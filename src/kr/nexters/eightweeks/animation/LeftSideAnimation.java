package kr.nexters.eightweeks.animation;

import kr.nexters.eightweeks.Common;

public class LeftSideAnimation extends ParticleAnimation {
	
	private boolean isRotate;
	
	public LeftSideAnimation(int width, int height) {
		this(width, height, true);
	}
	
	public LeftSideAnimation(int width, int height, boolean _isRotate) {
		super(width, height, 0, Math.random() * Common.getScreenHeight());		
		scale(100, 50);
		isRotate = _isRotate;
	}
	
	@Override
	public void move() {
		moveTo((float)(Math.random() * 8.0 + 10), 0);
	}
	
	@Override
	public void spectialEffect() {
		if(isRotate) {
			rotate();
		}
		shakeVertical();
	}

	@Override
	public boolean isWillRemoved() {
		if (getLeft() > Common.getScreenWidth()) {
			return true;
		}
		return false;
	}

}
