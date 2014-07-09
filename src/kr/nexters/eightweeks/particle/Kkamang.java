package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Kkamang extends Particle {
	
	public Kkamang() {
		super(BitmapManager.getKkamangBitmap(), ParticleAnimationFactory.TYPE_FLOATING_ANIMATION);
	}
}