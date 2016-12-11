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
      		     <th></th>
		          <th>產品名稱</th> 
		          <th>產品價錢</th>
		          <th>數量</th>
		          <th>總額</th>
		          <th></th>
		         <th></th>
		         
		        </tr>
        <c:forEach items="${ShoppingDetailList}" var="shoppingdetail">
        
     		<c:if test="${shoppingdetail.getShopping_M_id() == my_id}">
     			<tr>
     			  <td><img style="width: 140px;" src="<c:out value="${shoppingdetail.getProduct().getP_image()}"></c:out>"></td>
		          <td><c:out value="${shoppingdetail.getProduct().getP_name()}"></c:out></td> 
		          <td>ＮＴ.<c:out value="${shoppingdetail.getProduct().getP_price()}"></c:out></td>
		          <td><c:out value="${shoppingdetail.getP_amount()}"></c:out></td>
		          <td>ＮＴ.<c:out value="${shoppingdetail.getP_total()}"></c:out></td>
		          <td><button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModify<c:out value="${shoppingdetail.getShopping_M_id()}"/>_<c:out value="${shoppingdetail.getShopping_p_id()}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td>
		          <form action="deleteShoppingDetail" method="post">
		          	<input type="hidden" name="shopping_M_id" value="<c:out value="${shoppingdetail.getShopping_M_id()}"></c:out>">
		          	<input type="hidden" name="shopping_p_id" value="<c:out value="${shoppingdetail.getShopping_p_id()}"></c:out>">
		          	<td><button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#myDelete<c:out value="${shoppingdetail.getShopping_M_id()}"/><c:out value="${shoppingdetail.getShopping_p_id()}"/>"><img src="img/garbage.png"></button></td>
		          </form>
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
        <c:if test="${total==0 }"><h4>購物車內尚無產品</h4></c:if>
          <c:if test="${total!=0 }"><h4>總額 : N T.<c:out value="${total}"></c:out></h4>
		         </div>
		          	<div class="row">
		        <h3 style="margin-left:50px;">填寫訂購資訊</h3>
		        <div class="col-lg-2 col-sm-0"></div>
		        <div class="col-lg-9 col-sm-12">
				<form action="makeOrder" method="post">
				<input type="hidden" name="order_M_id" value="<c:out value="${my_id}"></c:out>">
				<input type="hidden" name="total" value="<c:out value="${total}"></c:out>">
				
		          <div class="input-group" style="margin-top: 20px;">
		          <span class="input-group-addon" id="basic-addon1">收件人姓名 ：</span>
		          <input type="text" class="form-control" name="receiver_name" placeholder="請輸入收件人姓名" aria-describedby="basic-addon1" required>
		          </div>
		          <div class="input-group" style="margin-top: 20px;">
		          <span class="input-group-addon" id="basic-addon1">電話 ：</span>
		          <input type="text" class="form-control" name="receiver_phone" placeholder="請輸入電話" aria-describedby="basic-addon1" required>
		          </div>
		          <div class="input-group" style="margin-top: 20px;">
		          <span class="input-group-addon" id="basic-addon1">地址 ：</span>
		          <input type="text" class="form-control" name="receiver_address" placeholder="請輸入地址" aria-describedby="basic-addon1" required>
		        </div>
		        </div>
		        <div class="col-lg-2 col-sm-0"></div>
		      </div>
		      <div class="row" style="margin-top: 20px;">
		        <div class="col-lg-9 ">
		        </div>
		        <div class="col-lg-3 ">
		          <button type="submit" class="btn btn-default btn-lg" style="padding:10px 30px;margin-bottom: 40px;" data-toggle="modal" data-target="#myModal">結帳</button>
		        </div>
		        </form>
		      </div>
          </c:if>
        </div>
      </div>
      <hr>
      
    </div>
</div>

    <div class="col-lg-1 col-md-1"></div>
    </div>
    <div class="row" style="margin-top: 50px;">
    <div class="col-lg-0 col-md-1"></div>
    <div class="col-lg-12 col-md-10" style="border: 1px solid #c8c8c8;border-radius: 5px;box-shadow: 6px 0px 73px -6px rgba(0,0,0,0.75);background-color: #FFFFFF;color: #252830;">
      <h3>建議產品</h3>
      <hr>
      <div class="row">
      <c:forEach items="${newProductList}" var="newproduct">
      <div class="col-sm-3 col-md-3">
        <div class="thumbnail">
          <img  src="<c:out value="${newproduct.getP_image()}"></c:out>" alt="...">
          <div class="caption">
            
            <center>
            <h3><c:out value="${newproduct.getP_name()}"></c:out></h3>
            <p style="margin-top: 30px;"><a href="Product?id=${newproduct.getP_id()}" class="btn btn-default" role="button">了解更多</a></p>
            </center>
          </div>
        </div>
      </div>
      </c:forEach>
    </div>
    <div class="row">
        <center>
          <p style="margin-top: 30px;"><a href="Product/iPad" class="btn btn-lg btn-default" role="button">More&nbsp></a></p>
        </center>
    </div>
    </div>
    <div class="col-lg-0 col-md-1"></div>
    </div>
      <c:forEach  items="${ShoppingDetailList}" var="shoppingdetail1">
    
     <!-- Modal -->
    <div class="modal fade" id="myModify<c:out value="${shoppingdetail1.getShopping_M_id()}"/>_<c:out value="${shoppingdetail1.getShopping_p_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title" id="myModalLabel">修改數量</h4>

          </div>
          <form class="form-horizontal" action="updateShoppingCart"  method="post">
          <div class="modal-body">
              <input type="hidden" name="shopping_M_id" value="<c:out value="${shoppingdetail1.getShopping_M_id()}"/>"/>
              <input type="hidden" name="shopping_p_id" value="<c:out value="${shoppingdetail1.getShopping_p_id()}"/>"/>
              <input type="hidden" name="p_price" value="<c:out value="${shoppingdetail1.getProduct().getP_price()}"/>"/>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-3 control-label">產品名稱：</label>
	                <div class="col-sm-5">
	                	<label for="inputEmail3" class="col-sm-12 control-label" ><c:out value="${shoppingdetail1.getProduct().getP_name()}"/></label>
					</div>			
					<div class="col-sm-3">				   
                  			<input type="number" class="form-control" name="p_amount" placeholder="數量" value="<c:out value="${shoppingdetail1.getP_amount()}"/>">      	
					</div>
             </div>
          
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" name="type" value="updateShoppingCart" >
          </div>
        
        </form>
        </div>
      </div>
    </div>
   </div>
    </c:forEach>
 
</body>
</html>