/**
 * 登记js
 */
;(function() {
	"use strict";
	define([ 'jquery' ,'app/utils/serializeObject'], function($) {

		var UserAccount = $.UserAccount = {
			/**
			 * init
			 */
			init : function( options ){
				this._payment( options );
			},
			
			/**
			 * 管理员充值
			 */
			_payment : function( options ){
				var self = this;
				$('body').on('click','[data-button="admin-payment"]',function(){
					
					var $btn = $(this),
						formDate = {},
						jsonDate = {};
					
					formDate = $('[data-class="admin-payment-form"]').serialize();
					jsonDate = $('[data-class="admin-payment-form"]').serializeObject();
					
					$.ajax({
						type  : 'POST',
						url   : options.paymentURL,
						data  : formDate,
						cache : false,
						success : function( result ){
							if(result.ajaxFlg === true){
								var userUuid = jsonDate['baseUserAccount.userUuid'];
								var payment = + $('input[name="baseUserAccount.totalAccount"]').val();
								var payUser = "";
								var bfAccount = + $('tbody').find('td').filter("[data-class="+userUuid+"]").text().trim();
								$('tbody').find('td').filter("[data-class="+userUuid+"]").text( payment + bfAccount );
								alert('充值成功!'+payUser+'卡内余额'+ (payment + bfAccount));
							}else{
								alert('充值失败，请联系管理员');
							}
						},
						fail	: function(){
							alert('失败')
						}
					
					});
				});
				return this;
			}
		};
		
		return UserAccount;
	});
})();
