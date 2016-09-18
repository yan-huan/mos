package com.myb.clerk.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.clerk.ClerksClerk;
import com.myb.entity.pojo.clerk.ClerksClerkMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("clerksClerkDao")
public class ClerksClerkDao extends MySqlCommandBase {

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
		return "clerks_clerk";
	}

	public int insert(ClerksClerk clerksClerk) {
		String sql = "INSERT INTO "
				+ getTableName()
				+ " (id,code,clerk_code,shop_code,company_code,create_by,create_party_type,update_by,update_party_type,comments,status,obj_name,beautician_code,age,gender,birthday,security_code,address,mobile,avatar,seniority,speciality,title,dreams,weixin,qq,complete_range,default_login_account_code,service_times,average_rank,evaluate_times,leave_date,created_at,updated_at)VALUES(@{id},@{code},@{clerk_code},@{shop_code},@{company_code},@{create_by},@{create_party_type},@{update_by},@{update_party_type},@{comments},@{status},@{obj_name},@{beautician_code},@{age},@{gender},@{birthday},@{security_code},@{address},@{mobile},@{avatar},@{seniority},@{speciality},@{title},@{dreams},@{weixin},@{qq},@{complete_range},@{default_login_account_code},@{service_times},@{average_rank},@{evaluate_times},@{leave_date},@{created_at},@{updated_at})";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(ClerksClerkMapping.Id, clerksClerk.getId());
		sqlParameter.add(ClerksClerkMapping.Code, clerksClerk.getCode());
		sqlParameter.add(ClerksClerkMapping.ClerkCode,
				clerksClerk.getClerkCode());
		sqlParameter
				.add(ClerksClerkMapping.ShopCode, clerksClerk.getShopCode());
		sqlParameter.add(ClerksClerkMapping.CompanyCode,
				clerksClerk.getCompanyCode());
		sqlParameter
				.add(ClerksClerkMapping.CreateBy, clerksClerk.getCreateBy());
		sqlParameter.add(ClerksClerkMapping.CreatePartyType,
				clerksClerk.getCreatePartyType());
		sqlParameter
				.add(ClerksClerkMapping.UpdateBy, clerksClerk.getUpdateBy());
		sqlParameter.add(ClerksClerkMapping.UpdatePartyType,
				clerksClerk.getUpdatePartyType());
		sqlParameter
				.add(ClerksClerkMapping.Comments, clerksClerk.getComments());
		sqlParameter.add(ClerksClerkMapping.Status, clerksClerk.getStatus());
		sqlParameter.add(ClerksClerkMapping.ObjName, clerksClerk.getObjName());
		sqlParameter.add(ClerksClerkMapping.BeauticianCode,
				clerksClerk.getBeauticianCode());
		sqlParameter.add(ClerksClerkMapping.Age, clerksClerk.getAge());
		sqlParameter.add(ClerksClerkMapping.Gender, clerksClerk.getGender());
		sqlParameter
				.add(ClerksClerkMapping.Birthday, clerksClerk.getBirthday());
		sqlParameter.add(ClerksClerkMapping.SecurityCode,
				clerksClerk.getSecurityCode());
		sqlParameter.add(ClerksClerkMapping.Address, clerksClerk.getAddress());
		sqlParameter.add(ClerksClerkMapping.Mobile, clerksClerk.getMobile());
		sqlParameter.add(ClerksClerkMapping.Avatar, clerksClerk.getAvatar());
		sqlParameter.add(ClerksClerkMapping.Seniority,
				clerksClerk.getSeniority());
		sqlParameter.add(ClerksClerkMapping.Speciality,
				clerksClerk.getSpeciality());
		sqlParameter.add(ClerksClerkMapping.Title, clerksClerk.getTitle());
		sqlParameter.add(ClerksClerkMapping.Dreams, clerksClerk.getDreams());
		sqlParameter.add(ClerksClerkMapping.Weixin, clerksClerk.getWeixin());
		sqlParameter.add(ClerksClerkMapping.Qq, clerksClerk.getQq());
		sqlParameter.add(ClerksClerkMapping.CompleteRange,
				clerksClerk.getCompleteRange());
		sqlParameter.add(ClerksClerkMapping.DefaultLoginAccountCode,
				clerksClerk.getDefaultLoginAccountCode());
		sqlParameter.add(ClerksClerkMapping.ServiceTimes,
				clerksClerk.getServiceTimes());
		sqlParameter.add(ClerksClerkMapping.AverageRank,
				clerksClerk.getAverageRank());
		sqlParameter.add(ClerksClerkMapping.EvaluateTimes,
				clerksClerk.getEvaluateTimes());
		sqlParameter.add(ClerksClerkMapping.LeaveDate,
				clerksClerk.getLeaveDate());
		sqlParameter.add(ClerksClerkMapping.CreatedAt,
				clerksClerk.getCreatedAt());
		sqlParameter.add(ClerksClerkMapping.UpdatedAt,
				clerksClerk.getUpdatedAt());
		return this.getDataCommand().executeNonQuery(sql, sqlParameter);
	}

	public int update(ClerksClerk clerksClerk) {
		String sql = "UPDATE "
				+ getTableName()
				+ " set code=@{code},clerk_code=@{clerk_code},shop_code=@{shop_code},company_code=@{company_code},create_by=@{create_by},create_party_type=@{create_party_type},update_by=@{update_by},update_party_type=@{update_party_type},comments=@{comments},status=@{status},obj_name=@{obj_name},beautician_code=@{beautician_code},age=@{age},gender=@{gender},birthday=@{birthday},security_code=@{security_code},address=@{address},mobile=@{mobile},avatar=@{avatar},seniority=@{seniority},speciality=@{speciality},title=@{title},dreams=@{dreams},weixin=@{weixin},qq=@{qq},complete_range=@{complete_range},default_login_account_code=@{default_login_account_code},service_times=@{service_times},average_rank=@{average_rank},evaluate_times=@{evaluate_times},leave_date=@{leave_date},created_at=@{created_at},updated_at=@{updated_at} WHERE id=@{id}";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(ClerksClerkMapping.Id, clerksClerk.getId());
		sqlParameter.add(ClerksClerkMapping.Code, clerksClerk.getCode());
		sqlParameter.add(ClerksClerkMapping.ClerkCode,
				clerksClerk.getClerkCode());
		sqlParameter
				.add(ClerksClerkMapping.ShopCode, clerksClerk.getShopCode());
		sqlParameter.add(ClerksClerkMapping.CompanyCode,
				clerksClerk.getCompanyCode());
		sqlParameter
				.add(ClerksClerkMapping.CreateBy, clerksClerk.getCreateBy());
		sqlParameter.add(ClerksClerkMapping.CreatePartyType,
				clerksClerk.getCreatePartyType());
		sqlParameter
				.add(ClerksClerkMapping.UpdateBy, clerksClerk.getUpdateBy());
		sqlParameter.add(ClerksClerkMapping.UpdatePartyType,
				clerksClerk.getUpdatePartyType());
		sqlParameter
				.add(ClerksClerkMapping.Comments, clerksClerk.getComments());
		sqlParameter.add(ClerksClerkMapping.Status, clerksClerk.getStatus());
		sqlParameter.add(ClerksClerkMapping.ObjName, clerksClerk.getObjName());
		sqlParameter.add(ClerksClerkMapping.BeauticianCode,
				clerksClerk.getBeauticianCode());
		sqlParameter.add(ClerksClerkMapping.Age, clerksClerk.getAge());
		sqlParameter.add(ClerksClerkMapping.Gender, clerksClerk.getGender());
		sqlParameter
				.add(ClerksClerkMapping.Birthday, clerksClerk.getBirthday());
		sqlParameter.add(ClerksClerkMapping.SecurityCode,
				clerksClerk.getSecurityCode());
		sqlParameter.add(ClerksClerkMapping.Address, clerksClerk.getAddress());
		sqlParameter.add(ClerksClerkMapping.Mobile, clerksClerk.getMobile());
		sqlParameter.add(ClerksClerkMapping.Avatar, clerksClerk.getAvatar());
		sqlParameter.add(ClerksClerkMapping.Seniority,
				clerksClerk.getSeniority());
		sqlParameter.add(ClerksClerkMapping.Speciality,
				clerksClerk.getSpeciality());
		sqlParameter.add(ClerksClerkMapping.Title, clerksClerk.getTitle());
		sqlParameter.add(ClerksClerkMapping.Dreams, clerksClerk.getDreams());
		sqlParameter.add(ClerksClerkMapping.Weixin, clerksClerk.getWeixin());
		sqlParameter.add(ClerksClerkMapping.Qq, clerksClerk.getQq());
		sqlParameter.add(ClerksClerkMapping.CompleteRange,
				clerksClerk.getCompleteRange());
		sqlParameter.add(ClerksClerkMapping.DefaultLoginAccountCode,
				clerksClerk.getDefaultLoginAccountCode());
		sqlParameter.add(ClerksClerkMapping.ServiceTimes,
				clerksClerk.getServiceTimes());
		sqlParameter.add(ClerksClerkMapping.AverageRank,
				clerksClerk.getAverageRank());
		sqlParameter.add(ClerksClerkMapping.EvaluateTimes,
				clerksClerk.getEvaluateTimes());
		sqlParameter.add(ClerksClerkMapping.LeaveDate,
				clerksClerk.getLeaveDate());
		sqlParameter.add(ClerksClerkMapping.CreatedAt,
				clerksClerk.getCreatedAt());
		sqlParameter.add(ClerksClerkMapping.UpdatedAt,
				clerksClerk.getUpdatedAt());
		return this.getDataCommand().executeNonQuery(sql, sqlParameter);
	}

	public int delete(int id) {
		String sql = "DELETE FROM " + getTableName() + " WHERE id=@{id}";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(ClerksClerkMapping.Id, id);
		return this.getDataCommand().executeNonQuery(sql, sqlParameter);
	}

	public PagedList<ClerksClerk> searchByPage(QueryCondition queryCondition) {
		PagedList<ClerksClerk> pagedList = this.searchByPage(queryCondition,
				ClerksClerk.class);
		return pagedList;
	}

	public List<ClerksClerk> searchList(QueryParameter queryParameter) {
		List<ClerksClerk> list = this.searchList(queryParameter,
				ClerksClerk.class);
		return list;
	}
}
