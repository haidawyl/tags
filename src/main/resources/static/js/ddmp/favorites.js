$(function () {
    window.onload = function () {
        //初始化Table
        var oTable = new TableInit();
        oTable.Init();
    }
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '/getFavorites',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
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
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: $(window).height(),    //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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
                field: 'id',
                title: 'ID',
                visible: false
            }, {
                field: 'title',
                title: '收藏标题',
                align: 'center'
            }, {
                field: 'favCreateDate',
                title: '收藏时间',
                align: 'center'
            }, {
                field: 'themeName',
                title: '查询主题',
                width: 80,
                align: 'center'
            }, {
                field: 'columns',
                title: '查询显示字段',
                visible: false
            }, {
                field: 'conditions',
                title: '查询条件',
                visible: false
            }, {
                field: 'remark',
                title: '搜索条件'
            }, {
                field: 'createDate',
                align: 'center',
                title: '查询创建时间'
            }, {
                field: 'sort',
                title: '查询排序',
                visible: false
            }, {
                field: 'limit',
                title: '返回数据条数',
                visible: false
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                width: 230,
                formatter: operateFormatter
            }
            ]
        });
    };

    function operateFormatter(value, row, index) {
        var buttonStr = '<button onclick="searchConfig(' + row.id + ',\'' + row.themeId + '\',\'' + row.columns + '\',\'' + row.conditions + '\',\'' + row.sort + '\',\'' + row.limit + '\',\'' + encodeURI(row.remark) + '\')" type="button" class="btn btn-default btn-sm fa fa-search">查看</button>';
        buttonStr +=  '&nbsp;&nbsp;<button onclick="deleteFav(' + row.id + ')" type="button" class="btn btn-default btn-sm fa fa-trash-o">取消收藏</button>';
        return [
            buttonStr
        ].join('');
    }

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
        };
        return temp;
    };
    return oTableInit;
};

function searchConfig(id, themeId, columns, conditions, sort, limit, remark) {
    window.parent.document.querySelector("#searchResults").href = "/search?id=" + id + "&themeId=" + themeId + "&columns=" + columns + "&conditions=" + conditions + "&sort=" + sort + "&limit=" + limit + "&remark=" + remark;
    window.parent.document.querySelector("#searchResults").click();
}

function deleteFav(id){
    Ewin.confirm({ message: "确认要取消收藏吗？" }).on(function (e) {
        if (!e) {
            return;
        }
        $.ajax({
            url: "/deleteFavorites",
            type: "post",
            data: {"id": id},
            datatype: "json",
            success: function (data) {
                if(data == 'success'){
                    $('#tb_departments').bootstrapTable('refresh',{});
                }
            }
        });
    });
}

(function ($) {
    window.Ewin = function () {
        var html = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
            '<div class="modal-dialog modal-sm">' +
            '<div class="modal-content">' +
            '<div class="modal-header">' +
            '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' +
            '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
            '</div>' +
            '<div class="modal-body">' +
            '<p>[Message]</p>' +
            '</div>' +
            '<div class="modal-footer">' +
            '<button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>' +
            '<button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';

        var dialogdHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
            '<div class="modal-dialog">' +
            '<div class="modal-content">' +
            '<div class="modal-header">' +
            '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' +
            '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
            '</div>' +
            '<div class="modal-body">' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
        var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
        var generateId = function () {
            var date = new Date();
            return 'mdl' + date.valueOf();
        }
        var init = function (options) {
            options = $.extend({}, {
                title: "操作提示",
                message: "提示内容",
                btnok: "确定",
                btncl: "取消",
                width: 200,
                auto: false
            }, options || {});
            var modalId = generateId();
            var content = html.replace(reg, function (node, key) {
                return {
                    Id: modalId,
                    Title: options.title,
                    Message: options.message,
                    BtnOk: options.btnok,
                    BtnCancel: options.btncl
                }[key];
            });
            $('body').append(content);
            $('#' + modalId).modal({
                width: options.width,
                backdrop: 'static'
            });
            $('#' + modalId).on('hide.bs.modal', function (e) {
                $('body').find('#' + modalId).remove();
            });
            return modalId;
        }

        return {
            alert: function (options) {
                if (typeof options == 'string') {
                    options = {
                        message: options
                    };
                }
                var id = init(options);
                var modal = $('#' + id);
                modal.find('.ok').removeClass('btn-success').addClass('btn-primary');
                modal.find('.cancel').hide();

                return {
                    id: id,
                    on: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.find('.ok').click(function () { callback(true); });
                        }
                    },
                    hide: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.on('hide.bs.modal', function (e) {
                                callback(e);
                            });
                        }
                    }
                };
            },
            confirm: function (options) {
                var id = init(options);
                var modal = $('#' + id);
                modal.find('.ok').removeClass('btn-primary').addClass('btn-success');
                modal.find('.cancel').show();
                return {
                    id: id,
                    on: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.find('.ok').click(function () { callback(true); });
                            modal.find('.cancel').click(function () { callback(false); });
                        }
                    },
                    hide: function (callback) {
                        if (callback && callback instanceof Function) {
                            modal.on('hide.bs.modal', function (e) {
                                callback(e);
                            });
                        }
                    }
                };
            },
            dialog: function (options) {
                options = $.extend({}, {
                    title: 'title',
                    url: '',
                    width: 800,
                    height: 550,
                    onReady: function () { },
                    onShown: function (e) { }
                }, options || {});
                var modalId = generateId();

                var content = dialogdHtml.replace(reg, function (node, key) {
                    return {
                        Id: modalId,
                        Title: options.title
                    }[key];
                });
                $('body').append(content);
                var target = $('#' + modalId);
                target.find('.modal-body').load(options.url);
                if (options.onReady())
                    options.onReady.call(target);
                target.modal();
                target.on('shown.bs.modal', function (e) {
                    if (options.onReady(e))
                        options.onReady.call(target, e);
                });
                target.on('hide.bs.modal', function (e) {
                    $('body').find(target).remove();
                });
            }
        }
    }();
})(jQuery);
