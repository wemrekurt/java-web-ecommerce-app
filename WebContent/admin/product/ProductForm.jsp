<%@ taglib prefix="z" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<z:layout pageTitle="Düzenle: ${product.name}">

	<c:if test="${product != null}">
		<form action="update" method="post">
	</c:if>
	<c:if test="${product == null}">
		<form action="insert" method="post">
	</c:if>

	<caption>
		<h2>
			<c:if test="${product != null}">
       	Ürünü Düzenle
       </c:if>
			<c:if test="${product == null}">
       	Yeni Ürün Ekle
      	</c:if>
		</h2>
	</caption>
	<c:if test="${product != null}">
		<input type="hidden" name="id"
			value="<c:out value='${product.id}' />" />
	</c:if>
	 <div class="form-group">
    <label for="name">Ürün Adı</label>
    <input type="text" id="name" class="form-control" name="name" placeholder="Ürün Adı Girin" value="<c:out value='${product.name}' />">
    <small id="emailHelp" class="form-text text-muted">Ürününüz için açıklayıcı bir isim girin.</small>
  </div>
  
  <div class="form-group">
    <label for="description">Ürün Açıklaması</label>
    <textarea name="description" id="description" class="form-control"><c:out value='${product.description}' /></textarea>
    <small id="emailHelp" class="form-text text-muted">Ürününüz için bir açıklama girin.</small>
  </div>
  
	<div class="form-group">
    <label for="price">Ürün Fiyatı</label>
    <input type="number" id="price" class="form-control" name="price" value="<c:out value='${product.price}' />">
  </div>
  <div class="form-group">
  <input type="submit" class="btn btn-info" value="Kaydet" />
  </div>

	</form>
</z:layout>