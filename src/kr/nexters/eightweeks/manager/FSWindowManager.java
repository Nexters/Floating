package kr.nexters.eightweeks.manager;

import kr.nexters.eightweeks.Common;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

public class FSWindowManager {
	
	private static volatile FSWindowManager instance;
	private static Context mContext;
	private WindowManager windowManager;
	
	
	private FSWindowManager(Context context) {
		windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		mContext = context;
	}
	
	public static FSWindowManager getInstance() {
		if(instance == null) {
			synchronized (FSWindowManager.class) {
				if(instance == null) {
					instance = new FSWindowManager(Common.getMainContext());
				}
			}
		}
		return instance;
	}
	
	public View addView(View view, int x, int y) {
		WindowManager.LayoutParams params = createParams();
		params.x = x;
		params.y = y;
		windowManager.addView(view, params);
		
		return view;
	}

	private WindowManager.LayoutParams createParams() {
		WindowManager.LayoutParams params;
		params = new WindowManager.LayoutParams(
				WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.MATCH_PARENT,	
				WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
				WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
				PixelFormat.TRANSLUCENT);
		params.gravity = Gravity.TOP | Gravity.LEFT;
		
		return params;
	}
	
	public void removeView(View view) {
		windowManager.removeView(view);
	}
}
