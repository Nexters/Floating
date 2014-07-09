package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Candy extends Particle {
	
	public Candy() {
		super(BitmapManager.getCandyBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
