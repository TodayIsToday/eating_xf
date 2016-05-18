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
      
      // bootstrap
      // --------------
      'bootstrap'              : 'vendors/bootstrap/js/bootstrap.min',

      // Lib
      // --------------
      'underscore' : 'vendors/underscore/js/underscore-min',

      // Application Folders
      // -------------------
      'app': 'app/js'

    },
    shim : {
      // bootstrap
      // --------------
      'bootstrap'              : { deps: ['jquery'] },

      // Lib
      // -------
      'underscore' : { exports: '_' },
    }
  });
})();
</script>

