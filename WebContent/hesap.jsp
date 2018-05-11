<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Hesap">
	<div class="row">
		<div class="col-md-4">
			<hr class="hr-text" data-content="HIZLI MENÜ"/>
			<div class="list-group">
			  <a href="./hesap" class="list-group-item list-group-item-action active">
			    Hesabım
			  </a>
			  <a href="./hesabim/siparisler" class="list-group-item list-group-item-action">Siparişlerim</a>
			  <button type="button" class="list-group-item list-group-item-action">Adreslerim</button>
			</div>
		</div>
		
		<div class="col-md-8">
			<hr class="hr-text" data-content="HESABIM"/>	
			Merhaba ${user.name},
			<br />
			<small>
				"Hesabım" sayfasından siparişlerinizi ve arıza/iade/değişim işlemlerinizi takip edebilir; kazandığınız hediye çeki ve puanları görüntüleyebilir; üyelik bilgisi güncelleme, şifre ve adres değişikliği gibi hesap ayarlarınızı kolayca yapabilirsiniz.
				Size özel fırsatlar ve dönemsel kampanyalar da bu sayfada duyurulur.
			</small>
			<hr class="hr-text" data-content="BİLGİLERİM"/>
			
			
		</div>
	</div>

</z:layout>