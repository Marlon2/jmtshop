package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.UserListDao;
import cn.edu.zut.jmtshop.entity.User;
import cn.edu.zut.jmtshop.util.PageConstants;

public class UserListDaoImpl extends HibernateDaoSupport implements UserListDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers(int firstRow) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		return this.getHibernateTemplate().findByCriteria(criteria, firstRow, PageConstants.MAX_PAGESIZE);
	}

	@Override
	public int findUserNums() {
		try {
			Long count = (Long) this.getHibernateTemplate().find("select count(*) from User").get(0);
			return count.intValue();
		} catch (Exception e) {
//			e.printStackTrace();
			return 0;
		}
	
	}

	@Override
	public User getUserById(int id) {
		return this.getHibernateTemplate().get(User.class, id);
	}
}

	