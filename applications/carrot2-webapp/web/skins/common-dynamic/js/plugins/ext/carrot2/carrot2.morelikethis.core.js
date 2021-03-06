/**
 * Adds a "search for more like this" functionality to the UI.
 */
(function($) {
  /**
   * Binds a handler for an event called when documents finish loading.
   */
  $(document).ready(function() {
    $("#clusters-panel").bind("carrot2-clusters-selected", function(target, clusterId, documents, clusterLabel) {
      $("#more-like-this").remove();
      if ($("#" + clusterId).is(".other")) {
        return;
      }
      
      // Handle a special case for by-url clustering
      var algorithm = $("#algorithm").val();
      var label;
      var prefix;
      if (algorithm != 'url') {
        label = "search for more like this";
        prefix = '';
      }
      else {
        label = "search this domain only";
        prefix = $("#query").val().replace(/\s*site:\S*/gi, '') + " site:";
      }
      
      $("<span id='more-like-this'>(<a href='#'>" + label + "</a>)</span>")
        .click(function() {
          $("#query").val(prefix + clusterLabel).get(0).form.submit();
          return false;
        }).appendTo("#documents-status");
    });
    
    $("#clusters-panel").bind("carrot2-clusters-selected-top", function() {
      $("#more-like-this").remove();
    });
  });
})(jQuery);

