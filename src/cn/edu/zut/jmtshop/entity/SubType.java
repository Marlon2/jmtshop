package cn.edu.zut.jmtshop.entity;

import java.io.Serializable;

public class SubType implements Serializable {

	private static final long serialVersionUID = 1L;

	private int subtypeid;
	private int supertypeid;
	private String subtypename;
	
	public int getSubtypeid() {
		return subtypeid;
	}
	public void setSubtypeid(int subtypeid) {
		this.subtypeid = subtypeid;
	}
	public String getSubtypename() {
		return subtypename;
	}
	public void setSubtypename(String subtypename) {
		this.subtypename = subtypename;
	}
	public int getSupertypeid() {
		return supertypeid;
	}
	public void setSupertypeid(int supertypeid) {
		this.supertypeid = supertypeid;
	}
}
