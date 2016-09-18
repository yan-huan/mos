package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Recordlogs;
import com.myb.entity.pojo.mos.RecordlogsMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("recordlogsDao")
public class RecordlogsDao extends MySqlCommandBase
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
        return "recordlogs";
    }


    public int insert(Recordlogs recordlogs)
    {
        String sql="INSERT INTO "+getTableName()+" (logsId,mobile,remark,status,createTime,operationUser,updateTime,addInfoUser,openShopAmount,payDate,beautifulYard,provinceCode,cityCode,zongbuAddress,provinceCodeShop,cityCodeShop,startDate,endDate,shopName,detailAddressShop,type,market,companyCode,shopCode,duration,accountId,giveAway)VALUES(@{logsId},@{mobile},@{remark},@{status},@{createTime},@{operationUser},@{updateTime},@{addInfoUser},@{openShopAmount},@{payDate},@{beautifulYard},@{provinceCode},@{cityCode},@{zongbuAddress},@{provinceCodeShop},@{cityCodeShop},@{startDate},@{endDate},@{shopName},@{detailAddressShop},@{type},@{market},@{companyCode},@{shopCode},@{duration},@{accountId},@{giveAway})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RecordlogsMapping.LogsId, recordlogs.getLogsId());
        sqlParameter.add(RecordlogsMapping.Mobile, recordlogs.getMobile());
        sqlParameter.add(RecordlogsMapping.Remark, recordlogs.getRemark());
        sqlParameter.add(RecordlogsMapping.Status, recordlogs.getStatus());
        sqlParameter.add(RecordlogsMapping.CreateTime, recordlogs.getCreateTime());
        sqlParameter.add(RecordlogsMapping.OperationUser, recordlogs.getOperationUser());
        sqlParameter.add(RecordlogsMapping.UpdateTime, recordlogs.getUpdateTime());
        sqlParameter.add(RecordlogsMapping.AddInfoUser, recordlogs.getAddInfoUser());
        sqlParameter.add(RecordlogsMapping.OpenShopAmount, recordlogs.getOpenShopAmount());
        sqlParameter.add(RecordlogsMapping.PayDate, recordlogs.getPayDate());
        sqlParameter.add(RecordlogsMapping.BeautifulYard, recordlogs.getBeautifulYard());
        sqlParameter.add(RecordlogsMapping.ProvinceCode, recordlogs.getProvinceCode());
        sqlParameter.add(RecordlogsMapping.CityCode, recordlogs.getCityCode());
        sqlParameter.add(RecordlogsMapping.ZongbuAddress, recordlogs.getZongbuAddress());
        sqlParameter.add(RecordlogsMapping.ProvinceCodeShop, recordlogs.getProvinceCodeShop());
        sqlParameter.add(RecordlogsMapping.CityCodeShop, recordlogs.getCityCodeShop());
        sqlParameter.add(RecordlogsMapping.StartDate, recordlogs.getStartDate());
        sqlParameter.add(RecordlogsMapping.EndDate, recordlogs.getEndDate());
        sqlParameter.add(RecordlogsMapping.ShopName, recordlogs.getShopName());
        sqlParameter.add(RecordlogsMapping.DetailAddressShop, recordlogs.getDetailAddressShop());
        sqlParameter.add(RecordlogsMapping.Type, recordlogs.getType());
        sqlParameter.add(RecordlogsMapping.Market, recordlogs.getMarket());
        sqlParameter.add(RecordlogsMapping.CompanyCode, recordlogs.getCompanyCode());
        sqlParameter.add(RecordlogsMapping.ShopCode, recordlogs.getShopCode());
        sqlParameter.add(RecordlogsMapping.Duration, recordlogs.getDuration());
        sqlParameter.add(RecordlogsMapping.AccountId, recordlogs.getAccountId());
        sqlParameter.add(RecordlogsMapping.GiveAway, recordlogs.getGiveAway());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Recordlogs recordlogs)
    {
        String sql="UPDATE "+getTableName()+" set mobile=@{mobile},remark=@{remark},status=@{status},createTime=@{createTime},operationUser=@{operationUser},updateTime=@{updateTime},addInfoUser=@{addInfoUser},openShopAmount=@{openShopAmount},payDate=@{payDate},beautifulYard=@{beautifulYard},provinceCode=@{provinceCode},cityCode=@{cityCode},zongbuAddress=@{zongbuAddress},provinceCodeShop=@{provinceCodeShop},cityCodeShop=@{cityCodeShop},startDate=@{startDate},endDate=@{endDate},shopName=@{shopName},detailAddressShop=@{detailAddressShop},type=@{type},market=@{market},companyCode=@{companyCode},shopCode=@{shopCode},duration=@{duration},accountId=@{accountId},giveAway=@{giveAway} WHERE logsId=@{logsId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RecordlogsMapping.LogsId, recordlogs.getLogsId());
        sqlParameter.add(RecordlogsMapping.Mobile, recordlogs.getMobile());
        sqlParameter.add(RecordlogsMapping.Remark, recordlogs.getRemark());
        sqlParameter.add(RecordlogsMapping.Status, recordlogs.getStatus());
        sqlParameter.add(RecordlogsMapping.CreateTime, recordlogs.getCreateTime());
        sqlParameter.add(RecordlogsMapping.OperationUser, recordlogs.getOperationUser());
        sqlParameter.add(RecordlogsMapping.UpdateTime, recordlogs.getUpdateTime());
        sqlParameter.add(RecordlogsMapping.AddInfoUser, recordlogs.getAddInfoUser());
        sqlParameter.add(RecordlogsMapping.OpenShopAmount, recordlogs.getOpenShopAmount());
        sqlParameter.add(RecordlogsMapping.PayDate, recordlogs.getPayDate());
        sqlParameter.add(RecordlogsMapping.BeautifulYard, recordlogs.getBeautifulYard());
        sqlParameter.add(RecordlogsMapping.ProvinceCode, recordlogs.getProvinceCode());
        sqlParameter.add(RecordlogsMapping.CityCode, recordlogs.getCityCode());
        sqlParameter.add(RecordlogsMapping.ZongbuAddress, recordlogs.getZongbuAddress());
        sqlParameter.add(RecordlogsMapping.ProvinceCodeShop, recordlogs.getProvinceCodeShop());
        sqlParameter.add(RecordlogsMapping.CityCodeShop, recordlogs.getCityCodeShop());
        sqlParameter.add(RecordlogsMapping.StartDate, recordlogs.getStartDate());
        sqlParameter.add(RecordlogsMapping.EndDate, recordlogs.getEndDate());
        sqlParameter.add(RecordlogsMapping.ShopName, recordlogs.getShopName());
        sqlParameter.add(RecordlogsMapping.DetailAddressShop, recordlogs.getDetailAddressShop());
        sqlParameter.add(RecordlogsMapping.Type, recordlogs.getType());
        sqlParameter.add(RecordlogsMapping.Market, recordlogs.getMarket());
        sqlParameter.add(RecordlogsMapping.CompanyCode, recordlogs.getCompanyCode());
        sqlParameter.add(RecordlogsMapping.ShopCode, recordlogs.getShopCode());
        sqlParameter.add(RecordlogsMapping.Duration, recordlogs.getDuration());
        sqlParameter.add(RecordlogsMapping.AccountId, recordlogs.getAccountId());
        sqlParameter.add(RecordlogsMapping.GiveAway, recordlogs.getGiveAway());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int logsId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE logsId=@{logsId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RecordlogsMapping.LogsId,logsId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Recordlogs searchByLogsId(int logsId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE logsId=@{logsId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RecordlogsMapping.LogsId,logsId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Recordlogs.class);
    }
    public PagedList<Recordlogs> searchByPage(QueryCondition queryCondition) {
        PagedList<Recordlogs> pagedList=this.searchByPage(queryCondition, Recordlogs.class);
        return pagedList;
    }
    public List<Recordlogs> searchList(QueryParameter queryParameter) {
                List<Recordlogs> list=this.searchList(queryParameter, Recordlogs.class);
                    return list;
    }
}
