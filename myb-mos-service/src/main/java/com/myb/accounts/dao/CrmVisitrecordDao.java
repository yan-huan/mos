package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myb.entity.pojo.mos.CrmVisitrecord;
import com.myb.entity.pojo.mos.CrmVisitrecordMapping;
import com.myb.entity.pojo.mos.Employee;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.EntityBase;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.SqlParameterForQuery;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("crmVisitrecordDao")
public class CrmVisitrecordDao extends MySqlCommandBase
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
        return "crm_visitrecord";
    }


    public int insert(CrmVisitrecord crmVisitrecord)
    {
        String sql="INSERT INTO "+getTableName()+" (id,shopId,clientName,picUrl,visitTime,clientLevel,longitude,latitude,contractId,isEscort,isValide,employeeId,remark,createTime,isdel,address,empName,isBoss)VALUES(@{id},@{shopId},@{clientName},@{picUrl},@{visitTime},@{clientLevel},@{longitude},@{latitude},@{contractId},@{isEscort},@{isValide},@{employeeId},@{remark},@{createTime},@{isdel},@{address},@{empName},@{isBoss})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmVisitrecordMapping.Id, crmVisitrecord.getId());
        sqlParameter.add(CrmVisitrecordMapping.ShopId, crmVisitrecord.getShopId());
        sqlParameter.add(CrmVisitrecordMapping.ClientName, crmVisitrecord.getClientName());
        sqlParameter.add(CrmVisitrecordMapping.PicUrl, crmVisitrecord.getPicUrl());
        sqlParameter.add(CrmVisitrecordMapping.VisitTime, crmVisitrecord.getVisitTime());
        sqlParameter.add(CrmVisitrecordMapping.ClientLevel, crmVisitrecord.getClientLevel());
        sqlParameter.add(CrmVisitrecordMapping.Longitude, crmVisitrecord.getLongitude());
        sqlParameter.add(CrmVisitrecordMapping.Latitude, crmVisitrecord.getLatitude());
        sqlParameter.add(CrmVisitrecordMapping.ContractId, crmVisitrecord.getContractId());
        sqlParameter.add(CrmVisitrecordMapping.IsEscort, crmVisitrecord.getIsEscort());
        sqlParameter.add(CrmVisitrecordMapping.IsValide, crmVisitrecord.getIsValide());
        sqlParameter.add(CrmVisitrecordMapping.EmployeeId, crmVisitrecord.getEmployeeId());
        sqlParameter.add(CrmVisitrecordMapping.Remark, crmVisitrecord.getRemark());
        sqlParameter.add(CrmVisitrecordMapping.CreateTime, crmVisitrecord.getCreateTime());
        sqlParameter.add(CrmVisitrecordMapping.Isdel, crmVisitrecord.getIsdel());
        sqlParameter.add(CrmVisitrecordMapping.Address, crmVisitrecord.getAddress());
        sqlParameter.add(CrmVisitrecordMapping.EmpName, crmVisitrecord.getEmpName());
        sqlParameter.add(CrmVisitrecordMapping.IsBoss, crmVisitrecord.getIsBoss());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(CrmVisitrecord crmVisitrecord)
    {
        String sql="UPDATE "+getTableName()+" set shopId=@{shopId},clientName=@{clientName},picUrl=@{picUrl},visitTime=@{visitTime},clientLevel=@{clientLevel},longitude=@{longitude},latitude=@{latitude},contractId=@{contractId},isEscort=@{isEscort},isValide=@{isValide},employeeId=@{employeeId},remark=@{remark},createTime=@{createTime},isdel=@{isdel},address=@{address},empName=@{empName},isBoss=@{isBoss} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmVisitrecordMapping.Id, crmVisitrecord.getId());
        sqlParameter.add(CrmVisitrecordMapping.ShopId, crmVisitrecord.getShopId());
        sqlParameter.add(CrmVisitrecordMapping.ClientName, crmVisitrecord.getClientName());
        sqlParameter.add(CrmVisitrecordMapping.PicUrl, crmVisitrecord.getPicUrl());
        sqlParameter.add(CrmVisitrecordMapping.VisitTime, crmVisitrecord.getVisitTime());
        sqlParameter.add(CrmVisitrecordMapping.ClientLevel, crmVisitrecord.getClientLevel());
        sqlParameter.add(CrmVisitrecordMapping.Longitude, crmVisitrecord.getLongitude());
        sqlParameter.add(CrmVisitrecordMapping.Latitude, crmVisitrecord.getLatitude());
        sqlParameter.add(CrmVisitrecordMapping.ContractId, crmVisitrecord.getContractId());
        sqlParameter.add(CrmVisitrecordMapping.IsEscort, crmVisitrecord.getIsEscort());
        sqlParameter.add(CrmVisitrecordMapping.IsValide, crmVisitrecord.getIsValide());
        sqlParameter.add(CrmVisitrecordMapping.EmployeeId, crmVisitrecord.getEmployeeId());
        sqlParameter.add(CrmVisitrecordMapping.Remark, crmVisitrecord.getRemark());
        sqlParameter.add(CrmVisitrecordMapping.CreateTime, crmVisitrecord.getCreateTime());
        sqlParameter.add(CrmVisitrecordMapping.Isdel, crmVisitrecord.getIsdel());
        sqlParameter.add(CrmVisitrecordMapping.Address, crmVisitrecord.getAddress());
        sqlParameter.add(CrmVisitrecordMapping.EmpName, crmVisitrecord.getEmpName());
        sqlParameter.add(CrmVisitrecordMapping.IsBoss, crmVisitrecord.getIsBoss());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(long id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmVisitrecordMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public CrmVisitrecord searchById(long id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmVisitrecordMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, CrmVisitrecord.class);
    }
    public PagedList<CrmVisitrecord> searchByPage(QueryCondition queryCondition) {
        PagedList<CrmVisitrecord> pagedList=this.searchByPage(queryCondition, CrmVisitrecord.class);
        return pagedList;
    }
    public List<CrmVisitrecord> searchList(QueryParameter queryParameter) {
                List<CrmVisitrecord> list=this.searchList(queryParameter, CrmVisitrecord.class);
                    return list;
    }
    //查询crm的拜访列表
    public <T extends EntityBase> List<T> searchListByCondition(QueryParameter queryParameter,String tableName,Class<T> t,int empId)
	{
    	
		SqlParameterForQuery sqlParameterForQuery =new SqlParameterForQuery(queryParameter);
		String where= sqlParameterForQuery.getSql();
		SqlParameter sqlParameter= sqlParameterForQuery.getSqlParameter();
		String sql="SELECT b.xiaozu,b.empId,b.xingming,b.quyu ,a.shopId,b.mobile,a.isValide FROM crm_visitrecord a"
				
					+" INNER JOIN crm_userinfo b ON a.employeeId = b.empId"
					
					+" "+where;
					
//					+" GROUP BY a.employeeId, b.xingming, b.xiaozu"
//					
//					+" ORDER BY count(a.employeeId) DESC";
		List<T> content=this.dataCommandWrite.executeList(sql, sqlParameter, t);
		return content;
		
	}
    
    

	
}
