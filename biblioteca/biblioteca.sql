-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`autor` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`biblioteca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`biblioteca` (
  `id_biblioteca` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_biblioteca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  PRIMARY KEY (`id_pessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `id_pessoa` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_cliente_pessoa1_idx` (`id_pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_pessoa1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `mydb`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`editora` (
  `id_editora` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_editora`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`livro` (
  `id_livro` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `id_autor` INT NOT NULL,
  `id_editora` INT NOT NULL,
  `biblioteca_id_biblioteca` INT NOT NULL,
  PRIMARY KEY (`id_livro`),
  INDEX `fk_livro_autor_idx` (`id_autor` ASC) VISIBLE,
  INDEX `fk_livro_editora1_idx` (`id_editora` ASC) VISIBLE,
  INDEX `fk_livro_biblioteca1_idx` (`biblioteca_id_biblioteca` ASC) VISIBLE,
  CONSTRAINT `fk_livro_autor`
    FOREIGN KEY (`id_autor`)
    REFERENCES `mydb`.`autor` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro_editora1`
    FOREIGN KEY (`id_editora`)
    REFERENCES `mydb`.`editora` (`id_editora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro_biblioteca1`
    FOREIGN KEY (`biblioteca_id_biblioteca`)
    REFERENCES `mydb`.`biblioteca` (`id_biblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`emprestimo` (
  `id_emprestimo` INT NOT NULL AUTO_INCREMENT,
  `livro_id_livro` INT NOT NULL,
  `cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_emprestimo`),
  INDEX `fk_emprestimo_livro1_idx` (`livro_id_livro` ASC) VISIBLE,
  INDEX `fk_emprestimo_cliente1_idx` (`cliente_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_emprestimo_livro1`
    FOREIGN KEY (`livro_id_livro`)
    REFERENCES `mydb`.`livro` (`id_livro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emprestimo_cliente1`
    FOREIGN KEY (`cliente_id_cliente`)
    REFERENCES `mydb`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`funcionario` (
  `id_funcionario` INT NOT NULL AUTO_INCREMENT,
  `id_pessoa` INT NOT NULL,
  `id_biblioteca` INT NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  INDEX `fk_funcionario_biblioteca1_idx` (`id_biblioteca` ASC) VISIBLE,
  INDEX `fk_funcionario_pessoa1_idx` (`id_pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_biblioteca1`
    FOREIGN KEY (`id_biblioteca`)
    REFERENCES `mydb`.`biblioteca` (`id_biblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_pessoa1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `mydb`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`gerente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gerente` (
  `id_gerente` INT NOT NULL AUTO_INCREMENT,
  `id_biblioteca` INT NOT NULL,
  `id_pessoa` INT NOT NULL,
  PRIMARY KEY (`id_gerente`),
  INDEX `fk_gerente_biblioteca1_idx` (`id_biblioteca` ASC) VISIBLE,
  INDEX `fk_gerente_pessoa1_idx` (`id_pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_gerente_biblioteca1`
    FOREIGN KEY (`id_biblioteca`)
    REFERENCES `mydb`.`biblioteca` (`id_biblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gerente_pessoa1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `mydb`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
