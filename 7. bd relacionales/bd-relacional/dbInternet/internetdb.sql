-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema internetdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema internetdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `internetdb` ;
USE `internetdb` ;

-- -----------------------------------------------------
-- Table `internetdb`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internetdb`.`plan` (
  `idplan` INT NOT NULL,
  `velocidad_en_megas` INT NULL,
  `precio` INT NULL,
  `descuento` DECIMAL(2,2) NULL,
  PRIMARY KEY (`idplan`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internetdb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internetdb`.`cliente` (
  `DNI` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_de_nacimiento` DATETIME NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `idplan` INT NULL,
  PRIMARY KEY (`DNI`),
  INDEX `idplan_idx` (`idplan` ASC) VISIBLE,
  CONSTRAINT `idplan`
    FOREIGN KEY (`idplan`)
    REFERENCES `internetdb`.`plan` (`idplan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
