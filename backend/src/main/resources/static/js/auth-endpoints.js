function executeGet(url, component){
    $.get(url, function(result){
       $(component).html(result);
    }).fail(function(result) {
        $(component).html(JSON.stringify(result.responseJSON, null, "\t"));
});
}

$("#adminButton").click(function() {
  executeGet("/payload/admin","#outputAdmin");
});

$("#reviewerButton").click(function() {
  executeGet("/payload/reviewer","#outputReviewer");
});

$("#userButton").click(function() {
  executeGet("/payload/user","#outputUser");
});