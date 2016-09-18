package com.myb.mos.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myb.framework.web.models.JsonModel;
import com.myb.framework.web.models.JsonModel.JsonModelStatus;
import com.myb.mos.utils.AliyunOSSUtil;

@Controller
@RequestMapping("/file")
public class SavePicFileController {
		@ResponseBody
	    @RequestMapping(value="/picSave",method={RequestMethod.POST,RequestMethod.GET})
	    public JsonModel fileUpload(InputStream inputStream,String fileName) throws IOException {
			JsonModel jsonModel=new JsonModel();
	    	if (inputStream.available() == 0) {
	    		jsonModel.setCode("-1");
	    		jsonModel.setStatus(JsonModelStatus.FAIL);
	    		jsonModel.setMessage("size 为0");
	    		return jsonModel;
	    	}
	    	if (inputStream.available() > 10485760){
	    		jsonModel.setCode("-1");
	    		jsonModel.setStatus(JsonModelStatus.FAIL);
	    		jsonModel.setMessage("size 大于10M");
	    		return jsonModel;
	    	}
	    	String filePath = "visitPic/"+fileName;
	    	String isOk = AliyunOSSUtil.save(filePath,inputStream);   
	    	if (!isOk.equals("0")) {
	    		jsonModel.setCode("100000");
	    		jsonModel.setStatus(JsonModelStatus.SUCCESS);
	    		jsonModel.setData("filePath");
	    		return jsonModel;
	    	}
	    	return jsonModel;
	    }

}
