package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Shop;
import com.myb.entity.pojo.mos.ShopMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("shopDao")
public class ShopDao extends MySqlCommandBase
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
        return "shop";
    }


    public int insert(Shop shop)
    {
        String sql="INSERT INTO "+getTableName()+" (shopId,contractId,shopName,shopOwner,shopAccount,city,province,beginDate,endDate,duration,address,longitude,latitude,giveAway,createTime,business,accountId,shopcode,isChannel,currentRate,danjia,exceptionStatus,updateTime,ispass,refuse)VALUES(@{shopId},@{contractId},@{shopName},@{shopOwner},@{shopAccount},@{city},@{province},@{beginDate},@{endDate},@{duration},@{address},@{longitude},@{latitude},@{giveAway},@{createTime},@{business},@{accountId},@{shopcode},@{isChannel},@{currentRate},@{danjia},@{exceptionStatus},@{updateTime},@{ispass},@{refuse})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopMapping.ShopId, shop.getShopId());
        sqlParameter.add(ShopMapping.ContractId, shop.getContractId());
        sqlParameter.add(ShopMapping.ShopName, shop.getShopName());
        sqlParameter.add(ShopMapping.ShopOwner, shop.getShopOwner());
        sqlParameter.add(ShopMapping.ShopAccount, shop.getShopAccount());
        sqlParameter.add(ShopMapping.City, shop.getCity());
        sqlParameter.add(ShopMapping.Province, shop.getProvince());
        sqlParameter.add(ShopMapping.BeginDate, shop.getBeginDate());
        sqlParameter.add(ShopMapping.EndDate, shop.getEndDate());
        sqlParameter.add(ShopMapping.Duration, shop.getDuration());
        sqlParameter.add(ShopMapping.Address, shop.getAddress());
        sqlParameter.add(ShopMapping.Longitude, shop.getLongitude());
        sqlParameter.add(ShopMapping.Latitude, shop.getLatitude());
        sqlParameter.add(ShopMapping.GiveAway, shop.getGiveAway());
        sqlParameter.add(ShopMapping.CreateTime, shop.getCreateTime());
        sqlParameter.add(ShopMapping.Business, shop.getBusiness());
        sqlParameter.add(ShopMapping.AccountId, shop.getAccountId());
        sqlParameter.add(ShopMapping.Shopcode, shop.getShopcode());
        sqlParameter.add(ShopMapping.IsChannel, shop.getIsChannel());
        sqlParameter.add(ShopMapping.CurrentRate, shop.getCurrentRate());
        sqlParameter.add(ShopMapping.Danjia, shop.getDanjia());
        sqlParameter.add(ShopMapping.ExceptionStatus, shop.getExceptionStatus());
        sqlParameter.add(ShopMapping.UpdateTime, shop.getUpdateTime());
        sqlParameter.add(ShopMapping.Ispass, shop.getIspass());
        sqlParameter.add(ShopMapping.Refuse, shop.getRefuse());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Shop shop)
    {
        String sql="UPDATE "+getTableName()+" set contractId=@{contractId},shopName=@{shopName},shopOwner=@{shopOwner},shopAccount=@{shopAccount},city=@{city},province=@{province},beginDate=@{beginDate},endDate=@{endDate},duration=@{duration},address=@{address},longitude=@{longitude},latitude=@{latitude},giveAway=@{giveAway},createTime=@{createTime},business=@{business},accountId=@{accountId},shopcode=@{shopcode},isChannel=@{isChannel},currentRate=@{currentRate},danjia=@{danjia},exceptionStatus=@{exceptionStatus},updateTime=@{updateTime},ispass=@{ispass},refuse=@{refuse} WHERE shopId=@{shopId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopMapping.ShopId, shop.getShopId());
        sqlParameter.add(ShopMapping.ContractId, shop.getContractId());
        sqlParameter.add(ShopMapping.ShopName, shop.getShopName());
        sqlParameter.add(ShopMapping.ShopOwner, shop.getShopOwner());
        sqlParameter.add(ShopMapping.ShopAccount, shop.getShopAccount());
        sqlParameter.add(ShopMapping.City, shop.getCity());
        sqlParameter.add(ShopMapping.Province, shop.getProvince());
        sqlParameter.add(ShopMapping.BeginDate, shop.getBeginDate());
        sqlParameter.add(ShopMapping.EndDate, shop.getEndDate());
        sqlParameter.add(ShopMapping.Duration, shop.getDuration());
        sqlParameter.add(ShopMapping.Address, shop.getAddress());
        sqlParameter.add(ShopMapping.Longitude, shop.getLongitude());
        sqlParameter.add(ShopMapping.Latitude, shop.getLatitude());
        sqlParameter.add(ShopMapping.GiveAway, shop.getGiveAway());
        sqlParameter.add(ShopMapping.CreateTime, shop.getCreateTime());
        sqlParameter.add(ShopMapping.Business, shop.getBusiness());
        sqlParameter.add(ShopMapping.AccountId, shop.getAccountId());
        sqlParameter.add(ShopMapping.Shopcode, shop.getShopcode());
        sqlParameter.add(ShopMapping.IsChannel, shop.getIsChannel());
        sqlParameter.add(ShopMapping.CurrentRate, shop.getCurrentRate());
        sqlParameter.add(ShopMapping.Danjia, shop.getDanjia());
        sqlParameter.add(ShopMapping.ExceptionStatus, shop.getExceptionStatus());
        sqlParameter.add(ShopMapping.UpdateTime, shop.getUpdateTime());
        sqlParameter.add(ShopMapping.Ispass, shop.getIspass());
        sqlParameter.add(ShopMapping.Refuse, shop.getRefuse());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int shopId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE shopId=@{shopId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopMapping.ShopId,shopId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Shop searchByShopId(int shopId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE shopId=@{shopId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopMapping.ShopId,shopId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Shop.class);
    }
    public PagedList<Shop> searchByPage(QueryCondition queryCondition) {
        PagedList<Shop> pagedList=this.searchByPage(queryCondition, Shop.class);
        return pagedList;
    }
    public List<Shop> searchList(QueryParameter queryParameter) {
                List<Shop> list=this.searchList(queryParameter, Shop.class);
                    return list;
    }
}
