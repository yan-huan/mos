package com.myb.framework.data;

import java.util.List;
import java.util.Map;

public interface IDataCommand {

	public <T extends EntityBase> java.util.List<T> executeList(String sql, SqlParameter sqlParameter, Class<T> t);

	public <T extends EntityBase> java.util.List<T> executeList(String sql, Class<T> t);

	public Number insertAndGetKey(String sql, SqlParameter sqlParameter);

	public Number insertAndGetKey(String sql);

	public int executeNonQuery(String sql, SqlParameter sqlParameter);

	public int executeNonQuery(String sql);

	public <T> T executeScale(String sql, SqlParameter sqlParameter, Class<T> t) throws IllegalAccessException, InstantiationException;

	public <T> T executeScale(String sql, Class<T> t);

	public Map<String, Object> executeResultMap(String sql, SqlParameter sqlParameter);

	public Map<String, Object> executeMap(String sql, SqlParameter sqlParameter);

	public List<Map<String, Object>> executeList(String sql, SqlParameter sqlParameter);

	public <T extends EntityBase> T executeEntity(String sql, SqlParameter sqlParameter, Class<T> t);

}
