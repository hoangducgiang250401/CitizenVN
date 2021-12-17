package com.citizen.entity.compound;

public class Account extends AbstracAccount {

	public Account() {
		super();
	}

	public Account(int id, String name, String user, String pass) {
		super(id, name, user, pass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [getName()=" + getName() + ", getId()=" + getId() + ", getUser()=" + getUser() + ", getPass()="
				+ getPass() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
