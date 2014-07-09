package kr.nexters.eightweeks.broadcastreceiver;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.manager.PrefManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PhoneBootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		boolean lastOn = PrefManager.getInstance().getBoolean(PrefManager.PREF_KEY_LAST_ON, false);
		if(lastOn) {
			int type = PrefManager.getInstance().getInt(PrefManager.PREF_KEY_LAST_ON_TYPE, -1);
			Common.type = type;
			Common.startService();
		}
	}
}
