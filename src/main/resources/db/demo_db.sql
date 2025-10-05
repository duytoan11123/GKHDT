-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `language` (
  `languageid` varchar(2) NOT NULL,
  `language` varchar(20) NOT NULL,
  PRIMARY KEY (`languageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES ('en','english'),('vi','vietnamese');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productid` int NOT NULL AUTO_INCREMENT,
  `price` decimal(38,2) DEFAULT NULL,
  `weight` decimal(4,2) DEFAULT NULL,
  `product_categoryid` int NOT NULL,
  PRIMARY KEY (`productid`),
  KEY `FKbcjdl68c16mbgdpxfe7o89d41` (`product_categoryid`),
  CONSTRAINT `FKbcjdl68c16mbgdpxfe7o89d41` FOREIGN KEY (`product_categoryid`) REFERENCES `product_category` (`product_categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,100.00,2.00,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `product_categoryid` int NOT NULL AUTO_INCREMENT,
  `can_be_shipped` bit(1) DEFAULT NULL,
  PRIMARY KEY (`product_categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,_binary ''),(2,_binary '\0');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category_translation`
--

DROP TABLE IF EXISTS `product_category_translation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category_translation` (
  `languageid` varchar(255) NOT NULL,
  `product_categoryid` int NOT NULL,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`languageid`,`product_categoryid`),
  KEY `FK65v7yp930bqqta52haehqcn6d` (`product_categoryid`),
  CONSTRAINT `FK65v7yp930bqqta52haehqcn6d` FOREIGN KEY (`product_categoryid`) REFERENCES `product_category` (`product_categoryid`),
  CONSTRAINT `FK68p99i2np85yorkg444f2tfwx` FOREIGN KEY (`languageid`) REFERENCES `language` (`languageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category_translation`
--

LOCK TABLES `product_category_translation` WRITE;
/*!40000 ALTER TABLE `product_category_translation` DISABLE KEYS */;
INSERT INTO `product_category_translation` VALUES ('en',1,'hhhhh'),('en',2,'plan'),('vi',1,'sdsgtrdtr'),('vi',2,'may bay');
/*!40000 ALTER TABLE `product_category_translation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_translation`
--

DROP TABLE IF EXISTS `product_translation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_translation` (
  `languageid` varchar(255) NOT NULL,
  `productid` int NOT NULL,
  `product_description` varchar(100) DEFAULT NULL,
  `product_name` varchar(100) NOT NULL,
  PRIMARY KEY (`languageid`,`productid`),
  KEY `FK3njfed2h135qyh5gcrxcxxxhl` (`productid`),
  CONSTRAINT `FK3njfed2h135qyh5gcrxcxxxhl` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `FKpmamgeijkh5b1jsfa8ru3sv6l` FOREIGN KEY (`languageid`) REFERENCES `language` (`languageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_translation`
--

LOCK TABLES `product_translation` WRITE;
/*!40000 ALTER TABLE `product_translation` DISABLE KEYS */;
INSERT INTO `product_translation` VALUES ('en',1,'bomb','B52 plane'),('vi',1,'bomb','may bay b52');
/*!40000 ALTER TABLE `product_translation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-05 12:43:49
