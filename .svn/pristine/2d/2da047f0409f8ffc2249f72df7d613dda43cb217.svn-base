<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加</title>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	$("#supertypeselect").change(function(){
		var supertypeid=$("#supertypeselect").val();
		$.ajax({
		    url:'<%=basePath%>/product/subtypecascade_getSubType.action',
			type : 'post',
			dataType : 'json',
			data : {e_supertypeid : supertypeid},
			success : createSubtype
		});
	});
	function createSubtype(json) {
		var dataObjs = (json.subTypes);
		$("#subtypeselect option[value!='']").remove();
		$.each(dataObjs, function(i, subType) {
			$option = $("<option></option>");
			$option.attr("value", subType.subtypeid);
			$option.text(subType.subtypename);
			$("#subtypeselect").append($option);
		});
	};
	$("#subtypeselect").change(function(){
		var subtypeid=$("#subtypeselect").val();
		$.ajax({
		    url:'<%=basePath%>/product/subtypecascade_getAttrs.action',
			type : 'post',
			dataType : 'json',
			data : {e_subtypeid : subtypeid},
			success : createAttrs
		});
	});
	//创建属性
	function createAttrs(json) {
			var dataObjs = (json.attrs1);
			$("table tr[class='attrtr']").remove();
			$.each(dataObjs, function(i, attr) {
				$tr = $("<tr></tr>");
				$tr.attr("class","attrtr");
				$td1 = $("<td></td>");
				$td1.text(attr.attrname);
				$input1 = $("<input type='hidden'>");
				$input1.attr("name","productattrs["+i+"].attrid");
				$input1.attr("value",attr.attrid);
				$td1.append($input1); 
				$td2 = $("<td></td>");
				if (attr.attrtype > 0) {
					$select = $("<select></select>");
					$select.attr("name","productattrs["+i+"].attrvalue");
					var str = new Array();
					str = attr.attrvalue.split('\\n');
					for (i=0;i<str.length ;i++ ){
					    $option = $("<option></option>");
					    /* $option.attr("value", attr.attrvalue); */
					    $option.text(str[i]);
					    $select.append($option);
				    } 
					$td2.append($select);
				}else{
					$input = $("<input type='text'>");
					$input.attr("name","productattrs["+i+"].attrvalue");
					$td2.append($input);
				}
				$tr.append($td1).append($td2);
				$tr.insertBefore($("#addBtn"));
			});

		};
	});
</script>
<sb:head/>
</head>
<body>
<div align="center">
		<form action="<%=basePath %>/product/productattr_add.action" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>选择类别：</td>
					<td>
					<select name="product.supertypeid" id="supertypeselect">
						<option name="">..请选择大类..</option>
						<s:iterator value="superTypes" var="superType">
							<option value='<s:property value="#superType.supertypeid" />'><s:property value="#superType.supertypename" /></option>
						</s:iterator>
					</select><br>
					<select name="product.subtypeid" id="subtypeselect">
					<option value="">..请选择小类..</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>产品名称：</td>
					<td>
					<input type="text" name="product.productname">
					</td>
				</tr>
				<tr>
					<td>品牌：</td>
					<td><input type="text" name="product.brand" >
					</td>
				</tr>
				<tr>
					<td>相关介绍:</td>
					<td><textarea rows="5" cols="20" name="product.introduce"></textarea></td>
				</tr>
				<tr>
					<td>原价:</td>
					<td><input type="text" name="product.price" ></td>
				</tr>
				<tr>
					<td>现价:</td>
					<td><input type="text" name="product.nowprice" ></td>
				</tr>
				<tr>
					<td>图片:</td>
					<td><input type="file" name="upload" accept="image/*">
					</td>
				</tr>
				<tr>
					<td>数量:</td>
					<td><input type="text" name="product.productnum" ></td>
				</tr>
				<tr>
					<td>商品来源：</td>
					<td>
					 <input type="text" name="product.origin"></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td>
					 <input type="checkbox" name="product.ishost" value="1">&nbsp;热卖&nbsp;
					 <input type="checkbox" name="product.isnew" value="1">&nbsp;新品&nbsp;
					 <input type="checkbox" name="product.issale" value="1">&nbsp;特价&nbsp;
					 <input type="checkbox" name="product.isspecial" value="1">&nbsp;推荐</td>
				</tr>
				<tr id="addBtn">
					<td><input type="submit" value="添加"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>