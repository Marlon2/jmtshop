package cn.edu.zut.jmtshop.service;

import java.util.List;

import cn.edu.zut.jmtshop.entity.SubType;

public interface SubTypeService {

	int getSubTypeNums(String e_subtypename);

	List<SubType> getAllSubType(int firstRow, String e_subtypename);

	void saveOrUpdateSubType(SubType e_subType);

	SubType getSubTypeByName(String subtypename);

	SubType getSubTypeById(int e_subtypeid);

	void deleteSubType(int e_subtypeid);

	List<SubType> getSubTypesBySuperId(int e_supertypeid);

}
