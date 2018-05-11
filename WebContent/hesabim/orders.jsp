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
			<hr class="hr-text" data-content="SİPARİŞLER"/>	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">Sipariş No</th>
			      <th scope="col">Tarih</th>
			      <th scope="col">Sipariş Durumu</th>
			      <th scope="col">Toplam</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach var="order" items="${orders}">
						<tr>
				      <th scope="row">#${order.num}${order.id}</th>
				      <td>${order.date}</td>
				      <td>${order.showState()}</td>
				      <td>${order.total} TL</td>
				    </tr>
					</c:forEach>
			    
			  </tbody>
			</table>
						
				
			
		</div>
	</div>

</z:layout>