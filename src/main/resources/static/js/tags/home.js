function searchConfig(){
    var key = $("#ipt").val();
    if(key == ""){
        $("#errorMsg").text('企业名称不能为空');
    }else{
        $("#errorMsg").text('');
        var start = "1001 String contains ";
        var end = " AND";
        key = start + key + end;
        var sort = "1007 desc";
        var limit = 1000;
        window.parent.document.querySelector("#searchResults").href = "/search?themeId=" + 1 + "&columns=" + "&conditions=" + key + "&sort=" + sort + "&limit=" + limit;
        window.parent.document.querySelector("#searchResults").click();
    }
}

function search(){
    window.parent.document.querySelector("#gradeSearch").href = "/searchConfig";
    window.parent.document.querySelector("#gradeSearch").click();
    // window.location.href="/searchConfig";
}