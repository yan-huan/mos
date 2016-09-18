package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Duty;
import com.myb.entity.pojo.mos.DutyMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("dutyDao")
public class DutyDao extends MySqlCommandBase
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
        return "duty";
    }


    public int insert(Duty duty)
    {
        String sql="INSERT INTO "+getTableName()+" (dutyId,dutyName,dutyCode,status)VALUES(@{dutyId},@{dutyName},@{dutyCode},@{status})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DutyMapping.DutyId, duty.getDutyId());
        sqlParameter.add(DutyMapping.DutyName, duty.getDutyName());
        sqlParameter.add(DutyMapping.DutyCode, duty.getDutyCode());
        sqlParameter.add(DutyMapping.Status, duty.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Duty duty)
    {
        String sql="UPDATE "+getTableName()+" set dutyName=@{dutyName},dutyCode=@{dutyCode},status=@{status} WHERE dutyId=@{dutyId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DutyMapping.DutyId, duty.getDutyId());
        sqlParameter.add(DutyMapping.DutyName, duty.getDutyName());
        sqlParameter.add(DutyMapping.DutyCode, duty.getDutyCode());
        sqlParameter.add(DutyMapping.Status, duty.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int dutyId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE dutyId=@{dutyId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DutyMapping.DutyId,dutyId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Duty searchByDutyId(int dutyId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE dutyId=@{dutyId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DutyMapping.DutyId,dutyId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Duty.class);
    }
    public PagedList<Duty> searchByPage(QueryCondition queryCondition) {
        PagedList<Duty> pagedList=this.searchByPage(queryCondition, Duty.class);
        return pagedList;
    }
    public List<Duty> searchList(QueryParameter queryParameter) {
                List<Duty> list=this.searchList(queryParameter, Duty.class);
                    return list;
    }
}
