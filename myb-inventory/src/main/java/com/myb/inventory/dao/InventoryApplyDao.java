package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryApply;
import com.myb.entity.pojo.inventory.InventoryApplyMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryApplyDao")
public class InventoryApplyDao extends MySqlCommandBase {

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
        return "inventory_apply";
    }

    

    public int insert(InventoryApply inventoryApply) {
        String sql="INSERT INTO "+getTableName()+" (id,apply_code,inventory_code,inventory_name,to_code,to_name,comments,original_document,type,status,create_user_code,create_user_name,create_time)VALUES(@{id},@{apply_code},@{inventory_code},@{inventory_name},@{to_code},@{to_name},@{comments},@{original_document},@{type},@{status},@{create_user_code},@{create_user_name},@{create_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryApplyMapping.Id, inventoryApply.getId());
        sqlParameter.add(InventoryApplyMapping.ApplyCode, inventoryApply.getApplyCode());
        sqlParameter.add(InventoryApplyMapping.InventoryCode, inventoryApply.getInventoryCode());
        sqlParameter.add(InventoryApplyMapping.InventoryName, inventoryApply.getInventoryName());
        sqlParameter.add(InventoryApplyMapping.ToCode, inventoryApply.getToCode());
        sqlParameter.add(InventoryApplyMapping.ToName, inventoryApply.getToName());
        sqlParameter.add(InventoryApplyMapping.Comments, inventoryApply.getComments());
        sqlParameter.add(InventoryApplyMapping.OriginalDocument, inventoryApply.getOriginalDocument());
        sqlParameter.add(InventoryApplyMapping.Type, inventoryApply.getType());
        sqlParameter.add(InventoryApplyMapping.Status, inventoryApply.getStatus());
        sqlParameter.add(InventoryApplyMapping.CreateUserCode, inventoryApply.getCreateUserCode());
        sqlParameter.add(InventoryApplyMapping.CreateUserName, inventoryApply.getCreateUserName());
        sqlParameter.add(InventoryApplyMapping.CreateTime, inventoryApply.getCreateTime());
//        sqlParameter.add(InventoryApplyMapping.UpdateUserCode, inventoryApply.getUpdateUserCode());
//        sqlParameter.add(InventoryApplyMapping.UpdateUserName, inventoryApply.getUpdateUserName());
//        sqlParameter.add(InventoryApplyMapping.UpdateTime, inventoryApply.getUpdateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    /**
     * 根据申请单code查询申请列表
     * @author hailin.liu 2016年5月19日 下午5:01:04 <br/>
     * @param code
     * @return
     */
    public InventoryApply searchByCode(String code) {
        String sql="SELECT * FROM "+getTableName()+" WHERE apply_code=@{apply_code}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryApplyMapping.ApplyCode,code);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryApply.class);
    }

    public InventoryApply searchById(int id) {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryApplyMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventoryApply.class);
    }
    
    public PagedList<InventoryApply> searchByPage(QueryCondition queryCondition) {
        PagedList<InventoryApply> pagedList=this.searchByPage(queryCondition, InventoryApply.class);
        return pagedList;
    }
    public List<InventoryApply> searchList(QueryParameter queryParameter) {
                List<InventoryApply> list=this.searchList(queryParameter, InventoryApply.class);
                    return list;
    }
}
