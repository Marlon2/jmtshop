<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论</title>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$(".content").each(function(){			
		 var content = $(this).text();
			if(content.length>10){
				$(this).text(content.substring(10,20)+"...");
				}
			//$(this).mouseover(function(){
				//$(this).text(content);
				//}).mouseleave(function(){
					//$(this).text(content.substring(10,20)+"...");
					//});
			});
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
			var id = $(this).attr("id");
			$("#myModal").modal({
				keyboard: false,
				show:true,
				remote:'<%=basePath%>/comment/comment_getCommentInfo?commentid='+id
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
			$(".modal-body").html("<h4>你确定要删除留言编号为"+id+"的留言吗？</h4>");
			$("#myModal").modal({
				keyboard: false,
				show:true,
				remote:null
			});
			$("#myModal").on("hidden",function(){
				$(this).removeData("modal");
			});
			$("#deleteBtn").click(function(){				
				window.location.href = "<%=basePath%>/comment/comment_deleteComment?commentid="+id;
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
					window.location.href = "<%=basePath%>/comment/comment_deleteComment?commentid="+ids[0];
					}
				if(ids.length>1){
				window.location.href = "<%=basePath%>/comment/comment_deleteCommentBeach?ids="+ids;
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
			<form class="form-search well" action="comment_searchComment">
				<div class="input-prepend">
					<label class="add-on" for="prependedInput">商品名称</label> <input
						name="productNameTXT" class="span2" id="prependedInput"
						type="text">
				</div>
				<button type="submit" class="btn">搜索</button>
			</form>
		</div>


		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><input type="checkbox" id="ckeckAll" /></th>
				<th>ID</th>
				<th>用户名</th>
				<th>标题</th>
				<th>商品名称</th>
				<th>内容</th>
				<th>评论日期</th>
				<th>操作</th>
			</tr>

			<s:if test="comments.empty">
				<td colspan="7"><div align="center">
						<font color="red"><b>无数据！</b></font>
					</div></td>
			</s:if>
			<s:else>
				<s:iterator value="comments" var="comment" status="sta">
					<s:if test="#sta.odd==true ">
						<tr class="success">
							<td><input type="checkbox" class="isXheck"
								id='<s:property value="#comment.id" />' /></td>
							<td><s:property value="#comment.id" /></td>
							<td><s:property value="#comment.user.userName" /></td>
							<td><s:property value="#comment.ctitle" /></td>
							<td><s:property value="#comment.product.productname" /></td>
							<td>
							<div class="content">
							   <s:property value="#comment.content"/>
							</div>
							</td>
							<td><s:property value="#comment.cdate" /></td>
							<td><a href="javascript:void(0)"><i
									class="icon-eye-open"
									id='<s:property value="#comment.id" />'></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-remove"
									id='<s:property value="#comment.id" />'></i></a></td>
						</tr>
					</s:if>
					<s:else>
						<tr class="error">
							<td><input type="checkbox" class="isXheck"
								id='<s:property value="#comment.id" />' /></td>
							<td><s:property value="#comment.id" /></td>
							<td><s:property value="#comment.user.userName" /></td>
							<td><s:property value="#comment.ctitle" /></td>
							<td><s:property value="#comment.product.productname" /></td>
								<td>
							<div class="content">
							   <s:property value="#comment.content" />
							</div>
							</td>
							<td><s:property value="#comment.cdate" /></td>
							<td><a href="javascript:void(0)"><i
									class="icon-eye-open"
									id='<s:property value="#comment.id" />'></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-remove"
									id='<s:property value="#comment.id" />'></i></a></td>
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
										href="<%=basePath%>/comment/comment_getCommentView?currentPage=${pageCount}">${pageCount
											}</a></li>
								</s:iterator>
							</s:if>
							<s:else>
								<s:if test="currentPage-1<3">
									<s:iterator var="pageCount" begin="1" end="4">
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${pageCount}">${pageCount
												}</a></li>
									</s:iterator>
									<li><a
										href="<%=basePath%>/comment/comment_getCommentView?currentPage=${allPageCounts}">...${allPageCounts
											}</a></li>
									<li><a
										href="<%=basePath%>/comment/comment_getCommentView?currentPage=${currentPage+1}">&gt;&gt;</a>
									</li>
								</s:if>
								<s:else>
									<s:if test="allPageCounts-currentPage>=3">
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${currentPage-1}">&lt;&lt;</a>
										</li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=1">1...</a>
										</li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${currentPage-1}">${currentPage-1
												}</a></li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${currentPage}">${currentPage
												}</a></li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${currentPage+1}">${currentPage+1
												}</a></li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${allPageCounts}">...${allPageCounts
												}</a></li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${currentPage+1}">&gt;&gt;</a>
										</li>
									</s:if>
									<s:else>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${currentPage-1}">&lt;&lt;</a>
										</li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=1">1...</a>
										</li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${allPageCounts-3}">${allPageCounts-3
												}</a></li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${allPageCounts-2}">${allPageCounts-2
												}</a></li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${allPageCounts-1}">${allPageCounts-1
												}</a></li>
										<li><a
											href="<%=basePath%>/comment/comment_getCommentView?currentPage=${allPageCounts}">${allPageCounts
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
				<h3>查看评论信息</h3>
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