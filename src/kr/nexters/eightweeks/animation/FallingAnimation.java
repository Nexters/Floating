package kr.nexters.eightweeks.animation;

import kr.nexters.eightweeks.Common;

public class FallingAnimation extends ParticleAnimation {
	
	private boolean isRotate;
	
	public FallingAnimation(int width, int height) {
		this(width, height, true);
	}
	
	public FallingAnimation(int width, int height, boolean _isRotate) {
		super(width, height, Math.random() * Common.getScreenWidth(), 0);
		scale(100, 30);
		isRotate = _isRotate;
	}
	
	@Override
	public void move() {
		moveTo(0, (float)(Math.random() * 8.0 + 10));
	}
	
	@Override
	public void spectialEffect() {
		if(isRotate) {
			rotate();
		}
		shakeHorizontal();
	}

	@Override
	public boolean isWillRemoved() {
		if (getTop() > Common.getScreenHeight() ) {
			return true;
		}
		return false;
	}

}
