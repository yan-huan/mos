package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryItem;
import com.myb.entity.pojo.inventory.InventoryItemMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;
import com.myb.inventory.cons.Cons;

@Repository("inventoryItemDao")
public class InventoryItemDao extends MySqlCommandBase
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
        return "inventory_item";
    }
    
    
    /**
     * 根据库存商品code和库存code查询库存详情(某一个仓库的)
     * @author hailin.liu 2016年5月16日 下午4:37:47 <br/>
     * @param inventorySkuCode				库存商品code
     * @return											库存详情
     */
    public List<InventoryItem> searchBySkuCode(String inventorySkuCodes, String inventoryCode, String status) {
        StringBuilder sql=new StringBuilder("SELECT * FROM "+getTableName()+" WHERE inventory_sku_code in (@{inventory_sku_code}) AND inventory_code=@{inventory_code}");
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryItemMapping.InventorySkuCode,inventorySkuCodes);
        sqlParameter.add(InventoryItemMapping.InventoryCode,inventoryCode);
        if(StringUtils.isNotEmpty(status)) {
        	sql.append(" AND status=@{status} ");
        	sqlParameter.add(InventoryItemMapping.Status,status);
        } else {
        	sql.append(" AND status=@{status} ");
        	sqlParameter.add(InventoryItemMapping.Status,Cons.STATUS_NORMAL);
        }
        return this.dataCommandRead.executeList(sql.toString(), sqlParameter, InventoryItem.class);
    }
    
    /**
     * 根据库存明细code查询库存明细(从库)
     * @param queryParameter
     * @return
     */
    public InventoryItem searchEntityR(QueryParameter queryParameter) {
    	return this.searchEntity(queryParameter, InventoryItem.class, this.dataCommandRead);
    }
    
    /**
     * 插入库存明细
     * @author hailin.liu 2016年5月16日 下午8:51:15 <br/>
     * @param inventoryItem	库存明细
     * @return
     */
    public int insert(InventoryItem inventoryItem) {
        String sql="INSERT INTO "+getTableName()+" (id,inventory_item_code,inventory_code,inventory_sku_code,saverage_price,tock_number,available_stock_number,occupy_stock_number,status,version,create_time,create_user_code,create_user_name,update_time,update_user_code,update_user_name)VALUES(@{id},@{inventory_item_code},@{inventory_code},@{inventory_sku_code},@{stock_number},@{available_stock_number},@{occupy_stock_number},@{status},@{version},@{create_time},@{create_user_code},@{create_user_name},@{update_time},@{update_user_code},@{update_user_name})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryItemMapping.Id, inventoryItem.getId());
        sqlParameter.add(InventoryItemMapping.InventoryItemCode, inventoryItem.getInventoryItemCode());
        sqlParameter.add(InventoryItemMapping.InventoryCode, inventoryItem.getInventoryCode());
        sqlParameter.add(InventoryItemMapping.InventorySkuCode, inventoryItem.getInventorySkuCode());
        sqlParameter.add(InventoryItemMapping.AveragePrice, inventoryItem.getAveragePrice());
        sqlParameter.add(InventoryItemMapping.StockNumber, inventoryItem.getStockNumber());
        sqlParameter.add(InventoryItemMapping.AvailableStockNumber, inventoryItem.getAvailableStockNumber());
        sqlParameter.add(InventoryItemMapping.OccupyStockNumber, inventoryItem.getOccupyStockNumber());
        sqlParameter.add(InventoryItemMapping.Status, inventoryItem.getStatus());
        sqlParameter.add(InventoryItemMapping.Version, inventoryItem.getVersion());
        sqlParameter.add(InventoryItemMapping.CreateTime, inventoryItem.getCreateTime());
        sqlParameter.add(InventoryItemMapping.CreateUserCode, inventoryItem.getCreateUserCode());
        sqlParameter.add(InventoryItemMapping.CreateUserName, inventoryItem.getCreateUserName());
        sqlParameter.add(InventoryItemMapping.UpdateTime, inventoryItem.getUpdateTime());
        sqlParameter.add(InventoryItemMapping.UpdateUserCode, inventoryItem.getUpdateUserCode());
        sqlParameter.add(InventoryItemMapping.UpdateUserName, inventoryItem.getUpdateUserName());
        return (int) this.dataCommandWrite.insertAndGetKey(sql, sqlParameter);
    }
    
    /**
     * 库存增加
     * @author hailin.liu 2016年5月17日 上午11:24:49 <br/>
     * @param inventoryItemId
     * @param quantity
     * @return
     */
    public int updateAddInventoryQuantity(Integer inventoryItemId, Integer quantity, Integer version, String updateUserCode, String updateUserName, Integer updateTime) {
    	String sql = "UPDATE " + getTableName() + " SET  stock_number = stock_number + @{stock_number} , available_stock_number = available_stock_number + @{available_stock_number}, version=version+1, update_user_code=@{update_user_code}, update_user_name=@{update_user_name}, update_time=@{update_time}  WHERE id=@{id} AND version=@{version}";
    	SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryItemMapping.Id, inventoryItemId);
        sqlParameter.add(InventoryItemMapping.StockNumber, quantity);
        sqlParameter.add(InventoryItemMapping.AvailableStockNumber, quantity);
        sqlParameter.add(InventoryItemMapping.Version, version);
        sqlParameter.add(InventoryItemMapping.UpdateUserCode, updateUserCode);
        sqlParameter.add(InventoryItemMapping.UpdateUserName, updateUserName);
        sqlParameter.add(InventoryItemMapping.UpdateTime, updateTime);
        return this.dataCommandWrite.executeNonQuery(sql, sqlParameter);
    }
    
    /**
     * 库存减少
     * @author hailin.liu 2016年5月17日 下午7:26:27 <br/>
     * @param inventoryItemId
     * @param quantity
     * @param version
     * @return
     */
    public int updateReduceInventoryQuantity(Integer inventoryItemId, Integer quantity, Integer version, String updateUserCode, String updateUserName, Integer updateTime) {
    	String sql = "UPDATE " + getTableName() + " SET  stock_number = stock_number - @{stock_number} , available_stock_number = available_stock_number - @{available_stock_number}, version=version+1, update_user_code=@{update_user_code}, update_user_name=@{update_user_name}, update_time=@{update_time} WHERE id=@{id} AND version=@{version}";
    	SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryItemMapping.Id, inventoryItemId);
        sqlParameter.add(InventoryItemMapping.StockNumber, quantity);
        sqlParameter.add(InventoryItemMapping.AvailableStockNumber, quantity);
        sqlParameter.add(InventoryItemMapping.Version, version);
        sqlParameter.add(InventoryItemMapping.UpdateUserCode, updateUserCode);
        sqlParameter.add(InventoryItemMapping.UpdateUserName, updateUserName);
        sqlParameter.add(InventoryItemMapping.UpdateTime, updateTime);
        return this.dataCommandWrite.executeNonQuery(sql, sqlParameter);
    }
    
    /**
     * 根据ID查询库存明细(主库)
     * @author hailin.liu 2016年5月17日 上午11:57:56 <br/>
     * @param id
     * @return
     */
    public InventoryItem searchByIdW(int id) {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryItemMapping.Id,id);
        return this.dataCommandWrite.executeEntity(sql, sqlParameter, InventoryItem.class);
    }
    
    public List<InventoryItem> searchListR(QueryParameter queryParameter) {
        List<InventoryItem> list=this.searchList(queryParameter, InventoryItem.class, dataCommandRead);
            return list;
    }
    
    /**
     * 更新加权平均价
     * @param inventoryItemId
     * @param averagePrice
     * @return
     */
    public int updateAveragePrice(Integer inventoryItemId, Double averagePrice) {
    	String sql = "UPDATE " + getTableName() + " SET average_price = @{average_price} WHERE id = @{id}";
    	SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryItemMapping.Id, inventoryItemId);
        sqlParameter.add(InventoryItemMapping.AveragePrice, averagePrice);
        return this.dataCommandWrite.executeNonQuery(sql, sqlParameter);
    }
    
}
