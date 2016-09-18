package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryStockCheckLog;
import com.myb.entity.pojo.inventory.InventoryStockCheckLogMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryStockCheckLogDao")
public class InventoryStockCheckLogDao extends MySqlCommandBase
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
        return "inventory_stock_check_log";
    }


    public int insert(InventoryStockCheckLog inventoryStockCheckLog)
    {
        String sql="INSERT INTO "+getTableName()+" (id,stock_check_item_code,descripe,operator_code,operate_time)VALUES(@{id},@{stock_check_item_code},@{descripe},@{operator_code},@{operate_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckLogMapping.Id, inventoryStockCheckLog.getId());
        sqlParameter.add(InventoryStockCheckLogMapping.StockCheckItemCode, inventoryStockCheckLog.getStockCheckItemCode());
        sqlParameter.add(InventoryStockCheckLogMapping.Descripe, inventoryStockCheckLog.getDescripe());
        sqlParameter.add(InventoryStockCheckLogMapping.OperatorCode, inventoryStockCheckLog.getOperatorCode());
        sqlParameter.add(InventoryStockCheckLogMapping.OperateTime, inventoryStockCheckLog.getOperateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(InventoryStockCheckLog inventoryStockCheckLog)
    {
        String sql="UPDATE "+getTableName()+" set stock_check_item_code=@{stock_check_item_code},descripe=@{descripe},operator_code=@{operator_code},operate_time=@{operate_time} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckLogMapping.Id, inventoryStockCheckLog.getId());
        sqlParameter.add(InventoryStockCheckLogMapping.StockCheckItemCode, inventoryStockCheckLog.getStockCheckItemCode());
        sqlParameter.add(InventoryStockCheckLogMapping.Descripe, inventoryStockCheckLog.getDescripe());
        sqlParameter.add(InventoryStockCheckLogMapping.OperatorCode, inventoryStockCheckLog.getOperatorCode());
        sqlParameter.add(InventoryStockCheckLogMapping.OperateTime, inventoryStockCheckLog.getOperateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckLogMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public InventoryStockCheckLog searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckLogMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryStockCheckLog.class);
    }
    public PagedList<InventoryStockCheckLog> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryStockCheckLog> pagedList=this.searchByPage(queryCondition, InventoryStockCheckLog.class);
        return pagedList;
    }
    public List<InventoryStockCheckLog> searchList(QueryParameter queryParameter) {
                List<InventoryStockCheckLog> list=this.searchList(queryParameter, InventoryStockCheckLog.class);
                    return list;
    }
}
