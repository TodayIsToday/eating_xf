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
	<label>早饭<input type="radio" name="eating" value="0"/></label>&nbsp;
	<label>中饭<input type="radio" name="eating" value="1"/></label>&nbsp;
	<label>晚饭<input type="radio" name="eating" value="2"/></label>&nbsp;
	<br>
	<br>
	<label>费用<input type="number" name="cost" min="0.01" max="500" step="100"/></label>
	<s:submit value="付款"/>
</s:form>
</body>
</html>