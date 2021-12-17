package com.citizen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.dao.face.FaceProvince;
import com.citizen.entity.BaseTerritory;
import com.citizen.entity.compound.Account;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;
import com.citizen.model.ModelNameArea;
import com.citizen.model.ModelPeople;

public class DaoProvince extends AbstractAreaDao implements FaceProvince,FaceAbstractArea {


	public Account findAccountByUserAndPass(String user, String pass) {
		String query = "select "
				+ "province.id_province as id,"
				+ "province.name,"
				+ "province.code,"
				+ "province.pass "
				+ "from province "
				+ "where province.code = ? and province.pass = ?;";
		return getAccount(query, user, pass);
	}

	public boolean getTrafficPermitById(int id) {
		String query = "SELECT province.permit FROM citizen.province where id_province = ?;";
		return getTrafficPermit(query,id);
	}

	public int getIdBossByIdSen(int id) {
		String query = "SELECT province.id_country FROM citizen.province where id_province = ?;";
		return getIdBoss(query, id);
	}

	public void addAccountDownlevel(BaseTerritory territory) {
		String query = "insert into district(id_province,name,area,pass,code,permit)"
				+ "values (?,?,?,?,?,?);";
		addAccount(query, territory);
	}
	
	

	public List<ModelCapDuoi> getAccountDownLevel(int id) {
		String query = "select name,code,pass,start_time,end_time from district where district.id_province = ? order by code;";
		return getAllAccount(query, id);
	}

	public void updateAccountDownLevel(int id,ModelCapDuoiSave capDuoiSave) {
		String query = "UPDATE district set name = ?,"
				+ "code = ?,"
				+ "pass = ?,"
				+ "start_time = ?,"
				+ "end_time = ?\r\n"
				+ "where district.id_province = ? "
				+ "and district.code = ?;";
		updateAccountDownlevel(query, id, capDuoiSave);
		
	}

	public boolean codeNotExist(int id, String code) {
		String query = "select "
				+ "name,"
				+ "area,"
				+ "pass,"
				+ "code,"
				+ "permit "
				+ "from district where district.id_province = ? and district.code = ?;";
		return codeNotExist(query, id, code);
	}

	public void deleteAccountDownlevel(int id,String name, String code, String pass) throws SQLException {
		String query = "delete "
				+ "from district "
				+ "where "
				+ "district.id_province = ? "
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
	public List<ModelNameArea> getAllNameArea(){
		String query = "select tinh from diachi group by diachi.tinh;";
		List<ModelNameArea> list = new ArrayList<ModelNameArea>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				list.add(new ModelNameArea(resultSet.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static void main(String[] args) throws SQLException {
		DaoProvince d = new DaoProvince();
//		System.out.println(d.getIdBossByIdSen(1));
//		System.out.println(d.getTrafficPermitById(1));
//		System.out.println(d.findAccountByUserAndPass("01","123"));
//		BaseTerritory territory = new BaseTerritory("Giang", 2222, "123", "01", 1, 1);
//		d.addAccount(territory);
//		if(d.codeNotExist(13, "02")) {
//			System.out.println("không tồn tại");
//		}
//		else {
//			System.out.println("tồn tại");
//		}
		List<ModelNameArea> list = d.getAllNameArea();
		for(ModelNameArea a : list) {
			System.out.println(a.getName());
		}
	}
}
