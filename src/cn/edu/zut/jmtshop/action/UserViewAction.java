package cn.edu.zut.jmtshop.action;

import cn.edu.zut.jmtshop.entity.User;
import cn.edu.zut.jmtshop.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserViewAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;
	private int id;
	private UserService userService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		user = this.userService.getUserById(id);
		return super.execute();
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
