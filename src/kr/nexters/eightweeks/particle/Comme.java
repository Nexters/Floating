package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Comme extends Particle {
	
	public Comme() {
		super(BitmapManager.getCommeBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
