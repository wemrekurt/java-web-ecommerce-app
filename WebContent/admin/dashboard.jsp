<%@ taglib prefix="z" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Yönetim Paneli">
	<div class="row">
		<div class="col-md-3">
			<a href="${pageContext.request.contextPath}/admin/product/list" class="btn btn-danger btn-lg btn-block" role="button">
				<i style="font-size: 3em;" class="fa fa-list"></i>
				<br>
				${productSize} Ürün
			</a>
		</div>
		<div class="col-md-3">
			<a href="${pageContext.request.contextPath}/admin/customer/list" class="btn btn-warning btn-lg btn-block" role="button">
				<i style="font-size: 3em;" class="fa fa-users"></i>
				<br>
				${customerSize} Müşteri
			</a>
		</div>
		<div class="col-md-3">
			<a href="${pageContext.request.contextPath}/admin/order/list" class="btn btn-info btn-lg btn-block" role="button">
				<i style="font-size: 3em;" class="fa fa-shopping-basket"></i>
				<br>
				${orderSize} Sipariş
			</a>
		</div>
	</div>

</z:layout>	