package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class BillsBillitem extends EntityBase{

    @DataMapping(BillsBillitemMapping.Id)
    private int id;//
    @DataMapping(BillsBillitemMapping.BillId)
    private int billId;//
    @DataMapping(BillsBillitemMapping.Code)
    private java.lang.String code;//
    @DataMapping(BillsBillitemMapping.CurrencyCode)
    private java.lang.String currencyCode;//
    @DataMapping(BillsBillitemMapping.CreateBy)
    private java.lang.String createBy;//
    @DataMapping(BillsBillitemMapping.CreatePartyType)
    private java.lang.String createPartyType;//
    @DataMapping(BillsBillitemMapping.Comments)
    private java.lang.String comments;//
    @DataMapping(BillsBillitemMapping.Status)
    private java.lang.String status;//
    @DataMapping(BillsBillitemMapping.BillCode)
    private java.lang.String billCode;//账单明细code
    @DataMapping(BillsBillitemMapping.GoodsMetaType)
    private java.lang.String goodsMetaType;//SERVICE--商品--服务类商品；PRODUCT--商品--实物类商品；COURSE--商品--卡券类商品--疗程卡；MEMBER--商品--卡券类商品--销售的会员卡；COUPON--商品--卡券类商品--销售的优惠卡优惠券
    @DataMapping(BillsBillitemMapping.OrderCode)
    private java.lang.String orderCode;//订单code
    @DataMapping(BillsBillitemMapping.GoodsCode)
    private java.lang.String goodsCode;//商品code
    @DataMapping(BillsBillitemMapping.GoodsNameR)
    private java.lang.String goodsNameR;//商品名称
    @DataMapping(BillsBillitemMapping.Quantity)
    private int quantity;//数量
    @DataMapping(BillsBillitemMapping.Price)
    private long price;//交易价格
    @DataMapping(BillsBillitemMapping.DiscountPrice)
    private long discountPrice;//删除适用新折扣规则后的价格
    @DataMapping(BillsBillitemMapping.IsApplyDiscountRule)
    private boolean isApplyDiscountRule;//是否接受折扣或者再次折扣
    @DataMapping(BillsBillitemMapping.Amount)
    private long amount;//交易总价
    @DataMapping(BillsBillitemMapping.OriginPrice)
    private long originPrice;//原价.项目卡的原价是取amount,项目单次消费是取price,产品取goods的originPrice
    @DataMapping(BillsBillitemMapping.BusinessSubjectCode)
    private java.lang.String businessSubjectCode;//
    @DataMapping(BillsBillitemMapping.RelatedPromotionCode)
    private java.lang.String relatedPromotionCode;//
    @DataMapping(BillsBillitemMapping.XsyhCode)
    private java.lang.String xsyhCode;//
    @DataMapping(BillsBillitemMapping.Additional1)
    private java.lang.String additional1;//扩展字段1
    @DataMapping(BillsBillitemMapping.Additional2)
    private java.lang.String additional2;//扩展字段2
    @DataMapping(BillsBillitemMapping.CreatedAt)
    private java.sql.Timestamp createdAt;//
    @DataMapping(BillsBillitemMapping.UpdatedAt)
    private java.sql.Timestamp updatedAt;//
    @DataMapping(BillsBillitemMapping.BelongToPartyCode)
    private java.lang.String belongToPartyCode;//
    @DataMapping(BillsBillitemMapping.BelongToPartyType)
    private java.lang.String belongToPartyType;//
    @DataMapping(BillsBillitemMapping.UpdatePartyType)
    private java.lang.String updatePartyType;//
    @DataMapping(BillsBillitemMapping.UpdateBy)
    private java.lang.String updateBy;//
    @DataMapping(BillsBillitemMapping.IsGift)
    private boolean isGift;//
    @DataMapping(BillsBillitemMapping.GiftTimes)
    private int giftTimes;//


    public BillsBillitem() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getBillId()
    {
        return billId;
    }

    public void setBillId(int billId)
    {
        this.billId = billId;
    }
    public java.lang.String getCode()
    {
        return code;
    }

    public void setCode(java.lang.String code)
    {
        this.code = code;
    }
    public java.lang.String getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(java.lang.String currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    public java.lang.String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(java.lang.String createBy)
    {
        this.createBy = createBy;
    }
    public java.lang.String getCreatePartyType()
    {
        return createPartyType;
    }

    public void setCreatePartyType(java.lang.String createPartyType)
    {
        this.createPartyType = createPartyType;
    }
    public java.lang.String getComments()
    {
        return comments;
    }

    public void setComments(java.lang.String comments)
    {
        this.comments = comments;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    public java.lang.String getBillCode()
    {
        return billCode;
    }

    public void setBillCode(java.lang.String billCode)
    {
        this.billCode = billCode;
    }
    public java.lang.String getGoodsMetaType()
    {
        return goodsMetaType;
    }

    public void setGoodsMetaType(java.lang.String goodsMetaType)
    {
        this.goodsMetaType = goodsMetaType;
    }
    public java.lang.String getOrderCode()
    {
        return orderCode;
    }

    public void setOrderCode(java.lang.String orderCode)
    {
        this.orderCode = orderCode;
    }
    public java.lang.String getGoodsCode()
    {
        return goodsCode;
    }

    public void setGoodsCode(java.lang.String goodsCode)
    {
        this.goodsCode = goodsCode;
    }
    public java.lang.String getGoodsNameR()
    {
        return goodsNameR;
    }

    public void setGoodsNameR(java.lang.String goodsNameR)
    {
        this.goodsNameR = goodsNameR;
    }
    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public long getPrice()
    {
        return price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }
    public long getDiscountPrice()
    {
        return discountPrice;
    }

    public void setDiscountPrice(long discountPrice)
    {
        this.discountPrice = discountPrice;
    }
    public boolean getIsApplyDiscountRule()
    {
        return isApplyDiscountRule;
    }

    public void setIsApplyDiscountRule(boolean isApplyDiscountRule)
    {
        this.isApplyDiscountRule = isApplyDiscountRule;
    }
    public long getAmount()
    {
        return amount;
    }

    public void setAmount(long amount)
    {
        this.amount = amount;
    }
    public long getOriginPrice()
    {
        return originPrice;
    }

    public void setOriginPrice(long originPrice)
    {
        this.originPrice = originPrice;
    }
    public java.lang.String getBusinessSubjectCode()
    {
        return businessSubjectCode;
    }

    public void setBusinessSubjectCode(java.lang.String businessSubjectCode)
    {
        this.businessSubjectCode = businessSubjectCode;
    }
    public java.lang.String getRelatedPromotionCode()
    {
        return relatedPromotionCode;
    }

    public void setRelatedPromotionCode(java.lang.String relatedPromotionCode)
    {
        this.relatedPromotionCode = relatedPromotionCode;
    }
    public java.lang.String getXsyhCode()
    {
        return xsyhCode;
    }

    public void setXsyhCode(java.lang.String xsyhCode)
    {
        this.xsyhCode = xsyhCode;
    }
    public java.lang.String getAdditional1()
    {
        return additional1;
    }

    public void setAdditional1(java.lang.String additional1)
    {
        this.additional1 = additional1;
    }
    public java.lang.String getAdditional2()
    {
        return additional2;
    }

    public void setAdditional2(java.lang.String additional2)
    {
        this.additional2 = additional2;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt)
    {
        this.createdAt = createdAt;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt)
    {
        this.updatedAt = updatedAt;
    }
    public java.lang.String getBelongToPartyCode()
    {
        return belongToPartyCode;
    }

    public void setBelongToPartyCode(java.lang.String belongToPartyCode)
    {
        this.belongToPartyCode = belongToPartyCode;
    }
    public java.lang.String getBelongToPartyType()
    {
        return belongToPartyType;
    }

    public void setBelongToPartyType(java.lang.String belongToPartyType)
    {
        this.belongToPartyType = belongToPartyType;
    }
    public java.lang.String getUpdatePartyType()
    {
        return updatePartyType;
    }

    public void setUpdatePartyType(java.lang.String updatePartyType)
    {
        this.updatePartyType = updatePartyType;
    }
    public java.lang.String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(java.lang.String updateBy)
    {
        this.updateBy = updateBy;
    }
    public boolean getIsGift()
    {
        return isGift;
    }

    public void setIsGift(boolean isGift)
    {
        this.isGift = isGift;
    }
    public int getGiftTimes()
    {
        return giftTimes;
    }

    public void setGiftTimes(int giftTimes)
    {
        this.giftTimes = giftTimes;
    }

}
