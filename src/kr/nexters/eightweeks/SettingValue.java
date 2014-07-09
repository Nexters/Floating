package kr.nexters.eightweeks;

import kr.nexters.eightweeks.manager.PrefManager;

public class SettingValue {

	private static float sizeSetting;
	private static float amountSetting;
	private static float speedSetting;
	private static int alphaSetting;

	private static final float adjSize 	= 0.03f;
	private static final float adjSpeed = 0.03f;
	
	public static void initSettingValue() {
		sizeSetting = PrefManager.getInstance().getFloat(PrefManager.PREF_KEY_SIZE_SETTING, 30);
		amountSetting = PrefManager.getInstance().getFloat(PrefManager.PREF_KEY_AMOUNT_SETTING, 7000);
		speedSetting = PrefManager.getInstance().getFloat(PrefManager.PREF_KEY_SPEED_SETTING, 30);
		alphaSetting = PrefManager.getInstance().getInt(PrefManager.PREF_KEY_ALPHA_SETTING, 200);
	}
	
	public static float getSpeedValue() {
		return speedSetting * adjSpeed;
	}
	
	public static float getAdjSpeed() {
		return adjSpeed;
	}
	
	public static float getSizeValue() {
		return sizeSetting * adjSize;
	}
	
	public static float getAdjSize() {
		return adjSize;
	}

	public static int getAlphaValue() {
		return alphaSetting;
	}

	public static float getAmountValue() {
		return amountSetting;
	}
	
	public static void setSpeedValue(float value) {
		speedSetting = value;
		PrefManager.getInstance().putFloat(PrefManager.PREF_KEY_SPEED_SETTING, speedSetting);
	}
	
	public static void setSizeValue(float value) {
		sizeSetting = value;
		PrefManager.getInstance().putFloat(PrefManager.PREF_KEY_SIZE_SETTING, sizeSetting);
	}
	
	public static void setAlphaValue(int value) {
		alphaSetting = value;
		PrefManager.getInstance().putInt(PrefManager.PREF_KEY_ALPHA_SETTING, alphaSetting);
	}

	public static void setAmountValue(float value) {
		amountSetting = value;
		PrefManager.getInstance().putFloat(PrefManager.PREF_KEY_AMOUNT_SETTING, amountSetting);
	}
}
