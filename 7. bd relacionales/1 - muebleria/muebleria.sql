-- MySQL Script generated by MySQL Workbench
-- Wed Jan 18 15:50:01 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema muebleria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema muebleria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `muebleria` DEFAULT CHARACTER SET utf8 ;
USE `muebleria` ;

-- -----------------------------------------------------
-- Table `muebleria`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muebleria`.`client` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last name` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `muebleria`.`furniture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muebleria`.`furniture` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `height` DECIMAL(2) NULL,
  `width` DECIMAL(2) NULL,
  `weight` DECIMAL(2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `muebleria`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muebleria`.`purchase` (
  `id` INT NOT NULL,
  `date` DATETIME NULL,
  `amount` DECIMAL(2) NULL,
  `items` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `muebleria`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muebleria`.`stock` (
  `id` INT NOT NULL,
  `furniture_id` INT NOT NULL,
  `available` INT NULL,
  `damaged` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_stock_furniture1_idx` (`furniture_id` ASC) VISIBLE,
  CONSTRAINT `fk_stock_furniture1`
    FOREIGN KEY (`furniture_id`)
    REFERENCES `muebleria`.`furniture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `muebleria`.`purchase_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muebleria`.`purchase_detail` (
  `purchase_id` INT NOT NULL,
  `furniture_id` INT NOT NULL,
  `cuantity` INT NULL,
  PRIMARY KEY (`purchase_id`, `furniture_id`),
  INDEX `fk_purchase_has_furniture_furniture1_idx` (`furniture_id` ASC) VISIBLE,
  INDEX `fk_purchase_has_furniture_purchase_idx` (`purchase_id` ASC) VISIBLE,
  CONSTRAINT `fk_purchase_has_furniture_purchase`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `muebleria`.`purchase` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_has_furniture_furniture1`
    FOREIGN KEY (`furniture_id`)
    REFERENCES `muebleria`.`furniture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `muebleria`.`purchase_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `muebleria`.`purchase_history` (
  `client_id` INT NOT NULL,
  `purchase_id` INT NOT NULL,
  PRIMARY KEY (`client_id`, `purchase_id`),
  INDEX `fk_client_has_purchase_purchase1_idx` (`purchase_id` ASC) VISIBLE,
  INDEX `fk_client_has_purchase_client1_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `fk_client_has_purchase_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `muebleria`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_has_purchase_purchase1`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `muebleria`.`purchase` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
