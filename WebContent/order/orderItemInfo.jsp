<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单项信息</title>
</head>
<body>
	<table class="table table-bordered table-striped table-hover">
		<tr class="success">
			<td><label>订单详情编号</label></td>
			<td><s:property value="orderItem.orderItemId" /></td>
		</tr>
		<tr class="error">
			<td><label>订单编号</label></td>
			<td><s:property value="orderItem.userOrder.orderId" /></td>
		</tr>
		<tr class="success">
			<td><label>商品编号</label></td>
			<td><s:property value="orderItem.product.productid" /></td>
		</tr>
		<tr class="error">
			<td><label>商品名称</label></td>
			<td><s:property value="orderItem.productName" /></td>
		</tr>
		<tr class="success">
			<td><label>价格</label></td>
			<td><s:property value="orderItem.price" /></td>
		</tr>
		<tr class="error">
			<td><label>商品数量</label></td>
			<td><s:property value="orderItem.productNum" /></td>
		</tr>
	</table>
</body>
</html>