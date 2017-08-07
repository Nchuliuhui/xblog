/**
 * Created by xp on 2017/8/6.
 */
$(document).ready(function(){

    'use strict';
    // 初始化
    var $image =  $('#image');
    $image.cropper({
        aspectRatio: 16 / 9,
        preview: '.img-preview',
        zoomOnWheel: false,
    });

    // 事件代理绑定事件
    $('.img-btn-grp').on('click', '[data-method]', function() {
        var $this = $(this);
        var data = $this.data();
        var result = $image.cropper(data.method, data.option, data.secondOption);

        switch (data.method) {
            case 'getCroppedCanvas':
                if (result) {
                    $image.cropper("getCroppedCanvas").toBlob(function(blob) {
                        var formData = new FormData();
                        formData.append('file', blob,'file');
                        $.ajax({
                            url: 'file/upload',
                            type: 'POST',
                            data: formData,
                            async: false,
                            cache: false,
                            contentType: false,
                            processData: false,
                            beforeSend: function(){
                               $("#my-modal-loading").modal('open');
                               $("#upload-image").css('z-index','1000');
                            },
                            success: function (returndata) {
                                $("#my-modal-loading").modal('close');
                                $("#upload-image").css('z-index','1300');
                                alert("修改成功！");
                                $("#myImg").attr("src",returndata.data);
                            },
                            error: function (returndata) {
                                alert("修改失败！");
                            }
                        });
                    });
                }
                break;
        }
    });
    // 上传图片
    var $inputImage = $('#inputImage');
    var URL = window.URL || window.webkitURL;
    var blobURL;

    if (URL) {
        $inputImage.change(function () {
            var files = this.files;
            var file;

            if (files && files.length) {
                file = files[0];

                if (/^image\/\w+$/.test(file.type)) {
                    blobURL = URL.createObjectURL(file);
                    $image.one('built.cropper', function () {

                        // Revoke when load complete
                        URL.revokeObjectURL(blobURL);
                    }).cropper('reset').cropper('replace', blobURL);
                    $inputImage.val('');
                } else {
                    window.alert('Please choose an image file.');
                }
            }
            // Amazi UI 上传文件显示代码
            var fileNames = '';
            $.each(this.files, function() {
                fileNames += '<span class="am-badge">' + this.name + '</span> ';
            });
            $('#file-list').html(fileNames);
        });
    } else {
        $inputImage.prop('disabled', true).parent().addClass('disabled');
    }
});
function selectFile() {
    //触发file click事件
    $("#inputImage").trigger("click");
}
function reset() {
    var $image =  $('#image');
    $image.cropper('reset')
}