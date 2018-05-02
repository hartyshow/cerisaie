-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 10 Avril 2018 à 12:39
-- Version du serveur :  10.1.8-MariaDB
-- Version de PHP :  5.6.30

create database `lesinscriptions`;
use `lesinscriptions`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lesinscriptions`
--

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `numcandidat` int(11) NOT NULL,
  `nomcandidat` varchar(20) DEFAULT NULL,
  `prenomcandidat` varchar(20) DEFAULT NULL,
  `datenaissance` date DEFAULT NULL,
  `adresse` varchar(150) DEFAULT NULL,
  `cpostal` varchar(20) DEFAULT NULL,
  `ville` varchar(150) DEFAULT NULL
) ENGINE=InnoDB
  DEFAULT CHARSET=`utf8` COLLATE=`utf8_general_ci`;
 


ALTER TABLE `inscription`
  ADD PRIMARY KEY (`numcandidat`);

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `numcandidat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
--
-- Contenu de la table `inscription`
--

INSERT INTO `inscription` (`numcandidat`, `nomcandidat`, `prenomcandidat`, `datenaissance`, `adresse`, `cpostal`, `ville`) VALUES
(9, 'SEGUIN', 'Lionel', '1990-07-21', '74, rue Bellecombe', '74370', 'VILLAZ'),
(10, 'VERSET', 'Stephane', '1986-04-13', '768, route de Chazal', '74370', 'VILLAZ'),
(11, 'DEPRES', ' Adrien', '1990-12-11', ' 23, rue Notre-Dame', ' 69006', ' LYON'),
(12, 'PATRICE', ' Keenan', '1990-03-23', '1, rue Jean-R Lacoste', ' 69780', ' MIONS'),
(13, 'VIAL', 'CHRISTIAN', '0006-07-18', '6 Rue de luniversité', '69100', 'Villeurbanne'),
(14, 'Jourdin', ' CHRISTIAN', '1978-05-12', ' 2 Rue de l\'université', ' 69100', ' Villeurbanne'),
(15, 'Dumez', ' CHRISTIAN', '1978-05-12', ' 43 Cours Emile Zola', ' 69100', ' Villeurbanne'),
(16, 'Fayolle', 'Alain', '2014-04-08', '5 Cours Emile Zola', '69100', 'Villeurbanne'),
(17, 'Brun', 'Bernard', '2014-04-13', '5 place du peuple', '42000', 'Saint Etienne'),
(29, 'Peugeot', ' Thierry', '1956-06-12', ' Rue de la mer', ' 01190', ' JASSERON'),
(31, 'FLOQUET', ' Cyprien', '1996-04-15', ' Rue de la mer', ' 13000', ' Marseille'),
(34, 'CHEMIN', ' Paul', '1956-04-12', ' 3 rue des lilas', ' 83000', ' TOULON'),
(36, 'CHEMIN', ' Marius', '1996-04-15', ' 3 rue des lilas', ' 13000', ' Marseille'),
(37, 'CHEMIN', ' Marius', '1996-04-15', ' 3 rue des lilas', ' 13000', ' Marseille'),
(38, 'belkadi', ' Antoine', '1956-04-12', ' 3 rue des lilas', ' 13000', ' SAINT GENIS LES OLLIERES'),
(39, 'belkadi', ' Antoine', '1956-04-12', ' 3 rue des lilas', ' 13000', ' SAINT GENIS LES OLLIERES'),
(40, 'CHAVAND', ' David', '1996-04-15', ' Rue de la mer', ' 13000', ' SAINT GENIS LES OLLIERES'),
(41, 'CHAVAND', ' David', '1996-04-15', ' Rue de la mer', ' 13000', ' SAINT GENIS LES OLLIERES'),
(44, 'FLOQUET', ' Cyprien', '1996-04-15', ' 3 rue des lilas', ' 13000', ' SAINT GENIS LES OLLIERES'),
(45, 'FLOQUET', ' Cyprien', '1996-04-15', ' 3 rue des lilas', ' 13000', ' SAINT GENIS LES OLLIERES'),
(100, 'GALLOIS', 'Bertrand', '2018-02-04', '43 Rue louis Pradel', '69290', 'SAINT GENIS LES OLLIERES'),
(101, 'Alfred', 'Bernard', '2019-07-04', '43 Rue louis Pradel', '69290', 'SAINT GENIS LES OLLIERES');



