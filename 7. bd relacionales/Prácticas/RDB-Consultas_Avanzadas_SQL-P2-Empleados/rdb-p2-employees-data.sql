-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema employees_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema employees_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `employees_db` DEFAULT CHARACTER SET utf8 ;
USE `employees_db` ;

-- -----------------------------------------------------
-- Table `employees_db`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employees_db`.`departamento` (
  `depto_nro` VARCHAR(6) NOT NULL,
  `nombre_depto` VARCHAR(16) NOT NULL,
  `localidad` VARCHAR(30) NULL,
  PRIMARY KEY (`depto_nro`))
ENGINE = InnoDB;

LOCK TABLES `departamento` WRITE;
INSERT INTO `departamento` VALUES ("D-0001","Software","Los Tigres"),
("D-0002","Sistemas","Guadalupe"),
("D-0003","Contabilidad","La Roca"),
("D-0004","Ventas","Plata");
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `employees_db`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employees_db`.`empleado` (
  `cod_emp` VARCHAR(6) NOT NULL,
  `nombre` VARCHAR(16) NOT NULL,
  `apellido` VARCHAR(24) NOT NULL,
  `puesto` VARCHAR(16) NOT NULL,
  `fecha_alta` DATETIME NOT NULL,
  `salario` INT NOT NULL,
  `comision` INT NULL DEFAULT 0,
  `depto_nro` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`cod_emp`),
  INDEX `fk_empleado_departamento_idx` (`depto_nro` ASC) VISIBLE,
  CONSTRAINT `fk_empleado_departamento`
    FOREIGN KEY (`depto_nro`)
    REFERENCES `employees_db`.`departamento` (`depto_nro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

LOCK TABLES `empleado` WRITE;
INSERT INTO `empleado` VALUES ("E-0001","César","Piñero","Vendedor","2018-05-12",80000,15000,"D-0004"),
("E-0002","Yosep","Kowaleski","Analista","2015-07-14",140000,0,"D-0002"),
("E-0003","Mariela","Barrios","Director","2014-06-05",185000,0,"D-0003"),
("E-0004","Jonathan","Aguilera","Vendedor","2015-06-03",85000,10000,"D-0004"),
("E-0005","Daniel","Brezezicki","Vendedor","2018-03-03",83000,10000,"D-0004"),
("E-0006","Mito","Barchuk","Presidente","2014-06-05",190000,0,"D-0003"),
("E-0007","Emilio","Galarza","Desarrollador","2014-08-02",60000,0,"D-0001");
UNLOCK TABLES;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
