package cn.edu.zut.jmtshop.dao;

import java.util.List;

import cn.edu.zut.jmtshop.entity.OrderItem;

public interface OrderItemDao {
	public int addOrderItem(OrderItem orderItem);
	public int deleteOrderItem(OrderItem orderItem);
	public int deleteOrderItemBeach(List<OrderItem> orderItems);
	public int updateOrderItem(OrderItem orderItem);
	public OrderItem getOrderItemById(int id);
	public List<OrderItem> getUserOrderItemByOrderId(int orderId);
	public int getUserOrderItemCounts(int userOrderId);
	public List<OrderItem> getUserOrderItemPrePage(int firstNum,int endNum,int userOrderId);
}
