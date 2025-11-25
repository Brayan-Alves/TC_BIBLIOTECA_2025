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
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`autor` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`editora` (
  `id_editora` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_editora`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`livro` (
  `id_livro` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `editora_id` INT NOT NULL,
  PRIMARY KEY (`id_livro`),
  INDEX `fk_livro_editora1_idx` (`editora_id` ASC) VISIBLE,
  CONSTRAINT `fk_livro_editora1`
    FOREIGN KEY (`editora_id`)
    REFERENCES `mydb`.`editora` (`id_editora`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`autor_livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`autor_livro` (
  `id_autor` INT NOT NULL,
  `id_livro` INT NOT NULL,
  PRIMARY KEY (`id_autor`, `id_livro`),
  INDEX `fk_autor_has_livro_livro1_idx` (`id_livro` ASC) VISIBLE,
  INDEX `fk_autor_has_livro_autor1_idx` (`id_autor` ASC) VISIBLE,
  CONSTRAINT `fk_autor_has_livro_autor1`
    FOREIGN KEY (`id_autor`)
    REFERENCES `mydb`.`autor` (`id_autor`),
  CONSTRAINT `fk_autor_has_livro_livro1`
    FOREIGN KEY (`id_livro`)
    REFERENCES `mydb`.`livro` (`id_livro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`role` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuarios` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_usuarios_role1_idx` (`id_role` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_role1`
    FOREIGN KEY (`id_role`)
    REFERENCES `mydb`.`role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `id_cliente` INT NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  INDEX `fk_cliente_usuarios1_idx` (`id_cliente` ASC) VISIBLE,
  PRIMARY KEY (`id_cliente`),
  CONSTRAINT `fk_cliente_usuarios1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `mydb`.`usuarios` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`emprestimo` (
  `id_emprestimo` INT NOT NULL AUTO_INCREMENT,
  `id_livro` INT NOT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_emprestimo`),
  INDEX `fk_emprestimo_livro1_idx` (`id_livro` ASC) VISIBLE,
  INDEX `fk_emprestimo_cliente1_idx` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_emprestimo_livro1`
    FOREIGN KEY (`id_livro`)
    REFERENCES `mydb`.`livro` (`id_livro`),
  CONSTRAINT `fk_emprestimo_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `mydb`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO role (nome) VALUES ('cliente');
INSERT INTO role (nome) VALUES ('funcionario');
INSERT INTO role (nome) VALUES ('gerente');

