function ajax(aType, aUrl){
    $.ajax({
       type: aType,
       url: aUrl,
       contentType: 'application/json; charset=utf-8'
    }).done(function(obj) {
        make.makeList(obj);
        make.makePage(obj);
    }).fail(function (error) {
        console.log(JSON.stringify(error));
    });
}

var main = {
    init : function () {
        ajax('GET', '/api/posts');
   }
};

var make = {
    makeList : function(obj){
        var source = $("#boardList").html();
        var bindTemplate = Handlebars.compile(source);
        var html = bindTemplate(obj);
        $(".table").html(html);
    },
    makePage : function(obj){
        var pageSource = $("#pagination").html();
        bindTemplate = Handlebars.compile(pageSource);

        //for 함수 생성
        Handlebars.registerHelper('for', function(options) {
            var pageLoop = options.data.root.totalPages;
            var block = '';
            for(var i = 1; i <= pageLoop ; i++)
                block += options.fn(i);
            return block;
        });

        //page html 데이터 바인딩
        var pageHtml = bindTemplate(obj);
        $(".pagination").html(pageHtml);

        //페이지 클릭 시 해당 페이지 스타일 활성화
        $('.index').each(function(e){
            if(obj.number === e){
                $(this).addClass('active');
            }
        });
    }
}

//페이지 클릭 시 목록 불러오기
$(document).on("click", '.index', function(){
    var index = parseInt($(this).index());
    ajax('GET', '/api/posts?page='+index+'&size=5');
 });

//검색 버튼 클릭
$('#searchBtn').on("click", function(){
 var keyword = $('#keyword').val();
 ajax('GET', '/api/posts/' + keyword);
});

main.init();