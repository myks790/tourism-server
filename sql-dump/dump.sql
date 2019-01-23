-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: tourism
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'2019-01-23 07:27:46','2019-01-23 07:27:46','힐링',0),(2,'2019-01-23 07:27:46','2019-01-23 07:27:46','자연',0),(3,'2019-01-23 07:27:46','2019-01-23 07:27:46','관광',0),(4,'2019-01-23 07:27:46','2019-01-23 07:27:46','카페',0),(5,'2019-01-23 07:27:46','2019-01-23 07:27:46','오름',0),(6,'2019-01-23 07:27:46','2019-01-23 07:27:46','바다',0),(7,'2019-01-23 07:27:46','2019-01-23 07:27:46','먹방',0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `downloaded_plan`
--

DROP TABLE IF EXISTS `downloaded_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `downloaded_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `plan_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiwy5vgmt6cc40lr6sgvw06bb1` (`plan_id`),
  KEY `FKj28lc39fd8g9kr9h8j1c902yo` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `downloaded_plan`
--

LOCK TABLES `downloaded_plan` WRITE;
/*!40000 ALTER TABLE `downloaded_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `downloaded_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `information` varchar(255) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `place_category` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (1,'2019-01-23 07:27:46','','해발 : 1,950m','2019-01-23 07:27:46','백록담 : 제주특별자치도 서귀포 토평동 산 15번지','한라산','TOURIST_SPOTS',0),(2,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EB%84%A5%EC%8A%A8%EC%BB%B4%ED%93%A8%ED%84%B0%EB%B0%95%EB%AC%BC%EA%B4%80.jpg','메가티켓 - 성인:8,000원 청소년:6,000원 어린이:12,000원 / 기가티켓 - 성인:12,000원 / 테라티켓 - 성인2+어린이2:25,000원','2019-01-23 07:27:46','제주 1100로 3198-8 NXC센터 (우) 63091','넥슨컴퓨터박물관','TOURIST_SPOTS',0),(3,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%A0%9C%EC%A3%BC%EB%8F%99%EB%AC%B8%EC%8B%9C%EC%9E%A5.jpg','개장시간 : 오전 5:00 - 오후 8:00','2019-01-23 07:27:46','제주 이도1동 1329-6','제주동문시장','TOURIST_SPOTS',0),(4,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EB%A9%94%EC%9D%B4%EC%A6%88%EB%9E%9C%EB%93%9C.jpg','성인:11,000원 청소년/군인:8,000원 어린이/경로/유공자:8,000원 장애인:5,000원','2019-01-23 07:27:46','제주 구좌읍 비자림로 2134-47 (우) 63351','메이즈랜드','TOURIST_SPOTS',0),(5,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%9B%94%EC%A0%95%EB%A6%AC%ED%95%B4%EB%B3%80.jpg','','2019-01-23 07:27:46','제주 구좌읍 월정리 33-3','월정리해변','TOURIST_SPOTS',0),(6,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%A0%9C%EC%A3%BC%EB%B6%88%EB%B9%9B%EC%A0%95%EC%9B%90.jpg','일반:12,000원 (SNS 인증시 10% 할인) 어린이/제주도민/장애인/노인:8,000원 (신분증 제시, 단체 10% 할인)','2019-01-23 07:27:46','제주 애월읍 평화로 2346 (우) 63066','제주불빛정원','TOURIST_SPOTS',0),(7,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%ED%85%8C%EC%A7%80%EC%9B%80%20%EC%A0%9C%EC%A3%BC.jpg','성인:10,000원 군경/장애인/경로:8,000원 청소년:9,000원 어린이:8,000원 만36개월:무료','2019-01-23 07:27:46','제주 애월읍 평화로 2159 (우) 695-910','테지움 제주','TOURIST_SPOTS',0),(8,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%A0%9C%EC%A3%BC%EC%8B%9C%20%EB%AF%BC%EC%86%8D%20%EC%98%A4%EC%9D%BC%EC%8B%9C%EC%9E%A5.jpg','매 2일, 7일날 열림','2019-01-23 07:27:46','제주 오일장서길 26 (우) 63116','제주시 민속 오일시장','TOURIST_SPOTS',0),(9,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%A0%9C%EC%A3%BC%20%EC%A0%88%EB%AC%BC%20%EC%9E%90%EC%97%B0%20%ED%9C%B4%EC%96%91%EB%A6%BC.jpg','일반:1,000원 청소년 600원 어린이 300원','2019-01-23 07:27:46','위치 : 제주특별자치도 제주시 명림로 584','제주 절물 자연 휴양림','TOURIST_SPOTS',0),(10,'2019-01-23 07:27:46','https://raw.githubusercontent.com/WonBeomChoi/kkc/master/image/%EC%83%9D%EA%B0%81%ED%95%98%EB%8A%94%20%EC%A0%95%EC%9B%90.jpg','성인:12,000원 청소년:10,000원 경로:10,000원 어린이:7,000원','2019-01-23 07:27:46','제주 한경면 저지리 1534 (우) 695-947','생각하는 정원','TOURIST_SPOTS',0);
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `number_of_recommendation` int(11) DEFAULT NULL,
  `number_of_shares` int(11) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `shared` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK271ok4ss5pcte25w6o3hvv60x` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,'2019-01-23 07:27:46','2019-01-23 07:27:46',17,52,3,_binary '','원범이와 함께하는 힐링 여행',0,1),(2,'2019-01-23 07:27:46','2019-01-23 07:27:46',22,48,2,_binary '','재희의 힐링 여행기',0,2),(3,'2019-01-23 07:27:46','2019-01-23 07:27:46',0,0,2,_binary '\0','혜린네 가족여행',0,3),(4,'2019-01-23 07:27:46','2019-01-23 07:27:46',7,3,3,_binary '','2명이 가면 3명이 되어서 돌아오는 제주 여행',0,7),(5,'2019-01-23 07:27:46','2019-01-23 07:27:46',9,17,1,_binary '','아이돌 강재희의 제주 투어 코스',0,5),(6,'2019-01-23 07:27:46','2019-01-23 07:27:46',6,3,4,_binary '','제주 정복 가즈아',0,1),(7,'2019-01-23 07:27:46','2019-01-23 07:27:46',14,5,3,_binary '','3일 여행',0,6),(8,'2019-01-23 07:27:46','2019-01-23 07:27:46',0,0,3,_binary '\0','제주로의 우정 여행',0,2),(9,'2019-01-23 07:27:46','2019-01-23 07:27:46',41,63,1,_binary '','연예인 제주 투어 코스',0,3),(10,'2019-01-23 07:27:46','2019-01-23 07:27:46',0,0,2,_binary '\0','제주도 2일 정복',0,5);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_categories`
--

DROP TABLE IF EXISTS `plan_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plan_categories` (
  `plan_id` int(11) NOT NULL,
  `categories_id` int(11) NOT NULL,
  KEY `FKjdwcv8bhqca5y6se0dgwes6jb` (`categories_id`),
  KEY `FKqc6cos0xs84hxfl59kae3b6o9` (`plan_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_categories`
--

LOCK TABLES `plan_categories` WRITE;
/*!40000 ALTER TABLE `plan_categories` DISABLE KEYS */;
INSERT INTO `plan_categories` VALUES (1,4),(2,1),(3,3),(4,1),(5,4),(6,5),(7,6),(8,3),(9,4),(10,3);
/*!40000 ALTER TABLE `plan_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `route_order` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `place_id` int(11) DEFAULT NULL,
  `plan_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdhwtixp8nr89pidfpgplkhmc7` (`place_id`),
  KEY `FKiriymbg09d9dbihd9lu1m3lkk` (`plan_id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'2019-01-23 07:27:46',1,'힘들겠다','2019-01-23 07:27:46',1,0,1,1),(2,'2019-01-23 07:27:46',1,'맛있겠다','2019-01-23 07:27:46',2,0,3,1),(3,'2019-01-23 07:27:46',2,NULL,'2019-01-23 07:27:46',1,0,2,1),(4,'2019-01-23 07:27:46',2,NULL,'2019-01-23 07:27:46',2,0,4,1),(5,'2019-01-23 07:27:46',3,NULL,'2019-01-23 07:27:46',1,0,7,1),(6,'2019-01-23 07:27:46',1,NULL,'2019-01-23 07:27:46',1,0,5,2),(7,'2019-01-23 07:27:46',1,'시장하구나 시장을가자','2019-01-23 07:27:46',2,0,3,2),(8,'2019-01-23 07:27:46',2,NULL,'2019-01-23 07:27:46',1,0,9,2),(9,'2019-01-23 07:27:46',1,NULL,'2019-01-23 07:27:46',1,0,1,3),(10,'2019-01-23 07:27:46',2,NULL,'2019-01-23 07:27:46',1,0,5,3),(11,'2019-01-23 07:27:46',1,NULL,'2019-01-23 07:27:46',1,0,3,4),(12,'2019-01-23 07:27:46',2,NULL,'2019-01-23 07:27:46',1,0,10,4),(13,'2019-01-23 07:27:47',2,NULL,'2019-01-23 07:27:47',2,0,6,4),(14,'2019-01-23 07:27:47',2,'카페카페','2019-01-23 07:27:47',3,0,NULL,4),(15,'2019-01-23 07:27:47',3,NULL,'2019-01-23 07:27:47',1,0,8,4),(16,'2019-01-23 07:27:47',3,NULL,'2019-01-23 07:27:47',2,0,2,4),(17,'2019-01-23 07:27:47',1,NULL,'2019-01-23 07:27:47',1,0,7,5),(18,'2019-01-23 07:27:47',1,NULL,'2019-01-23 07:27:47',2,0,3,5),(19,'2019-01-23 07:27:47',1,NULL,'2019-01-23 07:27:47',1,0,5,6),(20,'2019-01-23 07:27:47',1,NULL,'2019-01-23 07:27:47',2,0,2,6),(21,'2019-01-23 07:27:47',2,NULL,'2019-01-23 07:27:47',1,0,1,6),(22,'2019-01-23 07:27:47',3,NULL,'2019-01-23 07:27:47',1,0,8,6),(23,'2019-01-23 07:27:47',3,NULL,'2019-01-23 07:27:47',2,0,6,6),(24,'2019-01-23 07:27:47',3,NULL,'2019-01-23 07:27:47',3,0,4,6),(25,'2019-01-23 07:27:47',4,NULL,'2019-01-23 07:27:47',1,0,7,6),(26,'2019-01-23 07:27:47',4,NULL,'2019-01-23 07:27:47',2,0,10,6);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2019-01-23 07:27:45','2019-01-23 07:27:45','guest',0),(2,'2019-01-23 07:27:46','2019-01-23 07:27:46','guest1',0),(3,'2019-01-23 07:27:46','2019-01-23 07:27:46','guest2',0),(4,'2019-01-23 07:27:46','2019-01-23 07:27:46','guest3',0),(5,'2019-01-23 07:27:46','2019-01-23 07:27:46','guest4',0),(6,'2019-01-23 07:27:46','2019-01-23 07:27:46','guest5',0),(7,'2019-01-23 07:27:46','2019-01-23 07:27:46','오현규',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 16:28:07
