<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
</head>
<body>
	<form action="<%=basePath%>/product/superType_save" method="post">
		<input type="hidden" name="e_superType.supertypeid"
			value="${e_superType.supertypeid} "> 请输入大类名称<br> <input
			type="text" name="e_superType.supertypename"
			value="${e_superType.supertypename }"><br>
		<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		<input type="submit" class="btn btn-primary" value="保存">
	</form>

</body>
</html>