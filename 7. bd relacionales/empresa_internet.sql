-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `dni_clientes` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fecha_de_nacimiento` datetime DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dni_clientes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (10000956,'Pablo','Rojas','1999-12-24 00:00:00','Medellin','Medellin'),(10012332,'Juana','Fernandez','2000-03-10 00:00:00','Barcelona','Barcelona'),(10012678,'Alfonso','Sanchez','1996-10-26 00:00:00','Ciudad de Mexico','Ciudad de Mexico'),(10020735,'Juan','Martinez','2003-05-20 00:00:00','Cali','Cali'),(10022999,'Alonso','Rodriguez','2000-05-17 00:00:00','Barranquilla','Barranquilla'),(10023978,'Pedro','Ruiz','2010-06-13 00:00:00','Bogota','Bogota'),(10035580,'Andres','Zapata','2004-07-26 00:00:00','Madrid','Madrid'),(10072201,'Santiago','Gutierrez','1990-02-14 00:00:00','Santa Marta','Santa Marta'),(10080900,'Juan','Montiel','2001-01-01 00:00:00','Bogota','Bogota'),(10080978,'Daniel','Orjuela','2002-01-01 00:00:00','Bogota','Bogota');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planes_de_internet`
--

DROP TABLE IF EXISTS `planes_de_internet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planes_de_internet` (
  `id_plan` int NOT NULL,
  `velocidad_megas` int DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `descuento` int DEFAULT NULL,
  `dni_clientes` int DEFAULT NULL,
  PRIMARY KEY (`id_plan`),
  KEY `dni_clientes` (`dni_clientes`),
  CONSTRAINT `planes_de_internet_ibfk_1` FOREIGN KEY (`dni_clientes`) REFERENCES `clientes` (`dni_clientes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planes_de_internet`
--

LOCK TABLES `planes_de_internet` WRITE;
/*!40000 ALTER TABLE `planes_de_internet` DISABLE KEYS */;
INSERT INTO `planes_de_internet` VALUES (1,50,50000,0,10000956),(2,250,270000,0,10012332),(3,120,90000,0,10012678),(4,500,380000,0,10020735),(5,180,200000,0,10022999),(6,15,10000,0,10023978);
/*!40000 ALTER TABLE `planes_de_internet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-25 14:24:40
