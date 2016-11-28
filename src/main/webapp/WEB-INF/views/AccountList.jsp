<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp&nbspmindy850302</td>
                  <td>Mindy Hsu</td>
                  <td>0960730847</td>
                  <td>mindy850302@gmail.com</td>
                  <td>台北市</td>
                  <td>2016/11/02</td>
                  <th><button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModify"><span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span></button></th>
                  <th><button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#mydelete"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></th>
                </tr>
              </tbody>
            </table>
          </div>
            </div>
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
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                  &nbsp&nbspmindy850302</td>
                  <td>Mindy Hsu</td>
                  <td>行政</td>
                  <td>0960730847</td>
                  <td>mindy850302@gmail.com</td>
                  <td>台北市</td>
                  <td>2016/11/02</td>
                  <th><button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModify"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></th>
                  <th><button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#mydelete"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></th>
                </tr>
              </tbody>
            </table>
          </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">修改成員</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">成員類別</label>
                <div class="col-sm-8">
                  <input type="radio" id="Member_check" name="A_category" checked="checked" value="Member"/>&nbsp&nbspMember<br><input id="Administor_check" type="radio" name="A_category" value="Administor"/>&nbsp&nbspAdministor
                </div>
              </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">帳號</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="帳號" value="mindy850302">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="姓名" value="Mindy Hsu">
                </div>
              </div>
              <script>
                $('#Administor_check').click(function() {
                    $("#Administor").show();
                });
                $('#Member_check').click(function() {
                    $("#Administor").hide();
                });
              </script>
              <div class="form-group" id="Administor" style="display: none;">
                <label for="inputEmail3" class="col-sm-2 control-label">所屬部門</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="所屬部門" value="行政">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">電話</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputPassword3" placeholder="電話" value="0960730847">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-8">
                  <input type="email" class="form-control" id="inputPassword3" placeholder="Email" value="mindy850430@yahoo.com.tw">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputPassword3" placeholder="地址" value="台北市">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">新增成員</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">成員類別</label>
                <div class="col-sm-8">
                  <input type="radio" id="Member_check_add" name="A_category" checked="checked" value="Member"/>&nbsp&nbspMember<br><input id="Administor_check_add" type="radio" name="A_category" value="Administor"/>&nbsp&nbspAdministor
                </div>
              </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">帳號</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="帳號" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="姓名" >
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
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="所屬部門" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">電話</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputPassword3" placeholder="電話" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-8">
                  <input type="email" class="form-control" id="inputPassword3" placeholder="Email" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputPassword3" placeholder="地址" >
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>
    <div class="modal fade" id="mydelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">刪除會員</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-striped">
              <tbody>
                <tr>
                  <td>1</td>
                  <td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp&nbspmindy850302</td>
                  <td>Mindy Hsu</td>
                  <td>0960730847</td>
                  <td>mindy850302@gmail.com</td>
                  <td>台北市</td>
                  <td>2016/11/02</td>
                </tr>
              </tbody>
            </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary">確認</button>
                </div>
              </div>
            </div>
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
