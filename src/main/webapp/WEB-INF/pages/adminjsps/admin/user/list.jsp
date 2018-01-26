<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/17
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>

    <link  href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link  href="/css/font-awesome.css" rel="stylesheet">
    <script type="text/javascript" src="/lib/respond.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css"/>
    <script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <style>

        #divv{
            position: absolute;
            left:45%;
            top: 80%;

        }
        /* 正文：分页功能区 */
        #pages a
        {
            color: #000;
            font-size: 15pt;
        }
        #pages a:hover
        {
            background: #cddde4;
            border: #97b9c9 solid 1px;
            color: #067db5;
        }
        #pages a.current_page
        {
            background: #FFF;
            border: #89bdd8 solid 1px;
            color: #067db5;
        }
        a.summary
        {
            cursor: default;
            color: gray;
            font-weight: bold;
            display: block;
            width: 100%;
            line-height: 100%;
        }
        div.detail_info
        {
            position: absolute;
            z-index: 1000;
            min-width: 150px;
            min-height: 40px;
            display: none;
            padding: 3px;
            overflow: visible;
            text-align: left;
        }



    </style>
    <script language="JavaScript" type="text/javascript">
        //显示详细信息
        function showDetail(flag, a) {
            var detailDiv = a.parentNode.getElementsByTagName("div")[0];
            if (flag) {
                detailDiv.style.display = "block";
            }
            else
                detailDiv.style.display = "none";
        }
    </script>
</head>
<body>
<div class="page-container">
    <h1>用户列表</h1>
    <form action="/user/query" method="post">
        <div class="text-c"> 日期范围：
            <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" name="datemin"
                   class="input-text Wdate" style="width:120px;">
            -
            <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" name="datemax"
                   class="input-text Wdate" style="width:120px;">
            <input type="text" class="input-text" style="width:250px" placeholder="输入顾客名称或编号" id="name" name="name">
            <input type="submit"  class="btn btn-success" name="" value="搜用户"/>
        </div>
    </form>

    <div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l"><a href="javascript:;" onclick="databath()"
                                                               class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
    </span>
    </div>

    <table class="table table-bordered" >
        <thead>
        <tr class="text-c">
            <th width="25"><input type="checkbox" name="" value=""></th>
            <th scope="col" colspan="2" style="text-align: center">订货人编号</th>
            <th scope="col" colspan="2" style="text-align: center">订货人昵称</th>
            <th scope="col" colspan="2" style="text-align: center">订货人姓名</th>
            <th scope="col" colspan="2" style="text-align: center">订货人电话</th>
            <th scope="col" colspan="2" style="text-align: center">默认地址</th>
            <th scope="col" colspan="2" style="text-align: center">注册时间</th>
            <th scope="col" colspan="2" style="text-align: center">订货人订单</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pageBean.data}" var="user">
            <tr class="text-c">
                <td><input type="checkbox" value="${user.uid}" name="" id="uid"></td>
                <td scope="col" colspan="2">${user.uid}</td>
                <td scope="col" colspan="2">${user.loginame}</td>
                <td scope="col" colspan="2">${user.realname}</td>
                <td scope="col" colspan="2">${user.tel}</td>
                <td scope="col" colspan="2">
                   <c:choose>
                       <c:when test="${fn:length(user.adresses)>1}">
                           <a class="summary" onmousemove="showDetail(true,this);"
                              onmouseout="showDetail(false,this);">
                               <c:forEach items="${user.adresses}" varStatus="status" var="adress">
                                   <c:if test="${status.count==1}">
                                       ${adress.aname}
                                   </c:if>
                               </c:forEach>...
                           </a>
                           <div class="detail_info">
                               <c:forEach items="${user.adresses}" varStatus="status" var="adress">
                                   ${adress.aname}
                                   <c:if test="${!status.last}">
                                       、
                                   </c:if>
                               </c:forEach>
                           </div>
                       </c:when>
                       <c:otherwise>
                           <c:forEach items="${user.adresses}" var="adress">
                               ${adress.aname}
                           </c:forEach>
                       </c:otherwise>
                   </c:choose>
                </td>
                <td scope="col" colspan="2">${user.create_time}</td>
                <td scope="col" colspan="2"><a href="/order/userlist?uid=${user.uid}">查看订单</a> </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script>

<script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>

<div id="divv">
    <div id="pages">
        <c:if test="${pageBean.t==null}">
            <c:if test="${pageBean.pageNum>1}">
                <a href="/user/list?pageNum=1">首页</a>
            </c:if>
            <c:if test="${pageBean.pageNum>1}">
                <a href="/user/list?pageNum=${pageBean.pageNum-1}">上一页</a>
            </c:if>

            <c:if test="${pageBean.totalPage<=5}">
                <c:forEach var="i" begin="1" end="${pageBean.totalPage}">
                    <a href="/user/list?pageNum=${i}"
                       <c:if test="${pageBean.pageNum==i}">class="current_page" </c:if>>${i}</a>
                </c:forEach>
            </c:if>


            <c:if test="${pageBean.totalPage>5}">
                <c:if test="${pageBean.pageNum <= 3}">
                    <c:forEach var="i" begin="1" end="5">
                        <a href="/user/list?pageNum=${i}"
                           <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                    </c:forEach>
                </c:if>

                <c:if test="${pageBean.pageNum > 3 and pageBean.pageNum <= pageBean.totalPage -3}">
                    <c:forEach var="i" begin="${pageBean.pageNum-2}" end="${pageBean.pageNum+2}">
                        <a href="/user/list?pageNum=${i}"
                           <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                    </c:forEach>
                </c:if>
                <c:if test="${pageBean.pageNum > 3 and pageBean.pageNum > pageBean.totalPage-3}">
                    <c:forEach var="i" begin="${pageBean.totalPage-4}" end="${pageBean.totalPage}">
                        <a href="/user/list?pageNum=${i}"
                           <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                    </c:forEach>
                </c:if>

            </c:if>
            <c:if test="${pageBean.pageNum < pageBean.totalPage}">
                <a href="/user/list?pageNum=${pageBean.pageNum+1}">下一页</a>
                <a href="/user/list?pageNum=${pageBean.totalPage}">尾页</a>
            </c:if>
        </c:if>

        <c:if test="${pageBean.t!=null}">
            <c:if test="${pageBean.pageNum>1}">
                <a href="/user/query?pageNum=1">首页</a>
            </c:if>
            <c:if test="${pageBean.pageNum>1}">
                <a href="/user/query?pageNum=${pageBean.pageNum-1}">上一页</a>
            </c:if>

            <c:if test="${pageBean.totalPage<=5}">
                <c:forEach var="i" begin="1" end="${pageBean.totalPage}">
                    <a href="/user/query?pageNum=${i}"
                       <c:if test="${pageBean.pageNum==i}">class="current_page" </c:if>>${i}</a>
                </c:forEach>
            </c:if>


            <c:if test="${pageBean.totalPage>5}">
                <c:if test="${pageBean.pageNum <= 3}">
                    <c:forEach var="i" begin="1" end="5">
                        <a href="/user/query?pageNum=${i}"
                           <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                    </c:forEach>
                </c:if>

                <c:if test="${pageBean.pageNum > 3 and pageBean.pageNum <= pageBean.totalPage -3}">
                    <c:forEach var="i" begin="${pageBean.pageNum-2}" end="${pageBean.pageNum+2}">
                        <a href="/user/query?pageNum=${i}"
                           <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                    </c:forEach>
                </c:if>
                <c:if test="${pageBean.pageNum > 3 and pageBean.pageNum > pageBean.totalPage-3}">
                    <c:forEach var="i" begin="${pageBean.totalPage-4}" end="${pageBean.totalPage}">
                        <a href="/user/query?pageNum=${i}"
                           <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                    </c:forEach>
                </c:if>

            </c:if>
            <c:if test="${pageBean.pageNum < pageBean.totalPage}">
                <a href="/user/query?pageNum=${pageBean.pageNum+1}">下一页</a>
                <a href="/user/query?pageNum=${pageBean.totalPage}">尾页</a>
            </c:if>
        </c:if>
    </div>
</div>
<script type="text/javascript">
    function databath() {
       var deleteIds = [];
       $("input:checkbox:checked").each(function () {
           deleteIds.push($(this).val())
       });
        layer.confirm('确定要全部删除吗?',function (index) {
            if (deleteIds.length == 0){
                layer.msg('至少选择一条删除!', {icon: 2, time: 3000})
            }else {
                $.ajax({
                    type: "post",
                    url:"/user/databath",
                    data:{
                        deleteIds: deleteIds
                    },success:function (result) {
                        if (result.count > 0){
                            layer.msg('删除成功!, {icon: 1, time: 2000}')
                            location.href ="/user/list"
                        }
                    }
                })
            }
        })
    }


</script>

</body>
</html>
