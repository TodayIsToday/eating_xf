/**
 * 登记js
 */
;(function() {
	"use strict";
	define([ 'jquery' ], function($) {

		var UserAccount = function(options) {
			this._init(options);
		};

		UserAccount.prototype = {

			constructor : UserAccount,

			_init : function() {
				console.log('asdfas');
				this.options = $.extend( {}, $.UserAccount.defaults, typeof options == 'object' && options );
			},
		}
		
	});
	
	$.UserAccount = function(options) {
		return new UserAccount(options);
	};
	$.UserAccount.defaults = {
			paymentURL : ''
	}
})();
