package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Gao extends Particle {
	
	public Gao() {
		super(BitmapManager.getGaoBitmap(), ParticleAnimationFactory.TYPE_RIGHTSIDE_ANIMATION, false);
	}
}
