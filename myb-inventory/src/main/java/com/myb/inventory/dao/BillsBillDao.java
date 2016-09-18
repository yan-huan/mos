package com.myb.inventory.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.inventory.BillsBill;
import com.myb.entity.pojo.inventory.BillsBillMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("billsBillDao")
public class BillsBillDao extends MySqlCommandBase
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
        return "bills_bill";
    }


    public int insert(BillsBill billsBill)
    {
        String sql="INSERT INTO "+getTableName()+" (id,parent_code,related_order_code,code,discount_able_amount,fixed_amount,amount,currency_code,bill_meta_type,business_subject,payee_party_type,payee_party_code,payee_account_code,payer_party_type,payer_party_code,accept_date,pay_date,balancing_date,create_by,create_party_type,comments,cashier_party_type,cashier_party_code,cashier_name_r,has_child_bill,signature,addition1,addition2,addition3,addition4,addition5,status,created_at,updated_at,belong_to_party_type,belong_to_party_code,update_by,update_party_type,subject_type)VALUES(@{id},@{parent_code},@{related_order_code},@{code},@{discount_able_amount},@{fixed_amount},@{amount},@{currency_code},@{bill_meta_type},@{business_subject},@{payee_party_type},@{payee_party_code},@{payee_account_code},@{payer_party_type},@{payer_party_code},@{accept_date},@{pay_date},@{balancing_date},@{create_by},@{create_party_type},@{comments},@{cashier_party_type},@{cashier_party_code},@{cashier_name_r},@{has_child_bill},@{signature},@{addition1},@{addition2},@{addition3},@{addition4},@{addition5},@{status},@{created_at},@{updated_at},@{belong_to_party_type},@{belong_to_party_code},@{update_by},@{update_party_type},@{subject_type})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(BillsBillMapping.Id, billsBill.getId());
        sqlParameter.add(BillsBillMapping.ParentCode, billsBill.getParentCode());
        sqlParameter.add(BillsBillMapping.RelatedOrderCode, billsBill.getRelatedOrderCode());
        sqlParameter.add(BillsBillMapping.Code, billsBill.getCode());
        sqlParameter.add(BillsBillMapping.DiscountAbleAmount, billsBill.getDiscountAbleAmount());
        sqlParameter.add(BillsBillMapping.FixedAmount, billsBill.getFixedAmount());
        sqlParameter.add(BillsBillMapping.Amount, billsBill.getAmount());
        sqlParameter.add(BillsBillMapping.CurrencyCode, billsBill.getCurrencyCode());
        sqlParameter.add(BillsBillMapping.BillMetaType, billsBill.getBillMetaType());
        sqlParameter.add(BillsBillMapping.BusinessSubject, billsBill.getBusinessSubject());
        sqlParameter.add(BillsBillMapping.PayeePartyType, billsBill.getPayeePartyType());
        sqlParameter.add(BillsBillMapping.PayeePartyCode, billsBill.getPayeePartyCode());
        sqlParameter.add(BillsBillMapping.PayeeAccountCode, billsBill.getPayeeAccountCode());
        sqlParameter.add(BillsBillMapping.PayerPartyType, billsBill.getPayerPartyType());
        sqlParameter.add(BillsBillMapping.PayerPartyCode, billsBill.getPayerPartyCode());
        sqlParameter.add(BillsBillMapping.AcceptDate, billsBill.getAcceptDate());
        sqlParameter.add(BillsBillMapping.PayDate, billsBill.getPayDate());
        sqlParameter.add(BillsBillMapping.BalancingDate, billsBill.getBalancingDate());
        sqlParameter.add(BillsBillMapping.CreateBy, billsBill.getCreateBy());
        sqlParameter.add(BillsBillMapping.CreatePartyType, billsBill.getCreatePartyType());
        sqlParameter.add(BillsBillMapping.Comments, billsBill.getComments());
        sqlParameter.add(BillsBillMapping.CashierPartyType, billsBill.getCashierPartyType());
        sqlParameter.add(BillsBillMapping.CashierPartyCode, billsBill.getCashierPartyCode());
        sqlParameter.add(BillsBillMapping.CashierNameR, billsBill.getCashierNameR());
        sqlParameter.add(BillsBillMapping.HasChildBill, billsBill.getHasChildBill());
        sqlParameter.add(BillsBillMapping.Signature, billsBill.getSignature());
        sqlParameter.add(BillsBillMapping.Addition1, billsBill.getAddition1());
        sqlParameter.add(BillsBillMapping.Addition2, billsBill.getAddition2());
        sqlParameter.add(BillsBillMapping.Addition3, billsBill.getAddition3());
        sqlParameter.add(BillsBillMapping.Addition4, billsBill.getAddition4());
        sqlParameter.add(BillsBillMapping.Addition5, billsBill.getAddition5());
        sqlParameter.add(BillsBillMapping.Status, billsBill.getStatus());
        sqlParameter.add(BillsBillMapping.CreatedAt, billsBill.getCreatedAt());
        sqlParameter.add(BillsBillMapping.UpdatedAt, billsBill.getUpdatedAt());
        sqlParameter.add(BillsBillMapping.BelongToPartyType, billsBill.getBelongToPartyType());
        sqlParameter.add(BillsBillMapping.BelongToPartyCode, billsBill.getBelongToPartyCode());
        sqlParameter.add(BillsBillMapping.UpdateBy, billsBill.getUpdateBy());
        sqlParameter.add(BillsBillMapping.UpdatePartyType, billsBill.getUpdatePartyType());
        sqlParameter.add(BillsBillMapping.SubjectType, billsBill.getSubjectType());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(BillsBill billsBill)
    {
        String sql="UPDATE "+getTableName()+" set parent_code=@{parent_code},related_order_code=@{related_order_code},code=@{code},discount_able_amount=@{discount_able_amount},fixed_amount=@{fixed_amount},amount=@{amount},currency_code=@{currency_code},bill_meta_type=@{bill_meta_type},business_subject=@{business_subject},payee_party_type=@{payee_party_type},payee_party_code=@{payee_party_code},payee_account_code=@{payee_account_code},payer_party_type=@{payer_party_type},payer_party_code=@{payer_party_code},accept_date=@{accept_date},pay_date=@{pay_date},balancing_date=@{balancing_date},create_by=@{create_by},create_party_type=@{create_party_type},comments=@{comments},cashier_party_type=@{cashier_party_type},cashier_party_code=@{cashier_party_code},cashier_name_r=@{cashier_name_r},has_child_bill=@{has_child_bill},signature=@{signature},addition1=@{addition1},addition2=@{addition2},addition3=@{addition3},addition4=@{addition4},addition5=@{addition5},status=@{status},created_at=@{created_at},updated_at=@{updated_at},belong_to_party_type=@{belong_to_party_type},belong_to_party_code=@{belong_to_party_code},update_by=@{update_by},update_party_type=@{update_party_type},subject_type=@{subject_type} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(BillsBillMapping.Id, billsBill.getId());
        sqlParameter.add(BillsBillMapping.ParentCode, billsBill.getParentCode());
        sqlParameter.add(BillsBillMapping.RelatedOrderCode, billsBill.getRelatedOrderCode());
        sqlParameter.add(BillsBillMapping.Code, billsBill.getCode());
        sqlParameter.add(BillsBillMapping.DiscountAbleAmount, billsBill.getDiscountAbleAmount());
        sqlParameter.add(BillsBillMapping.FixedAmount, billsBill.getFixedAmount());
        sqlParameter.add(BillsBillMapping.Amount, billsBill.getAmount());
        sqlParameter.add(BillsBillMapping.CurrencyCode, billsBill.getCurrencyCode());
        sqlParameter.add(BillsBillMapping.BillMetaType, billsBill.getBillMetaType());
        sqlParameter.add(BillsBillMapping.BusinessSubject, billsBill.getBusinessSubject());
        sqlParameter.add(BillsBillMapping.PayeePartyType, billsBill.getPayeePartyType());
        sqlParameter.add(BillsBillMapping.PayeePartyCode, billsBill.getPayeePartyCode());
        sqlParameter.add(BillsBillMapping.PayeeAccountCode, billsBill.getPayeeAccountCode());
        sqlParameter.add(BillsBillMapping.PayerPartyType, billsBill.getPayerPartyType());
        sqlParameter.add(BillsBillMapping.PayerPartyCode, billsBill.getPayerPartyCode());
        sqlParameter.add(BillsBillMapping.AcceptDate, billsBill.getAcceptDate());
        sqlParameter.add(BillsBillMapping.PayDate, billsBill.getPayDate());
        sqlParameter.add(BillsBillMapping.BalancingDate, billsBill.getBalancingDate());
        sqlParameter.add(BillsBillMapping.CreateBy, billsBill.getCreateBy());
        sqlParameter.add(BillsBillMapping.CreatePartyType, billsBill.getCreatePartyType());
        sqlParameter.add(BillsBillMapping.Comments, billsBill.getComments());
        sqlParameter.add(BillsBillMapping.CashierPartyType, billsBill.getCashierPartyType());
        sqlParameter.add(BillsBillMapping.CashierPartyCode, billsBill.getCashierPartyCode());
        sqlParameter.add(BillsBillMapping.CashierNameR, billsBill.getCashierNameR());
        sqlParameter.add(BillsBillMapping.HasChildBill, billsBill.getHasChildBill());
        sqlParameter.add(BillsBillMapping.Signature, billsBill.getSignature());
        sqlParameter.add(BillsBillMapping.Addition1, billsBill.getAddition1());
        sqlParameter.add(BillsBillMapping.Addition2, billsBill.getAddition2());
        sqlParameter.add(BillsBillMapping.Addition3, billsBill.getAddition3());
        sqlParameter.add(BillsBillMapping.Addition4, billsBill.getAddition4());
        sqlParameter.add(BillsBillMapping.Addition5, billsBill.getAddition5());
        sqlParameter.add(BillsBillMapping.Status, billsBill.getStatus());
        sqlParameter.add(BillsBillMapping.CreatedAt, billsBill.getCreatedAt());
        sqlParameter.add(BillsBillMapping.UpdatedAt, billsBill.getUpdatedAt());
        sqlParameter.add(BillsBillMapping.BelongToPartyType, billsBill.getBelongToPartyType());
        sqlParameter.add(BillsBillMapping.BelongToPartyCode, billsBill.getBelongToPartyCode());
        sqlParameter.add(BillsBillMapping.UpdateBy, billsBill.getUpdateBy());
        sqlParameter.add(BillsBillMapping.UpdatePartyType, billsBill.getUpdatePartyType());
        sqlParameter.add(BillsBillMapping.SubjectType, billsBill.getSubjectType());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(BillsBillMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public BillsBill searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(BillsBillMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, BillsBill.class);
    }
    public PagedList<BillsBill> searchByPage(QueryCondition queryCondition) {
        PagedList<BillsBill> pagedList=this.searchByPage(queryCondition, BillsBill.class);
        return pagedList;
    }
    public List<BillsBill> searchList(QueryParameter queryParameter) {
                List<BillsBill> list=this.searchList(queryParameter, BillsBill.class);
                    return list;
    }
}
