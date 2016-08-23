package com.dy.mystorm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dy.mystorm.fragment.ActivityOne;
import com.dy.mystorm.handler.HandlerActivity;

/**
 * 作者： Dyan on 2016/8/22 17:37
 * 描述：主页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mymain);
		findViewById(R.id.handler).setOnClickListener(this);
		findViewById(R.id.aff).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R .id.handler:
				startActivity(new Intent(this, HandlerActivity.class));
				break;
			case R.id.aff:
				startActivity(new Intent(this, ActivityOne.class));
				break;

		}

	}
}
