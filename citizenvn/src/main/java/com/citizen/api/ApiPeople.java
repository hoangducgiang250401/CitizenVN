package com.citizen.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citizen.model.ModelPeople;
import com.citizen.service.ServicePeople;
import com.citizen.system.SystemMessage;
import com.citizen.system.SystemSession;
import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/api-people"})
public class ApiPeople extends HttpServlet{
	ServicePeople servicePeople = new ServicePeople();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("THÊM TÀI NGƯỜI DÂN");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		ModelPeople people = new Gson().fromJson(req.getReader(), ModelPeople.class);
		String[] queQuan = people.getQuequan().split(",");
		String code = servicePeople.getCodeByAddress(queQuan);
		SystemMessage message = new SystemMessage();
		try {
			if(code != null) {
				servicePeople.addPeople(SystemSession.getLevelInSession(req), code, people);
			message.setValue("Người dân mới đã được thêm");
			}
			else {
				message.setValue("Khu vực này không được tìm thấy !");
			}
			
		} catch (SQLException e) {
			message.setValue("Thông tin chưa hợp lý");
			e.printStackTrace();
		}
		String jsonResp = new Gson().toJson(message);
		PrintWriter out = resp.getWriter();
		out.write(jsonResp);
		out.close();
	}
}
