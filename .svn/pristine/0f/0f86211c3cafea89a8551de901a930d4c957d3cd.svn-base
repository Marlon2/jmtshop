package cn.edu.zut.jmtshop.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zut.jmtshop.entity.OrderItem;
import cn.edu.zut.jmtshop.service.OrderItemService;
import cn.edu.zut.jmtshop.service.ProductService;
import cn.edu.zut.jmtshop.service.UserOrderService;

public class OrderItemTest {
	private ApplicationContext ac;
	private OrderItemService itemService;
	private ProductService productService;
	private UserOrderService service;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		itemService = (OrderItemService) ac.getBean("orderItemService");
		service = (UserOrderService) ac.getBean("userOrderService");
		productService = (ProductService) ac.getBean("productService");
	}
	@Test
	public void add(){
		for(int j=1;j<10;j++){			
			for(int i=1;i<50;i++){
				
				OrderItem item = new OrderItem();
				item.setUserOrder(service.getUserOrderById(i,"all"));
				item.setProduct(productService.getProductById(i%2+1));
				item.setProductName(productService.getProductById(i%2+1).getProductname());
				item.setPrice(i);
				item.setProductNum(i%5+1);
				itemService.addOrderItem(item);
			}
		}
	}
//	@Test
	public void delete(){
		System.out.println(itemService.deleteOrderItem(3));
	}
//	@Test
	public void deleteBeach(){
		int[] ids = new int[3];
		ids[0] = 5;
		ids[1] = 6;
		ids[2] = 7;
		System.out.println(itemService.deleteOrderItemBeach(ids));
	}
//	@Test
	public void getCounts(){
		System.out.println(itemService.UserOrderItemCounts(6));
	}
//	@Test
	public void page(){
		System.out.println(itemService.getUserOrderItemPrePage(1,6).get(2).getOrderItemId());
	}
}
