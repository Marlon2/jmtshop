package cn.edu.zut.jmtshop.action;

import java.util.List;

import cn.edu.zut.jmtshop.entity.SubType;
import cn.edu.zut.jmtshop.entity.SuperType;
import cn.edu.zut.jmtshop.service.SubTypeService;
import cn.edu.zut.jmtshop.service.SuperTypeService;
import cn.edu.zut.jmtshop.util.PageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class SubTypeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<SubType> subTypes;
	List<SuperType> superTypes;
	private SubType e_subType;
	private SuperType e_superType;
	private int e_supertypeid;
	private int e_subtypeid;
	//小类所属的大类的名字
	private String e_supertypename;
	//小类的名称，用于查询
	private String e_subtypename="";
	private SubTypeService subTypeService;
	private SuperTypeService superTypeService;
	// 接受用户看的是第几页
	private int currentPage;
	private int totalPage;
	private String msg;
	private boolean msgflag = false;
	
	public String list(){
		if(msgflag){
			msgflag = false;
		}else{
			msg = "";
		}
		totalPage = (subTypeService.getSubTypeNums(e_subtypename)-1)/PageConstants.MAX_PAGESIZE+1;
		int firstRow = (currentPage-1)*PageConstants.MAX_PAGESIZE;
		subTypes = subTypeService.getAllSubType(firstRow,e_subtypename);
		return "list";
	}
	public String add(){
		System.out.println("add:"+e_supertypeid+"   "+e_subType.getSubtypename());
		SubType newSubtype = subTypeService.getSubTypeByName(e_subType.getSubtypename());
		if(newSubtype!=null){
			msgflag = true;
			msg = "该小类已经存在，添加失败！";
			return list();
		}
		e_subType.setSupertypeid(e_supertypeid);
		e_subType.setSubtypeid(0);
		subTypeService.saveOrUpdateSubType(e_subType);
		msgflag = true;
		msg = "添加成功！";
		return list();
	}
	public String save(){
		System.out.println(e_supertypeid+"   "+e_subType.getSubtypename());
		SubType newSubtype = subTypeService.getSubTypeByName(e_subType.getSubtypename());
		if(newSubtype!=null){
			msgflag = true;
			msg = "该小类已经存在，保存失败！";
			return list();
		}
		e_subType.setSupertypeid(e_supertypeid);
		subTypeService.saveOrUpdateSubType(e_subType);
		msgflag = true;
		msg = "保存成功！";
		return list();
	}
	public String edit(){
		superTypes = superTypeService.getAllSuperTypes();
		e_subType = subTypeService.getSubTypeById(e_subtypeid);
		
		return "edit";
	}
	public String allSuperTypes(){
		superTypes = superTypeService.getAllSuperTypes();
		return "allsupertypes";
	}
	public String delete(){
		subTypeService.deleteSubType(e_subtypeid);
		msgflag = true;
		msg = "删除成功！";
		return list();
	}
	public String view(){
		e_subType = subTypeService.getSubTypeById(e_subtypeid);
		SuperType e_supertype1 = superTypeService.getSuperType(e_subType.getSupertypeid());
		e_supertypename = e_supertype1.getSupertypename();
		return "view";
	}
	public List<SubType> getSubTypes() {
		return subTypes;
	}
	public void setSubTypes(List<SubType> subTypes) {
		this.subTypes = subTypes;
	}
	public SubTypeService getSubTypeService() {
		return subTypeService;
	}
	public void setSubTypeService(SubTypeService subTypeService) {
		this.subTypeService = subTypeService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

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

	public SubType getE_subType() {
		return e_subType;
	}

	public void setE_subType(SubType e_subType) {
		this.e_subType = e_subType;
	}

	public SuperType getE_superType() {
		return e_superType;
	}

	public void setE_superType(SuperType e_superType) {
		this.e_superType = e_superType;
	}

	public int getE_supertypeid() {
		return e_supertypeid;
	}

	public void setE_supertypeid(int e_supertypeid) {
		this.e_supertypeid = e_supertypeid;
	}


	public String getE_supertypename() {
		return e_supertypename;
	}

	public void setE_supertypename(String e_supertypename) {
		this.e_supertypename = e_supertypename;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getE_subtypeid() {
		return e_subtypeid;
	}

	public void setE_subtypeid(int e_subtypeid) {
		this.e_subtypeid = e_subtypeid;
	}

	public String getE_subtypename() {
		return e_subtypename;
	}

	public void setE_subtypename(String e_subtypename) {
		this.e_subtypename = e_subtypename;
	}

}
