$(document).ready(function(){

    // $(".dropdown-menu").click( function () {

        $(function () {
            $.ajax({
                url: "/member/loginMemberInformation",
                success: function (data) {

                    if(data.memberDivision == "본사") {

                        console.log(data);

                        $("#memberInfo-memberName").val(data.memberName);
                        $("#memberInfo-cellPhone").val(data.memberCellPhone);
                        $("#memberInfo-officePhone").val(data.officePhoneNumber);
                        $("#memberInfo-email").val(data.memberEmail);
                        $("#memberInfo-department").val(data.department.departmentName);
                        $("#memberInfo-cellPhone").val(data.memberCellPhone);
                        $("#memberInfo-officePhone").val(data.officePhoneNumber);

                    } else if(data.memberDivision == "가맹점" && data.officeDivision == "대표자") {

                        console.log(data);
                        console.log(data.supervisor)
                        $("#franchiseInfo-memberName").val(data.representativeName);
                        $("#franchiseInfo-cellPhone").val(data.representativePhone);
                        $("#franchiseInfo-franchisePhone").val(data.phone);
                        $("#franchiseInfo-email").val(data.representativeEmail);
                        $("#franchiseInfo-branchName").val(data.branchName);
                        $("#franchiseInfo-businessRegistrationNo").val(data.businessRegistrationNo);
                        $("#franchiseInfo-address").val(data.address);
                        $("#franchiseInfo-bankAccountNo").val(data.bankAccountNo);
                        $("#franchiseInfo-supervisor").val(data.supervisor.memberName);
                        $("#franchiseInfo-department").val(data.supervisor.department.departmentName);

                    } else if(data.memberDivision == "가맹점" && data.officeDivision == "직원") {

                        console.log(data);
                        console.log(data.managerPhone)
                        $("#managerInfo-memberName").val(data.managerName);
                        $("#managerInfo-cellPhone").val(data.managerPhone);
                        $("#managerInfo-branchName").val(data.franchiseInfo.branchName);
                        $("#managerInfo-supervisor").val(data.franchiseInfo.supervisor.memberName);
                        $("#managerInfo-department").val(data.franchiseInfo.supervisor.department.departmentName);
                        $("#managerInfo-address").val(data.franchiseInfo.address);
                        $("#managerInfo-franchisePhone").val(data.franchiseInfo.phone);
                        $("#managerInfo-email1").val(data.managerEmail);

                    }

                },
                error:function (xhr) {
                    console.log(xhr);
                }
            });
        });

    // });
});

