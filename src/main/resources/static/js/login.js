function loginView(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    return false;
}

function checkId(uAcct) {
    if(uAcct != ""){
        if(uAcct.match("^[a-zA-Z]\\w{3,17}$")){
            $.post("checkId",$('#login-id').serialize(),function(data){
                if (data === "false"){
                    $('#login-id-msg').text("该用户未注册").show();
                    $('#login-id').css("margin","0");
                    return false;
                } else {
                    $('#login-id-msg').text("").hide();
                    $('#login-id').css("margin","0 0 32px");
                    return true;
                }
            });
        } else {
            $('#login-id-msg').text("用户名不符合规范").show();
            $('#login-id').css("margin","0");
            return false;
        }
    }
    return false;
}

$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

$('#login-id').blur(function () {
    var uAcct = $('#login-id').val();
    checkId(uAcct);
});

$('.login-form button').click(function () {
    var uAcct = $('#login-id').val();
    var pwd = $('#login-pwd').val();
    var r = checkId(uAcct);
    if(r){
        if(pwd != ""){
            $('.login-form button').submit();
        }else {
            $('#login-pwd-msg').text("请输入密码").show();
            $('#login-pwd').css("margin","0");
        }
    }
    return false;
});