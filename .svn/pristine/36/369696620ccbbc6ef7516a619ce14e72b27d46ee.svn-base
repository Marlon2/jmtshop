package cn.edu.zut.jmtshop.action;

import java.util.List;

import cn.edu.zut.jmtshop.entity.Attr;
import cn.edu.zut.jmtshop.entity.SuperType;
import cn.edu.zut.jmtshop.service.AttrService;
import cn.edu.zut.jmtshop.service.SuperTypeService;
import cn.edu.zut.jmtshop.util.PageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class AttrAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Attr attr;
	//删除用
	private int e_attrid;
	//查找用
	private String e_attrname="";
	//从客户端穿过来的大类id，找到相应的小类
	
	private List<Attr> attrs;
	private List<SuperType> superTypes;
	
	private SuperTypeService superTypeService;
	
	private AttrService attrService;
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
		totalPage = (attrService.getAttrNums(e_attrname)-1)/PageConstants.MAX_PAGESIZE+1;
		int firstRow = (currentPage-1)*PageConstants.MAX_PAGESIZE;
		attrs = attrService.getAllAttrs(firstRow, e_attrname);
//		System.out.println(totalPage+"-----"+firstRow+"----"+attrs.size()+"---"+e_attrname);
		return "list";
	}
	public String getAllSuperTypes(){
		superTypes = superTypeService.getAllSuperTypes();
		return "allsupertypes";
	}
	public String add(){
		System.out.println("attrvalue:"+attr.getAttrvalue().replaceAll("\r\n", "#"));
		attr.setAttrvalue(attr.getAttrvalue().replaceAll("\r\n", "#"));
		Attr attr1 = attrService.getAttr(attr);
		if(attr1!=null){
			msgflag = true;
			msg = "该属性已经存在，添加失败！";
			return list();
		}
		attr.setAttrid(0);
		attrService.saveOrUpdateAttr(attr);
		msgflag = true;
		msg = "添加成功！";
		return list();
	}
	
	public String save(){
		attr.setAttrvalue(attr.getAttrvalue().replaceAll("\r\n", "#"));
		Attr attr1 = attrService.getAttr(attr);
		if(attr1!=null){
			msgflag = true;
			msg = "该属性已经存在，保存失败！";
			return list();
		}
		attrService.saveOrUpdateAttr(attr);
		return list();
	}
	
	public String delete(){
		attrService.deleteAttr(e_attrid);
		msgflag = true;
		msg = "删除成功！";
		return list();
	}
	public String edit(){
		attr = attrService.getAttr(e_attrid);
		superTypes = superTypeService.getAllSuperTypes();
		
		return list();
	}
	
	public List<SuperType> getSuperTypes() {
		return superTypes;
	}

	public void setSuperTypes(List<SuperType> superTypes) {
		this.superTypes = superTypes;
	}
	
	//@JSON(serialize=false)
	public SuperTypeService getSuperTypeService() {
		return superTypeService;
	}
	public void setSuperTypeService(SuperTypeService superTypeService) {
		this.superTypeService = superTypeService;
	}

	public Attr getAttr() {
		return attr;
	}
	public void setAttr(Attr attr) {
		this.attr = attr;
	}
	//@JSON(serialize=false)
	public AttrService getAttrService() {
		return attrService;
	}
	public void setAttrService(AttrService attrService) {
		this.attrService = attrService;
	}
	public List<Attr> getAttrs() {
		return attrs;
	}
	public void setAttrs(List<Attr> attrs) {
		this.attrs = attrs;
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getE_attrname() {
		return e_attrname;
	}
	public void setE_attrname(String e_attrname) {
		this.e_attrname = e_attrname;
	}
	public int getE_attrid() {
		return e_attrid;
	}
	public void setE_attrid(int e_attrid) {
		this.e_attrid = e_attrid;
	}

}
