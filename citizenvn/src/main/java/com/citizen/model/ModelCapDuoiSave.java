package com.citizen.model;

public class ModelCapDuoiSave {
	private String name;
	private String code;
	private String codeNew;
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
	public String getCodeNew() {
		return codeNew;
	}
	public void setCodeNew(String codeNew) {
		this.codeNew = codeNew;
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
	public ModelCapDuoiSave(String name, String code, String codeNew, String pass, String startTime, String endTime) {
		super();
		this.name = name;
		this.code = code;
		this.codeNew = codeNew;
		this.pass = pass;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public ModelCapDuoiSave() {
		super();
	}
	@Override
	public String toString() {
		return "ModelCapDuoiSave [name=" + name + ", code=" + code + ", codeNew=" + codeNew + ", pass=" + pass
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
