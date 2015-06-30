package cn.edu.zut.jmtshop.dao;

import java.util.List;

import cn.edu.zut.jmtshop.entity.UserOrder;

public interface UserOrderDao {
	public int addUserOrder(UserOrder userOrder);
	public int deleteUserOrder(UserOrder userOrder);
	public int updateUserOrder(UserOrder userOrder);
	public UserOrder getUserOrderById(int id,String orderFlag);
	public int getUserOrderCounts(String orderFlag);
	public List<UserOrder> getUserOrderPrePage(int firstNum,int maxNumPrePage,String orderFlag);
	public int deleteUserOrderBeach(List<UserOrder> userOrders);
}
