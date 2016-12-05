<%@ page language = "java" import = "java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
 
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Accountlist</title>

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
        <% request.setCharacterEncoding("utf-8");%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="color: #252830;">
        <div class="row">
          <div class="col-lg-6">
            <h1 class="page-header">成員列表</h1>
          </div>
          <div class="col-lg-3">
              <div class="input-group"">
                <input type="text" class="form-control" placeholder="Search for..." style="border-radius: 40px;">
                <span class="input-group-btn" >
                  <button class="btn btn-default" type="button" style="border-radius: 40px;"><span class="glyphicon glyphicon-search" aria-hidden="true" ></span></button>
                </span>
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
             <div class="col-lg-3">
              <div class="input-group"">
                <button type="button" class="btn btn-default"  data-toggle="modal" data-target="#myAdd"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增成員</button>
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div>
          <ul class="nav nav-tabs" role="tablist" >
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" style="color: #252830;">會員</a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" style="color: #252830;">管理者</a></li>
          </ul>
<!-- Member -->
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="home">
            <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#id</th>
                  <th>帳號</th>
                  <th>姓名</th>
                  <th>電話</th>
                  <th>Email</th>
                  <th>地址</th>
                  <th>建立日期</th>
                  <th>更新日期</th>
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
              <c:forEach  items="${memberList}" var="member">
                <tr>
                  <td><c:out value="${member.getM_id()}"/></td>
                  <td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp&nbsp<c:out value="${member.getM_idName()}"/></td>
                  <td><c:out value="${member.getM_name()}"/></td>
                  <td><c:out value="${member.getM_phone()}"/></td>
                  <td><c:out value="${member.getM_email()}"/></td>
                  <td><c:out value="${member.getM_address()}"/></td>
                  <td><c:out value="${member.getM_create_date()}"/></td>
                  <td><c:out value="${member.getM_update_date()}"/></td>
                  <th><button type="button" class="btn btn-success"   data-toggle="modal" data-target="#myMModify<c:out value="${member.getM_id()}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span></button></th>
                  <th><button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#myMDelete<c:out value="${member.getM_id()}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></th>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
            </div>
<!-- Administrator -->
            <div role="tabpanel" class="tab-pane fade" id="profile">
            <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#id</th>
                  <th>帳號</th>
                  <th>姓名</th>
                  <th>所屬部門</th>
                  <th>電話</th>
                  <th>Email</th>
                  <th>地址</th>
                  <th>建立日期</th>
                  <th>更新日期</th>
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
              <c:forEach  items="${administratorList}" var="admin">
                <tr>
                  <td><c:out value="${admin.getA_id()}"/></td>
                  <td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp&nbsp<c:out value="${admin.getM_idName()}"/></td>
                  <td><c:out value="${admin.getM_name()}"/></td>
                 <%--  <%int categoryNum = request.getParameter(admin.getA_category()); %> --%>
                 <c:forEach  items="${A_categoryList}" var="A_category">
                  <script>
                /*   for(int i=0;i<<c:out value="${A_categoryList.size()}"/>;i++){ */
                	  
                		 /*  $(document).ready(function(){
                			  $('#<c:out value="${admin.getA_id()}"/>categoryName').append('<c:out value="${A_category.getC_name()}"/>');
                		  
                		  break; */
                	
                 /*  } */
                  </script>
                  </c:forEach>
                 <%--  <%
                  	String categoryName ;
                  	switch(categoryNum){
                		case 1 :
                			categoryName = "行政" ;
                		case 2 :
                			categoryName = "銷售" ;
                		case 3 :
                			categoryName = "倉儲" ;
                  	}
                  %> --%>
                  <td id="<c:out value="${admin.getA_id()}"/>categoryName"><c:out value="${admin.getA_category()}"/></td>
                  <td><c:out value="${admin.getM_phone()}"/></td>
                  <td><c:out value="${admin.getM_email()}"/></td>
                  <td><c:out value="${admin.getM_address()}"/></td>
                  <td><c:out value="${admin.getM_create_date()}"/></td>
                  <td><c:out value="${admin.getM_update_date()}"/></td>
                  <th><button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myAModify<c:out value="${admin.getA_id()}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></th>
                  <th><button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#myADelete<c:out value="${admin.getA_id()}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></th>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
            </div>
          </div>
        </div>
      </div>
    </div>
<!--Modify Member-->
    <c:forEach  items="${memberList}" var="member1">
    <div class="modal fade" id="myMModify<c:out value="${member1.getM_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">修改成員</h4>
          </div>
          <form class="form-horizontal" action="updateMember"  method="post">
          <div class="modal-body">
          <input type="hidden" name="M_id" value="<c:out value="${member1.getM_id()}"/>">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">帳號</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_idName" placeholder="帳號" value="<c:out value="${member1.getM_idName()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_name" placeholder="姓名" value="<c:out value="${member1.getM_name()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">密碼</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_pwd" id="inputPassword3" placeholder="密碼" value="<c:out value="${member1.getM_pwd()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">電話</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_phone" id="inputPassword3" placeholder="電話" value="<c:out value="${member1.getM_phone()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-8">
                  <input type="email" class="form-control" name="M_email" id="inputPassword3" placeholder="Email" value="<c:out value="${member1.getM_email()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_address" id="inputPassword3" placeholder="地址" value="<c:out value="${member1.getM_address()}"/>">
                </div>
              </div>
            
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" name="type" value="modifyMember" >Save changes
          </div>
        
        </form>
        </div>
      </div>
    </div>
    </c:forEach>
<!--Modify Administrator-->
    <c:forEach  items="${administratorList}" var="admin1">
    <div class="modal fade" id="myAModify<c:out value="${admin1.getA_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">修改管理者</h4>
          </div>
          <form class="form-horizontal" action="updateAdministrator"  method="post">
          <div class="modal-body">
            
              <input type="hidden" name="A_id" value="<c:out value="${admin1.getA_id()}"/>">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">帳號</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_idName" placeholder="帳號" value="<c:out value="${admin1.getM_idName()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_name" placeholder="姓名" value="<c:out value="${admin1.getM_name()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="A_category" placeholder="姓名" value="<c:out value="${admin1.getM_name()}"/>">
                </div>
              </div>
              <!-- <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">所屬部門</label>
                <div class="col-sm-8">
                <select class="form-control" name="A_category">
                  <option value="1">行政</option>
                  <option value="2" selected>銷售</option>
                  <option value="3">倉儲</option>
                </select>
                </div>
              </div> -->
              
              <!-- <script>
                $('#Administor_check').click(function() {
                    $("#Administor").show();
                });
                $('#Member_check').click(function() {
                    $("#Administor").hide();
                });
              </script> -->
              <!-- <div class="form-group" id="Administor" style="display: none;">
                <label for="inputEmail3" class="col-sm-2 control-label">所屬部門</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="所屬部門" value="行政">
                </div>
              </div> -->
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">密碼</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_pwd" id="inputPassword3" placeholder="密碼" value="<c:out value="${admin1.getM_pwd()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">電話</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_phone" id="inputPassword3" placeholder="電話" value="<c:out value="${admin1.getM_phone()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">E-mail</label>
                <div class="col-sm-8">
                  <input type="email" class="form-control" name="M_email" id="inputPassword3" placeholder="E-mail" value="<c:out value="${admin1.getM_email()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_address" id="inputPassword3" placeholder="地址" value="<c:out value="${admin1.getM_address()}"/>">
                </div>
              </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" name="type" value="modifyAdministrator" >Save changes
          </div>
        </form>
        </div>
      </div>
    </div>
    </c:forEach>
<!--Add A Person-->
    <div class="modal fade" id="myAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">新增成員</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal" method="post" action="AccountList">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">成員類別</label>
                <div class="col-sm-8">
                  <input type="radio" id="Member_check_add" name="m_category" checked="checked" value="Member"/>&nbsp&nbspMember<br><input id="Administor_check_add" type="radio" name="m_category" value="Administor"/>&nbsp&nbspAdministor
                </div>
              </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">帳號</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_idName" id="inputEmail3" placeholder="帳號" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_name" id="inputEmail3" placeholder="姓名" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">密碼</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_pwd" id="inputEmail3" placeholder="密碼" >
                </div>
              </div>
              <script>
                $('#Administor_check_add').click(function() {
                    $("#Administor_add").show();
                });
                $('#Member_check_add').click(function() {
                    $("#Administor_add").hide();
                });
              </script>
              <div class="form-group" id="Administor_add" style="display: none;">
                <label for="inputEmail3" class="col-sm-2 control-label">所屬部門</label>
                <!-- <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="所屬部門" >
                </div> -->
                <div class="col-sm-8">
                <select  name="A_category" class="form-control">
                  <option value="1">行政</option>
                  <option value="2">銷售</option>
                  <option value="3">倉儲</option>
                </select>
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">電話</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_phone" id="inputPassword3" placeholder="電話" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-8">
                  <input type="email" class="form-control" name="M_email" id="inputPassword3" placeholder="Email" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_address" id="inputPassword3" placeholder="地址" >
                </div>
              </div>
              <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" name="action_type" value="addMember">Save changes</input>
          </div>
            </form>
          </div>
          
        </div>
      </div>
    </div>
<!--Delete Member-->
<c:forEach  items="${memberList}" var="member2">
<form action="deleteMember" method="post">
    <div class="modal fade" id="myMDelete<c:out value="${member2.getM_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">刪除會員</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-striped">
              <tbody>
              <input type="hidden" name="M_id" value="${member2.getM_id()}">
                <tr>
                  <td><c:out value="${member2.getM_id()}"/></td>
                  <td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp&nbspe<c:out value="${member2.getM_idName()}"/></td>
                  <td>e<c:out value="${member2.getM_name()}"/></td>
                  <td>e<c:out value="${member2.getM_phone()}"/></td>
                  <td>e<c:out value="${member2.getM_email()}"/></td>
                  <td>e<c:out value="${member2.getM_address()}"/></td>
                  <td>e<c:out value="${member2.getM_create_date()}"/></td>
                </tr>
              </tbody>
            </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="submit" action="AccountList" name="type" value="deleteMember" class="btn btn-primary">確認</button>
                </div>
              </div>
            </div>
          </div>
          </form>
</c:forEach>
<!--Delete Administrator-->
<c:forEach  items="${administratorList}" var="admin2">
<form action="deleteAdministrator" method="post">
    <div class="modal fade" id="myADelete<c:out value="${admin2.getA_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">刪除管理者</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-striped">
              <tbody>
              <input type="hidden" name="A_id" value="${admin2.getA_id()}">
                <tr>
                  <td><c:out value="${admin2.getA_id()}"/></td>
                  <td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp&nbspe<c:out value="${admin2.getM_idName()}"/></td>
                  <td>e<c:out value="${admin2.getM_name()}"/></td>
                  <td>e<c:out value="${admin2.getA_category()}"/></td>
                  <td>e<c:out value="${admin2.getM_phone()}"/></td>
                  <td>e<c:out value="${admin2.getM_email()}"/></td>
                  <td>e<c:out value="${admin2.getM_address()}"/></td>
                  <td>e<c:out value="${admin2.getM_create_date()}"/></td>
                </tr>
              </tbody>
            </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="submit" action="AccountList" name="type" value="deleteAdministrator" class="btn btn-primary">確認</button>
                </div>
              </div>
            </div>
          </div>
          </form>
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
