package com.dy.myeasynetcomment.data;

import android.content.ContentValues;

import java.util.List;
import java.util.Map;

/**
 * 作者： Dyan on 2016/8/30 15:27
 * 描述：对于数据库的数据操作
 */
public interface IDataDAO  {
	//增
	/**
	 * 根据参数添加一条数据
	 *
	 * @param table  数据要添加到的表名
	 * @param values 数据对象
	 * @return 布尔值代表数据添加成功与否
	 */
	public boolean add(String table, ContentValues values);

	/**
	 * 根据SQL语句添加一条数据
	 *
	 * @param sql SQL语句
	 * @return 布尔值代表数据添加成功与否
	 */
	public boolean add(String sql);

	/**
	 * 根据条件参数多条数据查询
	 *
	 * @param table         要查询的数据所在的表名
	 * @param columns       要查询的列名
	 * @param whereClause   查询的条件子句
	 * @param selectionArgs 条件子句占位符的参数
	 * @param groupBy       分组控制
	 * @param having        分组过滤
	 * @param orderBy       排序
	 * @param limit         分页
	 * @return 数据列表
	 */
	public List<Map<String, String>> queryMulti(String table, String[] columns, String whereClause, String[] selectionArgs, String groupBy, String having, String orderBy, String limit);

	/**
	 * 根据SQL语句多条数据查询
	 *
	 * @param sql SQL语句
	 * @return 数据列表
	 */
	public List<Map<String, String>> queryMulti(String sql);

	/**
	 * 根据条件参数单条数据查询
	 *
	 * @param table   要查询的数据所在的表名
	 * @param columns 要查询的列名
	 * @param flag    唯一标识值
	 * @param groupBy 分组控制
	 * @param having  分组过滤
	 * @param orderBy 排序
	 * @param limit   分页
	 * @return 单条
	 */
	public Map<String, String> querySingle(String table, String[] columns, String flag, String groupBy, String having, String orderBy, String limit);

	/**
	 * 根据SQL语句单条数据查询
	 *
	 * @param sql SQL语句
	 * @return 单条数据
	 */
	public Map<String, String> querySingle(String sql);

	/**
	 * 根据条件查询单个值
	 *
	 * @param table   要查询的数据所在的表名
	 * @param columns 要查询的列名
	 * @param key     查询的依据的列名
	 * @param value   查询依据值
	 * @return 查询结果
	 */
	public String queryValue(String table, String[] columns, String key, String value);

	/**
	 * 根据SQL语句查询单个值
	 *
	 * @param sql SQL语句
	 * @return 查询结果
	 */
	public String queryValue(String sql);
}
