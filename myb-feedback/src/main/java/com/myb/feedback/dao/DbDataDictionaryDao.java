package com.myb.feedback.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.entity.pojo.feedback.DbDataDictionaryMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("dbDataDictionaryDao")
public class DbDataDictionaryDao extends MySqlCommandBase
{

    @Resource(name = "datacommand")
    private DataCommand dataCommand;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommand);
    }
    @Override
    public String getTableName()
    {
        return "db_data_dictionary";
    }


    public int insert(DbDataDictionary dbDataDictionary)
    {
        String sql="INSERT INTO "+getTableName()+" (id,addTime,modifyTime,code,name,type)VALUES(@{id},@{addTime},@{modifyTime},@{code},@{name},@{type})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbDataDictionaryMapping.Id, dbDataDictionary.getId());
        sqlParameter.add(DbDataDictionaryMapping.AddTime, dbDataDictionary.getAddTime());
        sqlParameter.add(DbDataDictionaryMapping.ModifyTime, dbDataDictionary.getModifyTime());
        sqlParameter.add(DbDataDictionaryMapping.Code, dbDataDictionary.getCode());
        sqlParameter.add(DbDataDictionaryMapping.Name, dbDataDictionary.getName());
        sqlParameter.add(DbDataDictionaryMapping.Type, dbDataDictionary.getType());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(DbDataDictionary dbDataDictionary)
    {
        String sql="UPDATE "+getTableName()+" set addTime=@{addTime},modifyTime=@{modifyTime},code=@{code},name=@{name},type=@{type} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbDataDictionaryMapping.Id, dbDataDictionary.getId());
        sqlParameter.add(DbDataDictionaryMapping.AddTime, dbDataDictionary.getAddTime());
        sqlParameter.add(DbDataDictionaryMapping.ModifyTime, dbDataDictionary.getModifyTime());
        sqlParameter.add(DbDataDictionaryMapping.Code, dbDataDictionary.getCode());
        sqlParameter.add(DbDataDictionaryMapping.Name, dbDataDictionary.getName());
        sqlParameter.add(DbDataDictionaryMapping.Type, dbDataDictionary.getType());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbDataDictionaryMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public DbDataDictionary searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbDataDictionaryMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, DbDataDictionary.class);
    }
    public PagedList<DbDataDictionary> searchByPage(QueryCondition queryCondition) {
        PagedList<DbDataDictionary> pagedList=this.searchByPage(queryCondition, DbDataDictionary.class);
        return pagedList;
    }
    public List<DbDataDictionary> searchList(QueryParameter queryParameter) {
                List<DbDataDictionary> list=this.searchList(queryParameter, DbDataDictionary.class);
                    return list;
    }
}
