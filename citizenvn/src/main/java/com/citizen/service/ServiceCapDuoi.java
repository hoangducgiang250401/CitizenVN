package com.citizen.service;

import java.sql.SQLException;
import java.util.List;

import com.citizen.dao.DaoCountry;
import com.citizen.dao.DaoDistrict;
import com.citizen.dao.DaoProvince;
import com.citizen.dao.DaoWards;
import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.entity.BaseTerritory;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;

public class ServiceCapDuoi {
	FaceAbstractArea capDuoi;
	
	public void addAccount(BaseTerritory territory, int level) {
		if (level == 1) {
			capDuoi = new DaoCountry();
		} else if (level == 2) {
			capDuoi = new DaoProvince();
		} else if (level == 4) {
			capDuoi = new DaoDistrict();
		} else if (level == 6) {
			capDuoi = new DaoWards();
		} else if (level == 8) {
			return;
		} else {
			return;
		}

		capDuoi.addAccountDownlevel(territory);
		return;
	}
	
	public boolean codeNotExist(int level,String code, int id) {
		if (level == 1) {
			capDuoi = new DaoCountry();
		} else if (level == 2) {
			capDuoi = new DaoProvince();
		} else if (level == 4) {
			capDuoi = new DaoDistrict();
		} else if (level == 6) {
			capDuoi = new DaoWards();
		} else if (level == 8) {
			return true;
		} else {
			return true;
		}
		return capDuoi.codeNotExist(id, code);
	}

	public List<ModelCapDuoi> getCapDuoi(int id, int level) {
		if (level == 1) {
			capDuoi = new DaoCountry();
		} 
		else if (level == 2) {
			capDuoi = new DaoProvince();
		} 
		else if (level == 4) {
			capDuoi = new DaoDistrict();
		} 
		else if (level == 6) {
			capDuoi = new DaoWards();
		} 
		else if (level == 8) {
			return null;
		} 
		else {
			return null;
		}
		
		return capDuoi.getAccountDownLevel(id);
	}
	
	public void updateAccountDownLevel(int level, int id, ModelCapDuoiSave capDuoiSave) {
		if (level == 1) {
			capDuoi = new DaoCountry();
		} 
		else if (level == 2) {
			capDuoi = new DaoProvince();
		} 
		else if (level == 4) {
			capDuoi = new DaoDistrict();
		} 
		else if (level == 6) {
			capDuoi = new DaoWards();
		} 
		else if (level == 8) {
			return ;
		} 
		else {
			return ;
		}
		capDuoi.updateAccountDownLevel(id,capDuoiSave);
	}
	
	public void deleteAccountDownlevel(int level, int id, ModelCapDuoi modelCapDuoi) throws SQLException {
		if (level == 1) {
			capDuoi = new DaoCountry();
		} 
		else if (level == 2) {
			capDuoi = new DaoProvince();
		} 
		else if (level == 4) {
			capDuoi = new DaoDistrict();
		} 
		else if (level == 6) {
			capDuoi = new DaoWards();
		} 
		else if (level == 8) {
			return ;
		} 
		else {
			return ;
		}
		capDuoi.deleteAccountDownlevel(id,modelCapDuoi.getName(),modelCapDuoi.getCode(),modelCapDuoi.getPass());
	}
	
	public static void main(String[] args) {
		ServiceCapDuoi capDuoi = new ServiceCapDuoi();
		List<ModelCapDuoi> list = capDuoi.getCapDuoi(1, 1);
		for(ModelCapDuoi a : list) {
			System.out.println(a.getName());
		}
	}
}
