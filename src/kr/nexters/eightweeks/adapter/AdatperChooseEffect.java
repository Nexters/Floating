package kr.nexters.eightweeks.adapter;

import java.util.ArrayList;
import java.util.List;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.DataContainer;
import kr.nexters.eightweeks.R;
import kr.nexters.eightweeks.manager.FileManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdatperChooseEffect extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<ViewHolder> mRef;
	private static int selectedItemIndex = -1;
	private static IGridViewItem selectedItem = null;
	private boolean isDeleteMode = false;
	private Context mContext;
    private OnClickSlotItemListener mListener;
	
	private static Animation mAnimation;
	
	public AdatperChooseEffect(Context context) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
		mRef = new ArrayList<AdatperChooseEffect.ViewHolder>();
		mAnimation = AnimationUtils.loadAnimation(context, R.anim.shake_infinite);
		if(!Common.isPlay()) {
		    selectedItemIndex = -1;
		}
	}
	
	@Override
	public int getCount() {
		return DataContainer.particleItemList.size();
	}

	@Override
	public IGridViewItem getItem(int position) {
		return DataContainer.particleItemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null) {
			convertView = mInflater.inflate(R.layout.item_effect, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
			mRef.add(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		bindView(holder, position);
		
		return convertView;
	}
	
	private void bindView(final ViewHolder holder, final int position) {
		
		holder.image.setImageDrawable(getItem(position).getDrawable());
		holder.text.setText(getItem(position).getTitle());
		holder.parent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				onClickItem(holder, position);
			}
		});
		if(selectedItemIndex == position) {
            setHolderImage(holder, true);
		} else {
            setHolderImage(holder, false);
		}
		if(isDeleteMode) {
			if(getItem(position).isCustomType()) {
				holder.imageOpt.setBackgroundResource(R.drawable.trash);
			} else {
				holder.imageOpt.setBackgroundResource(R.drawable.default_edit);
			}
			holder.startAnimation();
		} else {
			holder.imageOpt.setBackgroundResource(R.drawable.select_selector);
		}
	}
	
	private void onClickItem(ViewHolder holder, int position) {
	    final IGridViewItem item = getItem(position);
	    if(mListener != null) {
	        mListener.onClickSlotItem(item, position, isDeleteMode);
	    }
	    if(isDeleteMode) {
	    	if(item.isCustomType()) {
	    		if(position == selectedItemIndex) {
	    			Toast.makeText(mContext, R.string.cannot_delete_using_item, Toast.LENGTH_SHORT).show();
	    			return;
	    		}
	    		showDeleteDialog((GridViewCustomItem) item);
	    	} else {
	    		Toast.makeText(mContext, R.string.cannot_delete_default_item, Toast.LENGTH_SHORT).show();
	    	}
	    } else {
	        clearSelector();
	        if(position != selectedItemIndex) {
	        	if(item instanceof GridViewCustomItem) {
	        		DataContainer.customParticleAnimationType = ((GridViewCustomItem) item).getAnimationType();
	        		DataContainer.customBitmap = ((GridViewCustomItem) item).getBitmap();
	        	} else {
	        		DataContainer.customParticleAnimationType = -1;
	        	}
	        	Common.type = item.getParticleType();
	            Common.startService();
	            setHolderImage(holder, true);
	            selectedItemIndex = position;
	            selectedItem = item;
	        } else {
	            Common.stopPlay();
	            Common.stopService();
	            selectedItemIndex = -1;
	            selectedItem = null;
	        }
	    }
	}
	
	private void showDeleteDialog(final GridViewCustomItem item) {
		AlertDialog.Builder builder = new Builder(mContext);
		builder.setTitle(R.string.delete);
		builder.setMessage(R.string.delete_item);
		builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				FileManager.deleteBitmap(item.getSlotId());
				Toast.makeText(mContext, R.string.delete_complete, Toast.LENGTH_SHORT).show();
				DataContainer.refreshParticleItemList();
				notifyDataSetChanged();
				dialog.dismiss();
			}
		});
		
		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.show();
	}
	
	public void clearSelector() {
		for(ViewHolder holder : mRef) {
		    setHolderImage(holder, false);
		}
	}
	
	private void setHolderImage(ViewHolder holder, boolean isSelected) {
	    holder.clearAnimaiton();
	    if(isSelected) {
            holder.image.setSelected(true);
            holder.imageOpt.setSelected(true);
	    } else {
            holder.image.setSelected(false);
            holder.imageOpt.setSelected(false);
	    }
	}
	
	public void clearSelectedItemIndex() {
	    selectedItemIndex = -1;
	    selectedItem = null;
	}
	
	public boolean isDeleteMode() {
	    return isDeleteMode;
	}
	
	public void toggleDeleteMode() {
	    isDeleteMode = !isDeleteMode;
	    notifyDataSetChanged();
	}
	
	@Override
	public void notifyDataSetChanged() {
		selectedItemIndex = DataContainer.particleItemList.indexOf(selectedItem);
		super.notifyDataSetChanged();
	}
	
	public boolean onBackPressed() {
	    if(isDeleteMode) {
	        toggleDeleteMode();
	        return true;
	    }
	    return false;
	}
	
	private static class ViewHolder {
		private View parent;
		private ImageView image;
		private ImageView imageOpt;
		private TextView text;
		
		public ViewHolder(View _parent) {
			parent = _parent;
			image = (ImageView) _parent.findViewById(R.id.item_effect_image);
			imageOpt = (ImageView) _parent.findViewById(R.id.item_effect_image_option);
			text = (TextView) _parent.findViewById(R.id.item_effect_title);
		}
		
		private void startAnimation() {
		    image.startAnimation(mAnimation);
		}
		
		private void clearAnimaiton() {
            image.clearAnimation();
		}
	}
	
	public void setOnClickSlotItemListener(OnClickSlotItemListener l) {
	    mListener = l;
	}
	
	public interface OnClickSlotItemListener {
	    public void onClickSlotItem(IGridViewItem item, int position, boolean isDeleteMode);
	}
}
