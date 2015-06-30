package cn.edu.zut.jmtshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zut.jmtshop.dao.OrderItemDao;
import cn.edu.zut.jmtshop.entity.OrderItem;
import cn.edu.zut.jmtshop.service.OrderItemService;
import cn.edu.zut.jmtshop.util.PageConstants;

public class OrderItemServiceImpl implements OrderItemService {
	private OrderItemDao orderItemDao;
	
	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	@Override
	public boolean addOrderItem(OrderItem orderItem) {
		if(orderItemDao.addOrderItem(orderItem)==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteOrderItem(int id) {
		if(orderItemDao.deleteOrderItem(orderItemDao.getOrderItemById(id))==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteOrderItemBeach(int[] ids) {
		List<OrderItem> orderItems = new ArrayList<>();
		for(int id:ids){
			orderItems.add(orderItemDao.getOrderItemById(id));
		}
		if(orderItemDao.deleteOrderItemBeach(orderItems)==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateOrderItem(OrderItem orderItem) {
		if(orderItemDao.updateOrderItem(orderItem)==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public OrderItem getOrderItemById(int id) {
		return orderItemDao.getOrderItemById(id);
	}

	@Override
	public int UserOrderItemCounts(int userOrderId) {
		return orderItemDao.getUserOrderItemCounts(userOrderId);
	}

	@Override
	public List<OrderItem> getUserOrderItemPrePage(int currentPage, int userOrderId) {
		int allRows = UserOrderItemCounts(userOrderId);
		if(currentPage<1){
			return new ArrayList<OrderItem>();
		}else{			
			if(allRows-currentPage*PageConstants.MAX_PAGESIZE<0){
				return orderItemDao.getUserOrderItemPrePage((currentPage-1)*PageConstants.MAX_PAGESIZE, allRows, userOrderId);
			}else{
				return orderItemDao.getUserOrderItemPrePage((currentPage-1)*PageConstants.MAX_PAGESIZE, currentPage*PageConstants.MAX_PAGESIZE, userOrderId);
			}
		}
		
	}

}
