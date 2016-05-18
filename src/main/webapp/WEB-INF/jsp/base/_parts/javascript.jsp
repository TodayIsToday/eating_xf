<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/base/tag.jsp" %>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lte IE 9]>
<script src="<%=request.getContextPath() %>/assets/vendors/respond/js/respond.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/vendors/html5shiv/js/html5shiv.min.js"></script>
<![endif]-->

<!-- RequirJS -->
<script src="<%=request.getContextPath()%>/assets/vendors/requirejs/js/require.js"></script>

<!-- RequirJS Core Configuration -->
<script type="text/javascript">
;(function() {
  /**
   * Intergration Requirejs
   *
   * @author zhangxiong
   */
  requirejs.config({
    baseUrl : '<%=request.getContextPath()%>/assets',

    urlArgs : window.urlArgs || '',
    
    waitSeconds: 15,

    paths : {
      // jQuery
      // --------------
      'jquery'           : 'vendors/jquery/js/jquery.min',
      'jquery-select2'   : 'vendors/jquery-select2/js/select2.min',
      'jquery.print'     : 'vendors/jquery-print/js/jQuery.print',
      'jquery.uploadify' : 'vendors/jquery-uploadify/js/jquery.uploadify.min',
      'jquery.blockUI'   : 'vendors/jquery-blockUI/js/jquery.blockUI',
      'jquery.numeric'   : 'lib/jquery-numeric/jquery.numeric.min',
      'jquery.jStorage'  : 'vendors/jStorage/js/jstorage.min',
      
      // bootstrap
      // --------------
      'bootstrap'              : 'vendors/bootstrap/js/bootstrap.min',
      'bootstrap.select'       : 'vendors/bootstrap-select/js/bootstrap-select.min',
      'bootstrap.datepicker'   : 'vendors/bootstrap-datepicker/js/bootstrap-datepicker.min',
      'bootstrap.modal'        : 'vendors/bootstrap-modal/js/bootstrap-modal',
      'bootstrap.modalmanager' : 'vendors/bootstrap-modal/js/bootstrap-modalmanager',

      // Lib
      // --------------
      'underscore' : 'vendors/underscore/js/underscore-min',
      'moment'     : "vendors/moment/js/moment.min",
      'mustache'   : "vendors/mustachejs/js/mustache.min",
      'nprogress'  : 'vendors/nprogress/js/nprogress',

      // Requirejs Plugins
      // --------------
      'domReady' : 'vendors/requirejs-domReady/js/domReady',

      // Application Folders
      // -------------------
      'app': 'app/js'

    },
    shim : {
      // bootstrap
      // --------------
      'bootstrap'              : { deps: ['jquery'] },
      'bootstrap.select'       : { deps: ['bootstrap'] },
      'bootstrap.datepicker'   : { deps: ['bootstrap'], exports: '$.fn.datepicker' },
      'bootstrap.modal'        : { deps: ['bootstrap'] },
      'bootstrap.modalmanager' : { deps: ['bootstrap'] },

      // Lib
      // -------
      'underscore' : { exports: '_' },
      'nprogress'  : { deps: ['jquery'] },

      // jQuery plugins
      // --------------
      'jquery-select2'   : { deps: ['jquery'] },
      'jquery.print'     : { deps: ['jquery'] },
      'jquery.uploadify' : { deps: ['jquery'] },
      'jquery.numeric'   : { deps: ['jquery'] },
      'jquery.jStorage'  : { deps: ['jquery'] }
    }
  });
})();
</script>

