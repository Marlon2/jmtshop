package cn.edu.zut.jmtshop.action;

import java.util.List;



import cn.edu.zut.jmtshop.entity.User;
import cn.edu.zut.jmtshop.service.UserService;
import cn.edu.zut.jmtshop.util.PageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport {
	/**
	 * 查看用户
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private UserService userService;
	//接受用户看的是第几页
	private int currentPage;
	@Override
	public String execute() throws Exception {
		totalPage = (userService.getUserNums()-1)/PageConstants.MAX_PAGESIZE+1;
		int firstRow = (currentPage-1)*PageConstants.MAX_PAGESIZE;
		users = userService.getAllUsers(firstRow);
		
		
		return super.execute();
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	private int totalPage;
}
