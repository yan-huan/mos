package com.myb.feedback.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.myb.feedback.service.DbDataDictionaryService;
import com.myb.feedback.service.DbProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.HtmlUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.myb.commons.utils.ImgCompress;
import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.entity.pojo.feedback.DbDataDictionaryMapping;
import com.myb.entity.pojo.feedback.DbProblem;
import com.myb.entity.pojo.feedback.DbUser;
import com.myb.feedback.base.Cons;
import com.myb.framework.data.QueryParameter;

@Controller
@RequestMapping("/wos/problem")
public class FrontProblemController {
	@Autowired
	private DbDataDictionaryService dbDataDictionaryService;
	@Autowired
	private DbProblemService dbProblemService;
	
	@RequestMapping("/erweima.jhtml")
	public String erweima() {
		return Cons.FRONT + "/problem/erweima";
	}
	
	@RequestMapping("/detail.jhtml")
	public String detail(Integer id, Model model) {
		DbProblem problem = dbProblemService.searchById(id);
		model.addAttribute("entity", problem);
		String imgName = problem.getImgUrl();
		if(imgName != null && !"".equals(imgName)) {
			String[] imgNames = imgName.split(",");
			model.addAttribute("imgNames", imgNames);
		}
		
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq(DbDataDictionaryMapping.Type, 6);
		List<DbDataDictionary> dbDataDictionaryList = dbDataDictionaryService.searchList(queryParameter);
		if(dbDataDictionaryList != null && dbDataDictionaryList.size() > 0) {
			Map<String, String> dbDataDictionaryMap = Maps.newHashMap();
			for (DbDataDictionary dbDataDictionary : dbDataDictionaryList) {
				dbDataDictionaryMap.put(dbDataDictionary.getCode(), dbDataDictionary.getName());
			}
			model.addAttribute("dbDataDictionaryMap", dbDataDictionaryMap);
		}
		return Cons.FRONT + "/problem/detail";
	}
	
	@RequestMapping("/addUI.jhtml")
	public String addUI(Model model) {
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("1", 1);
		List<DbDataDictionary> dbDataDictionarys = dbDataDictionaryService.searchList(queryParameter);
		if(dbDataDictionarys != null && dbDataDictionarys.size() > 0) {
			Map<Integer, List<DbDataDictionary>> mapTemp = Maps.newHashMap();
			for (DbDataDictionary dbDataDictionary : dbDataDictionarys) {
				Integer type = dbDataDictionary.getType();
				List<DbDataDictionary> dbDataDictionaryTemps = mapTemp.get(type);
				if(dbDataDictionaryTemps == null) {
					dbDataDictionaryTemps = Lists.newArrayList();
				}
				dbDataDictionaryTemps.add(dbDataDictionary);
				mapTemp.put(type, dbDataDictionaryTemps);
			}
			
			List<DbDataDictionary> bugTypes = mapTemp.get(1);
			model.addAttribute("bugTypes", bugTypes);
			
			List<DbDataDictionary> systemVersions = mapTemp.get(2);
			model.addAttribute("systemVersions", systemVersions);
			
			List<DbDataDictionary> roles = mapTemp.get(3);
			model.addAttribute("roles", roles);
			
			List<DbDataDictionary> appVersions = mapTemp.get(4);
			model.addAttribute("appVersions", appVersions);
			
			List<DbDataDictionary> departments = mapTemp.get(5);
			model.addAttribute("departments", departments);
			
			List<DbDataDictionary> problemStatus = mapTemp.get(6);
			model.addAttribute("problemStatus", problemStatus);
			
			List<DbDataDictionary> isoAuths = mapTemp.get(7);
			model.addAttribute("isoAuths", isoAuths);
			
			List<DbDataDictionary> rates = mapTemp.get(8);
			model.addAttribute("rates", rates);
			
		}
		return Cons.FRONT + "/problem/addUI";
	}
	
	@RequestMapping("/add.jhtml")
	public String uploadVedio(@RequestParam(required = false)MultipartFile vedioFile,  @RequestParam(required = false)MultipartFile[] imgFiles, DbProblem problem, HttpServletRequest request, Model mode, RedirectAttributes attr) {
		if(vedioFile.getSize() != 0 && vedioFile.getOriginalFilename() != null && !"".equals(vedioFile.getOriginalFilename())) {
			problem.setDescripe(HtmlUtils.htmlEscape(problem.getDescripe()));
			QueryParameter queryParameterV = new QueryParameter();
			queryParameterV.eq(DbDataDictionaryMapping.Code, Cons.VEDIO_EXTS);
			List<DbDataDictionary> vedioExts = dbDataDictionaryService.searchList(queryParameterV);
			if(!checkFileExt(vedioFile, vedioExts.get(0).getName().split(","))){
				attr.addFlashAttribute("uploadMessage", "1");
				attr.addFlashAttribute("entity", problem);
				return "redirect:/wos/problem/addUI.jhtml";
			}
		}
		
		if(imgFiles != null && imgFiles.length != 0) {
			for (MultipartFile imgFile : imgFiles) {
				if(imgFile.getSize() != 0 && imgFile.getOriginalFilename() != null && !"".equals(imgFile.getOriginalFilename())) {
					QueryParameter queryParameterI = new QueryParameter();
					queryParameterI.eq(DbDataDictionaryMapping.Code, Cons.IMG_EXTS);
					List<DbDataDictionary> imgExts = dbDataDictionaryService.searchList(queryParameterI);
					if(!checkFileExt(imgFile, imgExts.get(0).getName().split(","))) {
						attr.addFlashAttribute("uploadMessage", "2");
						attr.addFlashAttribute("entity", problem);
						return "redirect:/wos/problem/addUI.jhtml";
					}
				}
			}
		}
		
		
		
		DbUser user = (DbUser) request.getSession().getAttribute(Cons.USER);
		problem.setCreateBy(user.getId());
		problem.setCreateByUname(user.getUname());
		
		Timestamp ts = new Timestamp(new Date().getTime());
		problem.setAddTime(ts);
		problem.setStatus(Cons.STATUS_UNPROCESS);
		
		int id = dbProblemService.insert(problem);
		
		if(vedioFile.getSize() != 0 && vedioFile.getOriginalFilename() != null && !"".equals(vedioFile.getOriginalFilename())) {
			uploadFileAndUpdateProblem(request, id, "vedio", vedioFile);
		}
		
		if(imgFiles != null && imgFiles.length != 0) {
			uploadFileAndUpdateProblem(request, id, "img", imgFiles);
		}
		return "redirect:/wos/index.jhtml";
	}
	
	private boolean checkFileExt(MultipartFile file, String[] exts) {
		String fileNameExt = getExtName(file);
		if(fileNameExt == null || "".equals(fileNameExt)) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < exts.length; i++) {
			if(exts[i].equalsIgnoreCase(fileNameExt)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	private void uploadFileAndUpdateProblem(HttpServletRequest request, int id, String dir, MultipartFile... files) {
		if(files != null && files.length > 0) {
			StringBuilder fileName = new StringBuilder();
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				if(file != null && file.getSize() > 0 && file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())) {
					String path = request.getSession().getServletContext().getRealPath("uploads/" + dir); 
					String fileNameExt = getExtName(file);
//					if(fileNameExt == null || "".equals(fileNameExt)) {
//						fileNameExt = "mp4";
//					}
					String fileNameTemp = id + "-" + (i+1) + "." + fileNameExt;
					File targetFile = new File(path, fileNameTemp);
					try {
						file.transferTo(targetFile);
						//图片等比例压缩
						ImgCompress imgCom = new ImgCompress(targetFile);
						imgCom.resizeFix(400, 800, targetFile.getAbsolutePath());
						fileName.append(fileNameTemp).append(",");
					} catch (Exception e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			}
			if(fileName.length() > 0) {
				fileName.deleteCharAt(fileName.length() - 1);
			}
			DbProblem pnew = dbProblemService.searchById(id);
			
			if(fileName.length() > 0) {
				if("img".equalsIgnoreCase(dir)) {
					pnew.setImgUrl(fileName.toString());
				}else if("vedio".equalsIgnoreCase(dir)) {
					pnew.setVideoUrl(fileName.toString());
				}
				dbProblemService.update(pnew);
			}
		}
	}

	private String getExtName(MultipartFile file) {
		String[] fileNameArr = file.getOriginalFilename().split("\\.");
		if(fileNameArr.length == 1) {
			return "";
		}
		String fileNameExt = fileNameArr[fileNameArr.length - 1];
		return fileNameExt;
	}
	
}
