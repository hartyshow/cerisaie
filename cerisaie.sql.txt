-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 13 Avril 2018 à 11:18
-- Version du serveur :  10.1.8-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cerisaie`
--

-- --------------------------------------------------------

--
-- Structure de la table `activite`
--

CREATE TABLE `activite` (
  `CodeSport` int(11) NOT NULL,
  `DateJour` date NOT NULL,
  `NumSej` int(11) NOT NULL,
  `NbLoc` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `activite`
--

INSERT INTO `activite` (`CodeSport`, `DateJour`, `NumSej`, `NbLoc`) VALUES
(1, '2012-07-05', 3, 1),
(1, '2012-07-20', 13, 1),
(2, '2012-07-05', 2, 1),
(2, '2012-07-10', 7, 1),
(2, '2012-07-15', 7, 2),
(3, '2012-07-07', 4, 2),
(3, '2012-07-14', 9, 3),
(4, '2012-07-09', 5, 2),
(5, '2012-07-07', 6, 3),
(5, '2012-07-12', 8, 2);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `NumCli` int(11) NOT NULL,
  `NomCli` varchar(100) COLLATE utf8_bin NOT NULL,
  `AdrRueCli` varchar(50) COLLATE utf8_bin NOT NULL,
  `CpCli` int(11) NOT NULL,
  `VilleCli` varchar(50) COLLATE utf8_bin NOT NULL,
  `PieceCli` varchar(2) COLLATE utf8_bin NOT NULL,
  `NumPieceCli` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`NumCli`, `NomCli`, `AdrRueCli`, `CpCli`, `VilleCli`, `PieceCli`, `NumPieceCli`) VALUES
(1, 'Merle', '3 rue des lilas', 69005, 'Lyon', 'CI', 2356786),
(2, 'Poussin', 'rue des tulipes', 69007, 'Lyon', 'CI', 347835684),
(3, 'Rossignol', '3 rue des glaieuls', 69002, 'Lyon', 'CI', 23556645),
(4, 'Canaris', '10 rue des acacias', 69005, 'Lyon', 'PS', 235667),
(5, 'Piaf', '4 rue des pivoines', 69007, 'Lyon', 'PC', 347235684),
(6, 'Rose', '5 rue des marguerites', 69160, 'Tassin', 'CI', 56947341),
(7, 'Poussin', '20 rue des iris', 69400, 'Villefranche', 'CI', 234511),
(8, 'Piactivitet', 'rue des pétunias', 69340, 'Francheville', 'CI', 347289),
(9, 'Aigle', '3 rue des geraniums', 69290, 'Saint Consorce', 'CI', 234591),
(10, 'Mesange', '10 rue des aubépines', 69290, 'Craponne', 'PS', 2398643),
(11, 'Aactivitette', '4 rue des orchidés', 69500, 'Bron', 'PC', 34723896),
(12, 'Buse', '5 rue des nénuphars', 69200, 'Venissieux', 'CI', 569475342);

-- --------------------------------------------------------

--
-- Structure de la table `emplacement`
--

CREATE TABLE `emplacement` (
  `NumEmpl` int(11) NOT NULL,
  `CodeTypeE` int(11) NOT NULL,
  `SurfaceEmpl` smallint(6) NOT NULL,
  `NbPersMaxEmpl` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `emplacement`
--

INSERT INTO `emplacement` (`NumEmpl`, `CodeTypeE`, `SurfaceEmpl`, `NbPersMaxEmpl`) VALUES
(1, 1, 4, 4),
(2, 1, 4, 4),
(3, 1, 6, 5),
(4, 1, 8, 8),
(5, 2, 8, 12),
(6, 2, 10, 14),
(7, 2, 12, 16),
(8, 3, 12, 12),
(9, 3, 10, 8),
(10, 4, 19, 15),
(11, 4, 18, 16),
(12, 4, 18, 16),
(13, 4, 20, 25);

-- --------------------------------------------------------

--
-- Structure de la table `sejour`
--

CREATE TABLE `sejour` (
  `NumSej` int(11) NOT NULL,
  `NumCli` int(11) NOT NULL,
  `NumEmpl` int(11) NOT NULL,
  `DatedebSej` date NOT NULL,
  `DateFinSej` date DEFAULT NULL,
  `NbPersonnes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `sejour`
--

INSERT INTO `sejour` (`NumSej`, `NumCli`, `NumEmpl`, `DatedebSej`, `DateFinSej`, `NbPersonnes`) VALUES
(1, 1, 1, '2012-07-01', '2012-07-10', 4),
(2, 2, 3, '2012-07-02', '2012-07-13', 4),
(3, 3, 4, '2012-07-01', '2012-07-14', 4),
(4, 4, 2, '2012-07-05', '2012-07-15', 5),
(5, 5, 5, '2012-07-08', '2012-07-25', 8),
(6, 6, 13, '2012-07-09', '2012-07-23', 11),
(7, 7, 7, '2012-07-10', '2012-07-20', 6),
(8, 8, 8, '2012-07-11', '2012-07-26', 2),
(9, 9, 9, '2012-07-12', '2012-07-15', 3),
(10, 10, 10, '2012-07-13', '2012-07-17', 7),
(11, 11, 11, '2012-07-14', '2012-07-19', 6),
(12, 12, 12, '2012-07-15', '2012-07-21', 5),
(13, 2, 13, '2012-07-15', '2012-07-25', 14),
(14, 3, 3, '2012-07-16', '2012-07-23', 5),
(15, 4, 4, '2012-07-16', '2012-07-26', 4),
(16, 5, 5, '2012-07-17', '2012-07-28', 4);

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

CREATE TABLE `sport` (
  `CodeSport` int(11) NOT NULL,
  `LibelleSport` varchar(100) COLLATE utf8_bin NOT NULL,
  `UniteTpsSport` varchar(20) COLLATE utf8_bin NOT NULL,
  `TarifUnite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `sport`
--

INSERT INTO `sport` (`CodeSport`, `LibelleSport`, `UniteTpsSport`, `TarifUnite`) VALUES
(1, 'Tennis', '1 heure', 9),
(2, 'VTT', '1/2 journée', 15),
(3, 'Planche-vo', '1 journée', 22),
(4, 'Pédalo', '2 heures', 8),
(5, 'Canoé', '1/2 journée', 10);

-- --------------------------------------------------------

--
-- Structure de la table `type_emplacement`
--

CREATE TABLE `type_emplacement` (
  `CodeTypeE` int(11) NOT NULL,
  `LIBTYPEPL` varchar(30) COLLATE utf8_bin NOT NULL,
  `TARIFTYPEPL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `type_emplacement`
--

INSERT INTO `type_emplacement` (`CodeTypeE`, `LIBTYPEPL`, `TARIFTYPEPL`) VALUES
(1, 'TENTE', 19),
(2, 'CARAVANE', 29),
(3, 'CAMPING-CAR', 32),
(4, 'BUNGALOW', 28);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `activite`
--
ALTER TABLE `activite`
  ADD PRIMARY KEY (`CodeSport`,`DateJour`,`NumSej`),
  ADD KEY `NumSej` (`NumSej`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`NumCli`);

--
-- Index pour la table `emplacement`
--
ALTER TABLE `emplacement`
  ADD PRIMARY KEY (`NumEmpl`),
  ADD KEY `CodeTypeE` (`CodeTypeE`);

--
-- Index pour la table `sejour`
--
ALTER TABLE `sejour`
  ADD PRIMARY KEY (`NumSej`),
  ADD KEY `NumCli` (`NumCli`),
  ADD KEY `NumEmpl` (`NumEmpl`);

--
-- Index pour la table `sport`
--
ALTER TABLE `sport`
  ADD PRIMARY KEY (`CodeSport`);

--
-- Index pour la table `type_emplacement`
--
ALTER TABLE `type_emplacement`
  ADD PRIMARY KEY (`CodeTypeE`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `NumCli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `activite`
--
ALTER TABLE `activite`
  ADD CONSTRAINT `activite_ibfk_1` FOREIGN KEY (`CodeSport`) REFERENCES `sport` (`CodeSport`),
  ADD CONSTRAINT `activite_ibfk_2` FOREIGN KEY (`NumSej`) REFERENCES `sejour` (`NumSej`) ON DELETE CASCADE;

--
-- Contraintes pour la table `emplacement`
--
ALTER TABLE `emplacement`
  ADD CONSTRAINT `emplacement_ibfk_1` FOREIGN KEY (`CodeTypeE`) REFERENCES `type_emplacement` (`CodeTypeE`);

--
-- Contraintes pour la table `sejour`
--
ALTER TABLE `sejour`
  ADD CONSTRAINT `sejour_ibfk_1` FOREIGN KEY (`NumCli`) REFERENCES `client` (`NumCli`),
  ADD CONSTRAINT `sejour_ibfk_2` FOREIGN KEY (`NumEmpl`) REFERENCES `emplacement` (`NumEmpl`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
