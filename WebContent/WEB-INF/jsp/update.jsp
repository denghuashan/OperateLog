<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index JSP</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath }/UpdateServlet">
		<table>
			<tr>
				<td>编号：</td>
				<td><input type="text" name="id" value="${userInfo.id}"/></td>
			</tr>
			<tr>
				<td>中文姓名：</td>
				<td><input type="text" name="nameZh" value="${userInfo.nameZh}"/></td>
			</tr>
			<tr>
				<td>英文姓名：</td>
				<td><input type="text" name="nameEn" value="${userInfo.nameEn}"/></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age" value="${userInfo.age}"/></td>
			</tr>
			<tr>
				<td>类型：</td>
				<td><input type="text" name="type" value="${userInfo.type}"/></td>
			</tr>
			<tr>
				<td>日期：</td>
				<td><input type="text" name="birthday" value="<fmt:formatDate value='${userInfo.birthday}' pattern='yyyy-MM-dd HH:mm:ss'/>"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="修改"/></td>
			</tr>
		</table>
	</form>
	
	<c:if test="${operateLog != null}">
		<td colspan="2">
			<b>操作记录：</b><font color="red">${operateLog}</font>
		</td>
	</c:if>
</body>
</html>