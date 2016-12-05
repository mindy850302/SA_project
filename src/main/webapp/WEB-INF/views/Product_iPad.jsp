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
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
 <link href="../css/main.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/header_css.css">
</head>

<body style="background-image: linear-gradient(to top, rgba(46, 49, 65, 0.7), rgba(46, 49, 65, 0.7)), url(../img/iPad/iPad.jpg)">
<b>
	<%@include file="header.jsp"%>
<!-- Page Wrapper -->
	<div id="page-wrapper">
<!-- Banner -->
		<section id="banner">
			<div class="inner">
				<div class="logo"><span class="icon fa-tablet "></span></div>
				<h2>iPad</h2>
				<p></p>
			</div>
		</section>
<!-- Wrapper -->
		<section id="wrapper">
<!-- One -->
			<section id="one" class="wrapper spotlight style1">
				<div class="inner">
					<a href="/webapp/Product" class="image"><img src="../img/iPad/iPadPro.jpg" alt="" /></a>
					<div class="content">
						<h2 class="major">iPad Pro</h2>
						<p>iPad Pro 並非只是新一代 iPad，更是我們對當代個人電腦運算領域，堅信不疑的願景。它擁有超越多數筆記型電腦的強大威力，卻讓你以指尖運用自如；即使再複雜的工作，都可以輕觸、滑動或動筆書寫等自然的方式進行。不論你選擇 12.9 吋或全新的 9.7 吋機型，iPad Pro比歷來出現過的都更有能力、更多才多藝、更方便攜帶。簡而言之，就是超強。</p>
						<a href="/webapp/Product" class="special">Learn more</a>
					</div>
				</div>
			</section>
<!-- Two -->
			<section id="two" class="wrapper alt spotlight style2">
				<div class="inner">
					<a href="/webapp/Product" class="image"><img src="../img/iPad/iPadAir2.jpg" alt="" /></a>
					<div class="content">
						<h2 class="major">iPad Air 2</h2>
						<p>設計 iPad 時，我們總想達成一個看似矛盾的目標：創造一部強大非凡卻又纖薄輕巧，讓你幾乎忘記它就在手上的裝置；一部讓你可以大顯身手，卻又流暢輕鬆、毫不費力的裝置。iPad Air 2，正是這樣的一部裝置，甚至超越了我們的預期。</p>
						<p>為了打造 iPad Air 2 令人驚豔的纖薄外型，我們著手重新設計 Retina 顯示器，將其三層合而為一。如此一來不僅使顯示器變得更加纖薄，也變得更好，色彩因此變得更生動，對比也更加鮮明。另外我們還加上抗反射鍍膜，讓 iPad Air 2 成為全世界反射率最低的平板電腦之一。</p>
						<a href="/webapp/Product" class="special">Learn more</a>
					</div>
				</div>
			</section>
<!-- Three -->
			<section id="three" class="wrapper spotlight style3">
				<div class="inner">
					<a href="/webapp/Product" class="image"><img src="../img/iPad/iPadMini4.jpg" alt="" /></a>
					<div class="content">
						<h2 class="major">iPad mini 4</h2>
						<p>於2016年3月22日上午1時發布，擁有相似iPhone 5s的外觀，因此被認為iPhone 5s的繼任。內部硬體使用iPhone 6s上所使用的蘋果A9處理器以及iPhone 6的收發訊號組件、各種感測器等外圍組件，外觀、螢幕組件則是採用iPhone 5s的，市場定位及定價上屬於入門級價格，以供應發展中國家潛在客戶升級iPhone之用，以及取代iPhone 5s等小螢幕使用者的手機。</p>
						<a href="/webapp/Product" class="special">Learn more</a>
					</div>
				</div>
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
