tbalumno-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.27-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para dbupt
CREATE DATABASE IF NOT EXISTS `dbupt` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `dbupt`;

-- Volcando estructura para tabla dbupt.tbalumno
CREATE TABLE IF NOT EXISTS `tbalumno` (
  `codigo` varchar(15) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbalumno: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbupt.tbcargo
CREATE TABLE IF NOT EXISTS `tbcargo` (
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbcargo: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbupt.tbclase
CREATE TABLE IF NOT EXISTS `tbclase` (
  `idclase` varchar(10) NOT NULL,
  `dniemp` varchar(8) DEFAULT NULL,
  `codcurso` varchar(10) DEFAULT NULL,
  `coddoc` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`idclase`),
  KEY `FK_tbclase_tbcurso` (`codcurso`),
  KEY `FK_tbclase_tbempleado` (`dniemp`),
  KEY `FK_tbclase_tbdocente` (`coddoc`),
  CONSTRAINT `FK_tbclase_tbcurso` FOREIGN KEY (`codcurso`) REFERENCES `tbcurso` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tbclase_tbdocente` FOREIGN KEY (`coddoc`) REFERENCES `tbdocente` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tbclase_tbempleado` FOREIGN KEY (`dniemp`) REFERENCES `tbempleado` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbclase: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbupt.tbcurso
CREATE TABLE IF NOT EXISTS `tbcurso` (
  `codigo` varchar(10) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  `prerequisito` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbcurso: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbupt.tbdetalleclase
CREATE TABLE IF NOT EXISTS `tbdetalleclase` (
  `idclase` varchar(10) DEFAULT NULL,
  `codalumno` varchar(15) DEFAULT NULL,
  KEY `FK_tbdetalleclase_tbalumno` (`codalumno`),
  KEY `FK_tbdetalleclase_tbclase` (`idclase`),
  CONSTRAINT `FK_tbdetalleclase_tbalumno` FOREIGN KEY (`codalumno`) REFERENCES `tbalumno` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tbdetalleclase_tbclase` FOREIGN KEY (`idclase`) REFERENCES `tbclase` (`idclase`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbdetalleclase: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbupt.tbdetallematricula
CREATE TABLE IF NOT EXISTS `tbdetallematricula` (
  `idmatricula` int(11) DEFAULT NULL,
  `codcurso` varchar(10) DEFAULT NULL,
  KEY `FK_tbdetallematricula_tbmatricula` (`idmatricula`),
  KEY `FK_tbdetallematricula_tbcurso` (`codcurso`),
  CONSTRAINT `FK_tbdetallematricula_tbcurso` FOREIGN KEY (`codcurso`) REFERENCES `tbcurso` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tbdetallematricula_tbmatricula` FOREIGN KEY (`idmatricula`) REFERENCES `tbmatricula` (`idmatricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbdetallematricula: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbupt.tbdocente
CREATE TABLE IF NOT EXISTS `tbdocente` (
  `codigo` varchar(6) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbdocente: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbupt.tbempleado
CREATE TABLE IF NOT EXISTS `tbempleado` (
  `dni` varchar(8) NOT NULL,
  `idcargo` int(11) NOT NULL DEFAULT 0,
  `nombre` varchar(8) DEFAULT NULL,
  `direccion` varchar(8) DEFAULT NULL,
  `telefono` varchar(8) DEFAULT NULL,
  `email` varchar(8) DEFAULT NULL,
  `usuario` varchar(8) DEFAULT NULL,
  `clave` varchar(8) DEFAULT NULL,
  `estado` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `FK_tbempleado_tbcargo` (`idcargo`),
  CONSTRAINT `FK_tbempleado_tbcargo` FOREIGN KEY (`idcargo`) REFERENCES `tbcargo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbempleado: ~0 rows (aproximadamente)

-- Volcando estructura para tabla dbupt.tbmatricula
CREATE TABLE IF NOT EXISTS `tbmatricula` (
  `idmatricula` int(11) NOT NULL,
  `fecha` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `dniemp` varchar(8) DEFAULT NULL,
  `codalumno` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idmatricula`),
  KEY `FK_tbmatricula_tbempleado` (`dniemp`),
  KEY `FK_tbmatricula_tbalumno` (`codalumno`),
  CONSTRAINT `FK_tbmatricula_tbalumno` FOREIGN KEY (`codalumno`) REFERENCES `tbalumno` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_tbmatricula_tbempleado` FOREIGN KEY (`dniemp`) REFERENCES `tbempleado` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla dbupt.tbmatricula: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;dbupttbalumno