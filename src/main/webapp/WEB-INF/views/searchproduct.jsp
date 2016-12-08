<%@ page language="java" contentType="text/html; charset=UTF-8"
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

    <title>searchproduct</title>

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
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
		style="color: #252830;">
		<div class="row">
			<div class="col-lg-6">
				<h1 class="page-header">搜尋結果</h1>
			</div>
			</div>
		
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

							<c:forEach items="${ProductList}" var="searchproduct">
								<tr>
									<td><img style="width:100px;" src="<c:out value="${searchproduct.getP_image()}" />"></td>
									<td><c:out value="${searchproduct.getP_id()}" /></td>
									<td><c:out value="${searchproduct.getP_name()}" /></td>
									<td><c:out value="${searchproduct.getP_describe()}" /></td>
									<td><c:out value="${searchproduct.getP_price()}" /></td>
									<td><c:out value="${searchproduct.getP_inventory()}" /></td>
									<td><c:out value="${searchproduct.getP_onsale_date()}" /></td>
									<td><c:out value="${searchproduct.getP_update_date()}" /></td>
									<td><c:out value="${searchproduct.getP_remove_date()}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</div>
</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
