<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
      <script src="/js/jquery-3.2.1.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 13pt;

	}
	.icon {

		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 190px;
		text-align: center;
		float: left;
	}

    #img{
        width: 160px;
        height: 190px;
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
  <c:forEach items="${pageBean.data}" var="item">
          <div class="icon" id="div">
              <a href="<c:url value='/item/desc?iid=${item.iid}'/>"><img  id="img" src="<c:url value='${item.image}'/>" border="0"/></a>
              <br/>
              <a href="<c:url value='/item/desc?iid=${item.iid}'/>">${item.iname}</a>
          </div>
  </c:forEach>




  <div id="divv">
      <div id="pages">
          <c:if test="${pageBean.pageNum>1}">
              <a href="/item/list?pageNum=1">首页</a>
          </c:if>
          <c:if test="${pageBean.pageNum>1}">
              <a href="/item/list?pageNum=${pageBean.pageNum-1}">上一页</a>
          </c:if>

          <c:if test="${pageBean.totalPage<=5}">
              <c:forEach var="i" begin="1" end="${pageBean.totalPage}">
                  <a href="/item/list?pageNum=${i}"
                     <c:if test="${pageBean.pageNum==i}">class="current_page" </c:if>>${i}</a>
              </c:forEach>
          </c:if>


          <c:if test="${pageBean.totalPage>5}">
              <c:if test="${pageBean.pageNum <= 3}">
                  <c:forEach var="i" begin="1" end="5">
                      <a href="/item/list?pageNum=${i}"
                         <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                  </c:forEach>
              </c:if>

              <c:if test="${pageBean.pageNum > 3 and pageBean.pageNum <= pageBean.totalPage -3}">
                  <c:forEach var="i" begin="${pageBean.pageNum-2}" end="${pageBean.pageNum+2}">
                      <a href="/item/list?pageNum=${i}"
                         <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                  </c:forEach>
              </c:if>
              <c:if test="${pageBean.pageNum > 3 and pageBean.pageNum > pageBean.totalPage-3}">
                  <c:forEach var="i" begin="${pageBean.totalPage-4}" end="${pageBean.totalPage}">
                      <a href="/item/list?pageNum=${i}"
                         <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
                  </c:forEach>
              </c:if>

          </c:if>
          <c:if test="${pageBean.pageNum < pageBean.totalPage}">
              <a href="/item/list?pageNum=${pageBean.pageNum+1}">下一页</a>
              <a href="/item/list?pageNum=${pageBean.totalPage}">尾页</a>
          </c:if>
      </div>
  </div>
  </body>

</html>

