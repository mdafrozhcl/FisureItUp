package com.wglen.fisure;

import java.io.Serializable;

public class FIU_Split implements Serializable  {
private int exid;
private int uid;
private float splittedTotal;
public int getExid() {
	return exid;
}
public void setExid(int exid) {
	this.exid = exid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public float getSplittedTotal() {
	return splittedTotal;
}
public void setSplittedTotal(float splittedTotal) {
	this.splittedTotal = splittedTotal;
}

}
