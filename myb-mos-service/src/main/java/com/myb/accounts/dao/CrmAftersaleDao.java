package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.CrmAftersale;
import com.myb.entity.pojo.mos.CrmAftersaleMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("crmAftersaleDao")
public class CrmAftersaleDao extends MySqlCommandBase
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
        return "crm_aftersale";
    }


    public int insert(CrmAftersale crmAftersale)
    {
        String sql="INSERT INTO "+getTableName()+" (id,shopId,isDistribute,createTime,distributedId,isFinish,visitTimes,isCheck,quyu)VALUES(@{id},@{shopId},@{isDistribute},@{createTime},@{distributedId},@{isFinish},@{visitTimes},@{isCheck},@{quyu})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmAftersaleMapping.Id, crmAftersale.getId());
        sqlParameter.add(CrmAftersaleMapping.ShopId, crmAftersale.getShopId());
        sqlParameter.add(CrmAftersaleMapping.IsDistribute, crmAftersale.getIsDistribute());
        sqlParameter.add(CrmAftersaleMapping.CreateTime, crmAftersale.getCreateTime());
        sqlParameter.add(CrmAftersaleMapping.DistributedId, crmAftersale.getDistributedId());
        sqlParameter.add(CrmAftersaleMapping.IsFinish, crmAftersale.getIsFinish());
        sqlParameter.add(CrmAftersaleMapping.VisitTimes, crmAftersale.getVisitTimes());
        sqlParameter.add(CrmAftersaleMapping.IsCheck, crmAftersale.getIsCheck());
        sqlParameter.add(CrmAftersaleMapping.Quyu, crmAftersale.getQuyu());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(CrmAftersale crmAftersale)
    {
        String sql="UPDATE "+getTableName()+" set shopId=@{shopId},isDistribute=@{isDistribute},createTime=@{createTime},distributedId=@{distributedId},isFinish=@{isFinish},visitTimes=@{visitTimes},isCheck=@{isCheck},quyu=@{quyu} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmAftersaleMapping.Id, crmAftersale.getId());
        sqlParameter.add(CrmAftersaleMapping.ShopId, crmAftersale.getShopId());
        sqlParameter.add(CrmAftersaleMapping.IsDistribute, crmAftersale.getIsDistribute());
        sqlParameter.add(CrmAftersaleMapping.CreateTime, crmAftersale.getCreateTime());
        sqlParameter.add(CrmAftersaleMapping.DistributedId, crmAftersale.getDistributedId());
        sqlParameter.add(CrmAftersaleMapping.IsFinish, crmAftersale.getIsFinish());
        sqlParameter.add(CrmAftersaleMapping.VisitTimes, crmAftersale.getVisitTimes());
        sqlParameter.add(CrmAftersaleMapping.IsCheck, crmAftersale.getIsCheck());
        sqlParameter.add(CrmAftersaleMapping.Quyu, crmAftersale.getQuyu());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(long id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmAftersaleMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public CrmAftersale searchById(long id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmAftersaleMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, CrmAftersale.class);
    }
    public PagedList<CrmAftersale> searchByPage(QueryCondition queryCondition) {
        PagedList<CrmAftersale> pagedList=this.searchByPage(queryCondition, CrmAftersale.class);
        return pagedList;
    }
    public List<CrmAftersale> searchList(QueryParameter queryParameter) {
                List<CrmAftersale> list=this.searchList(queryParameter, CrmAftersale.class);
                    return list;
    }
}
