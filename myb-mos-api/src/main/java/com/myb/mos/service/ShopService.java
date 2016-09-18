package com.myb.mos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.FreshShop;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
@Service
public interface ShopService {


    public Long insert(FreshShop freshShop);

    public int update(FreshShop freshShop);

    public int delete(long id);

    public FreshShop searchById(long id);
    
    public PagedList<FreshShop> searchByPage(QueryCondition queryCondition);

    public List<FreshShop> searchList(QueryParameter queryParameter);
    
    public FreshShop searchByShopName(String shopName);
}

