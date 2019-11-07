$(function () {
    var totalRecord,currentPage;

    //显示
    to_page(1);











    function to_page(pageNo) {
        $.ajax({
            url:"/user.do",
            data:"pageNo="+pageNo,
            type:"GET",
            success:function (list) {
                build_user_table(list);
                build_page_info(list);
                build_page_nav(list);
            }

        })
    }

    function  build_user_table(list) {
        $("#user_table tbody").empty();
        var userList = list.extend.pageInfo.list;

        $.each(userList,function (index, item) {
            var checkBox=$("<td><input type='checkbox' class='check_item'/></td>");
            var id=$("<td></td>").append(item.id);
            var username=$("<td></td>").append(item.username);
            var birthday=$("<td></td>").append(item.birthday);
            var sex=$("<td></td>").append(item.sex);
            var address=$("<td></td>").append(item.address);

            var button1=$("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", true)).append("编辑");
            var button2=$("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden", true)).append("删除");
            var td_btn=$("<td></td>").append(button1).append("  ").append(button2);
            $("<tr></tr>").append(checkBox).append(id).append(username).append(birthday).append(sex)
                .append(address).append(td_btn).appendTo("#user_table tbody");
         })
    }


    function build_page_info(list) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+list.extend.pageInfo.pageNum+"页，总共"+list.extend.pageInfo.pages
        +"页，总共"+list.extend.pageInfo.total+"条记录");
        totalRecord = list.extend.pageInfo.total;
        currentPage=list.extend.pageInfo.pageNum
    }

    function build_page_nav(list) {
        $("#page_nav_area").empty();
        var ul=$("<ul></ul>").addClass("pagination");
        var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
        var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
        var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if (list.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //首页
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(list.extend.pageInfo.pageNum - 1);
            });
        }
        if (list.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            //构建点击事件

            nextPageLi.click(function () {
                to_page(list.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(list.extend.pageInfo.lastPage);
            })
        }
        //添加首页和前一页
        ul.append(firstPageLi).append(prePageLi);
        //遍历添加页码
        $.each(list.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
            //如果是当前选中页面，添加active标识
            if (list.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            //给每个页码添加点击就跳转
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");


    }
})