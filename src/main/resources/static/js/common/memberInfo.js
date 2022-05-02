$(document).ready(function(){

    $(function () {
        $.ajax({
            url: "/member/loginMemberInformation",
            success: function (data) {

                if(data.memberDivision == "본사") {

                    $("#memberName").val(data.memberName);
                    $("#memberInfo-cellPhone").val(data.memberCellPhone);
                    $("#memberInfo-officePhone").val(data.officePhoneNumber);
                    $("#memberInfo-email").val(data.memberEmail);

                } else if(data.memberDivision == "가맹점" && data.officeDivision == "대표자") {

                    console.log(data);
                    console.log(data.supervisor)
                    $("#memberInfo-memberName").val(data.representativeName);
                    $("#memberInfo-cellPhone").val(data.representativePhone);
                    $("#memberInfo-franchisePhone").val(data.phone);
                    $("#memberInfo-email").val(data.representativeEmail);
                    $("#memberInfo-branchName").val(data.branchName);
                    $("#memberInfo-businessRegistrationNo").val(data.businessRegistrationNo);
                    $("#memberInfo-address").val(data.address);
                    $("#memberInfo-bankAccountNo").val(data.bankAccountNo);
                    $("#memberInfo-supervisor").val(data.supervisor.memberName);
                    $("#memberInfo-department").val(data.supervisor.department.departmentName);

                } else if(data.memberDivision == "가맹점" && data.officeDivision == "직원") {

                    console.log(data);
                    console.log(data.managerPhone)
                    $("#memberInfo-memberName").val(data.managerName);
                    $("#memberInfo-cellPhone1").val(data.managerPhone);
                    $("#memberInfo-branchName").val(data.franchiseInfo.branchName);
                    $("#memberInfo-supervisor").val(data.franchiseInfo.supervisor.memberName);
                    $("#memberInfo-department").val(data.franchiseInfo.supervisor.department.departmentName);
                    $("#memberInfo-address").val(data.franchiseInfo.address);
                    $("#memberInfo-franchisePhone").val(data.franchiseInfo.phone);
                    $("#memberInfo-email1").val(data.managerEmail);

                }

            },
            error:function (xhr) {
                console.log(xhr);
            }
        });
    });

});

