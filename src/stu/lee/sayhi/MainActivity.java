package stu.lee.sayhi;

import java.util.ArrayList;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import stu.lee.sayhi.near.NearActivity;
import stu.lee.sayhi.near.NearMgr;
import stu.lee.sayhi.obj.ListData;
import stu.lee.sayhi.ui.ViewPagerAdapter;
import stu.lee.sayhi.util.AppLog;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initHeadBar();
		initFootBar();
		initViewPager();
	}
	TextView mTitle = null;
	void initHeadBar(){
		mTitle = (TextView)findViewById(R.id.head_title);
		mTitle.setVisibility(View.GONE);
	}
	void initFootBar(){
		ViewGroup footBarGroup = (ViewGroup)findViewById(R.id.foot_bar);
		for(int i = 0; i < footBarGroup.getChildCount(); i++){
			View view = footBarGroup.getChildAt(i);
			view.setId(i);
			view.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					AppLog.d("OnClickListener", v.getId() + "");
					mViewPager.setCurrentItem(v.getId(),false);
				}
			});
		}
	}
	ViewPager mViewPager;
	void initViewPager(){
		mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
		LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.list, null);initMsgList((ListView)view1);
        View view2 = mLi.inflate(R.layout.list, null);iniContactList((ListView)view2);
        View view3 = mLi.inflate(R.layout.list, null);initFound((ListView)view3);
        final View view4 = mLi.inflate(R.layout.list, null);initMySelfList((ListView)view4);
        
        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        
        ViewPagerAdapter wAdapter = new ViewPagerAdapter(views);
        mViewPager.setAdapter(wAdapter);
        
        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	void initMsgList(ListView list){
//		iniContactList(list);
	}
	void iniContactList(ListView list){
		String[] strs = getResources().getStringArray(R.array.main_found_strs);
		Integer[] icons = {R.drawable.near,R.drawable.found,R.drawable.found_her};
		Integer[] space = {10,0,50};
		int num = 10;
		ArrayList<String> strArr = new ArrayList<String>();
		int[] t_icons = new int[num];
		int[] t_space = new int[num];
		for(int i = 0; i < num; i++){
			strArr.add(strs[i % strs.length]);
			t_icons[i] = (icons[i % icons.length]);
			t_space[i] = (space[i % space.length]);
		}
		ListData listData = new ListData();
		strs = new String[strArr.size()];
		strArr.toArray(strs);
		listData.strs = strs;
		listData.icons = t_icons;
//		listData.space_top = t_space;
//		listData.space_bottom = t_space;
		fillList(list,  listData);
	}
	
	void initMySelfList(ListView list){
//		iniContactList(list);
	}
	void initFound(ListView list){
		String[] strs = getResources().getStringArray(R.array.main_found_strs);
		int[] icons = {R.drawable.near,R.drawable.found,R.drawable.found_her};
		int[] space = {10,0,50};
		ListData listData = new ListData();
		listData.strs = strs;
		listData.icons = icons;
		listData.space_top = space;
		listData.callbacks = new OnClickListener[2];
		listData.callbacks[1] = new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClassName(MainActivity.this, NearActivity.class.getName());
				MainActivity.this.startActivity(i);
			}
		};
		fillList(list,  listData);
	}
	void fillList(ListView list,final ListData data){
		String[] strs = data.strs;
		int[] icons = data.icons;
		Bitmap[] bimaps = data.icons_bitmap;
		int[] space_top = data.space_top;
		int[] space_bottom = data.space_bottom;
		
		boolean useIntIcons = icons != null;
		LayoutInflater mLi = LayoutInflater.from(this);
        ArrayList<View> arrList = new ArrayList<View>();
    	int minLength = Math.min(strs.length, useIntIcons ? icons.length : bimaps != null ? bimaps.length : 0);
        for(int i = 0; i < minLength; i++){
        	View listItem = mLi.inflate(R.layout.listitem, null);
        	if(data.callbacks != null && data.callbacks.length > i && data.callbacks[i] != null){
        		listItem.setOnClickListener(data.callbacks[i]);
        	}

        	//设置图标
        	ImageView iv = (ImageView)listItem.findViewById(R.id.list_item_icon);
        	if(useIntIcons){
        		iv.setImageResource(icons[i]);
        	}else{
        		iv.setImageBitmap(bimaps[i]);
        	}
        	//设置描述文字
        	TextView text = (TextView)listItem.findViewById(R.id.list_item_text);
        	text.setText(strs[i]);
        	
        	//设置间隔高度
        	if(space_top != null){
	        	LinearLayout spaceView = (LinearLayout)listItem.findViewById(R.id.list_item_space_top);
	        	spaceView.setVisibility(View.VISIBLE);
	        	spaceView.getLayoutParams().height = space_top[i];
        	}
        	
        	//设置间隔高度
        	if(space_bottom != null){
	        	LinearLayout spaceView_b = (LinearLayout)listItem.findViewById(R.id.list_item_space_bottom);
	        	spaceView_b.setVisibility(View.VISIBLE);
	        	spaceView_b.getLayoutParams().height = space_bottom[i];
        	}
        	arrList.add(listItem);
        }
    	list.setAdapter(new ListAdapterImpl(arrList));
	}
}
