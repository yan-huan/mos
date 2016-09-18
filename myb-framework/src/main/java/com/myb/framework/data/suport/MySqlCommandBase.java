package com.myb.framework.data.suport;

import java.util.List;

import com.myb.framework.data.*;
import com.myb.framework.util.StringUtil;

public abstract class MySqlCommandBase {
	
	public abstract String getTableName();
	
	private DataCommand dataCommand;

	public DataCommand getDataCommand() {
		return dataCommand;
	}

	public void setDataCommand(DataCommand dataCommand) {
		this.dataCommand = dataCommand;
	}

	public int insert(UpdateParameter updateParameter)
	{
		return this.insert(updateParameter,this.dataCommand);
	}

	public int insert(UpdateParameter updateParameter,DataCommand newDataCommand)
	{
		int result=0;
		SqlParameterForInsert sqlParameterForInsert=new SqlParameterForInsert(updateParameter);

		String sql=sqlParameterForInsert.getSql();

		if(!StringUtil.isNullOrEmpty(sql))
		{
			sql=String.format("INSERT INTO  %s %s",getTableName(),sql);
			result=newDataCommand.executeNonQuery(sql,sqlParameterForInsert.getSqlParameter());
		}
		return result;
	}

	public int update(UpdateParameter updateParameter)
	{
		return this.update(updateParameter,this.dataCommand);
	}
	public int update(UpdateParameter updateParameter,DataCommand newDataCommand)
	{
		int result=0;
		SqlParameterForUpdate sqlParameterForUpdate=new SqlParameterForUpdate(updateParameter);

		String sql=sqlParameterForUpdate.getSql();

		if(!StringUtil.isNullOrEmpty(sql))
		{
			sql=String.format("UPDATE %s SET  %s",getTableName(),sql);
			result=newDataCommand.executeNonQuery(sql,sqlParameterForUpdate.getSqlParameter());
		}
		return result;
	}
	public int delete(QueryParameter queryParameter)
	{
		return this.delete(queryParameter,this.dataCommand);
	}
	@SuppressWarnings("unused")
	public int delete(QueryParameter queryParameter,DataCommand newDataCommand)
	{
		int result=0;
		SqlParameterForQuery sqlParameterForQuery =new SqlParameterForQuery(queryParameter);
		String where= sqlParameterForQuery.getSql();
		SqlParameter sqlParameter= sqlParameterForQuery.getSqlParameter();
		String sql="DELETE FROM "+this.getTableName() +" "+where;
		result=newDataCommand.executeNonQuery(sql,sqlParameterForQuery.getSqlParameter());
		return result;
	}

	public <T extends EntityBase> PagedList<T> searchByPage(QueryCondition queryCondition,Class<T> t) {
		return searchByPage(queryCondition,t,this.dataCommand);
	}
	public <T extends EntityBase> PagedList<T> searchByPage(QueryCondition queryCondition,Class<T> t,DataCommand newDataCommand)
	{
		return searchByPage(queryCondition,getTableName(),t,newDataCommand);
	}

	public <T extends EntityBase> List<T> searchList(QueryParameter queryParameter,Class<T> t)
	{
		return this.searchList(queryParameter,t,this.dataCommand);
	}
	
	public <T extends EntityBase> List<T> searchList(QueryParameter queryParameter,Class<T> t,DataCommand newDataCommand)
	{
		return searchList(queryParameter,getTableName(),t,newDataCommand);
	}

	public <T extends EntityBase> List<T> searchList(QueryParameter queryParameter,String tableName,Class<T> t)
	{
		return this.searchList(queryParameter,tableName,t,this.dataCommand);
	}
	
	public <T extends EntityBase> List<T> searchList(QueryParameter queryParameter,String tableName,Class<T> t,DataCommand newDataCommand)
	{
		SqlParameterForQuery sqlParameterForQuery =new SqlParameterForQuery(queryParameter);
		String where= sqlParameterForQuery.getSql();
		SqlParameter sqlParameter= sqlParameterForQuery.getSqlParameter();
		String sql="SELECT * FROM "+tableName +" "+where;
		List<T> content=newDataCommand.executeList(sql,sqlParameter,t);
		return content;
		
	}
	
	
	public <T extends EntityBase> T searchEntity(QueryParameter queryParameter, Class<T> t) {
		return this.searchEntity(queryParameter, t, this.dataCommand);
	}
	
	public <T extends EntityBase> T searchEntity(QueryParameter queryParameter, Class<T> t, DataCommand newDataCommand) {
		return searchEntity(queryParameter, getTableName(), t, newDataCommand);
	}
	
	public <T extends EntityBase> T searchEntity(QueryParameter queryParameter,String tableName,Class<T> t) {
		return this.searchEntity(queryParameter, tableName, t, this.dataCommand);
	}
	
	public <T extends EntityBase> T searchEntity(QueryParameter queryParameter,String tableName,Class<T> t,DataCommand newDataCommand) {
		SqlParameterForQuery sqlParameterForQuery =new SqlParameterForQuery(queryParameter);
		String where= sqlParameterForQuery.getSql();
		SqlParameter sqlParameter= sqlParameterForQuery.getSqlParameter();
		String sql="SELECT * FROM "+tableName +" "+where;
		T tEntity =newDataCommand.executeEntity(sql,sqlParameter,t);
		return tEntity;
	}

	public <T extends EntityBase> PagedList<T> searchByPage(QueryCondition queryCondition,String tableName,Class<T> t)
	{
		return this.searchByPage(queryCondition,tableName,t,this.dataCommand);
	}
	
	public <T extends EntityBase> PagedList<T> searchByPage(QueryCondition queryCondition,String tableName,Class<T> t,DataCommand newDataCommand)
	{
		int start=(queryCondition.getPageIndex()-1)*queryCondition.getPageSize();
		SqlParameterForQuery sqlParameterForQuery =new SqlParameterForQuery(queryCondition.getQueryParameter());
		String sqlLimt=" LIMIT "+start+","+queryCondition.getPageSize();
		String where= sqlParameterForQuery.getSql();
		String order=queryCondition.getSortParameter().toSql();
		String sql="SELECT * FROM "+tableName +" "+where+order+sqlLimt;
		String sqlCount="SELECT Count(*) FROM "+tableName +" "+where;
		
		SqlParameter sqlParameter= sqlParameterForQuery.getSqlParameter();
		List<T> content=newDataCommand.executeList(sql,sqlParameter,t);
		int recordCount=newDataCommand.executeScale(sqlCount, sqlParameter, Integer.class);
		PagedList<T> pagedList=new PagedList<T>(queryCondition.getPageIndex(), queryCondition.getPageSize(), recordCount, content);
		return pagedList;
	}

	public <T extends EntityBase> PagedList<T> searchByPage(int pageIndex,int pageSize,String tableName,SqlParameter sqlParameter,Class<T> t)
	{
		return this.searchByPage(pageIndex,pageSize,tableName,sqlParameter,t,this.dataCommand);
	}
	
	public <T extends EntityBase> PagedList<T> searchByPage(int pageIndex,int pageSize,String tableName,SqlParameter sqlParameter,Class<T> t,DataCommand newDataCommand)
	{
		int start=(pageIndex-1)*pageSize;
		String sqlLimt=" LIMIT "+start+","+pageSize;
		String sql="SELECT * FROM "+tableName +" "+sqlLimt;
		String sqlCount="SELECT Count(*) FROM "+tableName ;
		List<T> content=newDataCommand.executeList(sql,sqlParameter,t);
		int recordCount=newDataCommand.executeScale(sqlCount, sqlParameter, Integer.class);
		PagedList<T> pagedList=new PagedList<T>(pageIndex, pageSize, recordCount, content);
		return pagedList;
	}
	
	
	
	
	//distinct
	public <T extends EntityBase> List<T> searchListDistince(QueryCondition queryCondition,Class<T> t,String column)
	{
		return this.searchListDistince(queryCondition,t,this.dataCommand ,column);
	}
	
	public <T extends EntityBase> List<T> searchListDistince(QueryCondition queryCondition,Class<T> t,DataCommand newDataCommand,String column)
	{
		return searchListDistince(queryCondition,getTableName(),t,newDataCommand,column);
	}

	
	public <T extends EntityBase> List<T> searchListDistince(QueryCondition queryCondition,String tableName,Class<T> t,DataCommand newDataCommand,String tableColumn)
	{
		SqlParameterForQuery sqlParameterForQuery =new SqlParameterForQuery(queryCondition.getQueryParameter());
		String where= sqlParameterForQuery.getSql();
		SqlParameter sqlParameter= sqlParameterForQuery.getSqlParameter();
		String sql="SELECT distinct "+tableColumn+" as market FROM "+tableName +" "+where;
		List<T> content=newDataCommand.executeList(sql,sqlParameter,t);
		return content;
		
	}
}
