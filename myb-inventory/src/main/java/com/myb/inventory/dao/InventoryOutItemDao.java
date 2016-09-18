package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryOutItem;
import com.myb.entity.pojo.inventory.InventoryOutItemMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryOutItemDao")
public class InventoryOutItemDao extends MySqlCommandBase
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
        return "inventory_out_item";
    }


    public int insert(InventoryOutItem inventoryOutItem)
    {
        String sql="INSERT INTO "+getTableName()+" (id,out_item_code,out_code,inventory_sku_code,quantity,status,create_user_code,create_user_name,create_time)VALUES(@{id},@{out_item_code},@{out_code},@{inventory_sku_code},@{quantity},@{status},@{create_user_code},@{create_user_name},@{create_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryOutItemMapping.Id, inventoryOutItem.getId());
        sqlParameter.add(InventoryOutItemMapping.OutItemCode, inventoryOutItem.getOutItemCode());
        sqlParameter.add(InventoryOutItemMapping.OutCode, inventoryOutItem.getOutCode());
        sqlParameter.add(InventoryOutItemMapping.InventorySkuCode, inventoryOutItem.getInventorySkuCode());
        sqlParameter.add(InventoryOutItemMapping.Quantity, inventoryOutItem.getQuantity());
        sqlParameter.add(InventoryOutItemMapping.Status, inventoryOutItem.getStatus());
        sqlParameter.add(InventoryOutItemMapping.CreateUserCode, inventoryOutItem.getCreateUserCode());
        sqlParameter.add(InventoryOutItemMapping.CreateUserName, inventoryOutItem.getCreateUserName());
        sqlParameter.add(InventoryOutItemMapping.CreateTime, inventoryOutItem.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public InventoryOutItem searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryOutItemMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryOutItem.class);
    }
    public PagedList<InventoryOutItem> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryOutItem> pagedList=this.searchByPage(queryCondition, InventoryOutItem.class, dataCommandRead);
        return pagedList;
    }
    public List<InventoryOutItem> searchList(QueryParameter queryParameter) {
                List<InventoryOutItem> list=this.searchList(queryParameter, InventoryOutItem.class, dataCommandRead);
                    return list;
    }
}
