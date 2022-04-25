-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: social
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `id` int DEFAULT NULL,
  `status` varchar(250) DEFAULT NULL,
  `likes` int DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`status_id`),
  KEY `id_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,1,NULL,0,'tahmid@gmail.com'),(2,1,'tamim\r\n',0,''),(3,1,'shab-e-barat',0,''),(4,1,'areee',0,''),(5,0,'taasdg',0,''),(6,0,'asgs',0,''),(7,1,'ajke varsity gesilam',0,''),(8,1,'ajke varsity gesilam',0,''),(9,NULL,'tu tu tu tu tu tara',0,'tahmid.islam22@gmail.com'),(10,NULL,'ading status',0,'tahmid@aiub.edu'),(11,0,'tamim',0,NULL),(12,1,'tamim',0,NULL),(13,1,'tamim',0,NULL),(14,1,'tamim',0,'tahmid@gmail.com'),(15,1,'tamim',0,'tahmid@gmail.com'),(16,1,'sdga',0,'tahmid@gmail.com'),(17,1,'tamim',0,'tahmid@gmail.com'),(18,1,'tamim',0,'tahmid@gmail.com'),(19,1,'sdga',0,'tahmid@gmail.com'),(20,1,'sdga',0,'tahmid@gmail.com');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-26  4:39:03
