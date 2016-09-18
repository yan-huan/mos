package com.myb.mos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.ShopProcess;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;

@Service
public interface ShopProcessService {


    public int insert(ShopProcess shopProcess);

    public int update(ShopProcess shopProcess);

    public int delete(long id);

    public ShopProcess searchById(long id);
    
    public ShopProcess searchByShopId(long shopId);

    public PagedList<ShopProcess> searchByPage(QueryCondition queryCondition);

    public List<ShopProcess> searchList(QueryParameter queryParameter);
}

