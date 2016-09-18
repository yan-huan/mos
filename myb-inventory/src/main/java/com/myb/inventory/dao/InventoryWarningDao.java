package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryWarning;
import com.myb.entity.pojo.inventory.InventoryWarningMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;
import com.myb.inventory.cons.Cons;

@Repository("inventoryWarningDao")
public class InventoryWarningDao extends MySqlCommandBase
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
        return "inventory_warning";
    }


    public int insert(InventoryWarning inventoryWarning)
    {
        String sql="INSERT INTO "+getTableName()+" (id,inventory_warnning_code,inventory_sku_code,inventory_code,is_send,is_read,type,condition,create_time,update_time)VALUES(@{id},@{inventory_warnning_code},@{inventory_sku_code},@{inventory_code},@{is_send},@{is_read},@{type},@{condition},@{create_time},@{update_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryWarningMapping.Id, inventoryWarning.getId());
        sqlParameter.add(InventoryWarningMapping.InventoryWarnningCode, inventoryWarning.getInventoryWarnningCode());
        sqlParameter.add(InventoryWarningMapping.InventorySkuCode, inventoryWarning.getInventorySkuCode());
        sqlParameter.add(InventoryWarningMapping.InventoryCode, inventoryWarning.getInventoryCode());
        sqlParameter.add(InventoryWarningMapping.IsSend, inventoryWarning.getIsSend());
        sqlParameter.add(InventoryWarningMapping.IsRead, inventoryWarning.getIsRead());
        sqlParameter.add(InventoryWarningMapping.Type, inventoryWarning.getType());
        sqlParameter.add(InventoryWarningMapping.Condition, inventoryWarning.getCondition());
        sqlParameter.add(InventoryWarningMapping.CreateTime, inventoryWarning.getCreateTime());
        sqlParameter.add(InventoryWarningMapping.UpdateTime, inventoryWarning.getUpdateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public InventoryWarning searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryWarningMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryWarning.class);
    }
    public PagedList<InventoryWarning> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryWarning> pagedList=this.searchByPage(queryCondition, InventoryWarning.class);
        return pagedList;
    }
    public List<InventoryWarning> searchList(QueryParameter queryParameter) {
                List<InventoryWarning> list=this.searchList(queryParameter, InventoryWarning.class);
                    return list;
    }
    
    /**
     * 查询未读的提醒(第一行)
     * @author hailin.liu 2016年5月21日 上午11:06:15 <br/>
     * @param parentCode
     * @param childCode
     * @return
     */
	public Long countWarnning(String inventoryCode) {
		StringBuilder sql = new StringBuilder(" SELECT COUNT(*) FROM " + getTableName() + " WHERE inventory_code=@{inventory_code} AND is_read=@{is_read} ");
		 SqlParameter sqlParameter=new SqlParameter();
		 sqlParameter.add(InventoryWarningMapping.InventoryCode, inventoryCode);
		 sqlParameter.add(InventoryWarningMapping.IsRead, Cons.UN_READ);
		return this.dataCommandRead.executeScale(sql.toString(), sqlParameter, Long.class);
	}
}
