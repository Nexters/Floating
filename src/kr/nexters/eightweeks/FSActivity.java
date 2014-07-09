
package kr.nexters.eightweeks;

import java.util.LinkedList;

import kr.nexters.eightweeks.adapter.AdatperChooseEffect;
import kr.nexters.eightweeks.adapter.AdatperChooseEffect.OnClickSlotItemListener;
import kr.nexters.eightweeks.adapter.IGridViewItem;
import kr.nexters.eightweeks.broadcastreceiver.FSBroadCastReceiver;
import kr.nexters.eightweeks.manager.FileManager;
import kr.nexters.eightweeks.particle.ParticleFactory;
import kr.nexters.eightweeks.utils.GraphicsUtils;
import kr.nexters.eightweeks.widget.FSActionBar;
import kr.nexters.eightweeks.widget.FSEffectView;
import kr.nexters.eightweeks.widget.FSSettingDialog;
import kr.nexters.eightweeks.widget.FSTabView;
import kr.nexters.eightweeks.widget.FSActionBar.OnActionBarClickListener;
import kr.nexters.eightweeks.widget.FSEffectView.OnClickSaveButtonListener;
import kr.nexters.eightweeks.widget.FSTabView.OnTabViewClickListener;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.GridView;

public class FSActivity extends Activity implements OnActionBarClickListener, OnTabViewClickListener, OnClickListener, OnClickSaveButtonListener, OnClickSlotItemListener  {

	private FSActionBar mActionBar;
	private FSTabView mTabView;
	private GridView mGridView;
	private View mDelectView;
	private FSEffectView mEffectView;
	private AdatperChooseEffect mAdapter;
	LayoutInflater inflater; 

	private BroadcastReceiver mReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			if(mAdapter != null) {
				mAdapter.clearSelector();
				mAdapter.clearSelectedItemIndex();
				mAdapter.notifyDataSetChanged();
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		initialize();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		if(DataContainer.particleItemList == null) {
			DataContainer.particleItemList = new LinkedList<IGridViewItem>();
		}
		if(DataContainer.particleItemList.size() == 0) {
			DataContainer.refreshParticleItemList();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(mReceiver != null) {
			unregisterReceiver(mReceiver);
		}
		if(Common.type == ParticleFactory.TYPE_CUSTOM_TEST_PARTICLE) {
            Common.stopPlay();
            Common.stopService();
			mAdapter.clearSelector();
			mAdapter.clearSelectedItemIndex();
			DataContainer.customParticleAnimationType = -1;
		}
	}

	private void initialize() {
		initView();
		initControls();
	}

	private void initView() {
		mActionBar = (FSActionBar) findViewById(R.id.actionbar);
		mTabView = (FSTabView) findViewById(R.id.tabView);
		mGridView = (GridView) findViewById(R.id.gridView);
		mEffectView = (FSEffectView) findViewById(R.id.effectView); 
		mDelectView = findViewById(R.id.effect_deleteButton);

		mAdapter = new AdatperChooseEffect(this);
	}

	private void initControls() {
		mActionBar.setOnActionBarClickListener(this);
		mTabView.setOnTabViewClickListener(this);
		mDelectView.setOnClickListener(this);
		mEffectView.setOnClickSaveButtonListener(this);
		
		mGridView.setAdapter(mAdapter);
		mAdapter.setOnClickSlotItemListener(this);

		IntentFilter intentFilter = new IntentFilter(FSBroadCastReceiver.ACTION_NOTIFICATION);
		registerReceiver(mReceiver, intentFilter);
	}

	@Override
	public void onClickSettingButton() {
		FSSettingDialog dialog = new FSSettingDialog(this);
		dialog.setSettingButton(mActionBar.getSettingButton());
		dialog.show();
	}

	@Override
	public void onClickOverflowItem(int position) {
		switch(position) {
		case FSActionBar.OVERFLOW_MENU_ITEM_HLEP:
			Intent i = new Intent(this, HelpAcitivity.class);
			startActivity(i);
			
			break;
		case FSActionBar.OVERFLOW_MENU_ITEM_SHARE:
			Intent shareingIntent = new Intent(android.content.Intent.ACTION_SEND);
			shareingIntent.setType("text/plan");
			shareingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Floating");
			shareingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=kr.nexters.eightweeks");
			startActivity(Intent.createChooser(shareingIntent,getResources().getString(R.string.app_name)));
			
			break;
		case FSActionBar.OVERFLOW_MENU_MAIL:
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("message/rfc822");
			intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"teamnexters@gmail.com"});
			intent.putExtra(Intent.EXTRA_SUBJECT, "제목");
			intent.putExtra(Intent.EXTRA_TEXT   , "내용");
			startActivity(Intent.createChooser(intent, "메일 보내기"));
			
			break;
		}
	}

	@Override
	public void onBackPressed() {
		if(mActionBar.onBackPressed() ||
				mAdapter.onBackPressed()) {
			return;
		}
		super.onBackPressed();
	}

	@Override
	public void onClickChooseEffectButton() {
		mGridView.setVisibility(View.VISIBLE);
		mEffectView.setVisibility(View.GONE);
		mDelectView.setVisibility(View.VISIBLE);
	}

	@Override
	public void onClickMakeEffectButton() {
		mGridView.setVisibility(View.GONE);
		mEffectView.setVisibility(View.VISIBLE);
		mDelectView.setVisibility(View.GONE);
		if(mAdapter.isDeleteMode()) {
			mAdapter.toggleDeleteMode();
		}
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.effect_deleteButton:
			mAdapter.toggleDeleteMode();
			mDelectView.setSelected(!mDelectView.isSelected());
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode != Activity.RESULT_OK) {
			return;
		}
		switch(requestCode) {
		case FSEffectView.CROP_FROM_CAMERA:
			Bitmap bitmap = GraphicsUtils.getCroppedBitmap(BitmapFactory.decodeFile(FileManager.TEMP_FILE_PATH));
			FileManager.saveBitmap(bitmap, FileManager.TEMP_CIRCLE_FILE_PATH);
			mEffectView.setImageView(bitmap);
			break;

		case FSEffectView.PICK_FROM_ALBUM:
		case FSEffectView.PICK_FROM_CAMERA:
			startCropActivity(data);
			break;
		}
	}

	
	private void startCropActivity(Intent data) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(data.getData(), "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 256);
		intent.putExtra("outputY", 256);
		intent.putExtra("return-data", false);
		intent.putExtra("output", FileManager.getTempUri());
		startActivityForResult(intent, FSEffectView.CROP_FROM_CAMERA);
		
	}

	@Override
	public void onClickSaveButton() {
		mTabView.onClickChooseEffectButton();
		mAdapter.notifyDataSetChanged();
	}

    @Override
    public void onClickSlotItem(IGridViewItem item, int position, boolean isDeleteMode) {
        if(!isDeleteMode) {
            mEffectView.clearSelected();
        }
    }
	

}