$(function () {
    $.ajax({
        url: "/mapping/getDict",
        type: "post",
        data: {"keyword": "province"},
        datatype: "json",
        success: function (data) {
            var str = "";
            var dict = data.dict;
            $.each(dict, function (i) {
                str+='<option value='+dict[i].value+'>'+dict[i].text+'</option>'
            });
            $("#province").html(str);
            $("#province").selectpicker('refresh');

            var args = dict[0].value;
            $.ajax({
                url: "/mapping/getDict",
                type: "post",
                data: {"keyword": "city","args": args},
                datatype: "json",
                success: function (data) {
                    var str = "";
                    var dict = data.dict;
                    $.each(dict, function (i) {
                        str+='<option value='+dict[i].value+'>'+dict[i].text+'</option>'
                    });
                    $("#city").html(str);
                    $("#city").selectpicker('refresh');

                    //初始化Table
                    var oTable = new TableInit();
                    oTable.Init();
                }
            });
        }
    });

    $('#province').change(function(){
        var province = $("#province").val();
        $.ajax({
            url: "/mapping/getDict",
            type: "post",
            data: {"keyword": "city","args": province},
            datatype: "json",
            success: function (data) {
                var str = "";
                var dict = data.dict;
                $.each(dict, function (i) {
                    str+='<option value='+dict[i].value+'>'+dict[i].text+'</option>'
                });
                $("#city").html(str);
                $("#city").selectpicker('refresh');

                //初始化Table
                var oTable = new TableInit();
                oTable.Init();
            }
        });
    })
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '/getCityIndustryL2Count',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: false,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            // showColumns: true,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            locale: 'zh-CN',
            columns: [{
                field: 'No',
                title: '序号',
                width: 5,
                align: 'center',
                switchable: false,
                formatter: function (value, row, index) {
                    var pageSize = $('#tb_departments').bootstrapTable('getOptions').pageSize; // 每页多少条
                    var pageNumber = $('#tb_departments').bootstrapTable('getOptions').pageNumber; // 当前第几页
                    return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号: 每页条数 * (当前页 - 1) + 序号
                }
            }, {
                field: 'province',
                title: '省',
                align: 'center'
            }, {
                field: 'provinceCode',
                title: '省Code',
                visible: false
            }, {
                field: 'city',
                title: '市',
                align: 'center'
            }, {
                field: 'cityCode',
                title: '市Code',
                visible: false
            }, {
                field: 'pname',
                title: '一级行业',
                align: 'center'
            }, {
                field: 'name',
                title: '二级行业',
                align: 'center'
            }, {
                field: 'code',
                title: '行业Code',
                visible: false
            }, {
                field: 'count',
                title: '企业数量',
                align: 'center',
                formatter: countFormatter
            }
            ]
        });
    };

    function countFormatter(value, row, index) {
        return [
            '<a href="#" onclick="searchConfig(' + row.count + ',\'' + row.province + '\',\'' + row.city + '\',\'' + row.cityCode + '\',\'' + row.provinceCode + '\',\'' + row.code + '\',\'' + row.name + '\')"  >' + row.count + '</a>'
        ].join('');
    }

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            city: $("#city").find("option:selected").text(),   //市
            province: $('#province').find("option:selected").text(), //省
            provinceCode: $('#province').selectpicker('val'),
            cityCode: $('#city').selectpicker('val')
        };
        return temp;
    };
    return oTableInit;
};

function search() {
    var province = $('#province').find("option:selected").text();
    var city = $("#city").find("option:selected").text();
    var provinceCode = $('#province').selectpicker('val');
    var cityCode = $('#city').selectpicker('val');
    //带参数刷新
    var opt = {
        url: "/getCityIndustryL2Count",
        // silent: true, //静默刷新
        query: {
            //请求参数
            city: city,
            province: province,
            provinceCode: provinceCode,
            cityCode: cityCode
        }
    };
    $("#tb_departments").bootstrapTable('refresh', opt);
}

function searchConfig(count, province, city, cityCode, provinceCode, code, name) {
    var c1 = "1002 Dict-Province = " + provinceCode + " AND;";
    var c2 = "1003 Dict-City = " + cityCode + " AND;";
    // var c3 = "1005 Dict-IndustryL1 = "+code+" AND;";
    var c3 = "1006 Dict-IndustryL2 = " + code + " AND";
    var conditions = c1 + c2 + c3;
    var sort = "1009 desc";
    var remark = "搜索条件: ";
    var total;
    if(count > 200){
        total = 200;
    }else{
        total = count;
    }
    remark = remark + "省份 等于 " + province + " AND 城市 等于 " + city + " AND 二级行业 等于 " + name + " <br /> 排序: 注册资金 倒序 <br /> 数据量: " + total + " 总数:" + count;
    remark = encodeURI(remark);
    window.parent.document.querySelector("#searchResults").href = "/search?id=0&themeId=1" + "&columns=" + $("#columns").val() + "&conditions=" + conditions + "&sort=" + sort + "&limit=" + 200 + "&remark=" + remark;
    window.parent.document.querySelector("#searchResults").click();
}