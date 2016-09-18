package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.accounts.AccountsAccount;
import com.myb.entity.pojo.accounts.AccountsAccountMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("accountsAccountDao")
public class AccountsAccountDao extends MySqlCommandBase
{

    @Resource(name = "datacommand_write")
    private DataCommand dataCommandWrite;
    
    @Resource(name = "datacommand_read")
    private DataCommand dataCommandRead;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName()
    {
        return "accounts_account";
    }


    public int insert(AccountsAccount accountsAccount)
    {
        String sql="INSERT INTO "+getTableName()+" (id,code,currency_code,belong_to_party_type,belong_to_party_code,create_by,create_party_type,update_by,update_party_type,comments,status,obj_name,parent_code,account_type,amount,expire_date,is_default,account_meta_type,created_at,updated_at)VALUES(@{id},@{code},@{currency_code},@{belong_to_party_type},@{belong_to_party_code},@{create_by},@{create_party_type},@{update_by},@{update_party_type},@{comments},@{status},@{obj_name},@{parent_code},@{account_type},@{amount},@{expire_date},@{is_default},@{account_meta_type},@{created_at},@{updated_at})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AccountsAccountMapping.Id, accountsAccount.getId());
        sqlParameter.add(AccountsAccountMapping.Code, accountsAccount.getCode());
        sqlParameter.add(AccountsAccountMapping.CurrencyCode, accountsAccount.getCurrencyCode());
        sqlParameter.add(AccountsAccountMapping.BelongToPartyType, accountsAccount.getBelongToPartyType());
        sqlParameter.add(AccountsAccountMapping.BelongToPartyCode, accountsAccount.getBelongToPartyCode());
        sqlParameter.add(AccountsAccountMapping.CreateBy, accountsAccount.getCreateBy());
        sqlParameter.add(AccountsAccountMapping.CreatePartyType, accountsAccount.getCreatePartyType());
        sqlParameter.add(AccountsAccountMapping.UpdateBy, accountsAccount.getUpdateBy());
        sqlParameter.add(AccountsAccountMapping.UpdatePartyType, accountsAccount.getUpdatePartyType());
        sqlParameter.add(AccountsAccountMapping.Comments, accountsAccount.getComments());
        sqlParameter.add(AccountsAccountMapping.Status, accountsAccount.getStatus());
        sqlParameter.add(AccountsAccountMapping.ObjName, accountsAccount.getObjName());
        sqlParameter.add(AccountsAccountMapping.ParentCode, accountsAccount.getParentCode());
        sqlParameter.add(AccountsAccountMapping.AccountType, accountsAccount.getAccountType());
        sqlParameter.add(AccountsAccountMapping.Amount, accountsAccount.getAmount());
        sqlParameter.add(AccountsAccountMapping.ExpireDate, accountsAccount.getExpireDate());
        sqlParameter.add(AccountsAccountMapping.IsDefault, accountsAccount.getIsDefault());
        sqlParameter.add(AccountsAccountMapping.AccountMetaType, accountsAccount.getAccountMetaType());
        sqlParameter.add(AccountsAccountMapping.CreatedAt, accountsAccount.getCreatedAt());
        sqlParameter.add(AccountsAccountMapping.UpdatedAt, accountsAccount.getUpdatedAt());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(AccountsAccount accountsAccount)
    {
        String sql="UPDATE "+getTableName()+" set code=@{code},currency_code=@{currency_code},belong_to_party_type=@{belong_to_party_type},belong_to_party_code=@{belong_to_party_code},create_by=@{create_by},create_party_type=@{create_party_type},update_by=@{update_by},update_party_type=@{update_party_type},comments=@{comments},status=@{status},obj_name=@{obj_name},parent_code=@{parent_code},account_type=@{account_type},amount=@{amount},expire_date=@{expire_date},is_default=@{is_default},account_meta_type=@{account_meta_type},created_at=@{created_at},updated_at=@{updated_at} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AccountsAccountMapping.Id, accountsAccount.getId());
        sqlParameter.add(AccountsAccountMapping.Code, accountsAccount.getCode());
        sqlParameter.add(AccountsAccountMapping.CurrencyCode, accountsAccount.getCurrencyCode());
        sqlParameter.add(AccountsAccountMapping.BelongToPartyType, accountsAccount.getBelongToPartyType());
        sqlParameter.add(AccountsAccountMapping.BelongToPartyCode, accountsAccount.getBelongToPartyCode());
        sqlParameter.add(AccountsAccountMapping.CreateBy, accountsAccount.getCreateBy());
        sqlParameter.add(AccountsAccountMapping.CreatePartyType, accountsAccount.getCreatePartyType());
        sqlParameter.add(AccountsAccountMapping.UpdateBy, accountsAccount.getUpdateBy());
        sqlParameter.add(AccountsAccountMapping.UpdatePartyType, accountsAccount.getUpdatePartyType());
        sqlParameter.add(AccountsAccountMapping.Comments, accountsAccount.getComments());
        sqlParameter.add(AccountsAccountMapping.Status, accountsAccount.getStatus());
        sqlParameter.add(AccountsAccountMapping.ObjName, accountsAccount.getObjName());
        sqlParameter.add(AccountsAccountMapping.ParentCode, accountsAccount.getParentCode());
        sqlParameter.add(AccountsAccountMapping.AccountType, accountsAccount.getAccountType());
        sqlParameter.add(AccountsAccountMapping.Amount, accountsAccount.getAmount());
        sqlParameter.add(AccountsAccountMapping.ExpireDate, accountsAccount.getExpireDate());
        sqlParameter.add(AccountsAccountMapping.IsDefault, accountsAccount.getIsDefault());
        sqlParameter.add(AccountsAccountMapping.AccountMetaType, accountsAccount.getAccountMetaType());
        sqlParameter.add(AccountsAccountMapping.CreatedAt, accountsAccount.getCreatedAt());
        sqlParameter.add(AccountsAccountMapping.UpdatedAt, accountsAccount.getUpdatedAt());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AccountsAccountMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public AccountsAccount searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(AccountsAccountMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, AccountsAccount.class);
    }
    public PagedList<AccountsAccount> searchByPage(QueryCondition queryCondition) {
        PagedList<AccountsAccount> pagedList=this.searchByPage(queryCondition, AccountsAccount.class);
        return pagedList;
    }
    public List<AccountsAccount> searchList(QueryParameter queryParameter) {
                List<AccountsAccount> list=this.searchList(queryParameter, AccountsAccount.class);
                    return list;
    }
}
