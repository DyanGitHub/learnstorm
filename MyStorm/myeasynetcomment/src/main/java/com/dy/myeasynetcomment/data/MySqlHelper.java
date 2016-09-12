package com.dy.myeasynetcomment.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 作者： Dyan on 2016/8/30 15:23
 * 描述：
 */
public class MySqlHelper extends SQLiteOpenHelper {
	public static final int mVersion=1;
	public static final String mName="myeasydata";
	public MySqlHelper(Context context)
	{
		this(context,null,null,0);
	}

	public MySqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
		super(context,mName , factory, mVersion);
	}
	/*
	  创建模型表SQL
	   */
	private static final String CREATE_TABLE_USER_SQL = "create table user(_id integer primary key autoincrement, flag varchar(16), userName varchar(16), nick integer, location varchar(32))";
	private static final String CREATE_TABLE_POST_SQL = "create table post(_id integer primary key autoincrement, flag varchar(16), createAt varchar(32))";
	private static final String CREATE_TABLE_COMMENT_SQL = "create table comment(_id integer primary key autoincrement, flag varchar(16), userFlag varchar(16), content varchar(1024), createAt varchar(32))";

	/*
	创建关联表SQL
	 */
	private static final String CREATE_TABLE_POST_AND_COMMENT_SQL = "create table post_comment(_id integer primary key autoincrement, postFlag varchar(16), commentFlag varchar(16))";
	private static final String CREATE_TABLE_USER_AND_PRAISE_SQL = "create table user_praise(_id integer primary key autoincrement, userFlag varchar(16), postFlag varchar(16))";
	private static final String CREATE_TABLE_USER_AND_UNPRAISE_SQL = "create table user_unpraise(_id integer primary key autoincrement, userFlag varchar(16), postFlag varchar(16))";
	private static final String CREATE_TABLE_USER_AND_COLLECT_SQL = "create table user_collect(_id integer primary key autoincrement, userFlag varchar(16), postFlag varchar(16))";
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_USER_SQL);
		db.execSQL(CREATE_TABLE_POST_SQL);
		db.execSQL(CREATE_TABLE_COMMENT_SQL);
		db.execSQL(CREATE_TABLE_POST_AND_COMMENT_SQL);
		db.execSQL(CREATE_TABLE_USER_AND_PRAISE_SQL);
		db.execSQL(CREATE_TABLE_USER_AND_UNPRAISE_SQL);
		db.execSQL(CREATE_TABLE_USER_AND_COLLECT_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
