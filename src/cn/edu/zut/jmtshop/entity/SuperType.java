package cn.edu.zut.jmtshop.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SuperType implements Serializable {

	private static final long serialVersionUID = 1L;

	private int supertypeid;
	private String supertypename;
	private Set<SubType> subTypes= new HashSet<>();
	
	public int getSupertypeid() {
		return supertypeid;
	}
	public void setSupertypeid(int supertypeid) {
		this.supertypeid = supertypeid;
	}
	public String getSupertypename() {
		return supertypename;
	}
	public void setSupertypename(String supertypename) {
		this.supertypename = supertypename;
	}
	public Set<SubType> getSubTypes() {
		return subTypes;
	}
	public void setSubTypes(Set<SubType> subTypes) {
		this.subTypes = subTypes;
	}
}
