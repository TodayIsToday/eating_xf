<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
!(function() {
	"use strict";
	require(['jquery','app/login/login'], function ($,ls){
		$(".moreAccount").on("click",function(){moreAccount()});
		var moreAccount = function(){
			$.post({
				url:"/eating/account/common.do",
				data:{},
				dataType:"json",
				success:function(accountCommons){
					//$("#accountSum").text("[消费总计："+accountCommon.accountSum+"]");
					for (var i=0;i<accountCommons.length;i++){
						var account = accountCommons[i];
						$(".moreAccount").parent().before(
								"<tr>"+
								"<th>"+account.accountTypeName+"</th>"+
								"<th>"+account.totalPrice+"</th>"+
								"<th>"+account.dateTime+"</th>"+
								"</tr>"
						);
					}
				}
			});
		};
		moreAccount();
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
				<label class="radio">
					<input type="radio" name="baseAccount.accountType" value="3">
					其他：我想买点粽子
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
消费记录<span id="accountSum" style="color: red;"></span>
		<table>
			<tr>
				<th>消费类型</th>
				<th>消费金额</th>
				<th>消费时间</th>
			</tr>
			<tr>
				<th class="moreAccount" colspan="3"><a>︾</a></th>
			</tr>
		</table>
		
</body>
</html>