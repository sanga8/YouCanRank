CREATE SCHEMA IF NOT EXISTS `users` DEFAULT CHARACTER SET utf8 ;
USE `users` ;

-- -----------------------------------------------------
-- Table `myrank`.`Categorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `users`.`User` (
  `id` INT NOT NULL,
  `pseudo` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;