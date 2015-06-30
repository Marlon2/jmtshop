<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小类的添加</title>
</head>
<body>
	<s:form action="subType_add.action" namespace="/product" method="post">
		<s:select list="superTypes" listValue="supertypename"
			listKey="supertypeid" name="e_supertypeid" label="大类名称"
			value="supertypeid">

		</s:select>
		<s:textfield label="小类名称" name="e_subType.subtypename" value=""></s:textfield>
		<s:submit value="保存"></s:submit>
	</s:form>
</body>
</html>