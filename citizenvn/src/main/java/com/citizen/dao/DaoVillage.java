package com.citizen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.dao.face.FaceVillage;
import com.citizen.entity.BaseTerritory;
import com.citizen.entity.compound.Account;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;
import com.citizen.model.ModelNameArea;
import com.citizen.model.ModelPeople;

public class DaoVillage extends AbstractAreaDao implements FaceVillage, FaceAbstractArea {

	public Account findAccountByUserAndPass(String user, String pass) {
		String query = "select " + "village.id_village as id," + "village.name, "
				+ "concat(province.code,district.code,wards.code,village.code) code, " + "village.pass "
				+ "from village\r\n" + "inner join wards on wards.id_wards = village.id_wards\r\n"
				+ "inner join district on district.id_district = wards.id_district\r\n"
				+ "inner join province on province.id_province = district.id_province\r\n"
				+ "where concat(province.code,district.code,wards.code,village.code) = ? and village.pass = ?;";
		return getAccount(query, user, pass);
	}

	public boolean getTrafficPermitById(int id) {
		String query = "SELECT village.permit FROM citizen.village where id_village = ?;";
		return getTrafficPermit(query, id);
	}

	public int getIdBossByIdSen(int id) {
		String query = "SELECT village.id_wards FROM citizen.village where village.id_village = ?;";
		return getIdBoss(query, id);
	}

	public void addAccountDownlevel(BaseTerritory territory) {

	}

	public static void main(String[] args) {
		DaoVillage d = new DaoVillage();
		System.out.println(d.getIdBossByIdSen(1));
		System.out.println(d.getTrafficPermitById(1));
		System.out.println(d.findAccountByUserAndPass("19024615", "123"));
		BaseTerritory territory = new BaseTerritory("Giang", 2222, "123", "01", 1, 1);
		d.addAccountDownlevel(territory);
	}

	public List<ModelCapDuoi> getAccountDownLevel(int id) {
		return null;
	}

	public void updateAccountDownLevel(int id, ModelCapDuoiSave capDuoiSave) {
		return ;
	}

	public boolean codeNotExist(int id, String code) {
		return true;
	}

	public void deleteAccountDownlevel(int id,String name, String code, String pass) {
		
	}

	public void addPeople(String code, ModelPeople modelPeople) throws SQLException {
		String query = "insert into citizen (code, cmnd, hoten, ngaysinh, gioitinh,dantoc,nghenghiep,quequan,tamtru,thuongtru,tongiao,trinhdovh) "
				+ "values \r\n"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		addPeople(query, code, modelPeople);
		
	}

	public List<ModelNameArea> getAllNameArea(String tinh,String huyen, String phuong) {
		String query = "select thon from diachi where "
				+ "diachi.tinh = ? and "
				+ "diachi.huyen = ? and "
				+ "diachi.phuong = ? group by diachi.thon;";
		List<ModelNameArea> list = new ArrayList<ModelNameArea>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, tinh);
			statement.setString(2, huyen);
			statement.setString(3, phuong);
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
