package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AbopenaccountData;
import com.myb.entity.pojo.mos.AbopenaccountDataMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("abopenaccountDataDao")
public class AbopenaccountDataDao extends MySqlCommandBase
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
        return "abopenaccount_data";
    }


    public int insert(AbopenaccountData abopenaccountData)
    {
        String sql="INSERT INTO "+getTableName()+" (id,COMPANYCODE,BEAUTIFULYARD,OPENNUMBER,SHOPCOUNT,PAYDATE,CREATETIME,ENDTIME,ZONGBUADDRESS,PROVINCE,CITY)VALUES(@{id},@{COMPANYCODE},@{BEAUTIFULYARD},@{OPENNUMBER},@{SHOPCOUNT},@{PAYDATE},@{CREATETIME},@{ENDTIME},@{ZONGBUADDRESS},@{PROVINCE},@{CITY})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountDataMapping.Id, abopenaccountData.getId());
        sqlParameter.add(AbopenaccountDataMapping.COMPANYCODE, abopenaccountData.getcOMPANYCODE());
        sqlParameter.add(AbopenaccountDataMapping.BEAUTIFULYARD, abopenaccountData.getbEAUTIFULYARD());
        sqlParameter.add(AbopenaccountDataMapping.OPENNUMBER, abopenaccountData.getoPENNUMBER());
        sqlParameter.add(AbopenaccountDataMapping.SHOPCOUNT, abopenaccountData.getsHOPCOUNT());
        sqlParameter.add(AbopenaccountDataMapping.PAYDATE, abopenaccountData.getpAYDATE());
        sqlParameter.add(AbopenaccountDataMapping.CREATETIME, abopenaccountData.getcREATETIME());
        sqlParameter.add(AbopenaccountDataMapping.ENDTIME, abopenaccountData.getcREATETIME());
        sqlParameter.add(AbopenaccountDataMapping.ZONGBUADDRESS, abopenaccountData.getzONGBUADDRESS());
        sqlParameter.add(AbopenaccountDataMapping.PROVINCE, abopenaccountData.getpROVINCE());
        sqlParameter.add(AbopenaccountDataMapping.CITY, abopenaccountData.getcITY());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AbopenaccountData abopenaccountData)
    {
        String sql="UPDATE "+getTableName()+" set COMPANYCODE=@{COMPANYCODE},BEAUTIFULYARD=@{BEAUTIFULYARD},OPENNUMBER=@{OPENNUMBER},SHOPCOUNT=@{SHOPCOUNT},PAYDATE=@{PAYDATE},CREATETIME=@{CREATETIME},ENDTIME=@{ENDTIME},ZONGBUADDRESS=@{ZONGBUADDRESS},PROVINCE=@{PROVINCE},CITY=@{CITY} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountDataMapping.Id, abopenaccountData.getId());
        sqlParameter.add(AbopenaccountDataMapping.COMPANYCODE, abopenaccountData.getcOMPANYCODE());
        sqlParameter.add(AbopenaccountDataMapping.BEAUTIFULYARD, abopenaccountData.getbEAUTIFULYARD());
        sqlParameter.add(AbopenaccountDataMapping.OPENNUMBER, abopenaccountData.getoPENNUMBER());
        sqlParameter.add(AbopenaccountDataMapping.SHOPCOUNT, abopenaccountData.getsHOPCOUNT());
        sqlParameter.add(AbopenaccountDataMapping.PAYDATE, abopenaccountData.getpAYDATE());
        sqlParameter.add(AbopenaccountDataMapping.CREATETIME, abopenaccountData.getcREATETIME());
        sqlParameter.add(AbopenaccountDataMapping.ENDTIME, abopenaccountData.getcREATETIME());
        sqlParameter.add(AbopenaccountDataMapping.ZONGBUADDRESS, abopenaccountData.getzONGBUADDRESS());
        sqlParameter.add(AbopenaccountDataMapping.PROVINCE, abopenaccountData.getpROVINCE());
        sqlParameter.add(AbopenaccountDataMapping.CITY, abopenaccountData.getcITY());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountDataMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AbopenaccountData searchById(java.lang.String id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AbopenaccountDataMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AbopenaccountData.class);
    }
    public PagedList<AbopenaccountData> searchByPage(QueryCondition queryCondition) {
        PagedList<AbopenaccountData> pagedList=this.searchByPage(queryCondition, AbopenaccountData.class);
        return pagedList;
    }
    public List<AbopenaccountData> searchList(QueryParameter queryParameter) {
                List<AbopenaccountData> list=this.searchList(queryParameter, AbopenaccountData.class);
                    return list;
    }
}
