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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOSTFOUND`
--

LOCK TABLES `LOSTFOUND` WRITE;
/*!40000 ALTER TABLE `LOSTFOUND` DISABLE KEYS */;
INSERT INTO `LOSTFOUND` VALUES (20,'2017-04-02','kk street','atlanta',34519,'F'),(30,'2017-04-03','kjk street','eee',30301,'F'),(32,'2017-04-03','bnbn street','gwinnet',30318,'F'),(33,'2017-04-04','hh street','fulton',30311,'L'),(35,'2017-04-18','kk street','fulton',30323,'F'),(36,'2017-04-17','green street','fulton',30314,'F'),(42,'2017-04-18','bb street','fulton',30314,'L'),(44,'2017-04-18','gg street','fulton',30318,'F'),(47,'2017-04-02','peachtree street','fulton',30329,'L'),(48,'2017-04-20','north street','gwinnett',30519,'F'),(49,'2017-04-03','hello street','gwinnett',30314,'L'),(50,'2017-04-19','pp street','gwinnett',30328,'F'),(55,'2017-04-18','pp Avenue','Dekalb',30318,'F'),(56,'2017-04-11','abc street','clarke',30605,'F'),(57,'2017-04-07','cba street','clarke',30605,'F'),(58,'2017-04-05','abc street','clarke',0,'L'),(59,'2017-04-19','jdnlkfkmeo','dekalb',30033,'L');
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PET`
--

LOCK TABLES `PET` WRITE;
/*!40000 ALTER TABLE `PET` DISABLE KEYS */;
INSERT INTO `PET` VALUES (11,'Cat','hello kitty','fancy','brown','gold',2,'F','nn1234567','no',NULL,20,NULL),(20,'Dog','nmnm','viviv','boue','red',3,'F','oo123456','jkjk',NULL,30,NULL),(22,'Dog','seven','chihuahua','black','brown',2,'M','mnm245','balabala',NULL,32,NULL),(23,'Cat','ginger','maine coon','yellow','black',4,'M','mm3232','it\'s gone',NULL,33,NULL),(24,'Cat','unknown','Persian','black','white',2,'M','cc1234567','unknown',NULL,35,NULL),(25,'Bird','unknown','finch','black','brown',2,'M','kk121212','it\'s green',NULL,36,NULL),(31,'Dog','didi','pug','black','white',3,'M','cc1234567','can\'t find it',NULL,42,NULL),(33,'Dog','eight','chihuahua','black','white',2,'M','nn1234567','',NULL,44,NULL),(36,'Dog','bling','boxer','black','brown',2,'M','kk123456','I can\'t find it since 9am.',NULL,47,NULL),(37,'Dog','unknown','boxer','black','white',1,'F','kk323232','it\'s cute. hope someone could bring it to home',NULL,48,NULL),(38,'Dog','coco','pug','black','grey',3,'M','new123456','I don\'t know',NULL,49,NULL),(39,'Dog','unknown','pug','black','white',2,'F','mmm12345678','I found it',NULL,50,NULL),(43,'Dog','Harbor','bulldog','black','brown',2,'M','cc12121212','',NULL,55,NULL),(44,'Dog','abe','bulldog','black','white',5,'M','','',NULL,56,NULL),(45,'Dog','unknown','bulldog','brown','white',5,'M','','',NULL,57,NULL),(46,'Dog','abe','chihuahua','hazel','brown',5,'M','','',NULL,58,NULL),(47,'Dog','fluffy','unkown','black','white',4,'F','dhbjklj1','fjsnilkvnd,',NULL,59,NULL);
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
INSERT INTO `PUT_INFORMATION` VALUES (3,30,'2017-04-13 16:39:08',NULL),(3,32,'2017-04-18 23:22:38',NULL),(3,35,'2017-04-19 15:45:37',NULL),(6,44,'2017-04-19 22:14:57',NULL),(7,20,'2017-04-12 11:23:40',NULL),(7,55,'2017-04-20 14:43:15',NULL),(9,33,'2017-04-19 15:36:28',NULL),(9,36,'2017-04-19 15:54:19',NULL),(9,48,'2017-04-20 09:06:34',NULL),(16,42,'2017-04-19 21:52:50',NULL),(17,47,'2017-04-20 08:57:03',NULL),(17,50,'2017-04-20 09:29:44',NULL),(17,58,'2017-04-20 17:07:54',NULL),(18,49,'2017-04-20 09:27:34',NULL),(18,56,'2017-04-20 17:03:41',NULL),(18,57,'2017-04-20 17:04:59',NULL),(24,59,'2017-04-20 17:20:28',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SHELTER`
--

LOCK TABLES `SHELTER` WRITE;
/*!40000 ALTER TABLE `SHELTER` DISABLE KEYS */;
INSERT INTO `SHELTER` VALUES (1,'Best Friends Pet Adoption Center','\n4874 S Atlanta Rd SE, Smyrna, GA 30080'),(2,'PAWS Atlanta','5287 Covington Hwy, Decatur, GA 30035');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'huih','kdkdkd','gg@gmail.com',12345678),(3,'boby','ccc','nvnvnv@gmail.com',898989),(6,'sumi2017','kkk','vivi@yahoo.com',987654321),(7,'babe','jjj','babe@gmail.com',12345678),(9,'coach','aaa','hi@gmail.com',123456789),(16,'xuxu','ooo','hihi@gmail.com',12345678),(17,'su2017','sss','su@gmail.com',19090909),(18,'brad2017','bbb','brad2017@gmail.com',229787878),(20,'hello2017','kkk','bu@gmail.com',23232323),(21,'vvvv','nnn','nvnv@gmail.com',56565656),(24,'amani','amani','amani@gmail.com',123456),(25,'kim','1234','kk@gmail.com',123131);
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

-- Dump completed on 2017-04-20 17:59:15
