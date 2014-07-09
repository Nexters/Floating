package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Love extends Particle {
	
	public Love() {
		super(BitmapManager.getLoveBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}