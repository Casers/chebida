/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.26 : Database - chebida
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`chebida` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `chebida`;

/*Table structure for table `advices` */

DROP TABLE IF EXISTS `advices`;

CREATE TABLE `advices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `advices` */

insert  into `advices`(`id`,`title`,`content`,`create_time`) values (4,'这是标题','这是公告内容！','2018-03-26 21:41:01'),(5,'写个正式标题','今天中午办公室开会！','2018-03-28 20:02:28'),(6,'中午开会，都到','中午开会，都到','2018-03-28 20:11:18'),(11,'项目有bug，今晚加班','项目有bug，今晚加班！！！','2018-03-29 00:43:35');

/*Table structure for table `cars` */

DROP TABLE IF EXISTS `cars`;

CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_number` varchar(20) DEFAULT NULL,
  `engine_number` varchar(20) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `photo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  KEY `driver_id` (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `cars` */

insert  into `cars`(`car_id`,`car_number`,`engine_number`,`start_time`,`end_time`,`driver_id`,`create_time`,`photo`) values (1,'鄂A12345','sdf123123dasdf','2017-02-01','2018-03-25',1,'2018-03-25 22:46:48','sdf123123dasdf.png'),(4,'鄂A8888','2','2018-03-25','2018-03-25',2,'2018-03-25 23:57:53','2.jpg'),(7,'wer','123122343','2018-03-07','2018-04-19',4,'2018-03-28 23:25:26','123122343.png'),(8,'粤A12346','123423sadrfsd4','2016-03-31','2018-03-29',5,'2018-03-29 00:37:19',NULL),(9,'鄂A54322','bsdfsa12312123','2016-02-08','2018-03-28',6,'2018-03-29 00:46:24',NULL);

/*Table structure for table `cars_mileage` */

DROP TABLE IF EXISTS `cars_mileage`;

CREATE TABLE `cars_mileage` (
  `cars_mileage_id` int(11) NOT NULL AUTO_INCREMENT,
  `mileage` int(11) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cars_mileage_id`),
  KEY `car_id` (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `cars_mileage` */

insert  into `cars_mileage`(`cars_mileage_id`,`mileage`,`sales`,`car_id`,`create_time`) values (1,23,23,1,NULL),(5,4,5,1,'2018-03-28 23:27:09'),(6,4,8,8,'2018-03-28 23:42:00'),(9,6,24,8,'2018-03-29 00:39:23'),(10,9,25,9,'2018-03-29 00:49:44'),(11,11,44,9,'2018-03-29 00:49:55');

/*Table structure for table `cars_repair` */

DROP TABLE IF EXISTS `cars_repair`;

CREATE TABLE `cars_repair` (
  `cars_repair_id` int(11) NOT NULL AUTO_INCREMENT,
  `cars_repair_type` varchar(5) DEFAULT NULL,
  `cars_repair_text` varchar(100) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cars_repair_id`),
  KEY `car_id` (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `cars_repair` */

insert  into `cars_repair`(`cars_repair_id`,`cars_repair_type`,`cars_repair_text`,`car_id`,`create_time`) values (1,'维修','车子打不燃，不知道为什么',1,'2018-04-02 11:28:00'),(2,'保养','到了保养的时间',1,'2018-02-26 11:28:50'),(3,'其他','其他什么东西。',1,'2018-03-26 16:38:57'),(8,'维修','今天不消息搽伤',8,'2018-03-29 00:38:52'),(9,'保养','今天到了保养时间！',8,'2018-03-29 00:39:07'),(10,'维修','今天不小心划伤',9,'2018-03-29 00:47:00'),(11,'保养','今天到保养时间了吗？？？？？',8,'2018-03-29 00:48:06'),(12,'其他','其他事情，不想说！！',9,'2018-03-29 00:51:59'),(14,'保养','发发发',1,'2018-04-08 17:32:00');

/*Table structure for table `drivers` */

DROP TABLE IF EXISTS `drivers`;

CREATE TABLE `drivers` (
  `driver_id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` char(4) DEFAULT NULL,
  `driver_age` int(11) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `drivers` */

insert  into `drivers`(`driver_id`,`driver_name`,`age`,`sex`,`driver_age`,`phone`,`id_card`,`address`,`create_time`,`status`,`photo`) values (1,'张三',27,'女',7,'13997831234','422093199501231432','地址在很远很远的家乡不知道的角落','2018-03-25 14:27:21','离职','422093199501231432.jpg'),(2,'李四',18,'男',1,'123','243545643563425242','长江大学文理学院西校区就很难受故意打这么长','2018-03-25 19:45:09','在职','243545643563425242.jpg'),(3,'姓名',21,'男',4,'123123123123','243545643563425242','地址在很远很远的家乡不知道的角落','2018-03-25 19:52:17','离职','243545643563425242.jpg'),(5,'司机姓名24',22,'男',3,'123345612343','333412352342342343','地址在哪里我也不知道2','2018-03-29 00:35:29','离职',NULL),(6,'lvhaosir姓名',22,'女',3,'12334561234','333432352342342343','地址在哪里我也不知道bb','2018-03-29 00:44:40','离职',NULL),(8,'11111',18,'男',1,'123345612346','3334123523423426','住址在哪里呢！！！','2018-04-02 16:31:45','在职','3334123523423426.jpg');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `nick_name` varchar(30) DEFAULT NULL,
  `user_admin` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`user_id`,`user_name`,`pwd`,`nick_name`,`user_admin`) values (1,'lvhaosir','123','lvhaosir','普通用户'),(4,'22','22','224','普通用户'),(5,'admin','admin','admin','管理员'),(6,'test','test','test','普通用户');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
