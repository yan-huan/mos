package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Area;
import com.myb.entity.pojo.mos.AreaMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

public class BaseDao<T>
{
   
    public T searchByAreaId(Object arg, int type, String tableName)
    {
        String sql="SELECT * FROM "+tableName+" WHERE areaId=@{areaId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AreaMapping.AreaId,arg);
        return null;
    }
}
