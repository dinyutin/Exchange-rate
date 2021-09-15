-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema calculate_record
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema calculate_record
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `calculate_record` DEFAULT CHARACTER SET utf8mb4 ;
USE `calculate_record` ;

-- -----------------------------------------------------
-- Table `calculate_record`.`calculate_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calculate_record`.`calculate_record` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `rate` decimal(16,2) DEFAULT NULL COMMENT '匯率',
  `currency` varchar(10) DEFAULT NULL,
  `price` decimal(16,2) DEFAULT NULL,
  `discount` decimal(16,2) DEFAULT NULL COMMENT '折扣',
  `result` decimal(16,2) DEFAULT NULL,
  `record_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cid`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
