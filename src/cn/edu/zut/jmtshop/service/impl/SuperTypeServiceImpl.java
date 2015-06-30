package cn.edu.zut.jmtshop.service.impl;

import java.util.List;

import cn.edu.zut.jmtshop.dao.SuperTypeDao;
import cn.edu.zut.jmtshop.entity.SuperType;
import cn.edu.zut.jmtshop.service.SuperTypeService;

public class SuperTypeServiceImpl implements SuperTypeService {

	private SuperTypeDao superTypeDao;
	@Override
	public List<SuperType> getAllSuperType(int firstRow, String e_supertypename) {
		
		return superTypeDao.findAllSuperType(firstRow,e_supertypename);
	}
	@Override
	public SuperType getSuperType(int supertypeid) {
		return superTypeDao.findSuperType(supertypeid);
	}
	@Override
	public int getSuperTypeNums(String e_supertypename) {
		return superTypeDao.findSuperTypeNums(e_supertypename);
	}

	public SuperTypeDao getSuperTypeDao() {
		return superTypeDao;
	}

	public void setSuperTypeDao(SuperTypeDao superTypeDao) {
		this.superTypeDao = superTypeDao;
	}
	@Override
	public void updateSuperType(SuperType e_superType) {
		superTypeDao.updateSuperType(e_superType);
	}
	@Override
	public void deleteSuperType(int e_supertypeid) {
		superTypeDao.deleteSuperType(e_supertypeid);
	}
	@Override
	public SuperType getSuperType(String supertypename) {
		return superTypeDao.findSuperType(supertypename);
	}
	@Override
	public List<SuperType> getAllSuperTypes() {
		return superTypeDao.getAllSuperTypes();
	}

	

}
