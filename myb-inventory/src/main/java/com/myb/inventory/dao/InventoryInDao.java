package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryIn;
import com.myb.entity.pojo.inventory.InventoryInMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryInDao")
public class InventoryInDao extends MySqlCommandBase
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
        return "inventory_in";
    }

    /**
     * 根据inCode查询入库单
     * @author hailin.liu 2016年5月17日 下午1:17:22 <br/>
     * @param inCode
     * @return
     */
    public InventoryIn findByInCode(String inCode) {
    	String sql = "SELECT * FROM " + getTableName() + " WHERE in_code=@{in_code} ";
    	SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInMapping.InCode, inCode);
        InventoryIn inventoryIn = dataCommandRead.executeEntity(sql, sqlParameter, InventoryIn.class);
    	return inventoryIn;
    }

    public int insert(InventoryIn inventoryIn)
    {
        String sql="INSERT INTO "+getTableName()+" (id,in_code,original_document,product_type,status,inventory_code,in_type,from_code,create_user_code,create_user_name,create_time)VALUES(@{id},@{in_code},@{original_document},@{product_type},@{status},@{inventory_code},@{in_type},@{from_code},@{create_user_code},@{create_user_name},@{create_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInMapping.Id, inventoryIn.getId());
        sqlParameter.add(InventoryInMapping.InCode, inventoryIn.getInCode());
        sqlParameter.add(InventoryInMapping.OriginalDocument, inventoryIn.getOriginalDocument());
        sqlParameter.add(InventoryInMapping.ProductType, inventoryIn.getProductType());
        sqlParameter.add(InventoryInMapping.Status, inventoryIn.getStatus());
        sqlParameter.add(InventoryInMapping.InventoryCode, inventoryIn.getInventoryCode());
        sqlParameter.add(InventoryInMapping.InType, inventoryIn.getInType());
        sqlParameter.add(InventoryInMapping.FromCode, inventoryIn.getFromCode());
        sqlParameter.add(InventoryInMapping.CreateUserCode, inventoryIn.getCreateUserCode());
        sqlParameter.add(InventoryInMapping.CreateUserName, inventoryIn.getCreateUserName());
        sqlParameter.add(InventoryInMapping.CreateTime, inventoryIn.getCreateTime());
        return this.getDataCommand().insertAndGetKey(sql, sqlParameter).intValue();
    }

    public int update(InventoryIn inventoryIn)
    {
        String sql="UPDATE "+getTableName()+" set in_code=@{in_code},original_document=@{original_document},product_type=@{product_type},status=@{status},inventory_code=@{inventory_code},in_type=@{in_type},from_code=@{from_code},create_user_code=@{create_user_code},create_user_name=@{create_user_name},create_time=@{create_time} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInMapping.Id, inventoryIn.getId());
        sqlParameter.add(InventoryInMapping.InCode, inventoryIn.getInCode());
        sqlParameter.add(InventoryInMapping.OriginalDocument, inventoryIn.getOriginalDocument());
        sqlParameter.add(InventoryInMapping.ProductType, inventoryIn.getProductType());
        sqlParameter.add(InventoryInMapping.Status, inventoryIn.getStatus());
        sqlParameter.add(InventoryInMapping.InventoryCode, inventoryIn.getInventoryCode());
        sqlParameter.add(InventoryInMapping.InType, inventoryIn.getInType());
        sqlParameter.add(InventoryInMapping.FromCode, inventoryIn.getFromCode());
        sqlParameter.add(InventoryInMapping.CreateUserCode, inventoryIn.getCreateUserCode());
        sqlParameter.add(InventoryInMapping.CreateUserName, inventoryIn.getCreateUserName());
        sqlParameter.add(InventoryInMapping.CreateTime, inventoryIn.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public InventoryIn searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryInMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryIn.class);
    }
    public PagedList<InventoryIn> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryIn> pagedList=this.searchByPage(queryCondition, InventoryIn.class);
        return pagedList;
    }
    public List<InventoryIn> searchListW(QueryParameter queryParameter) {
                List<InventoryIn> list=this.searchList(queryParameter, InventoryIn.class);
                    return list;
    }
}
