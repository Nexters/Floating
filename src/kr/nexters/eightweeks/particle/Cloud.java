package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Cloud extends Particle {
	
	public Cloud() {
		super(BitmapManager.getCloudBitmap(), ParticleAnimationFactory.TYPE_LEFTSIDE_ANIMATION, false);
	}
}
