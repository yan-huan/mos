package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.City;
import com.myb.entity.pojo.mos.CityMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("cityDao")
public class CityDao extends MySqlCommandBase
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
        return "city";
    }


    public int insert(City city)
    {
        String sql="INSERT INTO "+getTableName()+" (cityId,cityshort,cityname)VALUES(@{cityId},@{cityshort},@{cityname})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CityMapping.CityId, city.getCityId());
        sqlParameter.add(CityMapping.Cityshort, city.getCityshort());
        sqlParameter.add(CityMapping.Cityname, city.getCityname());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(City city)
    {
        String sql="UPDATE "+getTableName()+" set cityshort=@{cityshort},cityname=@{cityname} WHERE cityId=@{cityId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CityMapping.CityId, city.getCityId());
        sqlParameter.add(CityMapping.Cityshort, city.getCityshort());
        sqlParameter.add(CityMapping.Cityname, city.getCityname());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int cityId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE cityId=@{cityId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CityMapping.CityId,cityId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public City searchByCityId(int cityId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE cityId=@{cityId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CityMapping.CityId,cityId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, City.class);
    }
    public PagedList<City> searchByPage(QueryCondition queryCondition) {
        PagedList<City> pagedList=this.searchByPage(queryCondition, City.class);
        return pagedList;
    }
    public List<City> searchList(QueryParameter queryParameter) {
                List<City> list=this.searchList(queryParameter, City.class);
                    return list;
    }
}
