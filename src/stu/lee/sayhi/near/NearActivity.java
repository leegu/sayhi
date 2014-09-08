package stu.lee.sayhi.near;

import stu.lee.sayhi.R;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class NearActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(this.getApplicationContext());
		setContentView(R.layout.near);
		TextView back = (TextView) findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
//				 TelephonyManager localTelephonyManager = (TelephonyManager)getSystemService("phone");
//			      if (localTelephonyManager != null){
//			        String str = localTelephonyManager.getDeviceId();
//			        System.out.println(str);
//			      }
//				mNearMgr.showUserLoaction();
			}
		});
		initNear();
	}
	
	NearMgr mNearMgr = null;
	void initNear(){
		MapView mapView = (MapView)findViewById(R.id.near_mapview);
		 mNearMgr = new NearMgr(this,mapView);
	}
}
