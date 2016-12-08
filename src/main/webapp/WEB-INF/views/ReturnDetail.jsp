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
            <h1 class="page-header">退貨紀錄</h1>
          </div>
          <div class="col-lg-3">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="退貨查詢" style="border-radius: 40px;">
                <span class="input-group-btn" >
                  <button class="btn btn-default" type="button" style="border-radius: 40px;"><span class="glyphicon glyphicon-search" aria-hidden="true" ></span></button>
                </span>
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
             <div class="col-lg-3">
              <div class="input-group">
                <button type="button" class="btn btn-default"  data-toggle="modal" data-target="#myAddReturn"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增退貨</button>
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div>
          <ul class="nav nav-tabs" role="tablist" >
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" style="color: #252830;">退貨明細</a></li>
             <!-- <li role="presentation" ><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" style="color: #252830;">退貨紀錄</a></li> -->
          </ul>
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="home">
            <div class="table-responsive">
            <table class="table table-striped table-show-product">
              <thead>
                <tr>
                  <th>#退貨編號</th>
                  <th>產品編號</th>
                  <th>產品名稱</th>
                  <th>產品數量</th>
                  <th>退貨人姓名</th>
                  <th>承辦人員</th>
                  <th>總金額</th>
                  <th>退貨日期</th>
                </tr>
              </thead>
              <tbody>
             <c:forEach  items="${ReturnList}" var="Return">
             	<c:forEach  items="${ReturnDetailList}" var="ReturnDetail">
             	<c:if test="${Return.getReturn_id()==ReturnDetail.getReturn_id()}" >
	                <tr>
	                  <td><c:out value="${ReturnDetail.getReturn_id()}"/></td>
		              <td><c:out value="${ReturnDetail.getReturn_p_id()}"/></td>
		              <td><c:out value="${ReturnDetail.getProduct().getP_name()}"/></td>
	                  <td><c:out value="${ReturnDetail.getP_amount()}"/></td>
	                  <td><c:out value="${Return.getMember().getM_name()}"/></td>
	                  <td><c:out value="${Return.getAdministrato().getM_name()}"/></td>
	                  <td><c:out value="${Return.getReturn_total()}"/></td>
	                  <td><c:out value="${Return.getReturn_date()}"/>2</td>
	                  <td><button type="button" class="btn btn-success"   data-toggle="modal" data-target="#myModify<c:out value="${ReturnDetail.getReturn_id()}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span></button></td>
                  	  <td><button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#mydelete<c:out value="${ReturnDetail.getReturn_id()}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
	                </tr>
	                </c:if>
	                </c:forEach>
	          </c:forEach>
              </tbody>
            </table>
          </div>
            </div>
        </div>
      </div>
    <c:forEach  items="${ReturnList}" var="Return1">
    <c:forEach  items="${ReturnDetailList}" var="ReturnDetail1">
     <!-- Modal -->
     <c:if test="${Return1.getReturn_id()==ReturnDetail1.getReturn_id()}" >
    <div class="modal fade" id="myModify<c:out value="${Return1.getReturn_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">修改退貨</h4>

          </div>
          <form class="form-horizontal" action="updateReturn"  method="post">
          <div class="modal-body">
              <input type="hidden" name="return_id" value="<c:out value="${Return1.getReturn_id()}"/>">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">產品編號</label>
	                <div class="col-sm-5">
		                <select name="return_p_id" class="form-control">
	                     <c:forEach items="${ProductList}" var="Product1">
	                     <c:if test="${ReturnDetail1.getReturn_p_id()==Product1.getP_id()}">
	                     <script>
	                     $(document).ready(function(){       
	                      $('#product<c:out value="${Return1.getReturn_id()}"/><c:out value="${ReturnDetail1.getReturn_p_id()}"/>').attr("selected","ture");
	                     });
	                     </script>
	                     </c:if>
	        					<option id="product<c:out value="${Return1.getReturn_id()}"/><c:out value="${Product1.getP_id()}"/>" value="<c:out value="${Product1.getP_id()}"/>"><c:out value="${Product1.getP_name()}"/></option>
	        			</c:forEach>
					   </select>
					   </div>
					   <div>
					   <div class="col-sm-2">
                  			<input type="number" class="form-control" name="p_amount" placeholder="數量" value="<c:out value="${ReturnDetail1.getP_amount()}"/>">
                		</div>
					   </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-3 control-label">退貨人姓名</label>
                <div class="col-sm-7">
                  <select name="return_M_id" class="form-control">
	                     <c:forEach items="${memberList}" var="member1">
	                     <c:if test="${Return1.getReturn_M_id()==member1.getM_id()}">
	                     <script>
	                     $(document).ready(function(){       
	                      $('#member<c:out value="${Return1.getReturn_id()}"/><c:out value="${Return1.getReturn_M_id()}"/>').attr("selected","ture");
	                     });
	                     </script>
	                     </c:if>
	        					<option id="member<c:out value="${Return1.getReturn_id()}"/><c:out value="${member1.getM_id()}"/>" value="<c:out value="${member1.getM_id()}"/>"><c:out value="${member1.getM_name()}"/></option>
	        			</c:forEach>
					   </select>
					  
                </div>
              </div>
				<div class="form-group">
                <label for="inputPassword3" class="col-sm-3 control-label">承辦人姓名</label>
                <div class="col-sm-7">
                  <select name="return_A_id" class="form-control">
	                     <c:forEach items="${administratorList}" var="administrator1">
	                     <c:if test="${Return1.getReturn_A_id()==administrator1.getA_id()}">
	                     <script>
	                     $(document).ready(function(){       
	                      $('#Adminstrator<c:out value="${Return1.getReturn_id()}"/><c:out value="${Return1.getReturn_A_id()}"/>').attr("selected","ture");
	                     });
	                     </script>
	                     </c:if>
	        					<option id="Adminstrator<c:out value="${Return1.getReturn_id()}"/><c:out value="${administrator1.getA_id()}"/>" value="<c:out value="${administrator1.getA_id()}"/>"><c:out value="${administrator1.getM_name()}"/></option>
	        			</c:forEach>
					   </select>
					  
                </div>
              </div>
              <input type="hidden" name="return_date" value="<c:out value="${Return1.getReturn_date()}"/>">
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" name="type" value="updateReturn" >
          </div>
        
        </form>
        </div>
      </div>
    </div>
   
    </div>
    </c:if>
    </c:forEach>
    </c:forEach>
    <!-- Modal -->
    <div class="modal fade" id="myAddReturn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">新增退貨</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" method="post" action="addReturn">
           <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">退貨人姓名</label>
                <div class="col-sm-7">
                  <select name="return_M_id" class="form-control">
	                     <c:forEach items="${memberList}" var="member">
	        					<option value="<c:out value="${member.getM_id()}"/>"><c:out value="${member.getM_name()}"/></option>
	        			</c:forEach>
					   </select>
                </div>
              </div>
              <div id="product_return">
	            <div class="form-group" >
	                <label for="inputEmail3" class="col-sm-3 control-label">產品編號</label>
	                <div class="col-sm-5">
		                <select name="return_p_id" class="form-control">
	                     <c:forEach items="${ProductList}" var="Product">
	        					<option value="<c:out value="${Product.getP_id()}"/>"><c:out value="${Product.getP_name()}"/></option>
	        			</c:forEach>
					   </select>
				   </div>
	                <div class="col-sm-2">
	                  <input type="number" class="form-control" id="inputEmail3" name="p_amount"  placeholder="數量" >
	                </div>
	              </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">承辦人姓名</label>
                <div class="col-sm-7">
                
                  <select name="return_A_id" class="form-control">
                     <c:forEach items="${administratorList}" var="administrator2">
        					<option value="<c:out value="${administrator2.getA_id()}"/>"><c:out value="${administrator2.getM_name()}"/></option>
        			</c:forEach>
				   </select>
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">退貨日期</label>
                <div class="col-sm-8">
                  <input type="Date" class="form-control" name="return_date" id="inputEmail3" placeholder="退貨日期" >
                </div>
              </div>
              <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		            <input type="submit" class="btn btn-primary" name="type" value="addReturn"/>
         	 </div>
            </form>
          </div>
          
        </div>
      </div>
    </div>
 <c:forEach  items="${ReturnList}" var="Return2">
 <c:forEach  items="${ReturnDetailList}" var="ReturnDetail2">
  <c:if test="${Return2.getReturn_id()==ReturnDetail2.getReturn_id()}" >
     <form action="deleteReturn" method="post">
    <div class="modal fade" id="mydelete<c:out value="${Return2.getReturn_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">刪除退貨紀錄</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-striped">
              <tbody>
               <thead>
                <tr>
                  <th>#退貨編號</th>
                  <th>產品編號</th>
                  <th>產品數量</th>
                  <th>退貨人姓名</th>
                  <th>承辦人員</th>
                  <th>總金額</th>
                  <th>退貨日期</th>
                </tr>
              </thead>
              <input type="hidden" name="return_id" value="${Return2.getReturn_id()}"/>
                <tr>
                  <td><c:out value="${Return2.getReturn_id()}"/></td>
                  <td><c:out value="${ReturnDetail2.getReturn_p_id()}"/></td>
                  <td><c:out value="${ReturnDetail2.getP_amount()}"/></td>
                  <td><c:out value="${Return2.getReturn_M_id()}"/></td>
                  <td><c:out value="${Return2.getReturn_A_id()}"/></td>
                  <td><c:out value="${Return2.getReturn_total()}"/></td>
                  <td><c:out value="${Return2.getReturn_date()}"/></td>
                </tr>
              </tbody>
            </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="submit"  name="type" value="deleteReturn" class="btn btn-primary">確認</button>
                </div>
              </div>
            </div>
          </div>
          </form>
          </c:if>
</c:forEach>
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
