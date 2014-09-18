var EasyDocumentation = {}

EasyDocumentation.initializeMarkdown = function () {
    $(".documentation").each(function () {
        var target = $(this);
        console.log($(this));
        $.get("assets/md/" + $(this).data("md-file"), function (data) {
            console.log(data);
            var converter = new Markdown.Converter();
            console.log($(this));
            target.html(converter.makeHtml(data));
        });
    });
};