package cn.edu.zut.jmtshop.dao;

import java.util.List;

import cn.edu.zut.jmtshop.entity.SuperType;
import cn.edu.zut.jmtshop.entity.User;

public interface UserListDao {
	List<User> findAllUsers(int firstRow);

	int findUserNums();

	User getUserById(int id);
}
