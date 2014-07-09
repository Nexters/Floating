package kr.nexters.eightweeks.animation;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

public class ParticleAnimationFactory {
	public static final int TYPE_FALLING_ANIMATION = 1;
	public static final int TYPE_LEFTSIDE_ANIMATION = 2;
	public static final int TYPE_FLOATING_ANIMATION = 3;
	public static final int TYPE_FRAME_ANIMATION = 4;
	public static final int TYPE_BOTHSIDE_ANIMATION = 5;
	public static final int TYPE_FLOATING_AND_FRAME_ANIMATION = 6;
	public static final int TYPE_RIGHTSIDE_ANIMATION = 7;
	
	public static ParticleAnimation createParticleAnimation(int type, Bitmap bitmap) {
		return createParticleAnimation(type, bitmap, true);
	}
	
	public static ParticleAnimation createParticleAnimation(int type, Bitmap bitmap, boolean isRotate) {
		switch(type) {
		case TYPE_FALLING_ANIMATION:
			return new FallingAnimation(bitmap.getWidth(), bitmap.getHeight(), isRotate);
		case TYPE_LEFTSIDE_ANIMATION:
			return new LeftSideAnimation(bitmap.getWidth(), bitmap.getHeight(), isRotate);
		case TYPE_RIGHTSIDE_ANIMATION:
			return new RightSideAnimation(bitmap.getWidth(), bitmap.getHeight(), isRotate);
		case TYPE_FLOATING_ANIMATION:
			return new FloatingAnimation(bitmap.getWidth(), bitmap.getHeight(), isRotate);
		case TYPE_BOTHSIDE_ANIMATION:
			return Math.random() > 0.5?
					new LeftSideAnimation(bitmap.getWidth(), bitmap.getHeight(), isRotate):
					new RightSideAnimation(bitmap.getWidth(), bitmap.getHeight(), isRotate);
		}
		return new FallingAnimation(bitmap.getWidth(), bitmap.getHeight());
	}
	
	public static ParticleAnimation createParticleFrameAnimation(int type, List<Bitmap> bitmapList, int repeatCnt, boolean isRotate) {
		switch(type) {
		case TYPE_FRAME_ANIMATION:
			List<Bitmap> list = new ArrayList<Bitmap>();
			list.addAll(bitmapList);
			return new FrameAnimation(list, repeatCnt);
		case TYPE_FLOATING_AND_FRAME_ANIMATION:
			List<Bitmap> list2 = new ArrayList<Bitmap>();
			list2.addAll(bitmapList);
			return new FloatingAndFrameAnimation(bitmapList.get(0).getWidth(), bitmapList.get(0).getHeight(), bitmapList, isRotate);
		}
		return null;
	}
}
