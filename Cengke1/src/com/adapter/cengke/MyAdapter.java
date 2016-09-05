package com.adapter.cengke;

import java.util.ArrayList;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;


public class MyAdapter extends FragmentPagerAdapter{
	
	ArrayList<Fragment> fragmentList;
	
	public MyAdapter(android.support.v4.app.FragmentManager fm,ArrayList<Fragment> fragmentList){
		super(fm);
		this.fragmentList=fragmentList;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
