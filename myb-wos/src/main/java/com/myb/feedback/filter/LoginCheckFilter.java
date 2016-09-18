package com.myb.feedback.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myb.entity.pojo.feedback.DbUser;
import com.myb.feedback.base.Cons;

public class LoginCheckFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		DbUser em = (DbUser) session.getAttribute(Cons.USER);
		if(em != null) {
			int admin = em.getAdministrator();
			if(admin == 1) {
				chain.doFilter(req, resp);
			} else {
				resp.getWriter().write("<script>parent.window.location.href='" +  req.getContextPath() + "/manage.jhtml'</script>");
				//resp.getWriter().write("<script>parent.window.location.href='" +  req.getContextPath() + "/loginUI'</script>");
			}
		} else {
			resp.getWriter().write("<script>parent.window.location.href='" +  req.getContextPath() + "/manage.jhtml'</script>");
		}
	}

	public void destroy() {
		
	}


}
