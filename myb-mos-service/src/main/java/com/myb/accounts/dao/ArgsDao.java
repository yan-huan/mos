package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Args;
import com.myb.entity.pojo.mos.ArgsMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("argsDao")
public class ArgsDao extends MySqlCommandBase
{

    @Resource(name = "datacommand_write")
    private DataCommand dataCommandWrite;
    
    @Resource(name = "datacommand_read")
    private DataCommand dataCommandRead;
    
    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName()
    {
        return "args";
    }


    public int insert(Args args)
    {
        String sql="INSERT INTO "+getTableName()+" (argId,argName,argType,status,argValue)VALUES(@{argId},@{argName},@{argType},@{status},@{argValue})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ArgsMapping.ArgId, args.getArgId());
        sqlParameter.add(ArgsMapping.ArgName, args.getArgName());
        sqlParameter.add(ArgsMapping.ArgType, args.getArgType());
        sqlParameter.add(ArgsMapping.Status, args.getStatus());
        sqlParameter.add(ArgsMapping.ArgValue, args.getArgValue());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Args args)
    {
        String sql="UPDATE "+getTableName()+" set argName=@{argName},argType=@{argType},status=@{status},argValue=@{argValue} WHERE argId=@{argId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ArgsMapping.ArgId, args.getArgId());
        sqlParameter.add(ArgsMapping.ArgName, args.getArgName());
        sqlParameter.add(ArgsMapping.ArgType, args.getArgType());
        sqlParameter.add(ArgsMapping.Status, args.getStatus());
        sqlParameter.add(ArgsMapping.ArgValue, args.getArgValue());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int argId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE argId=@{argId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ArgsMapping.ArgId,argId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Args searchByArgId(int argId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE argId=@{argId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ArgsMapping.ArgId,argId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Args.class);
    }
    public PagedList<Args> searchByPage(QueryCondition queryCondition) {
        PagedList<Args> pagedList=this.searchByPage(queryCondition, Args.class);
        return pagedList;
    }
    public List<Args> searchList(QueryParameter queryParameter) {
                List<Args> list=this.searchList(queryParameter, Args.class);
                    return list;
    }
    
}
