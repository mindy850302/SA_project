<%@ page language = "java" import = "java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <title>Product Category</title>

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
    <script type="text/javascript" src="js/myscriptBackground.js"></script>

    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <%@include file="headerBackground.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="color: #252830;">
        <div class="row">
          <div class="col-lg-9">
            <h1 class="page-header">產品種類</h1>
          </div>
             <div class="col-lg-3">
              <div class="input-group">
                <button type="button" class="btn btn-default"  data-toggle="modal" data-target="#AddProduct_category"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增種類</button>
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div>
          <ul class="nav nav-tabs" role="tablist" >
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" style="color: #252830;">種類列表</a></li>
          </ul>
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="home">
            <div class="table-responsive">
            <table class="table table-striped table-show-product">
              <thead>
                <tr>
                  <th>#產品種類編號</th>
                  <th>產品種類名稱</th>
                </tr>
              </thead>
              <tbody>
             <c:forEach  items="${Product_categoryList}" var="Product_category">
	             <tr>
	                 <td><c:out value="${Product_category.getId()}"/></td>
		             <td><c:out value="${Product_category.getName()}"/></td>
	                 <td><button type="button" class="btn btn-success"   data-toggle="modal" data-target="#ModifyProduct_category<c:out value="${Product_category.getId()}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span></button></td>
	              </tr>
	          </c:forEach>
              </tbody>
            </table>
          </div>
            </div>
        </div>
      </div>
<!-- Modify -->
    <c:forEach  items="${Product_categoryList}" var="Product_category1">
    	<div class="modal fade" id="ModifyProduct_category<c:out value="${Product_category1.getId()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      		<div class="modal-dialog" role="document">
        		<div class="modal-content">
          			<div class="modal-header">
            			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            			<h4 class="modal-title" id="myModalLabel">修改產品種類名稱</h4>
          			</div>
          			<form class="form-horizontal" action="updateProduct_category"  method="post">
          				<div class="modal-body">
          					<input type="hidden" name="id" value="<c:out value="${Product_category1.getId()}"/>">
            				<div class="form-group">
            					<div class="col-sm-1"></div>
                				<label for="inputEmail3" class="col-sm-3 control-label">產品種類編號</label>
					   			<div class="col-sm-5">
					   				<p><c:out value="${Product_category1.getId()}"/></p>
                				</div>
                				<div class="col-sm-2"></div>
					   		</div>
					   		<div class="form-group">
					   			<div class="col-sm-1"></div>
                				<label for="inputEmail3" class="col-sm-3 control-label">產品種類名稱</label>
					   			<div class="col-sm-5">
					   				<input type="text" class="form-control" name="name" placeholder="Category Name" value="<c:out value="${Product_category1.getName()}"/>">
                				</div>
                				<div class="col-sm-2"></div>
					   		</div>  
              			</div>
	              		<div class="modal-footer">
            				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            				<input type="submit" class="btn btn-primary" name="type" value="modifyProduct_category" >
          				</div>
	        		</form>
        		</div>
      		</div>
    	</div>
    </c:forEach>
<!-- Add -->
    	<div class="modal fade" id="AddProduct_category" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      		<div class="modal-dialog" role="document">
        		<div class="modal-content">
          			<div class="modal-header">
            			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            			<h4 class="modal-title" id="myModalLabel">新增產品種類</h4>
          			</div>
          			<form class="form-horizontal" action="addProduct_category"  method="post">
          				<div class="modal-body">
					   		<div class="form-group">
					   			<div class="col-sm-1"></div>
                				<label for="inputEmail3" class="col-sm-3 control-label">產品種類名稱</label>
					   			<div class="col-sm-5">
					   				<input type="text" class="form-control" required="required" name="name" placeholder="Category Name"">
                				</div>
					   		</div>  
              			</div>
	              		<div class="modal-footer">
            				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            				<input type="submit" class="btn btn-primary" name="action_type" value="addProduct_category" >
          				</div>
	        		</form>
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
