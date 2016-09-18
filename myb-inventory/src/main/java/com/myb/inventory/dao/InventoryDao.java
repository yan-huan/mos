package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.Inventory;
import com.myb.entity.pojo.inventory.InventoryItemMapping;
import com.myb.entity.pojo.inventory.InventoryMapping;
import com.myb.entity.pojo.inventory.InventorySkuMapping;
import com.myb.entity.pojo.inventory.model.InventorySkuModel;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;
import com.myb.inventory.cons.Cons;

@Repository("inventoryDao")
public class InventoryDao extends MySqlCommandBase
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
        return "inventory";
    }
    
    
    /**
     * 查询库存信息（从库）
     * @author hailin.liu 2016年5月18日 上午9:59:44 <br/>
     * @param parentCode		父仓code
     * @param childCode			子仓code
     * @return							库存信息
     */
    public Inventory getInventoryR(String inventoryCode, String inventoryType) {
    	StringBuilder sql=new StringBuilder("SELECT * FROM "+getTableName()+" WHERE inventory_code=@{inventory_code}");
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryMapping.InventoryCode,inventoryCode);
        if(StringUtils.isNotEmpty(inventoryType)) {
        	sql.append("  AND inventory_type = @{inventory_type}");
        	sqlParameter.add(InventoryMapping.InventoryType,inventoryType);
        }
        return this.dataCommandRead.executeEntity(sql.toString(), sqlParameter, Inventory.class);
    }
    
    /**
     * 查询库存信息(主库)
     * @param inventoryCode
     * @param inventoryType
     * @return
     */
    public Inventory getInventoryW(String inventoryCode, String inventoryType) {
    	StringBuilder sql=new StringBuilder("SELECT * FROM "+getTableName()+" WHERE inventory_code=@{inventory_code} AND inventory_type = @{inventory_type}");
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryMapping.InventoryCode,inventoryCode);
        sqlParameter.add(InventoryMapping.InventoryType,inventoryType);
        return this.dataCommandWrite.executeEntity(sql.toString(), sqlParameter, Inventory.class);
    }
    
    
    /**
     * 查询库存商品集合
     * @author hailin.liu 2016年5月16日 下午1:10:53 <br/>
     * @param parentCode			父仓code
     * @param childCode				子仓code
     * @param inventoryType		仓库类型
     * @param productType			商品类型
     * @return								List<InventorySkuModel>
     */
    public List<InventorySkuModel> getInventorySkuList(String parentCode, String childCode, String inventoryType, String productType, String status, Integer startTime, Integer endTime) {
    	StringBuilder sql= new StringBuilder("SELECT isk.product_brand_code, isk.product_brand_name, isk.product_code, isk.product_name, isk.product_unit, ii.stock_number, isk.market_price, ii.version, isk.product_type FROM inventory i, inventory_item ii, inventory_sku isk WHERE i.inventory_code=ii.inventory_code AND ii.inventory_sku_code=isk.inventory_sku_code AND i.inventory_type=@{inventory_type}");
    	SqlParameter sqlParameter=new SqlParameter();
    	sqlParameter.add(InventoryMapping.InventoryType,inventoryType);
    	if(StringUtils.isNotEmpty(parentCode)) {
    		sql.append(" AND i.parent_code=@{parent_code} ");
    		sqlParameter.add(InventoryMapping.ParentCode,parentCode);
    	}
    	if(StringUtils.isNotEmpty(childCode)) {
    		sql.append(" AND i.child_code = @{child_code} ");
    		sqlParameter.add(InventoryMapping.ChildCode,childCode);
    	}
    	if(StringUtils.isNotEmpty(productType)) {
    		sql.append(" AND isk.product_type = @{product_type} ");
    		sqlParameter.add(InventorySkuMapping.ProductType,productType);
    	}
    	if(startTime != null) {
    		sql.append(" AND ii.create_time >= @{create_time} ");
    		sqlParameter.add(InventoryItemMapping.CreateTime, startTime);
    	}
    	if(endTime != null) {
    		sql.append(" AND ii.create_time <= @{create_time} ");
    		sqlParameter.add(InventoryItemMapping.CreateTime, endTime);
    	}
    	
    	if(StringUtils.isNotEmpty(status)) {
    		sql.append(" AND i.status = @{status} ");
    		sqlParameter.add(InventoryMapping.Status,status);
    	} else {
    		sql.append(" AND i.status = @{status} ");
    		sqlParameter.add(InventoryMapping.Status,Cons.STATUS_NORMAL);
    	}
    	
    	sql.append(" ORDER BY ii.create_time DESC ");
    	
        return dataCommandRead.executeList(sql.toString(), sqlParameter, InventorySkuModel.class);
    }

    public int insert(Inventory inventory) {
        String sql="INSERT INTO "+getTableName()+" (id,inventory_code,inventory_name,parent_code,child_code,inventory_type,status,create_time,create_user_code,create_user_name)VALUES(@{id},@{inventory_code},@{inventory_name},@{parent_code},@{child_code},@{inventory_type},@{status},@{create_time},@{create_user_code},@{create_user_name})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryMapping.Id, inventory.getId());
        sqlParameter.add(InventoryMapping.InventoryCode, inventory.getInventoryCode());
        sqlParameter.add(InventoryMapping.InventoryName, inventory.getInventoryName());
        sqlParameter.add(InventoryMapping.ParentCode, inventory.getParentCode());
        sqlParameter.add(InventoryMapping.ChildCode, inventory.getChildCode());
        sqlParameter.add(InventoryMapping.InventoryType, inventory.getInventoryType());
        sqlParameter.add(InventoryMapping.Status, inventory.getStatus());
        sqlParameter.add(InventoryMapping.CreateTime, inventory.getCreateTime());
        sqlParameter.add(InventoryMapping.CreateUserCode, inventory.getCreateUserCode());
        sqlParameter.add(InventoryMapping.CreateUserName, inventory.getCreateUserName());
//        sqlParameter.add(InventoryMapping.UpdateTime, inventory.getUpdateTime());
//        sqlParameter.add(InventoryMapping.UpdateUserCode, inventory.getUpdateUserCode());
//        sqlParameter.add(InventoryMapping.UpdateUserName, inventory.getUpdateUserName());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Inventory searchByInventoryCode(java.lang.String inventoryCode) {
        String sql="SELECT * FROM "+getTableName()+" WHERE inventory_code=@{inventory_code}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryMapping.InventoryCode,inventoryCode);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Inventory.class);
    }
    public PagedList<Inventory> searchByPage(QueryCondition queryCondition) {
        PagedList<Inventory> pagedList=this.searchByPage(queryCondition, Inventory.class);
        return pagedList;
    }
    
    public List<Inventory> searchList(QueryParameter queryParameter) {
                List<Inventory> list=this.searchList(queryParameter, Inventory.class);
                    return list;
    }
    
    /**
     * 查询库存信息
     * @param queryParameter
     * @return
     */
    public Inventory searchInventory(QueryParameter queryParameter) {
    	Inventory inventory = this.searchEntity(queryParameter, Inventory.class);
    	return inventory;
    }
}
