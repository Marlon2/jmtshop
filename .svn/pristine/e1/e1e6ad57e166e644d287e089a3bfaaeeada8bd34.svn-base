package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.SubTypeDao;
import cn.edu.zut.jmtshop.entity.SubType;
import cn.edu.zut.jmtshop.util.PageConstants;

public class SubTypeDaoImpl extends HibernateDaoSupport implements SubTypeDao {

	@Override
	public int getSubTypeNums(String e_subtypename) {
		String sql = "select count(*) from SubType where subtypename like '%" + e_subtypename + "%'";
		List list = this.getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			Long count = (Long) list.get(0);
			return count.intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubType> getAllSubType(int firstRow, String e_subtypename) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SubType.class);
		criteria.add(Restrictions.like("subtypename", e_subtypename, MatchMode.ANYWHERE));
		return this.getHibernateTemplate().findByCriteria(criteria, firstRow, PageConstants.MAX_PAGESIZE);
	}

	@Override
	public void saveOrUpdateSubType(SubType e_subType) {
		this.getHibernateTemplate().saveOrUpdate(e_subType);
	}

	@Override
	public SubType getSubTypeByName(String subtypename) {
			List list =  this.getHibernateTemplate().find("from SubType where subtypename=?", subtypename);
			if(list.size()>0){
				return (SubType) list.get(0);
			}
			return null;
	}

	@Override
	public SubType getSubTypeById(int e_subtypeid) {
		return this.getHibernateTemplate().get(SubType.class, e_subtypeid);
	}

	@Override
	public void deleteSubType(int e_subtypeid) {
		SubType entity = new SubType();
		entity.setSubtypeid(e_subtypeid);
		this.getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubType> findSubTypesBySuperId(int e_supertypeid) {
		return this.getHibernateTemplate().find("from SubType where supertypeid=?", e_supertypeid);
	}

}
