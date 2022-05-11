$("#add").submit(function(e) {
    e.preventDefault();

    var form = $(this);
    var actionUrl = form.attr('action');

    var request = $.ajax({
        type: "PUT",
        url: actionUrl,
        contentType: "application/json",
        data: JSON.stringify(getFormData(form))
    });
    request.done(function(data) {
        $("#status").html('OK');
    })
    request.fail(function(data) {
        $("#status").html('USER ALREADY EXIST');
    });

    function getFormData(form) {
        var unindexed_array = form.serializeArray();
        var indexed_array = {};

        $.map(unindexed_array, function(n, i) {
            indexed_array[n['name']] = n['value'];
        });

        return indexed_array;
    }
});