-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema testbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema testbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `testbd` ;
USE `testbd` ;

-- -----------------------------------------------------
-- Table `testbd`.`tbl_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testbd`.`tbl_client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testbd`.`tbl_car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testbd`.`tbl_car` (
  `car_id` INT NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `client_id` INT NULL,
  PRIMARY KEY (`car_id`),
  INDEX `client_id_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `client_id`
    FOREIGN KEY (`client_id`)
    REFERENCES `testbd`.`tbl_client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testbd`.`tbl_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testbd`.`tbl_service` (
  `service_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` INT NULL,
  PRIMARY KEY (`service_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testbd`.`tbl_service_car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testbd`.`tbl_service_car` (
  `service_car_id` INT NOT NULL,
  `car_id` INT NOT NULL,
  `service_id` INT NOT NULL,
  PRIMARY KEY (`service_car_id`),
  INDEX `service_id_idx` (`service_id` ASC) VISIBLE,
  INDEX `car:id_idx` (`car_id` ASC) VISIBLE,
  CONSTRAINT `service_id`
    FOREIGN KEY (`service_id`)
    REFERENCES `testbd`.`tbl_service` (`service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `car:id`
    FOREIGN KEY (`car_id`)
    REFERENCES `testbd`.`tbl_car` (`car_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
