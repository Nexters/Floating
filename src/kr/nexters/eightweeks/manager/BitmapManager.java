package kr.nexters.eightweeks.manager;

import java.util.ArrayList;
import java.util.List;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.R;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class BitmapManager {
	private static List<Bitmap> STAR_BITMAP_TYPE1;
	private static List<Bitmap> STAR_BITMAP_TYPE2;
	private static int[] STAR_BITMAP_TYPE1_RESID = { R.drawable.item_star01,
		R.drawable.item_star02, R.drawable.item_star03,
		R.drawable.item_star04, R.drawable.item_star05,
		R.drawable.item_star06, R.drawable.item_star07,
		R.drawable.item_star08, R.drawable.item_star09,
		R.drawable.item_star10, R.drawable.item_star11,
		R.drawable.item_star12 };

	private static int[] STAR_BITMAP_TYPE2_RESID = { R.drawable.item_star01_2,
			R.drawable.item_star02_2, R.drawable.item_star03_2,
			R.drawable.item_star04_2, R.drawable.item_star05_2,
			R.drawable.item_star06_2, R.drawable.item_star07_2,
			R.drawable.item_star08_2, R.drawable.item_star09_2,
			R.drawable.item_star10_2, R.drawable.item_star11_2,
			R.drawable.item_star12_2 };
	
	private static Bitmap SNOW_BITMAP_TYPE1;
	private static Bitmap SNOW_BITMAP_TYPE2;
	
	private static Bitmap CLOUD_BITMAP_TYPE1;
	private static Bitmap CLOUD_BITMAP_TYPE2;
	private static Bitmap CLOUD_BITMAP_TYPE3;
	
	private static Bitmap CHICKEN_BITMAP_TYPE1;
	private static Bitmap CHICKEN_BITMAP_TYPE2;
	private static Bitmap CHICKEN_BITMAP_TYPE3;
	
	private static Bitmap CANDY_BITMAP_TYPE1;
	private static Bitmap CANDY_BITMAP_TYPE2;
	
	private static Bitmap LOVE_BITMAP;
	
	private static Bitmap CHERRY_BITMAP_TYPE1;
	private static Bitmap CHERRY_BITMAP_TYPE2;
	private static Bitmap CHERRY_BITMAP_TYPE3;
	
	private static Bitmap DANDEL_BITMAP;
	
	private static Bitmap KKANMANG_BITMAP;

	private static Bitmap BAK_BITMAP1;
	private static Bitmap BAK_BITMAP2;
	private static Bitmap BAK_BITMAP3;
	private static Bitmap BAK_BITMAP4;
	private static Bitmap BAK_BITMAP5;
	private static Bitmap BAK_BITMAP6;
	
	private static Bitmap PACMAN_BITMAP1;
	private static Bitmap PACMAN_BITMAP2;
	private static Bitmap PACMAN_BITMAP3;
	private static Bitmap PACMAN_BITMAP4;
	private static Bitmap PACMAN_BITMAP5;

	private static Bitmap LIP_BITMAP;

	private static Bitmap YLEAF_BITMAP1;
	private static Bitmap YLEAF_BITMAP2;

	private static Bitmap PLANE_BITMAP1;
	private static Bitmap PLANE_BITMAP2;
	
	private static Bitmap ROSE_BITMAP1;
	private static Bitmap ROSE_BITMAP2;
	private static Bitmap ROSE_BITMAP3;
	
	private static Bitmap FALL01_BITMAP1;
	private static Bitmap FALL01_BITMAP2;
	private static Bitmap FALL01_BITMAP3;
	private static Bitmap FALL01_BITMAP4;

	private static List<Bitmap> LADYBUT_BITMAP;
	
	private static int[] LADYBUG_BITMAP_RESID = { 
		R.drawable.item_ladybug01, R.drawable.item_ladybug02};
	
	private static Bitmap MAPLE_BITMAP1;
	private static Bitmap MAPLE_BITMAP2;

	private static Bitmap COMME_BITMAP1;
	private static Bitmap COMME_BITMAP2;
	
	private static Bitmap BUBBLE_BITMAP1;
	private static Bitmap BUBBLE_BITMAP2;

	private static List<Bitmap> GGOM_BITMAP;
	
	private static int[] GGOM_BITMAP_RESID = { 
		R.drawable.item_lavender01, R.drawable.item_lavender01, R.drawable.item_lavender03};
	
	private static Bitmap SUSHI_BITMAP1;	
	private static Bitmap SUSHI_BITMAP2;	
	private static Bitmap SUSHI_BITMAP3;	

	private static Bitmap MACHARON_BITMAP1;	
	private static Bitmap MACHARON_BITMAP2;
	private static Bitmap MACHARON_BITMAP3;
	private static Bitmap MACHARON_BITMAP4;

	private static Bitmap MAN_BITMAP1;
	private static Bitmap MAN_BITMAP2;

	private static Bitmap GAO_BITMAP;

	private static Bitmap UFO_BITMAP1;
	private static Bitmap UFO_BITMAP2;
	private static Bitmap UFO_BITMAP3;
	
	private static List<Bitmap> DUCK_BITMAP;
	
	private static int[] DUCK_BITMAP_RESID = { 
		R.drawable.item_duck1_1, R.drawable.item_duck02, R.drawable.item_duck03, R.drawable.item_duck04};
	
	public static List<Bitmap> getStarBitmap() {
		if(STAR_BITMAP_TYPE1 == null || STAR_BITMAP_TYPE2 == null) {
			STAR_BITMAP_TYPE1 = new ArrayList<Bitmap>();
			STAR_BITMAP_TYPE2 = new ArrayList<Bitmap>();
			
			for(int resId : STAR_BITMAP_TYPE1_RESID) {
				Bitmap bm = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(resId)).getBitmap();
				STAR_BITMAP_TYPE1.add(bm);
			}
			for(int resId : STAR_BITMAP_TYPE2_RESID) {
				Bitmap bm = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(resId)).getBitmap();
				STAR_BITMAP_TYPE2.add(bm);
			}
		}
		return Math.random() > 0.5 ? STAR_BITMAP_TYPE1:STAR_BITMAP_TYPE2;
	}
	
	public static Bitmap getSnowBitmap() {
		if(SNOW_BITMAP_TYPE1 == null ||
				SNOW_BITMAP_TYPE2 == null) {
			SNOW_BITMAP_TYPE1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_snow01)).getBitmap();
			SNOW_BITMAP_TYPE2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_snow02)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.55) {
			return SNOW_BITMAP_TYPE1;
		} else {
			return SNOW_BITMAP_TYPE2;
		} 
	}
	
	public static Bitmap getCloudBitmap() {
		if(CLOUD_BITMAP_TYPE1 == null ||
				CLOUD_BITMAP_TYPE2 == null ||
				CLOUD_BITMAP_TYPE3 == null) {
			CLOUD_BITMAP_TYPE1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_cloud01)).getBitmap();
			CLOUD_BITMAP_TYPE2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_cloud02)).getBitmap();
			CLOUD_BITMAP_TYPE3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_cloud03)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.33) {
			return CLOUD_BITMAP_TYPE1;
		} else if(seed < 0.67) {
			return CLOUD_BITMAP_TYPE2;
		} else {
			return CLOUD_BITMAP_TYPE3;
		}
	}
	
	public static Bitmap getChickenBitmap() {
		if(CHICKEN_BITMAP_TYPE1 == null ||
				CHICKEN_BITMAP_TYPE2 == null ||
						CHICKEN_BITMAP_TYPE3 == null) {
			CHICKEN_BITMAP_TYPE1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.chicken01)).getBitmap();
			CHICKEN_BITMAP_TYPE2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.chicken02)).getBitmap();
			CHICKEN_BITMAP_TYPE3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.chicken03)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.33) {
			return CHICKEN_BITMAP_TYPE1;
		} else if(seed < 0.67) {
			return CHICKEN_BITMAP_TYPE2;
		} else {
			return CHICKEN_BITMAP_TYPE3;
		}
	}
	
	public static Bitmap getCandyBitmap() {
		if(CANDY_BITMAP_TYPE1 == null ||
				CANDY_BITMAP_TYPE2 == null) {
			CANDY_BITMAP_TYPE1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_candy01)).getBitmap();
			CANDY_BITMAP_TYPE2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_candy02)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.55) {
			return CANDY_BITMAP_TYPE1;
		} else {
			return CANDY_BITMAP_TYPE2;
		} 
	}
	
	public static Bitmap getLoveBitmap() {
		if(LOVE_BITMAP == null) {
			LOVE_BITMAP = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_heart)).getBitmap();
		}
		return LOVE_BITMAP;
	}
	
	public static Bitmap getKkamangBitmap() {
		if(KKANMANG_BITMAP == null) {
			KKANMANG_BITMAP = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_kkamang)).getBitmap();
		}
		return KKANMANG_BITMAP;
	}
	
	public static Bitmap getDandelBitmap() {
		if(DANDEL_BITMAP == null) {
			DANDEL_BITMAP = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_dandel)).getBitmap();
		}
		return DANDEL_BITMAP;
	}
	
	public static Bitmap getCherryBitmap() {
		if(CHERRY_BITMAP_TYPE1 == null ||
				CHERRY_BITMAP_TYPE2 == null ||
				CHERRY_BITMAP_TYPE3 == null) {
			CHERRY_BITMAP_TYPE1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_cherry01)).getBitmap();
			CHERRY_BITMAP_TYPE2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_cherry02)).getBitmap();
			CHERRY_BITMAP_TYPE3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_cherry03)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.33) {
			return CHERRY_BITMAP_TYPE1;
		} else if(seed < 0.67) {
			return CHERRY_BITMAP_TYPE2;
		} else {
			return CHERRY_BITMAP_TYPE3;
		}
	}
	
	public static Bitmap getBakBitmap() {
		if(BAK_BITMAP1 == null ||
				BAK_BITMAP2 == null ||
				BAK_BITMAP3 == null ||
				BAK_BITMAP4 == null ||
				BAK_BITMAP5 == null ||
				BAK_BITMAP6 == null) {
			BAK_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_bak_01)).getBitmap();
			BAK_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_bak_02)).getBitmap();
			BAK_BITMAP3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_bak_03)).getBitmap();
			BAK_BITMAP4 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_bak_04)).getBitmap();
			BAK_BITMAP5 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_bak_05)).getBitmap();
			BAK_BITMAP6 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_bak_06)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.16) {
			return BAK_BITMAP1;
		} else if(seed < 0.33) {
			return BAK_BITMAP2;
		} else if(seed < 50){
			return BAK_BITMAP3;
		} else if(seed < 66) {
			return BAK_BITMAP4;
		} else if(seed < 83) {
			return BAK_BITMAP5;
		} else {
			return BAK_BITMAP6;
		}
	}
	
	public static Bitmap getPacmankBitmap() {
		if(PACMAN_BITMAP1 == null ||
				PACMAN_BITMAP2 == null ||
				PACMAN_BITMAP3 == null ||
				PACMAN_BITMAP4 == null ||
				PACMAN_BITMAP5 == null) {
			PACMAN_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_pacman01)).getBitmap();
			PACMAN_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_pacman02)).getBitmap();
			PACMAN_BITMAP3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_pacman03)).getBitmap();
			PACMAN_BITMAP4 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_pacman04)).getBitmap();
			PACMAN_BITMAP5 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_pacman05)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.2) {
			return PACMAN_BITMAP1;
		} else if(seed < 0.40) {
			return PACMAN_BITMAP2;
		} else if(seed < 6){
			return PACMAN_BITMAP3;
		} else if(seed < 8){
			return PACMAN_BITMAP4;
		} else {
			return PACMAN_BITMAP5;
		}
	}
	
	public static Bitmap getLipBitmap() {
		if(LIP_BITMAP == null) {
			LIP_BITMAP = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_lip)).getBitmap();
		}
		return LIP_BITMAP;
	}
	
	public static Bitmap getYleafBitmap() {
		if(YLEAF_BITMAP1 == null ||
				YLEAF_BITMAP2 == null) {
			YLEAF_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_yleaf01)).getBitmap();
			YLEAF_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_yleaf02)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.5) {
			return YLEAF_BITMAP1;
		} else {
			return YLEAF_BITMAP2;
		}
	}
	
	public static Bitmap getPlaneBitmap() {
		if(PLANE_BITMAP1 == null ||
				PLANE_BITMAP2 == null) {
			PLANE_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_plane01)).getBitmap();
			PLANE_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_plane02)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.5) {
			return PLANE_BITMAP1;
		} else {
			return PLANE_BITMAP2;
		}
	}
	
	public static Bitmap getRoseBitmap() {
		if(ROSE_BITMAP1 == null ||
				ROSE_BITMAP2 == null ||
				ROSE_BITMAP3 == null) {
			ROSE_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_rose01)).getBitmap();
			ROSE_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_rose02)).getBitmap();
			ROSE_BITMAP3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_rose03)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.33) {
			return ROSE_BITMAP1;
		} else if(seed < 0.66) {
			return ROSE_BITMAP2;
		} else {
			return ROSE_BITMAP3;
		}
	}
	
	public static Bitmap getFall01Bitmap() {
		if(FALL01_BITMAP1 == null ||
				FALL01_BITMAP2 == null ||
				FALL01_BITMAP3 == null ||
				FALL01_BITMAP4 == null) {
			FALL01_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_fall01)).getBitmap();
			FALL01_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_fall02)).getBitmap();
			FALL01_BITMAP3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_fall03)).getBitmap();
			FALL01_BITMAP4 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_fall04)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.25) {
			return FALL01_BITMAP1;
		} else if(seed < 0.50) {
			return FALL01_BITMAP2;
		} else if(seed < 0.75){
			return FALL01_BITMAP3;
		} else {
			return FALL01_BITMAP4;
		}
	}
	
	public static List<Bitmap> getLadyBugBitmap() {
		if(LADYBUT_BITMAP == null) {
			LADYBUT_BITMAP = new ArrayList<Bitmap>();
			for(int resId : LADYBUG_BITMAP_RESID) {
				Bitmap bm = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(resId)).getBitmap();
				LADYBUT_BITMAP.add(bm);
			}
		}
		return LADYBUT_BITMAP;
	}
	
	public static Bitmap getMapleBitmap() {
		if(MAPLE_BITMAP1 == null ||
				MAPLE_BITMAP2 == null) {
			MAPLE_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_maple01)).getBitmap();
			MAPLE_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_maple02)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.5) {
			return MAPLE_BITMAP1;
		} else {
			return MAPLE_BITMAP2;
		}
	}
	
	public static Bitmap getCommeBitmap() {
		if(COMME_BITMAP1 == null ||
				COMME_BITMAP2 == null) {
			COMME_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_comme01)).getBitmap();
			COMME_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_comme02)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.5) {
			return COMME_BITMAP1;
		} else {
			return COMME_BITMAP2;
		}
	}
	
	public static Bitmap getBubbleBitmap() {
		if(BUBBLE_BITMAP1 == null ||
				BUBBLE_BITMAP2 == null) {
			BUBBLE_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_bubble01)).getBitmap();
			BUBBLE_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_bubble02)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.5) {
			return BUBBLE_BITMAP1;
		} else {
			return BUBBLE_BITMAP2;
		}
	}
	
	public static List<Bitmap> getGGomBitmap() {
		if(GGOM_BITMAP == null) {
			GGOM_BITMAP = new ArrayList<Bitmap>();
			for(int resId : GGOM_BITMAP_RESID) {
				Bitmap bm = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(resId)).getBitmap();
				GGOM_BITMAP.add(bm);
			}
		}
		return GGOM_BITMAP;
	}
	
	public static Bitmap getSushiBitmap() {
		if(SUSHI_BITMAP1 == null ||
				SUSHI_BITMAP2 == null ||
				SUSHI_BITMAP3 == null) {
			SUSHI_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_sushi01)).getBitmap();
			SUSHI_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_sushi02)).getBitmap();
			SUSHI_BITMAP3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_sushi03)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.33) {
			return SUSHI_BITMAP1;
		} else if(seed < 0.66) {
			return SUSHI_BITMAP2;
		} else {
			return SUSHI_BITMAP3;
		}
	}
	
	public static Bitmap getMacharonBitmap() {
		if(MACHARON_BITMAP1 == null ||
				MACHARON_BITMAP2 == null ||
				MACHARON_BITMAP3 == null ||
				MACHARON_BITMAP4 == null) {
			MACHARON_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_macaron01)).getBitmap();
			MACHARON_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_macaron02)).getBitmap();
			MACHARON_BITMAP3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_macaron03)).getBitmap();
			MACHARON_BITMAP4 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_macaron04)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.25) {
			return MACHARON_BITMAP1;
		} else if(seed < 0.50) {
			return MACHARON_BITMAP2;
		} else if(seed < 0.75){
			return MACHARON_BITMAP3;
		} else {
			return MACHARON_BITMAP4;
		}
	}
	
	public static Bitmap getManBitmap() {
		if(MAN_BITMAP1 == null ||
				MAN_BITMAP2 == null) {
			MAN_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_man)).getBitmap();
			MAN_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_man02)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.5) {
			return MAN_BITMAP1;
		} else {
			return MAN_BITMAP2;
		}
	}

	public static Bitmap getGaoBitmap() {
		if(GAO_BITMAP == null) {
			GAO_BITMAP = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_gao01)).getBitmap();
		}
		return GAO_BITMAP;
	}
	
	public static Bitmap getUFOBitmap() {
		if(UFO_BITMAP1 == null ||
				UFO_BITMAP2 == null ||
				UFO_BITMAP3 == null) {
			UFO_BITMAP1 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_ufo01)).getBitmap();
			UFO_BITMAP2 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_ufo02)).getBitmap();
			UFO_BITMAP3 = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(R.drawable.item_ufo03)).getBitmap();
		}
		double seed = Math.random();
		if(seed < 0.33) {
			return UFO_BITMAP1;
		} else if(seed < 0.66) {
			return UFO_BITMAP2;
		} else {
			return UFO_BITMAP3;
		}
	}
	
	public static List<Bitmap> getDuckBitmap() {
		if(DUCK_BITMAP == null) {
			DUCK_BITMAP = new ArrayList<Bitmap>();
			for(int resId : DUCK_BITMAP_RESID) {
				Bitmap bm = ((BitmapDrawable) Common.getMainContext().getResources().getDrawable(resId)).getBitmap();
				DUCK_BITMAP.add(bm);
			}
		}
		return DUCK_BITMAP;
	}
}
