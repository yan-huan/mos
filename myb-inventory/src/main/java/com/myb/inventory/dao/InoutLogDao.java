package com.myb.inventory.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InoutLog;
import com.myb.entity.pojo.inventory.InoutLogMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inoutLogDao")
public class InoutLogDao extends MySqlCommandBase
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
        return "inout_log";
    }


    public int insert(InoutLog inoutLog) {
        String sql="INSERT INTO "+getTableName()+" (id,inout_code,inventory_sku_code,inventory_code,inventory_item_code,type,reason,old_stock_number,old_available_stock_number,old_occupy_stock_number,change_stock_number,new_stock_number,new_available_stock_number,new_occupy_stock_number,create_time,create_user_code,create_user_name)VALUES(@{id},@{inout_code},@{inventory_sku_code},@{inventory_code},@{inventory_item_code},@{type},@{reason},@{old_stock_number},@{old_available_stock_number},@{old_occupy_stock_number},@{change_stock_number},@{new_stock_number},@{new_available_stock_number},@{new_occupy_stock_number},@{create_time},@{create_user_code},@{create_user_name})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InoutLogMapping.Id, inoutLog.getId());
        sqlParameter.add(InoutLogMapping.InoutCode, inoutLog.getInoutCode());
        sqlParameter.add(InoutLogMapping.InventorySkuCode, inoutLog.getInventorySkuCode());
        sqlParameter.add(InoutLogMapping.InventoryCode, inoutLog.getInventoryCode());
        sqlParameter.add(InoutLogMapping.InventoryItemCode, inoutLog.getInventoryItemCode());
        sqlParameter.add(InoutLogMapping.Type, inoutLog.getType());
        sqlParameter.add(InoutLogMapping.Reason, inoutLog.getReason());
        sqlParameter.add(InoutLogMapping.OldStockNumber, inoutLog.getOldStockNumber());
        sqlParameter.add(InoutLogMapping.OldAvailableStockNumber, inoutLog.getOldAvailableStockNumber());
        sqlParameter.add(InoutLogMapping.OldOccupyStockNumber, inoutLog.getOldOccupyStockNumber());
        sqlParameter.add(InoutLogMapping.ChangeStockNumber, inoutLog.getChangeStockNumber());
        sqlParameter.add(InoutLogMapping.NewStockNumber, inoutLog.getNewStockNumber());
        sqlParameter.add(InoutLogMapping.NewAvailableStockNumber, inoutLog.getNewAvailableStockNumber());
        sqlParameter.add(InoutLogMapping.NewOccupyStockNumber, inoutLog.getNewOccupyStockNumber());
        sqlParameter.add(InoutLogMapping.CreateTime, inoutLog.getCreateTime());
        sqlParameter.add(InoutLogMapping.CreateUserCode, inoutLog.getCreateUserCode());
        sqlParameter.add(InoutLogMapping.CreateUserName, inoutLog.getCreateUserName());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    /**
     * 查询出入库流水分页（从库）
     * @author hailin.liu 2016年5月19日 下午12:17:23 <br/>
     * @param queryCondition
     * @return
     */
    public PagedList<InoutLog> searchByPage(QueryCondition queryCondition) {
        PagedList<InoutLog> pagedList=this.searchByPage(queryCondition, InoutLog.class, dataCommandRead);
        return pagedList;
    }
}
