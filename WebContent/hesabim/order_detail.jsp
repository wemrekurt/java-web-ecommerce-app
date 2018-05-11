<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Hesap">
	<div class="row">
		<div class="col-md-4">
			<hr class="hr-text" data-content="HIZLI MENÜ"/>
			<div class="list-group">
			  <a href="${pageContext.request.contextPath}/hesap" class="list-group-item list-group-item-action">
			    Hesabım
			  </a>
			  <a href="${pageContext.request.contextPath}/hesabim/siparisler" class="list-group-item list-group-item-action active">Siparişlerim</a>
			  <button type="button" class="list-group-item list-group-item-action">Adreslerim</button>
			</div>
		</div>
		
		<div class="col-md-8">
			<hr class="hr-text" data-content="Sipariş: #${order.num}${order.id} (${order.showState()})"/>	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">Ürün Adı</th>
			      <th scope="col">Fiyat</th>
			      <th scope="col">Adet</th>
			      <th scope="col">Toplam</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach var="orp" items="${order_products}">
						<tr>
				      <th scope="row">${orp.product.name}</th>
				      <td>${orp.unit_price} TL</td>
				      <td>${orp.size}</td>
				      <td>${orp.unit_price * orp.size} TL</td>
				      
				    </tr>
					</c:forEach>
			    <tr>
			    	<td colspan="2"></td>
				      <td>Genel Toplam:</td>
				      <td>${order.total} TL</td>
				      
				    </tr>
			  </tbody>
			</table>
						
				
			
		</div>
	</div>

</z:layout>