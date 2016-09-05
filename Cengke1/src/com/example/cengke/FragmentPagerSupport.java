package com.example.cengke;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class FragmentPagerSupport extends FragmentActivity{
	RadioGroup radioGroup;
	RadioButton btn_homepage;//首页
	RadioButton btn_sort;//分类
	RadioButton btn_circle;//圈子
	RadioButton btn_my;//我
	
	FrameLayout rePlace_layout;//rePlace 替换
	
	Homepage_Fragment homepage_fragment;
	Sort_Fragment sort_fragment;
	Circle_Fragment circle_fragment;
	MyCenter_Fragment my_fragment;
	FragmentManager fm = getSupportFragmentManager();
	
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题拦
		setContentView(R.layout.start);
		
		rePlace_layout = (FrameLayout) findViewById(R.id.framelayout);//替换布局视图的ID
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup_start);
		radioGroup.setOnCheckedChangeListener(CheckedChangeListener);//选中改变的监听
		btn_homepage = (RadioButton) findViewById(R.id.radiobutton_homepage);
		btn_sort = (RadioButton)findViewById(R.id.radiobutton_sort);
		btn_circle = (RadioButton)findViewById(R.id.radiobutton_circle);
		btn_my = (RadioButton)findViewById(R.id.radiobutton_mine);
		
		setFragment(R.id.radiobutton_homepage);//自定义方法设置Fragment按钮
		setchecked(R.id.radiobutton_homepage);
}									
	
	
	OnCheckedChangeListener CheckedChangeListener = new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			setFragment(checkedId);//自定义生成Fragment判断方法——用于判断Fragment切换
			setchecked(checkedId);// 自定义生成【选中】方法 ——此处用于字体切换
			switch (checkedId) {
			
			default:
				break;
			}
		}
	};
	private void setchecked(int Id) {
		// TODO Auto-generated method stub
		switch (Id) {
		case R.id.radiobutton_homepage://选中首页做出以下判断
			//图片
			btn_homepage.setCompoundDrawablesWithIntrinsicBounds(null, 
					getResources().getDrawable(R.drawable.rub_course_home_page_selected_bg),
					null, null);// 选中图片更换为 靓图
			btn_sort.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_category_not_selected_bg), null, null);
			btn_circle.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_group_not_selected_bg), null, null);
			btn_my.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_me_not_selected_bg),null,null);
			//字体
			btn_homepage.setTextColor(getResources().getColor(R.color.chenghuangse));// 选中为深蓝色
			btn_sort.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			btn_circle.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			btn_my.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			break;
		case R.id.radiobutton_sort://选中分类做出以下判断
			btn_homepage.setCompoundDrawablesWithIntrinsicBounds(null, 
					getResources().getDrawable(R.drawable.rub_course_home_page_not_selected_bg),
					null, null);// 选中图片更换为 靓图
			btn_sort.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_category_selected_bg
							
							), null, null);
			btn_circle.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_group_not_selected_bg), null, null);
			btn_my.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_me_not_selected_bg),null,null);
			btn_homepage.setTextColor(getResources().getColor(R.color.black));// 选中为深蓝色
			btn_sort.setTextColor(getResources().getColor(R.color.chenghuangse));// 未选中为黑色
			btn_circle.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			btn_my.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			break;
		case R.id.radiobutton_circle://选中圈子做出以下判断
			btn_homepage.setCompoundDrawablesWithIntrinsicBounds(null, 
					getResources().getDrawable(R.drawable.rub_course_home_page_not_selected_bg),
					null, null);// 选中图片更换为 靓图
			btn_sort.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_category_not_selected_bg), null, null);
			btn_circle.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_group_selected_bg), null, null);
			btn_my.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_me_not_selected_bg),null,null);
			
			btn_homepage.setTextColor(getResources().getColor(R.color.black));// 选中为深蓝色
			btn_sort.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			btn_circle.setTextColor(getResources().getColor(R.color.chenghuangse));// 未选中为黑色
			btn_my.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			break;
		case R.id.radiobutton_mine://选中我做出以下判断
			btn_homepage.setCompoundDrawablesWithIntrinsicBounds(null, 
					getResources().getDrawable(R.drawable.rub_course_home_page_not_selected_bg),
					null, null);// 选中图片更换为 靓图
			btn_sort.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_category_not_selected_bg), null, null);
			btn_circle.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_group_not_selected_bg), null, null);
			btn_my.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.rub_course_me_selected_bg),null,null);
			
			btn_homepage.setTextColor(getResources().getColor(R.color.black));// 选中为深蓝色
			btn_sort.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			btn_circle.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			btn_my.setTextColor(getResources().getColor(R.color.chenghuangse));// 未选中为黑色
			break;
		default:
			break;
		}
	}

	private void setFragment(int R_id) {
		// TODO Auto-generated method stub
		// 碎片Manager管理人员——获得Support支持碎片管理
		FragmentTransaction ft = fm.beginTransaction();// 碎片管理begin开始处理Transaction事物
		switch (R_id){
		case R.id.radiobutton_homepage:
			ft.replace(R.id.framelayout, homepage_fragment);// replace替换——【Fragment替换viewoager内容】
			ft.commit();// commit委托
			break;
		case R.id.radiogroup_start:
			ft.replace(R.id.framelayout, homepage_fragment);
			ft.commit();// commit委托
			break;
		case R.id.radiobutton_circle:
			ft.replace(R.id.framelayout, homepage_fragment);
			ft.commit();// commit委托
			break;
		case R.id.radiobutton_mine:
			ft.replace(R.id.framelayout, homepage_fragment);
			ft.commit();// commit委托
			break;
		}
	}
}
