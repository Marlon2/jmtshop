<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单项列表</title>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#ckeckAll").click(function() {
			if ($(this).attr("checked") == "checked") {
				$(".isXheck").each(function() {
					$(this).attr("checked", "checked");
				});
			}
			if ($(this).attr("checked") == undefined) {
				$(".isXheck").each(function() {
					$(this).removeAttr("checked");
				});
			}
		});

		$("a[href='<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${currentPage}']").parent().addClass("active");	
		$(".icon-eye-open").bind('click',function(){
			
			$("#deleteDiv").hide();
			$("#closeDiv").show();
			$("#myModalLabel1").show();
			$("#myModalLabel2").hide();
			var id = $(this).attr("id");
			$("#myModal").modal({
				keyboard: false,
				show:true,
				remote:'<%=basePath%>/order/orderItem_getUserOrderItemInfo?op=look&&orderItemId='+id
			});
			$("#myModal").on("hidden",function(){
				$(this).removeData("modal");
			});
		});

		$(".icon-edit").bind('click',function(){
			var id = $(this).attr("id");
			$("#deleteDiv").hide();
			$("#myModalLabel1").hide();
			$("#myModalLabel2").show();
			$("#closeDiv").hide();
			$("#myModal").modal({
				keyboard: false,
				show:true,
				remote:$(".modal-body").load("<%=basePath%>/order/orderItem_getUserOrderItemInfo?op=edit&&orderItemId="+id)
			});
			$("#myModal").on("hidden",function(){
				$(this).removeData("modal");
			});
		});	
		$(".icon-remove").bind('click',function(){
			var id = $(this).attr("id");
			$("#deleteDiv").show();
			$("#myModalLabel1").hide();
			$("#myModalLabel2").hide();
			$("#closeDiv").hide();
			$(".modal-body").html("<h4>你确定要删除订单详情编号为"+id+"的订单项吗？</h4>");
			$("#myModal").modal({
				keyboard: false,
				show:true,
				remote:null
			});
			$("#myModal").on("hidden",function(){
				$(this).removeData("modal");
			});
			$("#deleteBtn").click(function(){				
				window.location.href = "<%=basePath%>/order/orderItem_deleteUserOrderItem?orderItemId="+id;
				});				
			});
		$("#deleteBeach").click(function(){
			var ids = new Array();
			var i = 0; 
			$(".isXheck").each(function(){
				if($(this).attr("checked") == "checked"){
					ids[i] = $(this).attr("id");
					i++;
					}
				});
			if(ids.length>0){
			$("#deleteDiv").show();
			$("#myModalLabel1").hide();
			$("#myModalLabel2").hide();
			$("#closeDiv").hide();
			$(".modal-body").html("<h4>你确定要删除选中的"+ids.length+"项吗？</h4>");
			$("#myModal").modal({
				keyboard: false,
				show:true,
				remote:null
			});
			$("#myModal").on("hidden",function(){
				$(this).removeData("modal");
			});
			$("#deleteBtn").click(function(){
				if(ids.length==1){
					window.location.href = "<%=basePath%>/order/orderItem_deleteUserOrderItem?orderItemId="+ids[0];
					}
				if(ids.length>1){
				window.location.href = "<%=basePath%>/order/orderItem_deleteUserOrderItemBeach?ids="+ids;
					}				
												});
							} else {
								alert("您没有选中任何一项！");
							}
						});
	});
</script>
<sb:head />
</head>
<body>
	<div class="well">
		<div class="container-fluid">
			<form class="form-search well" action="orderItem_searchOrderItem">
				<div class="input-prepend">
					<label class="add-on" for="prependedInput">订单号</label> <input
						name="OrderItemIdText" class="span2" id="prependedInput"
						type="text">
				</div>
				<button type="submit" class="btn">搜索</button>
			</form>
		</div>
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><input type="checkbox" id="ckeckAll" /></th>
				<th>订单详情编号</th>
				<th>订单编号</th>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>价格</th>
				<th>商品数量</th>
				<th>操作</th>
			</tr>

			<s:if test="orderItems.empty">
				<td colspan="7"><div align="center">
						<font color="red"><b>无数据！</b></font>
					</div></td>
			</s:if>
			<s:else>
				<s:iterator value="orderItems" var="orderItem" status="sta">
					<s:if test="#sta.odd==true ">
						<tr class="success">
							<td><input type="checkbox" class="isXheck"
								id='<s:property value="#orderItem.orderItemId" />' /></td>
							<td><s:property value="#orderItem.orderItemId" /></td>
							<td><s:property value="#orderItem.userOrder.orderId" /></td>
							<td><s:property value="#orderItem.product.productid" /></td>
							<td><s:property value="#orderItem.productName" /></td>
							<td><s:property value="#orderItem.price" /></td>
							<td><s:property value="#orderItem.productNum" /></td>
							<td><a href="javascript:void(0)"><i
									class="icon-eye-open"
									id='<s:property value="#orderItem.orderItemId" />'></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-edit"
									id='<s:property value="#orderItem.orderItemId" />'></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-remove"
									id='<s:property value="#orderItem.orderItemId" />'></i></a></td>
						</tr>
					</s:if>
					<s:else>
						<tr class="error">
							<td><input type="checkbox" class="isXheck"
								id='<s:property value="#orderItem.orderItemId" />' /></td>
							<td><s:property value="#orderItem.orderItemId" /></td>
							<td><s:property value="#orderItem.userOrder.orderId" /></td>
							<td><s:property value="#orderItem.product.productid" /></td>
							<td><s:property value="#orderItem.productName" /></td>
							<td><s:property value="#orderItem.price" /></td>
							<td><s:property value="#orderItem.productNum" /></td>
							<td><a href="javascript:void(0)"><i
									class="icon-eye-open"
									id='<s:property value="#orderItem.orderItemId" />'></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-edit"
									id='<s:property value="#orderItem.orderItemId" />'></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-remove"
									id='<s:property value="#orderItem.orderItemId" />'></i></a></td>
						</tr>
						<tr>
						</tr>
					</s:else>

				</s:iterator>
							<td colspan="8"><input type="button" class="btn" value="删除"
								id="deleteBeach" /></td>
			</s:else>
		</table>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="pagination pagination-centered pagination-large">
					<s:if test="currentPage>0">
						<ul>
							<s:if test="allPageCounts<6">
								<s:iterator var="pageCount" begin="1" end="allPageCounts">
									<li><a
										href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${pageCount}">${pageCount
											}</a></li>
								</s:iterator>
							</s:if>
							<s:else>
								<s:if test="currentPage-1<3">
									<s:iterator var="pageCount" begin="1" end="4">
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${pageCount}">${pageCount
												}</a></li>
									</s:iterator>
									<li><a
										href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${allPageCounts}">...${allPageCounts
											}</a></li>
									<li><a
										href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${currentPage+1}">&gt;&gt;</a>
									</li>
								</s:if>
								<s:else>
									<s:if test="allPageCounts-currentPage>=3">
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${currentPage-1}">&lt;&lt;</a>
										</li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=1">1...</a>
										</li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${currentPage-1}">${currentPage-1
												}</a></li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${currentPage}">${currentPage
												}</a></li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${currentPage+1}">${currentPage+1
												}</a></li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${allPageCounts}">...${allPageCounts
												}</a></li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${currentPage+1}">&gt;&gt;</a>
										</li>
									</s:if>
									<s:else>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${currentPage-1}">&lt;&lt;</a>
										</li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=1">1...</a>
										</li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${allPageCounts-3}">${allPageCounts-3
												}</a></li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${allPageCounts-2}">${allPageCounts-2
												}</a></li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${allPageCounts-1}">${allPageCounts-1
												}</a></li>
										<li><a
											href="<%=basePath%>/order/orderItem_getUserOrderItemView?currentPage=${allPageCounts}">${allPageCounts
												}</a></li>
									</s:else>
								</s:else>
							</s:else>
						</ul>
					</s:if>
				</div>
			</div>
		</div>
	</div>
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<div id="myModalLabel1">
				<h3>查看订单项信息</h3>
			</div>
			<div id="myModalLabel2">
				<h3>修改订单项信息</h3>
			</div>
		</div>
		<div class="modal-body">
			<p></p>
		</div>
		<div class="modal-footer">
			<div id="closeDiv">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
			<div id="deleteDiv">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="btn" data-dismiss="modal" aria-hidden="true"
					id="deleteBtn">删除</button>
			</div>
		</div>
	</div>
</body>
</html>