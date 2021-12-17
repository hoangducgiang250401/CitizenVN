package com.citizen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.dao.face.FaceDistrict;
import com.citizen.entity.BaseTerritory;
import com.citizen.entity.compound.Account;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;
import com.citizen.model.ModelNameArea;
import com.citizen.model.ModelPeople;

public class DaoDistrict extends AbstractAreaDao implements FaceDistrict ,FaceAbstractArea{


	public Account findAccountByUserAndPass(String user, String pass) {
		String query = "select "
				+ "district.id_district as id,"
				+ "district.name,"
				+ "concat(province.code,district.code) code,"
				+ "district.pass "
				+ "from district\r\n"
				+ "inner join province on province.id_province = district.id_province\r\n"
				+ "where concat(province.code,district.code) = ? and district.pass = ?;";
		return getAccount(query, user, pass);
	}
	

	public boolean getTrafficPermitById(int id) {
		String query = "SELECT district.permit FROM citizen.district where id_district = ?;";
		return getTrafficPermit(query,id);
	}
	

	public int getIdBossByIdSen(int id) {
		String query = "SELECT district.id_province FROM citizen.district where id_district = ?;";
		return getIdBoss(query, id);
	}


	public void addAccountDownlevel(BaseTerritory territory) {
		String query = "insert into wards(id_district,name,area,pass,code,permit)"
				+ "values (?,?,?,?,?,?);";
		addAccount(query, territory);
	}
	
	public static void main(String[] args) throws SQLException {
		DaoDistrict d = new DaoDistrict();
//		System.out.println(d.getIdBossByIdSen(1));
//		System.out.println(d.getTrafficPermitById(1));
//		System.out.println(d.findAccountByUserAndPass("1901","123"));
//		BaseTerritory territory = new BaseTerritory("Giang", 2222, "123", "01", 1, 1);
//		d.addAccount(territory);
//		if(d.codeNotExist(1, "02")) {
//			System.out.println("không tồn tại");
//		}
//		else {
//			System.out.println("tồn tại");
//		}
		List<ModelNameArea> list = d.getAllNameArea("hà nội");
		for(ModelNameArea a : list) {
			System.out.println(a.getName());
		}
	}


	public List<ModelCapDuoi> getAccountDownLevel(int id) {
		String query = "select name,code,pass,start_time,end_time from wards where wards.id_district = ? order by code;";
		return getAllAccount(query, id);
	}


	public void updateAccountDownLevel(int id, ModelCapDuoiSave capDuoiSave) {
		String query = "UPDATE wards "
				+ "set name = ?,"
				+ "code = ?,"
				+ "pass = ?,"
				+ "start_time = ?,"
				+ "end_time = ?\r\n"
				+ "where wards.id_district = ? "
				+ "and wards.code = ?;";
		updateAccountDownlevel(query, id, capDuoiSave);
		
	}

	public boolean codeNotExist(int id, String code) {
		String query = "select "
				+ "name,"
				+ "area,"
				+ "pass,"
				+ "code,"
				+ "permit "
				+ "from wards where wards.id_district = ? and wards.code = ?;";
		return codeNotExist(query, id, code);
	}


	public void deleteAccountDownlevel(int id,String name, String code, String pass) throws SQLException {
		String query = "delete "
				+ "from wards "
				+ "where wards.id_district = ? "
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


	public List<ModelNameArea> getAllNameArea(String tinh) {
		String query = "select huyen from diachi where diachi.tinh = ? group by diachi.huyen;";
		List<ModelNameArea> list = new ArrayList<ModelNameArea>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, tinh);
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
