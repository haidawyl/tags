package org.hdwyl.tags.controller.intercepter;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atme8.commons.utils.StringUtil;
import org.hdwyl.tags.common.Constants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		Set<String> notCheckURISet = new HashSet<String>();
		notCheckURISet.add("/error");
		notCheckURISet.add("/toLogin");
		notCheckURISet.add("/login");
		notCheckURISet.add("/logout");
		if (notCheckURISet.contains(request.getRequestURI())) {
			return true;
		}

		Object user = request.getSession().getAttribute(
				Constants.KEY_LOGIN_USER);

		if (user != null) { // 已登录
			return true;
		} else {// 未登录，跳转到登录页面
			response.sendRedirect("/toLogin");// 跳转登录页面
			return false;
		}
	}

}
