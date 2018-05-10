<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="${product.getName()}">
	<div class="row">
		<div class="col-4">
		Ürün Fotoğrafı
		</div>
		<div class="col-8">
		
			<h2>${product.getName()}</h2>
			<hr class="hr-text" data-content="Ürün Bilgileri">
			<form id="add_basket" method="post" action="./sepete-ekle">
				<input type="hidden" name="product_id" value="${product.id}" />
				<div class="row">
					<div class="col-4">
						<p>Fiyat: <b>${product.getPrice()} TL</b></p>
					</div>
					<div class="col-2">		
						<input type="number" name="qty" class="form-control" min="1" value="1" required />
					</div>
					<div class="col-6">
						<button id="basket_button" type="submit" class="btn btn-info">Sepete Ekle</button>
					</div>
				</div>
			</form>
			<hr class="hr-text" data-content="Ürün Açıklaması">
			<p>${product.getDescription()}</p>
		</div>
	</div>
	
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ürün Sepete Eklendi</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Ürün başarıyla sepete eklendi. Dilerseniz alışverişe devam edebilir, dilerseniz sepete gidebilirsiniz.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Alışverişe Devam et</button>
        <a href="./sepet" type="button" class="btn btn-primary">Sepete Git</a>
      </div>
    </div>
  </div>
</div>
	
</z:layout>