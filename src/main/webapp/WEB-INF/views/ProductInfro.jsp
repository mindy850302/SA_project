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
				<h2 id="MacBook_Pro">產品</h2>
				<div class="table-responsive">
					<table class="table table-striped table-show-product">
						<thead>
							<tr>
								<th></th>
								<th>#產品編號</th>
								<th>產品名稱</th>
								<th>產品描述</th>
								<th>價錢</th>
								<th>存貨數量</th>
								<th>上架日期</th>
								<th>更新日期</th>
								<th>下架日期</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${ProductList}" var="product">
								<tr>
									<td><img style="width:100px;" src="<c:out value="${product.getP_image()}" />"></td>
									<td><c:out value="${product.getP_id()}" /></td>
									<td><c:out value="${product.getP_name()}" /></td>
									<td><c:out value="${product.getP_describe()}" /></td>
									<td><c:out value="${product.getP_price()}" /></td>
									<td><c:out value="${product.getP_inventory()}" /></td>
									<td><c:out value="${product.getP_onsale_date()}" /></td>
									<td><c:out value="${product.getP_update_date()}" /></td>
									<td><c:out value="${product.getP_remove_date()}" /></td>

									<td><button type="button" class="btn btn-success"
											data-toggle="modal" data-target="#myModifyProduct<c:out value="${product.getP_id()}" />">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</button></td>
									<td><button type="button" class="btn btn-danger"
											data-toggle="modal" data-target="#mydeleteProduct<c:out value="${product.getP_id()}" />">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		<div role="tabpanel" class="tab-pane fade" id="profile">
				<h2 id="MacBook_Pro">產品</h2>
				<div class="row">
				<c:forEach items="${ProductList}" var="product">
				
					<div class="col-sm-3 col-md-3">
						<div class="thumbnail">
							<img src="<c:out value="${product.getP_image()}" />" alt="...">
							<div class="caption">
								
								

										<h5>
											<c:out value="${product.getP_name()}" />
										</h5>
										<h5 style="color: #777070; line-height: 25px;">
											<c:out value="${product.getP_describe()}" />
										</h5>
										<h5>
											<c:out value="${product.getP_price()}" />
										</h5>
										<h5>
											存貨數量：
											<c:out value="${product.getP_inventory()}" />
										</h5>
										<h5>
											上架日期：
											<c:out value="${product.getP_onsale_date()}" />
										</h5>
										<h5>
											更新日期：
											<c:out value="${product.getP_update_date()}" />
										</h5>
										<h5>
											下架日期：
											<c:out value="${product.getP_remove_date()}" />
										</h5>
										<button type="button" class="btn btn-success"
											data-toggle="modal" data-target="#myModifyProduct">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</button>
										<button type="button" class="btn btn-danger"
											data-toggle="modal" data-target="#mydeleteProduct">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										</button>
								
								
							</div>
						</div>
					</div>
					</c:forEach>
				</div>
				
			</div>
		</div>
	</div>

	<!-- Modal -->
	<c:forEach items="${ProductList}" var="product1">
		<div class="modal fade"
			id="myModifyProduct<c:out value="${product1.getP_id()}"/>"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改產品</h4>
					</div>

					<form class="form-horizontal" action="updateProduct" method="post">
					<input type="hidden" name="p_id" value="<c:out value="${product1.getP_id()}"/>">
						<div class="modal-body">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">產品圖片</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="p_image"
										id="inputEmail3" placeholder="產品圖片"
										value="<c:out value="${product1.getP_image()}"/>">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">產品名稱</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="p_name"
									id="inputEmail3" placeholder="產品名稱"
									value="<c:out value="${product1.getP_name()}"/>">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">產品描述</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="p_describe"
									id="inputEmail3" placeholder="產品描述"
									value="<c:out value="${product1.getP_describe()}"/>">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">價錢</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="p_price"
									id="inputEmail3" placeholder="價錢"
									value="<c:out value="${product1.getP_price()}"/>">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">存貨數量</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="p_inventory"
									id="inputEmail3" placeholder="存貨數量"
									value="<c:out value="${product1.getP_inventory()}"/>">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">產品狀態</label>
							<div class="col-sm-8">
								<input type="radio" id="Member_check_add" name="sale"checked="checked" value="1" />&nbsp&nbsp上架<br> <input
									id="Administor_check_add" type="radio" name="sale" value="0" />&nbsp&nbsp下架
								
							</div>
						</div>
					
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" name="type"
						value="modifyProduct"></input>
				</div>
				</form>
			</div>
		</div>
</div>
	</c:forEach>
	<!-- Add Product -->
	<div class="modal fade" id="myAddProduct" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增產品</h4>
				</div>

				<div class="modal-body">
					<form class="form-horizontal" action="insertProduct" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">產品種類</label>
							<div class="col-sm-8">
								<input type="radio" name="p_category" value="1" />iPhone <input
									type="radio" name="p_category" value="2" />iPad <input
									type="radio" name="p_category" value="3" />MacBook
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">產品圖片</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="p_image"
									id="inputEmail3" placeholder="產品圖片">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">產品名稱</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="p_name"
									id="inputEmail3" placeholder="產品名稱">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">產品描述</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="p_describe"
									id="inputEmail3" placeholder="產品描述">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">價錢</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="p_price"
									id="inputEmail3" placeholder="價錢">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">存貨數量</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="p_inventory"
									id="inputEmail3" placeholder="存貨數量">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">產品狀態</label>
							<div class="col-sm-8">
								<input type="radio" id="Member_check_add" name="sale"
									checked="checked" value="0" />&nbsp&nbsp上架<br> <input
									id="Administor_check_add" type="radio" name="sale" value="1" />&nbsp&nbsp下架

							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<input type="submit" class="btn btn-primary" name="type"
								value="insertProduct"></input>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Delete Product -->
	<c:forEach items="${ProductList}" var="product2">
		<form action="deleteProduct" method="post">
			<div class="modal fade" id="mydeleteProduct<c:out value="${product2.getP_id()}"/>"  tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">刪除產品</h4>
						</div>
						<div class="modal-body">
							<table class="table table-striped table-show-product-delete">
								<tbody>
								<input type="hidden" name="p_id" value="${product2.getP_id()}"/>
									
									<tr>
										<td><img class="product_img_list" src="<c:out value="${product2.getP_image()}" />"></td>
										<td><c:out value="${product2.getP_id()}" /></td>
										<td><c:out value="${product2.getP_name()}" /></td>
										<td><c:out value="${product2.getP_describe()}" /></td>
										<td><c:out value="${product2.getP_price()}" /></td>
										<td><c:out value="${product2.getP_inventory()}" /></td>
										<td><c:out value="${product2.getP_onsale_date()}" /></td>
										<td><c:out value="${product2.getP_update_date()}" /></td>
										<td><c:out value="${product2.getP_remove_date()}" /></td>
									</tr>
								
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit"action="ProductInfro"name="type" class="btn btn-primary"value="deleteProduct">確認</button>
						</div>
					</div>
				</div>
			</div>
		</form>
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