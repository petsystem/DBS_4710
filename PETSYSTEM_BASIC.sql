-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: PETSYSTEM
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `LOSTFOUND`
--

DROP TABLE IF EXISTS `LOSTFOUND`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOSTFOUND` (
  `lf_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `street_name` varchar(45) NOT NULL,
  `county` varchar(45) DEFAULT NULL,
  `zip_code` int(11) NOT NULL,
  `status_flag` enum('L','F') NOT NULL,
  PRIMARY KEY (`lf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOSTFOUND`
--

LOCK TABLES `LOSTFOUND` WRITE;
/*!40000 ALTER TABLE `LOSTFOUND` DISABLE KEYS */;
INSERT INTO `LOSTFOUND` VALUES (20,'2017-04-02','kk street','atlanta',34519,'F'),(24,'2016-04-01','kjdkjk','nbknbk',30321,'L'),(25,'2017-04-01','pilipala','usa',123123,'F');
/*!40000 ALTER TABLE `LOSTFOUND` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PET`
--

DROP TABLE IF EXISTS `PET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PET` (
  `pet_id` int(11) NOT NULL AUTO_INCREMENT,
  `pet_type` varchar(45) NOT NULL,
  `pet_name` varchar(45) DEFAULT NULL,
  `pet_breed` varchar(45) DEFAULT NULL,
  `pet_eyecolor` varchar(45) DEFAULT NULL,
  `pet_bodycolor` varchar(45) DEFAULT NULL,
  `pet_age` int(11) DEFAULT NULL,
  `pet_sex` enum('M','F') DEFAULT NULL,
  `mchip` varchar(45) DEFAULT NULL,
  `pet_discription` text,
  `pet_image` longblob,
  `pet_lfid` int(11) NOT NULL,
  `shelter_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pet_id`),
  KEY `fk-shelter-id_idx` (`shelter_id`),
  KEY `fk_p_lfid_idx` (`pet_lfid`),
  CONSTRAINT `fk-shelter-id` FOREIGN KEY (`shelter_id`) REFERENCES `SHELTER` (`shelter_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_lfid` FOREIGN KEY (`pet_lfid`) REFERENCES `LOSTFOUND` (`lf_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PET`
--

LOCK TABLES `PET` WRITE;
/*!40000 ALTER TABLE `PET` DISABLE KEYS */;
INSERT INTO `PET` VALUES (11,'Cat','hello kitty','fancy','brown','gold',2,'F','nn1234567','no',NULL,20,NULL),(14,'Dog','visa','holu','grey','light blue',5,'F','bnknk','kjkjkjk',NULL,24,NULL),(15,'Dog','caixm','stupid ','black','white',7,'F','asd','so cute',NULL,25,NULL);
/*!40000 ALTER TABLE `PET` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PUT_INFORMATION`
--

DROP TABLE IF EXISTS `PUT_INFORMATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PUT_INFORMATION` (
  `user_id` int(11) NOT NULL,
  `lf_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `close_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`lf_id`),
  KEY `fk_userid_idx` (`user_id`),
  KEY `fk_lf_id_idx` (`lf_id`),
  CONSTRAINT `fk_u_id` FOREIGN KEY (`user_id`) REFERENCES `USER` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_u_lfid` FOREIGN KEY (`lf_id`) REFERENCES `LOSTFOUND` (`lf_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PUT_INFORMATION`
--

LOCK TABLES `PUT_INFORMATION` WRITE;
/*!40000 ALTER TABLE `PUT_INFORMATION` DISABLE KEYS */;
INSERT INTO `PUT_INFORMATION` VALUES (3,25,'2017-04-12 21:15:10',NULL),(6,24,'2017-04-12 16:12:32',NULL),(7,20,'2017-04-12 11:23:40',NULL);
/*!40000 ALTER TABLE `PUT_INFORMATION` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER PUT_INFORMATION_create_date BEFORE INSERT ON PUT_INFORMATION
	FOR EACH ROW SET NEW.create_date = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `SHELTER`
--

DROP TABLE IF EXISTS `SHELTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SHELTER` (
  `shelter_id` int(11) NOT NULL AUTO_INCREMENT,
  `shelter_name` varchar(45) NOT NULL,
  `shelter_address` varchar(45) NOT NULL,
  PRIMARY KEY (`shelter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SHELTER`
--

LOCK TABLES `SHELTER` WRITE;
/*!40000 ALTER TABLE `SHELTER` DISABLE KEYS */;
/*!40000 ALTER TABLE `SHELTER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'huih','kdkdkd','gg@gmail.com',12345678),(3,'boby','ccc','bg@gmail.com',888888888),(4,'mmm','kdjfk','kk@gmail.com',123456789),(6,'sumi2017','kkk','bcder@gmail.com',567890898),(7,'babe','jjj','babe@gmail.com',12345678);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `petsearch`
--

DROP TABLE IF EXISTS `petsearch`;
/*!50001 DROP VIEW IF EXISTS `petsearch`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `petsearch` AS SELECT 
 1 AS `status_flag`,
 1 AS `pet_type`,
 1 AS `pet_name`,
 1 AS `pet_breed`,
 1 AS `pet_eyecolor`,
 1 AS `pet_bodycolor`,
 1 AS `pet_age`,
 1 AS `pet_sex`,
 1 AS `mchip`,
 1 AS `pet_discription`,
 1 AS `user_name`,
 1 AS `phone_number`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'PETSYSTEM'
--

--
-- Dumping routines for database 'PETSYSTEM'
--

--
-- Final view structure for view `petsearch`
--

/*!50001 DROP VIEW IF EXISTS `petsearch`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `petsearch` AS select `L`.`status_flag` AS `status_flag`,`P`.`pet_type` AS `pet_type`,`P`.`pet_name` AS `pet_name`,`P`.`pet_breed` AS `pet_breed`,`P`.`pet_eyecolor` AS `pet_eyecolor`,`P`.`pet_bodycolor` AS `pet_bodycolor`,`P`.`pet_age` AS `pet_age`,`P`.`pet_sex` AS `pet_sex`,`P`.`mchip` AS `mchip`,`P`.`pet_discription` AS `pet_discription`,`U`.`user_name` AS `user_name`,`U`.`phone_number` AS `phone_number` from (((`user` `U` join `pet` `P`) join `lostfound` `L`) join `put_information` `PI`) where ((`U`.`user_id` = `PI`.`user_id`) and (`PI`.`lf_id` = `L`.`lf_id`) and (`P`.`pet_lfid` = `L`.`lf_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-12 21:51:55
