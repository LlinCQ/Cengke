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
	ListView listView;//ȫ������listView����
	ArrayList<String> list;//����һ���б���
	LayoutInflater inflater;//�����
	View navigationBar;//��ͼ��ȡ��������[����ҳ��ĸ���]
	TextView province;//�ı���ͼ��ʡ
	//String[] provinces ={"����","�Ϻ�","����","�ɶ�"};//provincet���һ������
	//ImageView fubiao;//���������꣬ͷ���
	ListViewAdapter listViewAdapter;
	GridViewAdapter gridViewadapter;
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle bundle){
		//������ͼ
		LinearLayout linearLayout=new LinearLayout(getActivity());//��ü��ص�ǰFramgmet��Activity�Ķ���
		linearLayout.setLayoutParams(new LayoutParams(-1,-1));//������������Ϊ���Բ��֣�Params��������-1Ϊ������
		View view =inflater.inflate(R.layout.homepage_listview,linearLayout);//������β��֡���ͼ��䲼��.���þֲ��Ĳ���linearLayout�貼��Ϊ����
		listView=(ListView) view.findViewById(R.id.listview);//
		list = new ArrayList<String>();//listʵ�����б��Ϸ���
		this.inflater =inflater;//this��ǰҳ�潫���еĲ��ֽ������list���ݡ��õ���ǰҳ����Խ�����䡿
		navigationBar = inflater.inflate(R.layout.homepage_header, null);//��inflate����ҳ��ķ���
		province = (TextView) navigationBar.findViewById(R.id.text_province);//��ӿؼ�������
		//fubiao = (ImageView) navigationBar.findViewById(R.id.fubiao_touxiang);//��ӿؼ�������
		//province.setOnClickListener(listener);//province���ü����¼�
		
		
		
		for(int i=0; i<6; i++){
			list.add("");//�б����6��
		}
		gridViewadapter = new GridViewAdapter(list); 
		for(int i=0; i<7; i++){
			list.add("");//�б����6��
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
			switch (v.getId()) {//������ͼ�õ�id�жϣ�����󵯳��������Ĳ˵�����
			case R.id.text_province:
				createPopup();//���������˵�����
				break;

			default:
				break;
			}
		}	
	};

	private void createPopup(){
		ListView listView = new ListView(getActivity());//��ü��ص�ǰFramgmet��Activity�Ķ���
		listView.setDividerHeight(0);//listView�ļ��߶�
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
	 * ��������б�Ĵ�С
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}
	/**
	 * �����Ŀ
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * �����Ŀid
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	/**
	 * �����ͼ
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//convertת����   ��inflate����ҳ��ķ���
		convertView = inflater.inflate(R.layout.homepage_title, null);
		GridView gridView =(GridView) convertView.findViewById(R.id.homepage_gridview);
		int line =(lists.size()%2>0?1:0)+(int)lists.size()/2;//����Ҫ������ӵ����ݡ��б���2����ʽ���У�ȡ�࣬���ڶ��һ�š�
		gridView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,line*height+line*10-10));
		//gridView������ͼ���ò��ֲ���//ʵ�������ϸ���������Ӳ��ֲ���������������
		return convertView;//����ת������ͼ
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
		 * ��������б�Ĵ�С
		 */
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return lists.size();
		}
		/**
		 * �����Ŀ
		 */
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
		/**
		 * �����Ŀid
		 */
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		/**
		 * �����ͼ
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			//convertת����   ��inflate����ҳ��ķ���
			convertView = inflater.inflate(R.layout.homepage_content,null);
			int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);//������ͼ�Ŀ�Ƚ��������С��δ������ͼ������Ҫ�Ǹ������ݴ�С��
			int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);//������ͼ�ĸ߶Ƚ��������С��δ������ͼ������Ҫ�Ǹ������ݴ�С��
			convertView.measure(w, h);//ת�������������
			int width = convertView.getMeasuredWidth();//������Ŀ�ת����GridView�����еĿ�
			int height = convertView.getMeasuredHeight();//������ĸ�ת����GridView�����еĸ�
			return convertView;//����ת������ͼ
		}
		
	}







