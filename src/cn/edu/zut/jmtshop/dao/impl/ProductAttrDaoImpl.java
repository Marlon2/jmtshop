package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.ProductAttrDao;
import cn.edu.zut.jmtshop.entity.ProductAttr;

public class ProductAttrDaoImpl extends HibernateDaoSupport implements ProductAttrDao {

	@Override
	public void saveOrUpdateProAttr(ProductAttr productAttr) {
		this.getHibernateTemplate().save(productAttr);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteByPid(int productid) {
		List<ProductAttr> list = this.getHibernateTemplate().find("from ProductAttr where productid=?", productid);
		this.getHibernateTemplate().deleteAll(list);
	}

}
