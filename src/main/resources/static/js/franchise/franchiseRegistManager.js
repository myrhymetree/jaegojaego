$(document).ready(function(){

    $("#memberId").val().empty();
    $("#memberPwd").val().empty();

    <!-- password meter -->
    let options1 = {};
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
    $("#registManagerForm").ready().validate({

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
                maxlength: 15
            },
            memberName: {
                empty: true,
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
        placeholder: "가맹점을 선택하세요.",
        allowClear: true
    });

})

$(function() {
    $("input[name='memberId']").on("change", function (){
        let memberId = $("#memberId").val();
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


$(function () {
   $.ajax({
       url: "/franchise/branch",
       success: function (data) {
           
           console.log(data);

           const $branch = $("#branch");

           $branch.html("");

           $branch.append($("<option>"))

           for(let index in data) {
               console.log(data[index].memberNo)
               console.log(data[index].branchName)
               $branch.append($("<option>").val(data[index].memberNo).text(data[index].branchName));
           }
       },
       error:function (xhr) {
           console.log(xhr);
       }
   });
});