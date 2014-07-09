package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class UFO extends Particle {
	
	public UFO() {
		super(BitmapManager.getUFOBitmap(), ParticleAnimationFactory.TYPE_LEFTSIDE_ANIMATION, false);
	}
}
