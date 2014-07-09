package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Dandel extends Particle {
	
	public Dandel() {
		super(BitmapManager.getDandelBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
