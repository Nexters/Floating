package kr.nexters.eightweeks.manager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.particle.Particle;
import kr.nexters.eightweeks.particle.ParticleFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.SurfaceHolder;

public class FSParticleDrawManager {
    private static FSParticleDrawManager instance;
    private static String TIMER_NAME = "create.particle.timer";
    private Timer mTimer;
    private TimerTask mTimerTask;
    
	private SurfaceHolder mHolder;
	private List<Particle> mList;
	private List<Particle> mRemovedList;
	
	private static int count = 0;
	
	public static FSParticleDrawManager getInstance() {
	    if(instance == null) {
	        synchronized (FSParticleDrawManager.class) {
                if(instance == null) {
                    instance = new FSParticleDrawManager();
                }
            }
	    }
	    return instance;
	}
	
	private FSParticleDrawManager() {
		mList = new CopyOnWriteArrayList<Particle>();
		mRemovedList = new CopyOnWriteArrayList<Particle>();
	}
	
	public void setHolder(SurfaceHolder holder) {
		if(mHolder == null || mHolder != holder) {
			mHolder = holder;
		}
	}
	
	public void draw() {
	    if(mHolder == null || !Common.isPlay()) {
	        return;
	    }
		final Paint paint = new Paint(); 
		paint.setAntiAlias(true);
		new Thread(new Runnable() {
			
			@Override
			public synchronized void run() {
			    startCreateParticle();
			    while(Common.isPlay()) {
			        Canvas canvas = null;
			        if((canvas = mHolder.lockCanvas()) == null) {
			            continue;
			        }
			        canvas.drawColor(Color.TRANSPARENT, Mode.SRC_IN);
			        for(Particle particle : mList) {
			            paint.setAlpha(particle.getAlpha());
			            canvas.drawBitmap(particle.getBitmap(), particle.getMatrix(), paint);
			            particle.move();
			            particle.spectialEffect();
			            if(particle.isWillRemoved()) {
			                mRemovedList.add(particle);
			            }
			        }
			        try {
			        	mHolder.unlockCanvasAndPost(canvas);
			        } catch(IllegalArgumentException e) {
			        	e.printStackTrace();
			        }
			        removeParticle();
			    }
			}
		}).start();
	}
	
	public synchronized void clearParticle() {
		mRemovedList.addAll(mList);
	}
	
	private void startCreateParticle() {
	    if(mTimer != null) {
	        mTimer.cancel();
	        mTimer = null;
	    } 
	    mTimer = new Timer(TIMER_NAME);
	    mTimerTask = new TimerTask() {
			
			@Override
			public synchronized void run() {
				count++;
				if(count == 10) {
					System.gc();
					count = 0;
				}
				for(int i = 0; i<ParticleFactory.getCreateNumber(); i++) {
					if(mList.size() < ParticleFactory.getMax()) {
						Particle particle = ParticleFactory.createParticle();
						mList.add(particle);
					}
				}
				if(!Common.isPlay()) {
					cancel();
				}
			}
		};
	    mTimer.schedule(mTimerTask, 0, ParticleFactory.getPeriod());
	    
	}
	
	private synchronized void removeParticle() {
		for(Particle particle : mRemovedList) {
			mList.remove(particle);
			particle = null;
		}
		mRemovedList.clear();
	}
	
}
