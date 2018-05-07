<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="${product.getName()}">
	<div class="row">
		<div class="col-md-4">
		Ürün Fotoğrafı
		</div>
		<div class="col-md-8">
		<h2>${product.getName()}</h2>
		<hr>
		<p>Fiyat: <b>${product.getPrice()} TL</b></p>
		<p>
			<button type="button" class="btn btn-info">Sepete Ekle</button>
		</p>
		<p>${product.getDescription()}</p>
		</div>
	</div>
</z:layout>