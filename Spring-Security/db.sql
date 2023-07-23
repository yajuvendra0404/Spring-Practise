-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema employee_directory
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema employee_directory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `employee_directory` DEFAULT CHARACTER SET utf8mb4 ;
USE `employee_directory` ;

-- -----------------------------------------------------
-- Table `employee_directory`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`users` (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `enabled` TINYINT(4) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employee_directory`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`authorities` (
  `username` VARCHAR(50) NOT NULL,
  `authority` VARCHAR(50) NOT NULL,
  UNIQUE INDEX `authorities_idx_1` (`username` ASC, `authority` ASC),
  CONSTRAINT `authorities_ibfk_1`
    FOREIGN KEY (`username`)
    REFERENCES `employee_directory`.`users` (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employee_directory`.`hr_manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`hr_manager` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `company` VARCHAR(45) NOT NULL,
  `password` VARCHAR(70) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `employee_directory`.`instructor_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`instructor_detail` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `youtube_channel` VARCHAR(120) NOT NULL,
  `hobby` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `employee_directory`.`instructor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`instructor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `instructor_detail_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Instructor_instructor_detail` (`instructor_detail_id` ASC) VISIBLE,
  CONSTRAINT `fk_Instructor_instructor_detail`
    FOREIGN KEY (`instructor_detail_id`)
    REFERENCES `employee_directory`.`instructor_detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `employee_directory`.`members`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`members` (
  `user_id` VARCHAR(50) NOT NULL,
  `pw` CHAR(68) NOT NULL,
  `active` TINYINT(4) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employee_directory`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`roles` (
  `user_id` VARCHAR(50) NOT NULL,
  `role` VARCHAR(50) NOT NULL,
  UNIQUE INDEX `authorities5_idx_1` (`user_id` ASC, `role` ASC),
  CONSTRAINT `authorities5_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `employee_directory`.`members` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `employee_directory`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`student` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `marks` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `employee_directory`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`teacher` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `qualification` VARCHAR(45) NOT NULL,
  `department` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `age` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `employee_directory`.`user_session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employee_directory`.`user_session` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `session_id` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `user_agent` VARCHAR(45) NOT NULL,
  `user_ip` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
