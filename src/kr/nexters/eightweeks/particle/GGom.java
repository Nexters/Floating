package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class GGom extends Particle {
	
	public GGom() {
		super(BitmapManager.getGGomBitmap(), ParticleAnimationFactory.TYPE_FLOATING_AND_FRAME_ANIMATION, true);
	}
}
