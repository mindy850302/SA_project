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

    <title>searchmember</title>

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
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="color: #252830;">
        <div class="row">
          <div class="col-lg-6">
            <h1 class="page-header">搜尋結果</h1>
          </div>
          <div class="col-lg-3">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for..." style="border-radius: 40px;">
                <span class="input-group-btn" >
                  <button class="btn btn-default" type="button" style="border-radius: 40px;"><span class="glyphicon glyphicon-search" aria-hidden="true" ></span></button>
                </span>
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
           
        </div>
         
<!-- Member -->
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="home">
            <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th></th>
                  <th>產品編號</th>
                  <th>產品名稱</th>
                  <th>產品描述</th>
                  <th>價錢</th>
                  <th>存貨數量</th>
                  <th>上架日期</th>
                  <th>更新日期</th>
                  <th>下架日期</th>
                  <th>產品狀態</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
             <c:forEach  items="${ProductList}" var="ProductList">
             	<c:if test="${ProductList.getP_inventory()<=20}" >
                <tr>
                  <td><img class="product_img_list" src="<c:out value="${ProductList.getP_image()}"/>"></td>
                  <td><c:out value="${ProductList.getP_id()}"/></td>
                  <td><c:out value="${ProductList.getP_name()}"/></td>
                  <td><c:out value="${ProductList.getP_describe()}"/></td>
                  <td><c:out value="${ProductList.getP_price()}"/></td>
                  <td><c:out value="${ProductList.getP_inventory()}"/></td>
                  <td><c:out value="${ProductList.getP_onsale_date()}"/></td>
                  <td><c:out value="${ProductList.getP_update_date()}"/></td>
                  <td><c:out value="${ProductList.getP_remove_date()}"/></td>
                  <td>	<c:if test="${ProductList.isSale()==0}" >已下架</c:if>
                  	<c:if test="${ProductList.isSale()==1}" >上架中</c:if>
                  
                 </td>
                  
                  <td><button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myAddInventory<c:out value="${ProductList.getP_id()}"/>">追加存貨</button></td>
                  <td><button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#myRemoveInventory<c:out value="${ProductList.getP_id()}"/>">下架產品</button></td>
                </tr>
                </c:if>
                </c:forEach>
              </tbody>
            </table>
          </div>
          </div>
</div>
</div>
<c:forEach  items="${ProductList}" var="Product">
    <div class="modal fade" id="myAddInventory<c:out value="${Product.getP_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">追加存貨</h4>
          </div>
          
            <form class="form-horizontal" method="post" action="addInventory">
            <div class="modal-body">
                    <input type="hidden" name="p_id" value="<c:out value="${Product.getP_id()}"/>">
                	<input type="hidden" name="inventoryNumber" value="<c:out value="${Product.getP_inventory()}"/>">
                <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">追加量</label>
                <div class="col-sm-8">
                  <input type="number" class="form-control" id="inputEmail3" placeholder="追加量" name="p_inventory" >
                  
                </div>
              </div>
            
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            
            <input type="submit" class="btn btn-primary" name="type" value="modifyInventory"/>
            </div>
           </form>
        </div>
      </div>
    </div>
    </c:forEach>
    
    
   <c:forEach  items="${ProductList}" var="Product1">
    
	<div class="modal fade" id="myRemoveInventory<c:out value="${Product1.getP_id()}"/>" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">下架</h4>
				</div>
				            <form class="form-horizontal" method="post" action="removeInventory">
				
				<div class="modal-body">
				<input type="hidden" name="p_id" value="<c:out value="${Product1.getP_id()}"/>">
                	<input type="hidden" name="sale" value="<c:out value="${Product1.isSale()}"/>">
                	
					<p>下架後產品將不顯示於消費者觀看頁面，確定是否下架？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" name="type"  value="removeInventory" />
				</div>
				</form>
			</div>
		</div>
		</div>
		</c:forEach>
        

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
