package com.dy.myeasynetcomment.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者： Dyan on 2016/8/30 15:30
 * 描述： 具体实现对数据库的操作
 */
public class DataDAO implements IDataDAO {
	SQLiteOpenHelper mSQLiteOpenHelper;

	public DataDAO(Context context) {
		mSQLiteOpenHelper = new MySqlHelper(context);
	}

	@Override
	public boolean add(String table, ContentValues values) {
		SQLiteDatabase db = null;
		boolean flag = false;
		try {
			db = mSQLiteOpenHelper.getWritableDatabase();
			long id = db.insert(table, null, values);
			flag = id != -1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null)
				db.close();

		}

		return flag;
	}

	@Override
	public boolean add(String sql) {
		return false;
	}

	@Override
	public List<Map<String, String>> queryMulti(String table, String[] columns, String whereClause, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		List<Map<String, String>> result=new ArrayList<>();
		SQLiteDatabase db=null;
		try{
			db=mSQLiteOpenHelper.getWritableDatabase();
		}catch (Exception e)
		{
			Cursor cursor=db.query(table,columns,whereClause,selectionArgs,groupBy,having,orderBy,limit);
			while (cursor.moveToNext())
			{
				Map<String,String> map=new HashMap<>();
				for(int i=0;i<cursor.getColumnCount();i++)
				{
					String name=cursor.getColumnName(i);
					int index=cursor.getColumnIndex(name);
					if(index==i)
					Log.d("dy", "sqlite index==i");
					map.put(name,cursor.getString(index));
				}
				result.add(map);
			}
			e.printStackTrace();
		}finally {
			db.close();
		}
		return result;
	}

	@Override
	public List<Map<String, String>> queryMulti(String sql) {
		return null;
	}

	@Override
	public Map<String, String> querySingle(String table, String[] columns, String flag, String groupBy, String having, String orderBy, String limit) {

		Map<String, String> map = new HashMap<String, String>();
		SQLiteDatabase db = null;
		Cursor cursor;
		try {
			db = mSQLiteOpenHelper.getWritableDatabase();
			cursor = db.query(table, columns, "flag like ?", new String[]{flag}, groupBy, having, orderBy, limit);
			while (cursor.moveToNext()) {
				for (int i = 0; i < cursor.getColumnCount(); i++) {
					String columnName = cursor.getColumnName(i);
					String columnValue = cursor.getString(cursor.getColumnIndex(columnName));
					map.put(columnName, columnValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != db) {
				db.close();
			}
		}
		return map;
	}

	@Override
	public Map<String, String> querySingle(String sql) {
		return null;
	}

	@Override
	public String queryValue(String table, String[] columns, String key, String value) {
		return null;
	}

	@Override
	public String queryValue(String sql) {
		return null;
	}
}
