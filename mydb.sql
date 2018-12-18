-- MySQL Script generated by MySQL Workbench
-- Tue Dec 11 17:21:38 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema myrank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema myrank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `myrank` DEFAULT CHARACTER SET utf8 ;
USE `myrank` ;

-- -----------------------------------------------------
-- Table `myrank`.`Categorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myrank`.`Categorie` (
  `id` INT NOT NULL,
  `type` VARCHAR(15) NOT NULL,
  `couleur` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myrank`.`Question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myrank`.`Question` (
  `id` INT NOT NULL,
  `titre` VARCHAR(25) NOT NULL,
  `point` INT NULL,
  `Categorie_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Categorie_id`),
  INDEX `fk_Question_Categorie1_idx` (`Categorie_id` ASC) VISIBLE,
  CONSTRAINT `fk_Question_Categorie1`
    FOREIGN KEY (`Categorie_id`)
    REFERENCES `myrank`.`Categorie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myrank`.`Resultat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myrank`.`Resultat` (
  `id` INT NOT NULL,
  `valeur` VARCHAR(45) NULL,
  `point` INT NULL,
  `Question_id` INT NOT NULL,
  `Question_Categorie_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Question_id`, `Question_Categorie_id`),
  INDEX `fk_Resultat_Question1_idx` (`Question_id` ASC, `Question_Categorie_id` ASC) VISIBLE,
  CONSTRAINT `fk_Resultat_Question1`
    FOREIGN KEY (`Question_id` , `Question_Categorie_id`)
    REFERENCES `myrank`.`Question` (`id` , `Categorie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myrank`.`Utilisateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myrank`.`Utilisateur` (
  `id` INT NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `mdp` VARCHAR(45) NOT NULL,
  `telephone` INT NOT NULL,
  `date de naissance` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myrank`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myrank`.`vote` (
  `id` INT NOT NULL,
  `Utilisateur_id` INT NOT NULL,
  `Resultat_id` INT NOT NULL,
  `Resultat_Question_id` INT NOT NULL,
  `Resultat_Question_Categorie_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Resultat_id`, `Resultat_Question_id`, `Resultat_Question_Categorie_id`),
  INDEX `fk_vote_Utilisateur1_idx` (`Utilisateur_id` ASC) VISIBLE,
  INDEX `fk_vote_Resultat1_idx` (`Resultat_id` ASC, `Resultat_Question_id` ASC, `Resultat_Question_Categorie_id` ASC) VISIBLE,
  CONSTRAINT `fk_vote_Utilisateur1`
    FOREIGN KEY (`Utilisateur_id`)
    REFERENCES `myrank`.`Utilisateur` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vote_Resultat1`
    FOREIGN KEY (`Resultat_id` , `Resultat_Question_id` , `Resultat_Question_Categorie_id`)
    REFERENCES `myrank`.`Resultat` (`id` , `Question_id` , `Question_Categorie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `myrank`.`categorie` (`id`, `type`, `couleur`) VALUES ('1', 'sport', 'rouge');
INSERT INTO `myrank`.`categorie` (`id`, `type`, `couleur`) VALUES ('2', 'politique', 'bleu');
INSERT INTO `myrank`.`categorie` (`id`, `type`, `couleur`) VALUES ('3', 'jeunesse', 'orange');
INSERT INTO `myrank`.`categorie` (`id`, `type`, `couleur`) VALUES ('4', 'sex', 'rose');