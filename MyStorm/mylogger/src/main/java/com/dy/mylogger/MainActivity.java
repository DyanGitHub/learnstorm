package com.dy.mylogger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		a();
//		Logger.e("hello android");
        String jsonTest="{\"title\":\"\\u53d1\\u73b0\\u65b0\\u7248\\u672c\",\"description\":\"\\u624b\\u673a\\u53f7\\u7801\\u4e00\\u952e\\u767b\\u5f55\\u65e0\\u9700\\u6ce8\\u518c\",\"version\":\"2.1.05\",\"url\":\"http:\\/\\/www.guzheng.cn\\/app\\/apk\\/gzapp2105.apk\"}";
		Logger.json(jsonTest);
	}

	private void a() {
		b();
	}

	private void b() {
		StringBuilder sb=new StringBuilder();
		StackTraceElement[] et=Thread.currentThread().getStackTrace();
		for(StackTraceElement e:et)
		{
			sb.append("\tat");
			sb.append(e.toString());
			sb.append("\n");
//			Log.d("dy", e.getLineNumber()+"");
		}
		Log.d("dy", sb.toString());

	}
}
