package com.myb.mos.dao;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

import com.myb.entity.pojo.mos.FreshShop;

import com.myb.entity.pojo.mos.FreshShopMapping;

@Repository("freshShopDao")
public class FreshShopDao extends MySqlCommandBase
{

    @Resource(name = "datacommand")
    private DataCommand dataCommand;
    
    @Resource(name = "datacommand_read")
    private DataCommand dataCommandRead;
    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommand);
    }
    @Override
    public String getTableName()
    {
        return "fresh_shop";
    }


    public Long insert(FreshShop freshShop)
    {
        String sql="INSERT INTO "+getTableName()+" (id,name,cityId,businessArea,isLink,isArea,address,linkNum,telephone,source,isPublic,employeeId,visitTimes,isFinish,process,createTime,latitude,longitude)VALUES(@{id},@{name},@{cityId},@{businessArea},@{isLink},@{isArea},@{address},@{linkNum},@{telephone},@{source},@{isPublic},@{employeeId},@{visitTimes},@{isFinish},@{process},@{createTime},@{latitude},@{longitude})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(FreshShopMapping.Id, freshShop.getId());
        sqlParameter.add(FreshShopMapping.Name, freshShop.getName());
        sqlParameter.add(FreshShopMapping.CityId, freshShop.getCityId());
        sqlParameter.add(FreshShopMapping.BusinessArea, freshShop.getBusinessArea());
        sqlParameter.add(FreshShopMapping.IsLink, freshShop.getIsLink());
        sqlParameter.add(FreshShopMapping.IsArea, freshShop.getIsArea());
        sqlParameter.add(FreshShopMapping.Address, freshShop.getAddress());
        sqlParameter.add(FreshShopMapping.LinkNum, freshShop.getLinkNum());
        sqlParameter.add(FreshShopMapping.Telephone, freshShop.getTelephone());
        sqlParameter.add(FreshShopMapping.Source, freshShop.getSource());
        sqlParameter.add(FreshShopMapping.IsPublic, freshShop.getIsPublic());
        sqlParameter.add(FreshShopMapping.EmployeeId, freshShop.getEmployeeId());
        sqlParameter.add(FreshShopMapping.VisitTimes, freshShop.getVisitTimes());
        sqlParameter.add(FreshShopMapping.IsFinish, freshShop.getIsFinish());
        sqlParameter.add(FreshShopMapping.Process, freshShop.getProcess());
        sqlParameter.add(FreshShopMapping.CreateTime, freshShop.getCreateTime());
        sqlParameter.add(FreshShopMapping.Latitude, freshShop.getLatitude());
        sqlParameter.add(FreshShopMapping.Longitude, freshShop.getLongitude());
        return this.getDataCommand().insertAndGetKey(sql, sqlParameter).longValue();
    }

    public int update(FreshShop freshShop)
    {
        String sql="UPDATE "+getTableName()+" set name=@{name},cityId=@{cityId},businessArea=@{businessArea},isLink=@{isLink},isArea=@{isArea},address=@{address},linkNum=@{linkNum},telephone=@{telephone},source=@{source},isPublic=@{isPublic},employeeId=@{employeeId},visitTimes=@{visitTimes},isFinish=@{isFinish},process=@{process},createTime=@{createTime},latitude=@{latitude},longitude=@{longitude} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(FreshShopMapping.Id, freshShop.getId());
        sqlParameter.add(FreshShopMapping.Name, freshShop.getName());
        sqlParameter.add(FreshShopMapping.CityId, freshShop.getCityId());
        sqlParameter.add(FreshShopMapping.BusinessArea, freshShop.getBusinessArea());
        sqlParameter.add(FreshShopMapping.IsLink, freshShop.getIsLink());
        sqlParameter.add(FreshShopMapping.IsArea, freshShop.getIsArea());
        sqlParameter.add(FreshShopMapping.Address, freshShop.getAddress());
        sqlParameter.add(FreshShopMapping.LinkNum, freshShop.getLinkNum());
        sqlParameter.add(FreshShopMapping.Telephone, freshShop.getTelephone());
        sqlParameter.add(FreshShopMapping.Source, freshShop.getSource());
        sqlParameter.add(FreshShopMapping.IsPublic, freshShop.getIsPublic());
        sqlParameter.add(FreshShopMapping.EmployeeId, freshShop.getEmployeeId());
        sqlParameter.add(FreshShopMapping.VisitTimes, freshShop.getVisitTimes());
        sqlParameter.add(FreshShopMapping.IsFinish, freshShop.getIsFinish());
        sqlParameter.add(FreshShopMapping.Process, freshShop.getProcess());
        sqlParameter.add(FreshShopMapping.CreateTime, freshShop.getCreateTime());
        sqlParameter.add(FreshShopMapping.Latitude, freshShop.getLatitude());
        sqlParameter.add(FreshShopMapping.Longitude, freshShop.getLongitude());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(long id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(FreshShopMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public FreshShop searchById(long id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(FreshShopMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, FreshShop.class);
    }
    public PagedList<FreshShop> searchByPage(QueryCondition queryCondition) {
        PagedList<FreshShop> pagedList=this.searchByPage(queryCondition, FreshShop.class);
        return pagedList;
    }
    public List<FreshShop> searchList(QueryParameter queryParameter) {
                List<FreshShop> list=this.searchList(queryParameter, FreshShop.class);
                    return list;
    }
    /**
     * 根据名称查找美容院
     * @param mobile
     * @return
     */
    public FreshShop searchByShopName(String shopName)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE name=@{name}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(FreshShopMapping.Name,shopName);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, FreshShop.class);
    }
  
}
