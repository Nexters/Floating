package kr.nexters.eightweeks.adapter;

import android.graphics.drawable.Drawable;

public interface IGridViewItem extends Comparable<IGridViewItem> {
	public int getParticleType();
	public Drawable getDrawable();
	public String getTitle();
	public boolean isDefaultType();
	public boolean isCustomType();
}
