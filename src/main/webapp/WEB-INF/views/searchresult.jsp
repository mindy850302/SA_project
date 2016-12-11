<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Order Record</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="css/header_css.css">

</head>

<body>
<% request.setCharacterEncoding("utf-8");%>
<%@include file="header.jsp"%>
<html lang="en">

  <head>
    <meta charset="utf-8">

    <title>search result</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
  </head>

  <body class="align" style="margin-top:160px; ">

    <div class="col-lg-2"></div>
    <div class="col-lg-8">
      <div class="form login">
        <table class="table">
          <tr style="background-color: rgba(37, 30, 30, 0.22)"> 
            <td style="border-top: rgba(37, 30, 30, 0.22)">產品名稱</td>
            <td style="border-top: rgba(37, 30, 30, 0.22)">產品描述</td>
            <td style="border-top: rgba(37, 30, 30, 0.22)">總金額</td>
            <td style="border-top: rgba(37, 30, 30, 0.22)">目前存貨</td>
            <td style="border-top: rgba(37, 30, 30, 0.22)">上架日期</td>
            <td style="border-top: rgba(37, 30, 30, 0.22)">產品樣式</td>
          
          </tr>
          <c:forEach  items="${ProductList}" var="search">
         
          <tr style="background-color:#5e788e">
            <td><c:out value="${search.getP_name()}"/></td>
            <td><c:out value="${search.getP_describe()}"/></td>
            <td><c:out value="${search.getP_price()}"/></td>
            <td><c:out value="${search.getP_inventory()}"/></td>
            <td><c:out value="${search.getP_onsale_date()}"/></td>
            <td><img src="<c:out value="${search.getP_image()}" />" alt="..." style="width:300px"></td>
          </tr>
          
          </c:forEach>
        </table>
     
      </div>
    </div>

    <svg xmlns="http://www.w3.org/2000/svg" class="icons"><symbol id="arrow-right" viewBox="0 0 1792 1792"><path d="M1600 960q0 54-37 91l-651 651q-39 37-91 37-51 0-90-37l-75-75q-38-38-38-91t38-91l293-293H245q-52 0-84.5-37.5T128 1024V896q0-53 32.5-90.5T245 768h704L656 474q-38-36-38-90t38-90l75-75q38-38 90-38 53 0 91 38l651 651q37 35 37 90z"/></symbol><symbol id="lock" viewBox="0 0 1792 1792"><path d="M640 768h512V576q0-106-75-181t-181-75-181 75-75 181v192zm832 96v576q0 40-28 68t-68 28H416q-40 0-68-28t-28-68V864q0-40 28-68t68-28h32V576q0-184 132-316t316-132 316 132 132 316v192h32q40 0 68 28t28 68z"/></symbol><symbol id="user" viewBox="0 0 1792 1792"><path d="M1600 1405q0 120-73 189.5t-194 69.5H459q-121 0-194-69.5T192 1405q0-53 3.5-103.5t14-109T236 1084t43-97.5 62-81 85.5-53.5T538 832q9 0 42 21.5t74.5 48 108 48T896 971t133.5-21.5 108-48 74.5-48 42-21.5q61 0 111.5 20t85.5 53.5 62 81 43 97.5 26.5 108.5 14 109 3.5 103.5zm-320-893q0 159-112.5 271.5T896 896 624.5 783.5 512 512t112.5-271.5T896 128t271.5 112.5T1280 512z"/></symbol></svg>

  </body>

</html>
  
</body>
</html>