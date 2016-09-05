package com.example.cengke;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	RadioGroup radioGroup;// 声明RadioGroup
	// MyAdapter mAdapter;
	ViewPager mPager;
	ArrayList<Fragment> fragmentList;
	Homepage_Fragment homepage;//首页
	Circle_Fragment circle;//圈子
	Sort_Fragment sort;//分类
	MyCenter_Fragment center;//我
	FragmentManager fm;

	/*
	 * 如何结合Fragment以及ViewPager实现微信首页的效果1.创建一个Activity继承于FragmentActivity
	 * 2.创建4个不一样的Fragment3.创建ViewPager4.自定义一个FragmentPagerAdapter
	 * 5.setAdapter绑定数据
	 */
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.start);// 主布局界面；首页的布局
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup_start);
		homepage = new Homepage_Fragment();//首页
		center = new MyCenter_Fragment();//我
		sort = new Sort_Fragment();//分类
		circle = new Circle_Fragment();//圈子
		// 实例化radioGroup控件
		// 将实例化得到的radioGroup绑定监听事件
		// setFragment();//设置Fragment方法
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();// 事件(事务)【内部类】
		//framelayout帧布局
		ft.add(R.id.framelayout, homepage);//添加 首页
		ft.add(R.id.framelayout, center);//~我
		ft.add(R.id.framelayout, sort);//~分类
		ft.add(R.id.framelayout, circle);//~圈子
		ft.commit();//提交
		radioGroup.setOnCheckedChangeListener(listener);
	}

	// OnCheckedChangeListener多个按钮监听事件
	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int Id) {
			FragmentTransaction transaction = fm.beginTransaction();// 事件(事务)【内部类】
			switch (Id) {// Id判断点击之后跳转的界面
			case R.id.radiobutton_homepage:// Id调用 RadioGroup里的首页按钮
				// setHomepage_Activity();//Id按钮绑定可用的Class类或布局
				transaction.replace(R.id.framelayout, homepage);
				transaction.commit();
				break;
			case R.id.radiobutton_sort:// Id调用 RadioGroup里的分类按钮
				// setSort_Activity();//Id按钮绑定可用的Class类或布局
				transaction.replace(R.id.framelayout, center);
				transaction.commit();
				break;
			case R.id.radiobutton_circle:
				transaction.replace(R.id.framelayout, sort);
				transaction.commit();
				break;
			}
		}

	};

	@SuppressLint("NewApi")
	private void setFragment() {
		// TODO Auto-generated method stub

		// 创建一个FragmentManager对象
		FragmentManager fragmentManager = getSupportFragmentManager();
		// 创建FragmentTransaction对象
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 创建Fragment的对象
		Sort_Fragment sort_Activity = new Sort_Fragment();
		// 指定布局文件的内容(添加)替换成对应的 fragment
		transaction.replace(R.id.framelayout, sort_Activity);// 这里的iddiao
		// 【上文表述】传入的参id表示将用于添加后面Class文件的类；
		// sort_Activity表示将要添加进指定布局的Class类或者layout（布局）
		transaction.commit();// 提交修改

	}

	// FragmentManager fragmentManager = getFragmentManager();
	// 这是直接调用android.support.app.FragmentManager;的方法
	// import android.support.app.FragmentManager;
	@SuppressLint("NewApi")
	private void setFragment2() {
		// 创建一个FragmentManager对象
		FragmentManager fragmentManager = getSupportFragmentManager();
		// 创建FragmentTransactinon对象
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 创建Fragment的对象
		Homepage_Fragment homepage_Activity = new Homepage_Fragment();
		// 指定布局文件的内容(添加)替换成对应的 fragment
		transaction.replace(R.id.framelayout, homepage_Activity);
		// 【上文表述】传入的参id表示将用于添加后面Class文件的类；
		// homepage_Activity表示将要添加进指定布局的Class类或者layout（布局）
		transaction.commit();// 提交修改
	}

}
