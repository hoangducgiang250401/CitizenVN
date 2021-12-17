package com.citizen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.dao.face.FaceWards;
import com.citizen.entity.BaseTerritory;
import com.citizen.entity.compound.Account;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;
import com.citizen.model.ModelNameArea;
import com.citizen.model.ModelPeople;

public class DaoWards extends AbstractAreaDao implements FaceWards,FaceAbstractArea {

	public Account findAccountByUserAndPass(String user, String pass) {
		String query = "select wards.id_wards as id,wards.name, concat(province.code,district.code,wards.code) code, wards.pass from wards\r\n"
				+ "inner join district on district.id_district = wards.id_district\r\n"
				+ "inner join province on province.id_province = district.id_province\r\n"
				+ "where concat(province.code,district.code,wards.code) = ? and wards.pass = ?;";
		return getAccount(query, user, pass);
	}
	

	public boolean getTrafficPermitById(int id) {
		String query = "SELECT permit FROM citizen.wards where id_wards = ?;";
		return getTrafficPermit(query,id);
	}

	public int getIdBossByIdSen(int id) {
		String query = "SELECT wards.id_district FROM citizen.wards where id_wards = ?;";
		return getIdBoss(query, id);
	}


	public void addAccountDownlevel(BaseTerritory territory) {
		String query = "insert into village(id_wards,name,area,pass,code,permit)"
				+ "values (?,?,?,?,?,?);";
		addAccount(query, territory);
	}

	public static void main(String[] args) {
		DaoWards d = new DaoWards();
//		System.out.println(d.getIdBossByIdSen(67));
//		System.out.println(d.getTrafficPermitById(1));
//		System.out.println(d.findAccountByUserAndPass("190101","123"));
//		BaseTerritory territory = new BaseTerritory("Giang", 2222, "123", "01", 1, 1);
//		d.addAccount(territory);
		if(d.codeNotExist(1, "02")) {
			System.out.println("không tồn tại");
		}
		else {
			System.out.println("tồn tại");
		}
	}


	public List<ModelCapDuoi> getAccountDownLevel(int id) {
		String query = "select name,code,pass,start_time,end_time from village where village.id_wards = ? order by code;";
		return getAllAccount(query, id);
	}


	public void updateAccountDownLevel(int id, ModelCapDuoiSave capDuoiSave) {
		String query = "UPDATE village set name = ?,"
				+ "code = ?,"
				+ "pass = ?,"
				+ "start_time = ?,"
				+ "end_time = ?\r\n"
				+ "where village.id_wards = ? "
				+ "and village.code = ?;";
		updateAccountDownlevel(query, id, capDuoiSave);
		
	}


	public boolean codeNotExist(int id, String code) {
		String query = "select "
				+ "name,"
				+ "area,"
				+ "pass,"
				+ "code,"
				+ "permit "
				+ "from village where village.id_wards = ? and village.code = ?;";
		return codeNotExist(query, id, code);
	}


	public void deleteAccountDownlevel(int id,String name, String code, String pass) throws SQLException {
		String query = "delete"
				+ " from village "
				+ "where "
				+ "village.id_wards = ? "
				+ "and name = ? "
				+ "and code = ? "
				+ "and pass = ?;";
		deleteAccountDownlevel(query, id, name, code, pass);
	}


	public void addPeople(String code, ModelPeople modelPeople) throws SQLException {
		String query = "insert into citizen (code, cmnd, hoten, ngaysinh, gioitinh,dantoc,nghenghiep,quequan,tamtru,thuongtru,tongiao,trinhdovh) "
				+ "values \r\n"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		addPeople(query, code, modelPeople);
	}
	
	public List<ModelNameArea> getAllNameArea(String tinh,String huyen) {
		String query = "select phuong from diachi where diachi.tinh = ? and diachi.huyen = ? group by diachi.phuong;";
		List<ModelNameArea> list = new ArrayList<ModelNameArea>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, tinh);
			statement.setString(2, huyen);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				list.add(new ModelNameArea(resultSet.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
