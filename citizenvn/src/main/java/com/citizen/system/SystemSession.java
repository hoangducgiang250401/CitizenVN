package com.citizen.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.citizen.entity.compound.Account;

public class SystemSession {
	
	public static Account getAccountInSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Account account = (Account) session.getAttribute("account");
		return account;
	}
	
	public static int getLevelInSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int level = Integer.parseInt(session.getAttribute("level").toString());
		return level;
	}
}
