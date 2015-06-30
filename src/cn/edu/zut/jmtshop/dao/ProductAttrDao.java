package cn.edu.zut.jmtshop.dao;

import cn.edu.zut.jmtshop.entity.ProductAttr;

public interface ProductAttrDao {

	void saveOrUpdateProAttr(ProductAttr productAttr);

	void deleteByPid(int productid);

}
