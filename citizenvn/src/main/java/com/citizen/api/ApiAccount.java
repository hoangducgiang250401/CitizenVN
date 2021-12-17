package com.citizen.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.citizen.entity.BaseTerritory;
import com.citizen.entity.compound.Account;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;
import com.citizen.service.ServiceCapDuoi;
import com.citizen.system.SystemMessage;
import com.citizen.system.SystemSession;
import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/api-down-level" })
public class ApiAccount extends HttpServlet {

	ServiceCapDuoi capDuoi = new ServiceCapDuoi();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		System.out.println("THÊM TÀI KHOẢN");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		int level = Integer.parseInt(session.getAttribute("level").toString());
		try {
			BaseTerritory data = new Gson().fromJson(req.getReader(), BaseTerritory.class);
			SystemMessage message = new SystemMessage();
			if (capDuoi.codeNotExist(level, data.getCode(), data.getId_superior())) {
				capDuoi.addAccount(data, level);
				if (level == 1) {
					message.setValue("Tên tài tương ứng cửa bn là : " + data.getCode());
				} else {
					Account account = (Account) session.getAttribute("account");
					message.setValue("Tên tài tương ứng cửa bn là : " + account.getUser() + data.getCode());
				}
			} else {
				message.setValue("Tài khoản cho mã này đã tồn tại !");
			}
			String jsonResp = new Gson().toJson(message);
			PrintWriter out = resp.getWriter();
			out.write(jsonResp);
			out.close();
		} catch (Exception ex) {
			System.out.println();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("CẬP NHẬT TÀI KHOẢN");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		ModelCapDuoiSave modelCapDuoiSave = new Gson().fromJson(req.getReader(), ModelCapDuoiSave.class);
		SystemMessage message = new SystemMessage();
		capDuoi.updateAccountDownLevel(SystemSession.getLevelInSession(req),
		SystemSession.getAccountInSession(req).getId(), modelCapDuoiSave);
		message.setValue("Thay đổi thành công");
		String jsonResp = new Gson().toJson(message);
		PrintWriter out = resp.getWriter();
		out.write(jsonResp);
		out.close();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("XOÁ TÀI KHOẢN");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		Account account = SystemSession.getAccountInSession(req);
		int level = SystemSession.getLevelInSession(req);
		ModelCapDuoi modelCapDuoi = new Gson().fromJson(req.getReader(), ModelCapDuoi.class);
		SystemMessage message = new SystemMessage();
		try {
			capDuoi.deleteAccountDownlevel(level, account.getId(), modelCapDuoi);
			message.setValue("Đã xoá");
		} catch (SQLException e) {
			message.setValue("Sẽ xảy ra lỗi nếu xoá");
			e.printStackTrace();
		}
		String jsonResp = new Gson().toJson(message);
		PrintWriter out = resp.getWriter();
		out.write(jsonResp);
		out.close();
	}
}
