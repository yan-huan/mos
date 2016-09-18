package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryOut;
import com.myb.entity.pojo.inventory.InventoryOutMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventoryOutDao")
public class InventoryOutDao extends MySqlCommandBase {

	@Resource(name = "datacommand_inventory_write")
	private DataCommand dataCommandWrite;

	@Resource(name = "datacommand_inventory_read")
	private DataCommand dataCommandRead;

	@PostConstruct
	public void initDataCommand() {
		super.setDataCommand(dataCommandWrite);
	}

	@Override
	public String getTableName() {
		return "inventory_out";
	}

	/**
	 * 根据出库单号查询出库单（主库）
	 * @author hailin.liu 2016年5月17日 下午8:49:53 <br/>
	 * @param outCode
	 * @return
	 */
	public InventoryOut searchByOutCode(String outCode) {
		String sql = "SELECT * FROM " + getTableName() + " WHERE out_code=@{out_code}";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(InventoryOutMapping.OutCode, outCode);
		return this.dataCommandWrite.executeEntity(sql, sqlParameter,
				InventoryOut.class);
	}

	public InventoryOut insert(InventoryOut inventoryOut) {
		String sql = "INSERT INTO "
				+ getTableName()
				+ " (id,out_code,out_type,out_pattern,product_type,original_document,to_code,to_name,inventory_code,status,jingshouren_code,jingshouren_name,create_user_code,create_user_name,create_time)VALUES(@{id},@{out_code},@{out_type},@{out_pattern},@{product_type},@{original_document},@{to_code},@{to_name},@{inventory_code},@{status},@{jingshouren_code},@{jingshouren_name},@{create_user_code},@{create_user_name},@{create_time})";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(InventoryOutMapping.Id, inventoryOut.getId());
		sqlParameter
				.add(InventoryOutMapping.OutCode, inventoryOut.getOutCode());
		sqlParameter
				.add(InventoryOutMapping.OutType, inventoryOut.getOutType());
		sqlParameter.add(InventoryOutMapping.OutPattern,
				inventoryOut.getOutPattern());
		sqlParameter.add(InventoryOutMapping.ProductType,
				inventoryOut.getProductType());
		sqlParameter.add(InventoryOutMapping.OriginalDocument,
				inventoryOut.getOriginalDocument());
		sqlParameter.add(InventoryOutMapping.ToCode, inventoryOut.getToCode());
		sqlParameter.add(InventoryOutMapping.ToName, inventoryOut.getToName());
		sqlParameter.add(InventoryOutMapping.InventoryCode,
				inventoryOut.getInventoryCode());
		sqlParameter.add(InventoryOutMapping.Status, inventoryOut.getStatus());
		sqlParameter.add(InventoryOutMapping.JingshourenCode,
				inventoryOut.getJingshourenCode());
		sqlParameter.add(InventoryOutMapping.JingshourenName,
				inventoryOut.getJingshourenName());
		sqlParameter.add(InventoryOutMapping.CreateUserCode,
				inventoryOut.getCreateUserCode());
		sqlParameter.add(InventoryOutMapping.CreateUserName,
				inventoryOut.getCreateUserName());
		sqlParameter.add(InventoryOutMapping.CreateTime,
				inventoryOut.getCreateTime());
		int id = this.getDataCommand().insertAndGetKey(sql, sqlParameter).intValue();
		inventoryOut.setId(id);
		return inventoryOut;
	}

	public InventoryOut searchById(int id) {
		String sql = "SELECT * FROM " + getTableName() + " WHERE id=@{id}";
		SqlParameter sqlParameter = new SqlParameter();
		sqlParameter.add(InventoryOutMapping.Id, id);
		return this.dataCommandRead.executeEntity(sql, sqlParameter,
				InventoryOut.class);
	}

	public PagedList<InventoryOut> searchByPage(QueryCondition queryCondition) {
		PagedList<InventoryOut> pagedList = this.searchByPage(queryCondition,
				InventoryOut.class);
		return pagedList;
	}

	public List<InventoryOut> searchList(QueryParameter queryParameter) {
		List<InventoryOut> list = this.searchList(queryParameter,
				InventoryOut.class);
		return list;
	}
}
