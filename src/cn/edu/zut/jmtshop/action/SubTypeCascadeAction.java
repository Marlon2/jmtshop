package cn.edu.zut.jmtshop.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.json.annotations.JSON;

import cn.edu.zut.jmtshop.entity.Attr;
import cn.edu.zut.jmtshop.entity.SubType;
import cn.edu.zut.jmtshop.entity.SuperType;
import cn.edu.zut.jmtshop.service.AttrService;
import cn.edu.zut.jmtshop.service.SubTypeService;
import cn.edu.zut.jmtshop.service.SuperTypeService;

import com.opensymphony.xwork2.ActionSupport;

public class SubTypeCascadeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int e_supertypeid;
	private int e_subtypeid;
	private List<SuperType> superTypes;
	private List<SubType> subTypes;
	private List<Attr> attrs1;
	
	private SuperTypeService superTypeService;
	private SubTypeService subTypeService;
	private AttrService attrService;
	
	public String getAllSuperTypes(){
		superTypes = superTypeService.getAllSuperTypes();
		return "supertypes";
	}
	public String getFrontAllSuperTypes(){
		superTypes = superTypeService.getAllSuperTypes();
		return "frontsupertypes";
	}
	public String getAttrs() throws IOException {
		attrs1 = attrService.getAttrsBySubTypeId(e_subtypeid);
		try {
			JSONUtil.serialize(attrs1);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "json";
	}
	public String getSubType() throws IOException {
		subTypes = subTypeService.getSubTypesBySuperId(e_supertypeid);
		try {
			JSONUtil.serialize(subTypes);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "json";
	}
	
	@JSON(serialize=false)
	public AttrService getAttrService() {
		return attrService;
	}
	public void setAttrService(AttrService attrService) {
		this.attrService = attrService;
	}
	public int getE_subtypeid() {
		return e_subtypeid;
	}
	public void setE_subtypeid(int e_subtypeid) {
		this.e_subtypeid = e_subtypeid;
	}
	public List<Attr> getAttrs1() {
		return attrs1;
	}
	public void setAttrs1(List<Attr> attrs1) {
		this.attrs1 = attrs1;
	}
	@JSON(serialize=false)
	public SuperTypeService getSuperTypeService() {
		return superTypeService;
	}
	public void setSuperTypeService(SuperTypeService superTypeService) {
		this.superTypeService = superTypeService;
	}
	public List<SuperType> getSuperTypes() {
		return superTypes;
	}
	public void setSuperTypes(List<SuperType> superTypes) {
		this.superTypes = superTypes;
	}
	public List<SubType> getSubTypes() {
		return subTypes;
	}
	public void setSubTypes(List<SubType> subTypes) {
		this.subTypes = subTypes;
	}
	@JSON(serialize=false)
	public SubTypeService getSubTypeService() {
		return subTypeService;
	}
	public void setSubTypeService(SubTypeService subTypeService) {
		this.subTypeService = subTypeService;
	}

	public int getE_supertypeid() {
		return e_supertypeid;
	}

	public void setE_supertypeid(int e_supertypeid) {
		this.e_supertypeid = e_supertypeid;
	}
}
