package com.dy.mystorm.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dy.mystorm.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 作者： Dyan on 2016/8/22 16:40
 * 描述：
 */
public class Fragment2 extends Fragment implements View.OnClickListener {
	ActivityOne mActivity;
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		mActivity= (ActivityOne) context;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity.log();
		EventBus.getDefault().register(this);
	}
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onClickEvent(MessageEvent messageEvent)
	{
		textView.setText(messageEvent.msg.getString("msg"));
	}

	TextView textView;
	View mView;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_2,null);
		textView= (TextView) view.findViewById(R.id.text);
		textView.setText("test");
		view.findViewById(R.id.b1).setOnClickListener(this);
		view.findViewById(R.id.b2).setOnClickListener(this);
		view.findViewById(R.id.b3).setOnClickListener(this);
		mView=view;
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		textView=(TextView) mView.findViewById(R.id.text);
		Log.d("dy", textView==null?"null":" not null");
	}

//	public void resfreshView(String value)
//	{
//		Log.d("dy", getView()==null?"null":" not null");
//		textView.setText(value);
//	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
		Log.d("dy", "f2 ondestory");
	}


	@Override
	public void onClick(View v) {
		Log.d("dy", "selfonclick:"+Thread.currentThread().getId());
		switch (v.getId())
		{
			case R.id.b1:
				textView.setText("b1");
				break;
			case R.id.b2:
				textView.setText("b2");
				break;
			case R.id.b3:
				textView.setText("b3");
				break;
		}
	}
}
