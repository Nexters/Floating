package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Macharon extends Particle {
	
	public Macharon() {
		super(BitmapManager.getMacharonBitmap(), ParticleAnimationFactory.TYPE_BOTHSIDE_ANIMATION);
	}
}
