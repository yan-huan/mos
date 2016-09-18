package com.myb.inventory.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryStockCheckProfitShortages;
import com.myb.entity.pojo.inventory.InventoryStockCheckProfitShortagesMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryStockCheckProfitShortagesDao")
public class InventoryStockCheckProfitShortagesDao extends MySqlCommandBase
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
        return "inventory_stock_check_profit_shortages";
    }


    public int insert(InventoryStockCheckProfitShortages inventoryStockCheckProfitShortages)
    {
        String sql="INSERT INTO "+getTableName()+" (id,profit_shortages_code,stock_check_item_code,inventory_sku_code,comment,original_document,warehouse_code,warehouse_name,type,create_user_code,create_user_name,create_time)VALUES(@{id},@{profit_shortages_code},@{stock_check_item_code},@{inventory_sku_code},@{comment},@{original_document},@{warehouse_code},@{warehouse_name},@{type},@{create_user_code},@{create_user_name},@{create_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.Id, inventoryStockCheckProfitShortages.getId());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.ProfitShortagesCode, inventoryStockCheckProfitShortages.getProfitShortagesCode());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.StockCheckItemCode, inventoryStockCheckProfitShortages.getStockCheckItemCode());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.InventorySkuCode, inventoryStockCheckProfitShortages.getInventorySkuCode());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.Comment, inventoryStockCheckProfitShortages.getComment());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.OriginalDocument, inventoryStockCheckProfitShortages.getOriginalDocument());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.WarehouseCode, inventoryStockCheckProfitShortages.getWarehouseCode());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.WarehouseName, inventoryStockCheckProfitShortages.getWarehouseName());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.Type, inventoryStockCheckProfitShortages.getType());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.CreateUserCode, inventoryStockCheckProfitShortages.getCreateUserCode());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.CreateUserName, inventoryStockCheckProfitShortages.getCreateUserName());
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.CreateTime, inventoryStockCheckProfitShortages.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public InventoryStockCheckProfitShortages searchByCode(String profitShortagesCode) {
        String sql="SELECT * FROM "+getTableName()+" WHERE profit_shortages_code=@{profit_shortages_code}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckProfitShortagesMapping.ProfitShortagesCode,profitShortagesCode);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryStockCheckProfitShortages.class);
    }
    
}
