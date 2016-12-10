<%@ page contentType="text/html;charset=utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Log in</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="css/header_css.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body class="align" style="margin-top:200px">
<% request.setCharacterEncoding("utf-8");%>
<%@include file="header.jsp"%>
<a href="login"> ${loginsession.username}</a>
    <div class="grid">

      <form action="login" method="post" class="form login">

        <div class="form__field">
          <label for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Username</span></label>
          <input id="login__username" type="text" name="M_idName" class="form__input" placeholder="Username" required>
        </div>

        <div class="form__field">
          <label for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">Password</span></label>
          <input id="login__password" type="password" name="M_pwd" class="form__input" placeholder="Password" required>
        </div>

        <div class="form__field">
          <input type="submit"  value="Sign In"  >
          
        </div>
        
        <script>
        function loginFunction(){
        	alert("login success!!");
        }
  
        </script>

      </form>

      <p class="text--center">Not a member? <a href="/webapp/signup">Sign up now</a> </p>
      <center>
      	<a href="/webapp/loginAdministrator">I am Administrator:-)</a>
      <a href="/webapp/loginAdministrator">I am Administrator</a>
      </center>


    </div>
    
    

  </body>

</html>
  
</body>
</html>

