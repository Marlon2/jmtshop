<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息修改</title>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
    //验证输入项是否为空
    $(".input").each(function(){
    	$(this).focus(function() {
			if ($(this).val().trim() == "") {
				$(this).val(this.defaultValue);
				$(this).next().attr("color", "green").text("√");
			}
		}).blur(function() {
			if ($(this).val().trim() == "") {
				$(this).next().attr("color", "red").text("此项必填。请重新输入!");
			} else {
				$(this).next().attr("color", "green").text("√");
			}
		});
        });
		//验证邮编格式

		$("#postCode").blur(function() {
			var regExp = new RegExp("[0-9]{6}");
			if (!regExp.test($(this).val().trim())) {
				$(this).next().attr("color", "red").text("请输入正确的邮编号!");
			} else {
				$(this).next().attr("color", "green").text("√");
			}
		});
		//验证电话格式
		$("#phone").blur(function() {
			var regExp = new RegExp("[0-9]{11}");
			if (!regExp.test($(this).val().trim())) {
				$(this).next().attr("color", "red").text("请输入正确的电话号码!");
			} else {
				$(this).next().attr("color", "green").text("√");
			}
		});
		
		$("#resetBtn").click(function() {
			$(".input").each(function() {
				$(this).val(this.defaultValue);
				$(this).next().text("");
			});
		});
		$("#sumbitBtn").click(function() {
			var flag = true;
			var i = 0;
			$(".input").each(function() {
				if ($(this).next().text().trim() != "√"&&$(this).next().text().trim() !="") {
					flag = false;
					return;
				}
				if ($(this).next().text().trim() == "") {
					i++;
				}
			});
			if (i == 4) {
				if (confirm("没有修改任何一项，是否继续？")) {
					$("#editFprm").submit();
				} else{
					return;
					}
			}else if(flag){
				alert("tj");
				$("#editForm").submit();
			}else{
				alert("请检查输入项是否符合要求!");
				return;
				}
		});
	});
</script>
<sb:head />
</head>
<body>
	
		<s:form action="userOrder_userOrderEdit" id="editForm" theme="simple">
		
			<table class="table table-bordered table-striped table-hover">
				<tr class="success">
					<td><label>订单编号</label></td>
					<td><input type="text" value="${userOrder.orderId }"
						name="userOrder.orderId" readonly="readonly" />
				</tr>
				<tr class="error">
					<td><label>用户名</label></td>
					<td><input type="text" value="${userOrder.userName }"
						name="userOrder.userName" readonly="readonly" /></td>
				</tr>
				<tr class="success">
					<td><label>真实姓名<font color="red">*</font></label></td>
					<td><input type="text" value="${userOrder.realName }"
						class="input" name="userOrder.realName" /><font></font></td>
				</tr>
				<tr class="error">
					<td><label>地址<font color="red">*</font></label></td>
					<td><input type="text" value="${userOrder.address }"
						class="input" name="userOrder.address" /><font></font></td>
				</tr>
				<tr class="success">
					<td><label>邮政编码<font color="red">*</font></label></td>
					<td><input type="text" id="postCode"
						value="${userOrder.postCode }" class="input"
						name="userOrder.postCode" maxlength="6"/><font></font></td>
				</tr>
				<tr class="error">
					<td><label>电话<font color="red">*</font></label></td>
					<td><input type="text" id="phone" value="${userOrder.phone }"
						class="input" name="userOrder.phone" maxlength="11"/><font></font></td>
				</tr>
				<tr class="success">
					<td><label>订单时间</label></td>
					<td><input type="text" value="${userOrder.orderDate }"
						name="userOrder.orderDate" readonly="readonly" /></td>
				</tr>
				<tr class="error">
					<td><label>订单状态</label></td>
					<td><s:if test="userOrder.flag==0">
							<input type="text" readonly="readonly" value="未发货" />
						</s:if> <s:elseif test="userOrder.flag==1">
							<input type="text" readonly="readonly" value="已发货" />
						</s:elseif> <s:else>
							<input type="text" readonly="readonly" value="已完成" />
						</s:else></td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<input type="button" id="resetBtn" class="btn" value="重置" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" id="sumbitBtn" class="btn" value="修改" />
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	
</body>
</html>