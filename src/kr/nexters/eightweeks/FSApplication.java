package kr.nexters.eightweeks;

import kr.nexters.eightweeks.thread.ThreadQueue;
import android.app.Application;

public class FSApplication extends Application {
    
    private ThreadQueue threadQueue;
    
    @Override
    public void onCreate() {
        super.onCreate();
        Common.initialize(this);
        threadQueue = new ThreadQueue();
        threadQueue.start();
        
        VersionUpgrade.doUpgrade();
        SettingValue.initSettingValue();
    }
    
    @Override
    public void onTerminate() {
        super.onTerminate();
        
        if(threadQueue != null) {
            threadQueue.destroy();
            threadQueue = null;
        }
    }
    
}
