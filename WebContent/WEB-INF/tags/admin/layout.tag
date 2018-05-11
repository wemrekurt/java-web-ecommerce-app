<%@ tag body-content="scriptless" %>
<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="pageTitle" required="true" type="java.lang.String" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css" integrity="sha384-G0fIWCsCzJIMAVNQPfjH08cyYaUtMwjJwqiRKxxE/rx96Uroj1BtIQ6MLJuheaO9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>


<script type="text/javascript">
	$(document).ready( function () {
		$('#dataTable').DataTable();    
	});
	
</script>
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
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/">Anasayfa<span class="sr-only">(current)</span></a>
      </li>      
      
      <li class="nav-item">
       	<a class="nav-link" href="${pageContext.request.contextPath}/admin/product/list">Ürünler</a>
      </li>
      <li class="nav-item">
      	<a class="nav-link" href="${pageContext.request.contextPath}/admin/customer/list">Müşteriler</a>
     	</li>
     	<li class="nav-item">
      	<a class="nav-link" href="${pageContext.request.contextPath}/admin/order/list">Siparişler</a>
     	</li>
    </ul>
    
  </div>
</nav>
    </header>
	<main role="main">
		<div class="container" style="margin-top: 15px;">
		<jsp:doBody/>
		</div>
	</main>
</body>
</html>