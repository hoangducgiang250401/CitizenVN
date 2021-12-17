package com.citizen.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citizen.model.ModelCapDuoi;
import com.citizen.service.ServiceCapDuoi;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/cap-duoi"})
public class CapDuoi extends HttpServlet{
	ServiceCapDuoi capDuoi = new ServiceCapDuoi();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ModelCapDuoi> list = capDuoi.getCapDuoi(1, 1);
		req.setAttribute("listCapDuoi", list);
		req.getRequestDispatcher("views/jsp/capquyen.jsp").forward(req, resp);
	}
}
