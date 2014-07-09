package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Duck extends Particle {
	
	public Duck() {
		super(BitmapManager.getDuckBitmap(), ParticleAnimationFactory.TYPE_FLOATING_AND_FRAME_ANIMATION, false);
	}
}
