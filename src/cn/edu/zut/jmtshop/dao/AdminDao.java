package cn.edu.zut.jmtshop.dao;

import cn.edu.zut.jmtshop.entity.Admin;

public interface AdminDao {
	public Admin getAdminByNameAndPwd(String name,String pwd);
}
