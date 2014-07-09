package kr.nexters.eightweeks.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.R;
import kr.nexters.eightweeks.TransactionListener;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.widget.EditText;
import android.widget.LinearLayout;

public class FileManager {

	public static final String FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/.FallSnow/";
	public static final String TEMP_FILE_PATH = FILE_PATH + "temp/temp.png";
	public static final String TEMP_CIRCLE_FILE_PATH = FILE_PATH + "temp/tempCircle.png";
	
	private static Uri mTempUri = null;
	private static HashMap<Integer, Bitmap> bitmapTable;
	private static HashMap<Integer, String> filePathTable;
	private static HashMap<Integer, Integer> animationTypeTable;
	private static HashMap<Integer, String> itemNameTable;
	
	private static final int MAX_SLOT_NUM = 100;
	
	private FileManager() {
	    
	}

	public static void initFileManager() {
		File tempFile = new File(TEMP_FILE_PATH);
		tempFile.mkdirs();
		mTempUri = Uri.fromFile(tempFile);
		
		File dir = new File(FILE_PATH);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		bitmapTable = new HashMap<Integer, Bitmap>();
		filePathTable = new HashMap<Integer, String>();
		animationTypeTable = new HashMap<Integer, Integer>();
		itemNameTable = new HashMap<Integer, String>();
		
		if(dir.listFiles() != null) {
		    for(File file : dir.listFiles()) {
		    	if(file.isFile()) {
		    		String[] splitFileName = file.getName().split("[_|.]");
		    		int slotId = Integer.parseInt(splitFileName[1]);
		    		String filePath = file.getAbsolutePath();
		    		Bitmap bitmap = BitmapFactory.decodeFile(filePath);
		    		
		    		animationTypeTable.put(slotId, Integer.parseInt(splitFileName[2]));
		    		filePathTable.put(slotId, filePath);
		    		bitmapTable.put(slotId, bitmap);
		    		if(splitFileName.length >= 5) {
		    			itemNameTable.put(slotId, splitFileName[3]);
		    		} else {
		    			itemNameTable.put(slotId, Common.getMainContext().getString(R.string.userItems));
		    		}
		    	}
		    }
		}
	}
	
	/**
	 * 파일 이름 규칙 : timeStamp_slotId_animationType_name.png
	 */
	public static void saveCustomAnimationItem(Context context, final Bitmap bitmap, final int type, final TransactionListener listener) {
		AlertDialog.Builder builder = new Builder(context);
		final EditText input = new EditText(context);  
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		input.setLayoutParams(lp);
		input.setHint(R.string.userItems);
		builder.setView(input);
		builder.setTitle(R.string.make_custom_item_dialog_title);
		builder.setPositiveButton(R.string.confirm, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				int slotId = getEnableSlotId();
				String itemName = input.getText().toString();
				if(itemName.trim().equals("")) {
					itemName = Common.getMainContext().getString(R.string.userItems);
				}
				String path = FILE_PATH + System.currentTimeMillis() + "_" + slotId + "_" + type + "_" + itemName + ".png";
				
				File dir = new File(FILE_PATH);
				
				if(!dir.exists()) {
		            dir.mkdirs();
		        }
				
		        saveBitmap(bitmap, path);		
		        
		        bitmapTable.put(slotId, bitmap);
		        filePathTable.put(slotId, path);
		        animationTypeTable.put(slotId, type);
		        itemNameTable.put(slotId, itemName);
		        dialog.dismiss();
		        if(listener != null) {
		        	listener.onActionDone(TransactionListener.RESULT_CODE_SUCCESS, null, null);
		        }
			}
		});
		builder.setNegativeButton(R.string.cancel, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				if(listener != null) {
		        	listener.onActionDone(TransactionListener.RESULT_CODE_FAIL, null, null);
		        }
			}
		});
		builder.show();
	}
	
	public static void saveBitmap(Bitmap bitmap, String path) {
		File file = new File(path);
		
		OutputStream out = null;
        
        try {
            file.createNewFile();
            out = new FileOutputStream(file);

            bitmap.compress(CompressFormat.PNG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static Bitmap getBitmapsBySlot(int slotId) {
		return bitmapTable.get(slotId);
	}
	
	public static int getAnimationTypeBySlot(int slotId) {
		return animationTypeTable.get(slotId);
	}
	
	public static String getItemNameBySlot(int slotId) {
		return itemNameTable.get(slotId);
	}
	
	public static List<Bitmap> getBitmapList() {
		List<Bitmap> result = new ArrayList<Bitmap>();
		Iterator<Bitmap> it = bitmapTable.values().iterator();
		
		while(it.hasNext()) {
			result.add(it.next());
		}
		
		return result;
	}
	
	public static void deleteBitmap(int slotId) {
		File file = new File(filePathTable.get(slotId));
		if(file.exists()) {
			file.delete();
		}
		
		bitmapTable.remove(slotId);
		filePathTable.remove(slotId);
		animationTypeTable.remove(slotId);
		itemNameTable.remove(slotId);
	}
	
	public static int getSavedBitmapNumber() {
		return bitmapTable.size();
	}
	
	public static List<Integer> getSlotIdList() {
		Set<Integer> set = filePathTable.keySet();
		List<Integer> result = new ArrayList<Integer>();
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			result.add(it.next());
		}
		
		return result;
	}
	
	private static int getEnableSlotId() {
	    Set<Integer> set = bitmapTable.keySet();
	    
        for (int i = 0; i < MAX_SLOT_NUM; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
	    
	    return -1;
	}
	
	public static Uri getTempUri() {
		File tempFile = new File(TEMP_FILE_PATH);
		if(tempFile.exists()) {
			tempFile.delete();
		}
		try {
			tempFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mTempUri;
	}
	
	public static String getFileNameBySlotId(int slotId) {
		String filePath = filePathTable.get(slotId); 
		String[] temp = filePath.split("[/]");
		return temp[temp.length - 1];
	}
	
	public static boolean isTableNull() {
		return bitmapTable == null ||
				filePathTable == null ||
				animationTypeTable == null ||
				itemNameTable == null;
	}
}
