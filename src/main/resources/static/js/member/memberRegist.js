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
            confirm: {
                equalTo: "#password",
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