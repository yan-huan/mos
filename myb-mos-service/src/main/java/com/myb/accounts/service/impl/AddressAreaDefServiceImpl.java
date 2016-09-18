package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AddressAreaDefDao;
import com.myb.accounts.service.AddressAreaDefService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("addressAreaDefService")
public class AddressAreaDefServiceImpl implements AddressAreaDefService{

    @Autowired
    private AddressAreaDefDao addressAreaDefDao;

    public int insert(AddressAreaDef addressAreaDef)
    {
        return addressAreaDefDao.insert(addressAreaDef);
    }
    public int update(AddressAreaDef addressAreaDef)
    {
        return addressAreaDefDao.update(addressAreaDef);
    }

    public int delete(int id)
    {
        return addressAreaDefDao.delete(id);
    }

    public AddressAreaDef searchById(int id) {
        return addressAreaDefDao.searchById(id);
    }
    public PagedList<AddressAreaDef> searchByPage(QueryCondition queryCondition)
    {
        return addressAreaDefDao.searchByPage(queryCondition);
    }
    public List<AddressAreaDef> searchList(QueryParameter queryParameter)
    {
        return addressAreaDefDao.searchList(queryParameter);
    }
}

