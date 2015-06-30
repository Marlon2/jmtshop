package cn.edu.zut.jmtshop.service.impl;

import java.util.List;

import cn.edu.zut.jmtshop.dao.SuperTypeDao;
import cn.edu.zut.jmtshop.dao.UserListDao;
import cn.edu.zut.jmtshop.entity.SuperType;
import cn.edu.zut.jmtshop.entity.User;
import cn.edu.zut.jmtshop.service.UserService;

public class UserServiceImpl implements UserService {

	private UserListDao userListDao;
	@Override
	public List<User> getAllUsers(int firstRow) {
		
		return userListDao.findAllUsers(firstRow);
	}

	@Override
	public int getUserNums() {
		return userListDao.findUserNums();
	}

	public UserListDao getUserListDao() {
		return userListDao;
	}

	public void setUserListDao(UserListDao userListDao) {
		this.userListDao = userListDao;
	}

	@Override
	public User getUserById(int id) {
		return userListDao.getUserById( id);
	}

	
}
