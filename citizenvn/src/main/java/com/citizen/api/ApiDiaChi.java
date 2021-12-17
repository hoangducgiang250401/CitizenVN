package com.citizen.api;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citizen.model.ModelNameArea;
import com.citizen.service.ServiceDiaChi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/api-dia-chi"})
public class ApiDiaChi extends HttpServlet {
	
	ServiceDiaChi diaChi = new ServiceDiaChi();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("LẤY THÔNG TIN ĐỊA CHỈ");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		try {
			req.setCharacterEncoding("UTF-8");
			List<ModelNameArea> area =  new Gson().fromJson(req.getReader(),new TypeToken<List<ModelNameArea>>(){}.getType());
			List<ModelNameArea> RsDiaChi = diaChi.getAllNameArea(area);
			String jsonResp = new Gson().toJson(RsDiaChi);
			PrintWriter out = resp.getWriter();
			out.write(jsonResp);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
