<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>库销列表</title>
    <script src="/js/jquery-3.2.1.js"></script>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/font-awesome.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .text-c {
            text-align: center;

        }

        .page-container {
            padding: 20px
        }

        @media (max-width: 767px) {
            .page-container {
                padding: 15px
            }
        }


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


    </style>
</head>
<body>
<div class="page-container">
    <h1>库销列表</h1>
    <table class="table table-bordered" >
    <thead>
    <tr class="text-c">
        <th scope="col" colspan="3" style="text-align: center">商品名称</th>
        <th scope="col" colspan="3" style="text-align: center">库存
            <i  aria-hidden="true"  onclick="sort(this,'stock')"
                <c:if test="${stock_sort eq 'fa fa-sort-desc'}">class="fa fa-sort-desc"</c:if>
                <c:if test="${stock_sort eq 'fa fa-sort-asc'}">class="fa fa-sort-asc"</c:if>
                <c:if test="${empty stock_sort}">class="fa fa-sort-asc"</c:if>
              ></i>
        </th>
        <th scope="col" colspan="3" style="text-align: center">销量
            <i  aria-hidden="true" onclick="sort(this,'sales')"
               <c:if test="${sales_sort eq 'fa fa-sort-desc'}">class="fa fa-sort-desc"</c:if>
               <c:if test="${sales_sort eq 'fa fa-sort-asc'}">class="fa fa-sort-asc"</c:if>
               <c:if test="${empty sales_sort}">class="fa fa-sort-asc"</c:if>
            ></i>
        </th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${pageBean.data}" var="item">
        <tr class="text-c">
            <td scope="col" colspan="3">${item.iname}</td>
            <td scope="col" colspan="3">${item.stock}</td>
            <td scope="col" colspan="3">${item.sales}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</div>

<div id="divv">
    <div id="pages">
        <c:if test="${pageBean.pageNum>1}">
            <a href="/stock_sales/list?pageNum=1">首页</a>
        </c:if>
        <c:if test="${pageBean.pageNum>1}">
            <a href="/stock_sales/list?pageNum=${pageBean.pageNum-1}">上一页</a>
        </c:if>

        <c:if test="${pageBean.totalPage<=5}">
            <c:forEach var="i" begin="1" end="${pageBean.totalPage}">
                <a href="/stock_sales/list?pageNum=${i}"
                   <c:if test="${pageBean.pageNum==i}">class="current_page" </c:if>>${i}</a>
            </c:forEach>
        </c:if>


        <c:if test="${pageBean.totalPage>5}">
            <c:if test="${pageBean.pageNum <= 3}">
                <c:forEach var="i" begin="1" end="5">
                    <a href="/stock_sales/list?pageNum=${i}"
                       <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                </c:forEach>
            </c:if>

            <c:if test="${pageBean.pageNum > 3 and pageBean.pageNum <= pageBean.totalPage -3}">
                <c:forEach var="i" begin="${pageBean.pageNum-2}" end="${pageBean.pageNum+2}">
                    <a href="/stock_sales/list?pageNum=${i}"
                       <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                </c:forEach>
            </c:if>
            <c:if test="${pageBean.pageNum > 3 and pageBean.pageNum > pageBean.totalPage-3}">
                <c:forEach var="i" begin="${pageBean.totalPage-4}" end="${pageBean.totalPage}">
                    <a href="/stock_sales/list?pageNum=${i}"
                       <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                </c:forEach>
            </c:if>

        </c:if>
        <c:if test="${pageBean.pageNum < pageBean.totalPage}">
            <a href="/stock_sales/list?pageNum=${pageBean.pageNum+1}">下一页</a>
            <a href="/stock_sales/list?pageNum=${pageBean.totalPage}">尾页</a>
        </c:if>
    </div>
</div>

<script type="text/javascript">


    function sort(obj,column) {
        if (obj.className == "fa fa-sort-asc") {
            obj.className="fa fa-sort-desc"
            location.href ="/stock_sales/list?sort="+obj.className + "&column="+column+""

        }else {
            obj.className="fa fa-sort-asc"
            location.href ="/stock_sales/list?sort="+obj.className + "&column="+column+""

        }
    }
</script>
</body>
</html>
