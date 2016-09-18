package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AashopSaas;
import com.myb.entity.pojo.mos.AashopSaasMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("aashopSaasDao")
public class AashopSaasDao extends MySqlCommandBase
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
        return "aashop_saas";
    }


    public int insert(AashopSaas aashopSaas)
    {
        String sql="INSERT INTO "+getTableName()+" (shopId,CONTRACTID,SHOPNAME,SHOPACCOUNT,city,province,BEGINDATE,ENDDATE,DURATION,address,createtime,shopcode,companycode,N,O,ANOBEGINDATE,ANOENDDATE,ANOCREATETIME)VALUES(@{shopId},@{CONTRACTID},@{SHOPNAME},@{SHOPACCOUNT},@{city},@{province},@{BEGINDATE},@{ENDDATE},@{DURATION},@{address},@{createtime},@{shopcode},@{companycode},@{N},@{O},@{ANOBEGINDATE},@{ANOENDDATE},@{ANOCREATETIME})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AashopSaasMapping.ShopId, aashopSaas.getShopId());
        sqlParameter.add(AashopSaasMapping.CONTRACTID, aashopSaas.getCONTRACTID());
        sqlParameter.add(AashopSaasMapping.SHOPNAME, aashopSaas.getSHOPNAME());
        sqlParameter.add(AashopSaasMapping.SHOPACCOUNT, aashopSaas.getSHOPACCOUNT());
        sqlParameter.add(AashopSaasMapping.City, aashopSaas.getCity());
        sqlParameter.add(AashopSaasMapping.Province, aashopSaas.getProvince());
        sqlParameter.add(AashopSaasMapping.BEGINDATE, aashopSaas.getBEGINDATE());
        sqlParameter.add(AashopSaasMapping.ENDDATE, aashopSaas.getENDDATE());
        sqlParameter.add(AashopSaasMapping.DURATION, aashopSaas.getDURATION());
        sqlParameter.add(AashopSaasMapping.Address, aashopSaas.getAddress());
        sqlParameter.add(AashopSaasMapping.Createtime, aashopSaas.getCreatetime());
        sqlParameter.add(AashopSaasMapping.Shopcode, aashopSaas.getShopcode());
        sqlParameter.add(AashopSaasMapping.Companycode, aashopSaas.getCompanycode());
        sqlParameter.add(AashopSaasMapping.N, aashopSaas.getN());
        sqlParameter.add(AashopSaasMapping.O, aashopSaas.getO());
        sqlParameter.add(AashopSaasMapping.ANOBEGINDATE, aashopSaas.getaNOBEGINDATE());
        sqlParameter.add(AashopSaasMapping.ANOENDDATE, aashopSaas.getaNOENDDATE());
        sqlParameter.add(AashopSaasMapping.ANOCREATETIME, aashopSaas.getaNOCREATETIME());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AashopSaas aashopSaas)
    {
        String sql="UPDATE "+getTableName()+" set CONTRACTID=@{CONTRACTID},SHOPNAME=@{SHOPNAME},SHOPACCOUNT=@{SHOPACCOUNT},city=@{city},province=@{province},BEGINDATE=@{BEGINDATE},ENDDATE=@{ENDDATE},DURATION=@{DURATION},address=@{address},createtime=@{createtime},shopcode=@{shopcode},companycode=@{companycode},N=@{N},O=@{O},ANOBEGINDATE=@{ANOBEGINDATE},ANOENDDATE=@{ANOENDDATE},ANOCREATETIME=@{ANOCREATETIME} WHERE shopId=@{shopId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AashopSaasMapping.ShopId, aashopSaas.getShopId());
        sqlParameter.add(AashopSaasMapping.CONTRACTID, aashopSaas.getCONTRACTID());
        sqlParameter.add(AashopSaasMapping.SHOPNAME, aashopSaas.getSHOPNAME());
        sqlParameter.add(AashopSaasMapping.SHOPACCOUNT, aashopSaas.getSHOPACCOUNT());
        sqlParameter.add(AashopSaasMapping.City, aashopSaas.getCity());
        sqlParameter.add(AashopSaasMapping.Province, aashopSaas.getProvince());
        sqlParameter.add(AashopSaasMapping.BEGINDATE, aashopSaas.getBEGINDATE());
        sqlParameter.add(AashopSaasMapping.ENDDATE, aashopSaas.getENDDATE());
        sqlParameter.add(AashopSaasMapping.DURATION, aashopSaas.getDURATION());
        sqlParameter.add(AashopSaasMapping.Address, aashopSaas.getAddress());
        sqlParameter.add(AashopSaasMapping.Createtime, aashopSaas.getCreatetime());
        sqlParameter.add(AashopSaasMapping.Shopcode, aashopSaas.getShopcode());
        sqlParameter.add(AashopSaasMapping.Companycode, aashopSaas.getCompanycode());
        sqlParameter.add(AashopSaasMapping.N, aashopSaas.getN());
        sqlParameter.add(AashopSaasMapping.O, aashopSaas.getO());
        sqlParameter.add(AashopSaasMapping.ANOBEGINDATE, aashopSaas.getaNOBEGINDATE());
        sqlParameter.add(AashopSaasMapping.ANOENDDATE, aashopSaas.getaNOENDDATE());
        sqlParameter.add(AashopSaasMapping.ANOCREATETIME, aashopSaas.getaNOCREATETIME());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String shopId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE shopId=@{shopId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AashopSaasMapping.ShopId,shopId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AashopSaas searchByShopId(java.lang.String shopId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE shopId=@{shopId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AashopSaasMapping.ShopId,shopId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AashopSaas.class);
    }
    public PagedList<AashopSaas> searchByPage(QueryCondition queryCondition) {
        PagedList<AashopSaas> pagedList=this.searchByPage(queryCondition, AashopSaas.class);
        return pagedList;
    }
    public List<AashopSaas> searchList(QueryParameter queryParameter) {
                List<AashopSaas> list=this.searchList(queryParameter, AashopSaas.class);
                    return list;
    }
}
