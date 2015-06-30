package cn.edu.zut.jmtshop.entity;

import java.io.Serializable;

public class Attr implements Serializable {

	private static final long serialVersionUID = 1L;

	private int attrid;
	private String attrname;
	private int attrtype; 
	private String attrvalue;
	private int subtypeid;
	
	public int getAttrid() {
		return attrid;
	}
	public void setAttrid(int attrid) {
		this.attrid = attrid;
	}
	public String getAttrname() {
		return attrname;
	}
	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}
	public int getAttrtype() {
		return attrtype;
	}
	public void setAttrtype(int attrtype) {
		this.attrtype = attrtype;
	}
	public String getAttrvalue() {
		return attrvalue;
	}
	public void setAttrvalue(String attrvalue) {
		this.attrvalue = attrvalue;
	}
	public int getSubtypeid() {
		return subtypeid;
	}
	public void setSubtypeid(int subtypeid) {
		this.subtypeid = subtypeid;
	}
	
}
