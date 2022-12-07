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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,360,'25x200mm.trykimp.Brædt','cm',205.01,'understern'),(2,540,'25x200mm.trykimp.Brædt','cm',307.53,'understern'),(3,360,'25x125mm.trykimp.Brædt','cm',107.81,'overstern'),(4,540,'25x125mm.trykimp.Brædt','cm',161.73,'overstern'),(5,420,'38x73mm.Lægteubh.','cm',66.99,'*mangler*'),(6,270,'45x95mm.Reglarub.','cm',47.88,'*mangler*'),(7,240,'45x95mm.Reglarub.','cm',53.86,'*mangler*'),(8,600,'45x195mm.spærtræubh.','cm',467.7,'rem - spær'),(9,480,'45x195mm.spærtræubh.','cm',273.35,'rem - spær'),(10,300,'97x97mm.trykimp.Stolpe','cm',149.85,'stolpe'),(11,210,'19x100mm.trykimp.Brædt','cm',18.79,'vandbræt'),(12,540,'19x100mm.trykimp.Brædt','cm',49.56,'vandbræt'),(13,360,'19x100mm.trykimp.Brædt','cm',32.21,'vandbræt'),(14,600,'PlastmoEcoliteblåtonet','cm',339,'trapetz'),(15,360,'PlastmoEcoliteblåtonet','cm',199,'trapetz'),(16,200,'plastmobundskruer200stk.','stk',429,'trapetz'),(17,1000,'hulbånd1x20mm.10mtr.','cm',349,'hulbånd'),(18,1,'universal190mmhøjre','stk',37.1,'spær'),(19,1,'universal190mmvenstre','stk',37.1,'spær'),(20,200,'4,5x60mm.skruer200stk.','stk',389,'*mangler*'),(21,250,'4,0x50mm.beslagskruer250stk.','stk',436,'hulbånd - spær'),(22,25,'bræddebolt10x120mm.25stk','stk',409,'rem'),(23,50,'firkantskiver40x40x11mm50stk','stk',439,'*mangler*'),(24,400,'4,5x70mm.Skruer400stk.','stk',229,'*mangler*'),(25,300,'4,5x50mm.Skruer300stk.','stk',129,'*mangler*'),(26,1,'stalddørsgreb50x75','sæt',269,'*mangler*'),(27,1,'t-hængsel390mm','stk',139,'*mangler*'),(28,1,'vinkelbeslag35','stk',14.95,'*mangler*');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-06 21:18:38
