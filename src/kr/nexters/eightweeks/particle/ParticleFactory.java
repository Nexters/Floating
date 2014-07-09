package kr.nexters.eightweeks.particle;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.SettingValue;

public class ParticleFactory {
	public static final int TYPE_CUSTOM_PARTICLE = 1000;
	public static final int TYPE_CUSTOM_TEST_PARTICLE = 1001;
	public static final int TYPE_STAR = 0;
	public static final int TYPE_SNOW = 1;
	public static final int TYPE_CLOUD = 2;
	public static final int TYPE_CHICKEN = 3;
	public static final int TYPE_CHERRY = 4;
	public static final int TYPE_CANDY = 5;
	public static final int TYPE_LOVE = 6;
	public static final int TYPE_KKAMANG = 7;
	public static final int TYPE_DANDEL =8;
	
	public static final int TYPE_BAK = 10;
	public static final int TYPE_PACMAN = 11;
	public static final int TYPE_LIP = 12;
	public static final int TYPE_YLEAF = 13;
	public static final int TYPE_PLANE = 14;
	public static final int TYPE_ROSE = 15;
	public static final int TYPE_FALL01 = 16;
	public static final int TYPE_LADYBUG = 17;
	public static final int TYPE_MAPLE = 18;
	public static final int TYPE_COMME = 19;
	public static final int TYPE_BUBBLE = 20;
	public static final int TYPE_GGOM = 21;
	public static final int TYPE_SUSHI = 22;
	public static final int TYPE_MACHARON = 23;
	public static final int TYPE_MAN = 24;
	public static final int TYPE_GAO = 25;
	public static final int TYPE_UFO = 26;
	public static final int TYPE_DUCK = 27;

	public static Particle createParticle() {
		switch(Common.type) {
		case TYPE_CUSTOM_PARTICLE: 
		case TYPE_CUSTOM_TEST_PARTICLE: 
			return new CustomParticle();
		case TYPE_STAR: return new Star();
		case TYPE_SNOW: return new Snow();
		case TYPE_CLOUD: return new Cloud();
		case TYPE_CHICKEN: return new Chicken();
		case TYPE_CHERRY: return new Cherry();
		case TYPE_CANDY: return new Candy();
		case TYPE_LOVE: return new Love();
		case TYPE_KKAMANG: return new Kkamang();
		case TYPE_DANDEL: return new Dandel();
		case TYPE_BAK: return new Bak();
		case TYPE_PACMAN: return new Pacman();
		case TYPE_LIP: return new Lip();
		case TYPE_YLEAF: return new Yleaf();
		case TYPE_PLANE: return new Plane();
		case TYPE_ROSE: return new Rose();
		case TYPE_FALL01: return new Fall01();
		case TYPE_LADYBUG: return new LadyBug();
		case TYPE_MAPLE: return new Maple();
		case TYPE_COMME: return new Comme();
		case TYPE_BUBBLE: return new Bubble();
		case TYPE_GGOM: return new GGom();
		case TYPE_SUSHI: return new Sushi();
		case TYPE_MACHARON: return new Macharon();
		case TYPE_MAN: return new Man();
		case TYPE_GAO: return new Gao();
		case TYPE_UFO: return new UFO();
		case TYPE_DUCK: return new Duck();
		}		
		return null;
	}
	
	public static int getCreateNumber() {
		switch(Common.type) {
		case TYPE_STAR:
			return 10;
		case TYPE_SNOW:
		case TYPE_CLOUD:
		case TYPE_CHICKEN:
		case TYPE_CHERRY:
		case TYPE_CANDY:
		case TYPE_LOVE:
		case TYPE_KKAMANG:
		case TYPE_DANDEL:
		case TYPE_BAK:
		case TYPE_PACMAN:
		case TYPE_LIP:
		case TYPE_YLEAF:
		case TYPE_PLANE:
		case TYPE_ROSE:
		case TYPE_FALL01:
		case TYPE_LADYBUG:
		case TYPE_MAPLE:
		case TYPE_COMME:
		case TYPE_BUBBLE:
		case TYPE_GGOM:
		case TYPE_SUSHI:
		case TYPE_MACHARON:
		case TYPE_MAN:
		case TYPE_GAO:
		case TYPE_UFO:
		case TYPE_DUCK:
			return 1;
		}
		return 1;
	}
	
	public static int getMax() {
		switch(Common.type) {
		case TYPE_STAR: 
		case TYPE_SNOW: 
		case TYPE_CLOUD:
		case TYPE_CHICKEN:
		case TYPE_CHERRY:
		case TYPE_CANDY:
		case TYPE_LOVE:
		case TYPE_DANDEL:
		case TYPE_BAK:
		case TYPE_LIP:
		case TYPE_YLEAF:
		case TYPE_PLANE:
		case TYPE_ROSE:
		case TYPE_FALL01:
		case TYPE_LADYBUG:
		case TYPE_MAPLE:
		case TYPE_COMME:
		case TYPE_BUBBLE:
		case TYPE_GGOM:
		case TYPE_SUSHI:
		case TYPE_MACHARON:
		case TYPE_MAN:
		case TYPE_GAO:
		case TYPE_UFO:
		case TYPE_DUCK:
			return 15;
		case TYPE_CUSTOM_PARTICLE:
		case TYPE_CUSTOM_TEST_PARTICLE:
			return 10;
		case TYPE_KKAMANG: 
		case TYPE_PACMAN:
			return 5;
		}
		return 1;
	}
	
	public static long getPeriod() {
		switch(Common.type) {
		case TYPE_STAR: 
			return 1000;
		case TYPE_CUSTOM_PARTICLE: 
		case TYPE_CUSTOM_TEST_PARTICLE: 	
		case TYPE_CHERRY: 
		case TYPE_CANDY: 
		case TYPE_LOVE: 
		case TYPE_KKAMANG: 
		case TYPE_DANDEL:
		case TYPE_SNOW:
		case TYPE_CLOUD:
		case TYPE_CHICKEN:
		case TYPE_BAK:
		case TYPE_PACMAN:
		case TYPE_LIP:
		case TYPE_YLEAF:
		case TYPE_PLANE:
		case TYPE_ROSE:
		case TYPE_FALL01:
		case TYPE_LADYBUG:
		case TYPE_MAPLE:
		case TYPE_COMME:
		case TYPE_BUBBLE:
		case TYPE_GGOM:
		case TYPE_SUSHI:
		case TYPE_MACHARON:
		case TYPE_MAN:
		case TYPE_GAO:
		case TYPE_UFO:
		case TYPE_DUCK:
			long time = (long) (5000000 /(SettingValue.getAmountValue() + 1));
			if(time > 2500) {
				time = 2500;
			}
			return time;
		}
		return 1000;
	}
}
