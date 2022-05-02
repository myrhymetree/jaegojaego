$(document).ready(function(){

    $(function () {
        $.ajax({
            url: "/member/loginMemberInformation",
            success: function (data) {

                let member = data
                console.log(member)
                console.log(member.memberDivision == '본사')
                console.log()

                if(data.memberDivision == "본사") {

                    $("#memberName").val(data.memberName);
                    $("#memberInfo-cellPhone").val(data.memberCellPhone);
                    $("#memberInfo-officePhone").val(data.officePhoneNumber);
                    $("#memberInfo-email").val(data.memberEmail);

                } else if(data.memberDivision == "가맹점" && data.officeDivision == "대표자") {

                    console.log(data);
                    $("#memberInfo-cellPhone").val(data.representativePhone);
                    $("#memberInfo-officePhone").val(data.phone);
                    $("#memberInfo-email").val(data.representativeEmail);
                }

            },
            error:function (xhr) {
                console.log(xhr);
            }
        });
    });

});

