$(function () {
    init();
});

var themeId = null;
var themeChanged = false;

function changeTags() {
    if (themeId != $("#tagTheme").val()) {
        themeChanged = true;
        themeId = $("#tagTheme").val();
    }
    var typeId = $("#tagType").val();

    var searchArgs = {"themeId": themeId, "typeId": typeId};

    // 销毁表格
    $("#tagsTable").bootstrapTable('destroy');

    $("#tagsTable").bootstrapTable({
        locale: 'zh-CN', //中文支持
        url: '/mapping/getTagMappings',
        method: 'post',
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        queryParamsType: '', // 在这种情况下传给服务器的参数为: pageSize,pageNumber
        queryParams: function queryParams(params) {
            param = {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize
            };
            for (var key in searchArgs) {
                param[key] = searchArgs[key];
            }
            return param;
        },
        uniqueId: 'id',
        pagination: false, // 是否开启分页
        pageNumber: 1, // 初始化加载第一页，默认第一页
        pageSize: 100, // 每页的记录行数
        pageList: [100], // 可供选择的每页的行数
        sidePagination: "server", // 分页方式：client客户端分页，server服务端分页
        // height: $(window).height() - 50,
        columns: [
            {
                field: 'checked',
                checkbox: true
            },
            {
                title: '标签ID',
                field: 'id',
                align: 'center',
                valign: 'middle',
                width: 80,
                visible: false
            },
            {
                title: '标签名称',
                field: 'name',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '值类型',
                field: 'valueType',
                align: 'center',
                valign: 'middle',
                visible: false
            },
            {
                title: '标签主题',
                field: 'themeId',
                align: 'center',
                valign: 'middle',
                width: 100,
                formatter: function (value, row, index, field) {
                    return $("#tagTheme").find("option:selected").text();
                },
                visible: false
            },
            {
                title: '标签类型',
                field: 'typeId',
                align: 'center',
                valign: 'middle',
                width: 100,
                formatter: function (value, row, index, field) {
                    return $("#tagType").find("option:selected").text();
                },
                visible: false
            },
            {
                title: '定位ID',
                field: 'locationId',
                visible: false
            }
        ],
        onClickRow: function (row, $element, field) {
            var index = $element.data('index');
            if (row.checked == undefined || row.checked == false) {
                $("#tagsTable").bootstrapTable('check', index);
            } else {
                $("#tagsTable").bootstrapTable('uncheck', index);
            }
        },
        onCheck: function (row, $element) {
            tagName = row.name + "<input type='hidden' value='" + row.locationId + "' /><input type='hidden' value='" + row.valueType + "' />";

            condition = "<form class='form-inline' role='form' style='padding-left: 20px;'><div class='form-group'>";
            if (row.valueType == "String") {
                condition += "<select class='selectpicker form-control' style='width: 100px;'><option value='='>等于</option><option value='contains'>包含</option></select>";
                condition += "<input type='text' class='form-control' placeholder='" + row.name + "' />";
            } else if (row.valueType == "Integer" || row.valueType == "Double") {
                condition += "<select class='selectpicker form-control' style='width: 100px;'><option value='='>=</option><option value='>'>&gt;</option><option value='>='>&gt;=</option><option value='<'>&lt;</option><option value='<='>&lt;=</option><option value='!='>!=</option><option value='between'>Between</option></select>";
                condition += "<input type='text' class='form-control' placeholder='" + row.name + "' />";
            } else if (row.valueType == "Date") {
                condition += "<input type='text' name='startDate' placeholder='起始日期' class='datepicker form-control' data-provide='datepicker' />";
                condition += "<input type='text' name='endDate' placeholder='截止日期' class='datepicker form-control' data-provide='datepicker' />";
                condition += "<script>$('.datepicker').datepicker({language: 'zh-CN', format: 'yyyy-mm-dd', todayHighlight: true, autoclose: true});<\/script>";
            } else {
                var regexp = new RegExp("^Dict");
                if (regexp.test(row.valueType)) {
                    condition += "<select class='selectpicker form-control' style='width: 100px;'><option value='='>等于</option></select>";

                    var keyword = row.valueType.split("-")[1].toLowerCase();

                    var args = new Array();
                    if (keyword == "province") {
                    } else if (keyword == "city") {
                        var province = getConditionElement("Province");
                        if (province == null) {
                            alert("请先选择【省份】");
                            $('#tagsTable').bootstrapTable('uncheck', $element.data('index'));
                            return;
                        }
                        args.push(province.value);
                    } else if (keyword == "district") {
                        var city = getConditionElement("City");
                        if (city == null) {
                            alert("请先选择【城市】");
                            $('#tagsTable').bootstrapTable('uncheck', $element.data('index'));
                            return;
                        }
                        args.push(city.value);
                    } else if (keyword == "industryl1") {
                    } else if (keyword == "industryl2") {
                        var industry = getConditionElement("IndustryL1");
                        if (industry == null) {
                            alert("请先选择【一级行业】");
                            $('#tagsTable').bootstrapTable('uncheck', $element.data('index'));
                            return;
                        }
                        args.push(industry.value);
                    } else if (keyword == "industryl3") {
                        var industry = getConditionElement("IndustryL2");
                        if (industry == null) {
                            alert("请先选择【二级行业】");
                            $('#tagsTable').bootstrapTable('uncheck', $element.data('index'));
                            return;
                        }
                        args.push(industry.value);
                    } else if (keyword == "industryl4") {
                        var industry = getConditionElement("IndustryL3");
                        if (industry == null) {
                            alert("请先选择【三级行业】");
                            $('#tagsTable').bootstrapTable('uncheck', $element.data('index'));
                            return;
                        }
                        args.push(industry.value);
                    } else {
                        args.push(keyword);
                    }

                    condition += "<select class='selectpicker form-control' style='width: 100px;' name='" + keyword + "' onchange='changeMyself(this)'>";
                    $.ajax({
                        async: false,
                        url: "/mapping/getDict",
                        type: "post",
                        data: {"keyword": keyword, "args": args.join(",")},
                        datatype: "json",
                        success: function (result) {
                            for (var i = 0; i < result.dict.length; i++) {
                                var item = result.dict[i];
                                condition += "<option value='" + item.value + "'>" + item.text + "</option>";
                            }
                        },
                        error: function () {
                        }
                    });
                    condition += "</select>";
                }
            }
            condition += "</div></form>";

            var relation = "<select class='selectpicker form-control' style='width: 100px;'><option value='AND'>AND</option><option value='OR'>OR</option></select>";
            $('#conditionsTable').bootstrapTable('append', {
                "id": row.id,
                "tagName": tagName,
                "condition": condition,
                "relation": relation,
                "locationId": row.locationId
            });
        },
        onUncheck: function (row, $element) {
            $('#conditionsTable').bootstrapTable('removeByUniqueId', row.id);
        },
        onLoadSuccess: function (data) {
            $("#sortField").empty();
            for (var i = 0; i < data.rows.length; i++) {
                var row = data.rows[i];
                if (row.valueType == "Integer" || row.valueType == "Double" || row.valueType == "Date") {
                    $("#sortField").append("<option value='" + row.locationId + "'>" + row.name + "</option>");
                }
            }
        },
        onCheckAll: function (rows) {
            return false;
        },
        onUncheckAll: function (rows) {
            return false;
        }
    });

    if (themeChanged) {
        $("#conditionsTable").bootstrapTable('removeAll');

        $("#columnsTable").bootstrapTable({
            locale: 'zh-CN', //中文支持
            url: '/mapping/getDisplayColumns',
            method: 'post',
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            queryParamsType: '', // 在这种情况下传给服务器的参数为: pageSize,pageNumber
            queryParams: function queryParams(params) {
                param = {
                    pageNumber: params.pageNumber,
                    pageSize: params.pageSize
                };
                for (var key in searchArgs) {
                    param[key] = searchArgs[key];
                }
                return param;
            },
            uniqueId: 'column',
            pagination: false, // 是否开启分页
            pageNumber: 1, // 初始化加载第一页，默认第一页
            pageSize: 100, // 每页的记录行数
            pageList: [100], // 可供选择的每页的行数
            sidePagination: "server", // 分页方式：client客户端分页，server服务端分页
            // height: 400,
            columns: [
                {
                    field: 'checked',
                    checkbox: true
                },
                {
                    title: 'ID',
                    field: 'column',
                    align: 'center',
                    valign: 'middle',
                    width: 80,
                    visible: false
                },
                {
                    title: '列名',
                    field: 'title',
                    align: 'center',
                    valign: 'middle'
                }
            ],
            onClickRow: function (row, $element, field) {
                var index = $element.data('index');
                if (row.checked == undefined || row.checked == false) {
                    $("#columnsTable").bootstrapTable('check', index);
                } else {
                    $("#columnsTable").bootstrapTable('uncheck', index);
                }
            },
            onLoadSuccess: function (data) {
                for (var i = 0; i < data.rows.length; i++) {
                    var row = data.rows[i];
                    if (row.defaultDisplay == 1) {
                        $("#columnsTable").bootstrapTable('check', i);
                    }
                }
                $("#columnsTable").bootstrapTable('check', 0);
                $("#columnsTable").bootstrapTable('hideRow', {index: 0});
            },
            onUncheckAll: function (rows) {
                $("#columnsTable").bootstrapTable('check', 0);
            }
        });

        themeChanged = false;
    }
}

function init() {
    changeTags();

    $('#conditionsTable').bootstrapTable({
        locale: 'zh-CN',// 中文支持
        uniqueId: 'id',
        columns: [{
            title: '标签ID',
            field: 'id',
            align: 'center',
            valign: 'middle',
            width: 80
        }, {
            field: 'tagName',
            title: '标签名称',
            align: 'center',
            valign: 'middle',
            width: 150
        }, {
            field: 'condition',
            title: '查询条件',
            align: 'center',
            valign: 'middle'
        }, {
            field: 'relation',
            title: '逻辑关系',
            align: 'center',
            valign: 'middle',
            width: 150
        }, {
            field: 'locationId',
            title: '定位ID',
            visible: false
        }]
    });
}

function getConditionElement(condition) {
    var trs = $('#conditionsTable tbody tr');
    for (var i = 0; i < trs.length; i++) {
        var tds = $(trs[i]).children();
        var valueType = $($(tds[1]).children()[1]).val();
        var regexp = new RegExp(condition + "$");
        if (regexp.test(valueType)) {
            var items = $($($(tds[2]).children()[0]).children()[0]).children();
            for (var j = 0; j < items.length; j++) {
                if (items[j].name == condition.toLowerCase()) {
                    return items[j];
                }
            }
        }
    }
    return null;
}

function submit0() {
    var trs = $('#conditionsTable tbody tr');
    if (trs.length == 1 && $(trs[0]).children().length == 1) {
        return;
    }
    var conditions = new Array();
    var remarks = new Array();
    remarks.push("搜索条件:");
    for (var i = 0; i < trs.length; i++) {
        var tds = $(trs[i]).children();

        var condition = new Array();
        var remark = new Array();

        var tagName = $(tds[1]).text();
        var locationId = $($(tds[1]).children()[0]).val();
        condition.push(locationId);
        remark.push(tagName);

        var valueType = $($(tds[1]).children()[1]).val();
        condition.push(valueType);

        var items = $($($(tds[2]).children()[0]).children()[0]).children();
        var isDate = false;
        for (var j = 0; j < items.length; j++) {
            if (items[j].tagName.toLowerCase() == "script") {
                continue;
            }
            if ($(items[j]).hasClass("datepicker")) {
                isDate = true;
                if (condition.indexOf("Between") < 0) {
                    condition.push("Between")
                    remark.push("Between")
                }
                if (items[j].value != "") {
                    if (items[j].name == "endDate") {
                        condition.push(", " + items[j].value);
                        remark.push(", " + items[j].value);
                    } else {
                        condition.push(items[j].value);
                        remark.push(items[j].value);
                    }
                }
            } else {
                if (items[j].value == "") {
                    alert("查询条件【" + tagName + "】的值不能为空");
                    return;
                }
                condition.push(items[j].value);
                if (items[j].tagName.toLowerCase() == "select") {
                    remark.push($(items[j]).find("option:selected").text());
                } else {
                    remark.push(items[j].value);
                }
            }
        }

        var relation = $($(tds[3]).children()[0]).val();
        condition.push(relation);
        if (i < trs.length - 1) {
            remark.push(relation);
        }

        if (isDate && condition.length < 5) {
            alert("查询条件【" + tagName + "】的值不能为空");
            return;
        }

        if (valueType.toLowerCase() == "integer") {
            if (condition[2].toLowerCase() == "between") {
                var regexp = new RegExp("^[0-9]+[,]{1}[0-9]+$");
                if (!regexp.test(condition[3])) {
                    alert("查询条件【" + tagName + "】的值只允许是数字区间并且以【,】分隔");
                    return;
                }
            } else {
                var regexp = new RegExp("^[0-9]+$");
                if (!regexp.test(condition[3])) {
                    alert("查询条件【" + tagName + "】的值只允许是数字");
                    return;
                }
            }
        }

        if (isDate) {
            if (remark.length == 3) {
                if (remark[2].substring(0, 1) == ",") {
                    remark[1] = "<=";
                    remark[2] = remark[2].substring(2);
                } else {
                    remark[1] = ">=";
                }
            } else if (remark.length == 4) {
                remark[3] = remark[3].replace(",", " AND ");
            }
        } else {
            if (remark[1] == "Between") {
                remark[2] = remark[2].replace(",", " AND ");
            }
        }

        conditions.push(condition.join(" "));
        remarks.push(remark.join(" "));
    }

    remarks.push(encodeURI("<br />"));
    remarks.push("排序:");
    remarks.push($("#sortField").find("option:selected").text());
    remarks.push($("#order").find("option:selected").text());
    remarks.push(encodeURI("<br />"));
    remarks.push("数据量:");
    remarks.push($("#limit").val());

    // console.log(conditions.join(";"));

    $("#conditions").val(conditions.join(";"));

    var columns = new Array();
    var rows = $("#columnsTable").bootstrapTable('getSelections');
    for (var i = 0; i < rows.length; i++) {
        columns.push(rows[i].column);
    }
    // console.log(columns.join(","))


    // $("#searchForm").submit();
    // console.log(remarks.join(" "));
    window.parent.document.querySelector("#searchResults").href = "/search?themeId=" + $("#tagTheme").val() + "&columns=" + columns.join(",") + "&conditions=" + conditions.join(";") + "&sort=" + $("#sortField").val() + "%20" + $("#order").val() + "&limit=" + $("#limit").val() + "&remark=" + remarks.join(" ");
    window.parent.document.querySelector("#searchResults").click();
}

function changeMyself(obj) {
    var args = new Array();
    args.push(obj.value);
    var keyword = null;
    if (obj.name == "province") {
        keyword = "city";
    } else if (obj.name == "city") {
        keyword = "district";
    } else if (obj.name == "industryl1") {
        keyword = "industryl2";
    } else if (obj.name == "industryl2") {
        keyword = "industryl3";
    } else if (obj.name == "industryl3") {
        keyword = "industryl4";
    }
    $.ajax({
        async: false,
        url: "/mapping/getDict",
        type: "post",
        data: {"keyword": keyword, "args": args.join(",")},
        datatype: "json",
        success: function (result) {
            var element = null;
            if (keyword == "city") {
                element = getConditionElement("City");
            } else if (keyword == "district") {
                element = getConditionElement("District");
            } else if (keyword == "industryl2") {
                element = getConditionElement("IndustryL2");
            } else if (keyword == "industryl3") {
                element = getConditionElement("IndustryL3");
            } else if (keyword == "industryl4") {
                element = getConditionElement("IndustryL4");
            }
            if (element != null) {
                $(element).empty();
                for (var i = 0; i < result.dict.length; i++) {
                    var item = result.dict[i];
                    $(element).append("<option value='" + item.value + "'>" + item.text + "</option>");
                }
            }
            changeMyself(element);
        },
        error: function () {
        }
    });
}
