package com.dy.myimmersive;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
/*
   基于郭霖沉浸式讲解的实践（郭霖称：只有沉浸式效果而不存在沉浸式状态栏这个概念）
   1、透明式状态栏
   2、沉浸式效果
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("dy", "onCreate");
		setContentView(R.layout.activity_main);
		findViewById(R.id.hide_state).setOnClickListener(this);
		findViewById(R.id.transparent_state).setOnClickListener(this);
		findViewById(R.id.hide_navigation).setOnClickListener(this);
		findViewById(R.id.transparent_navigation).setOnClickListener(this);
		decorView= getWindow().getDecorView();
//		隐藏操作栏
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();

	}
	View decorView ;
	int option;
	@Override
	public void onClick(View v) {

		switch (v.getId()) {

			case R.id.hide_state:
				//1、内容全屏显示（覆盖状态栏+隐藏操作栏）
                // 内容全屏且覆盖状态栏
				option = View.SYSTEM_UI_FLAG_FULLSCREEN;
				decorView.setSystemUiVisibility(option);
				break;
			case R.id.transparent_state:
				if (Build.VERSION.SDK_INT >= 21) {
					//只支持5.0的系统
					//内容全屏透明化状态栏（不覆盖）
					option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
					decorView.setSystemUiVisibility(option);
					getWindow().setStatusBarColor(Color.TRANSPARENT);
				}
				break;
			case R.id.hide_navigation:
				//1、内容全屏显示（覆盖导航栏）
				// 内容全屏且覆盖导航栏
				option = View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
				decorView.setSystemUiVisibility(option);
				break;
			case R.id.transparent_navigation:
				if (Build.VERSION.SDK_INT >= 21) {
					//只支持5.0的系统
					//内容全屏透明化导航栏（不覆盖）
					option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
					decorView.setSystemUiVisibility(option);
					getWindow().setStatusBarColor(Color.TRANSPARENT);
					getWindow().setNavigationBarColor(Color.TRANSPARENT);
				}
				break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("dy", "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("dy", "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("dy", "onStop()");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("dy", " onStart()");
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		Log.d("dy", "onWindowFocusChanged:"+hasFocus);
		if(hasFocus)
		{
			if(Build.VERSION.SDK_INT>=19)
			{
				//4.4以上才支持完全沉浸式效果
				//沉浸式效果(一般用在横屏的游戏或者视频全屏)
				decorView.setSystemUiVisibility(
						View.SYSTEM_UI_FLAG_LAYOUT_STABLE
								| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
								| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
								| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
								| View.SYSTEM_UI_FLAG_FULLSCREEN
								| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
			}


		}
	}


}
