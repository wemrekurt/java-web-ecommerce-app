<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<z:layout pageTitle="Ürünler">
	<div class="row">
	 	<c:forEach var="product" items="${listProduct}">
	 		<div class="col-md-3">
				<div class="card">
				  <img class="card-img-top" src="https://vignette.wikia.nocookie.net/roblox-phantom-forces/images/7/7c/Noimage.png/revision/latest?cb=20171115203949" alt="Card image cap">
				  <div class="card-body">
				    <h5 class="card-title">${product.name}</h5>
				    <p class="card-text">${fn:substring(product.description, 0, 50)}...</p>
				    <a href="show?id=<c:out value='${product.id}' />" class="btn btn-primary">İncele</a>
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>

</z:layout>