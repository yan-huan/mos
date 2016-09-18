package com.myb.web.util;

import java.util.Map;

import com.google.common.collect.Maps;
import com.myb.commons.cons.CodeConst;
import com.myb.commons.dto.DataTransferObject;
import com.myb.commons.dto.ResultDto;

public class DtoUtil {
	
	public static ResultDto convert(DataTransferObject<? extends Object> dto) {
		ResultDto rd = new ResultDto();
		
		Map<String, Object> head = Maps.newHashMap();
		Map<String, Object> body = Maps.newHashMap();
		head.put("errCode", dto.getCode());
		rd.setHead(head);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			rd.setBody(dto.getData());
		} else {
			body.put("errMsg", dto.getMsg());
			rd.setBody(body);
		}
		return rd;
	}
	
}
