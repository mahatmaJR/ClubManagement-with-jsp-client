// function convertFormToJson(createMember){
//     var array = jQuery(createMember).serializeArray();
//     var json = {};
//
//     jQuery.each(array, function () {
//         json[this.name] = this.value ||"";
//     });
//
//     return json.stringify();
// }
//
// jQuery(document).on('ready', function () {
//     jQuery('form#createMember').bind('submit', function (event) {
//         event.preventDefault();
//
//         var form = this;
//         var json = convertFormToJson(form);
//         var tbody = jQuery('#createdMember > tbody');
//
//         $.ajax({
//             type : "POST",
//             url : "http://localhost:8080/ClubManagement/api/member/addMember",
//             data : json,
//             dataType : "json",
//             contentType : "application/json"
//         }).done(function () {
//             alert("success");
//         }).fail(function () {
//             alert("Failed");
//         });
//
//         return true;
//     });
// });




$(document).ready(function(){
    $("#submitBtn").click(function () {
        submitData();
    });
});

function submitData() {
    var member = {
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        email: $("#email").val(),
        mobileNo: $("#mobileNo").val(),
    };

    var jsonMemberObject = JSON.stringify(member);

    $.ajax({
        url: "http://localhost:8080/ClubManagement/api/member/addMember",
        type: "POST",
        dataType: "json",
        data: jsonMemberObject,
        context: document.body,
        contentType: "application/json",
        mimeType: "application/json"
    }).done(function () {
        alert("success");
    }).fail(function () {
        alert("Failed");
    });

    document.getElementById('jsonData').value = jsonMemberObject;
}