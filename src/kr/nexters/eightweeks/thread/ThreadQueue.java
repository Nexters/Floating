package kr.nexters.eightweeks.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import kr.nexters.eightweeks.DataContainer;
import kr.nexters.eightweeks.TransactionListener;

import kr.nexters.eightweeks.TransactionListener;
import kr.nexters.eightweeks.manager.FileManager;

public class ThreadQueue extends Thread {
    private static BlockingQueue<Job> queueJob;
    
    public ThreadQueue() {
        queueJob = new LinkedBlockingQueue<Job>();
    }
    
    @Override
    public void run() {
        super.run();
        while(true) {
            Job job;
            try {
                job = queueJob.take();
                job.process();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                job = null;
            }
        }
    }
    
    private static void queue(Job job) {
        if(queueJob == null) {
            queueJob = new LinkedBlockingQueue<Job>();
        }
        queueJob.add(job);
    }
    
    public void destroy() {
        if(queueJob != null) {
            queueJob.clear();
            queueJob = null;
        }
    }
    
    public static void initFileManager(TransactionListener listener) {
    	queue(new _initFileManger(listener));
    }
}

class _initFileManger implements Job {
	
	private TransactionListener mListener;
	
	public _initFileManger(TransactionListener listener) {
		mListener = listener;
	}
	
	@Override
	public void process() {
		FileManager.initFileManager();
		DataContainer.refreshParticleItemList();
		if(mListener != null) {
			mListener.onActionDone(TransactionListener.RESULT_CODE_SUCCESS, null, null);
		}
	}
	
}
