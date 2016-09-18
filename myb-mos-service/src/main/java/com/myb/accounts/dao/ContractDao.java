package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.ContractMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("contractDao")
public class ContractDao extends MySqlCommandBase
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
        return "contract";
    }


    public int insert(Contract contract)
    {
        String sql="INSERT INTO "+getTableName()+" (contractId,owner,ownerName,ownerDepName,contractCode,contractBody,beginDate,endDate,contractType,contractAmount,discount,bossAccount,bossName,payDate,payMoney,payAccountName,payNumber,payType,shopCount,status,remark,createTime,accountId,openNumber,payRemark,contractMoney,updateDate,creater,contractAnnex,companyName)VALUES(@{contractId},@{owner},@{ownerName},@{ownerDepName},@{contractCode},@{contractBody},@{beginDate},@{endDate},@{contractType},@{contractAmount},@{discount},@{bossAccount},@{bossName},@{payDate},@{payMoney},@{payAccountName},@{payNumber},@{payType},@{shopCount},@{status},@{remark},@{createTime},@{accountId},@{openNumber},@{payRemark},@{contractMoney},@{updateDate},@{creater},@{contractAnnex},@{companyName})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ContractMapping.ContractId, contract.getContractId());
        sqlParameter.add(ContractMapping.CompanyName, contract.getCompanyName());
        sqlParameter.add(ContractMapping.Owner, contract.getOwner());
        sqlParameter.add(ContractMapping.OwnerName, contract.getOwnerName());
        sqlParameter.add(ContractMapping.OwnerDepName, contract.getOwnerDepName());
        sqlParameter.add(ContractMapping.ContractCode, contract.getContractCode());
        sqlParameter.add(ContractMapping.ContractBody, contract.getContractBody());
        sqlParameter.add(ContractMapping.BeginDate, contract.getBeginDate());
        sqlParameter.add(ContractMapping.EndDate, contract.getEndDate());
        sqlParameter.add(ContractMapping.ContractType, contract.getContractType());
        sqlParameter.add(ContractMapping.ContractAmount, contract.getContractAmount());
        sqlParameter.add(ContractMapping.Discount, contract.getDiscount());
        sqlParameter.add(ContractMapping.BossAccount, contract.getBossAccount());
        sqlParameter.add(ContractMapping.BossName, contract.getBossName());
        sqlParameter.add(ContractMapping.PayDate, contract.getPayDate());
        sqlParameter.add(ContractMapping.PayMoney, contract.getPayMoney());
        sqlParameter.add(ContractMapping.PayAccountName, contract.getPayAccountName());
        sqlParameter.add(ContractMapping.PayNumber, contract.getPayNumber());
        sqlParameter.add(ContractMapping.PayType, contract.getPayType());
        sqlParameter.add(ContractMapping.ShopCount, contract.getShopCount());
        sqlParameter.add(ContractMapping.Status, contract.getStatus());
        sqlParameter.add(ContractMapping.Remark, contract.getRemark());
        sqlParameter.add(ContractMapping.CreateTime, contract.getCreateTime());
        sqlParameter.add(ContractMapping.AccountId, contract.getAccountId());
        sqlParameter.add(ContractMapping.OpenNumber, contract.getOpenNumber());
        sqlParameter.add(ContractMapping.PayRemark, contract.getPayRemark());
        sqlParameter.add(ContractMapping.ContractMoney, contract.getContractMoney());
        sqlParameter.add(ContractMapping.UpdateDate, contract.getUpdateDate());
        sqlParameter.add(ContractMapping.Creater, contract.getCreater());
        sqlParameter.add(ContractMapping.ContractAnnex, contract.getContractAnnex());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Contract contract)
    {
        String sql="UPDATE "+getTableName()+" set owner=@{owner},ownerName=@{ownerName},ownerDepName=@{ownerDepName},contractCode=@{contractCode},contractBody=@{contractBody},beginDate=@{beginDate},endDate=@{endDate},contractType=@{contractType},contractAmount=@{contractAmount},discount=@{discount},bossAccount=@{bossAccount},bossName=@{bossName},payDate=@{payDate},payMoney=@{payMoney},payAccountName=@{payAccountName},payNumber=@{payNumber},payType=@{payType},shopCount=@{shopCount},status=@{status},remark=@{remark},createTime=@{createTime},accountId=@{accountId},openNumber=@{openNumber},payRemark=@{payRemark},contractMoney=@{contractMoney},updateDate=@{updateDate},creater=@{creater},contractAnnex=@{contractAnnex},companyName=@{companyName} WHERE contractId=@{contractId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ContractMapping.ContractId, contract.getContractId());
        sqlParameter.add(ContractMapping.CompanyName, contract.getCompanyName());
        sqlParameter.add(ContractMapping.Owner, contract.getOwner());
        sqlParameter.add(ContractMapping.OwnerName, contract.getOwnerName());
        sqlParameter.add(ContractMapping.OwnerDepName, contract.getOwnerDepName());
        sqlParameter.add(ContractMapping.ContractCode, contract.getContractCode());
        sqlParameter.add(ContractMapping.ContractBody, contract.getContractBody());
        sqlParameter.add(ContractMapping.BeginDate, contract.getBeginDate());
        sqlParameter.add(ContractMapping.EndDate, contract.getEndDate());
        sqlParameter.add(ContractMapping.ContractType, contract.getContractType());
        sqlParameter.add(ContractMapping.ContractAmount, contract.getContractAmount());
        sqlParameter.add(ContractMapping.Discount, contract.getDiscount());
        sqlParameter.add(ContractMapping.BossAccount, contract.getBossAccount());
        sqlParameter.add(ContractMapping.BossName, contract.getBossName());
        sqlParameter.add(ContractMapping.PayDate, contract.getPayDate());
        sqlParameter.add(ContractMapping.PayMoney, contract.getPayMoney());
        sqlParameter.add(ContractMapping.PayAccountName, contract.getPayAccountName());
        sqlParameter.add(ContractMapping.PayNumber, contract.getPayNumber());
        sqlParameter.add(ContractMapping.PayType, contract.getPayType());
        sqlParameter.add(ContractMapping.ShopCount, contract.getShopCount());
        sqlParameter.add(ContractMapping.Status, contract.getStatus());
        sqlParameter.add(ContractMapping.Remark, contract.getRemark());
        sqlParameter.add(ContractMapping.CreateTime, contract.getCreateTime());
        sqlParameter.add(ContractMapping.AccountId, contract.getAccountId());
        sqlParameter.add(ContractMapping.OpenNumber, contract.getOpenNumber());
        sqlParameter.add(ContractMapping.PayRemark, contract.getPayRemark());
        sqlParameter.add(ContractMapping.ContractMoney, contract.getContractMoney());
        sqlParameter.add(ContractMapping.UpdateDate, contract.getUpdateDate());
        sqlParameter.add(ContractMapping.Creater, contract.getCreater());
        sqlParameter.add(ContractMapping.ContractAnnex, contract.getContractAnnex());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int contractId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE contractId=@{contractId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ContractMapping.ContractId,contractId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Contract searchByContractId(int contractId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE contractId=@{contractId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ContractMapping.ContractId,contractId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Contract.class);
    }
    public PagedList<Contract> searchByPage(QueryCondition queryCondition) {
        PagedList<Contract> pagedList=this.searchByPage(queryCondition, Contract.class);
        return pagedList;
    }
    public List<Contract> searchList(QueryParameter queryParameter) {
                List<Contract> list=this.searchList(queryParameter, Contract.class);
                    return list;
    }
}
