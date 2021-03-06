package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.AttrDao;
import cn.edu.zut.jmtshop.entity.Attr;
import cn.edu.zut.jmtshop.util.PageConstants;

public class AttrDaoImpl extends HibernateDaoSupport implements AttrDao {

	@Override
	public void saveOrUpdateAttr(Attr attr) {
		this.getHibernateTemplate().saveOrUpdate(attr);
	}

	@Override
	public int getAttrNums(String e_attrname) {
		String sql = "select count(*) from Attr where attrname like '%"+e_attrname+"%'";
		List list = this.getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			Long count = (Long) list.get(0);
			return count.intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attr> getAllAttrs(int firstRow, String e_attrname) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Attr.class);
		criteria.add(Restrictions.like("attrname", e_attrname, MatchMode.ANYWHERE));
		return this.getHibernateTemplate().findByCriteria(criteria, firstRow, PageConstants.MAX_PAGESIZE);
	}

	@Override
	public void deleteAttr(int e_attrid) {
		Attr entity = new Attr();
		entity.setAttrid(e_attrid);
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public Attr getAttr(Attr attr) {
		String sql = "from Attr where attrname like '"+attr.getAttrname()+"' and subtypeid="+attr.getSubtypeid();
		List list = this.getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			return (Attr) list.get(0);
		}
		return null;
	}

	@Override
	public Attr getAttr(int e_attrid) {
		List list = this.getHibernateTemplate().find("select count(*) from Attr where attrid =?", e_attrid);
		if(list.size()>0){
			return (Attr) list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attr> getAttrsBySubTypeId(int e_subtypeid) {
		return this.getHibernateTemplate().find("from Attr where subtypeid=?",e_subtypeid);
	}

}
