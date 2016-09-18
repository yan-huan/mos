package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AaopenAccountSaas;
import com.myb.entity.pojo.mos.AaopenAccountSaasMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("aaopenAccountSaasDao")
public class AaopenAccountSaasDao extends MySqlCommandBase
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
        return "aaopen_account_saas";
    }


    public int insert(AaopenAccountSaas aaopenAccountSaas)
    {
        String sql="INSERT INTO "+getTableName()+" (id,COMPANYCODE,BEAUTIFULYARD,OPENNUMBER,SHOPCOUNT,PAYDATE,CREATETIME,ENDTIME,ZONGBUADDRESS,PROVINCE,CITY,ANOCREATETIME,ANOENDTIME)VALUES(@{id},@{COMPANYCODE},@{BEAUTIFULYARD},@{OPENNUMBER},@{SHOPCOUNT},@{PAYDATE},@{CREATETIME},@{ENDTIME},@{ZONGBUADDRESS},@{PROVINCE},@{CITY},@{ANOCREATETIME},@{ANOENDTIME})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaopenAccountSaasMapping.Id, aaopenAccountSaas.getId());
        sqlParameter.add(AaopenAccountSaasMapping.COMPANYCODE, aaopenAccountSaas.getCOMPANYCODE());
        sqlParameter.add(AaopenAccountSaasMapping.BEAUTIFULYARD, aaopenAccountSaas.getBEAUTIFULYARD());
        sqlParameter.add(AaopenAccountSaasMapping.OPENNUMBER, aaopenAccountSaas.getOPENNUMBER());
        sqlParameter.add(AaopenAccountSaasMapping.SHOPCOUNT, aaopenAccountSaas.getSHOPCOUNT());
        sqlParameter.add(AaopenAccountSaasMapping.PAYDATE, aaopenAccountSaas.getPAYDATE());
        sqlParameter.add(AaopenAccountSaasMapping.CREATETIME, aaopenAccountSaas.getCREATETIME());
        sqlParameter.add(AaopenAccountSaasMapping.ENDTIME, aaopenAccountSaas.getENDTIME());
        sqlParameter.add(AaopenAccountSaasMapping.ZONGBUADDRESS, aaopenAccountSaas.getZONGBUADDRESS());
        sqlParameter.add(AaopenAccountSaasMapping.PROVINCE, aaopenAccountSaas.getPROVINCE());
        sqlParameter.add(AaopenAccountSaasMapping.CITY, aaopenAccountSaas.getCITY());
        sqlParameter.add(AaopenAccountSaasMapping.ANOCREATETIME, aaopenAccountSaas.getaNOCREATETIME());
        sqlParameter.add(AaopenAccountSaasMapping.ANOENDTIME, aaopenAccountSaas.getaNOENDTIME());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AaopenAccountSaas aaopenAccountSaas)
    {
        String sql="UPDATE "+getTableName()+" set COMPANYCODE=@{COMPANYCODE},BEAUTIFULYARD=@{BEAUTIFULYARD},OPENNUMBER=@{OPENNUMBER},SHOPCOUNT=@{SHOPCOUNT},PAYDATE=@{PAYDATE},CREATETIME=@{CREATETIME},ENDTIME=@{ENDTIME},ZONGBUADDRESS=@{ZONGBUADDRESS},PROVINCE=@{PROVINCE},CITY=@{CITY},ANOCREATETIME=@{ANOCREATETIME},ANOENDTIME=@{ANOENDTIME} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaopenAccountSaasMapping.Id, aaopenAccountSaas.getId());
        sqlParameter.add(AaopenAccountSaasMapping.COMPANYCODE, aaopenAccountSaas.getCOMPANYCODE());
        sqlParameter.add(AaopenAccountSaasMapping.BEAUTIFULYARD, aaopenAccountSaas.getBEAUTIFULYARD());
        sqlParameter.add(AaopenAccountSaasMapping.OPENNUMBER, aaopenAccountSaas.getOPENNUMBER());
        sqlParameter.add(AaopenAccountSaasMapping.SHOPCOUNT, aaopenAccountSaas.getSHOPCOUNT());
        sqlParameter.add(AaopenAccountSaasMapping.PAYDATE, aaopenAccountSaas.getPAYDATE());
        sqlParameter.add(AaopenAccountSaasMapping.CREATETIME, aaopenAccountSaas.getCREATETIME());
        sqlParameter.add(AaopenAccountSaasMapping.ENDTIME, aaopenAccountSaas.getENDTIME());
        sqlParameter.add(AaopenAccountSaasMapping.ZONGBUADDRESS, aaopenAccountSaas.getZONGBUADDRESS());
        sqlParameter.add(AaopenAccountSaasMapping.PROVINCE, aaopenAccountSaas.getPROVINCE());
        sqlParameter.add(AaopenAccountSaasMapping.CITY, aaopenAccountSaas.getCITY());
        sqlParameter.add(AaopenAccountSaasMapping.ANOCREATETIME, aaopenAccountSaas.getaNOCREATETIME());
        sqlParameter.add(AaopenAccountSaasMapping.ANOENDTIME, aaopenAccountSaas.getaNOENDTIME());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaopenAccountSaasMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AaopenAccountSaas searchById(java.lang.String id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaopenAccountSaasMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AaopenAccountSaas.class);
    }
    public PagedList<AaopenAccountSaas> searchByPage(QueryCondition queryCondition) {
        PagedList<AaopenAccountSaas> pagedList=this.searchByPage(queryCondition, AaopenAccountSaas.class);
        return pagedList;
    }
    public List<AaopenAccountSaas> searchList(QueryParameter queryParameter) {
                List<AaopenAccountSaas> list=this.searchList(queryParameter, AaopenAccountSaas.class);
                    return list;
    }
}
