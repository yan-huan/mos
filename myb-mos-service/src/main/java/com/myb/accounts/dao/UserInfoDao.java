package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.UserInfo;
import com.myb.entity.pojo.mos.UserInfoMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("userInfoDao")
public class UserInfoDao extends MySqlCommandBase
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
        return "crm_userInfo";
    }


    public int insert(UserInfo sheet0)
    {
        String sql="INSERT INTO "+getTableName()+" (xu,quyu,xingming,bumen,gangwei,id,empId,mobile,xiaozu)VALUES(@{xu},@{quyu},@{xingming},@{bumen},@{gangwei},@{id},@{empId},@{mobile},@{xiaozu})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserInfoMapping.Xu, sheet0.getXu());
        sqlParameter.add(UserInfoMapping.Quyu, sheet0.getQuyu());
        sqlParameter.add(UserInfoMapping.Xingming, sheet0.getXingming());
        sqlParameter.add(UserInfoMapping.Bumen, sheet0.getBumen());
        sqlParameter.add(UserInfoMapping.Gangwei, sheet0.getGangwei());
        sqlParameter.add(UserInfoMapping.Id, sheet0.getId());
        sqlParameter.add(UserInfoMapping.EmpId, sheet0.getEmpId());
        sqlParameter.add(UserInfoMapping.Mobile, sheet0.getMobile());
        sqlParameter.add(UserInfoMapping.Xiaozu, sheet0.getXiaozu());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(UserInfo sheet0)
    {
        String sql="UPDATE "+getTableName()+" set quyu=@{quyu},xingming=@{xingming},bumen=@{bumen},gangwei=@{gangwei},id=@{id},empId=@{empId},mobile=@{mobile},xiaozu=@{xiaozu} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserInfoMapping.Xu, sheet0.getXu());
        sqlParameter.add(UserInfoMapping.Quyu, sheet0.getQuyu());
        sqlParameter.add(UserInfoMapping.Xingming, sheet0.getXingming());
        sqlParameter.add(UserInfoMapping.Bumen, sheet0.getBumen());
        sqlParameter.add(UserInfoMapping.Gangwei, sheet0.getGangwei());
        sqlParameter.add(UserInfoMapping.Id, sheet0.getId());
        sqlParameter.add(UserInfoMapping.EmpId, sheet0.getEmpId());
        sqlParameter.add(UserInfoMapping.Mobile, sheet0.getMobile());
        sqlParameter.add(UserInfoMapping.Xiaozu, sheet0.getXiaozu());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(java.lang.String xu)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE xu=@{xu}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserInfoMapping.Xu,xu);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public UserInfo searchByXu(java.lang.String xu)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE xu=@{xu}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserInfoMapping.Xu,xu);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, UserInfo.class);
    }
    public PagedList<UserInfo> searchByPage(QueryCondition queryCondition) {
        PagedList<UserInfo> pagedList=this.searchByPage(queryCondition, UserInfo.class);
        return pagedList;
    }
    public List<UserInfo> searchList(QueryParameter queryParameter) {
                List<UserInfo> list=this.searchList(queryParameter, UserInfo.class);
                    return list;
    }
}
