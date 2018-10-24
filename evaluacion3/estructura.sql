-- MySQL Workbench Synchronization
-- Generated: 2018-10-23 14:55
-- Model: New Model
-- Version: 1.0
-- Project: Evaluacion 3
-- Author: Pablo Sepúlveda

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER SCHEMA `evaluacion3`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `evaluacion3`.`Persona` (
  `idPersona` INT(11) NOT NULL AUTO_INCREMENT,
  `rut` INT(11) NOT NULL,
  `dvRut` CHAR(1) NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `evaluacion3`.`Usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `passwd` VARCHAR(45) NOT NULL,
  `Persona_idPersona` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`, `Persona_idPersona`),
  INDEX `fk_Usuario_Persona_idx` (`Persona_idPersona` ASC),
  CONSTRAINT `fk_Usuario_Persona`
    FOREIGN KEY (`Persona_idPersona`)
    REFERENCES `evaluacion3`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
