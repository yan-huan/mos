package com.myb.mos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.ShopProcess;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.dao.ShopProcessDao;
import com.myb.mos.service.ShopProcessService;
import com.myb.framework.data.QueryCondition;


@Service("shopProcessService")
public class ShopProcessServiceImpl implements ShopProcessService{

    @Autowired
    private ShopProcessDao shopProcessDao;

    public int insert(ShopProcess shopProcess)
    {
        return shopProcessDao.insert(shopProcess);
    }
    public int update(ShopProcess shopProcess)
    {
        return shopProcessDao.update(shopProcess);
    }

    public int delete(long id)
    {
        return shopProcessDao.delete(id);
    }

    public ShopProcess searchById(long id) {
        return shopProcessDao.searchById(id);
    }
    public ShopProcess searchByShopId(long shopId) {
        return shopProcessDao.searchByShopId(shopId);
    }
    public PagedList<ShopProcess> searchByPage(QueryCondition queryCondition)
    {
        return shopProcessDao.searchByPage(queryCondition);
    }
    public List<ShopProcess> searchList(QueryParameter queryParameter)
    {
        return shopProcessDao.searchList(queryParameter);
    }
}

