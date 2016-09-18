package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Area;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
/**
 * 公共接口
 * @author yanhuan
 *
 */
public interface BaseService<T> {

    public T searchBy(Object arg, int type);

}

