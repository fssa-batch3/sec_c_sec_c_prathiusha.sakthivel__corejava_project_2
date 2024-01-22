--1.Product Table
--CREATE TABLE product (
--    ProductId int AUTO_INCREMENT PRIMARY KEY,
--    ProductName varchar(50) NOT NULL,
--    ProductImageUrl varchar(255) NOT NULL,
--    ProductPrice double NOT NULL,
--    ProductQuantity double NOT NULL,
--    ProductPercentage int CHECK (ProductPercentage >= 0 AND ProductPercentage <= 100),
--    ProductDescription varchar(600) NOT NULL,
--    ProductCategory varchar(10) NOT NULL,
--    ProductCreatedDate date NOT NULL
--);



--2.User Table
--CREATE TABLE `User` (
--  `user_id` int NOT NULL AUTO_INCREMENT,
--  `firstname` varchar(255) NOT NULL,
--  `lastname` varchar(255) NOT NULL,
--  `email_id` varchar(255) NOT NULL,
--  `password` varchar(255) NOT NULL,
--  `city` varchar(50) DEFAULT NULL,
--  `state` varchar(30) DEFAULT NULL,
--  `address` varchar(300) DEFAULT NULL,
--  `pincode` int DEFAULT NULL,
--  `mobilenumber` mediumtext,
--  `is_active` tinyint(1) DEFAULT '1',
--  PRIMARY KEY (`user_id`),
--  UNIQUE KEY `email_id` (`email_id`)
--) 



--3.OrderDetails Table
--CREATE TABLE `OrderDetails` (
--  `order_id` int NOT NULL AUTO_INCREMENT,
--  `user_id` int DEFAULT NULL,
--  `address` varchar(300) DEFAULT NULL,
--  `city` varchar(50) DEFAULT NULL,
--  `state` varchar(50) DEFAULT NULL,
--  `pincode` char(7) DEFAULT NULL,
--  `mobile_number` char(10) DEFAULT NULL,
--  `payment_method` varchar(50) DEFAULT NULL,
--  `orderdate` date NOT NULL,
--  PRIMARY KEY (`order_id`)
--)



--4.OrderedProduct Table
--CREATE TABLE `OrderedProduct` (
--  `order_id` int DEFAULT NULL,
--  `productId` int DEFAULT NULL,
--  `productName` varchar(50) DEFAULT NULL,
--  `productPrice` double DEFAULT NULL,
--  `productQuantity` double DEFAULT NULL,
--  `productTotalAmount` double DEFAULT NULL,
--  `status` tinyint(1) DEFAULT '1'
--) 



--5.CartItems Table
--CREATE TABLE `CartItems` (
--  `cart_id` int NOT NULL AUTO_INCREMENT,
--  `user_id` int NOT NULL,
--  `product_id` int NOT NULL,
--  `totalprice` float NOT NULL,
--  `quantity` float NOT NULL,
--  `status` int DEFAULT '1',
--  PRIMARY KEY (`cart_id`),
--  UNIQUE KEY `cart_id_UNIQUE` (`cart_id`),
--  UNIQUE KEY `product_id_UNIQUE` (`product_id`),
--  KEY `CartItems_ibfk_1` (`user_id`),
--  CONSTRAINT `CartItems_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
--)