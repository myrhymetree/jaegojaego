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
                equalTo: "#memberPwd",
            },
            memberPwd: {
                required: true,
                minlength: 8,
                maxlength: 15,
                empty: true
            },
            memberName: {
                empty: true,
                required: true
            },
            businessRegistrationNo: {
                required: true
            },
            address: {
                required: true
            },
            bankAccountNo: {
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
        placeholder: "계약상태를 선택하세요.",
        allowClear: true
    });

    // $("#registForm").submit(function (e) {
    //     e.preventDefault();
    //     var form = $(this)
    //     swal({
    //             title: "계정생성을 하시겠습니까?",
    //             text: "계정 생성이 완료됩니다.",
    //             type: "warning",
    //             showCancelButton: true,
    //             confirmButtonColor: "#1AB35",
    //             confirmButtonText: "등록",
    //             cancelButtonText: "취소",
    //             closeOnConfirm: false,
    //             closeOnCancel: false },
    //         function (isConfirm) {
    //             if (isConfirm) {
    //                 swal("계정 생성 성공", "계정을 성공적으로 생성했습니다.", "success");
    //                 form.submit();
    //             } else {
    //                 swal("취소되었습니다.", "", "success");
    //             }
    //         });
    // });

    var mem = $('#data_1 .input-group.date').datepicker({
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true
    });

    var yearsAgo = new Date();
    yearsAgo.setFullYear(yearsAgo.getFullYear() - 20);

    $('#selector').datepicker('setDate', yearsAgo );


    $('#data_2 .input-group.date').datepicker({
        startView: 1,
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        autoclose: true,
        format: "dd/mm/yyyy"
    });

    $('#data_3 .input-group.date').datepicker({
        startView: 2,
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        autoclose: true
    });

    $('#data_4 .input-group.date').datepicker({
        minViewMode: 1,
        keyboardNavigation: false,
        forceParse: false,
        forceParse: false,
        autoclose: true,
        todayHighlight: true
    });

    $('#data_5 .input-daterange').datepicker({
        keyboardNavigation: false,
        forceParse: false,
        autoclose: true,
        
    });
})

// $("#btn-submit").click(function(e) {
//      e.preventDefault();
//     // var $form = $(this).parents('form');
//
//         swal({
//                 title: "계정생성을 하시겠습니까?",
//                 text: "계정 생성이 완료됩니다.",
//                 type: "warning",
//                 showCancelButton: true,
//                 confirmButtonColor: "#1AB35",
//                 confirmButtonText: "등록",
//                 cancelButtonText: "취소",
//                 closeOnConfirm: false,
//                 closeOnCancel: false
//             },
//
//             function (isConfirm) {
//                 if (isConfirm) {
//                     $("#registForm").submit();
//                     swal("계정 생성 성공", "계정을 성공적으로 생성했습니다.", "success");
//                 } else {
//                     swal("취소되었습니다.", "", "success");
//                 }
//             });
// });

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


