package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Snow extends Particle {
	
	public Snow() {
		super(BitmapManager.getSnowBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
