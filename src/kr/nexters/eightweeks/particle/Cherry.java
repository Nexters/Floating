package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Cherry extends Particle {
	
	public Cherry() {
		super(BitmapManager.getCherryBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}