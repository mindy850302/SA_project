<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>OrderDetail</title>
    <link rel="icon" href="../../favicon.ico">

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
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="color: #252830;">
        <div class="row">
          <div class="col-lg-9">
            <h1 class="page-header">訂單明細</h1>
          </div>
          <div class="col-lg-3">
              <div class="input-group">
               <!--  <input type="text" class="form-control" placeholder="訂單查詢" style="border-radius: 40px;">
                <span class="input-group-btn" >
                  <button class="btn btn-default" type="button" style="border-radius: 40px;"><span class="glyphicon glyphicon-search" aria-hidden="true" ></span></button>
                </span> -->
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div>
          <ul class="nav nav-tabs" role="tablist" >
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" style="color: #252830;">訂單</a></li>
          </ul>
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="home">
            <div class="table-responsive">
            <table class="table table-striped table-show-product">
              <thead>
                <tr>
                  <th>#訂單編號</th>
                  <th>訂購人姓名</th>
                  <th>收件人姓名</th>
                  <th>運送地址</th>
                  <th>收件人電話</th>
                  <th>總金額</th>
                  <th>出貨日期</th>
                  <th>產品明細</th>
                </tr>
              </thead>
            <c:forEach  items="${OrderList}" var="order">
              <tbody>
                <tr>
                  <td><c:out value="${order.getOrder_id()}"/></td>
                  <td><c:out value="${order.getMember().getM_name()}"/></td>
                  <td><c:out value="${order.getReceiver_name()}"/></td>
		          <td><c:out value="${order.getReceiver_address()}"/></td>
		          <td><c:out value="${order.getReceiver_phone()}"/></td>
                  <td><c:out value="${order.getTotal()}"/></td>
                  <td><c:out value="${order.getO_date()}"/></td>
                  <td><button type="button" class="btn btn-success" data-toggle="modal" data-target="#OrderDetail<c:out value="${order.getOrder_id()}"/>" style="background-color: #303841;border-color: #101010">明細</button></td>
                  <td><button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModifyProduct<c:out value="${product.getP_id()}" />">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					  </button>
				  </td>
				  <td><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#OrderRecordDelete<c:out value="${order.getOrder_id()}" />">
					      <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					  </button>
				  </td>
                </tr>
              </tbody>
            </c:forEach>
            </table>
          </div>
            </div>
    </div>
    <!-- Detail -->
    <c:forEach  items="${OrderList}" var="order1">
        	<div class="modal fade" tabindex="-1" role="dialog" id="OrderDetail<c:out value="${order1.getOrder_id()}"/>">
                <div class="modal-dialog" role="document">
                    <div class="modal-content" style="color:#606468">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">訂單明細</h4>
                        </div>
                        <div class="modal-body">
                          <form class="form-horizontal" role="form">
                            <table class="table">
                              <tr>
                                <td>產品編號</td>
                                <td>產品名稱</td>
                                <td>產品價格</td>
                                <td>產品數量</td>
                                <td>產品金額</td>
                              </tr>
                          	  <c:forEach items="${OrderDetailList}" var="orderDetail">
                          		<c:if test="${orderDetail.getOrderDetail_id() == order1.getOrder_id() }">
                              		<tr>
                                		<td><c:out value="${orderDetail.getOrder_p_id()}"/></td>
                                		<td><c:out value="${orderDetail.getProduct().getP_name()}"/></td>
                                		<td><c:out value="${orderDetail.getProduct().getP_price()}"/></td>
                                		<td><c:out value="${orderDetail.getP_amount()}"/></td>
                                		<td><c:out value="${orderDetail.getP_total()}"/></td>
                              		</tr>
                          		</c:if>
                          	</c:forEach>
                          </table>
                        </form>
                      </div>
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
      		</div>
      </c:forEach>
    <!-- Modify -->
    <div class="modal fade" id="myModifyProduct" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">修改產品</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">產品圖片</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="產品圖片" value="macpro1.png">
                </div>
              </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">產品名稱</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="產品名稱" value="MacBook Pro 13寸">
                </div>
              </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">產品描述</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="產品描述" value="2.0GHz 處理器 , 256GB 儲存容量">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">價錢</label>
                <div class="col-sm-8">
                  <input type="number" class="form-control" id="inputEmail3" placeholder="價錢" value="43500">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">存貨數量</label>
                <div class="col-sm-8">
                  <input type="number" class="form-control" id="inputEmail3" placeholder="存貨數量" value="674">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">產品狀態</label>
                <div class="col-sm-8">
                  <input type="radio" id="Member_check_add" name="product_status" checked="checked" value="upSale"/>&nbsp&nbsp上架<br><input id="Administor_check_add" type="radio" name="product_status" value="removeSale"/>&nbsp&nbsp下架
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>
    <!-- Delete -->
    <c:forEach  items="${OrderList}" var="order3">
    <div class="modal fade" id="OrderRecordDelete<c:out value="${order1.getOrder_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">刪除產品</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-striped table-show-product-delete">
              <tbody>
                <tr>
                  <tr>
                  <td><img class="product_img_list"  src="img/macpro1.jpg"></td>
                  <td>1789</td>
                  <td>MacBook Pro 13寸</td>
                  <td>2.0GHz 處理器 , 256GB 儲存容量</td>
                  <td>43500</td>
                  <td>450</td>
                  <td>2016/11/02</td>
                  <td>2016/11/02</td>
                  <td>2016/11/02</td>
                </tr>
                </tr>
              </tbody>
            </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary">確認</button>
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
