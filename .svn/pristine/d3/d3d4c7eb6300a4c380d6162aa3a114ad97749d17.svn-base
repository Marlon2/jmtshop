package cn.edu.zut.jmtshop.action;

import java.util.List;

import cn.edu.zut.jmtshop.entity.UserOrder;
import cn.edu.zut.jmtshop.service.UserOrderService;
import cn.edu.zut.jmtshop.util.PageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class UserOrderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String orderFlag;//区分跳转到哪个页面all:所有订单 ；0未发货；1已发货；2已完成
	private UserOrderService userOrderService;
	private int currentPage;//当前页码
	private int allPageCounts;//总页码
	private List<UserOrder> userOrders;//每页记录
	private UserOrder userOrder;
	private int userOrderId;
	private String op;//判断执行查看还是编辑操作
	private String userOrderIdText;//输入框id值
	private String ids;//批量删除的订单id组成的字符串
	
	public String getOrderFlag() {
		return orderFlag;
	}


	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}


	public UserOrderService getUserOrderService() {
		return userOrderService;
	}


	public void setUserOrderService(UserOrderService userOrderService) {
		this.userOrderService = userOrderService;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getAllPageCounts() {
		return allPageCounts;
	}


	public void setAllPageCounts(int allPageCounts) {
		this.allPageCounts = allPageCounts;
	}


	public List<UserOrder> getUserOrders() {
		return userOrders;
	}


	public void setUserOrders(List<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}


	public UserOrder getUserOrder() {
		return userOrder;
	}


	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}


	public int getUserOrderId() {
		return userOrderId;
	}


	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}


	public String getOp() {
		return op;
	}


	public void setOp(String op) {
		this.op = op;
	}

	public String getUserOrderIdText() {
		return userOrderIdText;
	}


	public void setUserOrderIdText(String userOrderIdText) {
		this.userOrderIdText = userOrderIdText;
	}


	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}

/**
 * 查询订单
 * */
	public String searchUserOrder() throws Exception {
		try {
			if(userOrderIdText==null||userOrderIdText.trim().equals("")){
				return getUserOrderView();
			}else{				
				userOrder = userOrderService.getUserOrderById(Integer.parseInt(userOrderIdText),orderFlag);
				userOrders.removeAll(userOrders);
				if(userOrder!=null){					
					userOrders.add(userOrder);
				}
				allPageCounts = 1;
				currentPage = 0;
				return "searchSuccess";
			}
		} catch (Exception e) {
			e.printStackTrace();
            return ERROR;
		}
		
	}

	/**
	 * 执行列表显示
	 * */
	public String getUserOrderView() throws Exception {
		if(currentPage==0){
			currentPage = 1;
		}
		try {
			int allRows = userOrderService.getAllRows(orderFlag);
			if(allRows%PageConstants.MAX_PAGESIZE==0){
				allPageCounts = allRows/PageConstants.MAX_PAGESIZE;
			}else{
				allPageCounts = allRows/PageConstants.MAX_PAGESIZE+1;
			}
			if(currentPage>allPageCounts){
				currentPage = allPageCounts;
			}
			userOrders = userOrderService.getUserOrdersPrePage(currentPage,orderFlag);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
            return ERROR;
		}
	}
	/**
	 * 查看用户订单信息
	 * */
	public String getUserOrderInfo() throws Exception {
		try {
			System.err.println("orderFlag"+orderFlag);
			userOrder = userOrderService.getUserOrderById(userOrderId,orderFlag);
			if(op.equals("look")){	
				return "info";
			}else if(op.equals("edit")){
				return "edit";
			}else{
				System.err.println("error");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
            return ERROR;
		}
		
	}
public String userOrderEdit()throws Exception{
	try {
		boolean b =userOrderService.updateUserOrder(userOrder);
		System.err.println(b);
		if(b){
			return "editSuccess";
		}else{
			return "error";
		}
	} catch (Exception e) {
		e.printStackTrace();
		return "error";
		}
}
/**
 * 删除单个订单
 * */
public String deleteUserOrder()throws Exception{
	try {
		if(userOrderService.deleteUserOrderById(userOrderId,orderFlag)){
			return "deleteSuccess";
		}else{
			return "error";
		}
	} catch (Exception e) {
		e.printStackTrace();
		return "error";
		}
}
/**
 * 批量删除订单
 * */
public String deleteUserOrderBeach()throws Exception{
	try {
		String[] strIds = ids.split(",");
		int[] intIds = new int[strIds.length];
		for(int i=0;i<strIds.length;i++){
			intIds[i] = Integer.parseInt(strIds[i]);
		}
		if(intIds.length>0){	
			if(userOrderService.deleteUserOrderBeach(intIds,orderFlag)){
				return "deleteSuccess";
			}else{
				return "error";
			}
		}else {
			return "error";
		}
	} catch (Exception e) {
		e.printStackTrace();
		return "error";
		}
}
}
