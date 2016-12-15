<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Strawberry</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
 <link href="../css/main.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/header_css.css">
</head>

<body style="background-image: linear-gradient(to top, rgba(46, 49, 65, 0.7), rgba(46, 49, 65, 0.7)), url(../img/Macbook/Macbook.jpg)">
<b>
	<%@include file="header.jsp"%>
<!-- Page Wrapper -->
	<div id="page-wrapper">
<!-- Banner -->
		<section id="banner">
			<div class="inner">
				<div class="logo"><span class="icon fa-laptop"></span></div>
				<h2>Macbook</h2>
				<p></p>
			</div>
		</section>
<!-- Wrapper -->
		<section id="wrapper">
<!-- One -->
			<c:set var="count" value="${0}"/>
			<c:forEach  items="${ProductList}" var="product">
				<c:if test="${product.getP_category() == 3 && product.isSale()==1}">
				<c:set var="count" value="${count+1}"/>
				<c:if test="${count%2 == 1}">
            		<section id="one" class="wrapper spotlight style1">
						<div class="inner">
							<a href="/webapp/Product?id=${product.getP_id()}" class="image"><img src="<c:out value="${product.getP_image()}"/>" alt="" /></a>
							<div class="content">
								<h2 class="major"><c:out value="${product.getP_name()}"/></h2>
								<p><c:out value="${product.getP_describe()}"/></p>
								<h2><a href="/webapp/Product?id=${product.getP_id()}" class="special">購買產品</a></h2>
							</div>
						</div>
					</section>
        		</c:if>
        		<c:if test="${count%2 == 0}">
            		<section id="two" class="wrapper alt spotlight style2">
						<div class="inner">
							<a href="/webapp/Product?id=${product.getP_id()}" class="image"><img src="<c:out value="${product.getP_image()}"/>" alt="" /></a>
							<div class="content">
								<h2 class="major"><c:out value="${product.getP_name()}"/></h2>
								<p><c:out value="${product.getP_describe()}"/></p>
								<h2><a href="/webapp/Product?id=${product.getP_id()}" class="special">購買產品</a></h2>
							</div>
						</div>
					</section>
        		</c:if>
        	</c:if>
			</c:forEach>
<!-- Two -->
			
<!-- Three -->
			
<!-- Footer -->
		<section id="footer">
			<div class="inner">
				<ul class="copyright">
					<li>&copy; Untitled Inc. All rights reserved.</li>
				</ul>
			</div>
		</section>
	</div>

<!-- Scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</b>
</body>
</html>
