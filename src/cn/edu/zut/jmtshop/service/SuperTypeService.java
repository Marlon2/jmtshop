package cn.edu.zut.jmtshop.service;

import java.util.List;

import cn.edu.zut.jmtshop.entity.SuperType;

public interface SuperTypeService {

	List<SuperType> getAllSuperType(int firstRow, String e_supertypename);
	List<SuperType> getAllSuperTypes();
	int getSuperTypeNums(String e_supertypename);

	SuperType getSuperType(int supertypeid);
	SuperType getSuperType(String supertypename);

	void updateSuperType(SuperType e_superType);

	void deleteSuperType(int e_supertypeid);


}
