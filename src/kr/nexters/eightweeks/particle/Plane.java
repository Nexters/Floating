package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Plane extends Particle {
	public Plane() {
		super(BitmapManager.getPlaneBitmap(), ParticleAnimationFactory.TYPE_LEFTSIDE_ANIMATION, false);
	}
}
