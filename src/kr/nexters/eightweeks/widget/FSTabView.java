package kr.nexters.eightweeks.widget;

import kr.nexters.eightweeks.DataContainer;
import kr.nexters.eightweeks.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class FSTabView extends RelativeLayout implements OnClickListener {
	
	private View mChooseEffect;
	private View mMakeEffect;
	
	private OnTabViewClickListener mListener;

	public FSTabView(Context context) {
		super(context);
		initialize();
	}

	public FSTabView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	public FSTabView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize();
	}
	
	private void initialize() {
		LayoutInflater inflater = LayoutInflater.from(getContext());
		inflater.inflate(R.layout.fs_tabview, this, true);
		
		mChooseEffect = findViewById(R.id.tabview_effect_choose);
		mMakeEffect = findViewById(R.id.tabview_effect_make);
		
		mChooseEffect.setSelected(true);
		
		mChooseEffect.setOnClickListener(this);
		mMakeEffect.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.tabview_effect_choose:
			onClickChooseEffectButton();
			break;
		case R.id.tabview_effect_make:
			onClickMakeEffectButton();
			break;
		}
	}

	public void onClickChooseEffectButton() {
		mChooseEffect.setSelected(true);
		mMakeEffect.setSelected(false);
		if(mListener != null) {
			mListener.onClickChooseEffectButton();
		}
	}
	
	public void onClickMakeEffectButton() {
		mChooseEffect.setSelected(false);
		mMakeEffect.setSelected(true);
		if(mListener != null) {
			mListener.onClickMakeEffectButton();
		}
	}
	
	public void setOnTabViewClickListener(OnTabViewClickListener l) {
		mListener = l;
	}
	
	public interface OnTabViewClickListener {
		public void onClickChooseEffectButton();
		public void onClickMakeEffectButton();
	}
	
}
