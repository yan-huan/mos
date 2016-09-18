package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.CrmUserinfo;
import com.myb.entity.pojo.mos.CrmUserinfoMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("crmUserinfoDao")
public class CrmUserinfoDao extends MySqlCommandBase
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
        return "crm_userinfo";
    }


    public int insert(CrmUserinfo crmUserinfo)
    {
        String sql="INSERT INTO "+getTableName()+" (id,quyu,xingming,bumen,gangwei,empId,superiorId,mobile,xu,xiaozu,isValide)VALUES(@{id},@{quyu},@{xingming},@{bumen},@{gangwei},@{empId},@{superiorId},@{mobile},@{xu},@{xiaozu},@{isValide})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmUserinfoMapping.Id, crmUserinfo.getId());
        sqlParameter.add(CrmUserinfoMapping.Quyu, crmUserinfo.getQuyu());
        sqlParameter.add(CrmUserinfoMapping.Xingming, crmUserinfo.getXingming());
        sqlParameter.add(CrmUserinfoMapping.Bumen, crmUserinfo.getBumen());
        sqlParameter.add(CrmUserinfoMapping.Gangwei, crmUserinfo.getGangwei());
        sqlParameter.add(CrmUserinfoMapping.EmpId, crmUserinfo.getEmpId());
        sqlParameter.add(CrmUserinfoMapping.SuperiorId, crmUserinfo.getSuperiorId());
        sqlParameter.add(CrmUserinfoMapping.Mobile, crmUserinfo.getMobile());
        sqlParameter.add(CrmUserinfoMapping.Xu, crmUserinfo.getXu());
        sqlParameter.add(CrmUserinfoMapping.Xiaozu, crmUserinfo.getXiaozu());
        sqlParameter.add(CrmUserinfoMapping.IsValide, crmUserinfo.getIsValide());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(CrmUserinfo crmUserinfo)
    {
        String sql="UPDATE "+getTableName()+" set quyu=@{quyu},xingming=@{xingming},bumen=@{bumen},gangwei=@{gangwei},empId=@{empId},superiorId=@{superiorId},mobile=@{mobile},xu=@{xu},xiaozu=@{xiaozu},isValide=@{isValide} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmUserinfoMapping.Id, crmUserinfo.getId());
        sqlParameter.add(CrmUserinfoMapping.Quyu, crmUserinfo.getQuyu());
        sqlParameter.add(CrmUserinfoMapping.Xingming, crmUserinfo.getXingming());
        sqlParameter.add(CrmUserinfoMapping.Bumen, crmUserinfo.getBumen());
        sqlParameter.add(CrmUserinfoMapping.Gangwei, crmUserinfo.getGangwei());
        sqlParameter.add(CrmUserinfoMapping.EmpId, crmUserinfo.getEmpId());
        sqlParameter.add(CrmUserinfoMapping.SuperiorId, crmUserinfo.getSuperiorId());
        sqlParameter.add(CrmUserinfoMapping.Mobile, crmUserinfo.getMobile());
        sqlParameter.add(CrmUserinfoMapping.Xu, crmUserinfo.getXu());
        sqlParameter.add(CrmUserinfoMapping.Xiaozu, crmUserinfo.getXiaozu());
        sqlParameter.add(CrmUserinfoMapping.IsValide, crmUserinfo.getIsValide());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmUserinfoMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public CrmUserinfo searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CrmUserinfoMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, CrmUserinfo.class);
    }
    public PagedList<CrmUserinfo> searchByPage(QueryCondition queryCondition) {
        PagedList<CrmUserinfo> pagedList=this.searchByPage(queryCondition, CrmUserinfo.class);
        return pagedList;
    }
    public List<CrmUserinfo> searchList(QueryParameter queryParameter) {
                List<CrmUserinfo> list=this.searchList(queryParameter, CrmUserinfo.class);
                    return list;
    }
}
