package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.EmpRole;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface EmpRoleService {


    public int insert(EmpRole empRole);

    public int update(EmpRole empRole);

    public int delete(int id);

    public EmpRole searchById(int id);

    public PagedList<EmpRole> searchByPage(QueryCondition queryCondition);

    public List<EmpRole> searchList(QueryParameter queryParameter);
}

