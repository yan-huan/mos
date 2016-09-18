package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Aaexceptionopenaccount;
import com.myb.entity.pojo.mos.AaexceptionopenaccountMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("aaexceptionopenaccountDao")
public class AaexceptionopenaccountDao extends MySqlCommandBase
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
        return "aaexceptionopenaccount";
    }


    public int insert(Aaexceptionopenaccount aaexceptionopenaccount)
    {
        String sql="INSERT INTO "+getTableName()+" (id,mobile)VALUES(@{id},@{mobile})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaexceptionopenaccountMapping.Id, aaexceptionopenaccount.getId());
        sqlParameter.add(AaexceptionopenaccountMapping.Mobile, aaexceptionopenaccount.getMobile());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Aaexceptionopenaccount aaexceptionopenaccount)
    {
        String sql="UPDATE "+getTableName()+" set mobile=@{mobile} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaexceptionopenaccountMapping.Id, aaexceptionopenaccount.getId());
        sqlParameter.add(AaexceptionopenaccountMapping.Mobile, aaexceptionopenaccount.getMobile());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaexceptionopenaccountMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Aaexceptionopenaccount searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AaexceptionopenaccountMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Aaexceptionopenaccount.class);
    }
    public PagedList<Aaexceptionopenaccount> searchByPage(QueryCondition queryCondition) {
        PagedList<Aaexceptionopenaccount> pagedList=this.searchByPage(queryCondition, Aaexceptionopenaccount.class);
        return pagedList;
    }
    public List<Aaexceptionopenaccount> searchList(QueryParameter queryParameter) {
                List<Aaexceptionopenaccount> list=this.searchList(queryParameter, Aaexceptionopenaccount.class);
                    return list;
    }
}
