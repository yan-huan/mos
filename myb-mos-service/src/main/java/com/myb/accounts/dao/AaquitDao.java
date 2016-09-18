package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Aaquit;
import com.myb.entity.pojo.mos.AaquitMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("aaquitDao")
public class AaquitDao extends MySqlCommandBase
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
        return "aaquit";
    }


    public int insert(Aaquit aaquit)
    {
        String sql="INSERT INTO "+getTableName()+" (aa)VALUES(@{aa})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaquitMapping.Aa, aaquit.getAa());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Aaquit aaquit)
    {
        String sql="UPDATE "+getTableName()+" set  WHERE aa=@{aa}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaquitMapping.Aa, aaquit.getAa());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String aa)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE aa=@{aa}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaquitMapping.Aa,aa);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Aaquit searchByAa(java.lang.String aa)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE aa=@{aa}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaquitMapping.Aa,aa);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Aaquit.class);
    }
    public PagedList<Aaquit> searchByPage(QueryCondition queryCondition) {
        PagedList<Aaquit> pagedList=this.searchByPage(queryCondition, Aaquit.class);
        return pagedList;
    }
    public List<Aaquit> searchList(QueryParameter queryParameter) {
                List<Aaquit> list=this.searchList(queryParameter, Aaquit.class);
                    return list;
    }
}
