$(document).ready(function(){

    $("#modifyByAdminForm").children("input[class='form-control']").empty();

    <!-- password meter -->
    let options1 = {};
    options1.ui = {
        container: "#emplyee-pwd-container",
        showVerdictsInsideProgressBar: true,
        viewports: {
            progress: "#employee_pwstrength"
        }
    };
    options1.common = {
        debug: false,
    };

    $('#memberPwd5').pwstrength(options1);

    $("#employeeDepartment").select2({
        theme: 'bootstrap4',
        placeholder: "부서를 선택하세요.",
        allowClear: false
    });

    <!-- input mask, validation(password equality, length, email validation) -->
    $("#modifyByAdminForm").ready().validate({
        errorPlacement: function (error, element) {
            element.before(error);
        },
        rules: {
            memberPwd: {
                minlength: 8,
                maxlength: 15
            },
            confirm: {
                equalTo: "#memberPwd5",
                minlength: 8,
                maxlength: 15
            },
            email: {
                email: true
            }
        }
    });
})

$("#btn-member-submit").click(function() {
    swal({
            title: "계정생성을 하시겠습니까?",
            text: "계정 생성이 완료됩니다.",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#1AB35",
            confirmButtonText: "등록",
            cancelButtonText: "취소",
            closeOnConfirm: false,
            closeOnCancel: false
        },

        function (isConfirm) {
            if (isConfirm) {
                swal({
                    title: "본사 계정 생성 완료",
                    text: "본사 계정 생성이 완료되었습니다.",
                    type: "success",
                }, function () {
                    $("#modifyByAdminForm").submit();
                })
            }
            else {
                swal("취소되었습니다.", "", "success");
            }
        });
});