 $(document).ready(function(){

     $("#managerModifyModal").children("input[class='form-control']").empty();

     <!-- password meter -->
    var options1 = {};
    options1.ui = {
        container: "#pwd-container1",
        showVerdictsInsideProgressBar: true,
        viewports: {
            progress: ".pwstrength_viewport_progress"
        }
    };
    options1.common = {
    debug: false,
    };

    $('.example1').pwstrength(options1);

    <!-- input mask, validation(password equality, length, email validation) -->
    $("#modifyForm").ready().validate({
        errorPlacement: function (error, element) {
            element.before(error);
        },
        rules: {
            memberPwd: {
                minlength: 8,
                maxlength: 15
            },
            confirm: {
                equalTo: "#memberPwd",
                minlength: 8,
                maxlength: 15
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
                     $("#modifyForm").submit();
                 })
             }
             else {
                 swal("취소되었습니다.", "", "success");
             }
         });
 });