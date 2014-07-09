package kr.nexters.eightweeks;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import kr.nexters.eightweeks.adapter.GridViewCustomItem;
import kr.nexters.eightweeks.adapter.GridViewDefaultItem;
import kr.nexters.eightweeks.adapter.IGridViewItem;
import kr.nexters.eightweeks.manager.FileManager;
import kr.nexters.eightweeks.particle.ParticleFactory;
import android.graphics.Bitmap;

public class DataContainer {
	/* custom test particle & animation */
	public static Bitmap customBitmap;
	public static int customParticleAnimationType = -1;

	public static List<IGridViewItem> particleItemList = new LinkedList<IGridViewItem>();
	
	public static void refreshParticleItemList() {
		if(FileManager.isTableNull()) {
			FileManager.initFileManager();
		}
		particleItemList.clear();
		for(int slotId : FileManager.getSlotIdList()) {
			particleItemList.add(new GridViewCustomItem(slotId, FileManager.getAnimationTypeBySlot(slotId), FileManager.getBitmapsBySlot(slotId), FileManager.getItemNameBySlot(slotId)));
		}
		
		Collections.sort(particleItemList);
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_BAK, R.drawable.slot_bak, R.string.slot10));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_PACMAN, R.drawable.slot_pacman, R.string.slot11));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_LIP, R.drawable.slot_lip, R.string.slot12));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_YLEAF, R.drawable.slot_yleaf, R.string.slot13));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_PLANE, R.drawable.slot_plane, R.string.slot14));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_ROSE, R.drawable.slot_rose, R.string.slot15));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_FALL01, R.drawable.slot_fall01, R.string.slot16));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_LADYBUG, R.drawable.slot_ladybug, R.string.slot17));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_MAPLE, R.drawable.slot_maple, R.string.slot18));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_COMME, R.drawable.slot_comme, R.string.slot19));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_BUBBLE, R.drawable.slot_bubble, R.string.slot20));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_GGOM, R.drawable.slot_ggom, R.string.slot21));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_SUSHI, R.drawable.slot_sushi, R.string.slot22));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_MACHARON, R.drawable.slot_macharon, R.string.slot23));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_MAN, R.drawable.slot_man, R.string.slot24));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_GAO, R.drawable.slot_gao, R.string.slot25));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_UFO, R.drawable.slot_ufo, R.string.slot26));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_DUCK, R.drawable.slot_duck, R.string.slot27));
		
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_CHERRY, R.drawable.slot_cherry, R.string.slot1));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_SNOW, R.drawable.slot_frozen,  R.string.slot2));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_CLOUD, R.drawable.slot_cloud,  R.string.slot3));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_STAR, R.drawable.slot_star,  R.string.slot4));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_CANDY, R.drawable.slot_rolly,  R.string.slot5));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_LOVE, R.drawable.slot_heart,  R.string.slot6));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_KKAMANG, R.drawable.slot_kkamang,  R.string.slot7));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_DANDEL, R.drawable.slot_dandel, R.string.slot8));
		particleItemList.add(new GridViewDefaultItem(ParticleFactory.TYPE_CHICKEN, R.drawable.slot_chicken,  R.string.slot9));
	}
}
