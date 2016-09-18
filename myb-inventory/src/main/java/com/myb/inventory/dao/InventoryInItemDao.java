package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryInItem;
import com.myb.entity.pojo.inventory.InventoryInItemMapping;
import com.myb.entity.pojo.inventory.InventoryInMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;
import com.myb.inventory.cons.Cons;

@Repository("inventoryInItemDao")
public class InventoryInItemDao extends MySqlCommandBase
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
        return "inventory_in_item";
    }


    public int insert(InventoryInItem inventoryInItem)
    {
        String sql="INSERT INTO "+getTableName()+" (id,in_item_code,in_code,inventory_sku_code,production_time,product_expired_time,single_price,quantity,status,create_user_code,create_user_name,create_time)VALUES(@{id},@{in_item_code},@{in_code},@{inventory_sku_code},@{production_time},@{product_expired_time},@{single_price},@{quantity},@{status},@{create_user_code},@{create_user_name},@{create_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInItemMapping.Id, inventoryInItem.getId());
        sqlParameter.add(InventoryInItemMapping.InItemCode, inventoryInItem.getInItemCode());
        sqlParameter.add(InventoryInItemMapping.InCode, inventoryInItem.getInCode());
        sqlParameter.add(InventoryInItemMapping.InventorySkuCode, inventoryInItem.getInventorySkuCode());
        sqlParameter.add(InventoryInItemMapping.ProductionTime, inventoryInItem.getProductionTime());
        sqlParameter.add(InventoryInItemMapping.ProductExpiredTime, inventoryInItem.getProductExpiredTime());
        sqlParameter.add(InventoryInItemMapping.SinglePrice, inventoryInItem.getSinglePrice());
        sqlParameter.add(InventoryInItemMapping.Quantity, inventoryInItem.getQuantity());
        sqlParameter.add(InventoryInItemMapping.Status, inventoryInItem.getStatus());
        sqlParameter.add(InventoryInItemMapping.CreateUserCode, inventoryInItem.getCreateUserCode());
        sqlParameter.add(InventoryInItemMapping.CreateUserName, inventoryInItem.getCreateUserName());
        sqlParameter.add(InventoryInItemMapping.CreateTime, inventoryInItem.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(InventoryInItem inventoryInItem)
    {
        String sql="UPDATE "+getTableName()+" set in_item_code=@{in_item_code},in_code=@{in_code},inventory_sku_code=@{inventory_sku_code},production_time=@{production_time},product_expired_time=@{product_expired_time},single_price=@{single_price},quantity=@{quantity},status=@{status},create_user_code=@{create_user_code},create_user_name=@{create_user_name},create_time=@{create_time} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInItemMapping.Id, inventoryInItem.getId());
        sqlParameter.add(InventoryInItemMapping.InItemCode, inventoryInItem.getInItemCode());
        sqlParameter.add(InventoryInItemMapping.InCode, inventoryInItem.getInCode());
        sqlParameter.add(InventoryInItemMapping.InventorySkuCode, inventoryInItem.getInventorySkuCode());
        sqlParameter.add(InventoryInItemMapping.ProductionTime, inventoryInItem.getProductionTime());
        sqlParameter.add(InventoryInItemMapping.ProductExpiredTime, inventoryInItem.getProductExpiredTime());
        sqlParameter.add(InventoryInItemMapping.SinglePrice, inventoryInItem.getSinglePrice());
        sqlParameter.add(InventoryInItemMapping.Quantity, inventoryInItem.getQuantity());
        sqlParameter.add(InventoryInItemMapping.Status, inventoryInItem.getStatus());
        sqlParameter.add(InventoryInItemMapping.CreateUserCode, inventoryInItem.getCreateUserCode());
        sqlParameter.add(InventoryInItemMapping.CreateUserName, inventoryInItem.getCreateUserName());
        sqlParameter.add(InventoryInItemMapping.CreateTime, inventoryInItem.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInItemMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public InventoryInItem searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInItemMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryInItem.class);
    }
    public PagedList<InventoryInItem> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryInItem> pagedList=this.searchByPage(queryCondition, InventoryInItem.class);
        return pagedList;
    }
    public List<InventoryInItem> searchListW(QueryParameter queryParameter) {
                List<InventoryInItem> list=this.searchList(queryParameter, InventoryInItem.class);
                    return list;
    }
    
    /**
     * 根据库存code和库存商品code查询入库单明细集合
     * @param inventoryCode
     * @param inventorySkuCode
     * @return
     */
    public List<InventoryInItem> searchListW(String inventoryCode, String inventorySkuCode) {
    	String sql = "SELECT * FROM inventory_in iin, inventory_in_item item WHERE iin.in_code = item.in_code AND iin.inventory_code = @{inventory_code} AND item.inventory_sku_code = @{inventory_sku_code} AND iin.in_type=@{in_type}";
    	SqlParameter sqlParameter = new SqlParameter();
    	sqlParameter.add(InventoryInItemMapping.InventorySkuCode, inventorySkuCode);
    	sqlParameter.add(InventoryInMapping.InventoryCode, inventoryCode);
    	sqlParameter.add(InventoryInMapping.InType, Cons.CAIGOURUKU);
    	return this.dataCommandWrite.executeList(sql, sqlParameter, InventoryInItem.class);
    }
}
