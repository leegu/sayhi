package stu.lee.sayhi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		ViewPager vp = (ViewPager)findViewById(R.id.viewpager);
		new SplashView(this,MainActivity.class,vp);
	}

}
