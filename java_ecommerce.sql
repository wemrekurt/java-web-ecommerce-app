-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost:3306
-- Üretim Zamanı: 11 May 2018, 21:16:19
-- Sunucu sürümü: 5.7.22-0ubuntu18.04.1
-- PHP Sürümü: 5.6.36-1+ubuntu17.10.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `java_ecommerce`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `addresses`
--

CREATE TABLE `addresses` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` text NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `town` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `tckn` varchar(11) DEFAULT NULL,
  `tax_dep` varchar(100) DEFAULT NULL,
  `tax_num` varchar(100) DEFAULT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `addresses`
--

INSERT INTO `addresses` (`id`, `name`, `address`, `city`, `town`, `phone`, `tckn`, `tax_dep`, `tax_num`, `customer_id`) VALUES
(1, 'Ev', 'Tabakhane Mh. Kiraz Sk. No:6/2', 'SAMSUN', 'BAFRA', '05444059964', '1111111111', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `birthday` date DEFAULT NULL,
  `auth_key` varchar(150) DEFAULT NULL,
  `role` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `customers`
--

INSERT INTO `customers` (`id`, `name`, `email`, `password`, `birthday`, `auth_key`, `role`) VALUES
(1, 'Emre KURT', 'w.emre.kurt@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '1993-05-07', '04eb7ca1e3f6a1f0d264e5206e386688', 2),
(9, 'Emre KURT', 'test@test.com', '4297f44b13955235245b2497399d7a93', NULL, '22781293bd688d958f3be27e4c26d2c3', 1),
(10, 'Rumeysa Nur', 'nur.uslu@bil.omu.edu.tr', '4297f44b13955235245b2497399d7a93', NULL, 'c638560007237f3ef20f6759c3e2dc95', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `num` varchar(50) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total` decimal(8,2) DEFAULT NULL,
  `address_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `orders`
--

INSERT INTO `orders` (`id`, `num`, `date`, `total`, `address_id`, `customer_id`, `status`) VALUES
(1, '20180507001', '2018-05-07 00:00:00', '1250.00', 1, 1, 3),
(2, '20180511', '2018-05-11 11:11:15', '6626.00', 1, 1, 1),
(3, '20180511', '2018-05-11 11:29:39', '41.00', 1, 1, 1),
(4, '20180511', '2018-05-11 14:55:01', '39100.00', 1, 1, 2),
(5, '20180511', '2018-05-11 14:56:18', '82.00', 1, 10, 1),
(6, '20180511', '2018-05-11 17:50:32', '13006.00', 1, 1, 1),
(7, '20180511', '2018-05-11 17:52:49', '205.00', 1, 1, 1),
(8, '20180511', '2018-05-11 17:58:57', '6503.00', 1, 1, 1),
(9, '20180511', '2018-05-11 21:14:13', '6585.00', 1, 1, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `order_products`
--

CREATE TABLE `order_products` (
  `id` int(11) NOT NULL,
  `size` int(11) DEFAULT NULL,
  `unit_price` decimal(12,2) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `order_products`
--

INSERT INTO `order_products` (`id`, `size`, `unit_price`, `product_id`, `order_id`) VALUES
(1, 1, '41.00', 2, 3),
(2, 6, '6503.00', 1, 4),
(3, 2, '41.00', 2, 4),
(4, 2, '41.00', 2, 5),
(5, 2, '6503.00', 1, 6),
(6, 5, '41.00', 2, 7),
(7, 1, '6503.00', 1, 8),
(8, 1, '6503.00', 1, 9),
(9, 2, '41.00', 2, 9);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `description` text,
  `image` varchar(250) DEFAULT NULL,
  `sef_link` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `description`, `image`, `sef_link`) VALUES
(1, 'Macbook Pro', '6503.00', 'Retina ekran awa wgawg aw', '', 'macbook-pro'),
(2, 'Başka bir ürün', '41.00', 'açıklama', '', NULL);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `addresses`
--
ALTER TABLE `addresses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Tablo için indeksler `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `address_id` (`address_id`);

--
-- Tablo için indeksler `order_products`
--
ALTER TABLE `order_products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Tablo için indeksler `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `addresses`
--
ALTER TABLE `addresses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT değeri `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Tablo için AUTO_INCREMENT değeri `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Tablo için AUTO_INCREMENT değeri `order_products`
--
ALTER TABLE `order_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Tablo için AUTO_INCREMENT değeri `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `addresses`
--
ALTER TABLE `addresses`
  ADD CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);

--
-- Tablo kısıtlamaları `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`);

--
-- Tablo kısıtlamaları `order_products`
--
ALTER TABLE `order_products`
  ADD CONSTRAINT `order_products_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `order_products_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
