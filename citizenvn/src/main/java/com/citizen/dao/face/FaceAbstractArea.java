package com.citizen.dao.face;


import java.sql.SQLException;
import java.util.List;

import com.citizen.entity.BaseTerritory;
import com.citizen.entity.compound.Account;
import com.citizen.model.ModelCapDuoi;
import com.citizen.model.ModelCapDuoiSave;
import com.citizen.model.ModelPeople;

public interface FaceAbstractArea {

	Account findAccountByUserAndPass(String user,String pass);
	
	boolean getTrafficPermitById(int id);
	
	int getIdBossByIdSen(int id);
	
	void addAccountDownlevel(BaseTerritory territory);
	
	void deleteAccountDownlevel(int id,String name,String code,String pass) throws SQLException;
	
	void updateAccountDownLevel(int id,ModelCapDuoiSave capDuoiSave);
	
	List<ModelCapDuoi> getAccountDownLevel(int id);
	
	boolean codeNotExist(int id, String code);
	
	void addPeople(String code, ModelPeople modelPeople) throws SQLException;
	
}
