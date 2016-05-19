/**
 * 登记js
 */
;
(function() {
	"use strict";
	define([ 'jquery' ], function($) {

		var Login = function(options) {
			this._init(options);
		};

		Login.prototype = {

			constructor : Login,

			_init : function() {
				this.options = $.extend( {}, $.Login.defaults, typeof options == 'object' && options );
				this.test();
			},
			test : function(){
				alert('testing..')
			}
		},
		
		$.Login = function(options) {
			return new Login(options);
		};
	});
})();
