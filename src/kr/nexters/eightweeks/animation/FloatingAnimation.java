package kr.nexters.eightweeks.animation;

import java.util.Timer;
import java.util.TimerTask;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.SettingValue;

public class FloatingAnimation extends ParticleAnimation {
	private Way currentWay;
	private Way lastWay;
	
	private Timer changeWayTimer;
	private TimerTask changeWayTask;
	private float roundRotateVar = 0;
	private static final float ROUNDROTEVAR = 5;
	private static final float LIMIT_BOUNDARY = 10;
	
	private final long CHANGETIME_VAR = (long) (1000 / SettingValue.getSpeedValue());
	private boolean isTurnState = false;;
	private boolean isRotateMove = true;
	
	public FloatingAnimation(int width, int height) {
		this(width, height, true);
	}
	
	public FloatingAnimation(int width, int height, boolean isRotateMove) {
		super(width, height, Common.getScreenWidth() / 2, Common.getScreenHeight() / 2);
		
		double startWayVar = Math.random();
		
		if(startWayVar < 0.25) {
			currentWay = new RIGHT();
		} else if(startWayVar <0.5) {
			currentWay = new LEFT();
		} else if(startWayVar < 0.75) {
			currentWay = new UP();
		} else {
			currentWay = new DOWN();
		}
		
		lastWay = currentWay;
		
		initTimer();
		scale(120, 80);
		this.isRotateMove = isRotateMove;
	}
	
	private void initTimer() {
		changeWayTask = new TimerTask() {
			
			@Override
			public void run() {
				changeWay();
			}
		};
		changeWayTimer = new Timer();
		changeWayTimer.schedule(changeWayTask, getRandomLongVar(), getRandomLongVar());
	}
	
	private long getRandomLongVar() {
		return (long) (CHANGETIME_VAR * Math.random() + CHANGETIME_VAR);
	}

	@Override
	public void move() {
		moveTo(currentWay.getMoveX(), currentWay.getMoveY());
		if(roundRotateVar > 0 && isRotateMove) {
			roundRotateVar -= 0.1;
			float degree = (float) (90 / (ROUNDROTEVAR / 0.1));
			rotate(currentWay.isTurnLeft()?degree * -1 : degree);
			if(roundRotateVar <= 0) {
				isTurnState = false;
			}
		} 
	}

	@Override
	public void spectialEffect() {
		currentWay.specialEffect();
	}
	
	private void changeWay() {
		roundRotateVar = ROUNDROTEVAR;
		lastWay = currentWay;
		currentWay = currentWay.nextWay();
		if(isRotateMove) {
			isTurnState  = true;
		}
	}
	
	private void changeReverseWay() {
		lastWay = currentWay;
		currentWay = currentWay.reverseWay();
	}

	@Override
	public boolean isWillRemoved() {
		return false;
	}

	private interface Way {
		public float getMoveX();
		public float getMoveY();
		public Way nextWay();
		public Way reverseWay();
		public void specialEffect();
		public boolean isLeftWay();
		public boolean isRightWay();
		public boolean isUpWay();
		public boolean isDownWay();
		public boolean isTurnLeft();
	}

	class LEFT implements Way {

		@Override
		public float getMoveX() {
			if(isRotateMove) {
				if(lastWay.isDownWay()
						|| lastWay.isUpWay()) {
					return -5 + roundRotateVar;
				}
			}
			return -5;
		}

		@Override
		public float getMoveY() {
			if(isRotateMove) {
				if(lastWay.isDownWay()) {
					return roundRotateVar;
				} else if(lastWay.isUpWay()) {
					return -roundRotateVar;
				}
			}
			return 0;
		}

		@Override
		public Way nextWay() {
			return Math.random() > 0.5 ? new UP() : new DOWN();
		}

		@Override
		public void specialEffect() {
			if(getLeft() <= LIMIT_BOUNDARY) {
				changeReverseWay();
			}
			if(!isTurnState) {
				shakeVertical();
			}
		}

		@Override
		public boolean isLeftWay() {
			return true;
		}

		@Override
		public boolean isRightWay() {
			return false;
		}

		@Override
		public boolean isUpWay() {
			return false;
		}

		@Override
		public boolean isDownWay() {
			return false;
		}

		@Override
		public boolean isTurnLeft() {
			if(lastWay.isUpWay()) {
				return true;
			}
			return false;
		}

		@Override
		public Way reverseWay() {
			return new RIGHT();
		}
	}

	class RIGHT implements Way {

		@Override
		public float getMoveX() {
			if(isRotateMove) {
				if(lastWay.isDownWay()
						|| lastWay.isUpWay()) {
					return 5 - roundRotateVar;
				}
			}
			return 5;
		}

		@Override
		public float getMoveY() {
			if(isRotateMove) {
				if(lastWay.isDownWay()) {
					return roundRotateVar;
				} else if(lastWay.isUpWay()) {
					return -roundRotateVar;
				}
			}
			return 0;
		}

		@Override
		public Way nextWay() {
			return Math.random() > 0.5 ? new UP() : new DOWN();
		}

		@Override
		public void specialEffect() {
			if(getRight() >= Common.getScreenWidth() - LIMIT_BOUNDARY) {
				changeReverseWay();
			}
			if(!isTurnState) {
				shakeVertical();
			}
		}

		@Override
		public boolean isLeftWay() {
			return false;
		}

		@Override
		public boolean isRightWay() {
			return true;
		}

		@Override
		public boolean isUpWay() {
			return false;
		}

		@Override
		public boolean isDownWay() {
			return false;
		}

		@Override
		public boolean isTurnLeft() {
			if(lastWay.isDownWay()) {
				return true;
			}
			return false;
		}

		@Override
		public Way reverseWay() {
			return new LEFT();
		}
		
	}

	class UP implements Way {

		@Override
		public float getMoveX() {
			if(isRotateMove) {
				if(lastWay.isLeftWay()) {
					return -roundRotateVar;
				} else if(lastWay.isRightWay()) {
					return roundRotateVar;
				}
			}
			return 0;
		}

		@Override
		public float getMoveY() {
			if(isRotateMove) {
				if(lastWay.isLeftWay()
						|| lastWay.isRightWay()) {
					return -5 + roundRotateVar;
				}
			}
			return -5;
		}

		@Override
		public Way nextWay() {
			return Math.random() > 0.5 ? new LEFT() : new RIGHT();
		}

		@Override
		public void specialEffect() {
			if(getTop() < LIMIT_BOUNDARY) {
				changeReverseWay();
			}
			if(!isTurnState) {
				shakeHorizontal();
			}
		}

		@Override
		public boolean isLeftWay() {
			return false;
		}

		@Override
		public boolean isRightWay() {
			return false;
		}

		@Override
		public boolean isUpWay() {
			return true;
		}

		@Override
		public boolean isDownWay() {
			return false;
		}

		@Override
		public boolean isTurnLeft() {
			if(lastWay.isRightWay()) {
				return true;
			}
			return false;
		}

		@Override
		public Way reverseWay() {
			return new DOWN();
		}
		
	}

	class DOWN implements Way {

		@Override
		public float getMoveX() {
			if(isRotateMove) {
				if(lastWay.isLeftWay()) {
					return -roundRotateVar;
				} else if(lastWay.isRightWay()) {
					return roundRotateVar;
				}
			}
			return 0;
		}

		@Override
		public float getMoveY() {
			if(isRotateMove) {
				if(lastWay.isLeftWay()
						|| lastWay.isRightWay()) {
					return 5 - roundRotateVar;
				}
			}
			return 5;
		}

		@Override
		public Way nextWay() {
			return Math.random() > 0.5 ? new LEFT() : new RIGHT();
		}

		@Override
		public void specialEffect() {
			if(getBottom() >= Common.getScreenHeight() - LIMIT_BOUNDARY) {
				changeReverseWay();
			}
			if(!isTurnState) {
				shakeHorizontal();			
			}
		}

		@Override
		public boolean isLeftWay() {
			return false;
		}

		@Override
		public boolean isRightWay() {
			return false;
		}

		@Override
		public boolean isUpWay() {
			return false;
		}

		@Override
		public boolean isDownWay() {
			return true;
		}

		@Override
		public boolean isTurnLeft() {
			if(lastWay.isLeftWay()) {
				return true;
			}
			return false;
		}

		@Override
		public Way reverseWay() {
			return new UP();
		}
	}
}