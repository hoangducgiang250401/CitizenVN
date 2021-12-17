package com.citizen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citizen.model.ModelNameArea;
import com.citizen.service.ServiceDiaChi;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/people"})
public class People extends HttpServlet {
	ServiceDiaChi diaChi = new ServiceDiaChi();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ModelNameArea> a = new ArrayList<ModelNameArea>();
		List<ModelNameArea> list = diaChi.getAllNameArea(a);
		req.setAttribute("listDiaChi", list);
		req.getRequestDispatcher("views/jsp/addPeople.jsp").forward(req, resp);
	}
}
