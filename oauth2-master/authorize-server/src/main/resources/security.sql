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
-- Current Database: `security`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `security` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `security`;

--
-- Table structure for table `oauth_client`
--

DROP TABLE IF EXISTS `oauth_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oauth_client` (
  `id` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  `client_id` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  `client_secret` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  `authentication_methods` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  `authorized_grant_types` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  `redirect_uris` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  `scopes` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client`
--

LOCK TABLES `oauth_client` WRITE;
/*!40000 ALTER TABLE `oauth_client` DISABLE KEYS */;
INSERT INTO `oauth_client` VALUES ('5c229cec-b73b-11eb-880d-0242ac120002','samples-client','secret','basic','authorization_code,refresh_token','http://localhost:8080/login/oauth2/code/samples-client-oidc,http://localhost:8080/authorized','openid,samples.read');
/*!40000 ALTER TABLE `oauth_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이용자의 내부 ID 정보',
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '이용자의 Identity 정보를 특정할 수있는 이름',
  `password` varchar(512) COLLATE utf8mb4_bin NOT NULL COMMENT '이용자의 Identity정보의 소유를 확인해주는 비밀번호',
  `roles` varchar(1000) COLLATE utf8mb4_bin NOT NULL COMMENT '이용자의 역할정보',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='이용자 정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$ZAyz8jho7dcrGf7UJKalouGReWmG1uIpbsR2aZcIXDwCYL4o3RxqK','USER,member,admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;