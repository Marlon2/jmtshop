package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.OrderItemDao;
import cn.edu.zut.jmtshop.entity.OrderItem;

public class OrderItemDaoImpl extends HibernateDaoSupport implements
		OrderItemDao {

	@Override
	public int addOrderItem(OrderItem orderItem) {
		try {
			return (Integer) this.getHibernateTemplate().save(orderItem);
		} catch (DataAccessException e) {
			e.printStackTrace();
            return 0;
            }
	}

	@Override
	public int deleteOrderItem(OrderItem orderItem) {
		try {
			 this.getHibernateTemplate().delete(orderItem);
			 return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
            return 0;
            }
	}

	@Override
	public int deleteOrderItemBeach(List<OrderItem> orderItems) {
		try {
			 this.getHibernateTemplate().deleteAll(orderItems);
			 return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
           return 0;
           }
	}

	@Override
	public int updateOrderItem(OrderItem orderItem) {
		try {
			 this.getHibernateTemplate().update(orderItem);
			 return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
           return 0;
           }
	}

	@Override
	public OrderItem getOrderItemById(int id) {
		try {
			return this.getHibernateTemplate().get(OrderItem.class, id);
		} catch (DataAccessException e) {
			e.printStackTrace();
           return null;
           }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> getUserOrderItemByOrderId(int orderId) {
		try {
			return this.getHibernateTemplate().find("from OrderItem as model where model.userOrder.orderId=?",orderId);	     
		} catch (DataAccessException e) {
			e.printStackTrace();
           return null;
           }
	}

	@Override
	public int getUserOrderItemCounts(int userOrderId) {
		try {
			Long rows = (Long) this.getHibernateTemplate().find("select count(*) from OrderItem where userOrder.orderId=?",userOrderId).get(0);
		    return rows.intValue();
		} catch (DataAccessException e) {
			e.printStackTrace();
           return 0;
           }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> getUserOrderItemPrePage(int firstNum,
			int endNum, int userOrderId) {
		try {
			return this.getHibernateTemplate().find("from OrderItem as model where model.userOrder.orderId=?",userOrderId).subList(firstNum, endNum);	     
		} catch (DataAccessException e) {
			e.printStackTrace();
           return null;
           }
	}

}
