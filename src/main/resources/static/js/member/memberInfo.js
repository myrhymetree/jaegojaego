 $(function () {
        $.ajax({
            url: "/member/loginMemberInformation",
            success: function (data) {

                console.log("모달정보");

                console.log(data)
                console.log(data.memberCellPhone)

                $("#memberCellPhone2").val(data.memberCellPhone);
                $("#officePhoneNumber2").val(data.officePhoneNumber);
                // $("#memberEmail2").text(data.memberEmail);

            },
            error:function (xhr) {
                console.log(xhr);
            }
        });
    });


