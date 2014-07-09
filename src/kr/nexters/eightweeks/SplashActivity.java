package kr.nexters.eightweeks;

import kr.nexters.eightweeks.thread.ThreadQueue;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class SplashActivity extends Activity {
	
	private int[] splashResId = {R.id.f01, R.id.f02, R.id.f03, R.id.f04, R.id.f05, R.id.f06, R.id.f07, R.id.f08,};
	private AnimationSet[] animationSet;
	private Animation[] animationUp;
	private Animation[] animationDown;
	
	private boolean isAnimationEnd = false;
	private boolean isFileLoadEnd = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		
		View[] views = new View[8];
		for(int i = 0; i<8; i++) {
			views[i] = findViewById(splashResId[i]);
		}
		initAnimation();
		
		for(int i = 0; i<8; i++) {
			views[i].startAnimation(animationSet[i]);
		}
		
		animationSet[7].setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {  }
			
			@Override
			public void onAnimationRepeat(Animation animation) { }
			
			@Override
			public void onAnimationEnd(Animation animation) {
				new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						isAnimationEnd = true;
						startMainActivity();
					}
				}, 200);
			}
		});
		
		ThreadQueue.initFileManager(new TransactionListener() {
    		@Override
    		public void onActionDone(int requestCode, Object resultCode, Object data) {
    			isFileLoadEnd = true;
    			startMainActivity();
    		}
    	});
	}
	
	private void startMainActivity() {
		if(isAnimationEnd && isFileLoadEnd) {
			Intent intent = new Intent(this, FSActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	private void initAnimation() {
		final long duration = 300;
		final long delay = 100;
		final float animationHeight = 30;
		
		animationUp = new Animation[8];
		animationDown = new Animation[8];
		animationSet = new AnimationSet[8];
		
		for(int i = 0; i<8; i++) {
			animationUp[i] = new TranslateAnimation(0, 0, 0, -animationHeight);
			animationUp[i].setDuration(duration);
			animationUp[i].setStartOffset(delay * (i+2));
		}
		
		for(int i = 0; i<8; i++) {
			animationDown[i] = new TranslateAnimation(0, 0, 0, animationHeight);
			animationDown[i].setDuration(animationUp[i].getDuration()); 
			animationDown[i].setStartOffset(animationUp[i].getDuration() + animationUp[i].getStartOffset());
		}
		
		for(int i = 0; i<8; i++) {
			animationSet[i] = new AnimationSet(false);
			animationSet[i].addAnimation(animationUp[i]);
			animationSet[i].addAnimation(animationDown[i]);
		}
	}
}
