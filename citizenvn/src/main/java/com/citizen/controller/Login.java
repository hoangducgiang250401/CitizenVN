package com.citizen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.citizen.entity.compound.Account;
import com.citizen.service.ServiceLogin;



@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
	
	ServiceLogin serviceLogin = new ServiceLogin();
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is the login page");
	    req.getRequestDispatcher("views/jsp/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		Account account = serviceLogin.findAccountByUserAndPass(user, pass);
		if (account == null) {
			req.getRequestDispatcher("views/jsp/login.jsp").forward(req, resp);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("account", account);
			session.setAttribute("level", account.getUser().length());
			resp.sendRedirect("/citizenvn/home");
		}
	}

}
