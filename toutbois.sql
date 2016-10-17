--
-- Base de données :  `toutbois`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(100) NOT NULL,
  `idSociete` int(100) NOT NULL,
  `enseigneClient` varchar(30) NOT NULL,
  `siretClient` varchar(14) NOT NULL,
  `nbrCommandesClient` int(100) NOT NULL,
  `nomRepresentantClient` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `idSociete`, `enseigneClient`, `siretClient`, `nbrCommandesClient`, `nomRepresentantClient`) VALUES
(1, 3, 'Ikea', '15489654712548', 10, 'Morgane');

-- --------------------------------------------------------

--
-- Structure de la table `prospect`
--

CREATE TABLE `prospect` (
  `idProspect` int(100) NOT NULL,
  `idSociete` int(100) NOT NULL,
  `enseigneProspect` varchar(30) NOT NULL,
  `siretProspect` varchar(14) NOT NULL,
  `nomRepresentantProspect` varchar(30) NOT NULL,
  `dateDerniereVisiteProspect` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `prospect`
--

INSERT INTO `prospect` (`idProspect`, `idSociete`, `enseigneProspect`, `siretProspect`, `nomRepresentantProspect`, `dateDerniereVisiteProspect`) VALUES
(2, 10, 'Taratata', '54785412459658', 'Fox', '2016-04-11'),
(3, 13, 'Boulanger', '45741854741254', 'Morgane', '2016-02-14');

-- --------------------------------------------------------

--
-- Structure de la table `representant`
--

CREATE TABLE `representant` (
  `idRepresentant` int(100) NOT NULL,
  `idSociete` int(100) NOT NULL,
  `nomRepresentant` varchar(30) NOT NULL,
  `salaireFixeRepresentant` float NOT NULL,
  `tauxCommissionRepresentant` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `representant`
--

INSERT INTO `representant` (`idRepresentant`, `idSociete`, `nomRepresentant`, `salaireFixeRepresentant`, `tauxCommissionRepresentant`) VALUES
(26, 11, 'Morgane', 1425.21, 6.74),
(30, 12, 'Fox', 5555.24, 9.5);

-- --------------------------------------------------------

--
-- Structure de la table `societe`
--

CREATE TABLE `societe` (
  `idSociete` int(10) NOT NULL,
  `nomContactSociete` varchar(30) NOT NULL,
  `prenomContactSociete` varchar(30) DEFAULT NULL,
  `adresseSociete` varchar(30) NOT NULL,
  `complementAdresseSociete` varchar(30) DEFAULT NULL,
  `cpSociete` int(5) NOT NULL,
  `villeSociete` varchar(30) NOT NULL,
  `cedexSociete` varchar(30) DEFAULT NULL,
  `paysSociete` varchar(30) NOT NULL,
  `telephone1Societe` varchar(12) NOT NULL,
  `telephone2Societe` varchar(12) DEFAULT NULL,
  `faxSociete` varchar(12) DEFAULT NULL,
  `mailSociete` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `societe`
--

INSERT INTO `societe` (`idSociete`, `nomContactSociete`, `prenomContactSociete`, `adresseSociete`, `complementAdresseSociete`, `cpSociete`, `villeSociete`, `cedexSociete`, `paysSociete`, `telephone1Societe`, `telephone2Societe`, `faxSociete`, `mailSociete`) VALUES
(3, 'Durand', '', '25 rue de Metz', '', 59200, 'Tourcoing', '', 'France', '032015478585', '', '', 'ikea @ikea.com'),
(10, 'Nagui', 'Nag', '75 rue des Machins', '', 75000, 'Paris', '', 'France', '+33325749854', '', '', 'nag@nag.fr'),
(11, 'Morgane', 'Clara', '15 rue des Diables', '', 75000, 'Paris', '', 'France', '+33647512463', '', '', 'clara@morgane.fr'),
(12, 'Fox', 'Mégane', '98 rue de Linselle', '', 59000, 'Lille', '', 'France', '+33654748510', '', '', 'meg@fox.fr'),
(13, 'Bagueppi', 'Robert', '49 rue du Pains', '', 59000, 'Lille', '99', 'France', '+33654178745', '', '', 'boul@anger.fr');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `prospect`
--
ALTER TABLE `prospect`
  ADD PRIMARY KEY (`idProspect`);

--
-- Index pour la table `representant`
--
ALTER TABLE `representant`
  ADD PRIMARY KEY (`idRepresentant`);

--
-- Index pour la table `societe`
--
ALTER TABLE `societe`
  ADD PRIMARY KEY (`idSociete`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `prospect`
--
ALTER TABLE `prospect`
  MODIFY `idProspect` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `representant`
--
ALTER TABLE `representant`
  MODIFY `idRepresentant` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
