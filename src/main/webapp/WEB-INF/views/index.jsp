<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<title>Strawberry</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/ihover.css">
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="css/header_css.css">
</head>

<body>
<% request.setCharacterEncoding("utf-8");%>

<%@include file="hearderLogin.jsp"%>
<div class="modal fade" id="myLogout" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Logout</h4>
      </div>
      <div class="modal-body">
       確定登出？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<div class="row" style="margin-top:90px; background-color:#2C3338; border-bottom:4px solid #2C3338">
 <div class="col-xs-12 col-md-12" >
                 
 <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="width:100%;">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
   <center>
  <div class="carousel-inner" role="listbox" style="background-color:#F6F6F6;margin-top:-90px;">
 
    <div class="item active">
      <img src="http://store.storeimages.cdn-apple.com/8749/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone6s/gallery2/iphone6s-gallery2-2015?wid=4000&hei=3072&fmt=jpeg&qlt=80&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=2Vkkj2" style="height:800px;widh:100%;" alt="...">
      <div class="carousel-caption">
        
      </div>
    </div>
    <div class="item">
      <img src="http://images.apple.com/tw/ipad-mini-4/overview/images/apps_large_2x.jpg" alt="..." style="height:800px;">
   
      <div class="carousel-caption">
        
      </div>
    </div>
   <div class="item">
   
      <img src="http://images.apple.com/v/macbook-pro/l/images/overview/performance_large_2x.jpg" alt="..." style="height:800px;">
      <div class="carousel-caption">
      </div>
    </div>
  </div>
  </div>
 </center>
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
 
</div>
<!-- 輪播 -->

<!-- Left to right-->
<div class="row" style="margin-top:100px ">
 <div class="col-xs-3 col-md-3" ></div>
 <div class="col-xs-5 col-md-5" >
 <h2>Welcome to Strawberry!</h2>
 </div>
 <div class="col-xs-3 col-md-3" >
 <form class="navbar-form navbar-right" role="search">
   <span class="glyphicon glyphicon-search"></span>
                         <div class="form-group">
                          <input type="text" class="form-control" placeholder="Search you like">
                         </div>
                             <button type="submit" class="btn btn-default">Submit</button>
                  </form>
                  </div>
 <div class="col-xs-1 col-md-1" ></div>
</div>
<center>
<div class="row" >

 <div class="col-xs-1 col-md-1"></div>
<div  class="col-xs-10 col-md-10" style="background-color:#333; height:20px"></div>
 <div class="col-xs-1 col-md-1"></div>
 </div>
 <div class="row" style="margin:40px auto 20px auto">


  <div class="col-xs-4 col-md-4" >
 
    <!-- normal -->
    <p align="center"  style="font-size: 30px; color:#333;margin-left:100px"><B><span class="glyphicon glyphicon-off"></span> New</B></p>
    <div class="ih-item square effect13 left_to_right" style="margin-left:100px" ><a href="#">
        <div class="img"><img src="http://store.storeimages.cdn-apple.com/8749/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone6s/gallery2/iphone6s-gallery2-2015?wid=4000&hei=3072&fmt=jpeg&qlt=80&op_sharpen=0&resMode=bicub&op_usm=0.5,0.5,0,0&iccEmbed=0&layer=comp&.v=2Vkkj2" alt="img"></div>
        <div class="info">
          <h3>iphone7</h3>
          <p>Learn more >></p>
        </div></a></div>
    <!-- end normal -->
 
  </div>
  <div class="col-xs-4 col-md-4">
 <p align="center"  style="font-size: 30px; color:#333; " ><B><span class="glyphicon glyphicon-off"></span> Hot!</B></p>
    <!-- colored -->
    
    <div class="ih-item square colored effect13 right_to_left" ><a href="#">
        <div class="img"><img src="http://images.apple.com/v/apple-pencil/b/images/pencil/ipad_pro_large_2x.jpg" alt="img"></div>
        <div class="info">
          <h3>iMac</h3>
          <p>Learn more >></p>
        </div></a></div>
    <!-- end colored -->
 
  </div>

<div class="col-xs-4 col-md-4">
 <p align="center"  style="font-size: 30px; color:#333; margin-right:100px"><B><span class="glyphicon glyphicon-off"></span> Hot!</B></p>
    <!-- colored -->
    <div class="ih-item square effect13 top_to_bottom" style="margin-right:100px"><a href="#">
        <div class="img"><img src="http://images.apple.com/v/macbook-pro/l/images/overview/performance_large_2x.jpg" alt="img"></div>
        <div class="info">
          <h3>MacBook</h3>
          <p>Learn more >></p>
        </div></a></div>
    <!-- end normal -->
 
  </div>
  
  
 </center>
 
</div>

<!-- end Left to right-->
 
 

 

 

</body>
</html>
