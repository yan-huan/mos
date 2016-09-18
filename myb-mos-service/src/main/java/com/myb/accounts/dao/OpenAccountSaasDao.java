package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.OpenAccountSaas;
import com.myb.entity.pojo.mos.OpenAccountSaasMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("openAccountSaasDao")
public class OpenAccountSaasDao extends MySqlCommandBase
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
        return "open_account_saas";
    }


    public int insert(OpenAccountSaas openAccountSaas)
    {
        String sql="INSERT INTO "+getTableName()+" (id,accountId,beautifulyard,openNumber,shopCount,payDate,market,status,remark,createtime,zongbuaddress,kefumobile,province,city,companycode,approvalstatus,isaddaccount,updatedate,refuseinfo,empid,source)VALUES(@{id},@{accountId},@{beautifulyard},@{openNumber},@{shopCount},@{payDate},@{market},@{status},@{remark},@{createtime},@{zongbuaddress},@{kefumobile},@{province},@{city},@{companycode},@{approvalstatus},@{isaddaccount},@{updatedate},@{refuseinfo},@{empid},@{source})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountSaasMapping.Id, openAccountSaas.getId());
        sqlParameter.add(OpenAccountSaasMapping.AccountId, openAccountSaas.getAccountId());
        sqlParameter.add(OpenAccountSaasMapping.Beautifulyard, openAccountSaas.getBeautifulyard());
        sqlParameter.add(OpenAccountSaasMapping.OpenNumber, openAccountSaas.getOpenNumber());
        sqlParameter.add(OpenAccountSaasMapping.ShopCount, openAccountSaas.getShopCount());
        sqlParameter.add(OpenAccountSaasMapping.PayDate, openAccountSaas.getPayDate());
        sqlParameter.add(OpenAccountSaasMapping.Market, openAccountSaas.getMarket());
        sqlParameter.add(OpenAccountSaasMapping.Status, openAccountSaas.getStatus());
        sqlParameter.add(OpenAccountSaasMapping.Remark, openAccountSaas.getRemark());
        sqlParameter.add(OpenAccountSaasMapping.Createtime, openAccountSaas.getCreatetime());
        sqlParameter.add(OpenAccountSaasMapping.Zongbuaddress, openAccountSaas.getZongbuaddress());
        sqlParameter.add(OpenAccountSaasMapping.Kefumobile, openAccountSaas.getKefumobile());
        sqlParameter.add(OpenAccountSaasMapping.Province, openAccountSaas.getProvince());
        sqlParameter.add(OpenAccountSaasMapping.City, openAccountSaas.getCity());
        sqlParameter.add(OpenAccountSaasMapping.Companycode, openAccountSaas.getCompanycode());
        sqlParameter.add(OpenAccountSaasMapping.Approvalstatus, openAccountSaas.getApprovalstatus());
        sqlParameter.add(OpenAccountSaasMapping.Isaddaccount, openAccountSaas.getIsaddaccount());
        sqlParameter.add(OpenAccountSaasMapping.Updatedate, openAccountSaas.getUpdatedate());
        sqlParameter.add(OpenAccountSaasMapping.Refuseinfo, openAccountSaas.getRefuseinfo());
        sqlParameter.add(OpenAccountSaasMapping.Empid, openAccountSaas.getEmpid());
        sqlParameter.add(OpenAccountSaasMapping.Source, openAccountSaas.getSource());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(OpenAccountSaas openAccountSaas)
    {
        String sql="UPDATE "+getTableName()+" set accountId=@{accountId},beautifulyard=@{beautifulyard},openNumber=@{openNumber},shopCount=@{shopCount},payDate=@{payDate},market=@{market},status=@{status},remark=@{remark},createtime=@{createtime},zongbuaddress=@{zongbuaddress},kefumobile=@{kefumobile},province=@{province},city=@{city},companycode=@{companycode},approvalstatus=@{approvalstatus},isaddaccount=@{isaddaccount},updatedate=@{updatedate},refuseinfo=@{refuseinfo},empid=@{empid},source=@{source} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountSaasMapping.Id, openAccountSaas.getId());
        sqlParameter.add(OpenAccountSaasMapping.AccountId, openAccountSaas.getAccountId());
        sqlParameter.add(OpenAccountSaasMapping.Beautifulyard, openAccountSaas.getBeautifulyard());
        sqlParameter.add(OpenAccountSaasMapping.OpenNumber, openAccountSaas.getOpenNumber());
        sqlParameter.add(OpenAccountSaasMapping.ShopCount, openAccountSaas.getShopCount());
        sqlParameter.add(OpenAccountSaasMapping.PayDate, openAccountSaas.getPayDate());
        sqlParameter.add(OpenAccountSaasMapping.Market, openAccountSaas.getMarket());
        sqlParameter.add(OpenAccountSaasMapping.Status, openAccountSaas.getStatus());
        sqlParameter.add(OpenAccountSaasMapping.Remark, openAccountSaas.getRemark());
        sqlParameter.add(OpenAccountSaasMapping.Createtime, openAccountSaas.getCreatetime());
        sqlParameter.add(OpenAccountSaasMapping.Zongbuaddress, openAccountSaas.getZongbuaddress());
        sqlParameter.add(OpenAccountSaasMapping.Kefumobile, openAccountSaas.getKefumobile());
        sqlParameter.add(OpenAccountSaasMapping.Province, openAccountSaas.getProvince());
        sqlParameter.add(OpenAccountSaasMapping.City, openAccountSaas.getCity());
        sqlParameter.add(OpenAccountSaasMapping.Companycode, openAccountSaas.getCompanycode());
        sqlParameter.add(OpenAccountSaasMapping.Approvalstatus, openAccountSaas.getApprovalstatus());
        sqlParameter.add(OpenAccountSaasMapping.Isaddaccount, openAccountSaas.getIsaddaccount());
        sqlParameter.add(OpenAccountSaasMapping.Updatedate, openAccountSaas.getUpdatedate());
        sqlParameter.add(OpenAccountSaasMapping.Refuseinfo, openAccountSaas.getRefuseinfo());
        sqlParameter.add(OpenAccountSaasMapping.Empid, openAccountSaas.getEmpid());
        sqlParameter.add(OpenAccountSaasMapping.Source, openAccountSaas.getSource());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountSaasMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public OpenAccountSaas searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(OpenAccountSaasMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, OpenAccountSaas.class);
    }
    public PagedList<OpenAccountSaas> searchByPage(QueryCondition queryCondition) {
        PagedList<OpenAccountSaas> pagedList=this.searchByPage(queryCondition, OpenAccountSaas.class);
        return pagedList;
    }
    public List<OpenAccountSaas> searchList(QueryParameter queryParameter) {
                List<OpenAccountSaas> list=this.searchList(queryParameter, OpenAccountSaas.class);
                    return list;
    }
}
