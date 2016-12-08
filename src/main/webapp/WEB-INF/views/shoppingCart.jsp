<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ShoppingCart</title>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/mindy_style.css">
  <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <script type="text/javascript" src="js/myscript.js"></script>
  <link rel="stylesheet" type="text/css" href="css/header_css.css">
</head>
<body style="background-color: #434856;color: #181A19;">
  <%@include file="header.jsp"%>

  <div class="container" style="margin-top:80px;">
    <div class="row" style="margin-top: 50px;">
    <div class="col-lg-12 col-md-10" style="border: 1px solid #c8c8c8;border-radius: 5px;box-shadow: 6px 0px 73px -6px rgba(0,0,0,0.75);background-color: #FFFFFF;color: #252830;">
      <h3>你購物袋中的項目</h3>
      <table class="table table-hover" style="margin-top: 20px;">
      			<tr>
      			<center>
     			  <th></th>
		          <th>產品名稱</th> 
		          <th>產品價錢</th>
		          <th>數量</th>
		          <th>總額</th>
		         </center>
		        </tr>
        <c:forEach items="${ShoppingDetailList}" var="shoppingdetail">
     		<c:if test="${shoppingdetail.getShopping_M_id() == my_id}">
     			<tr>
     			  <td><img style="width: 140px;" src="<c:out value="${shoppingdetail.getProduct().getP_image()}"></c:out>"></td>
		          <td><c:out value="${shoppingdetail.getProduct().getP_name()}"></c:out></td> 
		          <td>ＮＴ.<c:out value="${shoppingdetail.getProduct().getP_price()}"></c:out></td>
		          <td><c:out value="${shoppingdetail.getP_amount()}"></c:out></td>
		          <td>ＮＴ.<c:out value="${shoppingdetail.getP_total()}"></c:out></td>
		          <td><button type="button" class="btn btn-danger"><img src="img/garbage.png"></button></td>
		        </tr>
     		</c:if>
     	</c:forEach>
      </table>
      <hr>
      <div class="row">
        <div class="col-lg-8 ">
          <h6>欲使用銀行轉帳付款，請致電 0800-020-021。 </h6>
        </div>
        <div class="col-lg-4 ">
          <h4>總金額 ： NT . 10900</h4>
        </div>
      </div>
      <hr>
      <div class="row">
        <h3>&nbsp&nbsp填寫訂購資訊</h3>
        <div class="col-lg-1 col-sm-0"></div>
        <div class="col-lg-9 col-sm-12">

          <div class="input-group" style="margin-top: 20px;">
          <span class="input-group-addon" id="basic-addon1">收件人姓名 ：</span>
          <input type="text" class="form-control" placeholder="請輸入收件人姓名" aria-describedby="basic-addon1">
          </div>
          <div class="input-group" style="margin-top: 20px;">
          <span class="input-group-addon" id="basic-addon1">電話 ：</span>
          <input type="text" class="form-control" placeholder="請輸入電話" aria-describedby="basic-addon1">
          </div>
          <div class="input-group" style="margin-top: 20px;">
          <span class="input-group-addon" id="basic-addon1">地址 ：</span>
          <input type="text" class="form-control" placeholder="請輸入地址" aria-describedby="basic-addon1">
        </div>
        </div>
        <div class="col-lg-2 col-sm-0"></div>
      </div>
      <div class="row" style="margin-top: 20px;">
        <div class="col-lg-9 ">
        </div>
        <div class="col-lg-3 ">
          <button type="button" class="btn btn-default btn-lg" style="padding:10px 30px;margin-bottom: 40px;" data-toggle="modal" data-target="#myModal">結帳</button>
        </div>
      </div>
    </div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" style="background-color: #252830;">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel" style="color: #FFFFFF;"><img src="img/shopping-cart_check.png"> 確定結帳</h4>
      </div>
      <div class="modal-body">
      <table class="table" style="margin-top: 20px;color:#181A19;font-size: 18px;line-height: 40px;">
     	
      </table>
      <div class="row">
        <div class="col-lg-8 ">
        </div>
        <div class="col-lg-4 " style="color:#181A19;font-size: 18px;line-height: 40px;">
          <h4>總金額 ： NT . 10900</h4>
        </div>
      </div>
      <hr>
      <div class="row">
      <div class="col-lg-0 col-md-0"></div>
        <div class="col-lg-10 ">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-4 control-label">收件人姓名</label>
                <div class="col-sm-8">
                  <p class="form-control-static">許甄珉</p>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">電話</label>
                <div class="col-sm-8">
                  <p class="form-control-static">0960730847</p>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">地址</label>
                <div class="col-sm-8">
                  <p class="form-control-static">台北市中山區大直街50號3樓</p>
                </div>
              </div>
            </form>
        </div>
      <div class="col-lg-2 col-md-0"></div>
      </div>
      </div>
      <div class="modal-footer" style="color: #252830;">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="order.jsp"><button type="button" class="btn btn-default">確定</button></a>
      </div>
    </div>
  </div>
</div>
    <div class="col-lg-1 col-md-1"></div>
    </div>
    <div class="row" style="margin-top: 50px;">
    <div class="col-lg-2 col-md-1"></div>
    <div class="col-lg-8 col-md-10" style="border: 1px solid #c8c8c8;border-radius: 5px;box-shadow: 6px 0px 73px -6px rgba(0,0,0,0.75);background-color: #FFFFFF;color: #252830;">
      <h3>建議產品</h3>
      <hr>
      <div class="row">
      <div class="col-sm-1 col-md-"></div>
      <div class="col-sm-5 col-md-5">
        <div class="thumbnail">
          <img  src="img/macpro1.jpg" alt="...">
          <div class="caption">
            <h3>13 吋 MacBook Pro</h3>
            <center>
            <h4 style="color: #777070;line-height: 25px;">2.0GHz 處理器 <br>256GB 儲存容量</h4>
            <p style="margin-top: 30px;"><a href="#" class="btn btn-default" role="button">加入購物車</a></p>
            </center>
          </div>
        </div>
      </div>
      <div class="col-sm-5 col-md-5">
        <div class="thumbnail">
          <img src="img/macpro2.jpg" alt="...">
          <div class="caption">
            <h3>13 吋 MacBook Pro</h3>
            <center>
            <h4 style="color: #777070;line-height: 25px;">Touch Bar 和 Touch ID<br>2.9GHz 處理器 <br>256GB 儲存容量</h4>
            <p style="margin-top: 30px;"><a href="#" class="btn btn-default" role="button">加入購物車</a></p>
            </center>
          </div>
        </div>
      </div>
      <div class="col-sm-1 col-md-"></div>
    </div>
    <div class="row">
        <center>
          <p style="margin-top: 30px;"><a href="#" class="btn btn-lg btn-default" role="button">More&nbsp></a></p>
        </center>
    </div>
    </div>
    <div class="col-lg-2 col-md-1"></div>
    </div>
  </div>
</body>
</html>