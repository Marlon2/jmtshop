package cn.edu.zut.jmtshop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.OrderItemDao;
import cn.edu.zut.jmtshop.dao.UserOrderDao;
import cn.edu.zut.jmtshop.entity.OrderItem;
import cn.edu.zut.jmtshop.entity.UserOrder;

public class UserOrderDaoImpl extends HibernateDaoSupport implements
		UserOrderDao {
	private OrderItemDao orderItemDao;
	
	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}
	/**
	 * 添加订单
	 * */
	@Override
	public int addUserOrder(UserOrder userOrder) {
		try {
			return (Integer) this.getHibernateTemplate().save(userOrder);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 删除单个订单
	 * */
	@Override
	public int deleteUserOrder(UserOrder userOrder) {
		try {
			//删除订单前先删除订单项
			List<OrderItem> orderItems = orderItemDao.getUserOrderItemByOrderId(userOrder.getOrderId());
			if(orderItems.isEmpty()){
				this.getHibernateTemplate().delete(userOrder);
			}else{				
				orderItemDao.deleteOrderItemBeach(orderItems);
				this.getHibernateTemplate().delete(userOrder);
			}
			return 1;				
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 修改订单
	 * */
	@Override
	public int updateUserOrder(UserOrder userOrder) {
		try {
			this.getHibernateTemplate().update(userOrder);
			return 1;	
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 通过订单号查询订单
	 * */
	@Override
	public UserOrder getUserOrderById(int id,String orderFlag) {
		try {
		if(orderFlag.equals("all")){
			@SuppressWarnings("unchecked")
			List<UserOrder> userOrders = this.getHibernateTemplate().find("from UserOrder where orderId = ?", id);
			if(userOrders.isEmpty()){
				return null;
			}else{			
				return userOrders.get(0);
			}
		}else if(orderFlag.equals("0")){
			@SuppressWarnings("unchecked")
			List<UserOrder> userOrders = this.getHibernateTemplate().find("from UserOrder where orderId = ?  and flag=0", id);
			if(userOrders.isEmpty()){
				return null;
			}else{			
				return userOrders.get(0);
			}
			
		}else if(orderFlag.equals("1")){
			@SuppressWarnings("unchecked")
			List<UserOrder> userOrders = this.getHibernateTemplate().find("from UserOrder where orderId = ?  and flag=1", id);
			if(userOrders.isEmpty()){
				return null;
			}else{			
				return userOrders.get(0);
			}
		}else if(orderFlag.equals("2")){
			@SuppressWarnings("unchecked")
			List<UserOrder> userOrders = this.getHibernateTemplate().find("from UserOrder where orderId = ?  and flag=2", id);
			if(userOrders.isEmpty()){
				return null;
			}else{			
				return userOrders.get(0);
			}
		}else{
			return null;
		}
		} catch (DataAccessException e) {
			e.printStackTrace();
            return null;
		}
	}
	/**
	 * 获取总记录数
	 * */
	@Override
	public int getUserOrderCounts(String orderFlag) {
			try {
				if(orderFlag.equals("all")){
					Long allCounts = (Long) this.getHibernateTemplate().find("select count(*) from UserOrder").get(0);
					return allCounts.intValue();
				}else if(orderFlag.equals("0")){
					Long allCounts = (Long) this.getHibernateTemplate().find("select count(*) from UserOrder where flag=0").get(0);
					return allCounts.intValue();
				}else if(orderFlag.equals("1")){
					Long allCounts = (Long) this.getHibernateTemplate().find("select count(*) from UserOrder where flag=1").get(0);
					return allCounts.intValue();
				}else if(orderFlag.equals("2")){
					Long allCounts = (Long) this.getHibernateTemplate().find("select count(*) from UserOrder where flag=2").get(0);
					return allCounts.intValue();
				}else{
					return 0;
				}
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			    return 0;	
			}
		
	}
	/**
	 * 获取每页记录列表
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserOrder> getUserOrderPrePage(int firstNum, int maxNumPrePage,String orderFlag) {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(UserOrder.class);
			if(orderFlag.equals("all")){
				return this.getHibernateTemplate().findByCriteria(criteria, firstNum, maxNumPrePage);
			}else if(orderFlag.equals("0")){
				criteria.add(Restrictions.eq("flag", 0));
				return this.getHibernateTemplate().findByCriteria(criteria, firstNum, maxNumPrePage);
			}else if(orderFlag.equals("1")){
				criteria.add(Restrictions.eq("flag", 1));
				return this.getHibernateTemplate().findByCriteria(criteria, firstNum, maxNumPrePage);
			}else if(orderFlag.equals("2")){
				criteria.add(Restrictions.eq("flag", 2));
				return this.getHibernateTemplate().findByCriteria(criteria, firstNum, maxNumPrePage);
			}else{
				return null;
			}		
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
/**
 * 批量删除
 * */
	@Override
	public int deleteUserOrderBeach(List<UserOrder> userOrders) {
		try {
			//删除订单前先清空各订单下的订单项
			List<OrderItem> orderItems = new ArrayList<>();
			for(UserOrder userOrder : userOrders){
				orderItems.addAll(orderItemDao.getUserOrderItemByOrderId(userOrder.getOrderId()));
			}
			if(orderItems.isEmpty()){				
				this.getHibernateTemplate().deleteAll(userOrders);
			}else{
				orderItemDao.deleteOrderItemBeach(orderItems);
				this.getHibernateTemplate().deleteAll(userOrders);
			}
			return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
