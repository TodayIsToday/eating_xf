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
<p>
welcome:<s:property value="getCurrentUser().getUserName()"/>
</p>

<s:form namespace="/security" action="logout">
	<s:submit value="注销"/>
</s:form>
<body>

<s:iterator value="getCurrentUserRole()" var="item">
	<s:if test="#item.roleCode == 'rc_000'">
		<!-- 管理员画面 -->
		<s:form namespace="/account" action="init">
			<s:submit value="充值"/>
		</s:form>
	</s:if>
</s:iterator>
<!-- 计费画面 -->
<s:include value="/WEB-INF/jsp/account/account_common.jsp" />
</body>
</html>