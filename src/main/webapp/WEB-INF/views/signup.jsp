<%@ page language = "java" import = "java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!doctype html>
    
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="css/header_css.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">

</head>

<body class="align" style="margin-top:200px">
<% request.setCharacterEncoding("utf-8");%>
<%@include file="header.jsp"%>
    <div class="grid">
<form action="insertMember" method="post" class="form login" >
      

        <div class="form__field">
          <label for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">姓名</span></label>
          <input id="signup__username" type="text" name="M_name" class="form__input" placeholder="姓名" required>
        </div>

        <div class="form__field">
          <label for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">帳號</span></label>
          <input id="signup__Account" type="text" name="M_idName" class="form__input" placeholder="帳號" required>
           <script>
           if(<c:out value="${checkid}"/>==0){
	        alert("此帳號已被使用");
	        }
            </script>
        </div> 
           <div class="form__field">
          <label for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">Password</span></label>
          <input id="signup__password" type="password" name="M_pwd" class="form__input" placeholder="Password需英數混合" required>
            <script>
           if(<c:out value="${checkpwd}"/>==0){
	        alert("密碼需要英數混合");
	        }
            </script>
        </div> 
        
           <div class="form__field">
          <label for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">E-mail</span></label>
          <input id="signup__email" type="email" name="M_email" class="form__input" placeholder="E-mail" required>
        </div> 
        
          <div class="form__field">
          <label for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">Phone</span></label>
          <input id="signup__phone" type="text" name="M_phone" class="form__input" placeholder="phone" required>
       	<script>
           if(<c:out value="${checkphone}"/>==0){
	        alert("電話請重新輸入");
	        }
            </script>
        </div> 
         <div class="form__field">
          <label for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">Address</span></label>
          <input id="signup__address" type="text" name="M_address" class="form__input" placeholder="address" required>
        </div> 

        <div class="form__field">
          <input type="submit" class="btn btn-primary" name="type" value="Check" style="border-color:#ab425a"></input>
        </div>



    

    </div>
          
</form>
  
  


  
</body>
</html>
