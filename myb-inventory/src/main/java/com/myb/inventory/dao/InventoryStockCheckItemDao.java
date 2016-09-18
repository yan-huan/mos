package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryStockCheckItem;
import com.myb.entity.pojo.inventory.InventoryStockCheckItemMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryStockCheckItemDao")
public class InventoryStockCheckItemDao extends MySqlCommandBase
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
        return "inventory_stock_check_item";
    }


    public InventoryStockCheckItem insert(InventoryStockCheckItem inventoryStockCheckItem)
    {
        String sql="INSERT INTO "+getTableName()+" (id,stock_check_item_code,stock_check_code,inventory_sku_code,stock_quantity,fact_quantity,"
        		+ "difference_quantity,status,create_user_code,create_user_name,create_time) "
        		+ "VALUES "
        		+ "(@{id},@{stock_check_item_code}, @{stock_check_code}, @{inventory_sku_code},@{stock_quantity},@{fact_quantity},@{difference_quantity},@{status},"
        		+ "@{create_user_code},@{create_user_name},@{create_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckItemMapping.Id, inventoryStockCheckItem.getId());
        sqlParameter.add(InventoryStockCheckItemMapping.StockCheckItemCode, inventoryStockCheckItem.getStockCheckItemCode());
        sqlParameter.add(InventoryStockCheckItemMapping.StockCheckCode, inventoryStockCheckItem.getStockCheckCode());
        sqlParameter.add(InventoryStockCheckItemMapping.InventorySkuCode, inventoryStockCheckItem.getInventorySkuCode());
        sqlParameter.add(InventoryStockCheckItemMapping.StockQuantity, inventoryStockCheckItem.getStockQuantity());
        sqlParameter.add(InventoryStockCheckItemMapping.FactQuantity, inventoryStockCheckItem.getFactQuantity());
        sqlParameter.add(InventoryStockCheckItemMapping.DifferenceQuantity, inventoryStockCheckItem.getDifferenceQuantity());
        sqlParameter.add(InventoryStockCheckItemMapping.Status, inventoryStockCheckItem.getStatus());
        sqlParameter.add(InventoryStockCheckItemMapping.CreateUserCode, inventoryStockCheckItem.getCreateUserCode());
        sqlParameter.add(InventoryStockCheckItemMapping.CreateUserName, inventoryStockCheckItem.getCreateUserName());
        sqlParameter.add(InventoryStockCheckItemMapping.CreateTime, inventoryStockCheckItem.getCreateTime());
//        sqlParameter.add(InventoryStockCheckItemMapping.UpdateUserCode, inventoryStockCheckItem.getUpdateUserCode());
//        sqlParameter.add(InventoryStockCheckItemMapping.UpdateUserName, inventoryStockCheckItem.getUpdateUserName());
//        sqlParameter.add(InventoryStockCheckItemMapping.UpdateTime, inventoryStockCheckItem.getUpdateTime());
        int id = (this.getDataCommand().insertAndGetKey(sql, sqlParameter)).intValue();
        inventoryStockCheckItem.setId(id);
        return inventoryStockCheckItem;
    }
    
    /**
     * 更新状态
     * @author hailin.liu 2016年5月18日 下午9:06:20 <br/>
     * @param id
     * @param status
     * @param updateUserCode
     * @param updateUserName
     * @param updateTime
     * @return
     */
    public int updateStatusById(Integer id, String status, String updateUserCode, String updateUserName, Integer updateTime) {
    	String sql = "UPDATE " + getTableName() + " SET status=@{status}, update_user_code=@{update_user_code}, update_user_name=@{update_user_name}, update_time=@{update_time} WHERE id=@{id} ";
    	SqlParameter sqlParameter = new SqlParameter();
    	sqlParameter.add(InventoryStockCheckItemMapping.Status, status);
    	sqlParameter.add(InventoryStockCheckItemMapping.UpdateUserCode, updateUserCode);
    	sqlParameter.add(InventoryStockCheckItemMapping.UpdateUserName, updateUserName);
    	sqlParameter.add(InventoryStockCheckItemMapping.UpdateTime, updateTime);
    	sqlParameter.add(InventoryStockCheckItemMapping.Id, id);
    	return dataCommandWrite.executeNonQuery(sql, sqlParameter);
    }

    /**
     * 根据code查询盘点明细详情(从库)
     * @author hailin.liu 2016年5月18日 下午4:08:28 <br/>
     * @param code
     * @return
     */
    public InventoryStockCheckItem searchByCode(String code) {
        String sql="SELECT * FROM "+getTableName()+" WHERE stock_check_item_code=@{stock_check_item_code}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckItemMapping.StockCheckItemCode,code);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryStockCheckItem.class);
    }

    public InventoryStockCheckItem searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryStockCheckItemMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryStockCheckItem.class);
    }
    public PagedList<InventoryStockCheckItem> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryStockCheckItem> pagedList=this.searchByPage(queryCondition, InventoryStockCheckItem.class, dataCommandRead);
        return pagedList;
    }
    public List<InventoryStockCheckItem> searchListR(QueryParameter queryParameter) {
                List<InventoryStockCheckItem> list=this.searchList(queryParameter, InventoryStockCheckItem.class, this.dataCommandRead);
                    return list;
    }
}
