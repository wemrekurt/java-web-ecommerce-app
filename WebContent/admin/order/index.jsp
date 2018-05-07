<%@ taglib prefix="z" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Siparişler">
	<div class="row">
		<div class="col-md-12"><h3>Sipariş Listesi</h3></div>
	</div>
	<table id="dataTable" class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Sipariş No</th>
            <th>Miktar</th>
            <th>Durum</th>
            <th>Müşteri</th>
            <th>#</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.num}</td>
            <td>${order.total} TL</td>
            <td>${order.showState()}</td>
            <td>${order.getCustomer().name}</td>
            <td>
            	<a href="./show?id=<c:out value='${order.id}' />" class="btn btn-success">
	            	<i class="fa fa-eye"></i>
            	</a>
	            <a href="./edit?id=<c:out value='${order.id}' />" class="btn btn-warning">
	            	<i class="fa fa-edit"></i>
            	</a>
	            <a href="./delete?id=<c:out value='${order.id}' />" class="btn btn-danger" onclick="return confirm('Silmek istediğinize emin misiniz?')" >
	            	<i class="fa fa-trash"></i>
            	</a>
            </td>
        </tr>
       </c:forEach>
    </tbody>
</table>
	
</z:layout>