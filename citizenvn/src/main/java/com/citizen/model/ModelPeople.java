package com.citizen.model;

public class ModelPeople {
	
	private String cmnd;
	private String hoten;
	private String ngaysinh;
	private String gioitinh;
	private String dantoc;
	private String nghenghiep;
	private String quequan;
	private String tamtru;
	private String thuongtru;
	private String tongiao;
	private String trinhdohv;
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDantoc() {
		return dantoc;
	}
	public void setDantoc(String dantoc) {
		this.dantoc = dantoc;
	}
	public String getNghenghiep() {
		return nghenghiep;
	}
	public void setNghenghiep(String nghenghiep) {
		this.nghenghiep = nghenghiep;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	public String getTamtru() {
		return tamtru;
	}
	public void setTamtru(String tamtru) {
		this.tamtru = tamtru;
	}
	public String getThuongtru() {
		return thuongtru;
	}
	public void setThuongtru(String thuongtru) {
		this.thuongtru = thuongtru;
	}
	public String getTongiao() {
		return tongiao;
	}
	public void setTongiao(String tongiao) {
		this.tongiao = tongiao;
	}
	public String getTrinhdohv() {
		return trinhdohv;
	}
	public void setTrinhdohv(String trinhdohv) {
		this.trinhdohv = trinhdohv;
	}
	public ModelPeople(String cmnd, String hoten, String ngaysinh, String gioitinh, String dantoc,
			String nghenghiep, String quequan, String tamtru, String thuongtru, String tongiao, String trinhdohv) {
		super();
		this.cmnd = cmnd;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.dantoc = dantoc;
		this.nghenghiep = nghenghiep;
		this.quequan = quequan;
		this.tamtru = tamtru;
		this.thuongtru = thuongtru;
		this.tongiao = tongiao;
		this.trinhdohv = trinhdohv;
	}
	public ModelPeople() {
		super();
	}

}
