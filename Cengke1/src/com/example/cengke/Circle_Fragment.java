package com.example.cengke;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Circle_Fragment extends Fragment {
	ListView listView;
	ArrayList<HashMap<String, String>> arrayList;
	HashMap<String, String> map;
	LayoutInflater inflater;

	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle bundle){//������ͼ
		LinearLayout linearLayout = new LinearLayout(getActivity());//��ü��ص�ǰFramgmet��Activity�Ķ���
		linearLayout.setLayoutParams(new LayoutParams(-1,-1));//�������-1Ϊ����
		View view=inflater.inflate(R.layout.circle_zhuye,null);
		listView=(ListView)view.findViewById(R.id.listview);
		arrayList=new ArrayList<HashMap<String,String>>();
		this.inflater=inflater;
		addData();
	//	Adapter adapter=new Adapter(arrayList);
	//	listView.setAdapter(adapter);
		return view;
		
	}
	private void addData() {
		// TODO Auto-generated method stub

	}
}
