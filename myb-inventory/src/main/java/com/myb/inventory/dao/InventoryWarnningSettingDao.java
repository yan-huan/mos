package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryWarnningSetting;
import com.myb.entity.pojo.inventory.InventoryWarnningSettingMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryWarnningSettingDao")
public class InventoryWarnningSettingDao extends MySqlCommandBase
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
        return "inventory_warnning_setting";
    }


    public int insert(InventoryWarnningSetting inventoryWarnningSetting)
    {
        String sql="INSERT INTO "+getTableName()+" (id,inventory_code,is_send,type,condition,create_time,update_time)VALUES(@{id},@{inventory_code},@{is_send},@{type},@{condition},@{create_time},@{update_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryWarnningSettingMapping.Id, inventoryWarnningSetting.getId());
        sqlParameter.add(InventoryWarnningSettingMapping.InventoryCode, inventoryWarnningSetting.getInventoryCode());
        sqlParameter.add(InventoryWarnningSettingMapping.IsSend, inventoryWarnningSetting.getIsSend());
        sqlParameter.add(InventoryWarnningSettingMapping.Type, inventoryWarnningSetting.getType());
        sqlParameter.add(InventoryWarnningSettingMapping.Condition, inventoryWarnningSetting.getCondition());
        sqlParameter.add(InventoryWarnningSettingMapping.CreateTime, inventoryWarnningSetting.getCreateTime());
        sqlParameter.add(InventoryWarnningSettingMapping.UpdateTime, inventoryWarnningSetting.getUpdateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(InventoryWarnningSetting inventoryWarnningSetting)
    {
        String sql="UPDATE "+getTableName()+" set inventory_code=@{inventory_code},is_send=@{is_send},type=@{type},condition=@{condition},create_time=@{create_time},update_time=@{update_time} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryWarnningSettingMapping.Id, inventoryWarnningSetting.getId());
        sqlParameter.add(InventoryWarnningSettingMapping.InventoryCode, inventoryWarnningSetting.getInventoryCode());
        sqlParameter.add(InventoryWarnningSettingMapping.IsSend, inventoryWarnningSetting.getIsSend());
        sqlParameter.add(InventoryWarnningSettingMapping.Type, inventoryWarnningSetting.getType());
        sqlParameter.add(InventoryWarnningSettingMapping.Condition, inventoryWarnningSetting.getCondition());
        sqlParameter.add(InventoryWarnningSettingMapping.CreateTime, inventoryWarnningSetting.getCreateTime());
        sqlParameter.add(InventoryWarnningSettingMapping.UpdateTime, inventoryWarnningSetting.getUpdateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryWarnningSettingMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public InventoryWarnningSetting searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryWarnningSettingMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryWarnningSetting.class);
    }
    public PagedList<InventoryWarnningSetting> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryWarnningSetting> pagedList=this.searchByPage(queryCondition, InventoryWarnningSetting.class);
        return pagedList;
    }
    public List<InventoryWarnningSetting> searchList(QueryParameter queryParameter) {
                List<InventoryWarnningSetting> list=this.searchList(queryParameter, InventoryWarnningSetting.class);
                    return list;
    }
}
