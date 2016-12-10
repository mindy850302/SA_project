<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/webapp/dashboard"><img src="img/tools.png"></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/webapp/dashboard"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>&nbspDashboard</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp設定 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                
                <li><a href="/webapp/logout">Log out</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
          	<!-- <li><form class="navbar-form "">
            <input style="background-color:#434856;border:0px solid #434856;color: #FFFFFF;" type="text" class="form-control" placeholder="Search...">
          </form></li> -->
          </ul>
          <ul class="nav nav-sidebar">
            <li>
                <a href="#"><i class="fa fa-desktop "></i>會員管理 </a>
                 <ul class="nav nav-second-level">
                    <li>
                        <a href="/webapp/AccountList"><i class="fa fa-toggle-on"></i>成員列表</a>
                    </li>
                   <!--  <li>
                        <a href="#"><i class="fa fa-toggle-on"></i>新增成員</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bell "></i>修改成員資料</a>
                    </li>
                     <li>
                        <a href="progress.html"><i class="fa fa-circle-o "></i>刪除成員</a>
                    </li>   -->             
                </ul>
            </li>
            <li>
                <a href="/webapp/ProductInfro"><i class="fa fa-desktop "></i>產品列表</a>
                 <ul class="nav nav-second-level">
                    <!-- <li>
                        <a href="#"><i class="fa fa-toggle-on"></i>產品資訊</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-toggle-on"></i>新增產品</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bell "></i>修改產品資料</a>
                    </li>
                     <li>
                        <a href="progress.html"><i class="fa fa-circle-o "></i>刪除產品</a>
                    </li>    -->            
                </ul>
            </li>
            <li><a href="/webapp/CommentList"><i class="fa fa-desktop "></i>評論查看</a></li>
            <li><a href="/webapp/Inventory"><i class="fa fa-desktop "></i>存貨情況</a></li>
            <li><a href="/webapp/OrderDetail"><i class="fa fa-desktop "></i>訂單明細</a></li>
            <li><a href="/webapp/ReturnDetail"><i class="fa fa-desktop "></i>退貨紀錄</a></li>
            <li><a href="/webapp/DiscountDetail"><i class="fa fa-desktop "></i>折讓紀錄</a></li>
          </ul>
        </div>