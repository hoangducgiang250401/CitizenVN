package com.citizen.filler;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.citizen.entity.compound.Account;
import com.citizen.service.ServiceFilter;
import com.citizen.system.SystemConstant;

@WebFilter(urlPatterns = { "/*" })
public class AuthorizationFilter implements Filter {

	ServiceFilter serviceFilter;

	public void init(FilterConfig filterConfig) throws ServletException {

		serviceFilter = new ServiceFilter();
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("trang filter");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String loginURI = request.getContextPath() + "/login";
		String uri = request.getRequestURI();
		boolean loggedIn = session != null && session.getAttribute("account") != null;
		boolean loginRequest = request.getRequestURI().equals(loginURI);

		if (loginRequest) {
			chain.doFilter(request, response);
		} else if (loggedIn) {
			Account account = (Account) session.getAttribute("account");
			int level = account.getUser().length();
			System.out.println("level : " + level);
			if (serviceFilter.getTrafficPermitById(account.getId(), level)) {
				forward(level, uri, request, response, chain, loginURI);
			} else {
				response.sendRedirect(loginURI);
			}
		} else {
			response.sendRedirect(loginURI);
		}
	}
	public void destroy() {

	}
	public static void forward(int level, String uri, HttpServletRequest request, HttpServletResponse response,
			FilterChain chain, String loginURI) throws IOException, ServletException {
		if (uri.startsWith(SystemConstant.COUNTRY)) {
			if (level == 1) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else if (uri.startsWith(SystemConstant.PROVINCE)) {
			if (level == 2 || level == 1) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else if (uri.startsWith(SystemConstant.DISTRICT)) {
			if (level == 4 || level == 2 || level == 1) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else if (uri.startsWith(SystemConstant.WARDS)) {
			if (level == 6 || level == 2 || level == 1) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else if (uri.startsWith(SystemConstant.VILLAGE)) {
			if (level == 8 || level == 6 || level == 2 || level == 1) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(loginURI);
			}
		} else {
			chain.doFilter(request, response);
		}
	}
}
