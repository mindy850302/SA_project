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

<title>CommentList</title>



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
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
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
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
		style="color: #252830;">
		<div class="row">
			<div class="col-lg-6">
				<h1 class="page-header">評論查看</h1>
			</div>
			<div class="col-lg-3">
				<div class="input-group"">
					<input type="text" class="form-control" placeholder="Search for..."
						style="border-radius: 40px;"> <span
						class="input-group-btn">
						<button class="btn btn-default" type="button"
							style="border-radius: 40px;">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-lg-3">
				<div class="input-group"">
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#myAddComment">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增評論
					</button>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#home"
				aria-controls="home" role="tab" data-toggle="tab"
				style="color: #252830;">評論</a></li>
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
								<th>產品名稱</th>
								<th>評論內容</th>
								<th>評分</th>
								<th>建立日期</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${CommentList}" var="comment">
								<tr>
									<td>${comment.comment_M_id}</td>
									<td><span class="glyphicon glyphicon-user"
										aria-hidden="true"></span>${comment.comment_M_id.M_idName}</td>
									<td>${comment.comment_M_id.M_name}</td>
									<td>${comment.comment_p_id.p_name}</td>
									<td>${comment.c_comment}</td>
									<td>${comment.score}</td>
									<td>${comment.c_create_date}</td>
									<th><button type="button" class="btn btn-success"
											data-toggle="modal" data-target="#myModifyComment">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</button></th>
									<th><button type="button" class="btn btn-danger"
											data-toggle="modal" data-target="#mydeleteComment">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										</button></th>
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
	<!-- Modal -->
	<c:forEach items="${CommentList}" var="comment1">
		<div class="modal fade" id="myModifyComment" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改評論</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" action="updateComment" method="post">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">帳號</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3"
										name="comment_M_id.M_idName" placeholder="帳號" value="<c:out value="${comment1.comment_M_id.M_idName}"/>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3"
										name="" placeholder="姓名" value="<c:out value="${comment1.comment_M_id.M_name}"/>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">產品名稱</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputPassword3"
										name="" placeholder="產品名稱" value="<c:out value="${comment1.comment_p_id.p_name}"/>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">評論內容</label>
								<div class="col-sm-8">
									<input type="text" class="form-control comment-input"
										id="inputPassword3" name="c_comment" placeholder="評論內容"
										value="<c:out value="${comment1.c_comment}"/>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">評分</label>
								<div class="col-sm-8">
									<fieldset class="rating">
										<input type="radio" id="star5" name="rating" value="5" /><label
											class="full" for="star5" title="Awesome - 5 stars"></label> <input
											type="radio" id="star4half" name="rating"
											value="4 and a half" /><label class="half" for="star4half"
											title="Pretty good - 4.5 stars"></label> <input type="radio"
											id="star4" name="rating" value="4" /><label class="full"
											for="star4" title="Pretty good - 4 stars"></label> <input
											type="radio" id="star3half" name="rating"
											value="3 and a half" /><label class="half" for="star3half"
											title="Meh - 3.5 stars"></label> <input type="radio"
											id="star3" name="rating" value="3" /><label class="full"
											for="star3" title="Meh - 3 stars"></label> <input
											type="radio" id="star2half" name="rating"
											value="2 and a half" /><label class="half" for="star2half"
											title="Kinda bad - 2.5 stars"></label> <input type="radio"
											id="star2" name="rating" value="2" /><label class="full"
											for="star2" title="Kinda bad - 2 stars"></label> <input
											type="radio" id="star1half" name="rating"
											value="1 and a half" /><label class="half" for="star1half"
											title="Meh - 1.5 stars"></label> <input type="radio"
											id="star1" name="rating" value="1" /><label class="full"
											for="star1" title="Sucks big time - 1 star"></label> <input
											type="radio" id="starhalf" name="rating" value="half" /><label
											class="half" for="starhalf"
											title="Sucks big time - 0.5 stars"></label>
									</fieldset>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary" name="type"
							value="modifyComment">Save changes</button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<!-- Modal -->
	<div class="modal fade" id="myAddComment" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增評論</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" method="post" action="CommentList">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">帳號</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputEmail3"
									name="comment_M_id" placeholder="帳號">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputEmail3"
									name="getMember().getM_name" placeholder="姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">產品名稱</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="inputPassword3"
									name="getProduct().getP_name" placeholder="產品名稱">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">評論內容</label>
							<div class="col-sm-8">
								<input type="text" class="form-control comment-input"
									id="inputPassword3" name="c_comment" placeholder="評論內容">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">評分</label>
							<div class="col-sm-8">
								<fieldset class="rating">
									<input type="radio" id="star5" name="rating" value="5" /><label
										class="full" for="star5" title="Awesome - 5 stars"></label> <input
										type="radio" id="star4half" name="rating" value="4 and a half" /><label
										class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
									<input type="radio" id="star4" name="rating" value="4" /><label
										class="full" for="star4" title="Pretty good - 4 stars"></label>
									<input type="radio" id="star3half" name="rating"
										value="3 and a half" /><label class="half" for="star3half"
										title="Meh - 3.5 stars"></label> <input type="radio"
										id="star3" name="rating" value="3" /><label class="full"
										for="star3" title="Meh - 3 stars"></label> <input type="radio"
										id="star2half" name="rating" value="2 and a half" /><label
										class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
									<input type="radio" id="star2" name="rating" value="2" /><label
										class="full" for="star2" title="Kinda bad - 2 stars"></label>
									<input type="radio" id="star1half" name="rating"
										value="1 and a half" /><label class="half" for="star1half"
										title="Meh - 1.5 stars"></label> <input type="radio"
										id="star1" name="rating" value="1" /><label class="full"
										for="star1" title="Sucks big time - 1 star"></label> <input
										type="radio" id="starhalf" name="rating" value="half" /><label
										class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
								</fieldset>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<input type="submit" class="btn btn-primary" name="action_type"
								value="addComment"></input>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<form action="deleteComment" method="post">
		<div class="modal fade" id="mydeleteComment" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">刪除評論</h4>
					</div>
					<div class="modal-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#id</th>
									<th>帳號</th>
									<th>姓名</th>
									<th>評論內容</th>
									<th>評分</th>
									<th>建立日期</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td><span class="glyphicon glyphicon-user"
										aria-hidden="true"></span>&nbsp&nbspmindy850302</td>
									<td>Mindy Hsu</td>
									<td>Defines a password field (characters are masked)</td>
									<td>5</td>
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
	</form>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
