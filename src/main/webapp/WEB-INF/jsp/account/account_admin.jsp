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
		<div class="graphs">
			<div class="xs">
				<h3>管理员充值</h3>
					<div class="col-md-4 span_3">
						<div class="bs-example1" data-example-id="contextual-table">
							<table class="table">
								<thead>
									<tr>
										<th>姓名</th>
										<th>余额</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="acciontDetails" var="item" status="st">
										<tr <s:if test="#st.even"> class="warning"</s:if>>
											<td><s:property value="userName" /></td>
											<td data-class="<s:property value="userUuid" />">
												<s:property value="personBalanceOfCare" />
											</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
				<!-- /充值 -->
				<div class="col-md-8 span_3">
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
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
		<!-- /#page-wrapper -->
		<div class="copy">
			<p>Copyright &copy; 2016.Company xf</p>
		</div>
</body>
</html>