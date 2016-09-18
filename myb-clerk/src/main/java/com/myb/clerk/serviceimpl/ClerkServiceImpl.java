package com.myb.clerk.serviceimpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.myb.clerk.cons.Cons;
import com.myb.clerk.dao.ClerksBeauticianDao;
import com.myb.clerk.dao.ClerksLoginaccountDao;
import com.myb.clerk.dao.ClerksRolesDao;
import com.myb.clerk.service.ClerkService;
import com.myb.clerk.dao.ClerksClerkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.commons.cons.CodeConst;
import com.myb.commons.dto.DataTransferObject;
import com.myb.commons.exception.dto.BusinessException;
import com.myb.commons.utils.CodeUtil;
import com.myb.commons.utils.ValidateUtil;
import com.myb.entity.pojo.clerk.ClerksBeautician;
import com.myb.entity.pojo.clerk.ClerksClerk;
import com.myb.entity.pojo.clerk.ClerksClerkMapping;
import com.myb.entity.pojo.clerk.ClerksLoginaccount;
import com.myb.entity.pojo.clerk.ClerksLoginaccountMapping;
import com.myb.entity.pojo.clerk.ClerksRoles;
import com.myb.entity.pojo.clerk.ClerksRolesMapping;
import com.myb.entity.pojo.clerk.model.ClerkModel;
import com.myb.entity.pojo.clerk.model.ClerkToBossModel;
import com.myb.framework.data.QueryParameter;

@Service("clerkService")
public class ClerkServiceImpl implements ClerkService {
	@Autowired
	private ClerksLoginaccountDao clerksLoginaccountDao;
	@Autowired
	private ClerksRolesDao clerksRolesDao;
	@Autowired
	private ClerksBeauticianDao clerksBeauticianDao;
	@Autowired
	private ClerksClerkDao clerksClerkDao;

	@Override
	public DataTransferObject<String> registBeauticianForMOS(ClerkModel clerk) {
		try {
			DataTransferObject<String> dto = new DataTransferObject<String>();
			
			String mobile = clerk.getMobile();
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(ClerksLoginaccountMapping.Mobile, mobile).and().eq(ClerksLoginaccountMapping.Status, Cons.STATUS_DELETED);
			List<ClerksLoginaccount> loginAccounts = clerksLoginaccountDao.searchList(queryParameter);
			ClerksLoginaccount clerksLoginaccount = null;
			if(loginAccounts != null && loginAccounts.size() > 0) {
				clerksLoginaccount = loginAccounts.get(0);
			}
			if(clerksLoginaccount != null && !Cons.STATUS_DELETED.equals(clerksLoginaccount.getStatus())) {
				throw new BusinessException(CodeConst.CLERK_LOGIN_ACCOUNT_EXIST_ERROR, ValidateUtil.get(CodeConst.CLERK_LOGIN_ACCOUNT_EXIST_ERROR));
			}
			
			String beauticianCode = CodeUtil.generateCode(ClerksBeautician.class.getName());
			ClerksBeautician beautician = new ClerksBeautician();
			beautician.setCode(beauticianCode);
			beautician.setAge(clerk.getAge());
			beautician.setCardType(Cons.CARD_TYPE_SHENGFENZHENG);
			beautician.setCardCode(clerk.getSecurityCode());
			beautician.setObjName(clerk.getObjName());
			beautician.setSex(Cons.GENDER_NV);
			beautician.setStatus(Cons.STATUS_NORMAL);
			
			String loginAccountCode = CodeUtil.generateCode(ClerksLoginaccount.class.getName());
			String clerkCode = CodeUtil.generateCode(ClerksClerk.class.getName());
			clerksLoginaccount = new ClerksLoginaccount();
			clerksLoginaccount.setMobile(mobile);
			clerksLoginaccount.setCode(loginAccountCode);
			clerksLoginaccount.setClerkCode(clerkCode);
			clerksLoginaccount.setPassword(clerk.getPassword());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp ts = new Timestamp(sdf.parse(clerk.getExpiredDate()).getTime());
			clerksLoginaccount.setExpiredDate(ts);
			clerksLoginaccount.setStatus(clerk.getStatus());
			clerksLoginaccount.setAvatar(clerk.getAvatar());
			clerksLoginaccount.setAccountType(clerk.getAccountType());
			clerksLoginaccount.setBeauticianCode(beauticianCode);
			
			//美容师是否同时注册登录帐号和员工档案
	        ClerksClerk cc = new ClerksClerk();
	        cc.setAvatar(clerk.getAvatar()); //头像路径
	        cc.setClerkCode(clerkCode);
	        cc.setDefaultLoginAccountCode(loginAccountCode);
	        cc.setMobile(clerk.getMobile());
	        cc.setAddress(clerk.getAddress());
	        cc.setAge(clerk.getAge());
	        cc.setBirthday(new Timestamp(clerk.getBirthday().getTime()));
	        cc.setDreams(clerk.getDreams());
	        cc.setGender(Cons.GENDER_NV);
	        cc.setObjName(clerk.getObjName());
	        cc.setQq(clerk.getQq());
	        cc.setSecurityCode(clerk.getSecurityCode());
	        cc.setSeniority(clerk.getSeniority());
	        cc.setSpeciality(clerk.getSpeciality());
	        cc.setWeixin(clerk.getWeixin());
	        cc.setCode(clerkCode);
	        cc.setBeauticianCode(beauticianCode);
	        cc.setStatus(Cons.STATUS_YOULI); //前段传入，与loginaccount保持一致
	        //clerk.setTitle(Clerk.CLERK_TITLE_MEIRONGSHI);
	        
	        queryParameter = new QueryParameter();
	        queryParameter.eq(ClerksRolesMapping.ClerkCode, clerkCode);
	        List<ClerksRoles> roles = clerksRolesDao.searchList(queryParameter);
	        if(roles != null && roles.size() > 0) {
	        	for (ClerksRoles clerksRoles : roles) {
	        		clerksRolesDao.delete(clerksRoles.getId());
				}
	        }
	        
	        String[] roleNames = new String[]{Cons.CLERK_TITLE_MEIRONGSHI};
	        //新增新的角色列表
	        for (String roleCode : roleNames) {
	        	ClerksRoles clerksRoles = new ClerksRoles();
	        	clerksRoles.setClerkCode(clerkCode);
	        	clerksRoles.setRoleCode(roleCode);
	        	clerksRolesDao.insert(clerksRoles);
	        }
	        
	        clerksLoginaccountDao.insert(clerksLoginaccount);
	        clerksBeauticianDao.insert(beautician);
	        clerksClerkDao.insert(cc);
	        
	        dto.setMsg(ValidateUtil.get(dto.getCode()));
			return dto;
		} catch (ParseException e) {
			throw new BusinessException(CodeConst.SYSTEM_ERROR, ValidateUtil.get(CodeConst.SYSTEM_ERROR));
		}
	}

	@Override
	public DataTransferObject<String> addBossForCompanyForMOS(ClerkToBossModel clerkToBossModel) {
		String mobile = clerkToBossModel.getMobile();
		//String smsCode = clerk.getSmsCode();
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq(ClerksClerkMapping.Mobile, mobile).and().eq(ClerksClerkMapping.Status, Cons.STATUS_DELETED);
		List<ClerksLoginaccount> loginAccounts = clerksLoginaccountDao.searchList(queryParameter);
		if(loginAccounts == null || loginAccounts.size() == 0) {
			throw new BusinessException(CodeConst.CLERK_NULL_ERROR, ValidateUtil.get(CodeConst.CLERK_NULL_ERROR));
		}
		
		
		return null;
	}

}
