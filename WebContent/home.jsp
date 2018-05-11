<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="jspCommerce">
	<div class="row">
		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		  </ol>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="https://images.hepsiburada.net/assets/storefront/banners/11-05-2018_1526020270746_1.png" alt="First slide">
		      <div class="carousel-caption d-none d-md-block">
		      	<h5>Büyük İndirim</h5>
    				<p>Bu Fırsatı Kaçırmayın</p>
   				</div>
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="https://images.hepsiburada.net/assets/storefront/banners/24-04-2018_1525697096190_1.png" alt="Second slide">
		      
		      <div class="carousel-caption d-none d-md-block">
		      	<h5>Telefon Almanın Vakti</h5>
    				<p>Sabit kur fırsatı!</p>
   				</div>
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="https://images.hepsiburada.net/assets/storefront/banners/11-05-2018_1525854164904_1.png" alt="Third slide">
		      <div class="carousel-caption d-none d-md-block">
		      	<h5>Akıllı Ev Aletleri</h5>
    				<p>Tıklayın, keşfedin</p>
   				</div>
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	</div>
	
	<div class="">
		<hr class="hr-text" data-content="Öne Çıkan Ürünler" />
	</div>

	<div class="row">
	 	<c:forEach var="product" items="${products}">
	 		<div class="col-2">
				<div class="card">
				  <img class="card-img-top" src="uploads/${product.id}.png" style="padding: 5px;" >
				  <div class="card-body">
				    <h5 style="font-size: 13px;" class="card-title">${fn:substring(product.name, 0, 20)}</h5>
				    <a href="urun?id=<c:out value='${product.id}' />" class="btn btn-primary btn-block">İncele</a>
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<div class="">
		<hr class="hr-text" data-content="Fırsatlar" />
	</div>
	
	<div class="row">
		<div class="col-6">
			<img src="images/sl1.png" class="img-fluid"/>
		</div>
		<div class="col-6">
			<img src="images/sl2.png" class="img-fluid"/>
		</div>
	</div>

</z:layout>