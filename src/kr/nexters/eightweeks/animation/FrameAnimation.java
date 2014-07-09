package kr.nexters.eightweeks.animation;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import kr.nexters.eightweeks.Common;
import android.graphics.Bitmap;

public class FrameAnimation extends ParticleAnimation {

	private List<Bitmap> bitmapList;
	private static Timer timer = new Timer();
	private TimerTask task = new TimerTask() {
		
		@Override
		public void run() {
			i++;
		}
	};
	private int repeat;
	private int i = 0;
	
	/**
	 * 존재하는 시간 (CHANGE_DELAY_VAR) * repeat = 생성되는 시간(Common.period) 가 비슷해야함
	 */
	private int CHANGE_DELAY_VAR;

	/**
	 * @param _bitmapList 비트맵 리스트
	 * @param _repeat 반복횟수
	 */
	public FrameAnimation(List<Bitmap> _bitmapList, int _repeat) {
		super(Common.getScreenWidth() * Math.random(), Common.getScreenHeight() * Math.random());
		bitmapList = _bitmapList;
		repeat = _repeat;
		scale(100, 50);
		
		CHANGE_DELAY_VAR = (int) (Math.random() * 100) + 50;
		timer.schedule(task, CHANGE_DELAY_VAR, CHANGE_DELAY_VAR);
	}
	
	@Override
	public void move() { }
	
	@Override
	public void spectialEffect() { }
	
	@Override
	public boolean isWillRemoved() {
		if(i >= bitmapList.size() * repeat) {
			return true;
		}
		return false;
	}
	
	public Bitmap getBitmap() {
		return bitmapList.get(i % bitmapList.size());
	}
}
