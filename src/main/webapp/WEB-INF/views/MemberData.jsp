<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Member Data</title>
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

    <title>Login</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
  </head>

  <body class="align" style="margin-top:160px; ">

    <div class="grid">
    <form action="MemberData" method="get"></form>
      <div class="form login">
        <table class="table table-striped">

        
          <tr style="background-color: #D2E9FF;color:#5B5B5B">

          <tr style="background-color: #D2E9FF;color:#5B5B5B">

            <td>帳號</td>
            <td><c:out value="${Member.getM_idName()}"></c:out></td>
          </tr>
          <tr style="background-color:#D2E9FF ;color:#5B5B5B">
            <td>姓名</td>
            <td><c:out value="${Member.getM_name()}"></c:out></td>
          </tr>
          <tr style="background-color: 	#D2E9FF ;color:#5B5B5B">
            <td>密碼</td>
            <td><c:out value="${Member.getM_pwd()}"></c:out></td>
          </tr>
          <tr style="background-color:#D2E9FF	;color:#5B5B5B">
            <td>電話</td>
            <td><c:out value="${Member.getM_phone()}"></c:out></td>
          </tr>
          <tr style="background-color: 	#D2E9FF ;color:#5B5B5B">
            <td>地址</td>
            <td><c:out value="${Member.getM_address()}"></c:out></td>
          </tr>
          <tr style="background-color:#D2E9FF ;color:#5B5B5B">
            <td>E-mail</td>
            <td><c:out value="${Member.getM_email()}"></c:out></td>
          </tr>
          <tr style="background-color: #D2E9FF ;color:#5B5B5B">
            <td>註冊日期</td>
            <td><c:out value="${Member.getM_create_date()}"></c:out></td>
          </tr>
          <tr style="background-color: #D2E9FF ;color:#5B5B5B">
            <td>更新日期</td>
            <td><c:out value="${Member.getM_update_date()}"></c:out></td>
          </tr>
        </table>
        <div style="margin: 10px">
          <input type="submit" value="修改資料"  data-toggle="modal" data-target="#modifyData<c:out value="${Member.getM_id()}"/>">
        </div>
        <div style="margin: 10px">
          <a href="/webapp/OrderRecord"><input type="submit" value="購買記錄"></a>
        </div>
      </div>
    </div>
    <div class="modal fade" tabindex="-1" role="dialog" id="modifyData<c:out value="${Member.getM_id()}"/>">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">修改資料</h4>
                        </div>
                        <form class="form-horizontal" action="updateMemberData"  method="post">
                        <div class="modal-body">
                        
                          	<input type="hidden" name="M_id" value="<c:out value="${Member.getM_id()}"/>">
                            <div class="form-group">
                              <label class="col-sm-2 control-label">帳號</label>
                              <div class="col-sm-9">
                              <input type="hidden" name="M_idName" value="<c:out value="${Member.getM_idName()}"/>">
                                <p class="form-control-static" style="margin-top: 0rem;color:#606468"><c:out value="${Member.getM_idName()}"></c:out></p>
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyName" class="col-sm-2 control-label">姓名</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_name" placeholder="Name" value="<c:out value="${Member.getM_name()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyPassword" class="col-sm-2 control-label">密碼</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_pwd" placeholder="Password" value="<c:out value="${Member.getM_pwd()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyPhone" class="col-sm-2 control-label">電話</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_phone" placeholder="Phone Number" value="<c:out value="${Member.getM_phone()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyAddress" class="col-sm-2 control-label">地址</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_address" placeholder="Address" value="<c:out value="${Member.getM_address()}"/>">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="modifyEmail" class="col-sm-2 control-label">信箱</label>
                              <div class="col-sm-9">
                                <input type="text" class="form-control" name="M_email" placeholder="E-mail" value="<c:out value="${Member.getM_email()}"/>">
                              </div>
                            </div>
                          
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <input type="submit" name="type" class="btn btn-primary" style="background-color: rgb(113, 197, 170);border-color: rgb(113, 197, 170)" value="modifyMemberData">
                        </div>
                        </form><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            
            
            </div>
        
        <div class="col-xs-2 col-md-2" ></div>
    
    <svg xmlns="http://www.w3.org/2000/svg" class="icons"><symbol id="arrow-right" viewBox="0 0 1792 1792"><path d="M1600 960q0 54-37 91l-651 651q-39 37-91 37-51 0-90-37l-75-75q-38-38-38-91t38-91l293-293H245q-52 0-84.5-37.5T128 1024V896q0-53 32.5-90.5T245 768h704L656 474q-38-36-38-90t38-90l75-75q38-38 90-38 53 0 91 38l651 651q37 35 37 90z"/></symbol><symbol id="lock" viewBox="0 0 1792 1792"><path d="M640 768h512V576q0-106-75-181t-181-75-181 75-75 181v192zm832 96v576q0 40-28 68t-68 28H416q-40 0-68-28t-28-68V864q0-40 28-68t68-28h32V576q0-184 132-316t316-132 316 132 132 316v192h32q40 0 68 28t28 68z"/></symbol><symbol id="user" viewBox="0 0 1792 1792"><path d="M1600 1405q0 120-73 189.5t-194 69.5H459q-121 0-194-69.5T192 1405q0-53 3.5-103.5t14-109T236 1084t43-97.5 62-81 85.5-53.5T538 832q9 0 42 21.5t74.5 48 108 48T896 971t133.5-21.5 108-48 74.5-48 42-21.5q61 0 111.5 20t85.5 53.5 62 81 43 97.5 26.5 108.5 14 109 3.5 103.5zm-320-893q0 159-112.5 271.5T896 896 624.5 783.5 512 512t112.5-271.5T896 128t271.5 112.5T1280 512z"/></symbol></svg>

  </body>

</html>
  
</body>
</html>