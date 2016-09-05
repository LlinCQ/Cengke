package com.example.cengke;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;






public class Homepage_Fragment extends Fragment{
	ListView listView;//全局声明listView对象
	ArrayList<String> list;//声明一个列表集合
	LayoutInflater inflater;//填充器
	View navigationBar;//视图，取名导航栏[调用页面的概述]
	TextView province;//文本视图，省
	//String[] provinces ={"重庆","上海","广州","成都"};//provincet添加一组数据
	//ImageView fubiao;//导航栏浮标，头像等
	ListViewAdapter listViewAdapter;
	GridViewAdapter gridViewadapter;
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle bundle){
		//构建视图
		LinearLayout linearLayout=new LinearLayout(getActivity());//获得加载当前Framgmet的Activity的对象
		linearLayout.setLayoutParams(new LayoutParams(-1,-1));//加载整个布局为线性布局，Params【参数】-1为铺满。
		View view =inflater.inflate(R.layout.homepage_listview,linearLayout);//【需填参布局】视图填充布局.调用局部的参数linearLayout设布局为铺满
		listView=(ListView) view.findViewById(R.id.listview);//
		list = new ArrayList<String>();//list实例化列表集合方法
		this.inflater =inflater;//this当前页面将现有的布局进行填充list数据【得到当前页面可以进行填充】
		navigationBar = inflater.inflate(R.layout.homepage_header, null);//【inflate】传页面的方法
		province = (TextView) navigationBar.findViewById(R.id.text_province);//添加控件的数据
		//fubiao = (ImageView) navigationBar.findViewById(R.id.fubiao_touxiang);//添加控件的数据
		//province.setOnClickListener(listener);//province设置监听事件
		
		
		
		for(int i=0; i<6; i++){
			list.add("");//列表添加6次
		}
		gridViewadapter = new GridViewAdapter(list); 
		for(int i=0; i<7; i++){
			list.add("");//列表添加6次
		listViewAdapter =new ListViewAdapter(list);
		listView.addHeaderView(navigationBar);
		listView.setAdapter(listViewAdapter);
		}
		return view;
		
	}
	
	/*OnClickListener listener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {//监听视图得到id判断，点击后弹出所创建的菜单方法
			case R.id.text_province:
				createPopup();//创建弹出菜单方法
				break;

			default:
				break;
			}
		}	
	};

	private void createPopup(){
		ListView listView = new ListView(getActivity());//获得加载当前Framgmet的Activity的对象
		listView.setDividerHeight(0);//listView的间距高度
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getActvity(),R.layout.)
	}
*/
}
	class ListViewAdapter extends BaseAdapter{
		ArrayList<String> lists;
		private LayoutInflater inflater;
		private int height;
		public ListViewAdapter(ArrayList<String> lists){
	}
	/**
	 * 获得数组列表的大小
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}
	/**
	 * 获得项目
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 获得项目id
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	/**
	 * 获得视图
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//convert转换器   【inflate】传页面的方法
		convertView = inflater.inflate(R.layout.homepage_title, null);
		GridView gridView =(GridView) convertView.findViewById(R.id.homepage_gridview);
		int line =(lists.size()%2>0?1:0)+(int)lists.size()/2;//【将要进行添加的数据】列表以2列形式排列，取余，由于多加一排。
		gridView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,line*height+line*10-10));
		//gridView网格视图设置布局参数//实例化在上个不居中添加布局参数，宽铺满，高
		return convertView;//返回转换的视图
	}

	}
	class GridViewAdapter extends BaseAdapter{
		ArrayList<String> lists;
		private LayoutInflater inflater;
		
		
		public GridViewAdapter(ArrayList<String> list) {
			// TODO Auto-generated constructor stub
			this.lists = list;
		}
		/**
		 * 获得数组列表的大小
		 */
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return lists.size();
		}
		/**
		 * 获得项目
		 */
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
		/**
		 * 获得项目id
		 */
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		/**
		 * 获得视图
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			//convert转换器   【inflate】传页面的方法
			convertView = inflater.inflate(R.layout.homepage_content,null);
			int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);//测量视图的宽度进行制造大小，未定的视图，【主要是根据内容大小】
			int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);//测量视图的高度进行制造大小，未定的视图，【主要是根据内容大小】
			convertView.measure(w, h);//转换器，测量宽高
			int width = convertView.getMeasuredWidth();//将测出的宽转换给GridView布局中的宽
			int height = convertView.getMeasuredHeight();//将测出的高转换给GridView布局中的高
			return convertView;//返回转换的视图
		}
		
	}







