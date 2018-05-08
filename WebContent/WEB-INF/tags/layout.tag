<%@ tag body-content="scriptless" %>
<%@tag pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ attribute name="pageTitle" required="true" type="java.lang.String" %>

	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css" integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/validate.js/0.12.0/validate.min.js"></script>

<style type="text/css">
	.hr-text {
	  line-height: 1em;
	  position: relative;
	  outline: 0;
	  border: 0;
	  color: black;
	  text-align: center;
	  height: 1.5em;
	  opacity: 0.5;
	}
	.hr-text:before {
	  content: '';
	  background: linear-gradient(to right, transparent, #818078, transparent);
	  position: absolute;
	  left: 0;
	  top: 50%;
	  width: 100%;
	  height: 1px;
	}
	.hr-text:after {
	  content: attr(data-content);
	  position: relative;
	  display: inline-block;
	  color: black;
	  padding: 0 0.5em;
	  line-height: 1.5em;
	  color: #818078;
	  background-color: #fcfcfa;
	}
</style>

<title>${pageTitle}</title>
</head>
<body>
 <header>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">E-Ticaret</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    
    <ul class="navbar-nav mr-auto">
      
      <li class="nav-item active">
        <a class="nav-link" href="./">Anasayfa<span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item">
       	<a class="nav-link" href="./tum-urunler">Tüm Ürünler</a>
      </li>
      
      <li class="nav-item">
      	<a class="nav-link" href="#">Hesap</a>
    	</li>
      
      <li class="nav-item">
      	<a class="nav-link" href="./hesap-olustur">Üye ol</a>
    	</li>
    	
    </ul>
    
  </div>
</nav>
    </header>
	<main role="main">
		<div class="container">
		<%
			if(session.getAttribute("user_auth") == null){
				
			}else{
		%>
				<h1>Üye girmiş</h1>	
		<% }
			%>
		<jsp:doBody/>
		</div>
	</main>
</body>
</html>