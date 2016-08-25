package com.dy.mystorm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.dy.mystorm.R;

/**
 * 作者： Dyan on 2016/8/22 16:41
 * 描述： fragment 所在的activity
 * fragment间数据交互和activity与fragment的数据交互
 */
public class ActivityOne extends FragmentActivity implements Fragment1.CallBack {
	public String from;
	Fragment1 mFragment1;
	Fragment2 mFragment2;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentManager fm = getSupportFragmentManager();
		mFragment1 = new Fragment1();
		mFragment2 = new Fragment2();
		fm.beginTransaction().add(R.id.fragment1, mFragment1);
		fm.beginTransaction().add(R.id.fragment2, mFragment2);

	}

	public void log() {
		Log.d("dy", " ActivityOne :" + from);
	}

	@Override
	public void onClick(int value) {

//		mFragment2.resfreshView(String.valueOf(value));
		//mFragme2d的View一直为null
//		Log.d("dy", mFragment2.textView == null ? "null" : "is null");
//		mFragment2.onClick(value);
	}
	interface CallBack{
		void onClick(int value);
	}
//	//获取本机号码
//	public void getMyPhoneNum()
//	{
//		TelephonyManager tMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//		String mPhoneNumber = tMgr.getLine1Number();
//		tMgr.getCellLocation();
//		//获取不到手机号啊
//		Log.d("dy", "mPhoneNumber:"+tMgr.getCellLocation());
//	}

}
