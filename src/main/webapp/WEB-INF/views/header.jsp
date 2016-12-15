<% request.setCharacterEncoding("utf-8");%>

<div class="container2">
<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav" role="banner">

   
   <div class="row" style="font-family:monospace !important;">                
 
    
    <div id="logo2">
        <h1><a href="#" style="font-size:30px !important;">Strawberry</a></h1>
    </div>
    <div id="menu2" style="font-size:20px !important;;">
        <ul>
            <li class="current_page_item"><a href="/webapp/" accesskey="1" title="">Homepage</a></li>
            <li><a href="/webapp/About" accesskey="2" title="">About us</a></li>
            <li><a href="/webapp/Product/iPhone" accesskey="3" title="">iPhone</a></li>
            <li><a href="/webapp/Product/iPad" accesskey="4" title="">ipad</a></li>
            <li><a href="/webapp/Product/Macbook" accesskey="5" title="">macbook</a></li>
            <li><a href="/webapp/FAQ" accesskey="5" title="">FAQ</a></li>
           <c:if test="${loginsession!=null}">
	            <li><a href="/webapp/MemberData" accesskey="5" title=""><c:out value="${loginsession}"/></a></li>
	            <li><a href="/webapp/ShoppingCart" accesskey="5" title=""><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a></li>
	            <li><a href="/webapp/logout" accesskey="5" title="">Logout</a></li>
	            
            </c:if>
            <c:if test="${loginsession==null}">
            <li><a href="/webapp/login" accesskey="5" title="">Login</a></li>
            <li><a href="/webapp/signup" accesskey="5" title="">Sign up </a></li>
            </c:if>
            
        </ul>
    </div>
   
   
    
 </div>
  </header>
 
 </div>
