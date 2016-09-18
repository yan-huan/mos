package com.myb.mos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.ShopContact;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.dao.ShopContactDao;
import com.myb.mos.service.ShopContactService;
import com.myb.framework.data.QueryCondition;


@Service("shopContactService")
public class ShopContactServiceImpl implements ShopContactService{

    @Autowired
    private ShopContactDao shopContactDao;

    public int insert(ShopContact shopContact)
    {
        return shopContactDao.insert(shopContact);
    }
    public int update(ShopContact shopContact)
    {
        return shopContactDao.update(shopContact);
    }

    public int delete(long id)
    {
        return shopContactDao.delete(id);
    }

    public ShopContact searchById(long id) {
        return shopContactDao.searchById(id);
    }
    public PagedList<ShopContact> searchByPage(QueryCondition queryCondition)
    {
        return shopContactDao.searchByPage(queryCondition);
    }
    public List<ShopContact> searchList(QueryParameter queryParameter)
    {
        return shopContactDao.searchList(queryParameter);
    }
	@Override
	public ShopContact searchByMobile(String mobile) {
		// TODO Auto-generated method stub
		  return shopContactDao.searchByMobile(mobile);
	}
}

