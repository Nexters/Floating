package kr.nexters.eightweeks;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HelpAcitivity extends Activity{
	ViewPager pager1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.help);

		pager1 =  (ViewPager) findViewById(R.id.pager1);
		
		HelpAdapter adapter = new HelpAdapter();
		pager1.setAdapter(adapter);
		
	}
	
	class HelpAdapter extends PagerAdapter {
		int tutorial[] = {R.drawable.tutorial_01,R.drawable.tutorial_02};
		
		@Override
		public int getCount() {
			return tutorial.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view.equals(obj);
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			
			pager1.removeView((View)object);
			
		}

		@Override
		public Object instantiateItem(View container, int position) {
			
			LinearLayout layout = new LinearLayout(getApplicationContext());
			layout.setOrientation(LinearLayout.VERTICAL);
			
			ImageView view = new ImageView(getApplicationContext());
			view.setImageResource(tutorial[position]);
			layout.addView(view);
			
			pager1.addView(layout, position);

			return layout;
		}
}
}
