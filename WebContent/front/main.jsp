<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城首页</title>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basepath%>/css/frontstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basepath%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	/* alert(1);
	var slist = $(".sidelist");
	
	for(var index=0;index<slist.length;index++){
		var supertypeid = $(slist[index]).find("input").attr("value");
		$.ajax({
		    url:'../product/subtypecascade_getSubType.action',
			type : 'post',
			dataType : 'json',
			data : {e_supertypeid : supertypeid},
			success : function(json){
				var dataObjs = (json.subTypes);
				$.each(dataObjs, function(i, subType) {
					$li = $("<li></li>");
					$a = $("<a></a>");
					$a.attr("href","#");
					$a.text(subType.subtypename);
					$li.append($a);
					alert($li.html());
					$("ul")[index].append($li);
				});
			}
		});
	} */
	
    $('.sidelist').mousemove(function(){
	$(this).find('.i-list').show();
	$(this).find('h3').addClass('hover');
	});
	$('.sidelist').mouseleave(function(){
	$(this).find('.i-list').hide();
	$(this).find('h3').removeClass('hover');
	});
});
</script>
</head>
<body>
	<div id="main_container">
	<jsp:include page="top.jsp"></jsp:include>
		<div id="body-left">
			<div id="sidebar">
				<s:iterator value="superTypes" var="superType">
					<div class="sidelist">
						<span><h3>
							<a href="#"><s:property value="#superType.supertypename" /></a>
						</h3></span>
						<input type="hidden" name="" value='<s:property value="#superType.supertypeid" />'>
						<div class="i-list">
						<ul>
						<s:iterator value="superType.subTypes" var="subType">
							<li>
								<a href="#"><s:property value="#subType.subtypeid"/> </a>
							</li>
						</s:iterator>
						</ul></div>
					</div>
				</s:iterator>
				<%-- <div class="sidelist">
					<span><h3>
							<a href="http://js.alixixi.com">巧克力阿</a>
						</h3></span>
					<div class="i-list">
						<ul>
							<li><a href="##">桶装</a></li>
							<li><a href="##">儿童</a></li>
							<li><a href="##">盒装</a></li>
							<li><a href="##">咖啡味</a></li>
							<li><a href="http://js.alixixi.com">草莓味</a></li>
							<li><a href="##">杏仁味</a></li>
							<li><a href="##">原味</a></li>
							<li><a href="##">原味</a></li>
							<li><a href="http://js.alixixi.com">鸡蛋</a></li>
						</ul>
					</div>
				</div> --%>
				
				
			</div>
		</div>
		<div class="center_content">

			<div class="oferta">
				<img src="images/p1.png" width="165" height="113" border="0"
					class="oferta_img" alt="" title="" />

				<div class="oferta_details">
					<div class="oferta_title">Power Tools BST18XN Cordless</div>
					<div class="oferta_text">Lorem ipsum dolor sit amet,
						consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
						labore et dolore magna aliqua. Ut enim ad minim veniam, quis
						nostrud exercitation ullamco</div>
					<a href="details.html" class="prod_buy">details</a>
				</div>
			</div>


			<div class="center_title_bar">Latest Products</div>

			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Makita 156 MX-VL</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p1.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>

			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Bosch XC</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p2.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>


			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Lotus PP4</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p4.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>

			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Makita 156 MX-VL</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p3.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>

			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Bosch XC</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p5.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>


			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Lotus PP4</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p6.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>

			<div class="center_title_bar">Recomended Products</div>

			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Makita 156 MX-VL</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p7.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>

			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Bosch XC</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p1.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>


			<div class="prod_box">

				<div class="center_prod_box">
					<div class="product_title">
						<a href="details.html">Lotus PP4</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/p3.jpg" alt=""
							title="" border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="reduce">350$</span> <span class="price">270$</span>
					</div>
				</div>

				<div class="prod_details_tab">
					<a href="buy.html" class="prod_buy">Add to Cart</a> <a
						href="details.html" class="prod_details">Details</a>
				</div>
			</div>


		</div>
		<!-- end of center content -->
	</div>

</body>
</html>