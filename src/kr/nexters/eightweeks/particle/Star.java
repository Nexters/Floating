package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Star extends Particle {

	public Star() {
		super(BitmapManager.getStarBitmap(), ParticleAnimationFactory.TYPE_FRAME_ANIMATION, 1);
	}
}
