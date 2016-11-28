<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*"%>
   
        <html xmlns="http://www.w3.org/1999/xhtml">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title>FAQ</title>
            <meta name="keywords" content="" />
            <meta name="description" content="" />
            <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
            <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
            <link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
            <link href="css/fonts.css" rel="stylesheet" type="text/css" media="all" />
            <link rel="stylesheet" type="text/css" href="css/header_css.css">
            <!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
        </head>

        <body>
        <%@include file="header.jsp"%>
         <div class="container" style="height: 100px;">
    </div>
     <div class="row" >
                <div id="logo">
                <h1><a href="#">F A Q</a></h1>
                <br>
            </div>
            </div>
    <div id="wrapper1">
        <div id="welcome" class="container">
            <div class="title">
                <h2>Apple Products Service</h2> <span class="byline">support all products</span> </div>
            <div class="content">
                <p>如果您的 Apple 硬體產品需要維修服務，請在下面按一下您產品的連結，來查看可用的服務選項。您將找到資訊來判斷您的產品或相關配件是否需要維修、取得保固資訊，以及查看有哪些服務選項可用。</p>
                <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tbody>
                        <tr>
                            <td width="50%" valign="top">
                                <ul class="square"> <img src="images/ipad.png">
                                    <li><a href="/webapp/FAQ/iPad" class="button">iPad</a></li>
                                    <br>
                                    <br> <img src="images/iphone.png">
                                    <li><a href="/webapp/FAQ/iPhone" class="button">iPhone</a></li>
                                </ul>
                            </td>
                            <td width="50%" valign="top">
                                <ul class="square"> <img src="images/macbook.png">
                                    <li><a href="/webapp/FAQ/Mac" class="button">MacBook Air</a></li>
                                    <br>
                                    <br> <img src="images/macbook1.png">
                                    <li><a href="/webapp/FAQ/Mac" class="button">MacBook Pro</a></li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div id="wrapper3">
        <div id="portfolio" class="container">
            <div class="title">
                <h2>Best Design</h2> <span class="byline">change your life in many ways</span> </div>
            <div class="pbox1">
                <div class="column1">
                    <div class="box"> <span class="icon icon-comments"></span>
                        <h3>串連每個社群網站舞台</h3>
                        <p>社交生活從不中斷</p>
                    </div>
                </div>
                <div class="column2">
                    <div class="box"> <span class="icon icon-cogs"></span>
                        <h3>內建超強系統</h3>
                        <p>安全性與隱私完全無需顧慮</p>
                    </div>
                </div>
                <div class="column3">
                    <div class="box"> <span class="icon icon-camera"></span>
                        <h3>超高解析度相機</h3>
                        <p>每一秒都是全場焦點</p>
                    </div>
                </div>
                <div class="column4">
                    <div class="box"> <span class="icon icon-cloud"></span>
                        <h3>iCloud</h3>
                        <p>史上最強雲端空間</p>
                    </div>
                </div>
            </div>
            <div class="pbox2">
                <div class="column1">
                    <div class="box"> <span class="icon icon-download"></span>
                        <h3>高速下載程式與文件</h3>
                        <p>高核心的CPU運算掌握最高效能</p>
                    </div>
                </div>
                <div class="column2">
                    <div class="box"> <span class="icon icon-headphones"></span>
                        <h3>iTune</h3>
                        <p>打造自己專屬的音樂庫</p>
                    </div>
                </div>
                <div class="column3">
                    <div class="box"> <span class="icon icon-user"></span>
                        <h3>最佳化使用者體驗</h3>
                        <p>使用最人性化的操控及感應器</p>
                    </div>
                </div>
                <div class="column4">
                    <div class="box"> <span class="icon icon-signal"></span>
                        <h3>最佳化系統分析</h3>
                        <p>為您尋找最合適自己的應用程式</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="wrapper2">
        <div id="featured" class="container">
            <div class="box1">
                <h2><span class="icon icon-group"></span>更多選購方式</h2>
                <p></p>
            </div>
            <div class="box2">
                <h2><span class="icon icon-briefcase"></span>尋找經銷商</h2>
                <p></p>
            </div>
        </div>
    </div>
    <div id="copyright">
        <div class="title">
            <h2>更多資訊</h2> <span class="byline">follow us in anyway</span> </div>
        <ul class="contact">
            <li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
            <li><a href="#" class="icon icon-facebook"><span></span></a></li>
            <li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
            <li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
            <li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
        </ul>
        <p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">igraph</a> | Design by <a href="http://templated.co" rel="nofollow">Strawberry</a>.</p>
    </div>
    </body>

    </html>