package kr.nexters.eightweeks.thread;

import android.os.Handler;
import android.os.Message;

public class ThreadUI extends Handler {
    
    private static ThreadUI instance = null;
    
    private ThreadUI() {}
    
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Job job = (Job) msg.obj;
        job.process();
    }
    
    public synchronized static void queue(Job job) {
        if(instance == null) {
            instance = new ThreadUI();
        }
        Message msg = Message.obtain();
        msg.obj = job;
        instance.sendMessage(msg);
    }
}
