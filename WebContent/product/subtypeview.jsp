<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看小类</title>
</head>
<body>
小类名称：<s:property value="e_subType.subtypename"/><br>
所属大类：<s:property value="e_supertypename"/>
<div class="modal-footer ">
<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">关闭</button>
</div>
</body>
</html>