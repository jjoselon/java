-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE DATABASE IF NOT EXISTS millonariodb;

-- -----------------------------------------------------
-- Table `millonariodb`.`pregunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `millonariodb`.`pregunta` (
  `idpregunta` INT NOT NULL AUTO_INCREMENT,
  `EnunciadoPregunta` VARCHAR(205) NOT NULL,
  `ValorPregunta` INT NOT NULL,
  PRIMARY KEY (`idpregunta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `millonariodb`.`respuesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `millonariodb`.`respuesta` (
  `idrespuesta` INT NOT NULL AUTO_INCREMENT,
  `DescripcionRespuesta` VARCHAR(205) NOT NULL,
  `pregunta_idpregunta` INT NOT NULL,
  PRIMARY KEY (`idrespuesta`, `pregunta_idpregunta`),
  INDEX `fk_respuesta_pregunta_idx` (`pregunta_idpregunta` ASC),
  CONSTRAINT `fk_respuesta_pregunta`
    FOREIGN KEY (`pregunta_idpregunta`)
    REFERENCES `millonariodb`.`pregunta` (`idpregunta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

ALTER TABLE `millonariodb`.`respuesta` ADD `OrdenRespuesta` INT(11) NOT NULL AFTER `DescripcionRespuesta`;
ALTER TABLE `millonariodb`.`respuesta` ADD `EsCorrecta` BOOLEAN NOT NULL AFTER `OrdenRespuesta`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

