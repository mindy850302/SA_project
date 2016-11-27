<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>index</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <link rel="stylesheet" type="text/css" href="css/ihover.css">
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="css/header_css.css">
</head>

<body>
<% request.setCharacterEncoding("utf-8");%>

<%@include file="header.jsp"%>

<!--
<div class="container">
  
<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner" style="margin-bottom:0px; border-bottom:0px; background-color: rgba(252, 120, 140,0.65)">
<div class="navbar-header">
<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  -->
<!--
<div style="margin:45px auto 45px auto; background-color:#333">
<center>
<h1>
Pineapple
</h1>
<p>
by pineapple
</p>
</center>
</div>
-->
<!--
              
                      <a href="about.jsp" c class="navbar-brand"><img src="appleimg/papple.jpg" width="40%" ></img></a>
                   </div>

 
  <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation" >
 
                  <ul class="nav navbar-nav navbar-brand" style="margin:0.1px 10px 20px 50px" >
                  
                    <li>
                      <a href="about.jsp">About us</a>
                    </li>
                    <li>
                      <a href="newProduct.jsp">iPhone</a>
                    </li>
                     <li>
                      <a href="productList.jsp">ipad</a>
                    </li>
                     <li>
                      <a href="productList.jsp">MacBook</a>
                    </li>
                   
                  </ul>
                   <ul class="nav navbar-nav navbar-right">
                    <li><a href="signup.jsp">Sign up </a></li>
                     <li><a href="login.jsp">Log in </a></li>
                 
</nav> 


</div>
</div>

                 </header>
-->                 

                 <div class="row" style="margin-top:90px; background-color:#272727; border-bottom:4px solid rgb(246, 126, 144)">
                 <div class="col-xs-2 col-md-2" ></div>
 <div class="col-xs-8 col-md-8" >
                 
 <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
   <center>
  <div class="carousel-inner" role="listbox" >
 
    <div class="item active">
      <img src="appleimg/iphone1.jpg" width="100%" alt="...">
      <div class="carousel-caption">
        
      </div>
    </div>
    <div class="item">
      <img src="appleimg/macbook1.jpg" alt="...">
      <div class="carousel-caption">
        
      </div>
    </div>
   <div class="item">
      <img src="appleimg/imac1.jpg" alt="...">
      <div class="carousel-caption">
         <h3 style="color:#333">imac</h3>
    <p>new product</p>
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
 <div class="col-xs-2 col-md-2" ></div>
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
        <div class="img"><img src="appleimg/iphone1.jpg" alt="img"></div>
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
        <div class="img"><img src="appleimg/imac1.jpg" alt="img"></div>
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
        <div class="img"><img src="appleimg/macbook1.jpg" alt="img"></div>
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
