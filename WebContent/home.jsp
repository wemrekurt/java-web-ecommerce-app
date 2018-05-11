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
		      <img class="d-block w-100" src="https://www.butikerva.com.tr/img/blockslideshow/1.jpg" alt="First slide">
		      <div class="carousel-caption d-none d-md-block">
		      	<h5>Başlık</h5>
    				<p>İçerik</p>
   				</div>
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="https://www.butikerva.com.tr/img/blockslideshow/2.jpg" alt="Second slide">
		      
		      <div class="carousel-caption d-none d-md-block">
		      	<h5>Başlık</h5>
    				<p>İçerik</p>
   				</div>
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="https://www.butikerva.com.tr/img/blockslideshow/3.jpg" alt="Third slide">
		      <div class="carousel-caption d-none d-md-block">
		      	<h5>Başlık</h5>
    				<p>İçerik</p>
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
		<hr />
	</div>

	<div class="row">
	 	<c:forEach var="product" items="${products}">
	 		<div class="col-3">
				<div class="card">
				  <img class="card-img-top" src="uploads/${product.id}.png" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">${product.name}</h5>
				    <p class="card-text">${fn:substring(product.description, 0, 50)}...</p>
				    <a href="urun?id=<c:out value='${product.id}' />" class="btn btn-primary">İncele</a>
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>

</z:layout>