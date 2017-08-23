/**
 * Created by xp on 2017/8/18.
 */
$(document).ready(function () {
    $("#passwordSuccess").css('display','none');
    $("#passwordFail").css('display','none');
    $(".alert-close").on('click',function () {
        $(this).parent().css('display','none');
    })
});






/**
 * 修改博主密码
 */
function modifyPassword(){

    var oldPassword = $("#oldPassword").val();
    var newPassword = $("#newPassword").val();
    alert(oldPassword);
    return;
    var newPasswordAgain = $("#newPasswordAgain").val();
    if(oldPassword != "" || newPassword != "" || newPasswordAgain != ""){
        $("#fText").text("输入不能为空！");
        $("#passwordFail").css('display','block');
        return ;
    }
    if( newPassword != newPasswordAgain){
        $("#fText").text("两次输入的密码不一致，请重新输入！");
        $("#passwordFail").css('display','block');
        return ;
    } else{
        $.ajax({
            url: '/admin/password',
            type: 'POST',
            dataType: 'json',
            data: {
                'oldPassword': oldPassword,
                'newPassword': newPassword
            },
            success: function(data){
                $("#sText").text(data.data);
                $("#passwordSuccess").css('display','block');
            },
            error: function(data){
                $("#fText").text('修改密码失败'+data.data);
                $("#passwordFail").css('display','block');
            }
        })
    }

}

