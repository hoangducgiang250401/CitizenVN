package com.citizen.service;

import com.citizen.dao.DaoCountry;
import com.citizen.dao.DaoDistrict;
import com.citizen.dao.DaoProvince;
import com.citizen.dao.DaoVillage;
import com.citizen.dao.DaoWards;
import com.citizen.dao.face.FaceAbstractArea;
import com.citizen.entity.compound.Account;

public class ServiceLogin {
	
	private FaceAbstractArea account;
	
	
	public Account findAccountByUserAndPass(String user,String pass) {
		
		int level = user.length();
		
		if(level == 1) {
			account = new DaoCountry();
		}
		else if (level == 2){
			account = new DaoProvince();
		}
		else if (level == 4){
			account = new DaoDistrict();
		}
		else if (level == 6){
			account = new DaoWards();
		}
		else if (level == 8){
			account = new DaoVillage();
		}
		else {
			return null;
		}
		
		return account.findAccountByUserAndPass(user, pass);
	}
	
	
	public static void main(String[] args) {
		ServiceLogin s = new ServiceLogin();
		System.out.println(s.findAccountByUserAndPass("01", "123").toString());
	}
}
