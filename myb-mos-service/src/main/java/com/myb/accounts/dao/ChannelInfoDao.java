package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.ChannelInfo;
import com.myb.entity.pojo.mos.ChannelInfoMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("channelInfoDao")
public class ChannelInfoDao extends MySqlCommandBase
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
        return "channel_info";
    }


    public int insert(ChannelInfo channelInfo)
    {
        String sql="INSERT INTO "+getTableName()+" (channelId,companyName,companyAddress,personInCharge,phone,readyDepositMoney,marginMoney,openTime,endTime,remark,status,createTime,updateTime,contractMoney,empId,discountRate,salesName,depositPaymentMoney)VALUES(@{channelId},@{companyName},@{companyAddress},@{personInCharge},@{phone},@{readyDepositMoney},@{marginMoney},@{openTime},@{endTime},@{remark},@{status},@{createTime},@{updateTime},@{contractMoney},@{empId},@{discountRate},@{salesName},@{depositPaymentMoney})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ChannelInfoMapping.ChannelId, channelInfo.getChannelId());
        sqlParameter.add(ChannelInfoMapping.CompanyName, channelInfo.getCompanyName());
        sqlParameter.add(ChannelInfoMapping.CompanyAddress, channelInfo.getCompanyAddress());
        sqlParameter.add(ChannelInfoMapping.PersonInCharge, channelInfo.getPersonInCharge());
        sqlParameter.add(ChannelInfoMapping.Phone, channelInfo.getPhone());
        sqlParameter.add(ChannelInfoMapping.ReadyDepositMoney, channelInfo.getReadyDepositMoney());
        sqlParameter.add(ChannelInfoMapping.MarginMoney, channelInfo.getMarginMoney());
        sqlParameter.add(ChannelInfoMapping.OpenTime, channelInfo.getOpenTime());
        sqlParameter.add(ChannelInfoMapping.EndTime, channelInfo.getEndTime());
        sqlParameter.add(ChannelInfoMapping.Remark, channelInfo.getRemark());
        sqlParameter.add(ChannelInfoMapping.Status, channelInfo.getStatus());
        sqlParameter.add(ChannelInfoMapping.CreateTime, channelInfo.getCreateTime());
        sqlParameter.add(ChannelInfoMapping.UpdateTime, channelInfo.getUpdateTime());
        sqlParameter.add(ChannelInfoMapping.ContractMoney, channelInfo.getContractMoney());
        sqlParameter.add(ChannelInfoMapping.EmpId, channelInfo.getEmpId());
        sqlParameter.add(ChannelInfoMapping.DiscountRate, channelInfo.getDiscountRate());
        sqlParameter.add(ChannelInfoMapping.SalesName, channelInfo.getSalesName());
        sqlParameter.add(ChannelInfoMapping.DepositPaymentMoney, channelInfo.getDepositPaymentMoney());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(ChannelInfo channelInfo)
    {
        String sql="UPDATE "+getTableName()+" set companyName=@{companyName},companyAddress=@{companyAddress},personInCharge=@{personInCharge},phone=@{phone},readyDepositMoney=@{readyDepositMoney},marginMoney=@{marginMoney},openTime=@{openTime},endTime=@{endTime},remark=@{remark},status=@{status},createTime=@{createTime},updateTime=@{updateTime},contractMoney=@{contractMoney},empId=@{empId},discountRate=@{discountRate},salesName=@{salesName},depositPaymentMoney=@{depositPaymentMoney} WHERE channelId=@{channelId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ChannelInfoMapping.ChannelId, channelInfo.getChannelId());
        sqlParameter.add(ChannelInfoMapping.CompanyName, channelInfo.getCompanyName());
        sqlParameter.add(ChannelInfoMapping.CompanyAddress, channelInfo.getCompanyAddress());
        sqlParameter.add(ChannelInfoMapping.PersonInCharge, channelInfo.getPersonInCharge());
        sqlParameter.add(ChannelInfoMapping.Phone, channelInfo.getPhone());
        sqlParameter.add(ChannelInfoMapping.ReadyDepositMoney, channelInfo.getReadyDepositMoney());
        sqlParameter.add(ChannelInfoMapping.MarginMoney, channelInfo.getMarginMoney());
        sqlParameter.add(ChannelInfoMapping.OpenTime, channelInfo.getOpenTime());
        sqlParameter.add(ChannelInfoMapping.EndTime, channelInfo.getEndTime());
        sqlParameter.add(ChannelInfoMapping.Remark, channelInfo.getRemark());
        sqlParameter.add(ChannelInfoMapping.Status, channelInfo.getStatus());
        sqlParameter.add(ChannelInfoMapping.CreateTime, channelInfo.getCreateTime());
        sqlParameter.add(ChannelInfoMapping.UpdateTime, channelInfo.getUpdateTime());
        sqlParameter.add(ChannelInfoMapping.ContractMoney, channelInfo.getContractMoney());
        sqlParameter.add(ChannelInfoMapping.EmpId, channelInfo.getEmpId());
        sqlParameter.add(ChannelInfoMapping.DiscountRate, channelInfo.getDiscountRate());
        sqlParameter.add(ChannelInfoMapping.SalesName, channelInfo.getSalesName());
        sqlParameter.add(ChannelInfoMapping.SalesName, channelInfo.getSalesName());
        sqlParameter.add(ChannelInfoMapping.DepositPaymentMoney, channelInfo.getDepositPaymentMoney());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int channelId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE channelId=@{channelId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ChannelInfoMapping.ChannelId,channelId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public ChannelInfo searchByChannelId(int channelId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE channelId=@{channelId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ChannelInfoMapping.ChannelId,channelId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, ChannelInfo.class);
    }
    public PagedList<ChannelInfo> searchByPage(QueryCondition queryCondition) {
        PagedList<ChannelInfo> pagedList=this.searchByPage(queryCondition, ChannelInfo.class);
        return pagedList;
    }
    public List<ChannelInfo> searchList(QueryParameter queryParameter) {
                List<ChannelInfo> list=this.searchList(queryParameter, ChannelInfo.class);
                    return list;
    }
}
