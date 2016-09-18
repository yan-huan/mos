package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AddressAreaDefService {


    public int insert(AddressAreaDef addressAreaDef);

    public int update(AddressAreaDef addressAreaDef);

    public int delete(int id);

    public AddressAreaDef searchById(int id);

    public PagedList<AddressAreaDef> searchByPage(QueryCondition queryCondition);

    public List<AddressAreaDef> searchList(QueryParameter queryParameter);
}

