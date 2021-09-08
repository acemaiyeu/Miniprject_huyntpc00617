-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: website_huyntpc00617
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `username` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('Admin','Nguyễn Thành Huy 1','nthanhhuy823@gmail.com','','Ô Môn','2021-04-02','Cần Thơ',_binary '','123'),('Pm','Phan Thế Nghĩa','pthenghia82@gmail.com','','Ô Môn','2021-10-18','Cần Thơ',_binary '','123'),('User','Nguyễn Ngọc Hải ','nngochai82@gmail.com','','Ô Môn','2021-06-14','Cần Thơ',_binary '','123');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth`
--

DROP TABLE IF EXISTS `auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth` (
  `authid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(12) DEFAULT NULL,
  `authsid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`authid`),
  UNIQUE KEY `username` (`username`,`authsid`),
  KEY `authsid` (`authsid`),
  CONSTRAINT `auth_ibfk_1` FOREIGN KEY (`username`) REFERENCES `accounts` (`username`),
  CONSTRAINT `auth_ibfk_2` FOREIGN KEY (`authsid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth`
--

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` VALUES (4,NULL,'PM'),(5,NULL,'PM'),(6,NULL,'PM'),(1,'Admin','ADMIN'),(14,'Admin','PM'),(3,'Pm','PM'),(2,'User','USER');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brandid` int NOT NULL AUTO_INCREMENT,
  `brandname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`brandid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Oppo'),(2,'Apple'),(3,'Samsung');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `categoryid` varchar(10) NOT NULL,
  `categoryname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('JAVA','JAVAPHONE'),('SMART','SMARTPHONE');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colors` (
  `colorid` int NOT NULL AUTO_INCREMENT,
  `productid` int DEFAULT NULL,
  `colorsid` varchar(10) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`colorid`),
  KEY `productid` (`productid`),
  KEY `colorsid` (`colorsid`),
  CONSTRAINT `colors_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `colors_ibfk_2` FOREIGN KEY (`colorsid`) REFERENCES `colorsdetails` (`colorid`)
) ENGINE=InnoDB AUTO_INCREMENT=4139 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` VALUES (1,1,'Black',_binary ''),(2,1,'Aurora',_binary ''),(3,1,'Blue',_binary ''),(4089,46,'Black',NULL),(4090,46,'BB',NULL),(4091,47,'Pink',NULL),(4094,49,'Black',NULL),(4095,50,'BB',NULL),(4096,51,'Black',NULL),(4097,51,'Gray',NULL),(4098,49,'Green',NULL),(4103,49,'Orange',NULL),(4105,50,'Yellow',NULL),(4106,49,'Pink',NULL),(4107,49,'Violet',NULL),(4109,46,'Gray',NULL),(4110,55,'Aurora',NULL),(4111,55,'BB',NULL),(4112,55,'Black',NULL),(4114,56,'BB',NULL),(4115,56,'Black',NULL),(4116,56,'Blue',NULL),(4117,56,'Gray',NULL),(4118,56,'Green',NULL),(4119,56,'Orange',NULL),(4122,56,'Violet',NULL),(4123,56,'Red',NULL),(4124,56,'Pink',NULL),(4126,57,'BB',NULL),(4127,57,'Black',NULL),(4128,57,'Blue',NULL),(4129,57,'Gray',NULL),(4130,57,'Green',NULL),(4131,57,'Orange',NULL),(4132,57,'YG',NULL),(4133,57,'Yellow',NULL),(4138,57,'Aurora',NULL);
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colorsdetails`
--

DROP TABLE IF EXISTS `colorsdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colorsdetails` (
  `colorid` varchar(10) NOT NULL,
  `colorname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`colorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colorsdetails`
--

LOCK TABLES `colorsdetails` WRITE;
/*!40000 ALTER TABLE `colorsdetails` DISABLE KEYS */;
INSERT INTO `colorsdetails` VALUES ('Aurora','Aurora'),('BB','BlueBlack'),('Black','Black'),('Blue','Blue'),('Gray','Gray'),('Green','Green'),('Orange','Orange'),('Pink','Pink'),('Red','Red'),('Violet','Violet'),('Yellow','Yellow'),('YG','YellowGreen');
/*!40000 ALTER TABLE `colorsdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `code` varchar(55) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('CT1','83 Trần Hưng Đạo','đối diện công an'),('CT2','83 Nguyễn Hồng Phong','đối diện công an'),('CT3','83 Lý Từ Thất','đối diện công an');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_sub`
--

DROP TABLE IF EXISTS `company_sub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_sub` (
  `code` varchar(55) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `codecompany` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `codecompany` (`codecompany`),
  CONSTRAINT `company_sub_ibfk_1` FOREIGN KEY (`codecompany`) REFERENCES `company` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_sub`
--

LOCK TABLES `company_sub` WRITE;
/*!40000 ALTER TABLE `company_sub` DISABLE KEYS */;
INSERT INTO `company_sub` VALUES ('CS1','93 Lý Từ Thất','','CT1'),('CS2','103 Lý Từ Thất','','CT1'),('CS3','82 Lý Từ Thất','','CT1'),('CS4','92 Cách Mạng Tháng 8','','CT2'),('CS5','102 30 Tháng 4','','CT2'),('CS6','72 3 Tháng 2','','CT2'),('CS7','132 Bà Huyện Thanh Quan','','CT3'),('CS8','164 Trần Hưng Đạo','','CT3'),('CS9','123 Nguyễn Trãi','','CT3');
/*!40000 ALTER TABLE `company_sub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_sub_sub`
--

DROP TABLE IF EXISTS `company_sub_sub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_sub_sub` (
  `code` varchar(55) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `codecompany_sub` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `codecompany_sub` (`codecompany_sub`),
  CONSTRAINT `company_sub_sub_ibfk_1` FOREIGN KEY (`codecompany_sub`) REFERENCES `company_sub` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_sub_sub`
--

LOCK TABLES `company_sub_sub` WRITE;
/*!40000 ALTER TABLE `company_sub_sub` DISABLE KEYS */;
INSERT INTO `company_sub_sub` VALUES ('CSS1','93 Tú Mỡ','','CS1'),('CSS10','35 Lê Lợi','','CS5'),('CSS11','123 Lê Hồng Phong','','CS6'),('CSS12','41 Tô Hiến Thành','','CS6'),('CSS13','52 Nguyễn Văn Công','','CS7'),('CSS14','83 Nguyễn Văn Đậu','','CS7'),('CSS15','66 Sư Vạn Hạnh','','CS7'),('CSS16','73 Nơ Trang Long','','CS8'),('CSS17','51 Quang Trung','','CS9'),('CSS18','278 Trần Quốc Tuấn','','CS9'),('CSS2','82 Hoàng Kim Giao','','CS1'),('CSS3','23 Lý Thường Kiệt','','CS2'),('CSS4','129 Nguyễn Văn Linh','','CS2'),('CSS5','13 Nguyên Hồng','','CS3'),('CSS6','54 Vĩnh Viễn','','CS3'),('CSS7','25 Nguyễn Thái Sơn','','CS4'),('CSS8','62 Nguyễn Văn Công','','CS4'),('CSS9','32 Bà Hạt','','CS5');
/*!40000 ALTER TABLE `company_sub_sub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descriptions`
--

DROP TABLE IF EXISTS `descriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descriptions` (
  `descriptionid` int NOT NULL AUTO_INCREMENT,
  `brandid` int DEFAULT NULL,
  `modelid` int DEFAULT NULL,
  `internal_memory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `network` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sim_slot` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `waterproof` bit(1) DEFAULT NULL,
  `screen_size` varchar(100) DEFAULT NULL,
  `operating_system` varchar(20) DEFAULT NULL,
  `Ram` varchar(5) DEFAULT NULL,
  `rear_camera` varchar(10) DEFAULT NULL,
  `front_camera` varchar(10) DEFAULT NULL,
  `GPS` bit(1) DEFAULT NULL,
  `Bluetooth` bit(1) DEFAULT NULL,
  `MicroUSB` varchar(20) DEFAULT NULL,
  `the_battery` float DEFAULT NULL,
  `origin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Resolution` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`descriptionid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descriptions`
--

LOCK TABLES `descriptions` WRITE;
/*!40000 ALTER TABLE `descriptions` DISABLE KEYS */;
INSERT INTO `descriptions` VALUES (1,1,17,'128GB','5G','Dual SIM',_binary '','6.55 inches','Android 11','8GB','64 MP','32 MP',_binary '',_binary '','type-C',4500,'China','1080 x 2400 pixels');
/*!40000 ALTER TABLE `descriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `input_product`
--

DROP TABLE IF EXISTS `input_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `input_product` (
  `input_id` int NOT NULL AUTO_INCREMENT,
  `productid` int DEFAULT NULL,
  `unitproduct` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `supplierid` varchar(55) DEFAULT NULL,
  `date_input` date DEFAULT NULL,
  PRIMARY KEY (`input_id`),
  UNIQUE KEY `productid` (`productid`,`date_input`),
  KEY `supplierid` (`supplierid`),
  CONSTRAINT `input_product_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `input_product_ibfk_2` FOREIGN KEY (`supplierid`) REFERENCES `supplier` (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `input_product`
--

LOCK TABLES `input_product` WRITE;
/*!40000 ALTER TABLE `input_product` DISABLE KEYS */;
INSERT INTO `input_product` VALUES (5,1,'chiếc',1000,'DDV','2021-09-01'),(38,46,'Chiếc',1000,'DDGG','2021-09-07'),(39,47,'Chiếc',1000,'DDGG','2021-09-07'),(40,48,'Chiếc',1000,'DDGG','2021-09-07'),(41,49,'Chiếc',1000,'DDGG','2021-09-07'),(42,50,'Chiếc',1000,'DDGG','2021-09-07'),(43,51,'Chiếc',1000,'DDGG','2021-09-07'),(44,52,'Chiếc',1000,'DDGG','2021-09-07'),(47,55,'Chiếc',1000,'DDGG','2021-09-08'),(48,56,'Chiếc',1000,'DDGG','2021-09-08'),(49,57,'Chiếc',1000,'DDGG','2021-09-08');
/*!40000 ALTER TABLE `input_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `modelid` int NOT NULL AUTO_INCREMENT,
  `modelname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`modelid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'Accer Iconia tab 8 Ư W1-810'),(2,'Accer Iconia Tab 8 W W1-810'),(3,'Acer Iconia Talk S A1-734'),(4,'Accer Iconia W3-810'),(5,'Accer Liquid E3'),(6,'Accer Liquid E600'),(7,'Accer liquid M220'),(8,'Accer Liquid S1'),(9,'SM-M326B'),(10,'SM-M326B/DS'),(11,'SM-F127G/DS'),(12,'SM-F127F'),(13,'CPH2249'),(14,'PEPM00'),(15,'PDSM00'),(16,'PDST00'),(17,'CPH2201');
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(12) DEFAULT NULL,
  `OrderDate` date DEFAULT NULL,
  `RequiredDate` date DEFAULT NULL,
  `ShippedDate` date DEFAULT NULL,
  `ShipVia` varchar(12) DEFAULT NULL,
  `ShipAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `City` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `statusorderid` varchar(5) DEFAULT NULL,
  `ShipPostalCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `username` (`username`),
  KEY `statusorderid` (`statusorderid`),
  KEY `ShipVia` (`ShipVia`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`username`) REFERENCES `accounts` (`username`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`statusorderid`) REFERENCES `statusorder` (`id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`ShipVia`) REFERENCES `shipper` (`shiperid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordersdetails`
--

DROP TABLE IF EXISTS `ordersdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordersdetails` (
  `orderdetailsid` int NOT NULL AUTO_INCREMENT,
  `orderid` int DEFAULT NULL,
  `productid` int DEFAULT NULL,
  `unitprice` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`orderdetailsid`),
  UNIQUE KEY `orderid` (`orderid`,`productid`),
  KEY `productid` (`productid`),
  CONSTRAINT `ordersdetails_ibfk_1` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `ordersdetails_ibfk_2` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordersdetails`
--

LOCK TABLES `ordersdetails` WRITE;
/*!40000 ALTER TABLE `ordersdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordersdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordersdetailstemp`
--

DROP TABLE IF EXISTS `ordersdetailstemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordersdetailstemp` (
  `orderdetailsid` int NOT NULL AUTO_INCREMENT,
  `orderid` int DEFAULT NULL,
  `productid` int DEFAULT NULL,
  `unitprice` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `quantity` float DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`orderdetailsid`),
  UNIQUE KEY `orderid` (`orderid`,`productid`),
  KEY `productid` (`productid`),
  CONSTRAINT `ordersdetailstemp_ibfk_1` FOREIGN KEY (`orderid`) REFERENCES `orderstemp` (`orderid`),
  CONSTRAINT `ordersdetailstemp_ibfk_2` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordersdetailstemp`
--

LOCK TABLES `ordersdetailstemp` WRITE;
/*!40000 ALTER TABLE `ordersdetailstemp` DISABLE KEYS */;
INSERT INTO `ordersdetailstemp` VALUES (13,14,1,'chiếc',1,0.2,'2021-09-08',7200000,_binary ''),(14,15,46,'chiếc',1,0.2,'2021-09-08',36000000,_binary ''),(15,16,46,'chiếc',1,0.2,'2021-09-08',36000000,_binary ''),(16,16,47,'chiếc',1,0.2,'2021-09-08',10788000,_binary ''),(17,17,47,'chiếc',2,0.2,'2021-09-08',10788000,_binary '');
/*!40000 ALTER TABLE `ordersdetailstemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderstemp`
--

DROP TABLE IF EXISTS `orderstemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderstemp` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(12) DEFAULT NULL,
  `OrderDate` date DEFAULT NULL,
  `shipAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `requireddate` date DEFAULT NULL,
  `City` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `statusorderid` varchar(5) DEFAULT NULL,
  `ShipPostalCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `username` (`username`),
  KEY `statusorderid` (`statusorderid`),
  CONSTRAINT `orderstemp_ibfk_1` FOREIGN KEY (`username`) REFERENCES `accounts` (`username`),
  CONSTRAINT `orderstemp_ibfk_2` FOREIGN KEY (`statusorderid`) REFERENCES `statusorder` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderstemp`
--

LOCK TABLES `orderstemp` WRITE;
/*!40000 ALTER TABLE `orderstemp` DISABLE KEYS */;
INSERT INTO `orderstemp` VALUES (1,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(2,'Admin','2021-09-08','sv','2021-09-08','sv','CXN',''),(3,'Admin','2021-09-08','sv','2021-09-08','sv','CXN',''),(4,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(5,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(6,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(7,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(8,'Admin','2021-09-08','s','2021-09-08','b','CXN',''),(9,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(10,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(11,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(12,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(13,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(14,'Admin','2021-09-08','d','2021-09-08','b','CXN',''),(15,'Admin','2021-09-08','s','2021-09-08','v','CXN',''),(16,'Admin','2021-09-08','o mon','2021-09-08','can tho','CXN',''),(17,'Admin','2021-09-08','c','2021-09-08','c','CXN','');
/*!40000 ALTER TABLE `orderstemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price` (
  `priceid` int NOT NULL AUTO_INCREMENT,
  `productid` int DEFAULT NULL,
  `Price_input` float DEFAULT NULL,
  `Price_Output_old` float DEFAULT NULL,
  `Price_Output_new` float DEFAULT NULL,
  `date_output` date DEFAULT NULL,
  PRIMARY KEY (`priceid`),
  UNIQUE KEY `productid` (`productid`,`date_output`),
  CONSTRAINT `price_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,1,12000,13000,15000,'2021-09-03'),(2,1,12000,13000,14000,'2021-09-01'),(3,1,12000,13000,16000,'2021-09-04'),(51,1,5000000,6000000,6000000,'2021-09-06'),(52,1,6000000,7200000,7200000,'2021-09-07'),(54,46,25000000,30000000,30000000,'2021-09-07'),(55,47,8990000,10788000,10788000,'2021-09-07'),(56,48,8000000,9600000,9600000,'2021-09-07'),(57,49,40000000,48000000,48000000,'2021-09-07'),(58,50,40000000,48000000,48000000,'2021-09-07'),(59,51,10000000,12000000,12000000,'2021-09-07'),(60,52,5900000,7080000,7080000,'2021-09-07'),(64,46,30000000,36000000,36000000,'2021-09-08'),(65,55,545435000,654522000,654522000,'2021-09-08'),(66,56,3243460,3892150,3892150,'2021-09-08'),(67,57,43434,52120.8,52120.8,'2021-09-08');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productid` int NOT NULL AUTO_INCREMENT,
  `productname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` date DEFAULT NULL,
  `updateedate` date DEFAULT NULL,
  `categoryid` varchar(10) DEFAULT NULL,
  `descriptionid` int DEFAULT NULL,
  `Status` bit(1) DEFAULT NULL,
  `imagename1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imagename2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imagename3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `qty` float DEFAULT NULL,
  `productcol` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Oppo Reno6 Pro 5G','2021-09-01','2021-09-07','SMART',1,_binary '','73ef4471.jpg','3ec504f9.jpg','8ff09a26.jpg',1000,NULL,7200000),(46,'Oppo find x3 Pro 5g','2021-09-07','2021-09-08','SMART',1,_binary '','863574c3.jpg','5c4006d9.jpg','1e251903.jpg',1000,NULL,36000000),(47,'Oppo reno 5','2021-09-07','2021-09-07','SMART',1,_binary '','946d016d.jpg','dc39b24a.jpg','5b24f2ae.jpg',1000,NULL,10788000),(48,'OPPO Reno5 phiên bản Marvel','2021-09-07','2021-09-07','SMART',1,_binary '','76240034.jpg','f67e0758.jpg','2c82dc54.jpg',1000,NULL,9600000),(49,'Samsung Galaxy Fold3 5g','2021-09-07','2021-09-07','SMART',1,_binary '','67eb9c7c.jpg','ee3e1cae.jpg','ce453cfe.jpg',1000,NULL,48000000),(50,'Samsung galaxy z flip 3 5g','2021-09-07','2021-09-07','SMART',1,_binary '','1ea5f070.jpg','cbe318db.jpg','753efe65.jpg',1000,NULL,48000000),(51,'Oppo find x2','2021-09-07','2021-09-07','SMART',1,_binary '','253e2beb.jpg','e51f9f29.jpg','3676c82e.jpg',1000,NULL,12000000),(52,'Oppo reno 4','2021-09-07','2021-09-07','SMART',1,_binary '','7b26c3f4.jpg','f3ecdca.jpg','3e7559cd.jpg',1000,NULL,7080000),(55,'fdf','2021-09-08','2021-09-08','JAVA',1,_binary '','cloud-upload.png','cloud-upload.png','cloud-upload.png',1000,NULL,545435000),(56,'sdsds','2021-09-08','2021-09-08','SMART',1,_binary '','cloud-upload.png','cloud-upload.png','cloud-upload.png',1000,NULL,3892150),(57,'jsdbf 2','2021-09-08','2021-09-08','SMART',1,_binary '','f7a113ba.jpg','19343350.jpg','932a8f3a.jpg',1000,NULL,52120.8);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('ADMIN','ADMIN'),('PM','PM'),('USER','USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipper` (
  `shiperid` varchar(12) NOT NULL,
  `shipername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phonenumber` varchar(20) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`shiperid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper`
--

LOCK TABLES `shipper` WRITE;
/*!40000 ALTER TABLE `shipper` DISABLE KEYS */;
INSERT INTO `shipper` VALUES ('SP_NH','Ngọc Hải','93 Nguyễn Văn Cừ','Cần Thơ','0767434245','hainnpc00645@fpt.edu.vn',_binary '');
/*!40000 ALTER TABLE `shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusorder`
--

DROP TABLE IF EXISTS `statusorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statusorder` (
  `id` varchar(5) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusorder`
--

LOCK TABLES `statusorder` WRITE;
/*!40000 ALTER TABLE `statusorder` DISABLE KEYS */;
INSERT INTO `statusorder` VALUES ('CXN','Chưa xác nhận'),('DG','Đang giao hàng'),('DGH','Đã giao hàng'),('DHH','Đã hủy hàng'),('DHT','Đã hoàn tiền'),('DLH','Đã lấy hàng'),('DXN','Đã xác nhận');
/*!40000 ALTER TABLE `statusorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplierid` varchar(55) NOT NULL,
  `suppliername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `contactname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `country` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`supplierid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('DDGG','CÔNG TY CỔ PHẦN TẬP ĐOÀN ĐẠI ĐOÀN GIA','Dương Hoàng Bảo','duonghoangbao.daidoangia@gmail.com','Số nhà 128, đường Lê Quý Đôn, Phường Tiền Phong, Tỉnh Thái Bình','Thái Bình','Việt Nam','0963.26.6868',''),('DDV','Công Ty TNHH Công Nghệ và Truyền Thông VMG','Trần Minh Phúc','',' 62A Trần Quang Khải, Phường Tân Định , quận 1','Hồ Chí Minh','Việt Nam',' 1800.6018','');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-08  9:07:56
