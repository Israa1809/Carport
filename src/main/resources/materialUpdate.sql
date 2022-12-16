-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport`
--

LOCK TABLES `carport` WRITE;
/*!40000 ALTER TABLE `carport` DISABLE KEYS */;
INSERT INTO `carport` VALUES (1,700,680,19753,5000,8,0,0),(2,700,680,19753,5000,9,0,0),(3,700,680,19753,5000,10,0,0),(4,700,680,19753,5000,11,0,0),(5,780,600,14007.2,2500,12,0,0),(6,780,600,14007.2,5000,13,1,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Martin','Her',2650,'Hvidovre',1234,'hjhj@hjh'),(8,'test test','test 12',2300,'KBH',12345678,'test@test.dk'),(9,'123','1234',111,'best',12345,'2@test.dk'),(10,'teaet','test 11',1234,'tbh',1245678,'a2@test.dk'),(11,'Mark','Ã¥gade 6',2300,'KBH S',12345781,'slam@tis.dk'),(12,'MP','Tis',123,'Ost',1234,'test@test.dk'),(13,'Mikkel','roev 69',4200,'Slam',2468,'yrat@gtes.dk');
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
INSERT INTO `material` VALUES (1,360,'25x200mm.trykimp.Brædt','cm',205.01,'understern'),(2,540,'25x200mm.trykimp.Brædt','cm',307.53,'understern'),(3,360,'25x125mm.trykimp.Brædt','cm',107.81,'overstern'),(4,540,'25x125mm.trykimp.Brædt','cm',161.73,'overstern'),(5,420,'38x73mm.Lægteubh.','cm',66.99,'*mangler*'),(6,270,'45x95mm.Reglarub.','cm',47.88,'*mangler*'),(7,240,'45x95mm.Reglarub.','cm',53.86,'*mangler*'),(8,600,'45x195mm.spærtræubh.','cm',467.7,'rem - spær'),(9,480,'45x195mm.spærtræubh.','cm',273.35,'rem - spær'),(10,300,'97x97mm.trykimp.Stolpe','cm',149.85,'stolpe'),(11,210,'19x100mm.trykimp.Brædt','cm',18.79,'vandbræt'),(12,540,'19x100mm.trykimp.Brædt','cm',49.56,'vandbræt'),(13,360,'19x100mm.trykimp.Brædt','cm',32.21,'vandbræt'),(14,600,'PlastmoEcoliteblåtonet109cm','cm',339,'trapetz'),(15,360,'PlastmoEcoliteblåtonet109cm','cm',199,'trapetz'),(16,200,'plastmobundskruer200stk.','stk',429,'trapetz'),(17,1000,'hulbånd1x20mm.10mtr.','cm',349,'hulbånd'),(18,1,'universal190mmhøjre','stk',37.1,'spær'),(19,1,'universal190mmvenstre','stk',37.1,'spær'),(20,200,'4,5x60mm.skruer200stk.','stk',389,'stern - vandbræt'),(21,250,'4,0x50mm.beslagskruer250stk.','stk',436,'hulbånd - spær'),(22,25,'bræddebolt10x120mm.25stk','stk',409,'rem'),(23,50,'firkantskiver40x40x11mm50stk','stk',439,'*mangler*'),(24,400,'4,5x70mm.Skruer400stk.','stk',229,'*mangler*'),(25,300,'4,5x50mm.Skruer300stk.','stk',129,'*mangler*'),(26,1,'stalddørsgreb50x75','sæt',269,'*mangler*'),(27,1,'t-hængsel390mm','stk',139,'*mangler*'),(28,1,'vinkelbeslag35','stk',14.95,'*mangler*');
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (14,4,5,599.4,10),(15,9,5,4209.3,8),(16,2,5,935.4,8),(17,6,5,970.38,4),(18,6,5,1845.18,2),(19,6,6,899.1,10),(20,16,6,7483.2,8),(21,4,6,1870.8,8),(22,8,6,1293.84,4),(23,8,6,2460.24,2);
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
INSERT INTO `user` VALUES ('1','12345678','user'),('2','12345','user'),('3','1245678','user'),('4','12345781','user'),('5','1234','user'),('6','2468','user'),('admin','1234','admin'),('user','1234','user');
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

-- Dump completed on 2022-12-16 14:09:14
