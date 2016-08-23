package com.dy.mystorm.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/*
   Handler使用（消息队列+线程队列两种）20160822
 */
public class HandlerActivity extends AppCompatActivity {
	Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		//1、真正开启了一个新的线程
		HandlerThread handlerThread=new HandlerThread("myhandler");
		handlerThread.start();//不调用start是会报空指针的
		handler=new Handler(handlerThread.getLooper()){
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				if(msg.what==2)
				{
					Log.d("dy", "msg.what==2");//true
				}else
				{
					Log.d("dy", "msg.what!=2");
				}
			}
		};
		Log.d("dy", "onCreate current thread id is :"+Thread.currentThread().getId());
		//2、并没有生成新的线程，只是在主线程中运行了一下run中的代码
//		handler=new Handler();
		handler.post(new MyRunnable());
	}
	public class MyRunnable implements Runnable
	{
		@Override
			public void run() {
				Log.d("dy", "Runnable thread is running!");
				Log.d("dy", "current thread id is:"+Thread.currentThread().getId());
				Message msg=Message.obtain();
				msg.what=2;
				handler.sendMessage(msg);
		}
	}

}
