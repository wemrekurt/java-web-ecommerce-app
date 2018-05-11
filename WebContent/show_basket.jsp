<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Sepet">
	<c:if test="${general == 0}">
		<div class="row">
			<div class="col-4 offset-md-4" style="text-align: center;">
				<i class="fa fa-frown" style="color: #844c17; font-size: 15em"></i>
			</div>
		</div>
		
		<div class="row">
			<div class="col-8 offset-md-2" style="text-align:center;">
					<h2>Sepetiniz Boş</h2>
			</div>
		</div>
	</c:if>
	<c:if test="${general > 0}">
		<div class="row">
			<div class="col-12">
				<hr class="hr-text" data-content="SEPETİNİZ">
			</div>
			
			<div class="col-12">
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Ürün</th>
				      <th scope="col">Birim Fiyatı</th>
				      <th scope="col">Adet</th>
				      <th scope="col">Toplam Fiyat</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				  	<c:forEach var="item" items="${basket}">		
					    <tr>
					      <td>${item.getProduct().getName()}</td>
					      <td>${item.product.price} TL</td>
					      <td>x ${item.qty}</td>
					      <td>${item.qty * item.product.price} TL</td>
					    </tr>
				    </c:forEach>
				    
				    <tr>
				    	<td colspan="2"></td>
				    	<td>Genel Toplam</td>
				    	<td>${general} TL</td>
				    </tr>			    
				  </tbody>
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col-3">
				<a class="btn btn-warning" href="./">
					<i class="fa fa-arrow-circle-left"></i>
					Alışverişe Devam Et
				</a>
			</div>
			<div class="col-3 offset-md-6">
				<c:if test="${!user_signed_in}">
					<a class="btn btn-info" data-toggle="modal" data-target="#exampleModal">
						Giriş Yap ve Sipariş Ver
						<i class="fa fa-arrow-circle-right"></i>
					</a>			
				</c:if>
				
				<c:if test="${user_signed_in}">
					<form method="post" action="./siparis-olustur">
					<input type="hidden" name="total" value="${general}" />
						<button class="btn btn-success" type="submit">
							Sipariş Oluştur
							<i class="fa fa-arrow-circle-right"></i>
						</button>
					</form>
				</c:if>
				
			</div>
		</div>
		
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Giriş Yap</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form method="post" action="./giris?return=sepet">
							<div class="form-group">
							    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="E-posta" required>
							    <small id="emailHelp" class="form-text text-muted">Giriş yapmanız için bir e-posta belirtin.</small>
							  </div>
							  <div class="form-group">
							    <input type="password" name="password" class="form-control" id="InputPassword1" placeholder="Parolanız" required>
							  </div>
							  <div class="form-group">
							  	<input type="submit" value="Giriş Yap" class="btn btn-block btn-lg btn-info" />
							  </div>
							  <div class="form-group">
							  	<hr class="hr-text" data-content="VEYA">
							  	<p style="text-align:center;">
							  		<a href="./hesap-olustur">Kayıt Ol</a>
						  		</p>
							  </div>
						</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">İptal</button>
		      </div>
		    </div>
		  </div>
		</div>
	</c:if>
</z:layout>