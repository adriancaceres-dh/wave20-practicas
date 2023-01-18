-- MySQL Script generated by MySQL Workbench
-- Wed Jan 18 15:11:24 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema concesionaria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema concesionaria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `concesionaria` DEFAULT CHARACTER SET utf8 ;
USE `concesionaria` ;

-- -----------------------------------------------------
-- Table `concesionaria`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`client` (
  `id_client` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last name` VARCHAR(45) NOT NULL,
  `DNI` INT UNSIGNED NOT NULL,
  `birthday` DATETIME NOT NULL,
  `adress` VARCHAR(45) NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`brand` (
  `id` INT NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`class` (
  `id` INT NOT NULL,
  `class` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`type` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `class_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_type_class1_idx` (`class_id` ASC) VISIBLE,
  CONSTRAINT `fk_type_class1`
    FOREIGN KEY (`class_id`)
    REFERENCES `concesionaria`.`class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`model` (
  `id` INT NOT NULL,
  `brand_id` INT NOT NULL,
  `type_id` INT NOT NULL,
  `year` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_model_brand1_idx` (`brand_id` ASC) VISIBLE,
  INDEX `fk_model_type1_idx` (`type_id` ASC) VISIBLE,
  CONSTRAINT `fk_model_brand1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `concesionaria`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_model_type1`
    FOREIGN KEY (`type_id`)
    REFERENCES `concesionaria`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`vehicle` (
  `id_vehicle` INT NOT NULL,
  `model_id_model` INT NOT NULL,
  `plate` VARCHAR(45) NULL,
  `mileage` VARCHAR(45) NULL,
  `purchase_date` DATETIME NULL,
  `price` DECIMAL(2) NULL,
  PRIMARY KEY (`id_vehicle`),
  INDEX `fk_vehicle_model1_idx` (`model_id_model` ASC) VISIBLE,
  CONSTRAINT `fk_vehicle_model1`
    FOREIGN KEY (`model_id_model`)
    REFERENCES `concesionaria`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`service` (
  `id_service` INT NOT NULL,
  `vehicle_id_vehicle` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `price` DECIMAL(2) NULL,
  ` date` DATETIME NULL,
  PRIMARY KEY (`id_service`),
  INDEX `fk_service_vehicle1_idx` (`vehicle_id_vehicle` ASC) VISIBLE,
  CONSTRAINT `fk_service_vehicle1`
    FOREIGN KEY (`vehicle_id_vehicle`)
    REFERENCES `concesionaria`.`vehicle` (`id_vehicle`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`client_has_vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`client_has_vehicle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `client_id_client` INT NOT NULL,
  `vehicle_id_vehicle` INT NOT NULL,
  PRIMARY KEY (`id`, `client_id_client`, `vehicle_id_vehicle`),
  INDEX `fk_client_has_vehicle_vehicle1_idx` (`vehicle_id_vehicle` ASC) VISIBLE,
  INDEX `fk_client_has_vehicle_client_idx` (`client_id_client` ASC) VISIBLE,
  CONSTRAINT `fk_client_has_vehicle_client`
    FOREIGN KEY (`client_id_client`)
    REFERENCES `concesionaria`.`client` (`id_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_has_vehicle_vehicle1`
    FOREIGN KEY (`vehicle_id_vehicle`)
    REFERENCES `concesionaria`.`vehicle` (`id_vehicle`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`color` (
  `id` INT NOT NULL,
  `color` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concesionaria`.`model_has_color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concesionaria`.`model_has_color` (
  `model_id` INT NOT NULL,
  `color_id` INT NOT NULL,
  PRIMARY KEY (`model_id`, `color_id`),
  INDEX `fk_model_has_color_color1_idx` (`color_id` ASC) VISIBLE,
  INDEX `fk_model_has_color_model1_idx` (`model_id` ASC) VISIBLE,
  CONSTRAINT `fk_model_has_color_model1`
    FOREIGN KEY (`model_id`)
    REFERENCES `concesionaria`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_model_has_color_color1`
    FOREIGN KEY (`color_id`)
    REFERENCES `concesionaria`.`color` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
