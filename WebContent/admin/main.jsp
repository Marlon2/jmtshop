<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" href="<%=basepath %>css/common.css" type="text/css">
<script type="text/javascript" src="<%=basepath %>js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=basepath %>js/menu.js"></script>
</head>
<body>
	<div id="top1">
		<div id="username">${admin.userName }</div>
		<img id="title" src="<%=basepath %>images/title.png" usemap="#Map" />
		<map name="Map">
			<area shape="rect" coords="3,1,57,32" href="<%=basepath %>admin/login.action">
			<area shape="rect" coords="60,1,115,32" href="javascript:history.go(-1);">
			<area shape="rect" coords="118,1,174,32" href="javascript:history.go(1);">
			<area shape="rect" coords="176,1,235,32" href="javascript:location.reload();">
			<area shape="rect" coords="239,1,335,32" href="#" onclick="tishi()">
			<area shape="rect" coords="340,1,398,32" href="#" onclick="tishi()">
		</map>
		<div id="timeId"></div>
	</div>
	<div id="container">
		<div id="middle">
			<div class="left_box">
				<img class="left_box_img"
					src="${pageContext.request.contextPath }/images/usermanage1.png"
					onmousedown="manage(this,'<%=basepath %>')">
				<div id="usermanage">
					<ul>
						<li><a href="${pageContext.request.contextPath }/user/userList.action" target="contentiframe">普通用户</a></li>
						<li><a href="javascript:void(0)" target="contentiframe">商户管理</a></li>
					</ul>
				</div>
			</div>
			<div class="left_box">
				<img class="left_box_img"
					src="${pageContext.request.contextPath }/images/ordermanage1.png"
					onmousedown="manage(this,'<%=basepath %>')">
				<div id="ordermanage">
					<ul>
						<li><a href="<%=basepath %>/order/userOrder_getUserOrderView?orderFlag=all" target="contentiframe">查看所有订单</a></li>
						<li><a href="${pageContext.request.contextPath }/order/userOrder_getUserOrderView?orderFlag=0" target="contentiframe">未发货订单</a></li>
						<li><a href="${pageContext.request.contextPath }/order/userOrder_getUserOrderView?orderFlag=1" target="contentiframe">已发货订单</a></li>
						<li><a href="${pageContext.request.contextPath }/order/userOrder_getUserOrderView?orderFlag=2" target="contentiframe">已完成订单</a></li>
					</ul>
				</div>
			</div>
			<div class="left_box">
				<img class="left_box_img"
					src="${pageContext.request.contextPath }/images/productmanage1.png"
					onmousedown="manage(this,'<%=basepath %>')">
				<div id="productmanage">
					<ul>
						<li><a href="<%=basepath %>product/superType_list" target="contentiframe">大类列表</a></li>
						<li><a href="<%=basepath %>product/subType_list" target="contentiframe">小类列表</a></li>
						<li><a href="<%=basepath %>product/attr_list" target="contentiframe">属性列表</a></li>
						<!-- <li><a href="javascript:void(0)" target="contentiframe">品牌列表</a></li> -->
						<li><a href="<%=basepath %>product/subtypecascade_getAllSuperTypes" target="contentiframe">添加商品</a></li>
						<li><a href="<%=basepath %>product/product_list" target="contentiframe">查看商品</a></li>
					</ul>
				</div>
			</div>
			<div class="left_box">
				<img class="left_box_img"
					src="${pageContext.request.contextPath }/images/admanage1.png"
					onmousedown="manage(this,'<%=basepath %>')">
				<div id="admanage">
					<ul>
						<li><a href="javascript:void(0)" target="contentiframe">添加公告</a></li>
						<li><a href="javascript:void(0)" target="contentiframe">查看公告</a></li>
					</ul>
				</div>
			</div>
			<div class="left_box">
				<img class="left_box_img"
					src="${pageContext.request.contextPath }/images/messagemanage1.png"
					onmousedown="manage(this,'<%=basepath %>')">
				<div id="messagemanage">
					<ul>
						<li><a href="<%=basepath %>comment/comment_getCommentView" target="contentiframe">查看评论</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="content">
			<iframe name="contentiframe" frameborder="0" scrolling="auto"
				height="100%" width="100%"></iframe>
		</div>
	</div>
</body>
</html>