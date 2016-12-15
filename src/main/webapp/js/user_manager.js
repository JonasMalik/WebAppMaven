/**
 * Created by jonas on 2016-05-23.
 */

var userValues = [];

$(function() {

    $("#popup_close").click(function() {
        $('#popBg').hide();
        $('#popUp').hide();
        reset();
    });

});

function getRowIndex(row) {

    reset();
    $('#popBg').show();
    $('#popUp').fadeIn(500);
    userValues.push(row.cells[0].innerHTML);
    userValues.push(row.cells[1].innerHTML);
    userValues.push(row.cells[2].innerHTML);
    userValues.push(row.cells[3].innerHTML);
    userValues.push(row.cells[4].innerHTML);
    $("#popup_id").val(userValues[0]);
    $("#popup_name").val(userValues[1]);
    $("#popup_email").val(userValues[2]);
    $("#popup_password").val(userValues[3]);
    $('#popup_role option[value='+userValues[4]+']').attr('selected','selected');
}

function reset() {
    
    userValues = [];
    $("#username").val("");
    $("#password").val("");
    $("#role").val("");
    $("#activation").val("");
}
