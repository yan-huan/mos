package com.myb.clerk.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.clerk.ClerksRoles;
import com.myb.entity.pojo.clerk.ClerksRolesMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("clerksRolesDao")
public class ClerksRolesDao extends MySqlCommandBase
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
        return "clerks_roles";
    }


    public int insert(ClerksRoles clerksRoles)
    {
        String sql="INSERT INTO "+getTableName()+" (id,code,clerk_code,shop_code,company_code,create_by,create_party_type,update_by,update_party_type,comments,status,obj_name,login_account_code,role_code,start_date,end_date,created_at,updated_at)VALUES(@{id},@{code},@{clerk_code},@{shop_code},@{company_code},@{create_by},@{create_party_type},@{update_by},@{update_party_type},@{comments},@{status},@{obj_name},@{login_account_code},@{role_code},@{start_date},@{end_date},@{created_at},@{updated_at})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ClerksRolesMapping.Id, clerksRoles.getId());
        sqlParameter.add(ClerksRolesMapping.Code, clerksRoles.getCode());
        sqlParameter.add(ClerksRolesMapping.ClerkCode, clerksRoles.getClerkCode());
        sqlParameter.add(ClerksRolesMapping.ShopCode, clerksRoles.getShopCode());
        sqlParameter.add(ClerksRolesMapping.CompanyCode, clerksRoles.getCompanyCode());
        sqlParameter.add(ClerksRolesMapping.CreateBy, clerksRoles.getCreateBy());
        sqlParameter.add(ClerksRolesMapping.CreatePartyType, clerksRoles.getCreatePartyType());
        sqlParameter.add(ClerksRolesMapping.UpdateBy, clerksRoles.getUpdateBy());
        sqlParameter.add(ClerksRolesMapping.UpdatePartyType, clerksRoles.getUpdatePartyType());
        sqlParameter.add(ClerksRolesMapping.Comments, clerksRoles.getComments());
        sqlParameter.add(ClerksRolesMapping.Status, clerksRoles.getStatus());
        sqlParameter.add(ClerksRolesMapping.ObjName, clerksRoles.getObjName());
        sqlParameter.add(ClerksRolesMapping.LoginAccountCode, clerksRoles.getLoginAccountCode());
        sqlParameter.add(ClerksRolesMapping.RoleCode, clerksRoles.getRoleCode());
        sqlParameter.add(ClerksRolesMapping.StartDate, clerksRoles.getStartDate());
        sqlParameter.add(ClerksRolesMapping.EndDate, clerksRoles.getEndDate());
        sqlParameter.add(ClerksRolesMapping.CreatedAt, clerksRoles.getCreatedAt());
        sqlParameter.add(ClerksRolesMapping.UpdatedAt, clerksRoles.getUpdatedAt());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(ClerksRoles clerksRoles)
    {
        String sql="UPDATE "+getTableName()+" set code=@{code},clerk_code=@{clerk_code},shop_code=@{shop_code},company_code=@{company_code},create_by=@{create_by},create_party_type=@{create_party_type},update_by=@{update_by},update_party_type=@{update_party_type},comments=@{comments},status=@{status},obj_name=@{obj_name},login_account_code=@{login_account_code},role_code=@{role_code},start_date=@{start_date},end_date=@{end_date},created_at=@{created_at},updated_at=@{updated_at} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ClerksRolesMapping.Id, clerksRoles.getId());
        sqlParameter.add(ClerksRolesMapping.Code, clerksRoles.getCode());
        sqlParameter.add(ClerksRolesMapping.ClerkCode, clerksRoles.getClerkCode());
        sqlParameter.add(ClerksRolesMapping.ShopCode, clerksRoles.getShopCode());
        sqlParameter.add(ClerksRolesMapping.CompanyCode, clerksRoles.getCompanyCode());
        sqlParameter.add(ClerksRolesMapping.CreateBy, clerksRoles.getCreateBy());
        sqlParameter.add(ClerksRolesMapping.CreatePartyType, clerksRoles.getCreatePartyType());
        sqlParameter.add(ClerksRolesMapping.UpdateBy, clerksRoles.getUpdateBy());
        sqlParameter.add(ClerksRolesMapping.UpdatePartyType, clerksRoles.getUpdatePartyType());
        sqlParameter.add(ClerksRolesMapping.Comments, clerksRoles.getComments());
        sqlParameter.add(ClerksRolesMapping.Status, clerksRoles.getStatus());
        sqlParameter.add(ClerksRolesMapping.ObjName, clerksRoles.getObjName());
        sqlParameter.add(ClerksRolesMapping.LoginAccountCode, clerksRoles.getLoginAccountCode());
        sqlParameter.add(ClerksRolesMapping.RoleCode, clerksRoles.getRoleCode());
        sqlParameter.add(ClerksRolesMapping.StartDate, clerksRoles.getStartDate());
        sqlParameter.add(ClerksRolesMapping.EndDate, clerksRoles.getEndDate());
        sqlParameter.add(ClerksRolesMapping.CreatedAt, clerksRoles.getCreatedAt());
        sqlParameter.add(ClerksRolesMapping.UpdatedAt, clerksRoles.getUpdatedAt());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(ClerksRolesMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }
    public PagedList<ClerksRoles> searchByPage(QueryCondition queryCondition) {
        PagedList<ClerksRoles> pagedList=this.searchByPage(queryCondition, ClerksRoles.class);
        return pagedList;
    }
    public List<ClerksRoles> searchList(QueryParameter queryParameter) {
                List<ClerksRoles> list=this.searchList(queryParameter, ClerksRoles.class);
                    return list;
    }
}
