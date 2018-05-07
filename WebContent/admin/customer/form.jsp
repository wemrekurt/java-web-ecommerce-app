<%@ taglib prefix="z" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<z:layout pageTitle="Düzenle: ${customer.name}">

	<c:if test="${product != null}">
		<form action="update" method="post">
	</c:if>
	<c:if test="${product == null}">
		<form action="insert" method="post">
	</c:if>

	<caption>
		<h2>
			<c:if test="${product != null}">
       	Müşteri Düzenle
       </c:if>
			<c:if test="${product == null}">
       	Müşteri Ekle
      	</c:if>
		</h2>
	</caption>
	<c:if test="${customer != null}">
		<input type="hidden" name="id"
			value="<c:out value='${customer.id}' />" />
	</c:if>
	 <div class="form-group">
    <label for="name">Müşteri Adı</label>
    <input type="text" id="name" class="form-control" name="name" placeholder="Müşteri Adı Girin" value="<c:out value='${customer.name}' />">
    <small id="emailHelp" class="form-text text-muted">Müşteri ismi girin.</small>
  </div>
  
  <div class="form-group">
    <label for="email">Müşteri E-posta</label>
    <input type="email" name="email" id="email" class="form-control" value="<c:out value='${customer.email}' />" />
    <small id="emailHelp" class="form-text text-muted">Müşteri e-posta girin.</small>
  </div>
  
	<div class="form-group">
    <label for="password">Parola</label>
    <input type="password" id="password" class="form-control" name="password" value="<c:out value='${customer.password}' />">
  </div>
  <div class="form-group">
    <label for="birthday">Doğum Tarihi</label>
    <input type="date" id="birthday" class="form-control" name="birthday"  value="<c:out value='${customer.birthday}' />">
    <small id="emailHelp" class="form-text text-muted">Müşteri doğum tarihi girin.</small>
  </div>
  <div class="form-group">
  <input type="submit" class="btn btn-info" value="Kaydet" />
  </div>

	</form>
</z:layout>