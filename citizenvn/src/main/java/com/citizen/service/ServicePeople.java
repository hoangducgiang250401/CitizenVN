package com.citizen.service;

import java.sql.SQLException;

import com.citizen.dao.AbstractAreaDao;
import com.citizen.dao.DaoCountry;
import com.citizen.dao.DaoDistrict;
import com.citizen.dao.DaoProvince;
import com.citizen.dao.DaoVillage;
import com.citizen.dao.DaoWards;
import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.model.ModelPeople;

public class ServicePeople {
	FaceAbstractArea people;

	public void addPeople(int level, String code, ModelPeople modelPeople) throws SQLException {
		if (level == 1) {
			people = new DaoCountry();
		} else if (level == 2) {
			people = new DaoProvince();
		} else if (level == 4) {
			people = new DaoDistrict();
		} else if (level == 6) {
			people = new DaoWards();
		} else if (level == 8) {
			people = new DaoVillage();
		} else {
			return;
		}
		people.addPeople(code, modelPeople);
	}
	
	public String getCodeByAddress(String[] queQuan){
		String code = new AbstractAreaDao().getCodeByAddress(queQuan[0], queQuan[1], queQuan[2], queQuan[3]);
		return code;
	}
}
