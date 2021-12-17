package com.citizen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citizen.entity.BaseTerritory;
import com.citizen.entity.compound.Account;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;
import com.citizen.model.ModelPeople;

public class AbstractAreaDao extends AbstractDao {

	// lấy tài khoản mật khẩu người dùng theo user và pass
	public Account getAccount(String query, String user, String pass) {
		Account account = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, user);
			statement.setString(2, pass);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				account = new Account(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	}

	// LẤY GIẤY THÔNG HÀNH THEO ID
	public boolean getTrafficPermit(String query, int id) {
		int permit = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				permit = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (permit == 1) {
			return true;
		}
		return false;
	}

	// LẤY ID CHỦ THOE ID SEN
	public int getIdBoss(String query, int id) {
		int idBoss = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				idBoss = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idBoss;
	}

	// LẤY TẤT CẢ TÀI KHOẢN CẤP DƯỚI
	public List<ModelCapDuoi> getAllAccount(String query, int id) {
		List<ModelCapDuoi> list = new ArrayList<ModelCapDuoi>();
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				list.add(new ModelCapDuoi(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// THÊM TÀI KHOẢN QUẢN LÝ CHO CẤP DƯỚI
	public void addAccount(String query, BaseTerritory territory) {

		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, territory.getId_superior());
			pStatement.setString(2, territory.getName());
			pStatement.setDouble(3, territory.getArea());
			pStatement.setString(4, territory.getPass());
			pStatement.setString(5, territory.getCode());
			pStatement.setInt(6, territory.getPermit());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// SỬA TÀI KHOẢN CẤP DƯỚI"UPDATE province "
	public void updateAccountDownlevel(String query, int id, ModelCapDuoiSave capDuoiSave) {

		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, capDuoiSave.getName());
			pStatement.setString(2, capDuoiSave.getCodeNew());
			pStatement.setString(3, capDuoiSave.getPass());
			pStatement.setString(4, capDuoiSave.getStartTime());
			pStatement.setString(5, capDuoiSave.getEndTime());
			pStatement.setInt(6, id);
			pStatement.setString(7, capDuoiSave.getCode());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//XOÁ TÀI KHOẢN CẤP DƯỚI
	public void deleteAccountDownlevel(String query,int id, String name,String code,String pass) throws SQLException {

		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, id);
			pStatement.setString(2, name);
			pStatement.setString(3, code);
			pStatement.setString(4, pass);
			pStatement.executeUpdate();
	}

	// KIỂM TRA TÀI KHOẢN CẤP DƯỚI TỒN TẠI KHÔNG
	public boolean codeNotExist(String query, int id, String code) {

		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, id);
			pStatement.setString(2, code);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	//THÊM NGƯỜI DÂN
	public void addPeople(String query, String code, ModelPeople modelPeople) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, code);
			pStatement.setString(2, modelPeople.getCmnd());
			pStatement.setString(3, modelPeople.getHoten());
			pStatement.setString(4, modelPeople.getNgaysinh());
			pStatement.setString(5, modelPeople.getGioitinh());
			pStatement.setString(6, modelPeople.getDantoc());
			pStatement.setString(7, modelPeople.getNghenghiep());
			pStatement.setString(8, modelPeople.getQuequan());
			pStatement.setString(9, modelPeople.getTamtru());
			pStatement.setString(10, modelPeople.getThuongtru());
			pStatement.setString(11, modelPeople.getTongiao());
			pStatement.setString(12, modelPeople.getTrinhdohv());
			pStatement.executeUpdate();
	}
	
	//LẤY MÃ CỦA KHU VỰC THEO ĐỊA CHỈ
	public String getCodeByAddress(String tinh, String huyen, String phuong, String thon) {
		Connection connection = getConnection();
		PreparedStatement pStatement = null;
		String query = "SELECT * FROM diachi "
				+ "where diachi.tinh = ? "
				+ "and diachi.huyen = ? "
				+ "and diachi.phuong = ? "
				+ "and diachi.thon = ?;";
		String code = null;
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, tinh);
			pStatement.setString(2, huyen);
			pStatement.setString(3, phuong);
			pStatement.setString(4, thon);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				code = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
}
