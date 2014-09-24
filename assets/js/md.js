var mdjs = {};

mdjs.init = function (mdjsOptions) {

    mdjsOptions = mdjsOptions || {};

    var mdjsDebug = mdjsOptions.debug;
    var baseUrl;
    if(mdjsOptions.baseUrl) {
        baseUrl = mdjsOptions.baseUrl;
    } else {
        baseUrl = "assets/md/";
    }

    $(".mdjs").each(function () {
        var target = $(this);
        $.get(baseUrl + $(this).data("md-file"), function (data) {
            if(mdjsDebug) {
                console.log('got file for target');
            }
            var converter = new Markdown.Converter();
            target.html(converter.makeHtml(data));
        });
    });
};