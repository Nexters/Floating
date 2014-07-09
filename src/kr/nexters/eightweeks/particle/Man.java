package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Man extends Particle {
	
	public Man() {
		super(BitmapManager.getManBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
