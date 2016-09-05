package com.example.cengke;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Sort_Fragment extends Fragment{
	ListView listview;//列表视图
	ArrayList<String> arraylist;//数组列表
	ArrayList<String> arraylist2;//数组列表
	LayoutInflater inflater;//转换器
	ListAdapter adapter;//适配器
	int height;

public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState){//ViewGroups视图组；  container//集合
	arraylist=new ArrayList<String>();//实例化字符串类型的数组列表
	arraylist2=new ArrayList<String>();
	this.inflater=inflater;
	addData();//添加数据；Data:数据
	
	View view=inflater.inflate(R.layout.sort_listview, null);
	view.setLayoutParams(new LayoutParams(-1, -1));
	//liLayout将要设置的布局参数通过转换器传进现有设置好的xml文件中的list里；
	listview=(ListView)view.findViewById(R.id.feilei_kecheng_listview);
	//将上边得到的布局视图对象view通过强转传入该布局控件使用；已达到在现有的布局中添加listView内容；
/*	ListView_Adapter listView_Adapter=new ListView_Adapter(arraylist);
	adapter=new Adapter(arraylists);//实例化适配器，数组列表传入多个字符；  
	listview.setAdapter(listView_Adapter);   */
	return view;//返回视图
	
	}

private void addData() {
	// TODO Auto-generated method stub
	for(int i=0; i<2;i++){
		arraylist.add("音乐类");
		arraylist.add("语言国学");
		arraylist.add("运动类");
	}
	for(int i=0; i<2;i++){
		arraylist2.add("钢琴");
		arraylist2.add("打击乐");
		arraylist2.add("古筝");
		arraylist2.add("二胡");
	}
}
class ListView_Adpater extends BaseAdapter{
	ArrayList<String>list;
	
	public ListView_Adpater(ArrayList<String> list){
		this.list= list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;//必须和int类型相同
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView=inflater.inflate(R.layout.sort_kecheng_content_xiangqing,null);
		TextView view=(TextView)convertView.findViewById(R.id.fenlie_kechang_xiangqing_title);
		view.setText(list.get(position));
		GridView gridView=(GridView)convertView.findViewById(R.id.fenlei_kecheng_xiangxi_content);
		view.setText(list.get(position));
		gridView.setAdapter(adapter);
		int line=(arraylist2.size()%3>0?1:0+(int)arraylist.size()/3);
		Log.i("line",line+"line"+(int)list.size()/3);
		gridView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,line*height+(line-1)*10));
		return convertView;
	}
	
}
class Adapter extends BaseAdapter{
	ArrayList<String>list;
	public Adapter(ArrayList<String> list){
		this.list=list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView=inflater.inflate(R.layout.sort_listview_params,null);
		TextView view=(TextView)convertView.findViewById(R.id.sort_params);
		int w=View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
		int h=View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
		convertView.measure(w,h);
		w=convertView.getMeasuredWidth();
		h=convertView.getMeasuredHeight();
		return convertView;
	}
	
}
}
