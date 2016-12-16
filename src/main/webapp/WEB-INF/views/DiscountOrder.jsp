<%@ page language = "java" import = "java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Product Information</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/dashboard.css" rel="stylesheet">
<link href="css/font-awesome.css" rel="stylesheet" />
<!--CUSTOM BASIC STYLES-->
<link href="css/basic.css" rel="stylesheet" />
<!--CUSTOM MAIN STYLES-->
<link href="css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link href="css/styleBackground.css" rel="stylesheet" />
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<%@include file="headerBackground.jsp"%>
	<%request.setCharacterEncoding("utf-8");%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"style="color: #252830;">
		<div class="row">
			<div class="col-lg-6">
				<h1 class="page-header">產品列表</h1>
			</div>
			<div class="col-lg-3">
			<form class="navbar-form navbar-right" role="search" action="psearch" method="POST">
				<div class="input-group">
				
					<input type="text" class="form-control"name="searchword" placeholder="Search for..."style="border-radius: 40px;"> 
						<span class="input-group-btn">
						<button type="submit"class="btn btn-default"style="border-radius: 40px;">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</span>
					
				</div>
				</form>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-lg-3">
				<div class="input-group">
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#myAddProduct">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增產品
					</button>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#home"
				aria-controls="home" role="tab" data-toggle="tab"
				style="color: #252830;">條列式</a></li>
			<li role="presentation"><a href="#profile"
				aria-controls="profile" role="tab" data-toggle="tab"
				style="color: #252830;">區塊式</a></li>
				
				</ul>
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane fade in active" id="home">
				<h2 id="MacBook_Pro">已出貨產品</h2>
				
				<div class="table-responsive">
					<table class="table table-striped table-show-product">
						<thead>
						
							<tr>
								
								<th>#訂單編號</th>
								<th>訂單會員</th>
								<th>價錢</th>
								<th>訂單日期</th>
								<th>出貨狀態</th>
								
							</tr>
							
						</thead>
						<tbody>
						<c:forEach items="${orderList}" var="order">
						<c:if test="${order.getShipping()==1}">
							
								<tr>
									<td><c:out value="${order.getOrder_id()}" /></td>
									<td><c:out value="${order.getOrder_M_id()}" /></td>
									<td><c:out value="${order.getTotal()}" /></td>
									<td><c:out value="${order.getO_date()}" /></td>
									
									<td>已出貨</td>
									
									<td><button type="button" class="btn btn-success"
											data-toggle="modal" data-target="#myModifyOrder<c:out value="${order.getOrder_id()}" />">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>折讓
										</button></td>
									
								</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		<div role="tabpanel" class="tab-pane fade" id="profile">
				<h2 id="MacBook_Pro">產品</h2>
				<div class="row">
				
				</div>
				
			</div>
		</div>
	</div>

	<!-- Modal -->
	<c:forEach items="${orderList}" var="order1">
		<div class="modal fade"
			id="myModifyOrder<c:out value="${order1.getOrder_id()}"/>"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改訂單狀態</h4>
					</div>
					
					<form class="form-horizontal" action="updateProduct" method="post">
					<input type="hidden" name="p_id" value="<c:out value="${order1.getOrder_id()}"/>">
						<div class="modal-body">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">訂單編號</label>
								<div class="col-sm-8">
									<c:out value="${order1.getOrder_id()}"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">訂購會員</label>
							<div class="col-sm-8">
								<label for="inputEmail3" class="col-sm-2 control-label">
									<c:out value="${order1.getOrder_M_id()}"/>
									</label>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">訂單金額</label>
							<div class="col-sm-8">
								<label for="inputEmail3" class="col-sm-2 control-label">
									<c:out value="${order1.gettotal()}"/>
									</label>							
									</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">折讓價錢</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="d_price" id="inputEmail3" placeholder="價錢">
							</div>
						</div>
				
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" name="type" value="modifyProduct"></input>
				</div>
				</form>
			</div>
		</div>
</div>
	</c:forEach>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>