package com.dy.myeasynetcomment;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dy.myeasynetcomment.bean.Comment;
import com.dy.myeasynetcomment.bean.User;
import com.dy.myeasynetcomment.data.DataDAO;
import com.dy.myeasynetcomment.data.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	DataDAO serverDAO;
	ArrayList<String> userFlagList=new ArrayList<>();//用户flag 即用户表的唯一标识
	ArrayList<String> postFlagList=new ArrayList<>();//帖子flag 即帖子的唯一标识
	ArrayList<String> commentFlagList=new ArrayList<>();//评论flag 即评论的唯一标识
	ArrayList<User> users=new ArrayList<>();//用户数据集

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		serverDAO=new DataDAO(this);
		setContentView(R.layout.activity_main);
		initUserData();
		initPostData();


	}
	/*
	创建10个不同的用户数据
	*/
	private void initUserData() {

		for (int i = 0; i < 10; i++) {
			User user = new User();
			ContentValues values = new ContentValues();
			values.put("flag", user.getFlag());
			values.put("userName", user.getUserName());
			values.put("nick", user.getNick());
			values.put("location", user.getLocation());
			serverDAO.add("user", values);

			//对象标识存储便于后续操作
			userFlagList.add(user.getFlag());

			users.add(user);
		}
	}
	/*
	创建100条帖子数据
	*/
	private void initPostData()
	{

		for (int i = 0; i < 100; i++) {
			Post post = new Post();
			ContentValues values = new ContentValues();
			values.put("flag", post.getFlag());
			values.put("createAt", post.getCreateAt());
			serverDAO.add("post", values);

			//对象标识存储便于后续操作
			postFlagList.add(post.getFlag());
		}
	}
	/*
	创建评论数据
	*/
	private void initCommentData()
	{

		for (int i = 0; i < 100; i++) {
			Comment comment = new Comment(String.valueOf(Math.random() * 100), users.get((int) (Math.random() * 10)));
			ContentValues values = new ContentValues();
			values.put("flag", comment.getFlag());
			values.put("userFlag", comment.getUser().getFlag());
			values.put("content", comment.getContent());
			values.put("createAt", comment.getCreateAt());
			serverDAO.add("comment", values);

			//对象标识存储便于后续操作
			commentFlagList.add(comment.getFlag());
		}
	}


}
