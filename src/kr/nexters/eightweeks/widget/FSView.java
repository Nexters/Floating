package kr.nexters.eightweeks.widget;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.manager.FSParticleDrawManager;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class FSView extends SurfaceView implements SurfaceHolder.Callback {

	public FSView(Context context) {
		super(context);
		initialize();
	}

	public FSView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	private void initialize() {
		getHolder().setFormat(PixelFormat.TRANSLUCENT);
		getHolder().addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {  }

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		FSParticleDrawManager manager = FSParticleDrawManager.getInstance();
		manager.setHolder(holder);
		Common.startPlay();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {  }
}
