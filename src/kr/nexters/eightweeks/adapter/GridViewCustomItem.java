package kr.nexters.eightweeks.adapter;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.manager.FileManager;
import kr.nexters.eightweeks.particle.ParticleFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class GridViewCustomItem implements IGridViewItem {

	private Drawable drawable;
	private Bitmap bitmap;
	private String title;
	private int animationType;
	private int slotId;
	private String fileName;

	public GridViewCustomItem(int _slotId, int _animationType, Bitmap _bitmap, String _title) {
		slotId = _slotId;
		animationType = _animationType;
		bitmap = _bitmap;
		drawable = new BitmapDrawable(Common.getMainContext().getResources(), bitmap);
		title = _title;
		
		fileName = FileManager.getFileNameBySlotId(_slotId);
	}
	
	@Override
	public int getParticleType() {
		return ParticleFactory.TYPE_CUSTOM_PARTICLE;
	}

	@Override
	public Drawable getDrawable() {
		return drawable;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public boolean isDefaultType() {
		return false;
	}

	@Override
	public boolean isCustomType() {
		return true;
	}

	public int getAnimationType() {
		return animationType;
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}
	
	public int getSlotId() {
		return slotId;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof GridViewCustomItem) {
			return this.slotId == ((GridViewCustomItem) o).slotId;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(IGridViewItem another) {
		if(another.isDefaultType()) {
			return -1;
		} else {
			return ((GridViewCustomItem)another).fileName.compareTo(fileName);
		}
	}
}
