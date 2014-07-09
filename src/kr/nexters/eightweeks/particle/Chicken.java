package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Chicken extends Particle {
	
	public Chicken() {
		super(BitmapManager.getChickenBitmap(), ParticleAnimationFactory.TYPE_BOTHSIDE_ANIMATION);
	}
}