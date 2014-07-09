package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Sushi extends Particle {
	
	public Sushi() {
		super(BitmapManager.getSushiBitmap(), ParticleAnimationFactory.TYPE_LEFTSIDE_ANIMATION);
	}
}
