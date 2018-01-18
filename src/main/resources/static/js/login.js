function loginView(){
    $.post("addAccount",$('#addAcco').serialize(),function(data){
        $("#accounts").html(data);
    });
    return false;
}