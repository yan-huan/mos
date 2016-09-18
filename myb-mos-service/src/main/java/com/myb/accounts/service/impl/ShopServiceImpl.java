package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.ShopDao;
import com.myb.accounts.service.ShopService;
import com.myb.entity.pojo.mos.Shop;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("shopService")
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopDao shopDao;

    public int insert(Shop shop)
    {
        return shopDao.insert(shop);
    }
    public int update(Shop shop)
    {
        return shopDao.update(shop);
    }

    public int delete(int shopId)
    {
        return shopDao.delete(shopId);
    }

    public Shop searchByShopId(int shopId) {
        return shopDao.searchByShopId(shopId);
    }
    public PagedList<Shop> searchByPage(QueryCondition queryCondition)
    {
        return shopDao.searchByPage(queryCondition);
    }
    public List<Shop> searchList(QueryParameter queryParameter)
    {
        return shopDao.searchList(queryParameter);
    }
}

