package stu.lee.sayhi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SplashView {
	Activity mSplashActivity = null;
	Class newActivity = null;
	SplashView(Activity selfActivity,Class newActivityClass,ViewPager viewPager){
		mSplashActivity = selfActivity;
		newActivity = newActivityClass;
		ArrayList<View> viewPagerList = new ArrayList<View>();
		int size = 2;
		for(int i = 0; i < size; i++){
			ImageView iv = new ImageView(selfActivity);
			if (i ==  0)
				iv.setImageResource(R.drawable.ic_launcher);
			if (i == 1){
				iv.setImageResource(R.drawable.ic_launcher);
				iv.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
					showMainActivity();
					}
				});
			}
			
			viewPagerList.add(iv);
		}
		viewPager.setAdapter(new SplashAdapter(viewPagerList));
		viewPager = viewPager;
		viewPager.setBackgroundColor(0xffff0000);
		viewPager.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				showMainActivity();
			}
		}, 500);
	}
	
	private void showMainActivity(){
		Intent intent = new Intent();
		intent.setClassName(mSplashActivity, newActivity.getName());
		mSplashActivity.startActivity(intent);
		mSplashActivity.finish();
	}
}

