package com.dy.mystorm.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dy.mystorm.R;

import org.greenrobot.eventbus.EventBus;

/**
 * 作者： Dyan on 2016/8/22 16:40
 * 描述：
 */
public class Fragment1 extends Fragment implements View.OnClickListener {
	CallBack mCallBack;

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.b1:
				Bundle msg=new Bundle();
				msg.putString("msg","信息传递成功！");
				EventBus.getDefault().post(new MessageEvent(msg));
				mCallBack.onClick(1);
				break;
			case R.id.b2:
				mCallBack.onClick(2);
				break;
			case R.id.b3:
				mCallBack.onClick(3);
				break;
		}
	}

	public interface CallBack {
		void onClick(int value);
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		mCallBack = (CallBack) context;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_1, null);
		view.findViewById(R.id.b1).setOnClickListener(this);
		view.findViewById(R.id.b2).setOnClickListener(this);
		view.findViewById(R.id.b3).setOnClickListener(this);
		return view;
	}
}
