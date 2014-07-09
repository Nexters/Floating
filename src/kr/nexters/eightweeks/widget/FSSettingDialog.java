package kr.nexters.eightweeks.widget;

import kr.nexters.eightweeks.R;
import kr.nexters.eightweeks.SettingValue;
import kr.nexters.eightweeks.manager.FSParticleDrawManager;
import kr.nexters.eightweeks.manager.PrefManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class FSSettingDialog extends AlertDialog.Builder implements OnSeekBarChangeListener {
	
	private SeekBar sizeSetting;	/* max : 70 	*/
	private SeekBar amountSetting;	/* max : 10000 	*/
	private SeekBar speedSetting;	/* max : 40 	*/
	private SeekBar alphaSetting;	/* max : 255 	*/
	
	private Context context;
	private View settingButton;
	
	public FSSettingDialog(Context arg0) {
		super(arg0);
		context = arg0;
		initialize();
	}
	
	private void initialize() {
		initView();
		initControls();
		initSettingValue();
	}
	
	private void initView() {
		LayoutInflater inflater = LayoutInflater.from(context);
		final View setting = inflater.inflate(R.layout.setting, null);
		
		sizeSetting = (SeekBar) setting.findViewById(R.id.pt1);
		amountSetting = (SeekBar) setting.findViewById(R.id.pt2);
		speedSetting = (SeekBar) setting.findViewById(R.id.pt3);
		alphaSetting = (SeekBar) setting.findViewById(R.id.pt4);
		
		setView(setting);
	}
	
	private void initControls() {
		setTitle(R.string.settingTitle);
		setCancelable(false);
		
		sizeSetting.setOnSeekBarChangeListener(this);
		amountSetting.setOnSeekBarChangeListener(this);
		speedSetting.setOnSeekBarChangeListener(this);
		alphaSetting.setOnSeekBarChangeListener(this);
		
		setPositiveButton(R.string.confirm, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				settingButton.setSelected(false);
				FSParticleDrawManager.getInstance().clearParticle();
				FSParticleDrawManager.getInstance().draw();
			}
		});
		
	}
	
	private void initSettingValue() {
		sizeSetting.setProgress((int) (SettingValue.getSizeValue() / SettingValue.getAdjSize()));
		amountSetting.setProgress((int) SettingValue.getAmountValue());
		speedSetting.setProgress((int) (SettingValue.getSpeedValue() / SettingValue.getAdjSpeed()));
		alphaSetting.setProgress(SettingValue.getAlphaValue());
	}
	
	public void setSettingButton(View _settingButton) {
		settingButton = _settingButton;
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		switch(seekBar.getId()) { 
		case R.id.pt1:
			SettingValue.setSizeValue(progress);
			break;
		case R.id.pt2:
			SettingValue.setAmountValue(progress);
			break;
		case R.id.pt3:
			SettingValue.setSpeedValue(progress);
			break;
		case R.id.pt4:
			SettingValue.setAlphaValue(progress);
			break;
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		seekBar.incrementProgressBy(1);
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) { }
}
