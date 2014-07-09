package kr.nexters.eightweeks.manager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.R;
import kr.nexters.eightweeks.broadcastreceiver.FSBroadCastReceiver;

public class FSNotifyManager {
	public static volatile FSNotifyManager instance;
	private static Context mContext;
	
	private FSNotifyManager() {
		mContext = Common.getMainContext();
	}
	
	public static FSNotifyManager getInstance() {
		if(instance == null) {
			synchronized (FSNotifyManager.class) {
				if(instance == null) {
					instance = new FSNotifyManager();
				}
			}
		}
		return instance;
	}
	
	public Notification getNotification() {
		NotificationCompat.Builder builder = new Builder(mContext);
		builder.setContentTitle(Common.getMainContext().getString(R.string.notify_title));
		builder.setContentText(Common.getMainContext().getString(R.string.notify_text));
		builder.setTicker(Common.getMainContext().getString(R.string.notify_ticker));
		builder.setSmallIcon(R.drawable.icon02_96);
		builder.setContentIntent(PendingIntent.getBroadcast(mContext, 1000, new Intent(mContext, FSBroadCastReceiver.class).setAction(FSBroadCastReceiver.ACTION_REQ_START_MAIN_ACT), PendingIntent.FLAG_UPDATE_CURRENT));
		builder.setPriority(NotificationCompat.PRIORITY_HIGH);
		builder.addAction(R.drawable.icon_off_96, Common.getMainContext().getString(R.string.off), PendingIntent.getBroadcast(mContext, 1001, new Intent(mContext, FSBroadCastReceiver.class).setAction(FSBroadCastReceiver.ACTION_REQ_NOTIFICATION), PendingIntent.FLAG_UPDATE_CURRENT));
		return builder.build();
	}
	
}
