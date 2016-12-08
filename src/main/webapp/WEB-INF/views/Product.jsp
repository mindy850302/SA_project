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
    <link rel="icon" href="../../favicon.ico">
    <title>Strawberry</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <link href="dashboard.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet" />
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <link href="css/style.css" rel="stylesheet" />
    <script type="text/javascript" src="js/myscript.js"></script>
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
            </div>
            <div class="col-xs-2 col-md-2" ></div>
    </div>

    <div class="row" style="background-color:#eee">
        <div class="col-xs-2 col-md-2" ></div>
        <div class="col-xs-8 col-md-8" >
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="home">
                    <div class="table-responsive">
                        <table class="table table-striped table-show-product">
                        <tbody style="color:#000000">
                            <tr>
                                <td rowspan="7" style="vertical-align:middle"><img style="max-width:100%; width:100%; height:auto" class="product_img_list"  src="<c:out value="${Product.getP_image()}"></c:out>"></td>
                                <td style="vertical-align:middle"><label style="font-size:30px" class="col-sm-11 control-label"><c:out value="${Product.getP_name()}"></c:out></label></td>
                            </tr>
                            <tr>
                                <td style="vertical-align:middle">
                                    <label class="col-sm-3 control-label" style="font-size:18px">滿意度：</label>
                                    <div class="radial-progress" data-score="1.7">
										<div class="circle">
											<div class="mask full">
												<div class="fill"></div>
											</div>
											<div class="mask half">
												<div class="fill"></div>
												<div class="fill fix"></div>
											</div>
										</div>
										<div class="inset"><span class='big'><c:out value="${Product.getAverage()}"></c:out></span> <span class='little'>/ 5</span></div>
										
									</div>
                                    
                                </td>
                            </tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label" style="font-size:18px">NT . <c:out value="${Product.getP_price()}"></c:out></label></td></tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label" style="font-size:16px"><c:out value="${Product.getP_describe()}"></c:out></label></td></tr>
                            <tr><td style="vertical-align:middle"><label class="col-sm-11 control-label" style="font-size:16px">存貨 ： <c:out value="${Product.getP_inventory()}"></c:out></label></td></tr>
                            <tr><td style="vertical-align:middle"><div class="form-group">
                                        <label class="col-sm-2 control-label" style="font-size:18px">評分</label>
                                        <!-- Rating Star -->
                                        <div class="col-sm-9">
                                        <form action="ratingStar" method="post">
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
                                            &nbsp&nbsp&nbsp<input type="submit" class="btn-default btn " name="comment" value="送出評論"/>
                                        </form>
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
                </div>
               
            <div class="modal fade" tabindex="-1" role="dialog" id="addToCart" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content" style="color:#000000">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">加入購物車</h4>
                        </div>
                        <div class="modal-body" >
                        
                            <form class="form-horizontal" action="insertShoppingCart">
                            <input type="hidden" name="shopping_M_id" value="1">
                            <div class="form-group" style="font-size:18px;">
                                <label for="inputEmail3" class="col-sm-3 control-label" style="padding-top:0px;">機款</label>
                                <div class="col-sm-8" class="form-control" >
                               		<input type="hidden" name="shopping_p_id" value="${Product.getP_id()}">
                                	<c:out value="${Product.getP_name()}"></c:out>
                                </div>
                            </div>
                            <div class="form-group" style="font-size:18px;">
                                <label for="inputEmail3" class="col-sm-3 control-label" style="padding-top:0px;">價錢</label>
                                <div class="col-sm-8" class="form-control" >
                                <input type="hidden" name="p_price" value="<c:out value="${Product.getP_price()}"></c:out>">
                                	<c:out value="${Product.getP_price()}"></c:out>
                                </div>
                            </div>   
                            <div class="form-group" style="font-size:18px;">
                                <label for="inputEmail3" class="col-sm-3 control-label" style="padding-top:0px;">數量</label>
                                <div class="col-sm-8">
                                <c:if test="${Product.getP_inventory()!=0}">
                                    <select class="form-control" name="p_amount"  id="amount" >                                    
	                                        <c:forEach var="i" begin="1" end="${Product.getP_inventory()}" step="1">
	                                        	<option value="${(i)}">${(i)}</option>
	                                        </c:forEach>	                                
	                                 </select>
	                                 </div>
	                                  </div>
	                                 <div class="modal-footer">
			                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			                            <button type="submit" class="btn btn-primary" onclick="addCart()">加入購物車</button>
			                        </div><!-- /.modal-content -->
	                                 </c:if>
	                                    <c:if test="${Product.getP_inventory()==0}">
	                                        <font color=red>存貨不足</font>
	                                        </div>
	                                         </div>
	                                        <div class="modal-footer">
					                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					                            
					                        </div><!-- /.modal-content -->
	                                    </c:if>
                                   
                                    
                                    
                                </div>
                            </div>
                        </form>
                        </div>
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            	<script>
					function addCart() {
						alert("加入購物車成功！");
					}
				</script>
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
