package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.BitmapManager;

public class Pacman extends Particle {
	public Pacman() {
		super(BitmapManager.getPacmankBitmap(), ParticleAnimationFactory.TYPE_FLOATING_ANIMATION, false); 
	}
}
