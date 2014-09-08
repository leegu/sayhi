package stu.lee.sayhi.ui;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerAdapter extends PagerAdapter{

	private ArrayList<View> views;
	
	
	public ViewPagerAdapter(ArrayList<View> views){
		this.views = views;
	}
	//获得size
	@Override
	public int getCount() {
		return this.views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	//销毁item
	public void destroyItem(View container, int position, Object object) {
		((ViewPager)container).removeView(views.get(position));
	}
	
	//页面view（实例化item）
	public Object instantiateItem(View container, int position) {
		((ViewPager)container).addView(views.get(position));
		return views.get(position);
	}

}
