package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class BillsBill extends EntityBase{

    @DataMapping(BillsBillMapping.Id)
    private int id;//
    @DataMapping(BillsBillMapping.ParentCode)
    private java.lang.String parentCode;//账单Code。一个账单分成多个子账单支付时，需要关联父子账单关系。
    @DataMapping(BillsBillMapping.RelatedOrderCode)
    private java.lang.String relatedOrderCode;//关联的业务订单号
    @DataMapping(BillsBillMapping.Code)
    private java.lang.String code;//
    @DataMapping(BillsBillMapping.DiscountAbleAmount)
    private long discountAbleAmount;//可以接受再次折扣的总额
    @DataMapping(BillsBillMapping.FixedAmount)
    private long fixedAmount;//固定要付款的金额。不适用折扣规则。
    @DataMapping(BillsBillMapping.Amount)
    private long amount;//要付款的总金额
    @DataMapping(BillsBillMapping.CurrencyCode)
    private java.lang.String currencyCode;//货币类型
    @DataMapping(BillsBillMapping.BillMetaType)
    private int billMetaType;//固定值
    @DataMapping(BillsBillMapping.BusinessSubject)
    private java.lang.String businessSubject;//业务科目
    @DataMapping(BillsBillMapping.PayeePartyType)
    private java.lang.String payeePartyType;//收款人Type
    @DataMapping(BillsBillMapping.PayeePartyCode)
    private java.lang.String payeePartyCode;//收款人code
    @DataMapping(BillsBillMapping.PayeeAccountCode)
    private java.lang.String payeeAccountCode;//收款人收款帐号
    @DataMapping(BillsBillMapping.PayerPartyType)
    private java.lang.String payerPartyType;//付款人type
    @DataMapping(BillsBillMapping.PayerPartyCode)
    private java.lang.String payerPartyCode;//付款人的code可能和实际付款的帐号所属的partyCode不一致
    @DataMapping(BillsBillMapping.AcceptDate)
    private java.sql.Timestamp acceptDate;//
    @DataMapping(BillsBillMapping.PayDate)
    private java.sql.Timestamp payDate;//
    @DataMapping(BillsBillMapping.BalancingDate)
    private java.sql.Timestamp balancingDate;//
    @DataMapping(BillsBillMapping.CreateBy)
    private java.lang.String createBy;//
    @DataMapping(BillsBillMapping.CreatePartyType)
    private java.lang.String createPartyType;//
    @DataMapping(BillsBillMapping.Comments)
    private java.lang.String comments;//
    @DataMapping(BillsBillMapping.CashierPartyType)
    private java.lang.String cashierPartyType;//记录收银员的信息
    @DataMapping(BillsBillMapping.CashierPartyCode)
    private java.lang.String cashierPartyCode;//
    @DataMapping(BillsBillMapping.CashierNameR)
    private java.lang.String cashierNameR;//
    @DataMapping(BillsBillMapping.HasChildBill)
    private boolean hasChildBill;//一旦具有子账单，则此笔账单不用支付，只需要支付子账单即可。
    @DataMapping(BillsBillMapping.Signature)
    private java.lang.String signature;//如果拥有子账单，则只需要把父账单签字即可。
    @DataMapping(BillsBillMapping.Addition1)
    private java.lang.String addition1;//
    @DataMapping(BillsBillMapping.Addition2)
    private java.lang.String addition2;//
    @DataMapping(BillsBillMapping.Addition3)
    private java.lang.String addition3;//
    @DataMapping(BillsBillMapping.Addition4)
    private java.lang.String addition4;//
    @DataMapping(BillsBillMapping.Addition5)
    private java.lang.String addition5;//
    @DataMapping(BillsBillMapping.Status)
    private java.lang.String status;//INIT--初始化；WAIT_PAY--正常使用中；PAYED--正常使用中；LOCKED--锁定；AUDITED--已审计；DELETED--逻辑删除；CANCELED--交易撤销
    @DataMapping(BillsBillMapping.CreatedAt)
    private java.sql.Timestamp createdAt;//
    @DataMapping(BillsBillMapping.UpdatedAt)
    private java.sql.Timestamp updatedAt;//
    @DataMapping(BillsBillMapping.BelongToPartyType)
    private java.lang.String belongToPartyType;//
    @DataMapping(BillsBillMapping.BelongToPartyCode)
    private java.lang.String belongToPartyCode;//
    @DataMapping(BillsBillMapping.UpdateBy)
    private java.lang.String updateBy;//
    @DataMapping(BillsBillMapping.UpdatePartyType)
    private java.lang.String updatePartyType;//
    @DataMapping(BillsBillMapping.SubjectType)
    private java.lang.String subjectType;//


    public BillsBill() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getParentCode()
    {
        return parentCode;
    }

    public void setParentCode(java.lang.String parentCode)
    {
        this.parentCode = parentCode;
    }
    public java.lang.String getRelatedOrderCode()
    {
        return relatedOrderCode;
    }

    public void setRelatedOrderCode(java.lang.String relatedOrderCode)
    {
        this.relatedOrderCode = relatedOrderCode;
    }
    public java.lang.String getCode()
    {
        return code;
    }

    public void setCode(java.lang.String code)
    {
        this.code = code;
    }
    public long getDiscountAbleAmount()
    {
        return discountAbleAmount;
    }

    public void setDiscountAbleAmount(long discountAbleAmount)
    {
        this.discountAbleAmount = discountAbleAmount;
    }
    public long getFixedAmount()
    {
        return fixedAmount;
    }

    public void setFixedAmount(long fixedAmount)
    {
        this.fixedAmount = fixedAmount;
    }
    public long getAmount()
    {
        return amount;
    }

    public void setAmount(long amount)
    {
        this.amount = amount;
    }
    public java.lang.String getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(java.lang.String currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    public int getBillMetaType()
    {
        return billMetaType;
    }

    public void setBillMetaType(int billMetaType)
    {
        this.billMetaType = billMetaType;
    }
    public java.lang.String getBusinessSubject()
    {
        return businessSubject;
    }

    public void setBusinessSubject(java.lang.String businessSubject)
    {
        this.businessSubject = businessSubject;
    }
    public java.lang.String getPayeePartyType()
    {
        return payeePartyType;
    }

    public void setPayeePartyType(java.lang.String payeePartyType)
    {
        this.payeePartyType = payeePartyType;
    }
    public java.lang.String getPayeePartyCode()
    {
        return payeePartyCode;
    }

    public void setPayeePartyCode(java.lang.String payeePartyCode)
    {
        this.payeePartyCode = payeePartyCode;
    }
    public java.lang.String getPayeeAccountCode()
    {
        return payeeAccountCode;
    }

    public void setPayeeAccountCode(java.lang.String payeeAccountCode)
    {
        this.payeeAccountCode = payeeAccountCode;
    }
    public java.lang.String getPayerPartyType()
    {
        return payerPartyType;
    }

    public void setPayerPartyType(java.lang.String payerPartyType)
    {
        this.payerPartyType = payerPartyType;
    }
    public java.lang.String getPayerPartyCode()
    {
        return payerPartyCode;
    }

    public void setPayerPartyCode(java.lang.String payerPartyCode)
    {
        this.payerPartyCode = payerPartyCode;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getAcceptDate()
    {
        return acceptDate;
    }

    public void setAcceptDate(java.sql.Timestamp acceptDate)
    {
        this.acceptDate = acceptDate;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getPayDate()
    {
        return payDate;
    }

    public void setPayDate(java.sql.Timestamp payDate)
    {
        this.payDate = payDate;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getBalancingDate()
    {
        return balancingDate;
    }

    public void setBalancingDate(java.sql.Timestamp balancingDate)
    {
        this.balancingDate = balancingDate;
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
    public java.lang.String getCashierPartyType()
    {
        return cashierPartyType;
    }

    public void setCashierPartyType(java.lang.String cashierPartyType)
    {
        this.cashierPartyType = cashierPartyType;
    }
    public java.lang.String getCashierPartyCode()
    {
        return cashierPartyCode;
    }

    public void setCashierPartyCode(java.lang.String cashierPartyCode)
    {
        this.cashierPartyCode = cashierPartyCode;
    }
    public java.lang.String getCashierNameR()
    {
        return cashierNameR;
    }

    public void setCashierNameR(java.lang.String cashierNameR)
    {
        this.cashierNameR = cashierNameR;
    }
    public boolean getHasChildBill()
    {
        return hasChildBill;
    }

    public void setHasChildBill(boolean hasChildBill)
    {
        this.hasChildBill = hasChildBill;
    }
    public java.lang.String getSignature()
    {
        return signature;
    }

    public void setSignature(java.lang.String signature)
    {
        this.signature = signature;
    }
    public java.lang.String getAddition1()
    {
        return addition1;
    }

    public void setAddition1(java.lang.String addition1)
    {
        this.addition1 = addition1;
    }
    public java.lang.String getAddition2()
    {
        return addition2;
    }

    public void setAddition2(java.lang.String addition2)
    {
        this.addition2 = addition2;
    }
    public java.lang.String getAddition3()
    {
        return addition3;
    }

    public void setAddition3(java.lang.String addition3)
    {
        this.addition3 = addition3;
    }
    public java.lang.String getAddition4()
    {
        return addition4;
    }

    public void setAddition4(java.lang.String addition4)
    {
        this.addition4 = addition4;
    }
    public java.lang.String getAddition5()
    {
        return addition5;
    }

    public void setAddition5(java.lang.String addition5)
    {
        this.addition5 = addition5;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
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
    public java.lang.String getBelongToPartyType()
    {
        return belongToPartyType;
    }

    public void setBelongToPartyType(java.lang.String belongToPartyType)
    {
        this.belongToPartyType = belongToPartyType;
    }
    public java.lang.String getBelongToPartyCode()
    {
        return belongToPartyCode;
    }

    public void setBelongToPartyCode(java.lang.String belongToPartyCode)
    {
        this.belongToPartyCode = belongToPartyCode;
    }
    public java.lang.String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(java.lang.String updateBy)
    {
        this.updateBy = updateBy;
    }
    public java.lang.String getUpdatePartyType()
    {
        return updatePartyType;
    }

    public void setUpdatePartyType(java.lang.String updatePartyType)
    {
        this.updatePartyType = updatePartyType;
    }
    public java.lang.String getSubjectType()
    {
        return subjectType;
    }

    public void setSubjectType(java.lang.String subjectType)
    {
        this.subjectType = subjectType;
    }

}
