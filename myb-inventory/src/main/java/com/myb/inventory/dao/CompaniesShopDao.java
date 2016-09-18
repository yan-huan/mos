package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.CompaniesShop;
import com.myb.entity.pojo.inventory.CompaniesShopMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("companiesShopDao")
public class CompaniesShopDao extends MySqlCommandBase
{

    @Resource(name = "datacommand_inventory_write")
    private DataCommand dataCommandWrite;

    @Resource(name = "datacommand_inventory_read")
    private DataCommand datacommandRead;
    
    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName()
    {
        return "companies_shop";
    }


    public int insert(CompaniesShop companiesShop)
    {
        String sql="INSERT INTO "+getTableName()+" (id,belong_to_party_type,belong_to_party_code,code,create_by,create_party_type,update_by,cover,update_party_type,comments,status,obj_name,address,description,service_phone,bed_count,room_count,area_count,company_code,start_operating_time,end_operating_time,service_type,created_at,updated_at)VALUES(@{id},@{belong_to_party_type},@{belong_to_party_code},@{code},@{create_by},@{create_party_type},@{update_by},@{cover},@{update_party_type},@{comments},@{status},@{obj_name},@{address},@{description},@{service_phone},@{bed_count},@{room_count},@{area_count},@{company_code},@{start_operating_time},@{end_operating_time},@{service_type},@{created_at},@{updated_at})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CompaniesShopMapping.Id, companiesShop.getId());
        sqlParameter.add(CompaniesShopMapping.BelongToPartyType, companiesShop.getBelongToPartyType());
        sqlParameter.add(CompaniesShopMapping.BelongToPartyCode, companiesShop.getBelongToPartyCode());
        sqlParameter.add(CompaniesShopMapping.Code, companiesShop.getCode());
        sqlParameter.add(CompaniesShopMapping.CreateBy, companiesShop.getCreateBy());
        sqlParameter.add(CompaniesShopMapping.CreatePartyType, companiesShop.getCreatePartyType());
        sqlParameter.add(CompaniesShopMapping.UpdateBy, companiesShop.getUpdateBy());
        sqlParameter.add(CompaniesShopMapping.Cover, companiesShop.getCover());
        sqlParameter.add(CompaniesShopMapping.UpdatePartyType, companiesShop.getUpdatePartyType());
        sqlParameter.add(CompaniesShopMapping.Comments, companiesShop.getComments());
        sqlParameter.add(CompaniesShopMapping.Status, companiesShop.getStatus());
        sqlParameter.add(CompaniesShopMapping.ObjName, companiesShop.getObjName());
        sqlParameter.add(CompaniesShopMapping.Address, companiesShop.getAddress());
        sqlParameter.add(CompaniesShopMapping.Description, companiesShop.getDescription());
        sqlParameter.add(CompaniesShopMapping.ServicePhone, companiesShop.getServicePhone());
        sqlParameter.add(CompaniesShopMapping.BedCount, companiesShop.getBedCount());
        sqlParameter.add(CompaniesShopMapping.RoomCount, companiesShop.getRoomCount());
        sqlParameter.add(CompaniesShopMapping.AreaCount, companiesShop.getAreaCount());
        sqlParameter.add(CompaniesShopMapping.CompanyCode, companiesShop.getCompanyCode());
        sqlParameter.add(CompaniesShopMapping.StartOperatingTime, companiesShop.getStartOperatingTime());
        sqlParameter.add(CompaniesShopMapping.EndOperatingTime, companiesShop.getEndOperatingTime());
        sqlParameter.add(CompaniesShopMapping.ServiceType, companiesShop.getServiceType());
        sqlParameter.add(CompaniesShopMapping.CreatedAt, companiesShop.getCreatedAt());
        sqlParameter.add(CompaniesShopMapping.UpdatedAt, companiesShop.getUpdatedAt());
        return this.dataCommandWrite.executeNonQuery(sql, sqlParameter);
    }

    public int update(CompaniesShop companiesShop)
    {
        String sql="UPDATE "+getTableName()+" set belong_to_party_type=@{belong_to_party_type},belong_to_party_code=@{belong_to_party_code},code=@{code},create_by=@{create_by},create_party_type=@{create_party_type},update_by=@{update_by},cover=@{cover},update_party_type=@{update_party_type},comments=@{comments},status=@{status},obj_name=@{obj_name},address=@{address},description=@{description},service_phone=@{service_phone},bed_count=@{bed_count},room_count=@{room_count},area_count=@{area_count},company_code=@{company_code},start_operating_time=@{start_operating_time},end_operating_time=@{end_operating_time},service_type=@{service_type},created_at=@{created_at},updated_at=@{updated_at} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CompaniesShopMapping.Id, companiesShop.getId());
        sqlParameter.add(CompaniesShopMapping.BelongToPartyType, companiesShop.getBelongToPartyType());
        sqlParameter.add(CompaniesShopMapping.BelongToPartyCode, companiesShop.getBelongToPartyCode());
        sqlParameter.add(CompaniesShopMapping.Code, companiesShop.getCode());
        sqlParameter.add(CompaniesShopMapping.CreateBy, companiesShop.getCreateBy());
        sqlParameter.add(CompaniesShopMapping.CreatePartyType, companiesShop.getCreatePartyType());
        sqlParameter.add(CompaniesShopMapping.UpdateBy, companiesShop.getUpdateBy());
        sqlParameter.add(CompaniesShopMapping.Cover, companiesShop.getCover());
        sqlParameter.add(CompaniesShopMapping.UpdatePartyType, companiesShop.getUpdatePartyType());
        sqlParameter.add(CompaniesShopMapping.Comments, companiesShop.getComments());
        sqlParameter.add(CompaniesShopMapping.Status, companiesShop.getStatus());
        sqlParameter.add(CompaniesShopMapping.ObjName, companiesShop.getObjName());
        sqlParameter.add(CompaniesShopMapping.Address, companiesShop.getAddress());
        sqlParameter.add(CompaniesShopMapping.Description, companiesShop.getDescription());
        sqlParameter.add(CompaniesShopMapping.ServicePhone, companiesShop.getServicePhone());
        sqlParameter.add(CompaniesShopMapping.BedCount, companiesShop.getBedCount());
        sqlParameter.add(CompaniesShopMapping.RoomCount, companiesShop.getRoomCount());
        sqlParameter.add(CompaniesShopMapping.AreaCount, companiesShop.getAreaCount());
        sqlParameter.add(CompaniesShopMapping.CompanyCode, companiesShop.getCompanyCode());
        sqlParameter.add(CompaniesShopMapping.StartOperatingTime, companiesShop.getStartOperatingTime());
        sqlParameter.add(CompaniesShopMapping.EndOperatingTime, companiesShop.getEndOperatingTime());
        sqlParameter.add(CompaniesShopMapping.ServiceType, companiesShop.getServiceType());
        sqlParameter.add(CompaniesShopMapping.CreatedAt, companiesShop.getCreatedAt());
        sqlParameter.add(CompaniesShopMapping.UpdatedAt, companiesShop.getUpdatedAt());
        return this.dataCommandWrite.executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CompaniesShopMapping.Id,id);
        return this.datacommandRead.executeNonQuery(sql, sqlParameter);
    }

    public CompaniesShop searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(CompaniesShopMapping.Id,id);
        return this.datacommandRead.executeEntity(sql, sqlParameter, CompaniesShop.class);
    }
    public PagedList<CompaniesShop> searchByPage(QueryCondition queryCondition) {
        PagedList<CompaniesShop> pagedList=this.searchByPage(queryCondition, CompaniesShop.class, datacommandRead);
        return pagedList;
    }
    public List<CompaniesShop> searchList(QueryParameter queryParameter) {
                List<CompaniesShop> list=this.searchList(queryParameter, CompaniesShop.class, datacommandRead);
                    return list;
    }
}
