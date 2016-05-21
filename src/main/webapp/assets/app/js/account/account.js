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
			init : function(  ){
				console.log('init testing');
				this._payment();
			},
			
			/**
			 * 管理员充值
			 */
			_payment : function(){
				
				alert('payment');
			}
		};
		
		return UserAccount;
	});
})();
