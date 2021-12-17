package com.citizen.entity;

public class BaseCitizen {
	
	private int id_citizen;
	private int id_village;
	private String date_of_birth;
	private String full_name;
	private String sex;
	private String countryside;
	private String data_time;
	public int getId_citizen() {
		return id_citizen;
	}
	public void setId_citizen(int id_citizen) {
		this.id_citizen = id_citizen;
	}
	public int getId_village() {
		return id_village;
	}
	public void setId_village(int id_village) {
		this.id_village = id_village;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountryside() {
		return countryside;
	}
	public void setCountryside(String countryside) {
		this.countryside = countryside;
	}
	public String getData_time() {
		return data_time;
	}
	public void setData_time(String data_time) {
		this.data_time = data_time;
	}
	public BaseCitizen(int id_citizen, int id_village, String date_of_birth, String full_name, String sex,
			String countryside, String data_time) {
		super();
		this.id_citizen = id_citizen;
		this.id_village = id_village;
		this.date_of_birth = date_of_birth;
		this.full_name = full_name;
		this.sex = sex;
		this.countryside = countryside;
		this.data_time = data_time;
	}
	public BaseCitizen() {
		super();
	}
	
}
