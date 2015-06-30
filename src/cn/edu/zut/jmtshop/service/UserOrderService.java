package cn.edu.zut.jmtshop.service;



import java.util.List;

import cn.edu.zut.jmtshop.entity.UserOrder;

public interface UserOrderService {
	public boolean addUserOrder(UserOrder userOrder);
	public boolean deleteUserOrderById(int id,String orderFlag);
	public boolean updateUserOrder(UserOrder userOrder);
	public UserOrder getUserOrderById(int id,String orderFlag);
	public boolean deleteUserOrderBeach(int ids[],String orderFlag);
	public int getAllRows(String orderFlag);
	public List<UserOrder> getUserOrdersPrePage(int currentPrePage,String orderFlag);
}
