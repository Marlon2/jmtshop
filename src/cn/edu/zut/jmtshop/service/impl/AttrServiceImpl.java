package cn.edu.zut.jmtshop.service.impl;

import java.util.List;

import cn.edu.zut.jmtshop.dao.AttrDao;
import cn.edu.zut.jmtshop.entity.Attr;
import cn.edu.zut.jmtshop.service.AttrService;

public class AttrServiceImpl implements AttrService {

	private AttrDao attrDao;
	@Override
	public void saveOrUpdateAttr(Attr attr) {
		this.attrDao.saveOrUpdateAttr(attr);
	}
	public AttrDao getAttrDao() {
		return attrDao;
	}
	public void setAttrDao(AttrDao attrDao) {
		this.attrDao = attrDao;
	}
	@Override
	public int getAttrNums(String e_attrname) {
		return this.attrDao.getAttrNums(e_attrname);
	}
	@Override
	public List<Attr> getAllAttrs(int firstRow, String e_attrname) {
		return this.attrDao.getAllAttrs(firstRow,e_attrname);
	}
	@Override
	public void deleteAttr(int e_attrid) {
		this.attrDao.deleteAttr(e_attrid);
	}
	@Override
	public Attr getAttr(Attr attr) {
		return this.attrDao.getAttr(attr);
	}
	@Override
	public Attr getAttr(int e_attrid) {
		return this.attrDao.getAttr(e_attrid);
	}
	@Override
	public List<Attr> getAttrsBySubTypeId(int e_subtypeid) {
		return this.attrDao.getAttrsBySubTypeId(e_subtypeid);
	}

}
