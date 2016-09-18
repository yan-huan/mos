package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryApplyLog;
import com.myb.entity.pojo.inventory.InventoryApplyLogMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryApplyLogDao")
public class InventoryApplyLogDao extends MySqlCommandBase {
	@Resource(name = "datacommand_inventory_write")
    private DataCommand dataCommandWrite;
    @Resource(name = "datacommand_inventory_read")
    private DataCommand dataCommandRead;

    @PostConstruct
    public void initDataCommand() {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName() {
        return "inventory_apply_log";
    }


    public int insert(InventoryApplyLog inventoryApplyLog) {
        String sql="INSERT INTO "+getTableName()+" (id,apply_log_code,apply_code,new_status,description,operator_code,operate_time)VALUES(@{id},@{apply_log_code},@{apply_code},@{new_status},@{description},@{operator_code},@{operate_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryApplyLogMapping.Id, inventoryApplyLog.getId());
        sqlParameter.add(InventoryApplyLogMapping.ApplyLogCode, inventoryApplyLog.getApplyLogCode());
        sqlParameter.add(InventoryApplyLogMapping.ApplyCode, inventoryApplyLog.getApplyCode());
        sqlParameter.add(InventoryApplyLogMapping.NewStatus, inventoryApplyLog.getNewStatus());
        sqlParameter.add(InventoryApplyLogMapping.Description, inventoryApplyLog.getDescription());
        sqlParameter.add(InventoryApplyLogMapping.OperatorCode, inventoryApplyLog.getOperatorCode());
        sqlParameter.add(InventoryApplyLogMapping.OperateTime, inventoryApplyLog.getOperateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public PagedList<InventoryApplyLog> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryApplyLog> pagedList=this.searchByPage(queryCondition, InventoryApplyLog.class);
        return pagedList;
    }
    
    public List<InventoryApplyLog> findListR(String applyCode) {
    	String sql = "SELECT * FROM " + getTableName() + " WHERE apply_code=@{apply_code} ORDER BY operate_time DESC";
    	SqlParameter sqlParameter=new SqlParameter();
    	sqlParameter.add(InventoryApplyLogMapping.ApplyCode, applyCode);
    	return dataCommandRead.executeList(sql, sqlParameter, InventoryApplyLog.class);
    }
    
    
    public List<InventoryApplyLog> searchListR(QueryParameter queryParameter) {
                List<InventoryApplyLog> list=this.searchList(queryParameter, InventoryApplyLog.class, dataCommandRead);
                    return list;
    }
}
