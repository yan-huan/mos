package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.InventoryMapping;
import com.myb.entity.pojo.inventory.InventorySku;
import com.myb.entity.pojo.inventory.InventorySkuMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("inventorySkuDao")
public class InventorySkuDao extends MySqlCommandBase
{

	@Resource(name = "datacommand_inventory_write")
    private DataCommand dataCommandWrite;
    @Resource(name = "datacommand_inventory_read")
    private DataCommand dataCommandRead;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName()
    {
        return "inventory_sku";
    }
    
    /**
     * 根据商品code查询库存商品(从库)
     * @author hailin.liu 2016年5月16日 下午4:26:50 <br/>
     * @param productCode		商品code
     * @return	库存商品信息
     */
    public InventorySku searchByProductCode(java.lang.String productCode, String status) {
        String sql="SELECT * FROM "+getTableName()+" WHERE product_code=@{product_code}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventorySkuMapping.ProductCode,productCode);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventorySku.class);
    }
    

    public int insert(InventorySku inventorySku)
    {
        String sql="INSERT INTO "+getTableName()+" (inventory_sku_code,product_brand_code,product_brand_name,product_unit,product_code,product_name,product_type,create_time,update_time)VALUES(@{inventory_sku_code},@{product_brand_code},@{product_brand_name},@{product_unit},@{product_code},@{product_name},@{product_type},@{create_time},@{update_time})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventorySkuMapping.InventorySkuCode, inventorySku.getInventorySkuCode());
        sqlParameter.add(InventorySkuMapping.ProductBrandCode, inventorySku.getProductBrandCode());
        sqlParameter.add(InventorySkuMapping.ProductBrandName, inventorySku.getProductBrandName());
        sqlParameter.add(InventorySkuMapping.ProductUnit, inventorySku.getProductUnit());
        sqlParameter.add(InventorySkuMapping.ProductCode, inventorySku.getProductCode());
        sqlParameter.add(InventorySkuMapping.ProductName, inventorySku.getProductName());
        sqlParameter.add(InventorySkuMapping.ProductType, inventorySku.getProductType());
        sqlParameter.add(InventorySkuMapping.CreateTime, inventorySku.getCreateTime());
        sqlParameter.add(InventorySkuMapping.UpdateTime, inventorySku.getUpdateTime());
        sqlParameter.add(InventorySkuMapping.ParentCode, inventorySku.getParentCode());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(InventorySku inventorySku)
    {
        String sql="UPDATE "+getTableName()+" set product_brand_code=@{product_brand_code},product_brand_name=@{product_brand_name},product_unit=@{product_unit},product_code=@{product_code},product_name=@{product_name},product_type=@{product_type},create_time=@{create_time},update_time=@{update_time} WHERE inventory_sku_code=@{inventory_sku_code}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventorySkuMapping.InventorySkuCode, inventorySku.getInventorySkuCode());
        sqlParameter.add(InventorySkuMapping.ProductBrandCode, inventorySku.getProductBrandCode());
        sqlParameter.add(InventorySkuMapping.ProductBrandName, inventorySku.getProductBrandName());
        sqlParameter.add(InventorySkuMapping.ProductUnit, inventorySku.getProductUnit());
        sqlParameter.add(InventorySkuMapping.ProductCode, inventorySku.getProductCode());
        sqlParameter.add(InventorySkuMapping.ProductName, inventorySku.getProductName());
        sqlParameter.add(InventorySkuMapping.ProductType, inventorySku.getProductType());
        sqlParameter.add(InventorySkuMapping.CreateTime, inventorySku.getCreateTime());
        sqlParameter.add(InventorySkuMapping.UpdateTime, inventorySku.getUpdateTime());
        sqlParameter.add(InventorySkuMapping.ParentCode, inventorySku.getParentCode());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    /**
     * 根据库存商品code查询库存商品（从库）
     * @author hailin.liu 2016年5月18日 下午5:04:07 <br/>
     * @param inventorySkuCode
     * @return
     */
    public InventorySku searchByInventorySkuCode(java.lang.String inventorySkuCode) {
        String sql="SELECT * FROM "+getTableName()+" WHERE inventory_sku_code=@{inventory_sku_code}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventorySkuMapping.InventorySkuCode,inventorySkuCode);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, InventorySku.class);
    }
    public PagedList<InventorySku> searchByPage(QueryCondition queryCondition) {
        PagedList<InventorySku> pagedList=this.searchByPage(queryCondition, InventorySku.class);
        return pagedList;
    }
    
    /**
     * 
     * @return
     */
    public PagedList<InventorySku> searchPage(String inventoryCode, String productType, String productBrandCode, Integer page, Integer pageSize) {
    	String sql = "SELECT sku.* FROM inventory i, inventory_item ii, inventory_sku sku "
    			+ " WHERE i.inventory_code = ii.inventory_code and ii.inventory_sku_code = sku.inventory_sku_code "
    			+ " AND i.inventory_code = @{inventory_code} AND sku.product_brand_code = @{product_brand_code} AND sku.product_type = @{product_type} "
    			+ " ORDER BY ii.create_time DESC "
    			+ " limit @{firstIndex},@{pageSize} ";
    	SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryMapping.InventoryCode,inventoryCode);
        sqlParameter.add(InventorySkuMapping.ProductBrandCode,productBrandCode);
        sqlParameter.add(InventorySkuMapping.ProductType,productType);
        sqlParameter.add("firstIndex",(page-1)*pageSize);
        sqlParameter.add("pageSize", pageSize);
        List<InventorySku> InventorySkuList = dataCommandRead.executeList(sql, sqlParameter, InventorySku.class);
        
        sql = "SELECT count(*) FROM inventory i, inventory_item ii, inventory_sku sku "
    			+ " WHERE i.inventory_code = ii.inventory_code and ii.inventory_sku_code = sku.inventory_sku_code "
    			+ " AND i.inventory_code = @{inventory_code} AND sku.product_brand_code = @{product_brand_code} AND sku.product_type = @{product_type} ";
        sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryMapping.InventoryCode,inventoryCode);
        sqlParameter.add(InventorySkuMapping.ProductBrandCode,productBrandCode);
        sqlParameter.add(InventorySkuMapping.ProductType,productType);
        Number count = dataCommandRead.executeScale(sql, sqlParameter, Number.class);
        
        PagedList<InventorySku> pageList = new PagedList<InventorySku>();
        pageList.setContent(InventorySkuList);
        pageList.setRecordCount(count.intValue());
        pageList.setPageIndex(page);
        pageList.setPageSize(pageSize);
        pageList.setTotalPage((count.intValue()%pageSize) == 0 ? count.intValue()/pageSize : count.intValue()/pageSize + 1);
        return pageList;
    }
    
    /**
     * 查询从库
     * @author hailin.liu 2016年5月17日 下午2:35:01 <br/>
     * @param queryParameter
     * @return
     */
    public List<InventorySku> searchListR(QueryParameter queryParameter) {
                List<InventorySku> list=this.searchList(queryParameter, InventorySku.class, dataCommandRead);
                    return list;
    }
    
    /**
     * 根据库存code查询库存商品列表
     * @param inventoryCode
     * @return
     */
    public List<InventorySku> searchProductListR(String inventoryCode, String productType) {
    	StringBuilder sql = new StringBuilder("SELECT sku.* FROM inventory_item ii, inventory_sku sku WHERE ii.inventory_sku_code = sku.inventory_sku_code AND inventory_code = @{inventory_code}");
    	SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryMapping.InventoryCode,inventoryCode);
        if(StringUtils.isNotEmpty(productType)) {
        	sql.append(" and sku.product_type = @{product_type}");
        	sqlParameter.add(InventorySkuMapping.ProductType,productType);
        }
        sql.append(" ORDER BY sku.create_time DESC");
    	return this.dataCommandRead.executeList(sql.toString(), sqlParameter, InventorySku.class);
    }
    
    /**
     * 计算成本，如果不传递品牌code和商品code，则计算总成本。如果传递品牌code，不传递商品code，则计算品牌成本。如果都穿，则计算商品成本
     * @param inventoryCode
     * @param productType
     * @param productBrandCode
     * @param productCode
     * @return
     */
	public Double totalCost(String inventoryCode, String productType, String productBrandCode, String productCode) {
		StringBuilder sql = new StringBuilder("SELECT SUM(ii.stock_number*ii.average_price) FROM inventory_item ii, inventory_sku sku WHERE ii.inventory_sku_code = sku.inventory_sku_code AND ii.inventory_code = @{inventory_code} AND sku.product_type = @{product_type}");
		SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(InventoryMapping.InventoryCode,inventoryCode);
        sqlParameter.add(InventorySkuMapping.ProductType,productType);
        
        if(StringUtils.isNotEmpty(productBrandCode)) {
        	sql.append(" AND sku.product_brand_code = @{product_brand_code} ");
        	sqlParameter.add(InventorySkuMapping.ProductBrandCode, productBrandCode);
        }
        
        if(StringUtils.isNotEmpty(productCode)) {
        	sql.append(" AND sku.product_code = @{product_code} ");
        	sqlParameter.add(InventorySkuMapping.ProductCode, productCode);
        }
        
		return this.dataCommandRead.executeScale(sql.toString(), sqlParameter, Double.class);
	}
    
}
