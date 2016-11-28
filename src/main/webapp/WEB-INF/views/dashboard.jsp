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

    <title>Dashboard</title>

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
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

                <div class="row">
                    <div class="col-md-4">
                        <div class="main-box mb-red">
                            <a href="#">
                                <h1>40</h1>
                                <h5>New Products</h5>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="main-box mb-dull">
                            <a href="#">
                                <h1>653</h1>
                                <h5>New Member</h5>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="main-box mb-pink">
                            <a href="#">
                                <h1>94</h1>
                                <h5>New Comment</h5>
                            </a>
                        </div>
                    </div>

                </div>

          <h2 class="sub-header">熱門產品</h2>
          <div class="row">
              <div class="col-sm-3 col-md-3">
                <div class="thumbnail">
                  <img  src="img/macpro1.jpg" alt="...">
                  <div class="caption">
                    <center>
                    <h5>13 吋 MacBook Pro</h5>
                    <h5 style="color: #777070;line-height: 25px;">2.0GHz 處理器 <br>256GB 儲存容量</h5>
                    <h5>價錢：43500</h5>
                    <h5>存貨數量：653</h5>
                    <h5>上架日期：2016/11/09</h5>
                    <h5>更新日期：2016/11/09</h5>
                    <h5>下架日期：2016/11/09</h5>
                    
                    </center>
                  </div>
                </div>
              </div>
              <div class="col-sm-3 col-md-3">
                <div class="thumbnail">
                  <img  src="img/macpro1.jpg" alt="...">
                  <div class="caption">
                    <center>
                    <h5>13 吋 MacBook Pro</h5>
                    <h5 style="color: #777070;line-height: 25px;">2.0GHz 處理器 <br>256GB 儲存容量</h5>
                    <h5>價錢：43500</h5>
                    <h5>存貨數量：653</h5>
                    <h5>上架日期：2016/11/09</h5>
                    <h5>更新日期：2016/11/09</h5>
                    <h5>下架日期：2016/11/09</h5>
                    
                    </center>
                  </div>
                </div>
              </div>
              <div class="col-sm-3 col-md-3">
                <div class="thumbnail">
                  <img  src="img/macpro1.jpg" alt="...">
                  <div class="caption">
                    <center>
                    <h5>13 吋 MacBook Pro</h5>
                    <h5 style="color: #777070;line-height: 25px;">2.0GHz 處理器 <br>256GB 儲存容量</h5>
                    <h5>價錢：43500</h5>
                    <h5>存貨數量：653</h5>
                    <h5>上架日期：2016/11/09</h5>
                    <h5>更新日期：2016/11/09</h5>
                    <h5>下架日期：2016/11/09</h5>
       
                    </center>
                  </div>
                </div>
              </div>
              <div class="col-sm-3 col-md-3">
                <div class="thumbnail">
                  <img  src="img/macpro1.jpg" alt="...">
                  <div class="caption">
                    <center>
                    <h5>13 吋 MacBook Pro</h5>
                    <h5 style="color: #777070;line-height: 25px;">2.0GHz 處理器 <br>256GB 儲存容量</h5>
                    <h5>價錢：43500</h5>
                    <h5>存貨數量：653</h5>
                    <h5>上架日期：2016/11/09</h5>
                    <h5>更新日期：2016/11/09</h5>
                    <h5>下架日期：2016/11/09</h5>
                    
                    </center>
                  </div>
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
