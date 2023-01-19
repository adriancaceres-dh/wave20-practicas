CREATE DATABASE  IF NOT EXISTS `empresa_internet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `empresa_internet`;
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
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `idCliente` int NOT NULL,
  `dni` varchar(15) DEFAULT NULL,
  `nombre` varchar(15) NOT NULL,
  `apellido` varchar(15) NOT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  `provincia` varchar(10) DEFAULT NULL,
  `ciudad` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'17671173-6','armando','burdiles','1990-09-14 00:00:00','pudahuel','santiago'),(2,'17671173-1','armando1','burdiles','1989-09-14 00:00:00','pudahuel','santiago'),(3,'17671173-2','armando2','burdiles','1991-09-14 00:00:00','huechuraba','concepcion'),(4,'17671173-3','armando3','burdiles','1992-09-14 00:00:00','pudahuel','talca'),(5,'17671173-4','armando4','burdiles','1993-09-14 00:00:00','renca','santiago'),(6,'17671173-5','armando5','burdiles','1994-09-14 00:00:00','pudahuel','santiago'),(7,'17671173-7','armando6','burdiles','1995-09-14 00:00:00','cerronavia','talca'),(8,'17671173-8','armando7','burdiles','1996-09-14 00:00:00','pudahuel','santiago'),(9,'17671172-8','armando9','burdiles','1984-09-14 00:00:00','maipu','santiago'),(10,'17671179-2','armando10','burdiles','1987-09-14 00:00:00','recoleta','concepcion');
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente_has_PlanInternet`
--

DROP TABLE IF EXISTS `Cliente_has_PlanInternet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente_has_PlanInternet` (
  `Cliente_idCliente` int NOT NULL,
  `PlanInternet_idPlanInternet` int NOT NULL,
  PRIMARY KEY (`Cliente_idCliente`,`PlanInternet_idPlanInternet`),
  KEY `fk_Cliente_has_PlanInternet_PlanInternet1_idx` (`PlanInternet_idPlanInternet`),
  KEY `fk_Cliente_has_PlanInternet_Cliente_idx` (`Cliente_idCliente`),
  CONSTRAINT `fk_Cliente_has_PlanInternet_Cliente` FOREIGN KEY (`Cliente_idCliente`) REFERENCES `Cliente` (`idCliente`),
  CONSTRAINT `fk_Cliente_has_PlanInternet_PlanInternet1` FOREIGN KEY (`PlanInternet_idPlanInternet`) REFERENCES `PlanInternet` (`idPlanInternet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente_has_PlanInternet`
--

LOCK TABLES `Cliente_has_PlanInternet` WRITE;
/*!40000 ALTER TABLE `Cliente_has_PlanInternet` DISABLE KEYS */;
INSERT INTO `Cliente_has_PlanInternet` VALUES (3,1),(4,1),(6,1),(7,1),(9,1),(1,2),(7,2),(2,3),(5,3),(6,3),(8,3),(9,3);
/*!40000 ALTER TABLE `Cliente_has_PlanInternet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PlanInternet`
--

DROP TABLE IF EXISTS `PlanInternet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PlanInternet` (
  `idPlanInternet` int NOT NULL,
  `nombrePlan` varchar(20) NOT NULL,
  `velocidadMB` int NOT NULL,
  `precio` int NOT NULL,
  `descuento` int NOT NULL,
  PRIMARY KEY (`idPlanInternet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PlanInternet`
--

LOCK TABLES `PlanInternet` WRITE;
/*!40000 ALTER TABLE `PlanInternet` DISABLE KEYS */;
INSERT INTO `PlanInternet` VALUES (1,'full',800,26990,4990),(2,'semi full',400,20990,2000),(3,'basic',200,15990,1000);
/*!40000 ALTER TABLE `PlanInternet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-19 18:46:49
