package kr.nexters.eightweeks.manager;

import kr.nexters.eightweeks.Common;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PrefManager {
	private static volatile PrefManager instance;
	private SharedPreferences mPref;
	
	public static final String PREF_KEY_SIZE_SETTING = "setting.particle.size";
	public static final String PREF_KEY_AMOUNT_SETTING = "setting.particle.amount";
	public static final String PREF_KEY_SPEED_SETTING = "setting.particle.speed";
	public static final String PREF_KEY_ALPHA_SETTING = "setting.particle.alpha";
	
	public static final String PREF_KEY_LAST_ON = "last.on";
	public static final String PREF_KEY_LAST_ON_TYPE = "last.type";
	
	public static final String PREK_KEY_LAST_VERSION_CODE = "last.version.code";
	
	private PrefManager() {
		mPref = Common.getMainContext().getSharedPreferences("team.8weeks", 0);
	}
	
	public static PrefManager getInstance() {
		if(instance == null) {
			synchronized (PrefManager.class) {
				if(instance == null) {
					instance = new PrefManager();
				}
			}
		}
		return instance;
	}
	
	public void putInt(String key, int value) {
		Editor edit = mPref.edit();
		edit.putInt(key, value);
		edit.commit();
	}
	
	public void putFloat(String key, float value) {
		Editor edit = mPref.edit();
		edit.putFloat(key, value);
		edit.commit();
	}
	
	public void putBoolean(String key, boolean value) {
		Editor edit = mPref.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}
	
	public int getInt(String key, int defValue) {
		return mPref.getInt(key, defValue); 
	}

	public float getFloat(String key, float defValue) {
		return mPref.getFloat(key, defValue);
	}
	
	public boolean getBoolean(String key, boolean defValue) {
		return mPref.getBoolean(key, defValue); 
	}
	
	public void clearPrefValue() {
		mPref.edit().clear().commit();
	}
}
