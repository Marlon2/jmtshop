<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息</title>
</head>
<body>
	<table class="table table-bordered table-striped table-hover">
		<tr class="success">
			<td><label>订单编号</label></td>
			<td><s:property value="userOrder.orderId" /></td>
		</tr>
		<tr class="error">
			<td><label>用户名</label></td>
			<td><s:property value="userOrder.userName" /></td>
		</tr>
		<tr class="success">
			<td><label>真实姓名</label></td>
			<td><s:property value="userOrder.realName" /></td>
		</tr>
		<tr class="error">
			<td><label>地址</label></td>
			<td><s:property value="userOrder.address" /></td>
		</tr>
		<tr class="success">
			<td><label>邮政编码</label></td>
			<td><s:property value="userOrder.postCode" /></td>
		</tr>
		<tr class="error">
			<td><label>电话</label></td>
			<td><s:property value="userOrder.phone" /></td>
		</tr>
		<tr class="success">
			<td><label>订单时间</label></td>
			<td><s:property value="userOrder.orderDate" /></td>
		</tr>
		<tr class="error">
			<td><label>订单状态</label></td>
			<td>
			
			<s:if test="userOrder.flag==0">未发货</s:if> <s:elseif
					test="userOrder.flag==1">已发货</s:elseif> <s:else>已完成</s:else></td>
		</tr>
	</table>
</body>
</html>