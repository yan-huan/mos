package com.myb.feedback.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import com.myb.feedback.service.DbDataDictionaryService;
import com.myb.feedback.service.DbProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Maps;
import com.myb.commons.utils.ImgCompress;
import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.entity.pojo.feedback.DbDataDictionaryMapping;
import com.myb.entity.pojo.feedback.DbProblem;
import com.myb.entity.pojo.feedback.DbProblemMapping;
import com.myb.entity.pojo.feedback.DbUser;
import com.myb.feedback.base.Cons;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.util.RequestUtil;

@Controller
@RequestMapping("/manage/control/problem")
public class DbProblemController {
	@Autowired
	private DbProblemService dbProblemService;
	@Autowired
	private DbDataDictionaryService dbDataDictionaryService;

	@RequestMapping("/list.jhtml")
	public String list(HttpServletRequest request, Model model, Integer code, String status) {
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setPageSize(Cons.PAGE_SIZE);
		queryCondition.setPageIndex(RequestUtil.getIntParameter(request, "page", 1));
		SortParameter sortParameter = new SortParameter();
		sortParameter.add(DbProblemMapping.Id, SqlOrder.DESC);
		queryCondition.setSortParameter(sortParameter);

		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("1", "1");
		if (code != null) {
			queryParameter.and().eq(DbProblemMapping.Id, code);
			model.addAttribute("code", code);
		}

		if (StringUtils.isNotEmpty(status)) {
			queryParameter.and().eq(DbProblemMapping.Status, status);
			model.addAttribute("status", status);
		}

		queryCondition.setQueryParameter(queryParameter);

		PagedList<DbProblem> pagedList = dbProblemService.searchByPage(queryCondition);
		model.addAttribute("pagedList", pagedList);

		queryParameter = new QueryParameter();
		queryParameter.eq(DbDataDictionaryMapping.Type, 6);
		List<DbDataDictionary> dbDataDictionaryList = dbDataDictionaryService.searchList(queryParameter);
		model.addAttribute("dbDataDictionaryList", dbDataDictionaryList);
		if (dbDataDictionaryList != null && dbDataDictionaryList.size() > 0) {
			Map<String, String> dbDataDictionaryMap = Maps.newHashMap();
			for (DbDataDictionary dbDataDictionary : dbDataDictionaryList) {
				dbDataDictionaryMap.put(dbDataDictionary.getCode(), dbDataDictionary.getName());
			}
			model.addAttribute("dbDataDictionaryMap", dbDataDictionaryMap);
		}

		try {
			String firstPage = RequestUtil.getUrl(request, "page", "1");
			String prePage = RequestUtil.getUrl(request, "page",
					String.valueOf(RequestUtil.getIntParameter(request, "page", 1) - 1));
			String nextPage = RequestUtil.getUrl(request, "page",
					String.valueOf(RequestUtil.getIntParameter(request, "page", 1) + 1));
			String lastPage = RequestUtil.getUrl(request, "page", String.valueOf(pagedList.getTotalPage()));
			model.addAttribute("firstPage", firstPage);
			model.addAttribute("prePage", prePage);
			model.addAttribute("nextPage", nextPage);
			model.addAttribute("lastPage", lastPage);
		}
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return Cons.CONTROL + "/problem/list";
	}

	@RequestMapping("/editUI.jhtml")
	public String editUI(Integer id, Model model) {
		DbProblem dbProblem = dbProblemService.searchById(id);
		model.addAttribute("entity", dbProblem);

		String imgName = dbProblem.getImgUrl();
		if (imgName != null && !"".equals(imgName)) {
			String[] imgNames = imgName.split(",");
			// 区分回复图片和问题图片
			List<String> questionlImage = new ArrayList<String>(5);
			List<String> replyImage = new ArrayList<String>(5);
			for (int i = 0; i < imgNames.length; i++) {
				if (imgNames[i] != null && imgNames[i].contains("reply")) {
					replyImage.add(imgNames[i]);
				} else {
					questionlImage.add(imgNames[i]);
				}
			}

			if (questionlImage.size() > 0) {
				model.addAttribute("questionlImage", questionlImage);
			}
			if (replyImage.size() > 0) {
				model.addAttribute("replyImage", replyImage);
			}
		}

		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq(DbDataDictionaryMapping.Type, 6);
		List<DbDataDictionary> dbDataDictionaryList = dbDataDictionaryService.searchList(queryParameter);
		if (dbDataDictionaryList != null && dbDataDictionaryList.size() > 0) {
			Map<String, String> dbDataDictionaryMap = Maps.newHashMap();
			for (DbDataDictionary dbDataDictionary : dbDataDictionaryList) {
				dbDataDictionaryMap.put(dbDataDictionary.getCode(), dbDataDictionary.getName());
			}
			model.addAttribute("dbDataDictionaryMap", dbDataDictionaryMap);
		}
		return Cons.CONTROL + "/problem/editUI";
	}

	@RequestMapping("/processing.jhtml")
	public String processing(Integer id, RedirectAttributes attr, HttpServletRequest request) {
		DbProblem dbProblem = dbProblemService.searchById(id);
		dbProblem.setStatus(Cons.STATUS_PROCESSING);
		DbUser user = (DbUser) request.getSession().getAttribute(Cons.USER);
		dbProblem.setUpdateBy(user.getId());
		dbProblem.setUpdateByUname(user.getUname());
		Timestamp ts = new Timestamp(new Date().getTime());
		dbProblem.setModifyTime(ts);

		dbProblemService.update(dbProblem);
		attr.addAttribute("id", id);
		return "redirect:/manage/control/problem/editUI.jhtml";
	}

	@RequestMapping("/answer.jhtml")
	public String answer(Integer id, String answer, RedirectAttributes attr, HttpServletRequest request,
			@RequestParam(required = false) MultipartFile[] imgFiles) {
		DbProblem dbProblem = dbProblemService.searchById(id);
		dbProblem.setStatus(Cons.STATUS_SUCCESS);
		dbProblem.setAnswer(answer);
		Timestamp ts = new Timestamp(new Date().getTime());
		dbProblem.setModifyTime(ts);

		DbUser user = (DbUser) request.getSession().getAttribute(Cons.USER);
		dbProblem.setUpdateBy(user.getId());
		dbProblem.setUpdateByUname(user.getUname());

		dbProblemService.update(dbProblem);
		attr.addAttribute("id", id);
		attr.addFlashAttribute(Cons.MESSAGE, "成功");

		// 图片上传
		if (imgFiles != null && imgFiles.length != 0) {
			for (MultipartFile imgFile : imgFiles) {
				if (imgFile.getSize() != 0 && imgFile.getOriginalFilename() != null
						&& !"".equals(imgFile.getOriginalFilename())) {
					QueryParameter queryParameterI = new QueryParameter();
					queryParameterI.eq(DbDataDictionaryMapping.Code, Cons.IMG_EXTS);
					List<DbDataDictionary> imgExts = dbDataDictionaryService.searchList(queryParameterI);
					if (!checkFileExt(imgFile, imgExts.get(0).getName().split(","))) {
						attr.addFlashAttribute("uploadMessage", "2");
						attr.addFlashAttribute("entity", dbProblem);
						attr.addAttribute("id", id);
						return "redirect:/manage/control/problem/editUI.jhtml";
					}
				}
			}
		}

		if (imgFiles != null && imgFiles.length != 0) {
			uploadFileAndUpdateProblem(request, id, "img", imgFiles);
		}

		return "redirect:/manage/control/problem/editUI.jhtml";
	}

	private boolean checkFileExt(MultipartFile file, String[] exts) {
		String fileNameExt = getExtName(file);
		if (fileNameExt == null || "".equals(fileNameExt)) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < exts.length; i++) {
			if (exts[i].equalsIgnoreCase(fileNameExt)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	private void uploadFileAndUpdateProblem(HttpServletRequest request, int id, String dir, MultipartFile... files) {
		if (files != null && files.length > 0) {
			StringBuilder fileName = new StringBuilder();
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				if (file != null && file.getSize() > 0 && file.getOriginalFilename() != null
						&& !"".equals(file.getOriginalFilename())) {
					String path = request.getSession().getServletContext().getRealPath("uploads/" + dir);
					String fileNameExt = getExtName(file);
					String fileNameTemp = id + "-" + (i + 1) + "_reply." + fileNameExt;
					File targetFile = new File(path, fileNameTemp);
					try {
						file.transferTo(targetFile);
						//进行压缩图片
						ImgCompress imgCom = new ImgCompress(targetFile);
						imgCom.resizeFix(400, 800, targetFile.getAbsolutePath());
						fileName.append(fileNameTemp).append(",");
					}
					catch (Exception e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			}
			if (fileName.length() > 0) {
				fileName.deleteCharAt(fileName.length() - 1);
			}
			DbProblem pnew = dbProblemService.searchById(id);

			if (fileName.length() > 0) {
				String oraiginalImg = pnew.getImgUrl();
				if (oraiginalImg != null && !"".equals(oraiginalImg)) {
					pnew.setImgUrl(oraiginalImg + "," + fileName.toString());
				}
				else {
					pnew.setImgUrl(fileName.toString());
				}
				dbProblemService.update(pnew);
			}
		}
	}

	private String getExtName(MultipartFile file) {
		String[] fileNameArr = file.getOriginalFilename().split("\\.");
		if (fileNameArr.length == 1) {
			return "";
		}
		String fileNameExt = fileNameArr[fileNameArr.length - 1];
		return fileNameExt;
	}

}
