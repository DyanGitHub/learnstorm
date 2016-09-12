package com.dy.mythreadupdateui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
/*
   爱哥关于"子线程中也能更新ui"的分析辅助代码类
 */

public class MainActivity extends AppCompatActivity {
	TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = (TextView) findViewById(R.id.text);
		new Thread() {
			@Override
			public void run() {
				super.run();
				//线程暂停（这段时间时间内ViewRootImpl的实例对象会被创建，那么checkThread方法就会被执行，所以会报非主线程更新ui的异常）
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				//那么？ViewRootImpl的实例对象尚未被创建，textview文本是如何被绘制了呢
				mTextView.setText("other thread");
			}
		}.start();
	}
}
