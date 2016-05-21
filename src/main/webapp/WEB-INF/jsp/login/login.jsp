<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	!(function() {
		"use strict";
		
	})();
</script>
</head>
<body id="login">
	<div class="login-logo">
		<img src="<%=request.getContextPath() %>/assets/app/images/logo.png" alt="" />
	</div>
	<h2 class="form-heading">login</h2>
	<div class="app-cam">
		<s:form action="login" namespace="/security" method="post" >
			<input type="text" class="text" name="userName" value="<s:property value="userName"/>" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Login name';}">
			<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
			<div class="submit">
				<input type="submit" value="Login">
			</div>
		</s:form>
	</div>
	<div class="copy_layout login">
		<p>
			Copyright &copy; 2016.Company xf 
		</p>
	</div>
</body>
</html>