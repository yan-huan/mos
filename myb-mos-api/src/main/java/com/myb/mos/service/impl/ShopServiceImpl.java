package com.myb.mos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.FreshShop;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.dao.FreshShopDao;
import com.myb.mos.service.ShopService;

@Service("shopService")
public class ShopServiceImpl implements ShopService{

    @Autowired
    private FreshShopDao freshShopDao;

    public Long insert(FreshShop freshShop)
    {
        return freshShopDao.insert(freshShop);
    }
    public int update(FreshShop freshShop)
    {
        return freshShopDao.update(freshShop);
    }

    public int delete(long id)
    {
        return freshShopDao.delete(id);
    }

    public FreshShop searchById(long id) {
        return freshShopDao.searchById(id);
    }
    public PagedList<FreshShop> searchByPage(QueryCondition queryCondition)
    {
        return freshShopDao.searchByPage(queryCondition);
    }
    public List<FreshShop> searchList(QueryParameter queryParameter)
    {
        return freshShopDao.searchList(queryParameter);
    }
    public FreshShop searchByShopName(String shopName) {
        return freshShopDao.searchByShopName(shopName);
    }
}

