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
            },
            name: {
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
            $('#memberName').val('');

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

            $idContainer.append($("<option>"))

            for (let index in data) {
                $idContainer.append($("<option>").val(data[index].departmentNo).text(data[index].departmentName));
            }

        },
        error:function (xhr) {
            console.log(xhr);
        }
    });
});

$(function() {
    $("input[name='memberId']").on("change", function (){
       let memberId = $("memberId").val();

       $.ajax({
           data : {
               memberId : memberId
           },
           url: "/member/duplicationId/{memberId}",
           success: function (data) {
               if(memberId == "") {
                   $("#duplicationText").css("color", "Green");
                   $("#duplicationText").text("아이디를 입력하세요")
               } else if(data == '0') {
                   $("#duplicationText").css("color", "Green");
                   $("#duplicationText").text("사용 가능한 아이디 입니다");
               } else if(data == '1') {
                   $("#duplicationText").css("color", "Red");
                   $("#duplicationText").text("이미 사용중인 아이디 입니다");
               }

           },
           error: function (error) {
                alert("error : " + error);
           }

       });
    });
});
