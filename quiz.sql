-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: quiz
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `login_user`
--

DROP TABLE IF EXISTS `login_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_user`
--

LOCK TABLES `login_user` WRITE;
/*!40000 ALTER TABLE `login_user` DISABLE KEYS */;
INSERT INTO `login_user` VALUES (1,'hema@gmail.com','hema','Hema@sri18'),(2,'hema@gmail','hema sri','Hema@sri18'),(3,'Ameh@gmail.com','Ameh irs','Hema@sri18'),(4,'shiva@com','shiva','Shiva123'),(5,'hema@123','Hema','Hema@123'),(6,'jaya@gmail.com','jayachandiran','J@123chandran'),(7,'hemajk518@gmail.com','Hema Dharshini .J','1Asdfghj'),(8,'Hema@gmail.com','Hema','1Asdfghj');
/*!40000 ALTER TABLE `login_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `chose` int NOT NULL,
  `correct_answers` int NOT NULL,
  `question` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Object-Oriented Programming','Object Ordering Process','Operating Overloaded Pointers','Order of Operations',-1,1,'What does OOP stand for?','java'),(2,'A type of loop','A built-in function','A data structure','An object',-1,2,'What is a list in Python?','python'),(3,'Stack','Queue','Array','LinkedList',-1,2,'Which data structure uses First-In-First-Out (FIFO) order?','python'),(4,'Unicode escape sequence','Octal escape','Hexadecimal','Line feed',-1,1,'The u0021 article referred to as a','java'),(5,'JVM','JRE','JDK','JDB',-1,4,'_____ is used to find and fix bugs in the Java programs.','java'),(6,'Object','int','long','void',-1,2,'What is the return type of the hashCode() method in the Object class?','java'),(7,'ABH8097','L990023','904423','0xnf029L',-1,4,'Which of the following is a valid long literal?','java'),(8,'0','Not a Number','Infinity','Run time exception',-1,3,'What does the expression float a = 35 / 0 return?','java'),(9,'24','23','20','25',-1,4,'Evaluate the following Java expression, if x=3, y=5, and z=10: ++z + y - y + z + x++','java'),(10,'javap tool','javaw command','Javadoc tool','javah command',-1,3,'Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?','java'),(11,'new List(false, 3)','new List(3, true)','new List(true, 3)','new List(3, false)',-1,2,'Which of the following creates a List of 3 visible items and multiple selections abled?','java'),(12,'for ( int i = 99; i >= 0; i / 9 )','for ( int i = 7; i <= 77; i += 7 )','for ( int i = 20; i >= 2; - -i )','for ( int i = 2; i <= 20; i = 2* i )',-1,1,'Which of the following for loop declaration is not valid?','java'),(13,'getClass()','intern()','getName()','toString()',-1,3,'Which method of the Class.class is used to determine the name of a class represented by the class object as a String?','java'),(14,'Serialization','Variable Shadowing','Abstraction','Multi-threading',-1,2,'In which process, a local variable has the same name as one of the instance variables?','java'),(15,'It has only methods','Objects cant be created','It has a fixed class name','It has no class name',-1,4,'Which of the following is true about the anonymous inner class?','java'),(16,'java.util package','java.lang package','java.awt package','java.io package',-1,1,' Which package contains the Random class?','java'),(17,'An object created by using the new keyword.','An object of a superclass created in the subclass.','An object without having any name but having a reference.','An object that has no reference.',-1,4,'What do you mean by nameless objects?','java'),(18,'Runnable Interface','Marker Interface','Abstract Interface','CharSequence Interface',-1,2,'An interface with no fields or methods is known as a ______.','java'),(19,'Applet class','Window class','Frame class','Dialog class',-1,1,'Which of the following is an immediate subclass of the Panel class?','java'),(20,'A final method cannot be overridden in its subclasses.','A final class cannot be extended.','A final class cannot extend other classes.','A final method can be inherited.',-1,3,'Which option is false about the final keyword?','java'),(21,'RuntimeException and Error class','Exception and VirtualMachineError class','Error and Exception class','IOException and VirtualMachineError class',-1,3,'Which of these classes are the direct subclasses of the Throwable class?','java'),(22,'Exceptions occurred by the VirtualMachineError','An exception caused by other exceptions','Exceptions occur in chains with discarding the debugging information','None of the above',-1,2,'What do you mean by chained exceptions in Java?','java'),(23,'Stack','String memory','Heap memory','Random storage space',-1,3,'In which memory a String is stored, when we create a string using new operator?','java'),(24,'It returns the existing string from memory','It creates a new string in the database','It modifies the existing string in the database','None of the above',-1,1,'What is the use of the intern() method?','java'),(25,'Runnable interface','Remote interface','Readable interface','Result interface',-1,2,'Which of the following is a marker interface?','java'),(26,'object','strictfp','main','system',-1,2,'Which of the following is a reserved keyword in Java?','java'),(27,'package','import','extends','export',-1,2,'Which keyword is used for accessing the features of a package?','java'),(28,'Java Archive Runner','Java Application Resource','Java Application Runner','None of the above',-1,4,'In java, jar stands for_____.','java'),(29,'using style tag','importing style.css into html file','only 1','both 1&2',0,4,'how do you insert style into your code ','HTML'),(30,'1','2','3','6',0,1,'1236','HTML'),(31,'object-oriented programming','structured programming',' functional programming','all of the mentioned',0,4,'Which type of Programming does Python support?','Python'),(32,'32','16','128','No fixed length is specified ',0,4,' \r\nWhat is the maximum length of a Python identifier?','Python');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_correct` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (1,3,'Kavi Sri'),(2,3,'ameh'),(3,4,'shi'),(4,0,'shiva'),(5,5,'007'),(6,5,'jayachandran'),(7,4,'Hema Dharshini.j'),(8,0,'aaaaa');
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-25 14:35:59
