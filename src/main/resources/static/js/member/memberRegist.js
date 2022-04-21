$(document).ready(function(){

    <!-- password meter -->
    var options1 = {};
    options1.ui = {
        container: "#pwd-container2",
        showVerdictsInsideProgressBar: true,
        viewports: {
            progress: ".pwstrength_viewport_progress"
        }
    };
    options1.common = {
        debug: false,
    };

    $('.example2').pwstrength(options1);

    <!-- input mask, validation(password equality, length, email validation) -->
    $("#registForm").ready().validate({
        errorPlacement: function (error, element) {
            element.before(error);
        },
        rules: {
            memberId: {
              empty: true
            },
            confirm: {
                equalTo: "#memberPwd",
            },
            memberPwd: {
                minlength: 8,
                maxlength: 15,
                empty: true
            }
        }
    });

    $(".select2_demo_1").select2({
        theme: 'bootstrap4',
    });
    $(".select2_demo_2").select2({
        theme: 'bootstrap4',
    });
    $(".select2_demo_3").select2({
        theme: 'bootstrap4',
        placeholder: "부서를 선택하세요.",
        allowClear: true
    });
})

$(function () {
    $.ajax({
        url: "/member/department",
        success: function (data) {
            const $departmentNo = $("#departmentNo");
            $departmentNo.html("");

            $departmentNo.append($("<option>"))

            for (let index in data) {
                $departmentNo.append($("<option>").val(data[index].departmentNo).text(data[index].departmentName));
            }

            $('#memberId').val('');
            $('#memberPwd').val('');
            $('#email').val('');

        },
        error:function (xhr) {
            console.log(xhr);
        }
    });
});

$(function () {
    $.ajax({
        url: "/member/duplicateId",
        success: function (data) {
            const $idContainer = $("#idContainer");

            $departmentNo.append($("<option>"))

            for (let index in data) {
                $departmentNo.append($("<option>").val(data[index].departmentNo).text(data[index].departmentName));
            }

            $('#memberId').val('');
            $('#memberPwd').val('');
            $('#email').val('');
            $('#memberName').val('');

        },
        error:function (xhr) {
            console.log(xhr);
        }
    });
});

