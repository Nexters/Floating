package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class LadyBug extends Particle {
	
	public LadyBug() {
		super(BitmapManager.getLadyBugBitmap(), ParticleAnimationFactory.TYPE_FLOATING_AND_FRAME_ANIMATION, true);
	}
}
