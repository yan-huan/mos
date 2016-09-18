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

@Repository("areaDao")
public class AreaDao extends MySqlCommandBase
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
        return "area";
    }


    public int insert(Area area)
    {
        String sql="INSERT INTO "+getTableName()+" (areaId,cityId,areaName)VALUES(@{areaId},@{cityId},@{areaName})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AreaMapping.AreaId, area.getAreaId());
        sqlParameter.add(AreaMapping.CityId, area.getCityId());
        sqlParameter.add(AreaMapping.AreaName, area.getAreaName());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Area area)
    {
        String sql="UPDATE "+getTableName()+" set cityId=@{cityId},areaName=@{areaName} WHERE areaId=@{areaId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AreaMapping.AreaId, area.getAreaId());
        sqlParameter.add(AreaMapping.CityId, area.getCityId());
        sqlParameter.add(AreaMapping.AreaName, area.getAreaName());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int areaId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE areaId=@{areaId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AreaMapping.AreaId,areaId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Area searchByAreaId(int areaId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE areaId=@{areaId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AreaMapping.AreaId,areaId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Area.class);
    }
    public PagedList<Area> searchByPage(QueryCondition queryCondition) {
        PagedList<Area> pagedList=this.searchByPage(queryCondition, Area.class);
        return pagedList;
    }
    public List<Area> searchList(QueryParameter queryParameter) {
                List<Area> list=this.searchList(queryParameter, Area.class);
                    return list;
    }
}
