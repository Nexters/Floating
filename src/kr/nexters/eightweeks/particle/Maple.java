package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Maple extends Particle {
	
	public Maple() {
		super(BitmapManager.getMapleBitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
