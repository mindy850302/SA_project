<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Order</title>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/mindy_style.css">
  <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <script type="text/javascript" src="js/myscript.js"></script>
  <link rel="stylesheet" type="text/css" href="css/header_css.css">
</head>
<body style="background-color: #434856;color: #181A19;">
    
 <%@include file="header.jsp"%>
 
  <div class="container">
    <div class="row" style="margin-top: 50px;">
    <div class="col-lg-1 col-md-1"></div>
    <div class="col-lg-10 col-md-10" style="border: 1px solid #c8c8c8;border-radius: 5px;box-shadow: 6px 0px 73px -6px rgba(0,0,0,0.75);background-color: #FFFFFF;color: #252830;">
      <h3>訂單編號：1345678</h3>
      <table class="table table-hover" style="margin-top: 20px;">
        <tr>
          <td><img style="width: 150px;" src="img/macpro1.jpg"></td>
          <td>1190</td>
          <td>MacBook Pro 13寸</td> 
          <td>NT.&nbsp23900</td>
          <td>數量&nbsp:&nbsp 1</td>
          <td>NT.&nbsp23900</td>
        </tr>
        <tr>
          <td><img style="width: 150px;" src="img/macpro2.jpg"></td>
          <td>1191</td>
          <td>MacBook Pro 13寸</td> 
          <td>NT.&nbsp43500</td>
          <td>數量&nbsp:&nbsp 2</td>
          <td>NT.&nbsp87000</td>
        </tr>
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
      <div class="row">
        <div class="col-lg-12">
          <table class="table table-striped" style="margin-top: 20px;">
        <tr>
          <td><img src="img/question.png">&nbsp&nbsp我要如何查詢配送進度？</td>
        </tr>
        <tr>
          <td>您於登入會員後，至『訂單管理』查詢配送狀況，訂單狀態：配送中-表示已通知廠商出貨；已配送-表示廠商已送交郵局或貨運寄送。</td>
        </tr>
        <tr>
          <td><img src="img/question.png">&nbsp&nbsp我可以指定送貨地點嗎？</td>
        </tr>
        <tr>
          <td>目前僅限台灣本島可正常配送，離島全區恕無法配送。</td>
        </tr>
        <tr>
          <td><img src="img/question.png">&nbsp&nbsp請問離島的範圍有哪些？</td>
        </tr>
        <tr>
          <td>您於登入會員後，至『訂單管理』查詢配送狀況，訂單狀態：配送中-表示已通知廠商出貨；已配送-表示廠商已送交郵局或貨運寄送。</td>
        </tr>
      </table>
        </div>
      </div>
    </div>
    </div>
    <div class="col-lg-1 col-md-1"></div>
    </div>
    <div class="row" style="margin-top: 50px;">
    <div class="col-lg-12 col-md-12" style="border: 1px solid #c8c8c8;border-radius: 5px;box-shadow: 6px 0px 73px -6px rgba(0,0,0,0.75);background-color: #FFFFFF;color: #252830;">
      <h3>&nbsp&nbsp瀏覽其他產品</h3>
      <hr>
      <center>
      <div class="row container">
      <div class="col-sm-4 col-md-3">
        <div class="thumbnail">
          <img  src="img/macpro1.jpg" alt="...">
          <div class="caption">
            <h3>13 吋 MacBook Pro</h3>
            <center>
            <h4 style="color: #777070;line-height: 25px;">2.0GHz 處理器 <br>256GB 儲存容量</h4>
            <p style="margin-top:30px;"><a href="#" class="btn btn-default" role="button">加入購物車</a></p>
            </center>
          </div>
        </div>
      </div>
      <div class="col-sm-4 col-md-3">
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
      <div class="col-sm-4 col-md-3">
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
      <div class="col-sm-4 col-md-3">
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
    </div>
    </center>
    <div class="row">
        <center>
          <p style="margin-top: 30px;"><a href="#" class="btn btn-default btn-lg" role="button">More&nbsp></a></p>
        </center>
    </div>
    </div>
    <div class="col-lg-2 col-md-1"></div>
    </div>
</body>
</html>