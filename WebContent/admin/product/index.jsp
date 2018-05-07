<%@ taglib prefix="z" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Ürün Listesi">
	<div class="row">
		<div class="col-md-8"><h3>Ürün listesi</h3></div>
		<div class="col-md-4" style="text-align:right"><a href="./new" class="btn btn-success">Yeni Ekle <i class="fa fa-plus"></i></a></div>
		<div class="col-md-12"><hr /></div>
	</div>
	<table id="dataTable" class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Ürün Adı</th>
            <th>Fiyat</th>
            <th>#</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach var="product" items="${listProduct}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
            <a href="./edit?id=<c:out value='${product.id}' />" class="btn btn-warning"><i class="fa fa-edit"></i></a>
            <a href="./delete?id=<c:out value='${product.id}' />" class="btn btn-danger" onclick="return confirm('Silmek istediğinize emin misiniz?')" ><i class="fa fa-trash"></i></a>
            </td>
        </tr>
       </c:forEach>
    </tbody>
</table>
	
</z:layout>