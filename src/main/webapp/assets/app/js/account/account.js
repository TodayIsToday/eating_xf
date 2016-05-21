/**
 * 登记js
 */
;(function() {
	"use strict";
	define([ 'jquery' ], function($) {

		var UserAccount = $.UserAccount = {
			/**
			 * init
			 */
			init : function( options ){
				console.log('init testing');
				this._payment( options );
			},
			
			/**
			 * 管理员充值
			 */
			_payment : function( options ){
				var self = this;
				$('body').on('click','[data-button="admin-payment"]',function(){
					
					var $btn = $(this),
						formDate = {};
					
					formDate = $('[data-class="admin-payment-form"]').serialize();
					
					$.ajax({
						type  : 'POST',
						url   : options.paymentURL,
						data  : formDate,
						cache : false,
						success : function( result ){
							if(result.ajaxFlg === true){
								alert('充值成功');
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
