<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<table  class="table table-bordered table-hover">
				<tr class="success">
							<td>用户编码：</td>
							<td><s:property value="user.userId"/></td>
				</tr>
				<tr class="error">
							<td>用户姓名：</td>
							<td><s:property value="user.userName"/></td>
				</tr>
				<tr class="success">
							<td>真实姓名：</td>
							<td><s:property value="user.trueName"/></td>
				</tr>
				<tr class="error">
							<td>用户邮箱：</td>
							<td><s:property value="user.userEmail"/></td>
				</tr>
				<tr class="success">
							<td>用户生日：</td>
							<td><s:date name="user.birthday" format="yyyy-MM-dd"/></td>
				</tr>
				<tr class="error">
							<td>用户性别：</td>
							<td><s:property value="user.gender"/></td>
				</tr>
				<tr class="success">
							<td>用户地址：</td>
							<td><s:property value="user.address"/></td>
				</tr>
				<tr class="error">
							<td>邮政编码：</td>
							<td><s:property value="user.postCode"/></td>
				</tr>
				<tr class="success">
							<td>固定电话：</td>
							<td><s:property value="user.phone"/></td>
				</tr>
				<tr class="error">
							<td>移动电话：</td>
							<td><s:property value="user.mobil"/></td>
				</tr>
				<tr class="success">
							<td>用户积分：</td>
							<td><s:property value="user.socre"/></td>
				</tr>
				
			    </table>
			  </div>
		</div>
	</div>


</body>
</html>