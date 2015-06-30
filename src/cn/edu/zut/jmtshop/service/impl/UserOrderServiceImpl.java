package cn.edu.zut.jmtshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zut.jmtshop.dao.UserOrderDao;
import cn.edu.zut.jmtshop.entity.UserOrder;
import cn.edu.zut.jmtshop.service.UserOrderService;
import cn.edu.zut.jmtshop.util.PageConstants;

public class UserOrderServiceImpl implements UserOrderService {
	private UserOrderDao userOrderDao;

	public UserOrderDao getUserOrderDao() {
		return userOrderDao;
	}

	public void setUserOrderDao(UserOrderDao userOrderDao) {
		this.userOrderDao = userOrderDao;
	}

	@Override
	public boolean addUserOrder(UserOrder userOrder) {
		if(userOrderDao.addUserOrder(userOrder)>0){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean deleteUserOrderById(int id,String orderFlag) {
		if(userOrderDao.deleteUserOrder(userOrderDao.getUserOrderById(id,orderFlag))>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateUserOrder(UserOrder userOrder) {
		if(userOrderDao.updateUserOrder(userOrder)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public UserOrder getUserOrderById(int id,String orderFlag) {
		return userOrderDao.getUserOrderById(id,orderFlag);
	}

	@Override
	public boolean deleteUserOrderBeach(int ids[],String orderFlag) {
		List<UserOrder> userOrders = new ArrayList<UserOrder>();
		for(int id:ids){
			userOrders.add(userOrderDao.getUserOrderById(id,orderFlag));
		}
		if(userOrderDao.deleteUserOrderBeach(userOrders)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int getAllRows(String orderFlag) {
		return userOrderDao.getUserOrderCounts(orderFlag);
	}

	@Override
	public List<UserOrder> getUserOrdersPrePage(int currentPrePage,String orderFlag) {
		
		return userOrderDao.getUserOrderPrePage((currentPrePage-1)*PageConstants.MAX_PAGESIZE, PageConstants.MAX_PAGESIZE,orderFlag);
	}

//	@Override
//	public PageBean<UserOrder> setPageBean(int currentPage) {
//		PageBean<UserOrder> pageBean = new PageBean<UserOrder>();
//		pageBean.setMaxCountsPrePage(PageConstants.MAX_PAGESIZE);
//		pageBean.setCurrentPageNum(currentPage);
//		pageBean.setAllPageCounts(userOrderDao.getUserOrderCounts());
//		pageBean.setList(userOrderDao.getUserOrderPrePage((currentPage-1)*PageConstants.MAX_PAGESIZE, PageConstants.MAX_PAGESIZE));
//		return pageBean;
//	}

}
