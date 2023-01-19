use empresa_internet;
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente` (
  `idCliente` INT NOT NULL,
  `dni` VARCHAR(15) NULL,
  `nombre` VARCHAR(15) NOT NULL,
  `apellido` VARCHAR(15) NOT NULL,
  `fechaNacimiento` DATETIME NULL,
  `provincia` VARCHAR(10) NULL,
  `ciudad` VARCHAR(10) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`PlanInternet` (
  `idPlanInternet` INT NOT NULL,
  `nombrePlan` VARCHAR(20) NOT NULL,
  `velocidadMB` INT NOT NULL,
  `precio` INT NOT NULL,
  `descuento` INT NOT NULL,
  PRIMARY KEY (`idPlanInternet`))
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente_has_PlanInternet` (
  `Cliente_idCliente` INT NOT NULL,
  `PlanInternet_idPlanInternet` INT NOT NULL,
  PRIMARY KEY (`Cliente_idCliente`, `PlanInternet_idPlanInternet`),
  INDEX `fk_Cliente_has_PlanInternet_PlanInternet1_idx` (`PlanInternet_idPlanInternet` ASC) VISIBLE,
  INDEX `fk_Cliente_has_PlanInternet_Cliente_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_has_PlanInternet_Cliente`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `empresa_internet`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_has_PlanInternet_PlanInternet1`
    FOREIGN KEY (`PlanInternet_idPlanInternet`)
    REFERENCES `empresa_internet`.`PlanInternet` (`idPlanInternet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (1,'17671173-6','armando','burdiles','1990-09-14 00:00:00','pudahuel','santiago');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (2,'17671173-1','armando1','burdiles','1989-09-14 00:00:00','pudahuel','santiago');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (3,'17671173-2','armando2','burdiles','1991-09-14 00:00:00','huechuraba','concepcion');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (4,'17671173-3','armando3','burdiles','1992-09-14 00:00:00','pudahuel','talca');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (5,'17671173-4','armando4','burdiles','1993-09-14 00:00:00','renca','santiago');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (6,'17671173-5','armando5','burdiles','1994-09-14 00:00:00','pudahuel','santiago');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (7,'17671173-7','armando6','burdiles','1995-09-14 00:00:00','cerronavia','talca');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (8,'17671173-8','armando7','burdiles','1996-09-14 00:00:00','pudahuel','santiago');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (9,'17671172-8','armando9','burdiles','1984-09-14 00:00:00','maipu','santiago');
INSERT INTO `Cliente` (`idCliente`,`dni`,`nombre`,`apellido`,`fechaNacimiento`,`provincia`,`ciudad`) VALUES (10,'17671179-2','armando10','burdiles','1987-09-14 00:00:00','recoleta','concepcion');

INSERT INTO `PlanInternet` (`idPlanInternet`,`nombrePlan`,`velocidadMB`,`precio`,`descuento`) VALUES (1,'full',800,26990,4990);
INSERT INTO `PlanInternet` (`idPlanInternet`,`nombrePlan`,`velocidadMB`,`precio`,`descuento`) VALUES (2,'semi full',400,20990,2000);
INSERT INTO `PlanInternet` (`idPlanInternet`,`nombrePlan`,`velocidadMB`,`precio`,`descuento`) VALUES (3,'basic',200,15990,1000);

INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (3,1);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (4,1);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (6,1);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (7,1);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (9,1);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (1,2);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (7,2);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (2,3);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (5,3);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (6,3);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (8,3);
INSERT INTO `Cliente_has_PlanInternet_PlanInternet` (`Cliente_idCliente`,`PlanInternet_idPlanInternet`) VALUES (9,3);
