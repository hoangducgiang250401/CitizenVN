package com.citizen.dao;

import java.sql.SQLException;
import java.util.List;

import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.dao.face.FaceCountry;
import com.citizen.entity.BaseTerritory;
import com.citizen.entity.compound.Account;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;
import com.citizen.model.ModelNameArea;
import com.citizen.model.ModelPeople;

public class DaoCountry extends AbstractAreaDao implements FaceCountry,FaceAbstractArea{

	// TÌM ACCOUNT
	public Account findAccountByUserAndPass(String user,String pass) {
		String query = "SELECT "
				+ "country.id_country as id,"
				+ "country.name,"
				+ " country.code, "
				+ "country.pass "
				+ "from country "
				+ "where country.code = ? and country.pass = ?;";
		return getAccount(query, user, pass);
	}

	// LẤY GIẤY THÔNG HÀNH THEO ID NÓ
	public boolean getTrafficPermitById(int id) {
		String query = "SELECT country.permit FROM citizen.country where id_country = ?;";
		return getTrafficPermit(query,id);
	}

	// LẤY TÌA KHOẢN BOSS THEO ID SEN
	public int getIdBossByIdSen(int id) {
		return 0;
	}

	// THÊM TÀI KHOẢN CHO CẤP DƯỚI
	public void addAccountDownlevel(BaseTerritory territory) {
		String query = "insert into province(id_country,name,area,pass,code,permit)"
				+ "values (?,?,?,?,?,?);";
		addAccount(query, territory);
	}

	// HIỂN THỊ TẤT CẢ TÀI KHOẢN CẤP DƯỚI THEO ID NÓ
	public List<ModelCapDuoi> getAccountDownLevel(int id) {
		String query = "select name,code,pass,start_time,end_time from province where province.id_country = ? order by code;";
		return getAllAccount(query, id);
	}

	//SỬA TÀI KHOẢN
	public void updateAccountDownLevel(int id, ModelCapDuoiSave capDuoiSave) {
		String query = "UPDATE province "
				+ "set name = ?,"
				+ "code = ?,"
				+ "pass = ?,"
				+ "start_time = ?,"
				+ "end_time = ?\r\n"
				+ "where province.id_country = ? "
				+ "and province.code = ?;";
		updateAccountDownlevel(query, id, capDuoiSave);
	}

	public boolean codeNotExist(int id, String code) {
		String query = "select "
				+ "name,"
				+ "area,"
				+ "pass,"
				+ "code,"
				+ "permit "
				+ "from province "
				+ "where province.id_country = ? and province.code = ?;";
		return codeNotExist(query, id, code);
	}
	public static void main(String[] args) throws SQLException {
		DaoCountry d = new DaoCountry();
//		System.out.println(d.getTrafficPermitById(1));
//		System.out.println(d.findAccountByUserAndPass("1","123"));
//		BaseTerritory territory = new BaseTerritory("Giang", 2222, "123", "01", 1, 1);
//		d.addAccount(territory);
//		System.out.println(d.showAccountDownLevel(1));
//		if(d.codeNotExist(1, "02")) {
//			System.out.println("không tồn tại");
//		}
//		else {
//			System.out.println("tồn tại");
//		}
		d.addPeople("1", new ModelPeople("033201004513","Hoàng Đức Giang","2001-04-25",
				"nam","Kinh","Sinh viên","Hưng yên","Hà Nội","Hưng yên","không","Sinh viên"));
	}

	public void deleteAccountDownlevel(int id,String name, String code, String pass) throws SQLException {
		String query = "delete "
				+ "from province "
				+ "where "
				+ "province.id_country = ? "
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

	public List<ModelNameArea> getAllNameArea() {
		
		return null;
	}
}
