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
              required: true
            },
            confirm: {
                required: true,
                equalTo: "#memberPwd1"
            },
            memberPwd: {
                required: true,
                minlength: 8,
                maxlength: 15
            },
            memberName: {
                required: true
            },
            department: {
                required: true
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
        allowClear: false
    });

})

$("#btn-submit").submit(function(e) {
     e.preventDefault();
    // var $form = $(this).parents('form');
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
                if (document.getElementById("memberId").value != "",
                    document.getElementById("memberPwd").value != "",
                    document.getElementById("department").value != "") {
                    swal({
                        title: "본사 계정 생성 완료",
                        text: "본사 계정 생성이 완료되었습니다.",
                        type: "success",
                    }, function () {
                        $("#registForm").submit();
                    })
                }
                else {
                    swal("취소되었습니다.", "", "success");
                }
            });
});

// $("#btn-submit")
//     .submit(async () => {
//         const jns_srt = $("#i_dok").val();
//
//         const result = await swal({
//             title: "계정생성을 하시겠습니까?",
//             text: "계정 생성이 완료됩니다.",
//             type: "warning",
//             showCancelButton: true,
//             confirmButtonColor: "#1AB35",
//             confirmButtonText: "등록",
//             cancelButtonText: "취소",
//             closeOnConfirm: true
//         });
//
//         if(!result.isconfirmed)
//             event.preventDefault();
// });

// $(document).on("click", ".submit", function (e) {
//     e.preventDefault();
//     var $invoiceForm = $('#registForm');
//     if (!$invoiceForm[0].checkValidity()) {
//         $invoiceForm[0].reportValidity()
//     } else {
//         swal({
//             title: "Are you sure?",
//             text: "Did you check all the inputs and calculations?",
//             type: "warning",
//             showCancelButton: true,
//             confirmButtonColor: "#DD6B55",
//             confirmButtonText: "Yes, Submit!",
//         }).then(function (result) {
//             $invoiceForm.submit();
//         });
//     }
// });

$(function () {
    $.ajax({
        url: "/member/department",
        success: function (data) {
            const $department = $("#department");
            $department.html("");

            $department.append($("<option>"))

            for (let index in data) {
                $department.append($("<option>").val(data[index].departmentNo).text(data[index].departmentName));
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

// $(function () {
//     $.ajax({
//         url: "/member/duplicateId",
//         success: function (data) {
//             const $idContainer = $("#idContainer");
//
//             $idContainer.append($("<option>"))
//
//             for (let index in data) {
//                 $idContainer.append($("<option>").val(data[index].departmentNo).text(data[index].departmentName));
//             }
//
//         },
//         error:function (xhr) {
//             console.log(xhr);
//         }
//     });
// });

$(function() {
    $("input[name='memberId']").on("change", function (){
       var memberId = $("#memberId").val();
       console.log(memberId);

       $.ajax({
           data : {
               memberId : memberId
           },
           url: "duplication",
           success: function (data) {

               console.log(data)

               if(memberId == "") {
                   $("#duplicationText").text("")
               } else if(data == false) {
                   $("#duplicationText").css("color", "Green");
                   $("#duplicationText").text("사용 가능한 아이디 입니다");
               } else if(data == true) {
                   $("#duplicationText").css("color", "Red");
                   $("#duplicationText").text("이미 사용중인 아이디 입니다");
               }

           },
           error: function (error, xhr) {
               console.log(xhr);
                alert("error : " + error);
           }

       });
    });
});
