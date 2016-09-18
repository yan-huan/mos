package com.myb.feedback.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myb.feedback.service.DbUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.myb.entity.pojo.feedback.DbUser;
import com.myb.entity.pojo.feedback.DbUserMapping;
import com.myb.feedback.base.Cons;
import com.myb.framework.data.QueryParameter;

public class FrontLoginCheckFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		DbUser em = (DbUser) session.getAttribute(Cons.USER);
		if (em != null) {
			int admin = em.getAdministrator();
			if (admin == 0) {
				chain.doFilter(req, resp);
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
					
					ApplicationContext cxt = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext());
					DbUserService dbUserService = (DbUserService) cxt.getBean("dbUserService");
					QueryParameter queryParameter = new QueryParameter();
					queryParameter.eq(DbUserMapping.Username, username).and()
							.eq("administrator", 0);
					List<DbUser> userTemps = dbUserService.searchList(queryParameter);
					if (userTemps != null && userTemps.size() > 0) {
						DbUser userTemp = userTemps.get(0);
						if (userTemp.getPassword().equals(password)) {
							req.getSession().setAttribute(Cons.USER, userTemp);
							chain.doFilter(req, resp);
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
	}

	public void destroy() {

	}

}
