package com.example.cengke;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class MyCenter_Fragment extends Fragment{
	
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle bundle){
		LinearLayout linearLayout = new LinearLayout(getActivity());
		linearLayout.setLayoutParams(new LayoutParams(-1,-1));//¿í¸ßÆÌÂú-1ÎªÆÌÂú
		View view =inflater.inflate(R.layout.gerenzhongxin, linearLayout);
		return view;
	}

		


}










