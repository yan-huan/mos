package com.myb.accounts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AreaDao;
import com.myb.accounts.service.BaseService;

/**
 * 公共实现
 * @author yanhuan
 *
 */
@Service
public class BaseServiceImpl<T> implements BaseService{

	@Autowired
    private AreaDao areaDao;
	
	@Override
	public Object searchBy(Object arg, int type) {
		
		
		return null;
	}
	
	
}

