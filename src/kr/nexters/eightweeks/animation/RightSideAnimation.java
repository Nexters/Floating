package kr.nexters.eightweeks.animation;

import kr.nexters.eightweeks.Common;

public class RightSideAnimation extends ParticleAnimation {
	
	private boolean isRotate;
	
	public RightSideAnimation(int width, int height) {
		this(width, height, true);
	}
	
	public RightSideAnimation(int width, int height, boolean _isRotate) {
		super(width, height, Common.getScreenWidth(), Math.random() * Common.getScreenHeight());
		scale(100, 50);
		isRotate = _isRotate;
	}
	
	@Override
	public void move() {
		moveTo((float)(Math.random() * 8.0 - 20), 0);
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
		if(getRight() < 0) {
			return true;
		}
		
		return false;
	}

}
