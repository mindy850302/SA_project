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

    <title>Strawberry</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <link href="dashboard.css" rel="stylesheet">
    
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
	<link href="css/main.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/header_css.css">
</head>

<body style="background-image: linear-gradient(to top, rgba(46, 49, 65, 0.7), rgba(46, 49, 65, 0.7)), url(img/Macbook/Macbook.jpg)">
<b>
	<%@include file="header.jsp"%>
<!-- Page Wrapper -->
	<div id="page-wrapper">
<!-- Banner -->
		<section id="banner">
			<div class="inner">
				<div class="logo"><span class="icon fa-laptop"></span></div>
				<h2>Macbook</h2>
				<p></p>
			</div>
		</section>
<!-- Wrapper -->
		<section id="wrapper">
<!-- One -->
			<section id="one" class="wrapper spotlight style1">
				<div class="inner">
					<a href="#" class="image"><img src="img/Macbook/MacbookPro.jpg" alt="" /></a>
					<div class="content">
						<h2 class="major">MacBook Pro</h2>
						<p>它比以往更為快速、更加強大，但身形卻更顯纖薄、輕巧。它擁有歷來最亮麗、最多彩的 Mac 筆記型電腦顯示器。它推出 Touch Bar，這是鑲嵌於鍵盤上，可支援 Multi-Touch 的長形玻璃面板，讓你快速取用你需要的各種工具。全新 MacBook Pro，以我們突破性的創意構想打造，現在，它已經準備好，等著助你實現你的每個創意。</p>
						<a href="#" class="special">Learn more</a>
					</div>
				</div>
			</section>
<!-- Two -->
			<section id="two" class="wrapper alt spotlight style2">
				<div class="inner">
					<a href="#" class="image"><img src="img/Macbook/Macbook.png" alt="" /></a>
					<div class="content">
						<h2 class="major">MacBook</h2>
						<p>我們打造 MacBook 的目標，意在實現種種不可能：打造出史上最輕盈、最精巧的 Mac 筆記型電腦，卻仍能提供完整的全尺寸使用體驗。也就是說，每個環節都必須經過重新設計，不但輕巧纖薄，還要更好。我們所成就的，不只是一部新的筆記型電腦，而是筆記型電腦的未來。現在，具備第六代 Intel 處理器、更強的繪圖處理效能、更快速的快閃儲存，以及長達 10 小時的電池續航力*，MacBook 功能更加強大。</p>
						<a href="#" class="special">Learn more</a>
					</div>
				</div>
			</section>
<!-- Three -->
			<section id="three" class="wrapper spotlight style3">
				<div class="inner">
					<a href="#" class="image"><img src="img/Macbook/MacbookAir.jpg" alt="" /></a>
					<div class="content">
						<h2 class="major">MacBook Air</h2>
						<p>MacBook Air 的第五代 Intel Core 處理器，給你更多時間處理更多。除了智慧與效率兼具的各式
功能外，你還能掌握不可思議的強大威力。而攜帶時卻幾乎輕若無物。</p>
						<a href="#" class="special">Learn more</a>
					</div>
				</div>
			</section>
<!-- Four -->
			<section id="four" class="wrapper alt style1">
				<div class="inner">
					<h2 class="major">其他</h2>
					<p></p>
					<section class="features">
						<article>
							<a href="#" class="image"><img src="img/Macbook/MacOS_Sierra.jpg" alt="" /></a>
							<h3 class="major">MacOS Sierra</h3>
							<p>現在你的 Mac 能做到什麼？儘管問。</p>
							<a href="#" class="special">Learn more</a>
						</article>
						<article>
							<a href="#" class="image"><img src="img/Macbook/Mac_Accessories.jpg" alt="" /></a>
							<h3 class="major">Mac 配件</h3>
							<a href="#" class="special">立即選購</a>
						</article>
					</section>
				</div>
			</section>
		</section>
<!-- Footer -->
		<section id="footer">
			<div class="inner">
				<h2 class="major">Get in touch</h2>
				<p>Cras mattis ante fermentum, malesuada neque vitae, eleifend erat. Phasellus non pulvinar erat. Fusce tincidunt, nisl eget mattis egestas, purus ipsum consequat orci, sit amet lobortis lorem lacus in tellus. Sed ac elementum arcu. Quisque placerat auctor laoreet.</p>
				<form method="post" action="#">
					<div class="field">
						<label for="name">Name</label>
						<input type="text" name="name" id="name" />
					</div>
					<div class="field">
						<label for="email">Email</label>
						<input type="email" name="email" id="email" />
					</div>
					<div class="field">
						<label for="message">Message</label>
						<textarea name="message" id="message" rows="4"></textarea>
					</div>
					<ul class="actions">
						<li><input type="submit" value="Send Message" /></li>
					</ul>
				</form>
				<ul class="contact">
					<li class="fa-home">
						Untitled Inc<br />
						1234 Somewhere Road Suite #2894<br />
						Nashville, TN 00000-0000
					</li>
					<li class="fa-phone">(000) 000-0000</li>
					<li class="fa-envelope"><a href="#">information@untitled.tld</a></li>
					<li class="fa-twitter"><a href="#">twitter.com/untitled-tld</a></li>
					<li class="fa-facebook"><a href="#">facebook.com/untitled-tld</a></li>
					<li class="fa-instagram"><a href="#">instagram.com/untitled-tld</a></li>
				</ul>
				<ul class="copyright">
					<li>&copy; Untitled Inc. All rights reserved.</li>
				</ul>
			</div>
		</section>
	</div>

<!-- Scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</b>
</body>
</html>
