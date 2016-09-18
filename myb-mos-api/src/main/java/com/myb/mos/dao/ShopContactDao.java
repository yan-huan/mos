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

import com.myb.entity.pojo.mos.ShopContact;

import com.myb.entity.pojo.mos.ShopContactMapping;

@Repository("shopContactDao")
public class ShopContactDao extends MySqlCommandBase
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
        return "shop_contact";
    }


    public int insert(ShopContact shopContact)
    {
        String sql="INSERT INTO "+getTableName()+" (id,shopId,name,telephone,wechat,duty)VALUES(@{id},@{shopId},@{name},@{telephone},@{wechat},@{duty})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopContactMapping.Id, shopContact.getId());
        sqlParameter.add(ShopContactMapping.ShopId, shopContact.getShopId());
        sqlParameter.add(ShopContactMapping.Name, shopContact.getName());
        sqlParameter.add(ShopContactMapping.Telephone, shopContact.getTelephone());
        sqlParameter.add(ShopContactMapping.Wechat, shopContact.getWechat());
        sqlParameter.add(ShopContactMapping.Duty, shopContact.getDuty());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(ShopContact shopContact)
    {
        String sql="UPDATE "+getTableName()+" set shopId=@{shopId},name=@{name},telephone=@{telephone},wechat=@{wechat},duty=@{duty} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopContactMapping.Id, shopContact.getId());
        sqlParameter.add(ShopContactMapping.ShopId, shopContact.getShopId());
        sqlParameter.add(ShopContactMapping.Name, shopContact.getName());
        sqlParameter.add(ShopContactMapping.Telephone, shopContact.getTelephone());
        sqlParameter.add(ShopContactMapping.Wechat, shopContact.getWechat());
        sqlParameter.add(ShopContactMapping.Duty, shopContact.getDuty());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(long id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopContactMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public ShopContact searchById(long id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopContactMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, ShopContact.class);
    }
    public PagedList<ShopContact> searchByPage(QueryCondition queryCondition) {
        PagedList<ShopContact> pagedList=this.searchByPage(queryCondition, ShopContact.class);
        return pagedList;
    }
    public List<ShopContact> searchList(QueryParameter queryParameter) {
                List<ShopContact> list=this.searchList(queryParameter, ShopContact.class);
                    return list;
    }
    public ShopContact searchByMobile(String mobile)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE telephone=@{telephone}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopContactMapping.Telephone,mobile);
        return this.dataCommand.executeEntity(sql, sqlParameter, ShopContact.class);
    }
}