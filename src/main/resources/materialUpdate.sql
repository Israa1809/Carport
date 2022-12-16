CREATE DATABASE  IF NOT EXISTS `carport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carport`;
-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `carport`
--

DROP TABLE IF EXISTS `carport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport` (
  `carport_id` int NOT NULL AUTO_INCREMENT,
  `length` int NOT NULL,
  `width` int NOT NULL,
  `material_full_price` float NOT NULL,
  `fee_price` float NOT NULL,
  `customer_id` int NOT NULL,
  `offer_status` tinyint NOT NULL DEFAULT '0',
  `payment_status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`carport_id`),
  KEY `fk_carport_customer1_idx` (`customer_id`),
  CONSTRAINT `fk_carport_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport`
--

LOCK TABLES `carport` WRITE;
/*!40000 ALTER TABLE `carport` DISABLE KEYS */;
INSERT INTO `carport` VALUES (1,780,600,14007.2,5000,8,1,0),(2,780,600,14007.2,5000,9,1,1),(3,780,800,22875.3,5000,10,1,1),(4,780,600,14007.2,10000,11,0,0),(5,780,600,24692,5000,12,1,1),(6,780,600,14879.2,5000,13,1,0),(7,780,600,15315.2,5000,14,0,0),(8,780,600,15288.2,5000,15,0,0),(9,780,600,54228.6,5000,16,0,0),(10,780,600,18051.6,5000,17,0,0);
/*!40000 ALTER TABLE `carport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `postal_code` int NOT NULL,
  `city` varchar(45) NOT NULL,
  `phone_number` int NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Martin','Her',2650,'Hvidovre',1234,'hjhj@hjh'),(8,'malene','hÃ¸j',28,'lyng',123,'123@mail.com'),(9,'malene','hÃ¸jlÃ¸kken',2800,'lyngby',12345678,'mail@mail.dk'),(10,'hallÃ¸j','goddag',12,'hej',2222,'m@m.dk'),(11,'mark','vejvejen',1234,'hallÃ¸jby',3333,'mark@mail.dk'),(12,'Martin','juhuuvej',4455,'jubii',5555,'martin@mail.dk'),(13,'israa','snevej',1111,'sneland',7777,'israa@mail.dk'),(14,'Berry','lysvej',7777,'lys',9999,'berry@mail.com'),(15,'sne','snesne',8888,'snesnesne',0,'mailmail@mail.dk'),(16,'julemanden','julevej',101,'jul',101,'jule@mail.dk'),(17,'rudolf','julevej',101,'juleby',101,'jul@mail.dk');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `material_id` int NOT NULL AUTO_INCREMENT,
  `material_quantity` int NOT NULL,
  `material_name` varchar(45) NOT NULL,
  `unit_type` varchar(45) NOT NULL,
  `material_price` float NOT NULL,
  `product_variant` varchar(45) NOT NULL,
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,360,'25x200mm.trykimp.Brædt','cm',205.01,'understern'),(2,540,'25x200mm.trykimp.Brædt','cm',307.53,'understern'),(3,360,'25x125mm.trykimp.Brædt','cm',107.81,'overstern'),(4,540,'25x125mm.trykimp.Brædt','cm',161.73,'overstern'),(5,420,'38x73mm.Lægteubh.','cm',66.99,'*mangler*'),(6,270,'45x95mm.Reglarub.','cm',47.88,'*mangler*'),(7,240,'45x95mm.Reglarub.','cm',53.86,'*mangler*'),(8,600,'45x195mm.spærtræubh.','cm',467.7,'rem - spær'),(9,480,'45x195mm.spærtræubh.','cm',273.35,'rem - spær'),(10,300,'97x97mm.trykimp.Stolpe','cm',149.85,'stolpe'),(11,210,'19x100mm.trykimp.Brædt','cm',18.79,'vandbræt'),(12,540,'19x100mm.trykimp.Brædt','cm',49.56,'vandbræt'),(13,360,'19x100mm.trykimp.Brædt','cm',32.21,'vandbræt'),(14,600,'PlastmoEcoliteblåtonet','cm',339,'trapetz'),(15,360,'PlastmoEcoliteblåtonet','cm',199,'trapetz'),(16,200,'plastmobundskruer200stk.','stk',429,'trapetz'),(17,1000,'hulbånd1x20mm.10mtr.','cm',349,'hulbånd'),(18,1,'universal190mmhøjre','stk',37.1,'spær'),(19,1,'universal190mmvenstre','stk',37.1,'spær'),(20,200,'4,5x60mm.skruer200stk.','stk',389,'stern - vandbræt'),(21,250,'4,0x50mm.beslagskruer250stk.','stk',436,'hulbånd - spær'),(22,25,'bræddebolt10x120mm.25stk','stk',409,'rem'),(23,50,'firkantskiver40x40x11mm50stk','stk',439,'*mangler*'),(24,400,'4,5x70mm.Skruer400stk.','stk',229,'*mangler*'),(25,300,'4,5x50mm.Skruer300stk.','stk',129,'*mangler*'),(26,1,'stalddørsgreb50x75','sæt',269,'*mangler*'),(27,1,'t-hængsel390mm','stk',139,'*mangler*'),(28,1,'vinkelbeslag35','stk',14.95,'*mangler*');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `part` (
  `part_id` int NOT NULL AUTO_INCREMENT,
  `part_quantity` int NOT NULL,
  `carport_id` int NOT NULL,
  `part_price` float NOT NULL,
  `material_id` int NOT NULL,
  PRIMARY KEY (`part_id`),
  KEY `fk_part_list_material_idx` (`material_id`),
  KEY `fk_part_list_carport1_idx` (`carport_id`),
  CONSTRAINT `fk_part_list_carport1` FOREIGN KEY (`carport_id`) REFERENCES `carport` (`carport_id`),
  CONSTRAINT `fk_part_list_material` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (1,6,1,899.1,10),(2,16,1,7483.2,8),(3,4,1,1870.8,8),(4,8,1,1293.84,4),(5,8,1,2460.24,2),(11,9,3,1348.65,10),(12,32,3,14966.4,8),(13,6,3,2806.2,8),(14,8,3,1293.84,4),(15,8,3,2460.24,2),(61,6,2,899.1,10),(62,16,2,7483.2,8),(63,4,2,1870.8,8),(64,8,2,1293.84,4),(65,8,2,2460.24,2),(71,6,4,899.1,10),(72,16,4,7483.2,8),(73,4,4,1870.8,8),(74,8,4,1293.84,4),(75,8,4,2460.24,2),(76,6,5,899.1,10),(77,16,5,7483.2,8),(78,288,5,10684.8,18),(79,4,5,1870.8,8),(80,8,5,1293.84,4),(81,8,5,2460.24,2),(82,6,6,899.1,10),(83,16,6,7483.2,8),(84,2,6,872,21),(85,4,6,1870.8,8),(86,8,6,1293.84,4),(87,8,6,2460.24,2),(88,6,7,899.1,10),(89,1,7,436,21),(90,16,7,7483.2,8),(91,2,7,872,21),(92,4,7,1870.8,8),(93,8,7,1293.84,4),(94,8,7,2460.24,2),(95,6,8,899.1,10),(96,1,8,409,22),(97,16,8,7483.2,8),(98,2,8,872,21),(99,4,8,1870.8,8),(100,8,8,1293.84,4),(101,8,8,2460.24,2),(102,6,9,899.1,10),(103,1,9,409,22),(104,16,9,7483.2,8),(105,2,9,872,21),(106,32,9,1187.2,18),(107,32,9,1187.2,19),(108,4,9,1870.8,8),(109,8,9,1293.84,4),(110,8,9,2460.24,2),(111,94,9,36566,20),(112,6,10,899.1,10),(113,1,10,409,22),(114,16,10,7483.2,8),(115,2,10,872,21),(116,32,10,1187.2,18),(117,32,10,1187.2,19),(118,4,10,1870.8,8),(119,8,10,1293.84,4),(120,8,10,2460.24,2),(121,1,10,389,20);
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','123','user'),('10','101','user'),('2','12345678','user'),('3','2222','user'),('4','3333','user'),('5','5555','user'),('6','7777','user'),('7','9999','user'),('8','0','user'),('9','101','user'),('admin','1234','admin'),('user','1234','user');
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

-- Dump completed on 2022-12-16 12:16:32
