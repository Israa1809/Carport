CREATE DATABASE  IF NOT EXISTS `carport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carport`;
-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.31

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
  `shed` tinyint NOT NULL DEFAULT '0',
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
INSERT INTO `carport` VALUES (9,780,300,21407.1,5000,16,1,1,0),(10,1090,900,50210.2,5000,17,1,0,1);
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
INSERT INTO `customer` VALUES (16,'Frank Pedersen','Bogtrykkervej 24 1.th',2400,'København NV',24566525,'frank@frank.dk'),(17,'Karine Bendtsen','Valbylanggade 14',2500,'Valby',56708929,'KarinaB@live.dk');
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
INSERT INTO `material` VALUES (1,360,'25x200mm.trykimp.Brædt','cm',205.01,'understern - beklædning'),(2,540,'25x200mm.trykimp.Brædt','cm',307.53,'understern - beklædning'),(3,360,'25x125mm.trykimp.Brædt','cm',107.81,'overstern'),(4,540,'25x125mm.trykimp.Brædt','cm',161.73,'overstern'),(5,420,'38x73mm.Lægteubh.','cm',66.99,'skurdør'),(6,270,'45x95mm.Reglarub.','cm',47.88,'skurramme'),(7,240,'45x95mm.Reglarub.','cm',53.86,'skurramme'),(8,600,'45x195mm.spærtræubh.','cm',467.7,'rem - spær'),(9,480,'45x195mm.spærtræubh.','cm',273.35,'rem - spær'),(10,300,'97x97mm.trykimp.Stolpe','cm',149.85,'stolpe'),(11,210,'19x100mm.trykimp.Brædt','cm',18.79,'vandbræt'),(12,540,'19x100mm.trykimp.Brædt','cm',49.56,'vandbræt'),(13,360,'19x100mm.trykimp.Brædt','cm',32.21,'vandbræt'),(14,600,'PlastmoEcoliteblåtonet109cm','cm',339,'trapetz'),(15,360,'PlastmoEcoliteblåtonet109cm','cm',199,'trapetz'),(16,200,'plastmobundskruer200stk.','stk',429,'trapetz'),(17,1000,'hulbånd1x20mm.10mtr.','cm',349,'hulbånd'),(18,1,'universal190mmhøjre','stk',37.1,'spær'),(19,1,'universal190mmvenstre','stk',37.1,'spær'),(20,200,'4,5x60mm.skruer200stk.','stk',389,'stern - vandbræt'),(21,250,'4,0x50mm.beslagskruer250stk.','stk',436,'hulbånd - spær'),(22,25,'bræddebolt10x120mm.25stk','stk',409,'rem'),(23,50,'firkantskiver40x40x11mm50stk','stk',439,'*mangler*'),(24,400,'4,5x70mm.Skruer400stk.','stk',229,'*mangler*'),(25,300,'4,5x50mm.Skruer300stk.','stk',129,'*mangler*'),(26,1,'stalddørsgreb50x75','sæt',269,'skurdør'),(27,1,'t-hængsel390mm','stk',139,'skurdør'),(28,1,'vinkelbeslag35','stk',14.95,'skurramme');
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (1,6,9,899.1,10),(2,1,9,409,22),(3,16,9,7483.2,8),(4,2,9,872,21),(5,32,9,1187.2,18),(6,32,9,1187.2,19),(7,4,9,1870.8,8),(8,8,9,862.48,3),(9,8,9,1640.08,1),(10,1,9,389,20),(11,2,9,698,17),(12,9,9,3051,14),(13,2,9,858,16),(14,12,10,1798.2,10),(15,1,10,409,22),(16,42,10,19643.4,8),(17,4,10,1744,21),(18,84,10,3116.4,18),(19,84,10,3116.4,19),(20,6,10,2806.2,8),(21,10,10,1617.3,4),(22,10,10,3075.3,2),(23,2,10,778,20),(24,4,10,1396,17),(25,24,10,8136,14),(26,6,10,2574,16);
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
INSERT INTO `user` VALUES ('10','56708929','user'),('9','24566525','user'),('admin','1234','admin'),('user','1234','user');
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

-- Dump completed on 2022-12-23 13:53:25
