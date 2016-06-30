<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	!(function() {
		"use strict";
		require([ 'jquery', 'metisMenu' ], function($) {
		});
	})();
</script>
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Modern</a>
		</div>
		<!-- /.navbar-header -->
		<ul class="nav navbar-nav navbar-right">
			
		</ul>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper">
		<p>
			welcome:<s:property value="getCurrentUser().getUserName()"/>
		</p>
		<p>
			余额:<s:property value="getCurrentUserBalanceOfCard()"/>
		</p>
		<s:form namespace="/security" action="logout">
			<input type="submit" class="btn btn-primary" value="注销" />
		</s:form>
		
		<s:action name="common" namespace="/account" executeResult="true"></s:action>
		
		<s:iterator value="getCurrentUserRole()" var="item">
			<s:if test="#item.roleCode == 'rc_000'">
				<!-- 管理员画面 -->
				<s:form namespace="/account" action="init">
					<input type="submit" class="btn btn-primary" value="充值" />
				</s:form>
			</s:if>
		</s:iterator>
	</div>
</body>
</html>