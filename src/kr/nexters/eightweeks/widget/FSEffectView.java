package kr.nexters.eightweeks.widget;

import kr.nexters.eightweeks.Common;
import kr.nexters.eightweeks.DataContainer;
import kr.nexters.eightweeks.R;
import kr.nexters.eightweeks.TransactionListener;
import kr.nexters.eightweeks.animation.ParticleAnimationFactory;
import kr.nexters.eightweeks.manager.FileManager;
import kr.nexters.eightweeks.particle.ParticleFactory;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FSEffectView extends RelativeLayout implements OnClickListener{
	private ImageView mImageView;
	private ImageView mPlusButton;
	
	private View mEffect01;
	private View mEffect02;
	private View mEffect03;
	
	private View mSaveButton;
	
	private LayoutInflater mInflater;
	private OnClickSaveButtonListener mListener;
	
	private Bitmap mBitmap = null;
	
	public static final int PICK_FROM_CAMERA = 0;
	public static final int PICK_FROM_ALBUM = 1;
	public static final int CROP_FROM_CAMERA = 2;

	public FSEffectView(Context context) {
		super(context);
		initialize();
	}
	
	public FSEffectView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}
	
	private void initialize() {
		mInflater = LayoutInflater.from(getContext());
		mInflater.inflate(R.layout.fs_effectview, this, true);
		
		initView();
	}
	
	private void initView() {
		mImageView = (ImageView) findViewById(R.id.picturechoose);
		mPlusButton = (ImageView) findViewById(R.id.picture_plus_button);
		mEffect01 = findViewById(R.id.ly_effect01);
		mEffect02 = findViewById(R.id.ly_effect02);
		mEffect03 = findViewById(R.id.ly_effect03);
		mSaveButton = findViewById(R.id.savebutton);
		
		mImageView.setOnClickListener(this);
		mEffect01.setOnClickListener(this);
		mEffect02.setOnClickListener(this);
		mEffect03.setOnClickListener(this);
		mSaveButton.setOnClickListener(this);
	}
	
	private void onClickPlusEffect() {
		DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				doTakePhotoAction();
			}
		};

		DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				doTakeAlbumAction();
			}
		};

		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				if(mBitmap != null) {
					mBitmap = null;
					mPlusButton.setVisibility(View.VISIBLE);
					mImageView.setImageBitmap(null);
				}
				dialog.dismiss();
			}
		};

		Builder builder = new AlertDialog.Builder(this.getContext());
		builder.setTitle(R.string.select_image);
		builder.setPositiveButton(R.string.capture_photo, cameraListener);
		builder.setNeutralButton(R.string.pic_photo, albumListener);
		
		if(mBitmap == null) {
			builder.setNegativeButton(R.string.cancel, cancelListener);
		} else {
			builder.setNegativeButton(R.string.delete, cancelListener);
		}
		
		builder.show();
	}
	
	private void doTakePhotoAction(){
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);		
		((Activity) getContext()).startActivityForResult(intent, PICK_FROM_CAMERA);
	}

	private void doTakeAlbumAction(){
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
		((Activity) getContext()).startActivityForResult(intent, PICK_FROM_ALBUM);
	}
	
	public void setImageView(Bitmap bm) {
		mBitmap = bm;
		mImageView.setImageBitmap(bm);
		mPlusButton.setVisibility(View.INVISIBLE);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.picturechoose:
			onClickPlusEffect();
			break;
		case R.id.ly_effect01:
			boolean isSucc = setCustomTest(ParticleAnimationFactory.TYPE_FALLING_ANIMATION, 0);
			if(isSucc) {
				setEffectViewSelected(0);
			}
			break;
		case R.id.ly_effect02:
			boolean isSucc2 = setCustomTest(ParticleAnimationFactory.TYPE_LEFTSIDE_ANIMATION, 1);
			if(isSucc2) {
				setEffectViewSelected(1);
			}
			break;
		case R.id.ly_effect03:
//			boolean isSucc3 = setCustomTest(ParticleAnimationFactory.TYPE_FLOATING_ANIMATION, 2);
//			if(isSucc3) {
//				setEffectViewSelected(1);
//			}
			Toast.makeText(getContext(), R.string.prepared_effect, Toast.LENGTH_SHORT).show();
			break;
		case R.id.savebutton:
			onClickSaveButton();
			break;
		}
	}
	
	private void setEffectViewSelected(int effectIndex) {
		switch(effectIndex) {
		case 0:
			mEffect01.setSelected(true);
			mEffect02.setSelected(false);
			break;
		case 1:
			mEffect01.setSelected(false);
			mEffect02.setSelected(true);
			break;
		}
	}
	
	private void onClickSaveButton() {
		if(mBitmap == null) {
			Toast.makeText(getContext(), R.string.need_image, Toast.LENGTH_SHORT).show();
			return;
		}
		if(DataContainer.customParticleAnimationType == -1) {
			Toast.makeText(getContext(), R.string.need_animation, Toast.LENGTH_SHORT).show();
			return;
		}
		FileManager.saveCustomAnimationItem(getContext(), mBitmap, DataContainer.customParticleAnimationType, new TransactionListener() {
			
			@Override
			public void onActionDone(int resultCode, Object param, Object tag) {
				if(resultCode == TransactionListener.RESULT_CODE_SUCCESS) {
					Toast.makeText(getContext(), R.string.saved, Toast.LENGTH_SHORT).show();
					
					Common.stopPlay();
					Common.stopService();
					DataContainer.refreshParticleItemList();
					clearSelected();
					
					if(mBitmap != null) {
						mBitmap = null;
						mPlusButton.setVisibility(View.VISIBLE);
						mImageView.setImageBitmap(null);
					}
					if(mListener != null) {
						mListener.onClickSaveButton();
					}
				}
			}
		});
	}

	private boolean setCustomTest(int type, int effectIndex) {
		if(mBitmap == null) {
			Toast.makeText(getContext(), R.string.need_image, Toast.LENGTH_SHORT).show();
			return false;
		}
		if(Common.isPlay() && Common.type != ParticleFactory.TYPE_CUSTOM_TEST_PARTICLE) {
			Toast.makeText(getContext(), R.string.off_current_item, Toast.LENGTH_SHORT).show();
			return false;
		}
		
		boolean isAlreadyCheck = false;
		switch(effectIndex) {
		case 0:
			if(mEffect01.isSelected()) {
				isAlreadyCheck = true;
			}
			break;
		case 1:
			if(mEffect02.isSelected()) {
				isAlreadyCheck = true;
			}
			break;
		case 2:
			if(mEffect03.isSelected()) {
				isAlreadyCheck = true;
			}
			break;
		}
		if(!isAlreadyCheck) {
			DataContainer.customBitmap = mBitmap;
			DataContainer.customParticleAnimationType = type;
			Common.type = ParticleFactory.TYPE_CUSTOM_TEST_PARTICLE;
			Common.startService();
		} else {
		    clearSelected();
			Common.stopPlay();
	        Common.stopService();
	        return false;
		}
		return true;
	}
	
	public void clearSelected() {
        mEffect01.setSelected(false);
        mEffect02.setSelected(false);
        DataContainer.customParticleAnimationType = -1;
	}
	
	public void setOnClickSaveButtonListener(OnClickSaveButtonListener l) {
		mListener = l;
	}
	
	public interface OnClickSaveButtonListener {
		public void onClickSaveButton();
	}
}
