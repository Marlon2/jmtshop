<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	$("#checkAll").click(function(){
		$("input[name=uid][type=checkbox]").prop("checked",this.checked);
	});
	$("a[href='<%=basePath%>/admin/userList.action?currentPage=${currentPage}']").parent().addClass("active");
	$(".icon-eye-open").bind('click',function(){
		var id = $(this).attr("id");
		$("#myModal").modal({
			keyboard: false,
			show:true,
			remote:"<%=basePath%>/user/userView?userOrderId="+id
		});
		$("#myModal").on("hidden",function(){
			$(this).removeData("modal");
		});
	});
});

</script>
<sb:head />
</head>
<body>


<div class="container-fluid">
	<form class="form-search well">
  	<div class="input-prepend">
  	<label class="add-on" for="prependedInput">姓名</label>
  	<input name="user.userName" class="span2" id="prependedInput" type="text">
	</div>&nbsp;&nbsp;
	<div class="input-prepend">
  	<label class="add-on" for="prependedInput">电话</label>
  	<input name="user.phone" class="span2" id="prependedInput" type="text">
	</div>
  	<button type="submit" class="btn">搜索</button>
	</form>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll"></th>
						<th>用户名</th>
						<th>真实姓名</th>
						<th>性别</th>
						<th>生日</th>
				        <th>操作</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="users" var="user" status="rowstatus">
					<s:if test="#rowstatus.odd==true">
						<tr class="success">
							<td><input type="checkbox" id="uid" name="uid" value="${user.userId}"></td>
							<td><s:property value="#user.userName" /></td>
							<td><s:property value="#user.trueName" /></td>
							<td><s:property value="#user.gender" /></td>
							
							<td><s:date name="#user.birthday" format="yyyy-MM-dd"/></td>
							<td>
								<a href="javascript:void(0)"><i class="icon-remove"></i></a>&nbsp;&nbsp;
								
								<a href="javascript:void(0)"><i class="icon-eye-open" id="${user.userId}"></i></a>
							</td>
						</tr>
					</s:if>
					<s:else>
						<tr class="error">
							<td><input type="checkbox" id="uid" name="uid" value="${user.userId}"></td>
							<td><s:property value="#user.userName" /></td>
							<td><s:property value="#user.trueName" /></td>
							<td><s:property value="#user.gender" /></td>
							<td><s:date name="#user.birthday" format="yyyy-MM-dd"/></td>
							<td>
								<a href="javascript:void(0)"><i class="icon-remove"></i></a>&nbsp;&nbsp;
								
								<a href="javascript:void(0)"><i class="icon-eye-open" id="${user.userId}"></i></a>
							</td>
						</tr>
					</s:else>
					</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="pagination pagination-centered pagination-large">
				<ul>
					<s:if test="totalPage<6">
					<s:iterator var="counter" begin="1" end="totalPage">
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${counter}">${counter }</a>
						</li>
					</s:iterator>
					</s:if>
					<s:else>
					<s:if test="currentPage-1<3">
					<s:iterator var="counter" begin="1" end="4">
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${counter}">${counter }</a>
						</li>
					</s:iterator>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${totalPage}">...${totalPage }</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${currentPage+1}">&gt;&gt;</a>
						</li>
					</s:if>
					<s:else>
					<s:if test="totalPage-currentPage>=3">
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${currentPage-1}">&lt;&lt;</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=1">1...</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${currentPage-1}">${currentPage-1 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${currentPage}">${currentPage }</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${currentPage+1}">${currentPage+1 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${totalPage}">...${totalPage }</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${currentPage+1}">&gt;&gt;</a>
						</li>
					</s:if>
					<s:else>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${currentPage-1}">&lt;&lt;</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=1">1...</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${totalPage-3}">${totalPage-3 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${totalPage-2}">${totalPage-2 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${totalPage-1}">${totalPage-1 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/user/userList.action?currentPage=${totalPage}">${totalPage }</a>
						</li>
					</s:else>
					</s:else>
					</s:else>
				</ul>
			</div>
		</div>
	</div>
</div>
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">查看用户信息</h3>
  </div>
  <div class="modal-body">
    <p></p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
    <!-- <button class="btn btn-primary">保存修改</button> -->
  </div>
</div>	 
</body>
</html>