--
-- Table structure for table `Albums`
--
CREATE TABLE `Albums` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(200) NOT NULL,
  `lanzado` date NOT NULL,
  `precio` double NOT NULL,
  `genero` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO `albums` (`id`, `titulo`, `lanzado`, `precio`, `genero`) VALUES (NULL, 'Luz de mi vida', '2022-01-06', '20.000', 'Pop');