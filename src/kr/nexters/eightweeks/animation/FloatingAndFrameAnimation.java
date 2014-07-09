package kr.nexters.eightweeks.animation;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Bitmap;

public class FloatingAndFrameAnimation extends FloatingAnimation {

	private List<Bitmap> bitmapList;
	private static Timer timer = new Timer();
	private TimerTask task = new TimerTask() {
		
		@Override
		public void run() {
			i++;
		}
	};
	private int i = 0;
	private int CHANGE_DELAY_VAR;
	
	public FloatingAndFrameAnimation(int width, int height, List<Bitmap> _bitmapList) {
		this(width, height, _bitmapList, true);
	}
	
	public FloatingAndFrameAnimation(int width, int height, List<Bitmap> _bitmapList, boolean isRotateMove) {
		super(width, height, isRotateMove);
		
		bitmapList = _bitmapList;
		
		CHANGE_DELAY_VAR = (int) (Math.random() * 100) + 200;
		timer.schedule(task, CHANGE_DELAY_VAR, CHANGE_DELAY_VAR);
	}
	

	public Bitmap getBitmap() {
		return bitmapList.get(i % bitmapList.size());
	}

}
