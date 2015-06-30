package cn.edu.zut.jmtshop.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zut.jmtshop.entity.User;
import cn.edu.zut.jmtshop.entity.UserOrder;
import cn.edu.zut.jmtshop.service.UserOrderService;
import cn.edu.zut.jmtshop.service.UserService;

public class UserOrderTest {
	private ApplicationContext ac;
	private UserOrderService service;
	private UserService userService;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (UserOrderService) ac.getBean("userOrderService");
		userService = (UserService) ac.getBean("userService");
	}
	@Test
	public void add(){
		for(int i=1;i<50;i++){
			
			UserOrder order = new UserOrder();
			User user = userService.getUserById(i%2+1);
			order.setUserName(user.getUserName());
			order.setRealName(user.getTrueName());
			order.setAddress(user.getAddress());
			order.setPostCode(user.getPostCode());
			order.setPhone(user.getPhone());
			order.setOrderDate(new Date());
			order.setFlag(i%3);
			service.addUserOrder(order);
		}
	}
//	@Test
	public void delete(){
		System.out.println(service.deleteUserOrderById(2,"all"));
	}
//	@Test
	public void update(){
		UserOrder order = service.getUserOrderById(1,"all");
		order.setUserName("李四");
		System.out.println(service.updateUserOrder(order));
	}
//	@Test
	public void get(){
		System.out.println(service.getUserOrderById(1,"all").getUserName());
	}
//	@Test
	public void deleteBeach(){
		int ids[] = new int[3];
		ids[0] = 5;
		ids[1] = 3;
		ids[2] = 4;
		System.out.println(service.deleteUserOrderBeach(ids,"all"));
	}
}
