/*
SQLyog Trial v12.14 (32 bit)
MySQL - 5.6.17 : Database - prodauta
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prodauta` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `prodauta`;

/*Table structure for table `automobil` */

DROP TABLE IF EXISTS `automobil`;

CREATE TABLE `automobil` (
  `regbrojauta` int(11) NOT NULL,
  `godproizv` date DEFAULT NULL,
  `oprema_id` int(11) DEFAULT NULL,
  `tipauta_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`regbrojauta`),
  KEY `automobil_ibfk_1` (`oprema_id`),
  KEY `automobil_ibfk_5` (`tipauta_id`),
  CONSTRAINT `automobil_ibfk_5` FOREIGN KEY (`tipauta_id`) REFERENCES `tipauta` (`tipautaid`),
  CONSTRAINT `automobil_ibfk_1` FOREIGN KEY (`oprema_id`) REFERENCES `oprema` (`opremaid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `automobil` */

insert  into `automobil`(`regbrojauta`,`godproizv`,`oprema_id`,`tipauta_id`) values 
(11111111,'2012-08-25',1,4),
(23333333,'2014-08-01',3,1);

/*Table structure for table `oprema` */

DROP TABLE IF EXISTS `oprema`;

CREATE TABLE `oprema` (
  `opremaid` int(11) NOT NULL AUTO_INCREMENT,
  `imeopreme` varchar(20) DEFAULT NULL,
  `dodcenaop` int(11) DEFAULT NULL,
  PRIMARY KEY (`opremaid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `oprema` */

insert  into `oprema`(`opremaid`,`imeopreme`,`dodcenaop`) values 
(1,'pocetnipak',100),
(2,'klimapak',500),
(3,'full oprema',5000),
(4,'poluoprema',2500);

/*Table structure for table `tipauta` */

DROP TABLE IF EXISTS `tipauta`;

CREATE TABLE `tipauta` (
  `tipautaid` int(11) NOT NULL AUTO_INCREMENT,
  `imeauta` varchar(20) DEFAULT NULL,
  `zapmotora` int(5) DEFAULT NULL,
  `brojvrata` int(2) DEFAULT NULL,
  PRIMARY KEY (`tipautaid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tipauta` */

insert  into `tipauta`(`tipautaid`,`imeauta`,`zapmotora`,`brojvrata`) values 
(1,'fabia',1900,3),
(3,'superb',1700,5),
(4,'citigo',1400,5),
(5,'yeti',2500,5),
(6,'rapid',1600,5),
(7,'GO',1300,3),
(8,'365GO',1500,5);

/*Table structure for table `ugovor` */

DROP TABLE IF EXISTS `ugovor`;

CREATE TABLE `ugovor` (
  `ugovorid` int(11) NOT NULL,
  `datum` date DEFAULT NULL,
  `automobil_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ugovorid`),
  KEY `ugovor_ibfk_3` (`automobil_id`),
  CONSTRAINT `ugovor_ibfk_3` FOREIGN KEY (`automobil_id`) REFERENCES `automobil` (`regbrojauta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ugovor` */

insert  into `ugovor`(`ugovorid`,`datum`,`automobil_id`) values 
(2,'2016-09-28',23333333),
(5,'2015-09-25',23333333);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
