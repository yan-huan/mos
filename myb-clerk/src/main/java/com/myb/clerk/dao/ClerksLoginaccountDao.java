package com.myb.clerk.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.clerk.ClerksLoginaccount;
import com.myb.entity.pojo.clerk.ClerksLoginaccountMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("clerksLoginaccountDao")
public class ClerksLoginaccountDao extends MySqlCommandBase {

	@Resource(name = "datacommand_write")
	private DataCommand dataCommandWrite;

	@Resource(name = "datacommand_read")
	private DataCommand dataCommandRead;

	@PostConstruct
	public void initDataCommand() {
		super.setDataCommand(dataCommandWrite);
	}

	@Override
	public String getTableName() {
		return "clerks_loginaccount";
	}

	public int insert(ClerksLoginaccount clerksLoginaccount) {
		String sql = "INSERT INTO "
				+ getTableName()
				+ " (id,code,clerk_code,shop_code,company_code,create_by,create_party_type,update_by,update_party_type,comments,status,avatar,beautician_code,mobile,password,token,expired_date,account_type,created_at,updated_at,release_level)VALUES(@{id},@{code},@{clerk_code},@{shop_code},@{company_code},@{create_by},@{create_party_type},@{update_by},@{update_party_type},@{comments},@{status},@{avatar},@{beautician_code},@{mobile},@{password},@{token},@{expired_date},@{account_type},@{created_at},@{updated_at},@{release_level})";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(ClerksLoginaccountMapping.Id,
				clerksLoginaccount.getId());
		sqlParameter.add(ClerksLoginaccountMapping.Code,
				clerksLoginaccount.getCode());
		sqlParameter.add(ClerksLoginaccountMapping.ClerkCode,
				clerksLoginaccount.getClerkCode());
		sqlParameter.add(ClerksLoginaccountMapping.ShopCode,
				clerksLoginaccount.getShopCode());
		sqlParameter.add(ClerksLoginaccountMapping.CompanyCode,
				clerksLoginaccount.getCompanyCode());
		sqlParameter.add(ClerksLoginaccountMapping.CreateBy,
				clerksLoginaccount.getCreateBy());
		sqlParameter.add(ClerksLoginaccountMapping.CreatePartyType,
				clerksLoginaccount.getCreatePartyType());
		sqlParameter.add(ClerksLoginaccountMapping.UpdateBy,
				clerksLoginaccount.getUpdateBy());
		sqlParameter.add(ClerksLoginaccountMapping.UpdatePartyType,
				clerksLoginaccount.getUpdatePartyType());
		sqlParameter.add(ClerksLoginaccountMapping.Comments,
				clerksLoginaccount.getComments());
		sqlParameter.add(ClerksLoginaccountMapping.Status,
				clerksLoginaccount.getStatus());
		sqlParameter.add(ClerksLoginaccountMapping.Avatar,
				clerksLoginaccount.getAvatar());
		sqlParameter.add(ClerksLoginaccountMapping.BeauticianCode,
				clerksLoginaccount.getBeauticianCode());
		sqlParameter.add(ClerksLoginaccountMapping.Mobile,
				clerksLoginaccount.getMobile());
		sqlParameter.add(ClerksLoginaccountMapping.Password,
				clerksLoginaccount.getPassword());
		sqlParameter.add(ClerksLoginaccountMapping.Token,
				clerksLoginaccount.getToken());
		sqlParameter.add(ClerksLoginaccountMapping.ExpiredDate,
				clerksLoginaccount.getExpiredDate());
		sqlParameter.add(ClerksLoginaccountMapping.AccountType,
				clerksLoginaccount.getAccountType());
		sqlParameter.add(ClerksLoginaccountMapping.CreatedAt,
				clerksLoginaccount.getCreatedAt());
		sqlParameter.add(ClerksLoginaccountMapping.UpdatedAt,
				clerksLoginaccount.getUpdatedAt());
		sqlParameter.add(ClerksLoginaccountMapping.ReleaseLevel,
				clerksLoginaccount.getReleaseLevel());
		return this.getDataCommand().executeNonQuery(sql, sqlParameter);
	}

	public int update(ClerksLoginaccount clerksLoginaccount) {
		String sql = "UPDATE "
				+ getTableName()
				+ " set code=@{code},clerk_code=@{clerk_code},shop_code=@{shop_code},company_code=@{company_code},create_by=@{create_by},create_party_type=@{create_party_type},update_by=@{update_by},update_party_type=@{update_party_type},comments=@{comments},status=@{status},avatar=@{avatar},beautician_code=@{beautician_code},mobile=@{mobile},password=@{password},token=@{token},expired_date=@{expired_date},account_type=@{account_type},created_at=@{created_at},updated_at=@{updated_at},release_level=@{release_level} WHERE id=@{id}";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(ClerksLoginaccountMapping.Id,
				clerksLoginaccount.getId());
		sqlParameter.add(ClerksLoginaccountMapping.Code,
				clerksLoginaccount.getCode());
		sqlParameter.add(ClerksLoginaccountMapping.ClerkCode,
				clerksLoginaccount.getClerkCode());
		sqlParameter.add(ClerksLoginaccountMapping.ShopCode,
				clerksLoginaccount.getShopCode());
		sqlParameter.add(ClerksLoginaccountMapping.CompanyCode,
				clerksLoginaccount.getCompanyCode());
		sqlParameter.add(ClerksLoginaccountMapping.CreateBy,
				clerksLoginaccount.getCreateBy());
		sqlParameter.add(ClerksLoginaccountMapping.CreatePartyType,
				clerksLoginaccount.getCreatePartyType());
		sqlParameter.add(ClerksLoginaccountMapping.UpdateBy,
				clerksLoginaccount.getUpdateBy());
		sqlParameter.add(ClerksLoginaccountMapping.UpdatePartyType,
				clerksLoginaccount.getUpdatePartyType());
		sqlParameter.add(ClerksLoginaccountMapping.Comments,
				clerksLoginaccount.getComments());
		sqlParameter.add(ClerksLoginaccountMapping.Status,
				clerksLoginaccount.getStatus());
		sqlParameter.add(ClerksLoginaccountMapping.Avatar,
				clerksLoginaccount.getAvatar());
		sqlParameter.add(ClerksLoginaccountMapping.BeauticianCode,
				clerksLoginaccount.getBeauticianCode());
		sqlParameter.add(ClerksLoginaccountMapping.Mobile,
				clerksLoginaccount.getMobile());
		sqlParameter.add(ClerksLoginaccountMapping.Password,
				clerksLoginaccount.getPassword());
		sqlParameter.add(ClerksLoginaccountMapping.Token,
				clerksLoginaccount.getToken());
		sqlParameter.add(ClerksLoginaccountMapping.ExpiredDate,
				clerksLoginaccount.getExpiredDate());
		sqlParameter.add(ClerksLoginaccountMapping.AccountType,
				clerksLoginaccount.getAccountType());
		sqlParameter.add(ClerksLoginaccountMapping.CreatedAt,
				clerksLoginaccount.getCreatedAt());
		sqlParameter.add(ClerksLoginaccountMapping.UpdatedAt,
				clerksLoginaccount.getUpdatedAt());
		sqlParameter.add(ClerksLoginaccountMapping.ReleaseLevel,
				clerksLoginaccount.getReleaseLevel());
		return this.getDataCommand().executeNonQuery(sql, sqlParameter);
	}

	public int delete(int id) {
		String sql = "DELETE FROM " + getTableName() + " WHERE id=@{id}";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(ClerksLoginaccountMapping.Id, id);
		return this.getDataCommand().executeNonQuery(sql, sqlParameter);
	}

	public PagedList<ClerksLoginaccount> searchByPage(
			QueryCondition queryCondition) {
		PagedList<ClerksLoginaccount> pagedList = this.searchByPage(
				queryCondition, ClerksLoginaccount.class);
		return pagedList;
	}

	public List<ClerksLoginaccount> searchList(QueryParameter queryParameter) {
		List<ClerksLoginaccount> list = this.searchList(queryParameter,
				ClerksLoginaccount.class);
		return list;
	}
}
