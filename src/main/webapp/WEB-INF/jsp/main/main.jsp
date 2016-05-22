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
		<div class="col_1">
			<div class="col-md-4 span_7">
				<div class="cal1 cal_2"></div>
				<div class="clearfix"></div>
			</div>
			<div class="content_bottom">
				<div class="col-md-8 span_3">
					<div class="bs-example1" data-example-id="contextual-table">
						<table class="table">
							<thead>
								<tr>
									<th>姓名</th>
									<th>余as</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="acciontDetails" var="item" status="st">
									<tr <s:if test="#st.even"> class="warning"</s:if>>
										<td><s:property value="personBalanceOfCare" /></td>
										<td><s:property value="userName" /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="copy">
				<p>Copyright &copy; 2016.Company xf</p>
			</div>
		</div>
		<!-- /#page-wrapper -->
		<p>
welcome:<s:property value="getCurrentUser().getUserName()"/>
</p>

<s:form namespace="/security" action="logout">
	<s:submit value="注销"/>
</s:form>

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
		
	</div>
</body>
</html>