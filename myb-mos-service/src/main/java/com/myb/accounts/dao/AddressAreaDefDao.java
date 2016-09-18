package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.AddressAreaDefMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("addressAreaDefDao")
public class AddressAreaDefDao extends MySqlCommandBase
{

    @Resource(name = "datacommand_write")
    private DataCommand dataCommandWrite;
    
    @Resource(name = "datacommand_read")
    private DataCommand dataCommandRead;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName()
    {
        return "address_area_def";
    }


    public int insert(AddressAreaDef addressAreaDef)
    {
        String sql="INSERT INTO "+getTableName()+" (id,code,parent_code,obj_name,pl_no,status)VALUES(@{id},@{code},@{parent_code},@{obj_name},@{pl_no},@{status})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AddressAreaDefMapping.Id, addressAreaDef.getId());
        sqlParameter.add(AddressAreaDefMapping.Code, addressAreaDef.getCode());
        sqlParameter.add(AddressAreaDefMapping.ParentCode, addressAreaDef.getParentCode());
        sqlParameter.add(AddressAreaDefMapping.ObjName, addressAreaDef.getObjName());
        sqlParameter.add(AddressAreaDefMapping.PlNo, addressAreaDef.getPlNo());
        sqlParameter.add(AddressAreaDefMapping.Status, addressAreaDef.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AddressAreaDef addressAreaDef)
    {
        String sql="UPDATE "+getTableName()+" set code=@{code},parent_code=@{parent_code},obj_name=@{obj_name},pl_no=@{pl_no},status=@{status} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AddressAreaDefMapping.Id, addressAreaDef.getId());
        sqlParameter.add(AddressAreaDefMapping.Code, addressAreaDef.getCode());
        sqlParameter.add(AddressAreaDefMapping.ParentCode, addressAreaDef.getParentCode());
        sqlParameter.add(AddressAreaDefMapping.ObjName, addressAreaDef.getObjName());
        sqlParameter.add(AddressAreaDefMapping.PlNo, addressAreaDef.getPlNo());
        sqlParameter.add(AddressAreaDefMapping.Status, addressAreaDef.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AddressAreaDefMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AddressAreaDef searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AddressAreaDefMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AddressAreaDef.class);
    }
    public PagedList<AddressAreaDef> searchByPage(QueryCondition queryCondition) {
        PagedList<AddressAreaDef> pagedList=this.searchByPage(queryCondition, AddressAreaDef.class);
        return pagedList;
    }
    public List<AddressAreaDef> searchList(QueryParameter queryParameter) {
                List<AddressAreaDef> list=this.searchList(queryParameter, AddressAreaDef.class);
                    return list;
    }
}
