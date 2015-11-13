package com.wglen.fisure;

import java.io.Serializable;

public class FIU_Expenses implements Serializable {
	private int uid;
	private int exid;
	private String exname;
	private float total;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getExid() {
		return exid;
	}
	public void setExid(int exid) {
		this.exid = exid;
	}
	public String getExname() {
		return exname;
	}
	public void setExname(String exname) {
		this.exname = exname;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
}
