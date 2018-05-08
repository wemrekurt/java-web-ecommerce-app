<%@ taglib prefix="z" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Sipariş: #${order.num}">
	<c:if test="${updateCookie.length() > 0}">
		<div class="row">		
			<div class="alert alert-success" role="alert">
			  İşlem başarılı.
			</div>
		</div>
	</c:if>
	<div class="row">
			<div class="col-md-8">
				<h3>Sipariş: #${order.num}</h3>
			</div>
			<div class="col-md-4" style="text-align: center;">
				<b>${order.date}</b>
			</div>
			<div class="col-md-12">
				<hr />
			</div>
	</div>
	
	<div class="row">
		<div class="col-md-6">
			<form method="post" action="./chstate" >
				<input type="hidden" name="id" value="${order.id}" />
				<div class="form-group">
		      <label for="inputState">Sipariş Durumu</label>
		      <select id="inputState" name="state" class="form-control">
			      <c:forEach var="status" items="${states}">
							<option <c:if test="${order.state == status.getKey()}">selected</c:if> value="${status.getKey()}">${status.getValue()}</option>
						</c:forEach>
		      </select>
		    </div>
		    
		    <div class="form-group">
		    	<input type="submit" value="Güncelle" class="btn btn-success" />
		    </div>
				
				
			</form>
		</div>
	</div>
	
</z:layout>