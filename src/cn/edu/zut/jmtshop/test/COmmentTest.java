package cn.edu.zut.jmtshop.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zut.jmtshop.entity.Comment;
import cn.edu.zut.jmtshop.entity.Product;
import cn.edu.zut.jmtshop.service.CommentService;
import cn.edu.zut.jmtshop.service.ProductService;
import cn.edu.zut.jmtshop.service.UserService;

public class COmmentTest {
	private ApplicationContext ac;
	private CommentService commentService;
	private ProductService productService;
	private UserService userService;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		commentService = (CommentService) ac.getBean("commentService");
		productService = (ProductService) ac.getBean("productService");
		userService = (UserService) ac.getBean("userService");
	}
	@Test
	public void add(){
		for(int i = 1;i<30;i++){
			Comment comment = new Comment();
			comment.setCtitle("title"+i);
			comment.setUser(userService.getUserById(i%2+1));
			comment.setProduct(productService.getProductById(i%2+1));
			comment.setContent(i+"内容去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去亲亲亲亲亲亲亲亲去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去去");
			comment.setCdate(new Date());
			System.out.println(commentService.addComment(comment));
		}
	}
}
