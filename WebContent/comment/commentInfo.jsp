<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言信息</title>
</head>
<body>
	<table class="table table-bordered table-striped table-hover">
		<tr class="error">
			<td><label>ID</label></td>
			<td><s:property value="comment.id" /></td>
		</tr>
		<tr class="success">
			<td><label>用户名</label></td>
			<td><s:property value="comment.user.userName" /></td>
		</tr>
		<tr class="error">
			<td><label>标题</label></td>
			<td><s:property value="comment.ctitle" /></td>
		</tr>
		<tr class="success">
			<td><label>商品名称</label></td>
			<td><s:property value="comment.product.productname" /></td>
		</tr>
		<tr class="error">
			<td><label>内容</label></td>
			<td><s:property value="comment.content" /></td>
		</tr>
		<tr class="success">
			<td><label>评论日期</label></td>
			<td><s:property value="comment.cdate" /></td>
		</tr>
	</table>
</body>
</html>