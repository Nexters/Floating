
package kr.nexters.eightweeks.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import kr.nexters.eightweeks.R;

public class FSActionBar extends RelativeLayout implements OnClickListener {
    
    public static final int OVERFLOW_MENU_ITEM_HLEP     = 1;
    public static final int OVERFLOW_MENU_ITEM_SHARE    = 2;
    public static final int OVERFLOW_MENU_MAIL			= 3;
    
    private OnActionBarClickListener mListener;
    private View mOverflowButton;
    private View mSettingButton;
    private PopupWindow mOverflowMenu;
    private View mOverflowMenuLy;

    public FSActionBar(Context context) {
        super(context);
        initialize();
    }
    
    public FSActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }
    
    public FSActionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }
    
    private void initialize() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.fs_actionbar, this, true);
        
        mSettingButton = findViewById(R.id.actionbar_setting_button);
        mSettingButton.setOnClickListener(this);
        
        mOverflowButton = findViewById(R.id.actionbar_overflow_button);
        mOverflowButton.setOnClickListener(this);
    }
    
    private void initPopupWindow() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.overflow_item, null);
        mOverflowMenu = new PopupWindow(mOverflowButton);
        mOverflowMenu.setContentView(view);
        
        mOverflowMenu.setBackgroundDrawable(null);
        mOverflowMenu.setWidth(LayoutParams.MATCH_PARENT);
        mOverflowMenu.setHeight(LayoutParams.MATCH_PARENT);
        mOverflowMenu.setAnimationStyle(android.R.anim.fade_in);
        
        view.findViewById(R.id.overflow_help).setOnClickListener(this);
        view.findViewById(R.id.overflow_share).setOnClickListener(this);
        view.findViewById(R.id.overflow_mail).setOnClickListener(this);
        view.findViewById(R.id.emptyView).setOnClickListener(this);
        
        mOverflowMenuLy = view.findViewById(R.id.overflow_ly);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.actionbar_setting_button:
                toggleSettingButton();
                break;
            case R.id.actionbar_overflow_button:
            case R.id.emptyView:
                if(mOverflowMenu == null) {
                    initPopupWindow();
                }
                toggleOverflowMenu();
                break;
            case R.id.overflow_help:
                if(mListener != null) {
                    mListener.onClickOverflowItem(OVERFLOW_MENU_ITEM_HLEP);
                }
                toggleOverflowMenu();
                break;
            case R.id.overflow_share:
                if(mListener != null) {
                    mListener.onClickOverflowItem(OVERFLOW_MENU_ITEM_SHARE);
                }
                toggleOverflowMenu();
                break;
            case R.id.overflow_mail:
                if(mListener != null) {
                    mListener.onClickOverflowItem(OVERFLOW_MENU_MAIL);
                }
                toggleOverflowMenu();
                break;
        }
    }
    
    private void toggleOverflowMenu() {
        if(mOverflowMenu.isShowing()) {
            mOverflowMenu.dismiss();
            mOverflowButton.setSelected(false);
        } else {
            mOverflowMenu.showAsDropDown(this);
            mOverflowButton.setSelected(true);
            mOverflowMenuLy.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.overflow_menu_animation));
        }
    }
    
    private void toggleSettingButton() {
    	if(mOverflowMenu != null && mOverflowMenu.isShowing()) {
            mOverflowMenu.dismiss();
            mOverflowButton.setSelected(false);
        }
        if(mListener != null) {
            mListener.onClickSettingButton();
        }
        if(mSettingButton.isSelected()) {
        	mSettingButton.setSelected(false);
        } else {
        	mSettingButton.setSelected(true);
        }
    }
    
    public void setOnActionBarClickListener(OnActionBarClickListener l) {
        mListener = l;
    }

    public interface OnActionBarClickListener {
        public void onClickSettingButton();
        public void onClickOverflowItem(int position);
    }
    
    public boolean onBackPressed() {
        if(mOverflowMenu != null && mOverflowMenu.isShowing()) {
            mOverflowMenu.dismiss();
            return true;
        }
        return false;
    }

	public View getSettingButton() {
		return mSettingButton;
	}

}
