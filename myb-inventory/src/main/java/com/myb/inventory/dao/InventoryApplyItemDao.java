package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryApplyItem;
import com.myb.entity.pojo.inventory.InventoryApplyItemMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryApplyItemDao")
public class InventoryApplyItemDao extends MySqlCommandBase {
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
        return "inventory_apply_item";
    }


    public int insert(InventoryApplyItem inventoryApplyItem)
    {
        String sql="INSERT INTO "+getTableName()+" (id,apply_item_code,apply_code,inventory_sku_code,quantity,create_user_code,create_user_name,create_time)VALUES(@{id},@{apply_item_code},@{apply_code},@{inventory_sku_code},@{quantity},@{create_user_code},@{create_user_name},@{create_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryApplyItemMapping.Id, inventoryApplyItem.getId());
        sqlParameter.add(InventoryApplyItemMapping.ApplyItemCode, inventoryApplyItem.getApplyItemCode());
        sqlParameter.add(InventoryApplyItemMapping.ApplyCode, inventoryApplyItem.getApplyCode());
        sqlParameter.add(InventoryApplyItemMapping.InventorySkuCode, inventoryApplyItem.getInventorySkuCode());
        sqlParameter.add(InventoryApplyItemMapping.Quantity, inventoryApplyItem.getQuantity());
        sqlParameter.add(InventoryApplyItemMapping.CreateUserCode, inventoryApplyItem.getCreateUserCode());
        sqlParameter.add(InventoryApplyItemMapping.CreateUserName, inventoryApplyItem.getCreateUserName());
        sqlParameter.add(InventoryApplyItemMapping.CreateTime, inventoryApplyItem.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public PagedList<InventoryApplyItem> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryApplyItem> pagedList=this.searchByPage(queryCondition, InventoryApplyItem.class);
        return pagedList;
    }
    public List<InventoryApplyItem> searchList(QueryParameter queryParameter) {
                List<InventoryApplyItem> list=this.searchList(queryParameter, InventoryApplyItem.class);
                    return list;
    }
}
