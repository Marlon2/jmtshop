package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.AdminDao;
import cn.edu.zut.jmtshop.entity.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@SuppressWarnings("unchecked")
	@Override
	public Admin getAdminByNameAndPwd(String name, String pwd) {
		try {
			List<Admin> admins = this.getHibernateTemplate().find("from Admin where userName = ? and userPassword = ?",name,pwd);
			if(admins.isEmpty()){
				return null;
			}else{
				return admins.get(0);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
