<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大类展示页面</title>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	$("#checkAll").click(function(){
		$("input[name=supertypeid][type=checkbox]").prop("checked",this.checked);
	});
	$("a[href='<%=basePath%>/product/superType_list?currentPage=${currentPage}']").parent().addClass("active");
	//修改大类
	$(".icon-edit").bind('click',function(){
		var id = $(this).attr("id");
		$("#myModalLabel").text("修改大类信息");
		$("#yesorno").hide();
		$("#myModal").modal({
			keyboard: false,
			show:true,
			remote:$(".modal-body").load("<%=basePath%>/product/superType_edit?e_supertypeid="+id)
		}).on("hidden",function(){
			$(this).removeData("modal");
		});
	});
	//添加大类
	$(".icon-plus").bind('click',function(){
		$("#myModalLabel").text("添加大类信息");
		$("#yesorno").hide();
		$("#myModal").modal({
			keyboard: false,
			show:true,
			remote:$(".modal-body").load("<%=basePath%>/product/supertypeadd.jsp")
		}).on("hidden",function(){
			$(this).removeData("modal");
		});
	});
	//删除大类
	
	$(".icon-remove").bind('click',function(){
		var id = $(this).attr("id");
		$("#myModalLabel").text("删除大类信息");
		$(".modal-body").html("<h4>你确定要删除吗？</h4>");
		$("#yesorno").show();
		$("#myModal").modal({
			keyboard: false,
			show:true,
			remote:null
		}).on("hidden",function(){
			$(this).removeData("modal");
		});
		$("#yesBtn").click(function(){
			window.location.href = "<%=basePath%>/product/superType_delete?e_supertypeid="+id;
		});
	});
	
});
</script>
<sb:head />
</head>
<body>
<div class="container-fluid">
	<form class="form-search well" action="<%=basePath%>/product/superType_list" method="post">
  	<div class="input-prepend">
  	<label class="add-on" for="prependedInput">大类名称</label>
  	<input name="e_supertypename" class="span2" id="prependedInput" type="text">
  	<input type="hidden" name="currentPage" value="1">
	</div>
  	<button type="submit" class="btn">搜索</button>
	</form>
	</div>
	<div class="alert">
  	<button type="button" class="close" data-dismiss="alert">&times;</button>
  	<strong>警告！</strong> ${msg}
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll"></th>
						<th>大类ID</th>
						<th>大类名称</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="superTypes" var="superType" status="rowstatus">
					<s:if test="#rowstatus.odd==true">
						<tr class="success">
							<td><input type="checkbox" id="supertypeid" name="supertypeid" value='<s:property value="#superType.supertypeid" />'></td>
							<td><s:property value="#superType.supertypeid" /></td>
							<td><s:property value="#superType.supertypename" /></td>
							<td><a href="javascript:void(0)"><i class="icon-plus"></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-remove" id='<s:property value="#superType.supertypeid" />'></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-edit" id='<s:property value="#superType.supertypeid" />'></i></a>&nbsp;&nbsp;
								<%-- <a href="javascript:void(0)"><i class="icon-eye-open" id='<s:property value="#superType.supertypeid" />'></i></a> --%>
							</td>
						</tr>
					</s:if>
					<s:else>
						<tr class="error">
							<td><input type="checkbox" id="supertypeid" name="supertypeid" value='<s:property value="#superType.supertypeid" />'></td>
							<td><s:property value="#superType.supertypeid" /></td>
							<td><s:property value="#superType.supertypename" /></td>
							<td><a href="javascript:void(0)"><i class="icon-plus"></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-remove" id='<s:property value="#superType.supertypeid" />'></i></a>&nbsp;&nbsp;
								<a href="javascript:void(0)"><i class="icon-edit" id='<s:property value="#superType.supertypeid" />'></i></a>&nbsp;&nbsp;
								<%-- <a href="javascript:void(0)"><i class="icon-eye-open" id='<s:property value="#superType.supertypeid" />'></i></a> --%>
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
							<a href="<%=basePath%>/product/superType_list?currentPage=${counter}">${counter }</a>
						</li>
					</s:iterator>
					</s:if>
					<s:else>
					<s:if test="currentPage-1<3">
					<s:iterator var="counter" begin="1" end="4">
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${counter}">${counter }</a>
						</li>
					</s:iterator>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${totalPage}">...${totalPage }</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${currentPage+1}">&gt;&gt;</a>
						</li>
					</s:if>
					<s:else>
					<s:if test="totalPage-currentPage>=3">
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${currentPage-1}">&lt;&lt;</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=1">1...</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${currentPage-1}">${currentPage-1 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${currentPage}">${currentPage }</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${currentPage+1}">${currentPage+1 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${totalPage}">...${totalPage }</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${currentPage+1}">&gt;&gt;</a>
						</li>
					</s:if>
					<s:else>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${currentPage-1}">&lt;&lt;</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=1">1...</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${totalPage-3}">${totalPage-3 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${totalPage-2}">${totalPage-2 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${totalPage-1}">${totalPage-1 }</a>
						</li>
						<li>
							<a href="<%=basePath%>/product/superType_list?currentPage=${totalPage}">${totalPage }</a>
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
    <h3 id="myModalLabel"></h3>
  </div>
  <div class="modal-body">
    
  </div>
  <div class="modal-footer hide" id="yesorno">
    <button class="btn" data-dismiss="modal" aria-hidden="true">否</button>
    <button class="btn btn-primary" id="yesBtn">是</button>
</div>
</div>
</body>
</html>