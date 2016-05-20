<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
!(function() {
	"use strict";
	require(['jquery','app/login/login'], function ($,ls){
		
	});
})();
</script>
</head>
<body>
<s:form action="" namespace="/" method="post">
	
	<label>充值<input type="number" name="cost" min="100" max="100.00" step="100.00"/></label>
	
	<label>预付人：</label>
	<s:select list="xfUserList" 
			  headerValue="--请选择--"
			  headerKey=""
			  name="userName"
			  value="loginName"
			  listValue="userName"
			  listKey="loginName"/>
	<s:submit value="充值"/>
</s:form>
<hr/>
</body>
</html>