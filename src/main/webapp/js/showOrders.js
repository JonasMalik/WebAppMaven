/**
 * Created by jonas on 2016-03-30.
 */
    
var counter = 0;

$(function() {
     getOrders();
});

function getOrders() {

    $(document).ajaxStart(function() {
        $("#table1 > tbody > tr").remove();
        $("#table1").hide();
        $("#loader").fadeIn(1000);
    });
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/home/showDB",
        contentType: "application/json",
        dataType: "json",
        data: {"filter": "FILTER_ALL"},

        success: function(data) {

            var j = 0;
            var n = 0;
            while (i<data.length) {
                var id = data[i].Id;
                var date = data[i].DateOfOrder;
                var name = data[i].FirstName+" "+data[i].LastName;
                //var phone = data[i].Phone;
                var email = data[i].Email;
                var newData = data[i].NewData;
                var status = data[i].Status;

                loadRow(id, date, name, email, newData, status);
                i++;
            }
            $("#loader").fadeOut(1000);
            $("#table1").delay(1000).fadeIn(2000);
        },
    });
}

function loadRow(tempId, tempDate,tempName, tempEmail, tempNewData, tempStatus){

    $('#t1:last').append("<tr onclick='getRowIndex(this);'></tr>");
    $('#t1 tr:last').append("<td>" + tempId + "</td>")
                    .append("<td>" + tempDate + "</td>")
                    .append("<td>" + tempName + "</td>")
                    .append("<td>" + tempEmail + "</td>")
                    .append("<td>" + tempNewData + "</td>")
                    .append("<td>" + tempStatus + "</td>");
}