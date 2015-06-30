package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.ProductDao;
import cn.edu.zut.jmtshop.entity.Product;
import cn.edu.zut.jmtshop.util.PageConstants;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	@Override
	public int getProductNums(String e_productname) {
		String sql = "select count(*) from Product where productname like '%"+e_productname+"%'";
		List list = this.getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			Long count = (Long) list.get(0);
			return count.intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts(int firstRow, String e_productname) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.like("productname", e_productname, MatchMode.ANYWHERE));
		return this.getHibernateTemplate().findByCriteria(criteria, firstRow, PageConstants.MAX_PAGESIZE);
	}

	@Override
	public void saveOrUpdateProduct(Product product) {
		this.getHibernateTemplate().saveOrUpdate(product);
	}

	@Override
	public Product getProductById(int e_productid) {
		return this.getHibernateTemplate().get(Product.class, e_productid);
	}

	@Override
	public void deleteProduct(Product p) {
		this.getHibernateTemplate().delete(p);
	}

}
