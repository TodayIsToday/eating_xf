/**
 * 序列化form表单数据to Object
 * 
 * Reference  
 * https://tobiascohen.com/files/stackoverflow/jquery-form-serializeObject.html
 */


!function(root, factory) {
	if (typeof define === 'function' && define.amd) {
		define([ 'jquery' ], factory);
	} else {
		factory(root.jQuery);
	}
}(this, function($) {

	'use strict';
	$.fn.serializeObject = function(){
		var obj = {};
		var arr = this.serializeArray();
		$.each( arr ,function(){
			if(obj[this.name] !==undefined){
				if(!obj[this.name].push){
					obj[this.name] = [obj[this.name]];
				}
				obj[this.name].push(this.value || '');
			}else{
				obj[this.name] = this.value || '';
			}
		});
		return obj;
	}
});
