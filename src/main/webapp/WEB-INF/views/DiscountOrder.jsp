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

    <title>Dashboard Template for Bootstrap</title>

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
          <div class="col-lg-6">
            <h1 class="page-header">折讓</h1>
          </div>
          <div class="col-lg-3">
              <div class="input-group">
               <!--  <input type="text" class="form-control" placeholder="退貨查詢" style="border-radius: 40px;">
                <span class="input-group-btn" >
                  <button class="btn btn-default" type="button" style="border-radius: 40px;"><span class="glyphicon glyphicon-search" aria-hidden="true" ></span></button>
                </span> -->
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
             <div class="col-lg-3">
              <div class="input-group">
                <a type="button" class="btn btn-default" href="DiscountDetail"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>折讓明細</a>
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div>
          <ul class="nav nav-tabs" role="tablist" >
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" style="color: #252830;">已出貨訂單</a></li>
             <!-- <li role="presentation" ><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" style="color: #252830;">退貨紀錄</a></li> -->
          </ul>
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="home">
            <div class="table-responsive">
            <table class="table table-striped table-show-product">
              <thead>
                <tr>
                  <th>#訂單編號</th>
                  <th>訂購人編號</th>
                  <th>訂購人姓名</th>
                  <th>訂貨日期</th>
                  <th>出貨日期</th>
                  <th>訂單金額</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
             <c:forEach  items="${orderList}" var="order">
             	<c:if test="${order.getShipping()==1 && order.getOrder_status()==0}" >
	                <tr>
	                  <td><c:out value="${order.getOrder_id()}"/></td>
		              <td><c:out value="${order.getOrder_M_id()}"/></td>
		              <td><c:out value="${order.getMember().getM_name()}"/></td>
	                  <td><c:out value="${order.getO_date()}"/></td>
	                  <td><c:out value="${order.getShipping_Date()}"/></td>
	                  <td><c:out value="${order.getTotal()}"/></td>
	                  <td><button type="button" class="btn btn-success"   data-toggle="modal" data-target="#myReturn<c:out value="${order.getOrder_id()}"/>">折讓</button></td>
	                </tr>
	                </c:if>
	          </c:forEach>
              </tbody>
            </table>
          </div>
            </div>
        </div>
      </div>
    
    <!-- Modal -->
  <c:forEach  items="${orderList}" var="order1">
    <div class="modal fade" id="myReturn<c:out value="${order1.getOrder_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">新增折讓</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" method="post" action="addDiscount">
           <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">折讓人姓名</label>
                <div class="col-sm-7">
                  <input type="hidden" name="discount_order_id" value="<c:out value="${order1.getOrder_id()}"/>">
                  <p class="form-control-static" style="margin-top: 0rem"><c:out value="${order1.getMember().getM_name()}"></c:out></p>
                </div>
              </div>
              
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">訂單總額</label>
                <div class="col-sm-7">
                  <p class="form-control-static" style="margin-top: 0rem"><c:out value="${order1.getTotal()}"></c:out></p>
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">承辦人姓名</label>
                <div class="col-sm-7">
                  <select name="discount_A_id" class="form-control">
                     <c:forEach items="${administratorList}" var="administrator">
        					<option value="<c:out value="${administrator.getA_id()}"/>"><c:out value="${administrator.getM_name()}"/></option>
        			</c:forEach>
				   </select>
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">折讓訂單金額</label>
                <div class="col-sm-7">
                  <input type="number" name="discount_total" class="form-control">
                </div>
              </div>
              <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		            <input type="submit" class="btn btn-primary" name="type" value="addDiscount"/>
         	 </div>
            </form>
          </div>
          
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
