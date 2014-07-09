package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Rose extends Particle {
	
	public Rose() {
		super(BitmapManager.getRoseBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
