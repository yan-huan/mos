package com.myb.feedback.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myb.feedback.service.DbDataDictionaryService;
import com.myb.feedback.service.DbProblemService;
import com.myb.feedback.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Maps;
import com.myb.commons.utils.HexUtil;
import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.entity.pojo.feedback.DbDataDictionaryMapping;
import com.myb.entity.pojo.feedback.DbProblem;
import com.myb.entity.pojo.feedback.DbProblemMapping;
import com.myb.entity.pojo.feedback.DbUser;
import com.myb.entity.pojo.feedback.DbUserMapping;
import com.myb.feedback.base.Cons;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.util.RequestUtil;

@Controller
public class IndexController {
	@Autowired
	private DbUserService dbUserService;
	@Autowired
	private DbProblemService dbProblemService;
	@Autowired
	private DbDataDictionaryService dbDataDictionaryService;

	@RequestMapping("/wos/index")
	public String index(HttpServletRequest request, Model model) {
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setPageSize(Cons.PAGE_SIZE);
		queryCondition.setPageIndex(RequestUtil.getIntParameter(request,
				"page", 1));

		DbUser user = (DbUser) request.getSession().getAttribute(Cons.USER);
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq(DbProblemMapping.CreateBy, user.getId());
		queryCondition.setQueryParameter(queryParameter);

		SortParameter sortParameter = new SortParameter();
		sortParameter.add(DbProblemMapping.Id, SqlOrder.DESC);
		queryCondition.setSortParameter(sortParameter);

		PagedList<DbProblem> pagedList = dbProblemService
				.searchByPage(queryCondition);
		if (pagedList != null) {
			List<DbProblem> dps = pagedList.getContent();
			if (dps != null && dps.size() > 0) {
				for (DbProblem dbProblem : dps) {
					dbProblem
							.setDescripe(dbProblem.getDescripe().length() > 30 ? dbProblem
									.getDescripe().substring(0, 30) + "......"
									: dbProblem.getDescripe());
				}
			}
		}
		model.addAttribute("pagedList", pagedList);

		queryParameter = new QueryParameter();
		queryParameter.eq(DbDataDictionaryMapping.Type, 6);
		List<DbDataDictionary> dbDataDictionaryList = dbDataDictionaryService
				.searchList(queryParameter);
		if (dbDataDictionaryList != null && dbDataDictionaryList.size() > 0) {
			Map<String, String> dbDataDictionaryMap = Maps.newHashMap();
			for (DbDataDictionary dbDataDictionary : dbDataDictionaryList) {
				dbDataDictionaryMap.put(dbDataDictionary.getCode(),
						dbDataDictionary.getName());
			}
			model.addAttribute("dbDataDictionaryMap", dbDataDictionaryMap);
		}
		return Cons.FRONT + "/index";
	}

	@RequestMapping("/loginUI")
	public String loginUI(HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
		HttpSession session = req.getSession();
		DbUser em = (DbUser) session.getAttribute(Cons.USER);
		if (em != null) {
			int admin = em.getAdministrator();
			if (admin == 0) {
				return "redirect:/wos/index.jhtml";
			} else {
				resp.getWriter().write(
						"<script>parent.window.location.href='"
								+ req.getContextPath() + "/'</script>");
			}
		} else {

			Cookie[] cookies = req.getCookies();// 取cookie值，这里还有其他网站的
			if (cookies != null) {
				String cookieValue = null;
				// 下面是找到本项目的cookie
				for (int i = 0; i < cookies.length; i++) {
					if (Cons.cookieDomainName.equals(cookies[i].getName())) {
						cookieValue = cookies[i].getValue();
						break;
					}
				}
				
				if(cookieValue==null){
					resp.getWriter().write(
							"<script>parent.window.location.href='"
									+ req.getContextPath() + "/'</script>");
				} else {
					String cookieValues[] = cookieValue.split(":");
					// 取出cookie中的用户名,并到数据库中检查这个用户名,
					String username = cookieValues[0];
					String password = cookieValues[1];
					
					QueryParameter queryParameter = new QueryParameter();
					queryParameter.eq(DbUserMapping.Username, username).and()
							.eq("administrator", 0);
					List<DbUser> userTemps = dbUserService.searchList(queryParameter);
					if (userTemps != null && userTemps.size() > 0) {
						DbUser userTemp = userTemps.get(0);
						if (userTemp.getPassword().equals(password)) {
							req.getSession().setAttribute(Cons.USER, userTemp);
							return "redirect:/wos/index.jhtml";
						} else {
							resp.getWriter().write(
									"<script>parent.window.location.href='"
											+ req.getContextPath() + "/'</script>");
						}
					} else {
						resp.getWriter().write(
								"<script>parent.window.location.href='"
										+ req.getContextPath() + "/'</script>");
					}
				}
			} else {
				resp.getWriter().write(
						"<script>parent.window.location.href='"
								+ req.getContextPath() + "/'</script>");
			}
		}
		return Cons.FRONT + "/login";
	}

	@RequestMapping("/login")
	public String login(DbUser user, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes attr) {
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq(DbUserMapping.Username, user.getUsername()).and()
				.eq("administrator", 0);
		List<DbUser> userTemps = dbUserService.searchList(queryParameter);
		if (userTemps != null && userTemps.size() > 0) {
			DbUser userTemp = userTemps.get(0);
			if (HexUtil.validPasswd(user.getPassword(), userTemp.getPassword())) {
				request.getSession().setAttribute(Cons.USER, userTemp);

				// 保存Cookie到客户端
				// 将要被保存的完整的Cookie值
				String cookieValue = user.getUsername() + ":"
						+ userTemp.getPassword();
				// 开始保存Cookie（cookie是网站名和值）
				Cookie cookie = new Cookie(Cons.cookieDomainName, cookieValue);
				// 存两年(这个值应该大于或等于validTime)
				cookie.setMaxAge(60 * 60 * 24 * 365 * 2);
				// cookie有效路径是网站根目录
				cookie.setPath("/");
				// 向客户端写入
				response.addCookie(cookie);

				return "redirect:/wos/index.jhtml";
			} else {
				attr.addFlashAttribute(Cons.MESSAGE, "0");
				return "redirect:/loginUI";
			}
		} else {
			attr.addFlashAttribute(Cons.MESSAGE, "1");
			return "redirect:/loginUI";
		}
	}

	@RequestMapping("/wos/logout.jhtml")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute(Cons.USER);
		Cookie cookie = new Cookie(Cons.cookieDomainName, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/";
	}

}
