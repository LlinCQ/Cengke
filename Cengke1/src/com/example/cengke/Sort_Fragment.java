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
	ListView listview;//�б���ͼ
	ArrayList<String> arraylist;//�����б�
	ArrayList<String> arraylist2;//�����б�
	LayoutInflater inflater;//ת����
	ListAdapter adapter;//������
	int height;

public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState){//ViewGroups��ͼ�飻  container//����
	arraylist=new ArrayList<String>();//ʵ�����ַ������͵������б�
	arraylist2=new ArrayList<String>();
	this.inflater=inflater;
	addData();//������ݣ�Data:����
	
	View view=inflater.inflate(R.layout.sort_listview, null);
	view.setLayoutParams(new LayoutParams(-1, -1));
	//liLayout��Ҫ���õĲ��ֲ���ͨ��ת���������������úõ�xml�ļ��е�list�
	listview=(ListView)view.findViewById(R.id.feilei_kecheng_listview);
	//���ϱߵõ��Ĳ�����ͼ����viewͨ��ǿת����ò��ֿؼ�ʹ�ã��Ѵﵽ�����еĲ��������listView���ݣ�
/*	ListView_Adapter listView_Adapter=new ListView_Adapter(arraylist);
	adapter=new Adapter(arraylists);//ʵ�����������������б������ַ���  
	listview.setAdapter(listView_Adapter);   */
	return view;//������ͼ
	
	}

private void addData() {
	// TODO Auto-generated method stub
	for(int i=0; i<2;i++){
		arraylist.add("������");
		arraylist.add("���Թ�ѧ");
		arraylist.add("�˶���");
	}
	for(int i=0; i<2;i++){
		arraylist2.add("����");
		arraylist2.add("�����");
		arraylist2.add("����");
		arraylist2.add("����");
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
		return position;//�����int������ͬ
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
