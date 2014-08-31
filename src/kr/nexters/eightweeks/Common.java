package kr.nexters.eightweeks;

import kr.nexters.eightweeks.manager.FSParticleDrawManager;
import kr.nexters.eightweeks.manager.PrefManager;
import kr.nexters.eightweeks.particle.ParticleFactory;
import kr.nexters.eightweeks.service.FSService;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;
import android.view.Window;

public class Common {
	private static Context sContext;
	public static int type = ParticleFactory.TYPE_SNOW;
	public static int period = 1000;
	private static boolean isPlay = false;
	private static boolean isServiceStart = false;
	
	public static void initialize(Context context) {
		sContext = context;
	}
	
	public static Context getMainContext() {
		return sContext;
	}
	
	public static int getScreenHeight() {
		return sContext.getResources().getDisplayMetrics().heightPixels;
	}
	
	public static int getScreenWidth() {
		return sContext.getResources().getDisplayMetrics().widthPixels;
	}
	
	public static int getStatusBarHeight(Activity activity) {
	    Rect rectgle= new Rect();
	    Window window= activity.getWindow();
	    window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
	    int StatusBarHeight = rectgle.top;
	    return StatusBarHeight;
	}
	
	public static void startPlay() {
		if(isPlay) {
			return;
		}
	    isPlay = true;
	    FSParticleDrawManager.getInstance().draw();
	}
	
	public static void stopPlay() {
		if(!isPlay) {
			return;
		}
	    isPlay = false;
	    FSParticleDrawManager.getInstance().clearParticle();
	}
	
	public static void pausePlay() {
		FSParticleDrawManager.getInstance().pause();
	}
	
	public static void resumePlay() {
		FSParticleDrawManager.getInstance().resume();
	}
	
	public static boolean isPlay() {
	    return isPlay;
	}
	
	public static void startService() {
        FSParticleDrawManager.getInstance().clearParticle();
		if(isServiceStart) {
			return;
		}
		isServiceStart = true;
		sContext.startService(new Intent(sContext, FSService.class));
		PrefManager.getInstance().putInt(PrefManager.PREF_KEY_LAST_ON_TYPE, Common.type);
		PrefManager.getInstance().putBoolean(PrefManager.PREF_KEY_LAST_ON, true);
	}
	
	public static void stopService() {
		if(!isServiceStart) {
			return;
		}
		isServiceStart = false;
		sContext.stopService(new Intent(sContext, FSService.class));
		PrefManager.getInstance().putBoolean(PrefManager.PREF_KEY_LAST_ON, false);
	}
}
