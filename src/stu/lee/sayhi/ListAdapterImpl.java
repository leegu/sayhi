package stu.lee.sayhi;

import java.util.ArrayList;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

public class ListAdapterImpl implements ListAdapter {

	private ArrayList<View> mViewList = null;
	
	public ListAdapterImpl(ArrayList<View> viewList){
		mViewList = viewList;
	}
	
	public ArrayList<View> getViewList(){
		return mViewList;
	}
	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mViewList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mViewList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return mViewList.get(position);
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return mViewList.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
		return false;
	}

}
