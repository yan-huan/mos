package com.myb.mos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.ShopContact;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;

@Service
public interface ShopContactService {


    public int insert(ShopContact shopContact);

    public int update(ShopContact shopContact);

    public int delete(long id);

    public ShopContact searchById(long id);
    
    public PagedList<ShopContact> searchByPage(QueryCondition queryCondition);

    public List<ShopContact> searchList(QueryParameter queryParameter);

	ShopContact searchByMobile(String mobile);
}

