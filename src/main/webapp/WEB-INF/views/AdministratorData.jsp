
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Strawberry</title>

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
    <script type="text/javascript" src="js/myscriptBackground.js"></script>

    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <%@include file="headerBackground.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="color: #252830;">
        <div class="row">
          <div class="col-lg-8">
            <h1 class="page-header">個人資料</h1>
          </div>
             <div class="col-lg-1">
              <div class="input-group">
                <button type="button" class="btn btn-default"  data-toggle="modal" data-target="#modifyData<c:out value="${Administrator.getA_id()}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改</button>
              </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-3">
        </div>
        
        <div class="row">
            <div class="col-lg-9">
                <div class="grid">
				    <form action="AdministratorData" method="get"></form>
				      <div class="form login">
				        <table class="table table-striped">
				          <tr style="background-color: #f9f9f9">
				
				            <td>帳號</td>
				            <td><c:out value="${Administrator.getM_idName()}"></c:out></td>
				          </tr>
				          <tr>
				            <td>姓名</td>
				            <td><c:out value="${Administrator.getM_name()}"></c:out></td>
				          </tr>
				          <tr style="background-color:#f9f9f9">
				            <td>密碼</td>
				            <td><c:out value="${Administrator.getM_pwd()}"></c:out></td>
				          </tr>
				          <tr>
				            <td>部門</td>
				            <td><c:out value="${Administrator.getA_category1().getC_name()}"></c:out></td>
				          </tr>
				          <tr style="background-color:#f9f9f9">
				            <td>電話</td>
				            <td><c:out value="${Administrator.getM_phone()}"></c:out></td>
				          </tr>
				          <tr>
				            <td>地址</td>
				            <td><c:out value="${Administrator.getM_address()}"></c:out></td>
				          </tr>
				          <tr style="background-color:#f9f9f9">
				            <td>E-mail</td>
				            <td><c:out value="${Administrator.getM_email()}"></c:out></td>
				          </tr>
				          <tr>
				            <td>註冊日期</td>
				            <td><c:out value="${Administrator.getM_create_date()}"></c:out></td>
				          </tr>
				          <tr style="background-color: #f9f9f9">
				            <td>更新日期</td>
				            <td><c:out value="${Administrator.getM_update_date()}"></c:out></td>
				          </tr>
				        </table>
					</div>
				  </div>
				</div>
            	<div class="col-lg-3"></div>
            </div>
          
<!-- Modify -->
    <div class="modal fade" id="modifyData<c:out value="${Administrator.getA_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">修改管理者</h4>
          </div>
          <form class="form-horizontal" action="updateAdministratorData"  method="post">
          <div class="modal-body">
            
              <input type="hidden" name="A_id" value="<c:out value="${Administrator.getA_id()}"/>">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">帳號</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_idName" placeholder="帳號" required="required" value="<c:out value="${Administrator.getM_idName()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_name" placeholder="姓名" required="required" value="<c:out value="${Administrator.getM_name()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">部門</label>
                <div class="col-sm-8">
                  
                  <select name="A_category" class="form-control">
	                     <c:forEach items="${A_categoryList}" var="A_category2">
	                     <c:if test="${Administrator.getA_category()==A_category2.getC_id()}">
	                     <script>
	                     $(document).ready(function(){       
	                      $('#A_category<c:out value="${Administrator.getA_id()}"/><c:out value="${A_category2.getC_id()}"/>').attr("selected","ture");
	                     });
	                     </script>
	                     </c:if>
	        					<option id="A_category<c:out value="${Administrator.getA_id()}"/><c:out value="${A_category2.getC_id()}"/>" value="<c:out value="${A_category2.getC_id()}"/>"><c:out value="${A_category2.getC_name()}"/></option>
	        			</c:forEach>
					   </select>
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">密碼</label>
                <div class="col-sm-8">
                  <input type="password" class="form-control" name="M_pwd" required="required" id="inputPassword3" placeholder="密碼" value="<c:out value="${Administrator.getM_pwd()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">電話</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" name="M_phone"required="required" id="inputPassword3" placeholder="電話" value="<c:out value="${Administrator.getM_phone()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">E-mail</label>
                <div class="col-sm-8">
                  <input type="email" class="form-control" name="M_email" required="required" id="inputPassword3" placeholder="E-mail" value="<c:out value="${Administrator.getM_email()}"/>">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-8"> 
                  <input type="text" class="form-control" name="M_address" required="required" id="inputPassword3" placeholder="地址" value="<c:out value="${Administrator.getM_address()}"/>">
                </div>
              </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" name="type" value="modifyAdministratorData" >
          </div>
        </form>
        </div>
      </div>
    </div>
    
    <div class="modal fade" tabindex="-1" role="dialog" id="modifyData<c:out value="${Administrator.getA_id()}"/>">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">修改資料</h4>
                        </div>
                        <form class="form-horizontal" action="updateAdministratorData" method="post">
                        <div class="modal-body">
                        
                          	<input type="hidden" name="A_id" value="<c:out value="${Administrator.getA_id()}"/>">
                            <div class="form-group">
                              <label class="col-sm-2 control-label">帳號</label>
                              <div class="col-sm-9">
                              <input type="hidden" name="M_idName" value="<c:out value="${Administrator.getM_idName()}"/>">
                                <p class="form-control-static" style="margin-top: 0rem;color:#606468"><c:out value="${Administrator.getM_idName()}"></c:out></p>
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyName" class="col-sm-2 control-label">姓名</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_name" placeholder="Name" value="<c:out value="${Administrator.getM_name()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyPassword" class="col-sm-2 control-label">密碼</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_pwd" placeholder="Password" value="<c:out value="${Administrator.getM_pwd()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyPassword" class="col-sm-2 control-label">部門</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="A_category" placeholder="Category" value="<c:out value="${Administrator.getA_category()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyPhone" class="col-sm-2 control-label">電話</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_phone" placeholder="Phone Number" value="<c:out value="${Administrator.getM_phone()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyAddress" class="col-sm-2 control-label">地址</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_address" placeholder="Address" value="<c:out value="${Administrator.getM_address()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyEmail" class="col-sm-2 control-label">信箱</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_email" placeholder="E-mail" value="<c:out value="${Administrator.getM_email()}"/>">
                              </div>
                            </div>
                          
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <input type="submit" name="type" class="btn btn-primary" style="background-color: rgb(113, 197, 170);border-color: rgb(113, 197, 170)" value="modifyAdministratorData">
                        </div>
                        </form><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            
            
            </div>
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
