function loginView(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    return false;
}

$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

$('#login-id').blur(function () {
    var uAcct = $('#login-id').val();
    if(uAcct != ""){
        if(uAcct.match("^[a-zA-Z]\\w{3,17}$")){
            $.post("checkId",$('#login-id').serialize(),function(data){
                if (data === "false"){
                    $('.form-control-static:first').text("该用户未注册");
                } else {
                    $('.form-control-static:first').text("");
                }
            });
        } else {
            $('.form-control-static:first').text("该用户未注册");
        }
    }
});
