package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.ContractDao;
import com.myb.accounts.service.ContractService;
import com.myb.entity.pojo.mos.Contract;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("contractService")
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractDao contractDao;

    public int insert(Contract contract)
    {
        return contractDao.insert(contract);
    }
    public int update(Contract contract)
    {
        return contractDao.update(contract);
    }

    public int delete(int contractId)
    {
        return contractDao.delete(contractId);
    }

    public Contract searchByContractId(int contractId) {
        return contractDao.searchByContractId(contractId);
    }
    public PagedList<Contract> searchByPage(QueryCondition queryCondition)
    {
        return contractDao.searchByPage(queryCondition);
    }
    public List<Contract> searchList(QueryParameter queryParameter)
    {
        return contractDao.searchList(queryParameter);
    }
}

