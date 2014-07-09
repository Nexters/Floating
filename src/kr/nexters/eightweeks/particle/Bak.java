package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Bak extends Particle {
	
	public Bak() {
		super(BitmapManager.getBakBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
