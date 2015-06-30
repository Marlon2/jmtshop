package cn.edu.zut.jmtshop.action;

import java.util.List;

import cn.edu.zut.jmtshop.entity.OrderItem;
import cn.edu.zut.jmtshop.service.OrderItemService;
import cn.edu.zut.jmtshop.util.PageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class OrderItemActon extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private OrderItemService orderItemService;
	private List<OrderItem> orderItems;//单页订单项
	private int userOrderId;
	private int orderItemId;
	private int currentPage;
	private int allPageCounts; 
	private OrderItem orderItem;
	private String op;//查询或修改标识look查询edit编辑
	private String orderItemIdText;//查询订单项id
	private String ids;//选中的订单项id数组
	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
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
	
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}
	
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getOrderItemIdText() {
		return orderItemIdText;
	}
	public void setOrderItemIdText(String orderItemIdText) {
		this.orderItemIdText = orderItemIdText;
	}
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * 查询订单项
	 * */
	public String searchOrderItem() throws Exception {
		try {
			
			if(orderItemIdText==null||orderItemIdText.trim().equals("")){
				return getUserOrderItemView();
			}else{				
				orderItem = orderItemService.getOrderItemById(Integer.parseInt(orderItemIdText));
				if(orderItems!=null){				
					orderItems.removeAll(orderItems);
				}
				if(orderItem!=null&&orderItem.getUserOrder().getOrderId()==userOrderId){					
					orderItems.add(orderItem);
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
	 * 订单项列表
	 * */
	public String getUserOrderItemView() throws Exception {
		if(currentPage==0){
			currentPage = 1;
		}
		try {
			int allRows = orderItemService.UserOrderItemCounts(userOrderId);
			if(allRows%PageConstants.MAX_PAGESIZE==0){
				allPageCounts = allRows/PageConstants.MAX_PAGESIZE;
			}else{
				allPageCounts = allRows/PageConstants.MAX_PAGESIZE+1;
			}
			if(currentPage>allPageCounts){
				currentPage = allPageCounts;
			}
			orderItems = orderItemService.getUserOrderItemPrePage(currentPage, userOrderId);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
            return ERROR;
		}
	}
	
	/**
	 * 查看用户订单项信息
	 * */
	public String getUserOrderItemInfo() throws Exception {
		try {
			orderItem = orderItemService.getOrderItemById(orderItemId);
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
	/**
	 * 修改订单项
	 * */
	public String userOrderItemEdit()throws Exception{
		try {
			if(orderItemService.updateOrderItem(orderItem)){
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
	 * 删除单个订单项
	 * */
	public String deleteUserOrderItem()throws Exception{
		try {
			if(orderItemService.deleteOrderItem(orderItemId)){
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
	 * 批量删除订单项
	 * */
	public String deleteUserOrderItemBeach()throws Exception{
		try {
			String[] strIds = ids.split(",");
			int[] intIds = new int[strIds.length];
			for(int i=0;i<strIds.length;i++){
				intIds[i] = Integer.parseInt(strIds[i]);
			}
			if(intIds.length>0){	
				if(orderItemService.deleteOrderItemBeach(intIds)){
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
