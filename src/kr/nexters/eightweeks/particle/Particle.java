package kr.nexters.eightweeks.particle;

import java.util.List;

import kr.nexters.eightweeks.animation.FloatingAndFrameAnimation;
import kr.nexters.eightweeks.animation.FrameAnimation;
import kr.nexters.eightweeks.animation.ParticleAnimation;
import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import android.graphics.Bitmap;
import android.graphics.Matrix;

public abstract class Particle {
	private ParticleAnimation movingAnimation;
	private Bitmap bitmap;
	private List<Bitmap> bitmapList;
	
	public Particle(Bitmap _bitmap, int animationType) {
		this(_bitmap, animationType, true);
	}
	
	public Particle(Bitmap _bitmap, int animationType, boolean isRotate) {
		bitmap = _bitmap;
		movingAnimation = ParticleAnimationFactory.createParticleAnimation(animationType, bitmap, isRotate);
	}
	
	public Particle(List<Bitmap> _bitmapList, int animationType) {
		this(_bitmapList, animationType, 2);
	}
	
	public Particle(List<Bitmap> _bitmapList, int animationType, int repeatCnt) {
		this(_bitmapList, animationType, repeatCnt, true);
	}
	
	public Particle(List<Bitmap> _bitmapList, int animationType, boolean isRotate) {
		this(_bitmapList, animationType, 10, isRotate);
	}
	
	public Particle(List<Bitmap> _bitmapList, int animationType, int repeatCnt, boolean isRotate) {
		bitmapList = _bitmapList;
		movingAnimation = ParticleAnimationFactory.createParticleFrameAnimation(animationType, bitmapList, repeatCnt, isRotate);
	}
	
	public Bitmap getBitmap() {
		if(bitmap != null) {
			return bitmap;
		} else if(bitmapList != null && movingAnimation instanceof FrameAnimation) {
			return ((FrameAnimation) movingAnimation).getBitmap();
		} else if(bitmapList != null && movingAnimation instanceof FloatingAndFrameAnimation) {
			return ((FloatingAndFrameAnimation) movingAnimation).getBitmap();
		}
		return null;
	}
	
	public void move() {
		movingAnimation.move();
	}
	
	public void spectialEffect() {
		movingAnimation.spectialEffect();
	}
	
	public boolean isWillRemoved() {
		return movingAnimation.isWillRemoved();
	}
	
	public int getAlpha() {
		return movingAnimation.getAlpha();
	}
	
	public Matrix getMatrix() {
		return movingAnimation.getMatrix();		
	}
	
}
