package kr.nexters.eightweeks.adapter;

import kr.nexters.eightweeks.Common;
import android.graphics.drawable.Drawable;

public class GridViewDefaultItem implements IGridViewItem {
	
	private int particleType;
	private Drawable drawable;
	private String title;
	
	public GridViewDefaultItem(int _type, int _imageRes, int titleResId) {
		particleType = _type;
		drawable = Common.getMainContext().getResources().getDrawable(_imageRes);
		title = Common.getMainContext().getString(titleResId);
	}

	@Override
	public int getParticleType() {
		return particleType;
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
		return true;
	}

	@Override
	public boolean isCustomType() {
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof GridViewDefaultItem) {
			return this.title == ((GridViewDefaultItem) o).title;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(IGridViewItem another) {
		// TODO Auto-generated method stub
		return 0;
	}
}
