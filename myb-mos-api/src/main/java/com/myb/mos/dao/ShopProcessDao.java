package com.myb.mos.dao;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

import com.myb.entity.pojo.mos.ShopProcess;

import com.myb.entity.pojo.mos.ShopProcessMapping;

@Repository("shopProcessDao")
public class ShopProcessDao extends MySqlCommandBase
{

    @Resource(name = "datacommand")
    private DataCommand dataCommand;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommand);
    }
    @Override
    public String getTableName()
    {
        return "shop_process";
    }


    public int insert(ShopProcess shopProcess)
    {
        String sql="INSERT INTO "+getTableName()+" (id,shopId,isEscort,clientLevel,isValide,process,reason,createTime,amount,finishTime,employeeId)VALUES(@{id},@{shopId},@{isEscort},@{clientLevel},@{isValide},@{process},@{reason},@{createTime},@{amount},@{finishTime},@{employeeId})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopProcessMapping.Id, shopProcess.getId());
        sqlParameter.add(ShopProcessMapping.ShopId, shopProcess.getShopId());
        sqlParameter.add(ShopProcessMapping.IsEscort, shopProcess.getIsEscort());
        sqlParameter.add(ShopProcessMapping.ClientLevel, shopProcess.getClientLevel());
        sqlParameter.add(ShopProcessMapping.IsValide, shopProcess.getIsValide());
        sqlParameter.add(ShopProcessMapping.Process, shopProcess.getProcess());
        sqlParameter.add(ShopProcessMapping.Reason, shopProcess.getReason());
        sqlParameter.add(ShopProcessMapping.CreateTime, shopProcess.getCreateTime());
        sqlParameter.add(ShopProcessMapping.Amount, shopProcess.getAmount());
        sqlParameter.add(ShopProcessMapping.FinishTime, shopProcess.getFinishTime());
        sqlParameter.add(ShopProcessMapping.EmployeeId, shopProcess.getEmployeeId());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(ShopProcess shopProcess)
    {
        String sql="UPDATE "+getTableName()+" set shopId=@{shopId},isEscort=@{isEscort},clientLevel=@{clientLevel},isValide=@{isValide},process=@{process},reason=@{reason},createTime=@{createTime},amount=@{amount},finishTime=@{finishTime},employeeId=@{employeeId} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopProcessMapping.Id, shopProcess.getId());
        sqlParameter.add(ShopProcessMapping.ShopId, shopProcess.getShopId());
        sqlParameter.add(ShopProcessMapping.IsEscort, shopProcess.getIsEscort());
        sqlParameter.add(ShopProcessMapping.ClientLevel, shopProcess.getClientLevel());
        sqlParameter.add(ShopProcessMapping.IsValide, shopProcess.getIsValide());
        sqlParameter.add(ShopProcessMapping.Process, shopProcess.getProcess());
        sqlParameter.add(ShopProcessMapping.Reason, shopProcess.getReason());
        sqlParameter.add(ShopProcessMapping.CreateTime, shopProcess.getCreateTime());
        sqlParameter.add(ShopProcessMapping.Amount, shopProcess.getAmount());
        sqlParameter.add(ShopProcessMapping.FinishTime, shopProcess.getFinishTime());
        sqlParameter.add(ShopProcessMapping.EmployeeId, shopProcess.getEmployeeId());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(long id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopProcessMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public ShopProcess searchById(long id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopProcessMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, ShopProcess.class);
    }
    public PagedList<ShopProcess> searchByPage(QueryCondition queryCondition) {
        PagedList<ShopProcess> pagedList=this.searchByPage(queryCondition, ShopProcess.class);
        return pagedList;
    }
    public List<ShopProcess> searchList(QueryParameter queryParameter) {
                List<ShopProcess> list=this.searchList(queryParameter, ShopProcess.class);
                    return list;
    }
    public ShopProcess searchByShopId(Long shopId){
    	String sql="SELECT * FROM "+getTableName()+" WHERE shopId=@{shopId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ShopProcessMapping.ShopId,shopId);
        return this.dataCommand.executeEntity(sql, sqlParameter, ShopProcess.class);
    }
}
