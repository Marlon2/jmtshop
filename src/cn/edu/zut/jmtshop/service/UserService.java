package cn.edu.zut.jmtshop.service;

import java.util.List;

import cn.edu.zut.jmtshop.entity.SuperType;
import cn.edu.zut.jmtshop.entity.User;

public interface UserService {
	List<User> getAllUsers(int firstRow);

	int getUserNums();

	User getUserById(int id);

}
