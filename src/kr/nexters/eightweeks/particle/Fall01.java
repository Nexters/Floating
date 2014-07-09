package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Fall01 extends Particle {
	
	public Fall01() {
		super(BitmapManager.getFall01Bitmap(), ParticleAnimationFactory.TYPE_FALLING_ANIMATION);
	}
}
