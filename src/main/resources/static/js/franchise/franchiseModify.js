$(document).ready(function(){

    <!-- password meter -->
    let options3 = {};
    options3.ui = {
        container: "#pwd-container3",
        showVerdictsInsideProgressBar: true,
        viewports: {
            progress: ".pwstrength_viewport_progress3"
        }
    };
    options3.common = {
        debug: false,
    };

    $('#representativePwd').pwstrength(options3);

    <!-- input mask, validation(password equality, length, email validation) -->
    $("#franchiseModifyForm").ready().validate({
        errorPlacement: function (error, element) {
            element.before(error);
        },
        rules: {
            memberPwd: {
                minlength: 8,
                maxlength: 15
            },
            confirm: {
                equalTo: "#representativePwd",
                minlength: 8,
                maxlength: 15
            },
            representativeEmail: {
                email: true
            }
        }
    });
})

$("#btn-franchise-modify-submit").click(function() {
    swal({
            title: "계정수정을 하시겠습니까?",
            text: "계정 수정이 완료됩니다.",
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
                    title: "계정 정보 수정 완료",
                    text: "가맹점 대표자 계정 정보 계정 수정이 완료되었습니다.",
                    type: "success",
                }, function () {
                    $("#franchiseModifyForm").submit();
                })
            }
            else {
                swal("취소되었습니다.", "", "success");
            }
        });
});