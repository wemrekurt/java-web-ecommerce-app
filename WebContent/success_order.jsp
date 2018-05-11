<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<z:layout pageTitle="Sipariş Kayıt Edildi">
		<div class="row">
			<div class="col-4 offset-md-4" style="text-align: center;">
				<i class="fa fa-check-circle" style="color: #55a00b; font-size: 15em"></i>
			</div>
		</div>
		
		<div class="row">
			<div class="col-8 offset-md-2" style="text-align:center;">
					<h2>Siparişiniz kayıt edildi!</h2>
					<h3>Sipariş Numaranız: #${order_num}</h3>
					<p>Şimdi <a href="./hesap">Hesabınız</a>a giderek siparişinizi görebilirsiniz.</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-8 offset-md-2" style="text-align:center;">
				<hr class="hr-text" data-content="DİKKAT!" />
				Siparişinizin onaylanması için lütfen aşağıdaki banka hesabımıza #${order_num} açıklaması ile
				sipariş tutarını gönderiniz.
				<br />
				Ödenecek Tutar: <b>${total} TL</b>
			</div>
		</div>
		
		<div class="row">
			<div class="col-8 offset-md-2" style="text-align:center;">
				<hr class="hr-text" data-content="HESAP NUMARAMIZ" />
				T. İş Bankası
				<br />
				Şube Kodu: 7320
				<br />
				Hesap No: 0997761
				<br />
				IBAN: TR6000000562406073200997761
			</div>
		</div>
</z:layout>