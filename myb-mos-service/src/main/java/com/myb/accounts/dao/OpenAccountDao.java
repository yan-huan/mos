package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.accounts.vo.DistinctVO;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.OpenAccountMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("openAccountDao")
public class OpenAccountDao extends MySqlCommandBase
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
        return "open_account";
    }


    public int insert(OpenAccount openAccount)
    {
        String sql="INSERT INTO "+getTableName()+" (accountId,beautifulyard,openNumber,shopCount,payDate,market,status,remark,createTime,zongbuAddress,kefumobile,"
        		+ "province,city,companyCode,approvalStatus,"
        		+ "isAddAccount,updateDate,refuseInfo,empId,isOpenStatus,isChannel,isShowQudaoList,consumerId,isOperationException,operationReason,filePath,touchMobile)"
        		+ "VALUES"
        		+ "(@{accountId},@{beautifulyard},@{openNumber},@{shopCount},@{payDate},@{market},@{status},"
        		+ "@{remark},@{createTime},@{zongbuAddress},@{kefumobile},@{province},@{city},@{companyCode},"
        		+ "@{approvalStatus},@{isAddAccount},@{updateDate},@{refuseInfo},@{empId},@{isOpenStatus},@{isChannel},@{isShowQudaoList},@{consumerId},"
        		+ "@{isOperationException},@{operationReason},@{filePath},@{touchMobile})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountMapping.AccountId, openAccount.getAccountId());
        sqlParameter.add(OpenAccountMapping.Beautifulyard, openAccount.getBeautifulyard());
        sqlParameter.add(OpenAccountMapping.OpenNumber, openAccount.getOpenNumber());
        sqlParameter.add(OpenAccountMapping.ShopCount, openAccount.getShopCount());
        sqlParameter.add(OpenAccountMapping.PayDate, openAccount.getPayDate());
        sqlParameter.add(OpenAccountMapping.Market, openAccount.getMarket());
        sqlParameter.add(OpenAccountMapping.Status, openAccount.getStatus());
        sqlParameter.add(OpenAccountMapping.Remark, openAccount.getRemark());
        sqlParameter.add(OpenAccountMapping.CreateTime, openAccount.getCreateTime());
        sqlParameter.add(OpenAccountMapping.ZongbuAddress, openAccount.getZongbuAddress());
        sqlParameter.add(OpenAccountMapping.Kefumobile, openAccount.getKefumobile());
        sqlParameter.add(OpenAccountMapping.Province, openAccount.getProvince());
        sqlParameter.add(OpenAccountMapping.City, openAccount.getCity());
        sqlParameter.add(OpenAccountMapping.CompanyCode, openAccount.getCompanyCode());
        sqlParameter.add(OpenAccountMapping.ApprovalStatus, openAccount.getApprovalStatus());
        sqlParameter.add(OpenAccountMapping.IsAddAccount, openAccount.getIsAddAccount());
        sqlParameter.add(OpenAccountMapping.UpdateDate, openAccount.getUpdateDate());
        sqlParameter.add(OpenAccountMapping.RefuseInfo, openAccount.getRefuseInfo());
        sqlParameter.add(OpenAccountMapping.EmpId, openAccount.getEmpId());
        sqlParameter.add(OpenAccountMapping.IsOpenStatus, openAccount.getIsOpenStatus());
        sqlParameter.add(OpenAccountMapping.IsChannel, openAccount.getIsChannel());
        sqlParameter.add(OpenAccountMapping.IsShowQudaoList, openAccount.getIsShowQudaoList());
        sqlParameter.add(OpenAccountMapping.ConsumerId, openAccount.getConsumerId());
        sqlParameter.add(OpenAccountMapping.IsOperationException, openAccount.getIsOperationException());
        sqlParameter.add(OpenAccountMapping.OperationReason, openAccount.getOperationReason());
        sqlParameter.add(OpenAccountMapping.FilePath, openAccount.getFilePath());
        sqlParameter.add(OpenAccountMapping.TouchMobile, openAccount.getTouchMobile());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(OpenAccount openAccount)
    {
        String sql="UPDATE "+getTableName()+" set beautifulyard=@{beautifulyard},openNumber=@{openNumber},shopCount=@{shopCount},payDate=@{payDate},market=@{market},status=@{status},"
        		+ "remark=@{remark},createTime=@{createTime},zongbuAddress=@{zongbuAddress},kefumobile=@{kefumobile},"
        		+ "province=@{province},city=@{city},companyCode=@{companyCode},approvalStatus=@{approvalStatus},"
        		+ "isAddAccount=@{isAddAccount},updateDate=@{updateDate},refuseInfo=@{refuseInfo},empId=@{empId},"
        		+ "isOpenStatus=@{isOpenStatus},isChannel=@{isChannel},isShowQudaoList=@{isShowQudaoList},"
        		+ "consumerId=@{consumerId},isOperationException=@{isOperationException},operationReason=@{operationReason},filePath=@{filePath}," +
                "touchMobile=@{touchMobile},financeSuccessDate=@{financeSuccessDate} WHERE accountId=@{accountId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountMapping.AccountId, openAccount.getAccountId());
        sqlParameter.add(OpenAccountMapping.Beautifulyard, openAccount.getBeautifulyard());
        sqlParameter.add(OpenAccountMapping.OpenNumber, openAccount.getOpenNumber());
        sqlParameter.add(OpenAccountMapping.ShopCount, openAccount.getShopCount());
        sqlParameter.add(OpenAccountMapping.PayDate, openAccount.getPayDate());
        sqlParameter.add(OpenAccountMapping.Market, openAccount.getMarket());
        sqlParameter.add(OpenAccountMapping.Status, openAccount.getStatus());
        sqlParameter.add(OpenAccountMapping.Remark, openAccount.getRemark());
        sqlParameter.add(OpenAccountMapping.CreateTime, openAccount.getCreateTime());
        sqlParameter.add(OpenAccountMapping.ZongbuAddress, openAccount.getZongbuAddress());
        sqlParameter.add(OpenAccountMapping.Kefumobile, openAccount.getKefumobile());
        sqlParameter.add(OpenAccountMapping.Province, openAccount.getProvince());
        sqlParameter.add(OpenAccountMapping.City, openAccount.getCity());
        sqlParameter.add(OpenAccountMapping.CompanyCode, openAccount.getCompanyCode());
        sqlParameter.add(OpenAccountMapping.ApprovalStatus, openAccount.getApprovalStatus());
        sqlParameter.add(OpenAccountMapping.IsAddAccount, openAccount.getIsAddAccount());
        sqlParameter.add(OpenAccountMapping.UpdateDate, openAccount.getUpdateDate());
        sqlParameter.add(OpenAccountMapping.RefuseInfo, openAccount.getRefuseInfo());
        sqlParameter.add(OpenAccountMapping.EmpId, openAccount.getEmpId());
        sqlParameter.add(OpenAccountMapping.IsOpenStatus, openAccount.getIsOpenStatus());
        sqlParameter.add(OpenAccountMapping.IsChannel, openAccount.getIsChannel());
        sqlParameter.add(OpenAccountMapping.IsShowQudaoList, openAccount.getIsShowQudaoList());
        sqlParameter.add(OpenAccountMapping.ConsumerId, openAccount.getConsumerId());
        sqlParameter.add(OpenAccountMapping.IsOperationException, openAccount.getIsOperationException());
        sqlParameter.add(OpenAccountMapping.OperationReason, openAccount.getOperationReason());
        sqlParameter.add(OpenAccountMapping.FilePath, openAccount.getFilePath());
        sqlParameter.add(OpenAccountMapping.TouchMobile, openAccount.getTouchMobile());
        sqlParameter.add(OpenAccountMapping.FinanceSuccessDate, openAccount.getFinanceSuccessDate());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int accountId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE accountId=@{accountId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountMapping.AccountId,accountId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public OpenAccount searchByAccountId(int accountId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE accountId=@{accountId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountMapping.AccountId,accountId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, OpenAccount.class);
    }
    
    public PagedList<OpenAccount> searchByPage(QueryCondition queryCondition) {
        PagedList<OpenAccount> pagedList=this.searchByPage(queryCondition, OpenAccount.class);
        return pagedList;
    }
    
    public List<OpenAccount> searchDistinct(QueryCondition queryCondition, String column) {
    	
    	return this.searchListDistince(queryCondition, OpenAccount.class,column);
    }
    
    public List<OpenAccount> searchList(QueryParameter queryParameter) {
                List<OpenAccount> list=this.searchList(queryParameter, OpenAccount.class);
                    return list;
    }
    
    /**
     * 根据手机号查询美容院的信息
     * @param mobile
     * @return
     */
    public OpenAccount searchByMobile(String openNumber)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE openNumber=@{openNumber}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountMapping.OpenNumber,openNumber);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, OpenAccount.class);
    }
}
