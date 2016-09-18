package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryStockCheck;
import com.myb.entity.pojo.inventory.InventoryStockCheckMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryStockCheckDao")
public class InventoryStockCheckDao extends MySqlCommandBase
{

    @Resource(name = "datacommand_inventory_write")
    private DataCommand dataCommandWrite;
    
    @Resource(name = "datacommand_inventory_read")
    private DataCommand dataCommandRead;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName()
    {
        return "inventory_stock_check";
    }


    public InventoryStockCheck insert(InventoryStockCheck inventoryStockCheck)
    {
        String sql="INSERT INTO "+getTableName()+" (id,stock_check_code,inventory_code,status,start_time,end_time,create_user_code,create_user_name,create_time)VALUES(@{id},@{stock_check_code},@{inventory_code},@{status},@{start_time},@{end_time},@{create_user_code},@{create_user_name},@{create_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckMapping.Id, inventoryStockCheck.getId());
        sqlParameter.add(InventoryStockCheckMapping.StockCheckCode, inventoryStockCheck.getStockCheckCode());
        sqlParameter.add(InventoryStockCheckMapping.InventoryCode, inventoryStockCheck.getInventoryCode());
        sqlParameter.add(InventoryStockCheckMapping.Status, inventoryStockCheck.getStatus());
        sqlParameter.add(InventoryStockCheckMapping.StartTime, inventoryStockCheck.getStartTime());
        sqlParameter.add(InventoryStockCheckMapping.EndTime, inventoryStockCheck.getEndTime());
        sqlParameter.add(InventoryStockCheckMapping.CreateUserCode, inventoryStockCheck.getCreateUserCode());
        sqlParameter.add(InventoryStockCheckMapping.CreateUserName, inventoryStockCheck.getCreateUserName());
        sqlParameter.add(InventoryStockCheckMapping.CreateTime, inventoryStockCheck.getCreateTime());
        int id = (this.getDataCommand().insertAndGetKey(sql, sqlParameter)).intValue();
        inventoryStockCheck.setId(id);
        return inventoryStockCheck;
    }

    public int update(InventoryStockCheck inventoryStockCheck)
    {
        String sql="UPDATE "+getTableName()+" set stock_check_code=@{stock_check_code},inventory_code=@{inventory_code},status=@{status},start_time=@{start_time},end_time=@{end_time},create_user_code=@{create_user_code},create_user_name=@{create_user_name},create_time=@{create_time} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckMapping.Id, inventoryStockCheck.getId());
        sqlParameter.add(InventoryStockCheckMapping.StockCheckCode, inventoryStockCheck.getStockCheckCode());
        sqlParameter.add(InventoryStockCheckMapping.InventoryCode, inventoryStockCheck.getInventoryCode());
        sqlParameter.add(InventoryStockCheckMapping.Status, inventoryStockCheck.getStatus());
        sqlParameter.add(InventoryStockCheckMapping.StartTime, inventoryStockCheck.getStartTime());
        sqlParameter.add(InventoryStockCheckMapping.EndTime, inventoryStockCheck.getEndTime());
        sqlParameter.add(InventoryStockCheckMapping.CreateUserCode, inventoryStockCheck.getCreateUserCode());
        sqlParameter.add(InventoryStockCheckMapping.CreateUserName, inventoryStockCheck.getCreateUserName());
        sqlParameter.add(InventoryStockCheckMapping.CreateTime, inventoryStockCheck.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }
    
    /**
     * 根据code查询盘点记录
     * @author hailin.liu 2016年5月18日 下午2:36:31 <br/>
     * @param code
     * @return
     */
    public InventoryStockCheck searchByCodeR(String code) {
        String sql="SELECT * FROM "+getTableName()+" WHERE stock_check_code=@{stock_check_code}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckMapping.StockCheckCode,code);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryStockCheck.class);
    }

    public InventoryStockCheck searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryStockCheck.class);
    }
    public PagedList<InventoryStockCheck> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryStockCheck> pagedList=this.searchByPage(queryCondition, InventoryStockCheck.class, dataCommandRead);
        return pagedList;
    }
    public List<InventoryStockCheck> searchList(QueryParameter queryParameter) {
                List<InventoryStockCheck> list=this.searchList(queryParameter, InventoryStockCheck.class, dataCommandRead);
                    return list;
    }
}
