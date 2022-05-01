$(document).ready(function(){

    $(function () {
        $.ajax({
            url: "/member/loginMemberInformation",
            success: function (data) {
                console.log(data);
                console.log(data.department.departmentName)
                console.log(data.memberDivision)

                $("#memberName").text(data.memberName);
                $("#department").text(data.department.departmentName);
                $("#memberEmail2").text(data.memberEmail);
            },
            error:function (xhr) {
                console.log(xhr);
            }
        });
    });

});

