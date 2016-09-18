package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Shopsaas;
import com.myb.entity.pojo.mos.ShopsaasMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("shopsaasDao")
public class ShopsaasDao extends MySqlCommandBase
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
        return "shopsaas";
    }


    public int insert(Shopsaas shopsaas)
    {
        String sql="INSERT INTO "+getTableName()+" (SHOPID,CONTRACTID,SHOPNAME,SHOPACCOUNT,CITY,PROVINCE,BEGINDATE,ENDDATE,DURATION,ADDRESS,NULL,NULL1,NULL2,CREATETIME,NULL3,NULL4,SHOPCODE,NULL5,NULL6,NULL7,NULL8,NULL9,NULL10,NULL11,NULL12,id)VALUES(@{SHOPID},@{CONTRACTID},@{SHOPNAME},@{SHOPACCOUNT},@{CITY},@{PROVINCE},@{BEGINDATE},@{ENDDATE},@{DURATION},@{ADDRESS},@{NULL},@{NULL1},@{NULL2},@{CREATETIME},@{NULL3},@{NULL4},@{SHOPCODE},@{NULL5},@{NULL6},@{NULL7},@{NULL8},@{NULL9},@{NULL10},@{NULL11},@{NULL12},@{id})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopsaasMapping.SHOPID, shopsaas.getSHOPID());
        sqlParameter.add(ShopsaasMapping.CONTRACTID, shopsaas.getCONTRACTID());
        sqlParameter.add(ShopsaasMapping.SHOPNAME, shopsaas.getSHOPNAME());
        sqlParameter.add(ShopsaasMapping.SHOPACCOUNT, shopsaas.getSHOPACCOUNT());
        sqlParameter.add(ShopsaasMapping.CITY, shopsaas.getCITY());
        sqlParameter.add(ShopsaasMapping.PROVINCE, shopsaas.getPROVINCE());
        sqlParameter.add(ShopsaasMapping.BEGINDATE, shopsaas.getBEGINDATE());
        sqlParameter.add(ShopsaasMapping.ENDDATE, shopsaas.getENDDATE());
        sqlParameter.add(ShopsaasMapping.DURATION, shopsaas.getDURATION());
        sqlParameter.add(ShopsaasMapping.ADDRESS, shopsaas.getADDRESS());
        sqlParameter.add(ShopsaasMapping.NULL, shopsaas.getNULL());
        sqlParameter.add(ShopsaasMapping.NULL1, shopsaas.getNULL1());
        sqlParameter.add(ShopsaasMapping.NULL2, shopsaas.getNULL2());
        sqlParameter.add(ShopsaasMapping.CREATETIME, shopsaas.getCREATETIME());
        sqlParameter.add(ShopsaasMapping.NULL3, shopsaas.getNULL3());
        sqlParameter.add(ShopsaasMapping.NULL4, shopsaas.getNULL4());
        sqlParameter.add(ShopsaasMapping.SHOPCODE, shopsaas.getSHOPCODE());
        sqlParameter.add(ShopsaasMapping.NULL5, shopsaas.getNULL5());
        sqlParameter.add(ShopsaasMapping.NULL6, shopsaas.getNULL6());
        sqlParameter.add(ShopsaasMapping.NULL7, shopsaas.getNULL7());
        sqlParameter.add(ShopsaasMapping.NULL8, shopsaas.getNULL8());
        sqlParameter.add(ShopsaasMapping.NULL9, shopsaas.getNULL9());
        sqlParameter.add(ShopsaasMapping.NULL10, shopsaas.getNULL10());
        sqlParameter.add(ShopsaasMapping.NULL11, shopsaas.getNULL11());
        sqlParameter.add(ShopsaasMapping.NULL12, shopsaas.getNULL12());
        sqlParameter.add(ShopsaasMapping.Id, shopsaas.getId());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Shopsaas shopsaas)
    {
        String sql="UPDATE "+getTableName()+" set CONTRACTID=@{CONTRACTID},SHOPNAME=@{SHOPNAME},SHOPACCOUNT=@{SHOPACCOUNT},CITY=@{CITY},PROVINCE=@{PROVINCE},BEGINDATE=@{BEGINDATE},ENDDATE=@{ENDDATE},DURATION=@{DURATION},ADDRESS=@{ADDRESS},NULL=@{NULL},NULL1=@{NULL1},NULL2=@{NULL2},CREATETIME=@{CREATETIME},NULL3=@{NULL3},NULL4=@{NULL4},SHOPCODE=@{SHOPCODE},NULL5=@{NULL5},NULL6=@{NULL6},NULL7=@{NULL7},NULL8=@{NULL8},NULL9=@{NULL9},NULL10=@{NULL10},NULL11=@{NULL11},NULL12=@{NULL12},id=@{id} WHERE SHOPID=@{SHOPID}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopsaasMapping.SHOPID, shopsaas.getSHOPID());
        sqlParameter.add(ShopsaasMapping.CONTRACTID, shopsaas.getCONTRACTID());
        sqlParameter.add(ShopsaasMapping.SHOPNAME, shopsaas.getSHOPNAME());
        sqlParameter.add(ShopsaasMapping.SHOPACCOUNT, shopsaas.getSHOPACCOUNT());
        sqlParameter.add(ShopsaasMapping.CITY, shopsaas.getCITY());
        sqlParameter.add(ShopsaasMapping.PROVINCE, shopsaas.getPROVINCE());
        sqlParameter.add(ShopsaasMapping.BEGINDATE, shopsaas.getBEGINDATE());
        sqlParameter.add(ShopsaasMapping.ENDDATE, shopsaas.getENDDATE());
        sqlParameter.add(ShopsaasMapping.DURATION, shopsaas.getDURATION());
        sqlParameter.add(ShopsaasMapping.ADDRESS, shopsaas.getADDRESS());
        sqlParameter.add(ShopsaasMapping.NULL, shopsaas.getNULL());
        sqlParameter.add(ShopsaasMapping.NULL1, shopsaas.getNULL1());
        sqlParameter.add(ShopsaasMapping.NULL2, shopsaas.getNULL2());
        sqlParameter.add(ShopsaasMapping.CREATETIME, shopsaas.getCREATETIME());
        sqlParameter.add(ShopsaasMapping.NULL3, shopsaas.getNULL3());
        sqlParameter.add(ShopsaasMapping.NULL4, shopsaas.getNULL4());
        sqlParameter.add(ShopsaasMapping.SHOPCODE, shopsaas.getSHOPCODE());
        sqlParameter.add(ShopsaasMapping.NULL5, shopsaas.getNULL5());
        sqlParameter.add(ShopsaasMapping.NULL6, shopsaas.getNULL6());
        sqlParameter.add(ShopsaasMapping.NULL7, shopsaas.getNULL7());
        sqlParameter.add(ShopsaasMapping.NULL8, shopsaas.getNULL8());
        sqlParameter.add(ShopsaasMapping.NULL9, shopsaas.getNULL9());
        sqlParameter.add(ShopsaasMapping.NULL10, shopsaas.getNULL10());
        sqlParameter.add(ShopsaasMapping.NULL11, shopsaas.getNULL11());
        sqlParameter.add(ShopsaasMapping.NULL12, shopsaas.getNULL12());
        sqlParameter.add(ShopsaasMapping.Id, shopsaas.getId());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String sHOPID)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE SHOPID=@{SHOPID}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopsaasMapping.SHOPID,sHOPID);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Shopsaas searchBySHOPID(java.lang.String sHOPID)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE SHOPID=@{SHOPID}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopsaasMapping.SHOPID,sHOPID);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Shopsaas.class);
    }
    public PagedList<Shopsaas> searchByPage(QueryCondition queryCondition) {
        PagedList<Shopsaas> pagedList=this.searchByPage(queryCondition, Shopsaas.class);
        return pagedList;
    }
    public List<Shopsaas> searchList(QueryParameter queryParameter) {
                List<Shopsaas> list=this.searchList(queryParameter, Shopsaas.class);
                    return list;
    }
}
