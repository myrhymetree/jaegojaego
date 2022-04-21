 $(document).ready(function(){

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
            confirm: {
                equalTo: "#password",
                minlength: 8,
                maxlength: 15
            },
            password: {
                minlength: 8,
                maxlength: 15
            },
            email: {
                email: true
            }
        }
    });
})