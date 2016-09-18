package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Shop;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface ShopService {


    public int insert(Shop shop);

    public int update(Shop shop);

    public int delete(int shopId);

    public Shop searchByShopId(int shopId);

    public PagedList<Shop> searchByPage(QueryCondition queryCondition);

    public List<Shop> searchList(QueryParameter queryParameter);
    
}

