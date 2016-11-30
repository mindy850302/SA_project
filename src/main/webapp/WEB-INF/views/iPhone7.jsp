<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Pineapple</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <link href="dashboard.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet" />
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <link href="css/style.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/header_css.css">
	<!-- <link href="main2.css" rel="stylesheet"> -->

</head>

<body style="background-image: linear-gradient(to top, rgba(46, 49, 65, 0.7), rgba(46, 49, 65, 0.7)), url("../img/images/iPhone.jpg")">
<b>
    <%@include file="header.jsp"%>
    <div class="row" style="margin-top:90px; background-color:#272727">
        <div class="col-xs-2 col-md-2" ></div>
        <div class="col-xs-8 col-md-8" >
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
<!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                </ol>
<!-- Wrapper for slides -->
                <center>
                    <div class="carousel-inner" role="listbox" >
                        <div class="item active">
                            <img src="img/iPhone7-jetBlack.jpg" width="100%" alt="...">
                            <div class="carousel-caption">
                                <h3 style="color:#eee">Jet Black</h3>
                                <p>~ New ~</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="img/iPhone7-black.jpg" alt="...">
                            <div class="carousel-caption">
                                <h3 style="color:#f5f5f5">Black</h3>
                                <p></p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="img/iPhone7-silver.jpg" alt="...">
                            <div class="carousel-caption">
                                <h3 style="color:#333">Silver</h3>
                                <p></p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="img/iPhone7-gold.jpg" alt="...">
                            <div class="carousel-caption">
                                <h3 style="color:#333">Gold</h3>
                                <p></p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="img/iPhone7-roseGold.jpg" alt="...">
                            <div class="carousel-caption">
                                <h3 style="color:#333">Rose Gold</h3>
                                <p></p>
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
    </div>

    <div class="row" style="background-color:#eee">
        <div class="col-xs-2 col-md-2" ></div>
        <div class="col-xs-8 col-md-8" >
            <ul class="nav nav-tabs" role="tablist" >
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" style="color: #252830;">iPhone 7</a></li>
                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab" style="color: #252830;">iPhone 7 Plus</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="home">
                    <div class="table-responsive">
                        <table class="table table-striped table-show-product">
                        <tbody>
                            <tr>
                                <td rowspan="7" style="vertical-align:middle"><img style="max-width:100%; width:100%; height:auto" class="product_img_list"  src="img/iphone7.png"></td>
                                <td style="vertical-align:middle"><label style="font-size:30px" class="col-sm-11 control-label">iPhone 7</label></td>
                            </tr>
                            <tr>
                                <td style="vertical-align:middle">
                                    <label class="col-sm-3 control-label">滿意度：</label>
                                    <!-- Rating Star -->
                                        <div class="col-sm-4">
                                            <fieldset class="rating">
                                                <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
                                                <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
                                                <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                                                <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
                                                <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
                                                <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
                                                <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                                                <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
                                                <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                                                <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                                            </fieldset>
                                        </div>
                                    <label style="color: #ff0000 ; font-size:20px" class="col-sm-2 control-label">10分</label>
                                </td>
                            </tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label">4.7 吋顯示器</label></td></tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label">128GB : NT$28,500</label></td></tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label">256GB : NT$32,500</label></td></tr>
                            <tr><td style="vertical-align:middle"><div class="form-group">
                                        <label class="col-sm-2 control-label">評分</label>
                                        <!-- Rating Star -->
                                        <div class="col-sm-9">
                                            <fieldset class="rating">
                                                <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
                                                <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
                                                <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                                                <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
                                                <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
                                                <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
                                                <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                                                <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
                                                <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                                                <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                                            </fieldset>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="vertical-align:middle"><button style="background-color: #286090;border-color: #204d74;" type="button" class="btn btn-success"  data-toggle="modal" data-target="#addToCart">加入購物車</button></td>
                            </tr>
                        </tbody>
                        </table>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="profile">
                    <div class="table-responsive">
                        <table class="table table-striped table-show-product">
                        <tbody>
                            <tr>
                                <td rowspan="7" style="vertical-align:middle"><img style="max-width:100%; width:100%; height:auto" class="product_img_list"  src="img/iphone7-plus.png"></td>
                                <td style="vertical-align:middle"><label style="font-size:30px" class="col-sm-11 control-label">iPhone 7 Plus</label></td>
                            </tr>
                            <tr>
                                <td style="vertical-align:middle">
                                    <label class="col-sm-3 control-label">滿意度：</label>
                                    <!-- Rating Star -->
                                        <div class="col-sm-4">
                                            <fieldset class="rating">
                                                <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
                                                <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
                                                <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                                                <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
                                                <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
                                                <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
                                                <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                                                <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
                                                <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                                                <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                                            </fieldset>
                                        </div>
                                    <label style="color: #ff0000 ; font-size:20px" class="col-sm-2 control-label">10分</label>
                                </td>
                            </tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label">5.5 吋顯示器</label></td></tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label">128GB : NT$32,900</label></td></tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label">256GB : NT$36,900</label></td></tr>
                            <tr><td style="vertical-align:middle"><div class="form-group">
                                        <label class="col-sm-2 control-label">評分</label>
                                        <!-- Rating Star -->
                                        <div class="col-sm-9">
                                            <fieldset class="rating">
                                                <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
                                                <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
                                                <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
                                                <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
                                                <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
                                                <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
                                                <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
                                                <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>
                                                <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
                                                <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
                                            </fieldset>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="vertical-align:middle"><button style="background-color: #286090;border-color: #204d74;" type="button" class="btn btn-success"  data-toggle="modal" data-target="#addToCart">加入購物車</button></td>
                            </tr>
                        </tbody>
                        </table>
                    </div>
                </div>
            <div class="modal fade" tabindex="-1" role="dialog" id="addToCart">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">加入購物車</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal">
                            <div class="form-group">
                                <label for="choosePattern" class="col-sm-2 control-label">機款</label>
                                <div class="col-sm-8">
                                    <input type="radio" id="iPhone7" name="pattern" checked="checked" value="iPhone7"/>  iPhone7<br><input id="iPhone7Plus" type="radio" name="pattern" value="iPhone7Plus"/>  iPhone7 Plus
                                </div>
                            </div>   
                            <div class="form-group">
                                <label for="chooseColor" class="col-sm-2 control-label">顏色</label>
                                <div class="col-sm-8">
                                    <select name="color" size="1" id="color" > 
                                        <option value="1" selected>曜石黑色 Jet Black</option> 
                                        <option value="2">黑色 Black</option>
                                        <option value="3">銀色 Silver</option>
                                        <option value="4">金色 Gold</option>
                                        <option value="5">玫瑰金色 Rose Gold</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="chooseCapacity" class="col-sm-2 control-label">儲存容量</label>
                                <div class="col-sm-8">
                                    <select name="capacity" size="1" id="capacity" > 
                                        <option value="1" selected>32GB</option>
                                        <option value="2">128GB</option> 
                                        <option value="3">256GB</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="chooseAmount" class="col-sm-2 control-label">數量</label>
                                <div class="col-sm-8">
                                    <select name="amount" size="1" id="amount" > 
                                        <option value="1" selected>1</option>
                                        <option value="2">2</option> 
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary">加入購物車</button>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            
            
            </div>
        </div>
        <div class="col-xs-2 col-md-2" ></div>
    </div>

<!-- Scripts -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</b>
</body>
</html>
