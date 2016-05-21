<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
!(function() {
	"use strict";
	require(['jquery','app/login/login'], function ($){
		
		$.Login()
	});
})();
</script>
</head>
<body>
<s:form action="login" namespace="/security" method="post">
<label>姓名：</label>
<input name="userName" value="<s:property value="userName"/>">
</s:form>
</body>
</html>