package cn.edu.zut.jmtshop.service.impl;

import cn.edu.zut.jmtshop.dao.AdminDao;
import cn.edu.zut.jmtshop.entity.Admin;
import cn.edu.zut.jmtshop.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin loginAdmin(Admin admin) {		
		return adminDao.getAdminByNameAndPwd(admin.getUserName(), admin.getUserPassword());
	}   
}
