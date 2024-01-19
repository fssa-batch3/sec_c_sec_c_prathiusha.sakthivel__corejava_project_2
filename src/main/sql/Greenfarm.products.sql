--use greenfarm;
--SELECT * FROM greenfarm.product;
--
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
--

--insert into  product(ProductName,ProductImageUrl,ProductPrice,ProductQuantity,ProductPercentage,ProductDescription,ProductCategory,ProductCreatedDate)
--values 
--("FreshorganicTomato","https://iili.io/HyRNkxf.jpg",20,2,50,'It is good in vitamins and proteins',"vegetables","2023-07-22" ),
--("FreshorganicBeetroot","https://iili.io/HyROWLx.jpg",45,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicPotato","https://iili.io/HyRve7S.jpg",30,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicKohlrabi","https://iili.io/HyR83vI.jpg",28,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicBrinjal","https://iili.io/HyR8YZu.jpg",30,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicBittergourd","https://iili.io/Hy0Q6eS.jpg",45,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicBroadbeans","https://iili.io/Hy0Qbrx.jpg",50,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicBeans","https://iili.io/Hy0Zqrv.jpg",35,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicCabbage","https://iili.io/Hy0ZThX.png",25,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicBrocholi","https://iili.io/Hy0ZcYl.jpg",85,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicCarrot","https://iili.io/Hy0ZSZF.jpg",65,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" ),
--("FreshorganicRaddish","https://iili.io/Hy0Zy6G.jpg",55,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" );

---- serching a product
---- select * from Product where ProductPrice Between 20 AND 30;

--select * from product;

--desc product;

--deleting a product
--DELETE FROM Product WHERE ProductName = "FreshorganicRaddish" AND ProductId =12; 

--adding a product
---- insert into Product(ProductName, ProductImageUrl, ProductPrice, ProductQuantity, ProductPercentage, ProductDescription, ProductCategory, ProductCreatedDate) 
---- value
---- ("FreshorganicRaddish","https://iili.io/Hy0Zy6G.jpg",55,1,50,'It is good in vitamins and proteins',"vegetables","2023-07-20" );