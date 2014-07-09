package kr.nexters.eightweeks.broadcastreceiver;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.FSActivity;

public class FSBroadCastReceiver extends BroadcastReceiver {

    public static final String ACTION_REQ_NOTIFICATION = "notification.req.action";
    public static final String ACTION_REQ_START_MAIN_ACT = "start.mainactivity.req.action";
    
    public static final String ACTION_NOTIFICATION = "notification.action";
    
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(ACTION_REQ_NOTIFICATION)) {
            context.sendBroadcast(new Intent(ACTION_NOTIFICATION));
            onActionNotification(intent);
        } else if(action.equals(ACTION_REQ_START_MAIN_ACT)) {
            onActionStartMainActivity(context);
        }
    }
    
    private void onActionNotification(Intent intent) {
        Common.stopPlay();
        Common.stopService();
    }
    
    private void onActionStartMainActivity(Context context) {
        if(!isActivityOnTop(FSActivity.class.getName(), context)) {
            Intent mainIntent = new Intent(context, FSActivity.class);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mainIntent);
        }
    }
    
    private boolean isActivityOnTop(String activityName, Context context) {
        ActivityManager activityMgr = (ActivityManager) context.getSystemService(Activity.ACTIVITY_SERVICE);
        ComponentName c = activityMgr.getRunningTasks(1).get(0).topActivity; 
        String currentActivityName = c.getClassName();
        if(currentActivityName.equals(activityName)) {
            return true;
        }
        return false;
    }

}
