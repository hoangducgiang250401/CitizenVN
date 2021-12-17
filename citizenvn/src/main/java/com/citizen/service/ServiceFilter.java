package com.citizen.service;

import com.citizen.dao.DaoCountry;
import com.citizen.dao.DaoDistrict;
import com.citizen.dao.DaoProvince;
import com.citizen.dao.DaoVillage;
import com.citizen.dao.DaoWards;
import com.citizen.dao.face.FaceAbstractArea;

public class ServiceFilter {

	FaceAbstractArea permit;

	public boolean getTrafficPermitById(int id, int level) {

		if (level == 1 || level == 0) {
			permit = new DaoCountry();
		} else if (level == 2) {
			permit = new DaoProvince();
		} else if (level == 4) {
			permit = new DaoDistrict();
		} else if (level == 6) {
			permit = new DaoWards();
		} else if (level == 8) {
			permit = new DaoVillage();
		} else {
			return false;
		}

		if (level == 1) {
			return true;
		}

		if (level == 0) {
			return permit.getTrafficPermitById(id);
		}

		if (permit.getTrafficPermitById(id) == false) {
			return false;
		}

		return getTrafficPermitById(permit.getIdBossByIdSen(id), level - 2);
	}

	public static void main(String[] args) {
		ServiceFilter s = new ServiceFilter();
		System.out.println(s.getTrafficPermitById(19, 2));
	}
}
