-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: wshopdb
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `idarticle` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) DEFAULT NULL,
  `desc` varchar(500) DEFAULT NULL,
  `prix` double DEFAULT '0',
  `img` varchar(200) DEFAULT 'images/OXO---Homepage_39.jpg',
  `qte` int(11) DEFAULT '0',
  `dateajout` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idarticle`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'Clé 32 Go','                        eeee\r\n                    ',33.2,'produitImages/cle32.jpg',4,'2014-12-27 11:31:29'),(2,'Test Produit MODIF','                        desc2 Modif',5.32,'produitImages/default.gif',12,'2014-12-27 12:06:58'),(3,'Etuit Tablette 1',NULL,7,'produitImages/etui1.jpg',5,'2013-12-27 18:27:23'),(4,'Etuit iPad 1',NULL,8,'produitImages/etui2.jpg',87,'2014-12-27 18:41:47'),(5,'Cle usb Nikon',NULL,30,'produitImages/nikon.jpg',4,'2012-12-27 18:41:47'),(6,'Clé usb ',NULL,21,'produitImages/trus.jpg',2,'2014-12-27 18:41:47'),(7,'Etuit 2 ',NULL,18,'produitImages/etui1.jpg',5,'2014-12-27 18:41:47'),(8,'Clé 32Go 2',NULL,40,'produitImages/cle32.jpg',77,'2014-12-27 18:41:47'),(9,'Etuit iPad 2',NULL,19,'produitImages/etui2.jpg',3,'2014-12-27 18:41:47'),(10,'Marioo',NULL,10,'produitImages/mario.jpg',7,'2014-12-27 18:41:47'),(11,'Cléé',NULL,22,'produitImages/cle32.jpg',3,'2014-12-27 18:41:47'),(12,'Clé usb nikon 2',NULL,30,'produitImages/nikon.jpg',8,'2014-12-27 19:04:21'),(13,'Clé Trus',NULL,23,'produitImages/trus.jpg',9,'2014-12-27 19:04:21');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `login` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `dtnaissance` datetime DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('ali','123','Ali','ila','1988-10-12 00:00:00'),('test','E','Z','sakZhana2','1988-10-12 00:00:00');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `idcommande` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) DEFAULT NULL,
  `datecmd` datetime DEFAULT CURRENT_TIMESTAMP,
  `prixtotale` double DEFAULT NULL,
  `etat` int(11) DEFAULT '0',
  PRIMARY KEY (`idcommande`),
  KEY `Login_idx` (`login`),
  CONSTRAINT `Login` FOREIGN KEY (`login`) REFERENCES `client` (`login`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1002,'ali','2015-01-01 20:21:47',93,1),(1003,'ali','2015-01-01 20:24:40',7,2),(1004,'ali','2015-01-01 20:35:44',93,1),(1005,'ali','2015-01-01 22:15:26',77,1),(1006,'test','2015-01-01 22:34:04',5.32,0);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ligne_commande`
--

DROP TABLE IF EXISTS `ligne_commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ligne_commande` (
  `idcmd` int(11) NOT NULL,
  `idart` int(11) NOT NULL,
  `nbr` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcmd`,`idart`),
  KEY `idArt_idx` (`idart`),
  CONSTRAINT `idArt` FOREIGN KEY (`idart`) REFERENCES `article` (`idarticle`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `idCmd` FOREIGN KEY (`idcmd`) REFERENCES `commande` (`idcommande`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ligne_commande`
--

LOCK TABLES `ligne_commande` WRITE;
/*!40000 ALTER TABLE `ligne_commande` DISABLE KEYS */;
INSERT INTO `ligne_commande` VALUES (1002,1,1),(1002,5,2),(1003,3,1),(1004,1,1),(1004,5,2),(1005,3,2),(1005,6,3),(1006,2,1);
/*!40000 ALTER TABLE `ligne_commande` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-01 23:31:43
