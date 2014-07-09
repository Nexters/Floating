package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Lip extends Particle {
	public Lip() {
		super(BitmapManager.getLipBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
