<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.Random" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<sb:head/>
<%
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
String basePath2 = request.getScheme() + "://"
		+ request.getRemoteHost() + ":" + request.getLocalPort()
		+ request.getContextPath();
%>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
  $(function(){
	  $("#imageDiv").insertBefore($("#sub"));
	  $("#Kaptcha").click(function(){
		  if($("#Kaptcha").attr("src")=="<%=basePath%>/Kaptcha.jpg"){
			  $("#Kaptcha").attr("src","<%=basePath2%>/Kaptcha.jpg");
		  }else{
			  $("#Kaptcha").attr("src","<%=basePath%>/Kaptcha.jpg");
			  }	
	});
		$("#sub").click(function(){
			var i=0;
			$(".input").each(function(){
				if($(this).val().trim()==""){
					$("#msg").text("用户名或密码或验证码为空！");
					return;
					}else{
						i++;
						}
				if(i==3){
					$("#msg").text("");
					$("#loginForm").submit();
					}
				});
			});
  });
	function changeImag(){
		var imagSrc = document.getElementById("Kaptcha");
		if(imagSrc.src=="<%=basePath%>/Kaptcha.jpg"){
			imagSrc.src="<%=basePath2%>/Kaptcha.jpg";
			}else{
				imagSrc.src="<%=basePath%>/Kaptcha.jpg";
				} 
  }
</script>
<style type="text/css">
.container {
	width: 400px;
}

#sub {
	background-color: aqua;
	border: hidden;
	width: 300px;
	height: 30px;
}

a,img {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<div class="page-header well">
			<h3>用户登陆</h3>
			<div id="imageDiv">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="<%=basePath%>/Kaptcha.jpg" id="Kaptcha"> <br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <a
					onclick="changeImag()" onmousemove="this.style.cursor='hand'">看不清，点击换一张</a>
				<br /> <br />
			</div>
			<div class="well">
				<s:form action="login" namespace="/admin" id="loginForm" theme="simple">
			   <table>
			     <tr> 
			       <td><b>用户名</b>&nbsp;&nbsp;&nbsp;<s:textfield name="admin.userName" cssClass="input"></s:textfield></td>
			     </tr>
			     <tr>
			       <td><b>密       码</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:password name="admin.userPassword" cssClass="input"></s:password></td>
			     </tr>
                  <tr>
                    <td align="right"><font color="red"><b><s:property value="massage"/></b></font></td>
                  </tr>
			     <tr>
			       <td><b>验证码</b>&nbsp;&nbsp;&nbsp;<s:textfield name="vcode" id="vcode" cssClass="input"></s:textfield></td>
			     </tr>
			     <tr><td align="right"><font id=msg color="red"></font></td></tr>
			     <tr>
			       <td><input type="button" value="登录" id="sub"></td>
			     </tr>					
			   </table>				
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>