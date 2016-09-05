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
	RadioGroup radioGroup;// ����RadioGroup
	// MyAdapter mAdapter;
	ViewPager mPager;
	ArrayList<Fragment> fragmentList;
	Homepage_Fragment homepage;//��ҳ
	Circle_Fragment circle;//Ȧ��
	Sort_Fragment sort;//����
	MyCenter_Fragment center;//��
	FragmentManager fm;

	/*
	 * ��ν��Fragment�Լ�ViewPagerʵ��΢����ҳ��Ч��1.����һ��Activity�̳���FragmentActivity
	 * 2.����4����һ����Fragment3.����ViewPager4.�Զ���һ��FragmentPagerAdapter
	 * 5.setAdapter������
	 */
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.start);// �����ֽ��棻��ҳ�Ĳ���
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup_start);
		homepage = new Homepage_Fragment();//��ҳ
		center = new MyCenter_Fragment();//��
		sort = new Sort_Fragment();//����
		circle = new Circle_Fragment();//Ȧ��
		// ʵ����radioGroup�ؼ�
		// ��ʵ�����õ���radioGroup�󶨼����¼�
		// setFragment();//����Fragment����
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();// �¼�(����)���ڲ��ࡿ
		//framelayout֡����
		ft.add(R.id.framelayout, homepage);//��� ��ҳ
		ft.add(R.id.framelayout, center);//~��
		ft.add(R.id.framelayout, sort);//~����
		ft.add(R.id.framelayout, circle);//~Ȧ��
		ft.commit();//�ύ
		radioGroup.setOnCheckedChangeListener(listener);
	}

	// OnCheckedChangeListener�����ť�����¼�
	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int Id) {
			FragmentTransaction transaction = fm.beginTransaction();// �¼�(����)���ڲ��ࡿ
			switch (Id) {// Id�жϵ��֮����ת�Ľ���
			case R.id.radiobutton_homepage:// Id���� RadioGroup�����ҳ��ť
				// setHomepage_Activity();//Id��ť�󶨿��õ�Class��򲼾�
				transaction.replace(R.id.framelayout, homepage);
				transaction.commit();
				break;
			case R.id.radiobutton_sort:// Id���� RadioGroup��ķ��ఴť
				// setSort_Activity();//Id��ť�󶨿��õ�Class��򲼾�
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

		// ����һ��FragmentManager����
		FragmentManager fragmentManager = getSupportFragmentManager();
		// ����FragmentTransaction����
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// ����Fragment�Ķ���
		Sort_Fragment sort_Activity = new Sort_Fragment();
		// ָ�������ļ�������(���)�滻�ɶ�Ӧ�� fragment
		transaction.replace(R.id.framelayout, sort_Activity);// �����iddiao
		// �����ı���������Ĳ�id��ʾ��������Ӻ���Class�ļ����ࣻ
		// sort_Activity��ʾ��Ҫ��ӽ�ָ�����ֵ�Class�����layout�����֣�
		transaction.commit();// �ύ�޸�

	}

	// FragmentManager fragmentManager = getFragmentManager();
	// ����ֱ�ӵ���android.support.app.FragmentManager;�ķ���
	// import android.support.app.FragmentManager;
	@SuppressLint("NewApi")
	private void setFragment2() {
		// ����һ��FragmentManager����
		FragmentManager fragmentManager = getSupportFragmentManager();
		// ����FragmentTransactinon����
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// ����Fragment�Ķ���
		Homepage_Fragment homepage_Activity = new Homepage_Fragment();
		// ָ�������ļ�������(���)�滻�ɶ�Ӧ�� fragment
		transaction.replace(R.id.framelayout, homepage_Activity);
		// �����ı���������Ĳ�id��ʾ��������Ӻ���Class�ļ����ࣻ
		// homepage_Activity��ʾ��Ҫ��ӽ�ָ�����ֵ�Class�����layout�����֣�
		transaction.commit();// �ύ�޸�
	}

}
