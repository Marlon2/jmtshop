package cn.edu.zut.jmtshop.service;

import java.util.List;

import cn.edu.zut.jmtshop.entity.OrderItem;

public interface OrderItemService {
	public boolean addOrderItem(OrderItem orderItem);
	public boolean deleteOrderItem(int id);
	public boolean deleteOrderItemBeach(int[] ids);
	public boolean updateOrderItem(OrderItem orderItem);
	public OrderItem getOrderItemById(int id);
	public int UserOrderItemCounts(int userOrderId);
	public List<OrderItem> getUserOrderItemPrePage(int currentPage, int userOrderId); 
}
