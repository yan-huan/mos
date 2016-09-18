package com.myb.clerk.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.clerk.ClerksBeautician;
import com.myb.entity.pojo.clerk.ClerksBeauticianMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("clerksBeauticianDao")
public class ClerksBeauticianDao extends MySqlCommandBase {

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
		return "clerks_beautician";
	}

	public int insert(ClerksBeautician clerksBeautician) {
		String sql = "INSERT INTO "
				+ getTableName()
				+ " (id,code,obj_name,age,sex,union_id,card_type,card_code,update_by,comments,status,created_at,updated_at)VALUES(@{id},@{code},@{obj_name},@{age},@{sex},@{union_id},@{card_type},@{card_code},@{update_by},@{comments},@{status},@{created_at},@{updated_at})";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(ClerksBeauticianMapping.Id, clerksBeautician.getId());
		sqlParameter.add(ClerksBeauticianMapping.Code,
				clerksBeautician.getCode());
		sqlParameter.add(ClerksBeauticianMapping.ObjName,
				clerksBeautician.getObjName());
		sqlParameter
				.add(ClerksBeauticianMapping.Age, clerksBeautician.getAge());
		sqlParameter
				.add(ClerksBeauticianMapping.Sex, clerksBeautician.getSex());
		sqlParameter.add(ClerksBeauticianMapping.UnionId,
				clerksBeautician.getUnionId());
		sqlParameter.add(ClerksBeauticianMapping.CardType,
				clerksBeautician.getCardType());
		sqlParameter.add(ClerksBeauticianMapping.CardCode,
				clerksBeautician.getCardCode());
		sqlParameter.add(ClerksBeauticianMapping.UpdateBy,
				clerksBeautician.getUpdateBy());
		sqlParameter.add(ClerksBeauticianMapping.Comments,
				clerksBeautician.getComments());
		sqlParameter.add(ClerksBeauticianMapping.Status,
				clerksBeautician.getStatus());
		sqlParameter.add(ClerksBeauticianMapping.CreatedAt,
				clerksBeautician.getCreatedAt());
		sqlParameter.add(ClerksBeauticianMapping.UpdatedAt,
				clerksBeautician.getUpdatedAt());
		return this.getDataCommand().executeNonQuery(sql, sqlParameter);
	}

	public int update(ClerksBeautician clerksBeautician) {
		String sql = "UPDATE "
				+ getTableName()
				+ " set code=@{code},obj_name=@{obj_name},age=@{age},sex=@{sex},union_id=@{union_id},card_type=@{card_type},card_code=@{card_code},update_by=@{update_by},comments=@{comments},status=@{status},created_at=@{created_at},updated_at=@{updated_at} WHERE id=@{id}";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(ClerksBeauticianMapping.Id, clerksBeautician.getId());
		sqlParameter.add(ClerksBeauticianMapping.Code,
				clerksBeautician.getCode());
		sqlParameter.add(ClerksBeauticianMapping.ObjName,
				clerksBeautician.getObjName());
		sqlParameter
				.add(ClerksBeauticianMapping.Age, clerksBeautician.getAge());
		sqlParameter
				.add(ClerksBeauticianMapping.Sex, clerksBeautician.getSex());
		sqlParameter.add(ClerksBeauticianMapping.UnionId,
				clerksBeautician.getUnionId());
		sqlParameter.add(ClerksBeauticianMapping.CardType,
				clerksBeautician.getCardType());
		sqlParameter.add(ClerksBeauticianMapping.CardCode,
				clerksBeautician.getCardCode());
		sqlParameter.add(ClerksBeauticianMapping.UpdateBy,
				clerksBeautician.getUpdateBy());
		sqlParameter.add(ClerksBeauticianMapping.Comments,
				clerksBeautician.getComments());
		sqlParameter.add(ClerksBeauticianMapping.Status,
				clerksBeautician.getStatus());
		sqlParameter.add(ClerksBeauticianMapping.CreatedAt,
				clerksBeautician.getCreatedAt());
		sqlParameter.add(ClerksBeauticianMapping.UpdatedAt,
				clerksBeautician.getUpdatedAt());
		return this.getDataCommand().executeNonQuery(sql, sqlParameter);
	}

}
