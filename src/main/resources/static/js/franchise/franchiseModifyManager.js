$(document).ready(function(){

    <!-- password meter -->
    let options2 = {};
    options2.ui = {
        container: "#pwd-container2",
        showVerdictsInsideProgressBar: true,
        viewports: {
            progress: ".pwstrength_viewport_progress2"
        }
    };
    options2.common = {
        debug: false,
    };

    $('#managerPwd').pwstrength(options2);

    <!-- input mask, validation(password equality, length, email validation) -->
    $("#managerModifyForm").ready().validate({
        errorPlacement: function (error, element) {
            element.before(error);
        },
        rules: {
            memberPwd: {
                minlength: 8,
                maxlength: 15
            },
            confirm: {
                equalTo: "#managerPwd",
                minlength: 8,
                maxlength: 15
            },
            managerEmail: {
                email: true
            }
        }
    });
})

$("#btn-submit").click(function() {
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
                    $("#modifyForm").submit();
                })
            }
            else {
                swal("취소되었습니다.", "", "success");
            }
        });
});