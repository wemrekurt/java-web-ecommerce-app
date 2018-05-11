<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="jspCommerce">
<div class="">
		<hr class="hr-text" data-content="Tüm Ürünler" />
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
</z:layout>