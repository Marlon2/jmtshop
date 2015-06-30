package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.SuperTypeDao;
import cn.edu.zut.jmtshop.entity.SuperType;
import cn.edu.zut.jmtshop.util.PageConstants;

public class SuperTypeDaoImpl extends HibernateDaoSupport implements SuperTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SuperType> findAllSuperType(int firstRow, String e_supertypename) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SuperType.class);
		criteria.add(Restrictions.like("supertypename", e_supertypename, MatchMode.ANYWHERE));
		return this.getHibernateTemplate().findByCriteria(criteria, firstRow, PageConstants.MAX_PAGESIZE);
	}

	@Override
	public int findSuperTypeNums(String e_supertypename) {
		String sql = "select count(*) from SuperType where supertypename like '%"+e_supertypename+"%'";
		List list = this.getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			Long count = (Long) list.get(0);
			return count.intValue();
		}
		return 0;
	}

	@Override
	public SuperType findSuperType(int supertypeid) {
		return this.getHibernateTemplate().get(SuperType.class, supertypeid);
	}

	@Override
	public void updateSuperType(SuperType e_superType) {
//		System.out.println(e_superType.getSupertypeid()+"---"+e_superType.getSupertypename());
		this.getHibernateTemplate().saveOrUpdate(e_superType);
	}

	@Override
	public void deleteSuperType(int e_supertypeid) {
		SuperType e_superType = new SuperType();
		e_superType.setSupertypeid(e_supertypeid);
		this.getHibernateTemplate().delete(e_superType);
		
	}

	@Override
	public SuperType findSuperType(String supertypename) {
		List list = this.getHibernateTemplate().find("from SuperType where supertypename=?", supertypename);
		if (list.size() > 0) {
			return (SuperType) list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SuperType> getAllSuperTypes() {
		return this.getHibernateTemplate().find("from SuperType where 1=1");
	}

}
