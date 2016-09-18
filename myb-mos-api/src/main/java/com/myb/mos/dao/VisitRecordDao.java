package com.myb.mos.dao;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

import com.myb.entity.pojo.mos.VisitRecord;

import com.myb.entity.pojo.mos.VisitRecordMapping;

@Repository("visitRecordDao")
public class VisitRecordDao extends MySqlCommandBase
{

    @Resource(name = "datacommand")
    private DataCommand dataCommand;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommand);
    }
    @Override
    public String getTableName()
    {
        return "visit_record";
    }


    public int insert(VisitRecord visitRecord)
    {
        String sql="INSERT INTO "+getTableName()+" (id,shopId,clientName,picUrl,visitTime,clientLevel,longitude,latitude,contractId,isEscort,isValide,employeeId,remark,createTime,isdel)VALUES(@{id},@{shopId},@{clientName},@{picUrl},@{visitTime},@{clientLevel},@{longitude},@{latitude},@{contractId},@{isEscort},@{isValide},@{employeeId},@{remark},@{createTime},@{isdel})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(VisitRecordMapping.Id, visitRecord.getId());
        sqlParameter.add(VisitRecordMapping.ShopId, visitRecord.getShopId());
        sqlParameter.add(VisitRecordMapping.ClientName, visitRecord.getClientName());
        sqlParameter.add(VisitRecordMapping.PicUrl, visitRecord.getPicUrl());
        sqlParameter.add(VisitRecordMapping.VisitTime, visitRecord.getVisitTime());
        sqlParameter.add(VisitRecordMapping.ClientLevel, visitRecord.getClientLevel());
        sqlParameter.add(VisitRecordMapping.Longitude, visitRecord.getLongitude());
        sqlParameter.add(VisitRecordMapping.Latitude, visitRecord.getLatitude());
        sqlParameter.add(VisitRecordMapping.ContractId, visitRecord.getContractId());
        sqlParameter.add(VisitRecordMapping.IsEscort, visitRecord.getIsEscort());
        sqlParameter.add(VisitRecordMapping.IsValide, visitRecord.getIsValide());
        sqlParameter.add(VisitRecordMapping.EmployeeId, visitRecord.getEmployeeId());
        sqlParameter.add(VisitRecordMapping.Remark, visitRecord.getRemark());
        sqlParameter.add(VisitRecordMapping.CreateTime, visitRecord.getCreateTime());
        sqlParameter.add(VisitRecordMapping.Isdel, visitRecord.getIsdel());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(VisitRecord visitRecord)
    {
        String sql="UPDATE "+getTableName()+" set shopId=@{shopId},clientName=@{clientName},picUrl=@{picUrl},visitTime=@{visitTime},clientLevel=@{clientLevel},longitude=@{longitude},latitude=@{latitude},contractId=@{contractId},isEscort=@{isEscort},isValide=@{isValide},employeeId=@{employeeId},remark=@{remark},createTime=@{createTime},isdel=@{isdel} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(VisitRecordMapping.Id, visitRecord.getId());
        sqlParameter.add(VisitRecordMapping.ShopId, visitRecord.getShopId());
        sqlParameter.add(VisitRecordMapping.ClientName, visitRecord.getClientName());
        sqlParameter.add(VisitRecordMapping.PicUrl, visitRecord.getPicUrl());
        sqlParameter.add(VisitRecordMapping.VisitTime, visitRecord.getVisitTime());
        sqlParameter.add(VisitRecordMapping.ClientLevel, visitRecord.getClientLevel());
        sqlParameter.add(VisitRecordMapping.Longitude, visitRecord.getLongitude());
        sqlParameter.add(VisitRecordMapping.Latitude, visitRecord.getLatitude());
        sqlParameter.add(VisitRecordMapping.ContractId, visitRecord.getContractId());
        sqlParameter.add(VisitRecordMapping.IsEscort, visitRecord.getIsEscort());
        sqlParameter.add(VisitRecordMapping.IsValide, visitRecord.getIsValide());
        sqlParameter.add(VisitRecordMapping.EmployeeId, visitRecord.getEmployeeId());
        sqlParameter.add(VisitRecordMapping.Remark, visitRecord.getRemark());
        sqlParameter.add(VisitRecordMapping.CreateTime, visitRecord.getCreateTime());
        sqlParameter.add(VisitRecordMapping.Isdel, visitRecord.getIsdel());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(long id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(VisitRecordMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public VisitRecord searchById(long id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(VisitRecordMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, VisitRecord.class);
    }
    public PagedList<VisitRecord> searchByPage(QueryCondition queryCondition) {
        PagedList<VisitRecord> pagedList=this.searchByPage(queryCondition, VisitRecord.class);
        return pagedList;
    }
    public List<VisitRecord> searchList(QueryParameter queryParameter) {
                List<VisitRecord> list=this.searchList(queryParameter, VisitRecord.class);
                    return list;
    }
}
