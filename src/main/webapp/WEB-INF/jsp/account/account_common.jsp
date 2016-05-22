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


<s:form action="insertCommon" namespace="/account" method="post" cssClass="form-horizontal">
		<div class="control-group">
			<div class="controls">
				<label class="radio"> 
					<input type="radio" name="baseAccount.accountType" value="0" checked>
					早饭
				</label>
				<label class="radio">
					<input type="radio" name="baseAccount.accountType" value="1">
					中饭
				</label>
				<label class="radio">
					<input type="radio" name="baseAccount.accountType" value="2">
					晚饭
				</label>
				<br>
				<label class="control-label">费用</label>
				<input type="number" min="0.0" max="100.0" step="0.1" name="baseAccount.totalPrice" style="height:30px"/>
				<s:submit value="付款" cssClass="btn btn-primary"/>
			</div>
		</div>
		<br>
</s:form>
<hr>
消费记录
		<table>
			<tr>
				<th>消费类型</th>
				<th>消费金额</th>
				<th>消费时间</th>
			</tr>
			<s:iterator value="accountCommon.baseAccounts">
				<tr>
					<td>
						<s:if test="accountType==0">早饭</s:if>
						<s:if test="accountType==1">中饭</s:if>
						<s:if test="accountType==2">晚饭</s:if>
						<s:if test="accountType==3">其他</s:if>
					</td>
					<td><s:property value="totalPrice" /></td>
					<td><s:property value="createTime" /></td>
				</tr>
			</s:iterator>
		</table>
消费总计：<s:property value="accountCommon.accountSum" />
</body>
</html>