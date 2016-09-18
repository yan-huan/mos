package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.BillsBillitem;
import com.myb.entity.pojo.inventory.BillsBillitemMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("billsBillitemDao")
public class BillsBillitemDao extends MySqlCommandBase
{

    @Resource(name = "datacommand_inventory_sync")
    private DataCommand dataCommand;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommand);
    }
    @Override
    public String getTableName()
    {
        return "bills_billitem";
    }


    public int insert(BillsBillitem billsBillitem)
    {
        String sql="INSERT INTO "+getTableName()+" (id,bill_id,code,currency_code,create_by,create_party_type,comments,status,bill_code,goods_meta_type,order_code,goods_code,goods_name_r,quantity,price,discount_price,is_apply_discount_rule,amount,origin_price,business_subject_code,related_promotion_code,xsyh_code,additional1,additional2,created_at,updated_at,belong_to_party_code,belong_to_party_type,update_party_type,update_by,is_gift,gift_times)VALUES(@{id},@{bill_id},@{code},@{currency_code},@{create_by},@{create_party_type},@{comments},@{status},@{bill_code},@{goods_meta_type},@{order_code},@{goods_code},@{goods_name_r},@{quantity},@{price},@{discount_price},@{is_apply_discount_rule},@{amount},@{origin_price},@{business_subject_code},@{related_promotion_code},@{xsyh_code},@{additional1},@{additional2},@{created_at},@{updated_at},@{belong_to_party_code},@{belong_to_party_type},@{update_party_type},@{update_by},@{is_gift},@{gift_times})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(BillsBillitemMapping.Id, billsBillitem.getId());
        sqlParameter.add(BillsBillitemMapping.BillId, billsBillitem.getBillId());
        sqlParameter.add(BillsBillitemMapping.Code, billsBillitem.getCode());
        sqlParameter.add(BillsBillitemMapping.CurrencyCode, billsBillitem.getCurrencyCode());
        sqlParameter.add(BillsBillitemMapping.CreateBy, billsBillitem.getCreateBy());
        sqlParameter.add(BillsBillitemMapping.CreatePartyType, billsBillitem.getCreatePartyType());
        sqlParameter.add(BillsBillitemMapping.Comments, billsBillitem.getComments());
        sqlParameter.add(BillsBillitemMapping.Status, billsBillitem.getStatus());
        sqlParameter.add(BillsBillitemMapping.BillCode, billsBillitem.getBillCode());
        sqlParameter.add(BillsBillitemMapping.GoodsMetaType, billsBillitem.getGoodsMetaType());
        sqlParameter.add(BillsBillitemMapping.OrderCode, billsBillitem.getOrderCode());
        sqlParameter.add(BillsBillitemMapping.GoodsCode, billsBillitem.getGoodsCode());
        sqlParameter.add(BillsBillitemMapping.GoodsNameR, billsBillitem.getGoodsNameR());
        sqlParameter.add(BillsBillitemMapping.Quantity, billsBillitem.getQuantity());
        sqlParameter.add(BillsBillitemMapping.Price, billsBillitem.getPrice());
        sqlParameter.add(BillsBillitemMapping.DiscountPrice, billsBillitem.getDiscountPrice());
        sqlParameter.add(BillsBillitemMapping.IsApplyDiscountRule, billsBillitem.getIsApplyDiscountRule());
        sqlParameter.add(BillsBillitemMapping.Amount, billsBillitem.getAmount());
        sqlParameter.add(BillsBillitemMapping.OriginPrice, billsBillitem.getOriginPrice());
        sqlParameter.add(BillsBillitemMapping.BusinessSubjectCode, billsBillitem.getBusinessSubjectCode());
        sqlParameter.add(BillsBillitemMapping.RelatedPromotionCode, billsBillitem.getRelatedPromotionCode());
        sqlParameter.add(BillsBillitemMapping.XsyhCode, billsBillitem.getXsyhCode());
        sqlParameter.add(BillsBillitemMapping.Additional1, billsBillitem.getAdditional1());
        sqlParameter.add(BillsBillitemMapping.Additional2, billsBillitem.getAdditional2());
        sqlParameter.add(BillsBillitemMapping.CreatedAt, billsBillitem.getCreatedAt());
        sqlParameter.add(BillsBillitemMapping.UpdatedAt, billsBillitem.getUpdatedAt());
        sqlParameter.add(BillsBillitemMapping.BelongToPartyCode, billsBillitem.getBelongToPartyCode());
        sqlParameter.add(BillsBillitemMapping.BelongToPartyType, billsBillitem.getBelongToPartyType());
        sqlParameter.add(BillsBillitemMapping.UpdatePartyType, billsBillitem.getUpdatePartyType());
        sqlParameter.add(BillsBillitemMapping.UpdateBy, billsBillitem.getUpdateBy());
        sqlParameter.add(BillsBillitemMapping.IsGift, billsBillitem.getIsGift());
        sqlParameter.add(BillsBillitemMapping.GiftTimes, billsBillitem.getGiftTimes());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(BillsBillitem billsBillitem)
    {
        String sql="UPDATE "+getTableName()+" set bill_id=@{bill_id},code=@{code},currency_code=@{currency_code},create_by=@{create_by},create_party_type=@{create_party_type},comments=@{comments},status=@{status},bill_code=@{bill_code},goods_meta_type=@{goods_meta_type},order_code=@{order_code},goods_code=@{goods_code},goods_name_r=@{goods_name_r},quantity=@{quantity},price=@{price},discount_price=@{discount_price},is_apply_discount_rule=@{is_apply_discount_rule},amount=@{amount},origin_price=@{origin_price},business_subject_code=@{business_subject_code},related_promotion_code=@{related_promotion_code},xsyh_code=@{xsyh_code},additional1=@{additional1},additional2=@{additional2},created_at=@{created_at},updated_at=@{updated_at},belong_to_party_code=@{belong_to_party_code},belong_to_party_type=@{belong_to_party_type},update_party_type=@{update_party_type},update_by=@{update_by},is_gift=@{is_gift},gift_times=@{gift_times} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(BillsBillitemMapping.Id, billsBillitem.getId());
        sqlParameter.add(BillsBillitemMapping.BillId, billsBillitem.getBillId());
        sqlParameter.add(BillsBillitemMapping.Code, billsBillitem.getCode());
        sqlParameter.add(BillsBillitemMapping.CurrencyCode, billsBillitem.getCurrencyCode());
        sqlParameter.add(BillsBillitemMapping.CreateBy, billsBillitem.getCreateBy());
        sqlParameter.add(BillsBillitemMapping.CreatePartyType, billsBillitem.getCreatePartyType());
        sqlParameter.add(BillsBillitemMapping.Comments, billsBillitem.getComments());
        sqlParameter.add(BillsBillitemMapping.Status, billsBillitem.getStatus());
        sqlParameter.add(BillsBillitemMapping.BillCode, billsBillitem.getBillCode());
        sqlParameter.add(BillsBillitemMapping.GoodsMetaType, billsBillitem.getGoodsMetaType());
        sqlParameter.add(BillsBillitemMapping.OrderCode, billsBillitem.getOrderCode());
        sqlParameter.add(BillsBillitemMapping.GoodsCode, billsBillitem.getGoodsCode());
        sqlParameter.add(BillsBillitemMapping.GoodsNameR, billsBillitem.getGoodsNameR());
        sqlParameter.add(BillsBillitemMapping.Quantity, billsBillitem.getQuantity());
        sqlParameter.add(BillsBillitemMapping.Price, billsBillitem.getPrice());
        sqlParameter.add(BillsBillitemMapping.DiscountPrice, billsBillitem.getDiscountPrice());
        sqlParameter.add(BillsBillitemMapping.IsApplyDiscountRule, billsBillitem.getIsApplyDiscountRule());
        sqlParameter.add(BillsBillitemMapping.Amount, billsBillitem.getAmount());
        sqlParameter.add(BillsBillitemMapping.OriginPrice, billsBillitem.getOriginPrice());
        sqlParameter.add(BillsBillitemMapping.BusinessSubjectCode, billsBillitem.getBusinessSubjectCode());
        sqlParameter.add(BillsBillitemMapping.RelatedPromotionCode, billsBillitem.getRelatedPromotionCode());
        sqlParameter.add(BillsBillitemMapping.XsyhCode, billsBillitem.getXsyhCode());
        sqlParameter.add(BillsBillitemMapping.Additional1, billsBillitem.getAdditional1());
        sqlParameter.add(BillsBillitemMapping.Additional2, billsBillitem.getAdditional2());
        sqlParameter.add(BillsBillitemMapping.CreatedAt, billsBillitem.getCreatedAt());
        sqlParameter.add(BillsBillitemMapping.UpdatedAt, billsBillitem.getUpdatedAt());
        sqlParameter.add(BillsBillitemMapping.BelongToPartyCode, billsBillitem.getBelongToPartyCode());
        sqlParameter.add(BillsBillitemMapping.BelongToPartyType, billsBillitem.getBelongToPartyType());
        sqlParameter.add(BillsBillitemMapping.UpdatePartyType, billsBillitem.getUpdatePartyType());
        sqlParameter.add(BillsBillitemMapping.UpdateBy, billsBillitem.getUpdateBy());
        sqlParameter.add(BillsBillitemMapping.IsGift, billsBillitem.getIsGift());
        sqlParameter.add(BillsBillitemMapping.GiftTimes, billsBillitem.getGiftTimes());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(BillsBillitemMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public BillsBillitem searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(BillsBillitemMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, BillsBillitem.class);
    }
    public PagedList<BillsBillitem> searchByPage(QueryCondition queryCondition) {
        PagedList<BillsBillitem> pagedList=this.searchByPage(queryCondition, BillsBillitem.class);
        return pagedList;
    }
    public List<BillsBillitem> searchList(QueryParameter queryParameter) {
                List<BillsBillitem> list=this.searchList(queryParameter, BillsBillitem.class);
                    return list;
    }
}
