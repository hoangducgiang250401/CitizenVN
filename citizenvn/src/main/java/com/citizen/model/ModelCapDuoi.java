package com.citizen.model;

public class ModelCapDuoi {
	private String name;
	private String code;
	private String pass;
	private String startTime;
	private String endTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public ModelCapDuoi(String name, String code, String pass, String startTime, String endTime) {
		super();
		this.name = name;
		this.code = code;
		this.pass = pass;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public ModelCapDuoi() {
		super();
	}
	@Override
	public String toString() {
		return "ModelCapDuoi [name=" + name + ", code=" + code + ", pass=" + pass + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
}
