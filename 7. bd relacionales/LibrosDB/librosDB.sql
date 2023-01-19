-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema librosdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema librosdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `librosdb` DEFAULT CHARACTER SET utf8 ;
USE `librosdb` ;

-- -----------------------------------------------------
-- Table `librosdb`.`Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librosdb`.`Libro` (
  `idLibro` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `editorial` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLibro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `librosdb`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librosdb`.`Autor` (
  `idAutor` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `librosdb`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librosdb`.`Estudiante` (
  `idLector` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  PRIMARY KEY (`idLector`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `librosdb`.`LibroAutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librosdb`.`LibroAutor` (
  `idLibro` INT NOT NULL,
  `idAutor` INT NOT NULL,
  PRIMARY KEY (`idLibro`, `idAutor`),
  INDEX `fk_Libro_has_Autor_Autor1_idx` (`idAutor` ASC) VISIBLE,
  INDEX `fk_Libro_has_Autor_Libro_idx` (`idLibro` ASC) VISIBLE,
  CONSTRAINT `fk_Libro_has_Autor_Libro`
    FOREIGN KEY (`idLibro`)
    REFERENCES `librosdb`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_has_Autor_Autor1`
    FOREIGN KEY (`idAutor`)
    REFERENCES `librosdb`.`Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `librosdb`.`Prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `librosdb`.`Prestamo` (
  `idLibro` INT NOT NULL,
  `idLector` INT NOT NULL,
  `fechaPrestamo` DATETIME NULL,
  `fechaDevolucion` DATETIME NULL,
  `devuelto` TINYINT NULL,
  PRIMARY KEY (`idLibro`, `idLector`),
  INDEX `fk_Libro_has_Estudiante_Estudiante1_idx` (`idLector` ASC) VISIBLE,
  INDEX `fk_Libro_has_Estudiante_Libro1_idx` (`idLibro` ASC) VISIBLE,
  CONSTRAINT `fk_Libro_has_Estudiante_Libro1`
    FOREIGN KEY (`idLibro`)
    REFERENCES `librosdb`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_has_Estudiante_Estudiante1`
    FOREIGN KEY (`idLector`)
    REFERENCES `librosdb`.`Estudiante` (`idLector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
