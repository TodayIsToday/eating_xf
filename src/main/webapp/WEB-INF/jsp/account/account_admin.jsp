<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
!(function() {
	"use strict";
	require(['jquery','app/account/account'], function ($,account){
		account.init({
			paymentURL : '<s:url namespace="/account" action="payment"/>'	// 充值
		});
	});
})();
</script>
</head>
<body>
	<form data-class="admin-payment-form">
		<label>充值
			<input type="number" name="baseUserAccount.totalAccount" min="100" max="500.00" step="100.00"/>
		</label>
		
		<label>预付人：
		<s:select list="xfUserList" 
				  headerValue="--请选择--"
				  headerKey=""
				  name="baseUserAccount.userUuid"
				  value="baseUserAccount.userUuid"
				  listValue="userName"
				  listKey="userUuid"/>
		</label>
		<!-- button -->
		<a href="javascript:void(0)" class="btn btn-primary" data-button="admin-payment">充值</a>
	<form>
	<hr/>
</body>
</html>