<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	  <script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
	  <link href="/css/font-awesome.css" rel="stylesheet">
	  <link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 13pt;
	}
	#divimg {
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
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
	  <style type="text/css" media="print">
		  .noprint{
			  display: none;
		  }

	  </style>
  </head>
  
  <body>
  <h1>
	  <c:if test="${pageBean.condition==0}"><h1>所有订单</h1></c:if>
	  <c:if test="${pageBean.condition==1}"><h1>未付款订单</h1></c:if>
	  <c:if test="${pageBean.condition==2}"><h1>已付款订单</h1></c:if>
	  <c:if test="${pageBean.condition==3}"><h1>未收货订单</h1></c:if>
	  <c:if test="${pageBean.condition==4}"><h1>已完成订单</h1></c:if>
  </h1>
  <%--<input id="btnPrint" type="button" value="打印订单" onclick="javascript:window.print(); "--%>
	<%--style="color:#00f; font-weight:bold; text-decoration:none;cursor:pointer!important; cursor:hand"/>--%>
  <table border="1" width="100%" cellspacing="0" background="black">
	<c:forEach items="${pageBean.data}" var="order">
		<tr style="color: white;background-color: rgb(32,145,177)">
			<td colspan="6">
				<a href="/order/print?oid=${order.oid}">打印该订单</a>
				订单编号：${order.oid}&nbsp;&nbsp;&nbsp;&nbsp;
				下单时间：${order.ordertime}&nbsp;&nbsp;&nbsp;&nbsp;
				金额：<font color="red"><b>${order.subtotal}&yen;&nbsp;&nbsp;&nbsp;&nbsp;</b></font>
				<c:if test="${order.state==1}">
					<input type="button" style="width: 90px; text-align: center ;text-decoration: none" value="未付款" >
				</c:if>
				<c:if test="${order.state==2}">
					<input type="button" style="width: 90px; text-align: center ;text-decoration: none" onclick="send(${order.oid})" value="点击发货" >

				</c:if>
				<c:if test="${order.state==3}">
					<input type="button" style="width: 120px; text-align: center ;text-decoration: none" value="等待买家收货" >
				</c:if>
				<c:if test="${order.state==4}">
					<input type="button" style="width: 90px; text-align: center ;text-decoration: none" value="订单完成" >
				</c:if>&nbsp;&nbsp;&nbsp;&nbsp;

				<form action="/order/addCustomer?oid=${order.oid}" method="post">
					客户单位：
					<select id=""  style="height: 25px;font-size: 13pt" name="cuid">
						<option>---请选择客户单位---</option>
						<c:forEach items="${customers}" var="customer">
							<option value="${customer.cuid}"
									<c:if test="${order.cuid == customer.cuid}">selected="selected" </c:if>
									 >${customer.cuname}</option>
						</c:forEach>
					</select>
					<input style=" height:25px;font-size: 13pt" type="submit" value="确认" onclick="customer(${order.oid})">
				</form>

			</td>
		</tr>

		<c:forEach items="${order.orderItemList}" var="oderItem">
			<tr bordercolor="rgb(78,78,78)" align="center">
				<td>商品名称：${oderItem.item.iname}</td>
				<td>单价：${oderItem.item.price}</td>
				<td>类型：${oderItem.item.category.cname}</td>
				<td>数量：${oderItem.count}</td>
				<td>小计：${oderItem.total}</td>
				<td>留言：${order.context}</td>
			</tr>
		</c:forEach>
	</c:forEach>
</table>


<div id="divv">
	<div id="pages">
		<c:if test="${pageBean.pageNum>1}">
				<a href="/order/list?pageNum=1&state=${pageBean.condition}">首页</a>
			</c:if>
			<c:if test="${pageBean.pageNum>1}">
				<a href="/order/list?pageNum=${pageBean.pageNum-1}&state=${pageBean.condition}">上一页</a>
			</c:if>

			<c:if test="${pageBean.totalPage<=5}">
				<c:forEach var="i" begin="1" end="${pageBean.totalPage}">
					<a href="/order/list?pageNum=${i}&state=${pageBean.condition}"
					   <c:if test="${pageBean.pageNum==i}">class="current_page" </c:if>>${i}</a>
				</c:forEach>
			</c:if>


			<c:if test="${pageBean.totalPage>5}">
				<c:if test="${pageBean.pageNum <= 3}">
					<c:forEach var="i" begin="1" end="5">
						<a href="/order/list?pageNum=${i}&state=${pageBean.condition}"
						   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
					</c:forEach>
				</c:if>

				<c:if test="${pageBean.pageNum > 3 and pageBean.pageNum <= pageBean.totalPage -3}">
					<c:forEach var="i" begin="${pageBean.pageNum-2}" end="${pageBean.pageNum+2}">
						<a href="/order/list?pageNum=${i}&state=${pageBean.condition}"
						   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
					</c:forEach>
				</c:if>
				<c:if test="${pageBean.pageNum > 3 and pageBean.pageNum > pageBean.totalPage-3}">
					<c:forEach var="i" begin="${pageBean.totalPage-4}" end="${pageBean.totalPage}">
						<a href="/order/list?pageNum=${i}&state=${pageBean.condition}"
						   <c:if test="${pageBean.pageNum == i}">class="current_page"</c:if> >${i}</a>
					</c:forEach>
				</c:if>

			</c:if>
			<c:if test="${pageBean.pageNum < pageBean.totalPage}">
				<a href="/order/list?pageNum=${pageBean.pageNum+1}&state=${pageBean.condition}">下一页</a>
				<a href="/order/list?pageNum=${pageBean.totalPage}&state=${pageBean.condition}">尾页</a>
			</c:if>

	</div>
</div>
  <script type="text/javascript">
	  function send(oid) {
		  $.ajax({
			  url:"/order/updateState",
			  data:{
			      oid:oid
			  },success:function (result) {
				  if (result.count>0){
                      alert("发货成功！")
                      location.href ="/order/list?state=2"
				  }
              }
		  })
      }

      // function customer(oid) {
	   //    var cuid = $("option:selected").val()
		//   alert(cuid)
		//   $.ajax({
		// 	  url:"/order/addCustomer",
		// 	  data:{
		// 	      oid:oid,
		// 	      cuid:$("option:selected:selected").val()
      //
		// 	  // },success:function (result) {
		// 		//   if (result.count>0){
      //          //        location.href ="/order/list?state=0"
		// 		//   }
      //         }
      //
		//   })
      // }


  </script>
  </body>
</html>
