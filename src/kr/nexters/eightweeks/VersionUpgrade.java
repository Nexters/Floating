package kr.nexters.eightweeks;

import kr.nexters.eightweeks.manager.PrefManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class VersionUpgrade {
	
	public static void doUpgrade() {
		int lastVersionCode = PrefManager.getInstance().getInt(PrefManager.PREK_KEY_LAST_VERSION_CODE, 10006);
		int currentVersionCode = 0; 
	    try {  
	        PackageInfo info = Common.getMainContext().getPackageManager().getPackageInfo(Common.getMainContext().getPackageName(), 0);  
	        currentVersionCode = info.versionCode;  
	    } catch (NameNotFoundException e) {  
	    	e.printStackTrace();
	    }  
	    
	    while(lastVersionCode < currentVersionCode) {
	    	switch(lastVersionCode) {
	    	case 10006:
	    		upgrade_10006();
	    		break;
	    	}
	    	lastVersionCode++;
	    }
	    
	    PrefManager.getInstance().putInt(PrefManager.PREK_KEY_LAST_VERSION_CODE, currentVersionCode);
	}
	
	/* clear Preference value */
	private static void upgrade_10006() {
		PrefManager.getInstance().clearPrefValue();
	}
}
