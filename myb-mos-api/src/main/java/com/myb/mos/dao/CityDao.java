package com.myb.mos.dao;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.City;
import com.myb.entity.pojo.mos.CityMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;



@Repository("cityDao")
public class CityDao extends MySqlCommandBase
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
        return "city";
    }


    public int insert(City city)
    {
        String sql="INSERT INTO "+getTableName()+" (cityId,cityshort,cityname,status,createTime,provinceId)VALUES(@{cityId},@{cityshort},@{cityname},@{status},@{createTime},@{provinceId})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CityMapping.CityId, city.getCityId());
        sqlParameter.add(CityMapping.Cityshort, city.getCityshort());
        sqlParameter.add(CityMapping.Cityname, city.getCityname());
        sqlParameter.add(CityMapping.Status, city.getStatus());
        sqlParameter.add(CityMapping.CreateTime, city.getCreateTime());
        sqlParameter.add(CityMapping.ProvinceId, city.getProvinceId());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(City city)
    {
        String sql="UPDATE "+getTableName()+" set cityshort=@{cityshort},cityname=@{cityname},status=@{status},createTime=@{createTime},provinceId=@{provinceId} WHERE cityId=@{cityId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CityMapping.CityId, city.getCityId());
        sqlParameter.add(CityMapping.Cityshort, city.getCityshort());
        sqlParameter.add(CityMapping.Cityname, city.getCityname());
        sqlParameter.add(CityMapping.Status, city.getStatus());
        sqlParameter.add(CityMapping.CreateTime, city.getCreateTime());
        sqlParameter.add(CityMapping.ProvinceId, city.getProvinceId());
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
        return this.dataCommand.executeEntity(sql, sqlParameter, City.class);
    }
    public City searchByCityName(String cityName)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE cityname=@{cityname}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CityMapping.Cityname,cityName);
        return this.dataCommand.executeEntity(sql, sqlParameter, City.class);
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
