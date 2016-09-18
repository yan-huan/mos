package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Contract;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface ContractService {


    public int insert(Contract contract);

    public int update(Contract contract);

    public int delete(int contractId);

    public Contract searchByContractId(int contractId);

    public PagedList<Contract> searchByPage(QueryCondition queryCondition);

    public List<Contract> searchList(QueryParameter queryParameter);
}

