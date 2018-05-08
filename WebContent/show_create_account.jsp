<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Hesap Oluştur">
	
	<div class="row" style="margin-top:10px;">
		<div class="col-md-4 offset-md-4">
			<c:if test="${show_error}">
				<div class="alert alert-danger" role="alert">
				  ${error}
				</div>
			</c:if>
			<h3 style="text-align: center;">Hesap Oluştur</h3>
			<hr />
			<form method="post" action="./create-account">
				<h5>Giriş Bilgileri</h5>
				<div class="form-group">
			    <input type="email" value="<c:out value='${email}' />" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="E-posta" required>
			    <small id="emailHelp" class="form-text text-muted">Giriş yapmanız için bir e-posta belirtin.</small>
			  </div>
			  <div class="form-group">
			    <input type="password" name="password" class="form-control" id="InputPassword1" placeholder="Parolanız" required>
			  </div>
			  <div class="form-group">
			    <input type="password" name="password_confirmation" class="form-control" id="InputPassword2" placeholder="Parola Doğrulama" required>
			  </div>
			  <hr />
			  <h5>Kişisel Bilgiler</h5>
			  <div class="form-group">
		  		<div class="form-group">
				    <input type="text" name="name" value="<c:out value='${name}' />" class="form-control"  placeholder="İsim Soyisim" required>
				  </div>
				  <div class="form-group">
				    <input type="date" name="birthday" value="<c:out value='${birthday}' />" class="form-control"  placeholder="Doğum Tarihi">
				  </div>
				  
				  <div class="form-group">
				  	<input type="submit" value="Hesabımı Oluştur" class="btn btn-block btn-lg btn-info" />
				  </div>

				  <div class="form-group">
				  	<hr class="hr-text" data-content="VEYA">
				  	<p style="text-align:center;">
				  		<a href="./giris-yap">Giriş Yap</a>
			  		</p>
				  </div>
				  
			  </div>
			</form>
		</div>
	</div>
</z:layout>