-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema clinicafisio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clinicafisio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinicafisio` DEFAULT CHARACTER SET utf8 ;
USE `clinicafisio` ;

-- -----------------------------------------------------
-- Table `clinicafisio`.`tbl_fichapaciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicafisio`.`tbl_fichapaciente` (
                                                                  `id_ficha` INT NOT NULL AUTO_INCREMENT,
                                                                  `nome` VARCHAR(80) NOT NULL,
    `data_nasc` DATE NOT NULL,
    `sexo` VARCHAR(1) NOT NULL,
    `cep` VARCHAR(11) NULL,
    `endereco` VARCHAR(100) NULL,
    `num_complemento` VARCHAR(60) NULL,
    `cidade` VARCHAR(45) NULL,
    `estado` VARCHAR(2) NULL,
    `ocupacao` VARCHAR(45) NULL,
    `bairro` VARCHAR(45) NULL,
    `diagnostico_clinico` TEXT NOT NULL,
    `queixa_principal` TEXT NOT NULL,
    `hpo_hma` TEXT NOT NULL,
    `medicacoes` TEXT NOT NULL,
    `exames_comple` TEXT NOT NULL,
    `exame_fisico` TEXT NOT NULL,
    `conduta_clinica` TEXT NOT NULL,
    `diagnostico` TEXT NOT NULL,
    PRIMARY KEY (`id_ficha`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinicafisio`.`tbl_midia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicafisio`.`tbl_midia` (
                                                          `num_seq` INT NOT NULL AUTO_INCREMENT,
                                                          `descricao` VARCHAR(255) NULL,
    `link_midia` VARCHAR(255) NULL,
    `id_ficha` INT NOT NULL,
    PRIMARY KEY (`num_seq`),
    INDEX `fk_tbl_midia_tbl_fichapaciente_idx` (`id_ficha` ASC) VISIBLE,
    CONSTRAINT `fk_tbl_midia_tbl_fichapaciente`
    FOREIGN KEY (`id_ficha`)
    REFERENCES `clinicafisio`.`tbl_fichapaciente` (`id_ficha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinicafisio`.`tbl_clinica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicafisio`.`tbl_clinica` (
                                                            `id_clinica` INT NOT NULL,
                                                            `nome` VARCHAR(60) NULL,
    `link_foto` VARCHAR(100) NULL,
    `telefone` VARCHAR(20) NULL,
    `endereco` VARCHAR(100) NULL,
    `numero` VARCHAR(10) NULL,
    `complemento` VARCHAR(80) NULL,
    `cep` VARCHAR(15) NULL,
    PRIMARY KEY (`id_clinica`),
    UNIQUE INDEX `id_clinica_UNIQUE` (`id_clinica` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinicafisio`.`tbl_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinicafisio`.`tbl_usuario` (
                                                            `id_usuario` INT NOT NULL AUTO_INCREMENT,
                                                            `login` VARCHAR(80) NOT NULL,
    `senha` VARCHAR(100) NOT NULL,
    `funcao` VARCHAR(20) NOT NULL,
    `especializacao` VARCHAR(50) NOT NULL,
    `nome` VARCHAR(60) NOT NULL,
    `role` ENUM('dono', 'id_funcionario') NOT NULL DEFAULT 'id_funcionario',
    `id_clinica` INT NOT NULL,
    PRIMARY KEY (`id_usuario`),
    INDEX `fk_tbl_usuario_tbl_clinica1_idx` (`id_clinica` ASC) VISIBLE,
    CONSTRAINT `fk_tbl_usuario_tbl_clinica1`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `clinicafisio`.`tbl_clinica` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
