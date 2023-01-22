CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: biblioteca
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
-- Table structure for table `Autor`
--

DROP TABLE IF EXISTS `Autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Autor` (
  `idAutor` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autor`
--

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;
INSERT INTO `Autor` VALUES (1,'Tarik','Norway'),(2,'Leila','France'),(3,'Fritz','Russian Federation'),(4,'Xander','Italy'),(5,'Cooper','Brazil'),(6,'Hilary','Sweden'),(7,'Vincent','France'),(8,'Barclay','Russian Federation'),(9,'J.K. Rowling','Ukraine'),(10,'Barrett','United Kingdom'),(11,'Marcia','Singapore'),(12,'Troy','Singapore'),(13,'Brenden','Ukraine'),(14,'Omar','France'),(15,'Wang','Mexico');
/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estudiante`
--

DROP TABLE IF EXISTS `Estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estudiante` (
  `idLector` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `carrera` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estudiante`
--

LOCK TABLES `Estudiante` WRITE;
/*!40000 ALTER TABLE `Estudiante` DISABLE KEYS */;
INSERT INTO `Estudiante` VALUES (1,'Wesley','Gallagher','Ap #409-226 Ut Street','Vivamus',28),(2,'Ima','Pennington','940-6351 Nam Rd.','erat',24),(3,'Veda','Vincent','P.O. Box 772, 7007 Quisque Rd.','et',41),(4,'Quinlan','Foreman','Ap #447-5244 Nibh. St.','nulla.',38),(5,'Wade','Vaughan','Ap #244-5968 Ac, Rd.','informática',42),(6,'Ebony','Wells','480-3121 Imperdiet, Rd.','lorem,',48),(7,'Chancellor','Padilla','Ap #418-4711 Libero Avenue','at,',41),(8,'Charde','Sweet','P.O. Box 223, 4595 Sem Road','consectetuer',21),(9,'Filippo','Galli','Ap #779-6416 Cursus. Rd.','ornare,',33),(10,'Ishmael','Payne','697-9825 Faucibus Rd.','informática',46),(11,'Elton','Allen','455-4210 Venenatis Road','non',40),(12,'Galvin','Bell','Ap #126-5676 Nullam Av.','neque.',32),(13,'Garth','Morgan','5674 Bibendum St.','metus.',21),(14,'Isabella','GWatts','303-5303 Faucibus Rd.','informática',31),(15,'Gray','Rhodes','821-8751 Turpis. Street','vel',22);
/*!40000 ALTER TABLE `Estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libro`
--

DROP TABLE IF EXISTS `Libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libro` (
  `idLibro` int NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `editorial` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libro`
--

LOCK TABLES `Libro` WRITE;
/*!40000 ALTER TABLE `Libro` DISABLE KEYS */;
INSERT INTO `Libro` VALUES (1,'Burke','Parrish','Clinton'),(2,'Richard','Gregory','Base de Datos'),(3,'Genevieve','Salamandra','Mohammad'),(4,'Lance','Stein','Lydia'),(5,'El Universo: Guía de viaje','Garrison','internet'),(6,'Buckminster','Mendez','Hanae'),(7,'Alika','Harrell','Driscoll'),(8,'Melyssa','Solomon','Base de Datos'),(9,'Forrest','Hunt','Nell'),(10,'Jenna','Ryan','Yolanda'),(11,'Michelle','Salamandra','internet'),(12,'Jacqueline','Sosa','Solomon'),(13,'Kylie','Acevedo','Aidan'),(14,'Joseph','Mcintyre','Irene'),(15,'Brielle','Peck','internet');
/*!40000 ALTER TABLE `Libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LibroAutor`
--

DROP TABLE IF EXISTS `LibroAutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LibroAutor` (
  `idLibro` int NOT NULL,
  `idAutor` int NOT NULL,
  PRIMARY KEY (`idLibro`,`idAutor`),
  KEY `fk_Libro_has_Autor_Autor1_idx` (`idAutor`),
  KEY `fk_Libro_has_Autor_Libro1_idx` (`idLibro`),
  CONSTRAINT `fk_Libro_has_Autor_Autor1` FOREIGN KEY (`idAutor`) REFERENCES `Autor` (`idAutor`),
  CONSTRAINT `fk_Libro_has_Autor_Libro1` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LibroAutor`
--

LOCK TABLES `LibroAutor` WRITE;
/*!40000 ALTER TABLE `LibroAutor` DISABLE KEYS */;
INSERT INTO `LibroAutor` VALUES (2,2),(3,2),(3,5),(14,5),(11,9),(5,10),(3,11),(7,11),(10,11),(11,11),(14,11),(5,12),(12,12),(11,13),(14,13);
/*!40000 ALTER TABLE `LibroAutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prestamo`
--

DROP TABLE IF EXISTS `Prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prestamo` (
  `idLibro` int NOT NULL,
  `idLector` int NOT NULL,
  `fechaPrestamo` date DEFAULT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `devuelto` tinyint DEFAULT NULL,
  PRIMARY KEY (`idLibro`,`idLector`),
  KEY `fk_Libro_has_Estudiante_Estudiante1_idx` (`idLector`),
  KEY `fk_Libro_has_Estudiante_Libro_idx` (`idLibro`),
  CONSTRAINT `fk_Libro_has_Estudiante_Estudiante1` FOREIGN KEY (`idLector`) REFERENCES `Estudiante` (`idLector`),
  CONSTRAINT `fk_Libro_has_Estudiante_Libro` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamo`
--

LOCK TABLES `Prestamo` WRITE;
/*!40000 ALTER TABLE `Prestamo` DISABLE KEYS */;
INSERT INTO `Prestamo` VALUES (2,6,'2020-12-31','2021-05-02',0),(4,10,'2020-12-31','2021-04-06',1),(6,8,'2020-12-31','2021-10-27',1),(6,12,'2020-12-31','2021-02-23',0),(7,8,'2020-12-31','2021-05-08',1),(8,4,'2020-12-31','2021-03-27',1),(8,5,'2020-12-31','2021-07-01',1),(8,6,'2020-12-31','2021-11-30',1),(10,8,'2020-12-31','2021-03-15',0),(11,7,'2020-12-31','2021-02-26',0),(12,2,'2020-12-31','2021-09-13',1),(14,6,'2020-12-31','2021-05-02',0),(14,10,'2020-12-31','2021-06-27',0),(15,4,'2020-12-31','2021-03-01',1),(15,13,'2020-12-31','2021-08-22',1);
/*!40000 ALTER TABLE `Prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-22 14:09:14
