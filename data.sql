

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `correct_rate` float DEFAULT NULL,
  `mode` varchar(20) NOT NULL,
  PRIMARY KEY (`test_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `attempt`;
CREATE TABLE `attempt` (
  `attempt_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_id` int(11) DEFAULT NULL,
  `trash_type` varchar(20) DEFAULT NULL,
  `choice` varchar(20) DEFAULT NULL,
  `is_correct` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`attempt_id`),
  KEY `test_id` (`test_id`),
  CONSTRAINT `attempt_ibfk_1` FOREIGN KEY (`test_id`) REFERENCES `test` (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;



LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'DuJianyu'),(2,'WangHao');
UNLOCK TABLES;



LOCK TABLES `test` WRITE;
INSERT INTO `test` VALUES (1,1,'2024-04-13 13:03:03',0.6,'EVALUATION'),(2,1,'2024-04-13 14:03:18',0.8,'EVALUATION'),(3,2,'2024-04-13 13:03:25',0.5,'EVALUATION'),(4,2,'2024-04-13 13:03:28',0.4,'EVALUATION');
UNLOCK TABLES;


LOCK TABLES `attempt` WRITE;
INSERT INTO `attempt` VALUES (8,1,'recyclable','recyclable',1),(9,1,'recyclable','compostable',0),(10,1,'recyclable','recyclable',1),(11,1,'recyclable','recyclable',1),(12,1,'recyclable','recyclable',1),(13,1,'recyclable','compostable',0),(14,1,'recyclable','hazardous',0),(15,1,'recyclable','other',0),(16,1,'recyclable','other',0),(17,1,'recyclable','recyclable',1);
UNLOCK TABLES;

