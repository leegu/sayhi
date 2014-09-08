package stu.lee.sayhi.near;

import stu.lee.sayhi.util.CanvasHelper;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;

public class NearMgr implements BDLocationListener {

	private BaiduMap mBaiduMap;
	private MapView mMapView;
	private Context mContext;

	public NearMgr(Context context, MapView mapView) {
		mContext = context;
		mBaiduMap = mapView.getMap();
		mMapView = mapView;
//		Button btn = new Button(context);
//		btn.setText("�ҵ�λ��");
//		btn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				showUserLoaction();
//			}
//		});
//		mapView.addView(btn,new LayoutParams(CanvasHelper.dip2px(context, 50), CanvasHelper.dip2px(context, 50)));
		showUserLoaction();
	}

	// ��λ���
	LocationClient mLocClient;
	private LocationMode mCurrentMode;
	private UiSettings mUiSettings;
	public void showUserLoaction() {
		mUiSettings = mBaiduMap.getUiSettings();
		mUiSettings.setZoomGesturesEnabled(true);
		mUiSettings.setCompassEnabled(true);
		// ������λͼ��
		mBaiduMap.setMyLocationEnabled(true);
		// ��λ��ʼ��
		mLocClient = new LocationClient(mContext);
		mLocClient.registerLocationListener(this);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// ��gps
		option.setCoorType("bd09ll"); // ������������
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();
	}

	boolean isFirstLoc = true;

	@Override
	public void onReceiveLocation(BDLocation location) {
		// map view ���ٺ��ڴ����½��յ�λ��
		if (location == null || mMapView == null)
			return;
		MyLocationData locData = new MyLocationData.Builder()
				.accuracy(location.getRadius())
				// �˴����ÿ����߻�ȡ���ķ�����Ϣ��˳ʱ��0-360
				.direction(100).latitude(location.getLatitude())
				.longitude(location.getLongitude()).build();
		mBaiduMap.setMyLocationData(locData);
		if (isFirstLoc) {
			isFirstLoc = false;
			LatLng ll = new LatLng(location.getLatitude(),
					location.getLongitude());
			MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
			mBaiduMap.animateMapStatus(u);
		}
	}

}
