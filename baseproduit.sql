-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.6.17 - MySQL Community Server (GPL)
-- SE du serveur:                Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de la base pour baseproduit
CREATE DATABASE IF NOT EXISTS `baseproduit` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `baseproduit`;


-- Export de la structure de table baseproduit. description
CREATE TABLE IF NOT EXISTS `description` (
  `codedesc` smallint(6) NOT NULL AUTO_INCREMENT,
  `nomdesc` varchar(100) DEFAULT NULL,
  `typedesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codedesc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table baseproduit. produit
CREATE TABLE IF NOT EXISTS `produit` (
  `codeproduit` varchar(10) NOT NULL,
  `typeproduit` varchar(50) DEFAULT NULL,
  `dates` date DEFAULT NULL,
  `codedesc` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`codeproduit`),
  KEY `fk_prod_desc` (`codedesc`),
  CONSTRAINT `fk_prod_desc` FOREIGN KEY (`codedesc`) REFERENCES `description` (`codedesc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table baseproduit. stock
CREATE TABLE IF NOT EXISTS `stock` (
  `codestock` varchar(10) NOT NULL,
  `dateRecep` date DEFAULT NULL,
  `prixprod` float DEFAULT NULL,
  `quantiteDispo` int(11) DEFAULT NULL,
  `codedesc` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`codestock`),
  KEY `fk_stock_desc` (`codedesc`),
  CONSTRAINT `fk_stock_desc` FOREIGN KEY (`codedesc`) REFERENCES `produit` (`codedesc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table baseproduit. utilisateur
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `codeuser` varchar(20) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `prenom` varchar(150) NOT NULL,
  `sexe` varchar(20) NOT NULL,
  `cin` varchar(50) NOT NULL,
  `fonction` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `etat` varchar(1) NOT NULL,
  PRIMARY KEY (`codeuser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L'exportation de données n'était pas sélectionnée.


-- Export de la structure de table baseproduit. vente
CREATE TABLE IF NOT EXISTS `vente` (
  `codevente` varchar(10) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `prixunitaire` double DEFAULT NULL,
  `codestock` varchar(10) DEFAULT NULL,
  `datevente` varchar(50) DEFAULT NULL,
  `codeuser` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codevente`),
  KEY `fk_vente_stock` (`codestock`),
  KEY `FK_vente_utilisateur` (`codeuser`),
  CONSTRAINT `fk_vente_stock` FOREIGN KEY (`codestock`) REFERENCES `stock` (`codestock`),
  CONSTRAINT `FK_vente_utilisateur` FOREIGN KEY (`codeuser`) REFERENCES `utilisateur` (`codeuser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L'exportation de données n'était pas sélectionnée.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
