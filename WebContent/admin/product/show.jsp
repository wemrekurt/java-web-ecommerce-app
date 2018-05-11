<%@ taglib prefix="z" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<z:layout pageTitle="${product.name}">
	<form action="upload?id=${product.id}" method="post" enctype = "multipart/form-data">
		<input type="file" name="image" />
		<input type="submit" value="Yükle" class="btn btn-warning" />
	</form>
</z:layout>