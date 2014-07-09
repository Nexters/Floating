package kr.nexters.eightweeks.animation;

import kr.nexters.eightweeks.SettingValue;
import android.graphics.Matrix;

public abstract class ParticleAnimation implements Cloneable {
	protected int alpha = 255;
	private double x, y;
	private Matrix matrix = new Matrix();
	private float image_w, image_h;
	private float scaleRate = 1;
	protected float rotateVar = Math.random() > 0.5?(float)(Math.random() + 1):(float)(Math.random() - 2);
	
	private int shakeCount = 0;
	
	public abstract void move();
	public abstract void spectialEffect();
	public abstract boolean isWillRemoved();
	
	protected ParticleAnimation(double _x, double _y) {
		x = _x;
		y = _y;
		matrix.postTranslate((float) x, (float) y);
	}
	
	protected ParticleAnimation(int w, int h, double _x, double _y) {
		image_w = w;
		image_h = h;
		x = _x / scaleRate;
		y = _y / scaleRate;
		matrix.postTranslate((float) x, (float) y);
	}
	
	public Matrix getMatrix() {
		return matrix;
	}
	
	public int getAlpha() {
		alpha = SettingValue.getAlphaValue();
		return alpha;
	}
	
	protected void moveTo(float dx, float dy) {
	    dx *= SettingValue.getSpeedValue();
	    dy *= SettingValue.getSpeedValue();
	    
		x += dx;
		y += dy;
		
		matrix.postTranslate(dx * scaleRate, dy * scaleRate);
	}
	
	protected void shakeVertical() {
		if (shakeCount >=0 && shakeCount < 20) {
			moveTo(0, 2);
			shakeCount++;
		} else if(shakeCount == 20) {
			shakeCount = -20;
		} else if(shakeCount < 0) {
			moveTo(0, -2);
			shakeCount++;
		}
	}
	
	protected void shakeHorizontal() {
		if (shakeCount >=0 && shakeCount < 20) {
			moveTo(2, 0);
			shakeCount++;
		} else if(shakeCount == 20) {
			shakeCount = -20;
		} else if(shakeCount < 0) {
			moveTo(-2, 0);
			shakeCount++;
		}
	}
	
	protected double getLeft() {
		return x * scaleRate;
	}
	
	protected double getRight() {
		return (x + image_w) * scaleRate;
	}

	protected double getTop() {
		return y * scaleRate;
	}
	
	protected double getBottom() {
		return (y + image_h) * scaleRate;
	}

	protected void rotate() {
		rotate(rotateVar);
	}
	
	protected void rotate(float degree) {
		matrix.postRotate(degree, (float) ((image_w / 2 + x) * scaleRate),
				(float) ((image_h / 2 + y) * scaleRate));
	}

	protected void scale(int max, int min) {
		max *= SettingValue.getSizeValue();
		min *= SettingValue.getSizeValue();
		scaleRate = (float) (Math.random() * (max - min) + min) * 0.01f;
		matrix.postTranslate((float) -x, (float) -y);
		x /= scaleRate;
		y /= scaleRate;
		matrix.postTranslate((float) x, (float) y);
		matrix.postScale(scaleRate , scaleRate );
	}
}
