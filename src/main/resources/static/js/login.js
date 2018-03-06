function loginView() {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    return false;
}

function uAcctStrong(uAcct) {
    if (uAcct != "") {
        if (uAcct.match("^[a-zA-Z]\\w{3,17}$")) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

function pwdRepeat(pwd, pwd2) {
    if (pwd2 != pwd) {
        return false;
    } else {
        return true;
    }
}

function pwdStrong(pwd) {
    if (pwd != "") {
        if (!pwd.match("^.{6,16}$")) {
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}

$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

//登录表单验证
$('#login-id').blur(function () {
    var uAcct = $('#login-id').val();
    if (uAcctStrong(uAcct)) {
        $.post("checkId", $('#login-id').serialize(), function (data) {
            if (data === "false") {
                $('#login-id-msg').text("该用户未注册").show();
                $('#login-id').css("margin", "0");
            } else {
                $('#login-id-msg').text("").hide();
                $('#login-id').css("margin", "0 0 32px");
            }
        });
    } else {
        $('#login-id-msg').text("用户名不符合规范").show();
        $('#login-id').css("margin", "0");
    }
    return false;
});

$('.login-form button').click(function () {
    var uAcct = $('#login-id').val();
    var pwd = $('#login-pwd').val();
    if (uAcct != "") {
        if (uAcctStrong(uAcct)) {
            $.post("checkId", $('#login-id').serialize(), function (data) {
                if (data === "false") {
                    $('#login-id-msg').text("该用户未注册").show();
                    $('#login-id').css("margin", "0");
                } else {
                    $('#login-id-msg').text("").hide();
                    $('#login-id').css("margin", "0 0 32px");
                    if (pwd != "") {
                        $('.login-form').submit();
                    } else {
                        $('#login-pwd-msg').text("请输入密码").show();
                        $('#login-pwd').css("margin", "0");
                    }
                }
            });
        } else {
            $('#login-id-msg').text("用户名不符合规范").show();
            $('#login-id').css("margin", "0");
        }
    } else {
        $('#login-id-msg').text("请输入用户名").show();
        $('#login-id').css("margin", "0");
    }
    return false;
});

//注册表单验证
$('#sign-id').blur(function () {
    var uAcct = $('#sign-id').val();
    if (uAcctStrong(uAcct)) {
        $.post("checkId", $('#sign-id').serialize(), function (data) {
            if (data === "true") {
                $('#sign-id-msg').text("该用户名已注册").show();
                $('#sign-id').css("margin", "0");
            } else {
                $('#sign-id-msg').text("").hide();
                $('#sign-id').css("margin", "0 0 32px");
            }
        });
    } else {
        $('#sign-id-msg').text("用户名不符合规范").show();
        $('#sign-id').css("margin", "0");
    }
    return false;
});

$('#sign-pwd').blur(function () {
    var pwd = $('#sign-pwd').val();
    if (pwdStrong(pwd)) {
        $('#sign-pwd-msg').text("").hide();
        $('#sign-pwd').css("margin", "0 0 32px");
    } else {
        $('#sign-pwd-msg').text("密码长度必须为6-16").show();
        $('#sign-pwd').css("margin", "0");
    }
    return false;
});

$('#sign-pwd2').blur(function () {
    var pwd = $('#sign-pwd').val();
    var pwd2 = $('#sign-pwd2').val();
    if (pwdRepeat(pwd, pwd2)) {
        $('#sign-pwd2-msg').text("").hide();
        $('#sign-pwd2').css("margin", "0 0 32px");
    } else {
        $('#sign-pwd2-msg').text("两次密码输入不匹配").show();
        $('#sign-pwd2').css("margin", "0");
    }
    return false;
});

$('.register-form button').click(function () {
    var uAcct = $('#sign-id').val();
    var pwd = $('#sign-pwd').val();
    var pwd2 = $('#sign-pwd2').val();
    if (uAcct != "") {
        if (uAcctStrong(uAcct)) {
            $.post("checkId", $('#sign-id').serialize(), function (data) {
                if (data === "true") {
                    $('#sign-id-msg').text("该用户名已注册").show();
                    $('#sign-id').css("margin", "0");
                } else {
                    $('#sign-id-msg').text("").hide();
                    $('#sign-id').css("margin", "0 0 32px");
                    if (pwdRepeat(pwd, pwd2)) {
                        if (pwdStrong(pwd) && pwdStrong(pwd2)) {
                            $('.register-form').submit();
                        } else {
                            $('#sign-pwd-msg').text("密码长度必须为6-16").show();
                            $('#sign-pwd').css("margin", "0");
                        }
                    } else {
                        $('#sign-pwd2-msg').text("两次密码输入不匹配").show();
                        $('#sign-pwd2').css("margin", "0");
                    }
                }
            });
        } else {
            $('#sign-id-msg').text("用户名不符合规范").show();
            $('#sign-id').css("margin", "0");
        }
    } else {
        $('#sign-id-msg').text("请输入用户名").show();
        $('#sign-id').css("margin", "0");
    }
    return false;
});