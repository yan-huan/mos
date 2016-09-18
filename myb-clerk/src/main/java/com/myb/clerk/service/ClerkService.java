package com.myb.clerk.service;

import com.myb.commons.dto.DataTransferObject;
import com.myb.entity.pojo.clerk.model.ClerkModel;
import com.myb.entity.pojo.clerk.model.ClerkToBossModel;

public interface ClerkService {
	
	/**
	 * 注册账号
	 * @author hailin.liu 2016年5月26日 下午9:06:04 <br/>
	 * @param clerk
	 * @return
	 */
	public DataTransferObject<String> registBeauticianForMOS(ClerkModel clerk);
	
	/**
	 * 员工变成老板
	 * @author hailin.liu 2016年5月27日 上午9:50:11 <br/>
	 * @param clerkToBossModel
	 * @return
	 */
	public DataTransferObject<String> addBossForCompanyForMOS(ClerkToBossModel clerkToBossModel);
	
}
