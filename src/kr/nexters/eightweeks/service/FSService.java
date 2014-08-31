package kr.nexters.eightweeks.service;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.broadcastreceiver.FSBroadCastReceiver;
import kr.nexters.eightweeks.manager.FSNotifyManager;
import kr.nexters.eightweeks.manager.FSWindowManager;
import kr.nexters.eightweeks.widget.FSView;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class FSService extends Service {
	
	private static FSView view;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		startForeground(1, FSNotifyManager.getInstance().getNotification());
		view = new FSView(this);
		FSWindowManager.getInstance().addView(view, 0, 0);
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		filter.addAction(Intent.ACTION_SCREEN_ON);
		
		registerReceiver(new FSBroadCastReceiver(), filter);
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		FSWindowManager.getInstance().removeView(view);
	}
}
