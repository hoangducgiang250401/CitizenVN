package com.citizen.service;

import java.util.ArrayList;
import java.util.List;

import com.citizen.dao.DaoDistrict;
import com.citizen.dao.DaoProvince;
import com.citizen.dao.DaoVillage;
import com.citizen.dao.DaoWards;
import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.model.ModelNameArea;

public class ServiceDiaChi {
	
	FaceAbstractArea diaChi;
	
	public List<ModelNameArea> getAllNameArea(List<ModelNameArea> area){
		List<ModelNameArea> list = new ArrayList<ModelNameArea>();
		if(area.isEmpty()) {
			DaoProvince province = new DaoProvince();
			list = province.getAllNameArea();
		}
		else if(area.size() == 1) {
			DaoDistrict distric = new DaoDistrict();
			list = distric.getAllNameArea(area.get(0).getName());
		}
		else if(area.size() == 2) {
			DaoWards wards = new DaoWards();
			list = wards.getAllNameArea(area.get(0).getName(),area.get(1).getName());
		}
		else if(area.size() == 3) {
			DaoVillage village = new DaoVillage();
			list = village.getAllNameArea(area.get(0).getName(),area.get(1).getName(),area.get(2).getName());
		}
		return list;
	}

}
