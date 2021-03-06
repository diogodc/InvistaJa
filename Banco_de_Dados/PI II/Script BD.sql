-- MySQL Script generated by MySQL Workbench
-- 09/15/16 19:58:34
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema DB_InvistaJa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DB_InvistaJa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DB_InvistaJa` DEFAULT CHARACTER SET utf8 ;
USE `DB_InvistaJa` ;

-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_User` (
  `Id_User` INT NOT NULL AUTO_INCREMENT,
  `User` VARCHAR(50) NOT NULL,
  `Name_User` VARCHAR(100) NOT NULL,
  `Last_Name_User` VARCHAR(200) NOT NULL,
  `Password_User` VARCHAR(10) NOT NULL,
  `Phone_Number_User` VARCHAR(20) NULL,
  `CPF_User` VARCHAR(11) NULL,
  `Cell_Phone_Number_User` VARCHAR(20) NULL,
  PRIMARY KEY (`Id_User`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_Question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_Question` (
  `Id_Question` INT NOT NULL AUTO_INCREMENT,
  `Question` VARCHAR(5000) NOT NULL,
  `Type_Question` INT NULL,
  PRIMARY KEY (`Id_Question`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_User_Management`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_User_Management` (
  `Id_User_Management` INT NOT NULL AUTO_INCREMENT,
  `User_Management` VARCHAR(50) NOT NULL,
  `Name_User_Management` VARCHAR(100) NOT NULL,
  `Last_Name_User_Management` VARCHAR(200) NOT NULL,
  `Password_User_Management` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Id_User_Management`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_Answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_Answer` (
  `Id_Answer` INT NOT NULL AUTO_INCREMENT,
  `Answer_Text` VARCHAR(5000) NOT NULL,
  `Weight_Answer` INT NULL,
  `Answer_Number` REAL NULL,
  PRIMARY KEY (`Id_Answer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_Template`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_Template` (
  `Id_User` INT NOT NULL,
  `Id_Question` INT NOT NULL,
  `Id_Answer` INT NOT NULL,
  PRIMARY KEY (`Id_User`, `Id_Question`, `Id_Answer`),
  INDEX `fk_$!_Profile_$!_User1_idx` (`Id_User` ASC),
  INDEX `fk_$!_Profile_$!_Question1_idx` (`Id_Question` ASC),
  INDEX `fk_$!_Profile_$!_Answer1_idx` (`Id_Answer` ASC),
  CONSTRAINT `fk_$!_Profile_$!_User1`
    FOREIGN KEY (`Id_User`)
    REFERENCES `DB_InvistaJa`.`$!_User` (`Id_User`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_$!_Profile_$!_Question1`
    FOREIGN KEY (`Id_Question`)
    REFERENCES `DB_InvistaJa`.`$!_Question` (`Id_Question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_$!_Profile_$!_Answer1`
    FOREIGN KEY (`Id_Answer`)
    REFERENCES `DB_InvistaJa`.`$!_Answer` (`Id_Answer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_Question_Answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_Question_Answer` (
  `Id_Question` INT NOT NULL,
  `Id_Answer` INT NOT NULL,
  `Correct_Answer` BIT NULL DEFAULT 0,
  `Condition_Answer` VARCHAR(2) NULL,
  `Value_Condition_Answer` REAL NULL,
  PRIMARY KEY (`Id_Question`, `Id_Answer`),
  INDEX `fk_$!_Question_has_$!_Answer_$!_Answer1_idx` (`Id_Answer` ASC),
  INDEX `fk_$!_Question_has_$!_Answer_$!_Question_idx` (`Id_Question` ASC),
  CONSTRAINT `fk_$!_Question_has_$!_Answer_$!_Question`
    FOREIGN KEY (`Id_Question`)
    REFERENCES `DB_InvistaJa`.`$!_Question` (`Id_Question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_$!_Question_has_$!_Answer_$!_Answer1`
    FOREIGN KEY (`Id_Answer`)
    REFERENCES `DB_InvistaJa`.`$!_Answer` (`Id_Answer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_Investment_Type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_Investment_Type` (
  `Id_Investment_Type` INT NOT NULL AUTO_INCREMENT,
  `Investment_Type` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Id_Investment_Type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_Profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_Profile` (
  `Id_Profile` INT NOT NULL,
  `Id_User` INT NOT NULL,
  PRIMARY KEY (`Id_Profile`),
  INDEX `fk_$!_Profile_$!_User2_idx` (`Id_User` ASC),
  CONSTRAINT `fk_$!_Profile_$!_User2`
    FOREIGN KEY (`Id_User`)
    REFERENCES `DB_InvistaJa`.`$!_User` (`Id_User`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_InvistaJa`.`$!_Simulation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_InvistaJa`.`$!_Simulation` (
  `Id_Investment_Type` INT NOT NULL,
  `Id_Profile` INT NOT NULL,
  PRIMARY KEY (`Id_Investment_Type`, `Id_Profile`),
  INDEX `fk_$!_Profile_has_$!_Investment_Type_$!_Investment_Type1_idx` (`Id_Investment_Type` ASC),
  INDEX `fk_$!_Simulation_$!_Profile1_idx` (`Id_Profile` ASC),
  CONSTRAINT `fk_$!_Profile_has_$!_Investment_Type_$!_Investment_Type1`
    FOREIGN KEY (`Id_Investment_Type`)
    REFERENCES `DB_InvistaJa`.`$!_Investment_Type` (`Id_Investment_Type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_$!_Simulation_$!_Profile1`
    FOREIGN KEY (`Id_Profile`)
    REFERENCES `DB_InvistaJa`.`$!_Profile` (`Id_Profile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
