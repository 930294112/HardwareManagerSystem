<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分类列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link href="/css/bootstrap.min.css" rel="stylesheet">
	  <script src="/js/jquery-3.2.1.js"></script>
<style type="text/css">

	table {font-family: 宋体; font-size: 17pt; border-color: rgb(32,145,177);  width: 60%;}
	#th {background: rgb(32,145,177);}

	#div{
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
	.text-c{
		position: absolute;
		left: 60%;
	}
	.input-text{
		margin-right: -6px;
		border-radius: 2px;
	}
	#th{
		text-align: center;
		color: white;
	}



</style>
  </head>
  
  <body>
    <h2 style="text-align: center;">分类列表</h2>
	<div class="text-c">
		<form class="" method="post" action="/category/queryByName" target="_self">
			<input type="text" class="input-text" style="width: 200px ;height: 31px;" placeholder="输入分类名称" id="cname" value="" name="cname">
			<input type="submit" value="搜索" class="btn btn-success">
		</form>
	</div>
	<br><br>
    <table align="center" border="1" cellpadding="0" cellspacing="0">
		<thead>
		<tr id="th">
			<th>分类名称</th>
			<th>操作</th>
		</tr>
		</thead>

		<c:forEach items="${pageBean.data}" var="category">
			<tr >
				<td>${category.cname}</td>
				<td>
					<a href="<c:url value='/category/mod?cid=${category.cid}'/>">修改</a> |
					<a href="<c:url value='/category/del?cid=${category.cid}'/>">删除</a> |
					<a href="<c:url value='/category/query?cid=${category.cid}'/>">查询其下商品</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<div id="div">
		<div id="pages">
			<c:if test="${pageBean.condition==null}">
				<c:if test="${pageBean.pageNum>1}">
					<a href="/category/list?pageNum=1">首页</a>
				</c:if>
				<c:if test="${pageBean.pageNum>1}">
					<a href="/category/list?pageNum=${pageBean.pageNum-1}">上一页</a>
				</c:if>

				<c:if test="${pageBean.totalPage<=5}">
					<c:forEach var="i" begin="1" end="${pageBean.totalPage}">
						<a href="/category/list?pageNum=${i}"
						   <c:if test="${pageBean.pageNum==i}">class="current_page" </c:if>>${i}</a>
					</c:forEach>
				</c:if>


				<c:if test="${pageBean.totalPage>5}">
					<c:if test="${pageBean.pageNum <= 3}">
						<c:forEach var="i" begin="1" end="5">
							<a href="/category/list?pageNum=${i}"
							   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
						</c:forEach>
					</c:if>

					<c:if test="${pageBean.pageNum > 3 and pageBean.pageNum <= pageBean.totalPage -3}">
						<c:forEach var="i" begin="${pageBean.pageNum-2}" end="${pageBean.pageNum+2}">
							<a href="/category/list?pageNum=${i}"
							   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
						</c:forEach>
					</c:if>
					<c:if test="${pageBean.pageNum > 3 and pageBean.pageNum > pageBean.totalPage-3}">
						<c:forEach var="i" begin="${pageBean.totalPage-4}" end="${pageBean.totalPage}">
							<a href="/category/list?pageNum=${i}"
							   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
						</c:forEach>
					</c:if>

				</c:if>
				<c:if test="${pageBean.pageNum < pageBean.totalPage}">
					<a href="/category/list?pageNum=${pageBean.pageNum+1}">下一页</a>
					<a href="/category/list?pageNum=${pageBean.totalPage}">尾页</a>
				</c:if>
			</c:if>

		<c:if test="${pageBean.condition!=null}">
			<c:if test="${pageBean.pageNum>1}">
				<a href="/category/queryByName?pageNum=1&cname=${pageBean.condition}">首页</a>
			</c:if>
			<c:if test="${pageBean.pageNum>1}">
				<a href="/category/queryByName?pageNum=${pageBean.pageNum-1}&cname=${pageBean.condition}">上一页</a>
			</c:if>

			<c:if test="${pageBean.totalPage<=5}">
				<c:forEach var="i" begin="1" end="${pageBean.totalPage}">
					<a href="/category/queryByName?pageNum=${i}&cname=${pageBean.condition}"
					   <c:if test="${pageBean.pageNum==i}">class="current_page" </c:if>>${i}</a>
				</c:forEach>
			</c:if>


			<c:if test="${pageBean.totalPage>5}">
				<c:if test="${pageBean.pageNum <= 3}">
					<c:forEach var="i" begin="1" end="5">
						<a href="/category/queryByName?pageNum=${i}&cname=${pageBean.condition}"
						   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
					</c:forEach>
				</c:if>

				<c:if test="${pageBean.pageNum > 3 and pageBean.pageNum <= pageBean.totalPage -3}">
					<c:forEach var="i" begin="${pageBean.pageNum-2}" end="${pageBean.pageNum+2}">
						<a href="/category/queryByName?pageNum=${i}&cname=${pageBean.condition}"
						   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
					</c:forEach>
				</c:if>
				<c:if test="${pageBean.pageNum > 3 and pageBean.pageNum > pageBean.totalPage-3}">
					<c:forEach var="i" begin="${pageBean.totalPage-4}" end="${pageBean.totalPage}">
						<a href="/category/queryByName?pageNum=${i}&cname=${pageBean.condition}"
						   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
					</c:forEach>
				</c:if>

			</c:if>
			<c:if test="${pageBean.pageNum < pageBean.totalPage}">
				<a href="/category/queryByName?pageNum=${pageBean.pageNum+1}&cname=${pageBean.condition}">下一页</a>
				<a href="/category/queryByName?pageNum=${pageBean.totalPage}&cname=${pageBean.condition}">尾页</a>
			</c:if>
		</c:if>
		</div>
</div>
  <script type="text/javascript">
	  layer.confirm(${msg},function (index) {
		  location.href="/category/list"
      })
  </script>
  </body>

</html>
