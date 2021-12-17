package com.citizen.entity.compound;

public class AbstracAccount {
	
	private int id;
	private String name;
	private String user;
	private String pass;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public AbstracAccount(int id, String name, String user, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.pass = pass;
	}
	public AbstracAccount() {
		super();
	}

	
}
