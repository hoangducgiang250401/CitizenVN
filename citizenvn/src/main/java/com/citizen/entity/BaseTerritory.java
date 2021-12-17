package com.citizen.entity;

public class BaseTerritory {

	private String name;
	private double area;
	private String pass;
	private String code;
	private int permit;
	private int id_superior;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPermit() {
		return permit;
	}

	public void setPermit(int permit) {
		this.permit = permit;
	}

	public int getId_superior() {
		return id_superior;
	}

	public void setId_superior(int id_superior) {
		this.id_superior = id_superior;
	}

	public BaseTerritory(String name, double area, String pass, String code, int permit, int id_superior) {
		super();
		this.name = name;
		this.area = area;
		this.pass = pass;
		this.code = code;
		this.permit = permit;
		this.id_superior = id_superior;
	}

	public BaseTerritory() {
		super();
	}

	@Override
	public String toString() {
		return "BaseTerritory [name=" + name + ", area=" + area + ", pass=" + pass + ", code=" + code + ", permit="
				+ permit + ", id_superior=" + id_superior + "]";
	}
	
}
