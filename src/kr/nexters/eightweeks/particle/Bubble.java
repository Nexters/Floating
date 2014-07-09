package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Bubble extends Particle {
	
	public Bubble() {
		super(BitmapManager.getBubbleBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
