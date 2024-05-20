CREATE DATABASE  IF NOT EXISTS `quiz` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quiz`;

-- Host: localhost    Database: quiz
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `cpp_quiz`
--

DROP TABLE IF EXISTS `cpp_quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpp_quiz` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `correct_answer` varchar(255) NOT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `cpp_quiz_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpp_quiz`
--

LOCK TABLES `cpp_quiz` WRITE;
/*!40000 ALTER TABLE `cpp_quiz` DISABLE KEYS */;
INSERT INTO `cpp_quiz` VALUES (1,'What is a destructor in C++?','A special method used to destroy objects','A method for creating objects','A method used to initialize objects','A method used for encryption','A special method used to destroy objects',3),(2,'What is the difference between `cout` and `cin` in C++?','`cout` is used for output, and `cin` is used for input','`cout` is used for input, and `cin` is used for output','There is no difference','Both are used for file handling','`cout` is used for output, and `cin` is used for input',3),(3,'What are namespaces in C++?','A way to organize code into logical groups','A type of operator','A type of data type','A way to define variables','A way to organize code into logical groups',3),(4,'What is operator overloading in C++?','Defining multiple behaviors for an operator','Defining multiple constructors for a class','Restricting access to class members','Inheriting from multiple base classes','Defining multiple behaviors for an operator',3),(5,'What is dynamic memory allocation in C++?','Allocating memory during runtime','Allocating memory before program execution','Allocating memory for local variables','Deallocating memory for global variables','Allocating memory during runtime',3),(6,'What is the role of `const` in C++?','To declare constants','To declare global variables','To restrict access to class members','To define virtual functions','To declare constants',3),(7,'What is the purpose of the `new` keyword in C++?','To allocate memory dynamically','To declare a new class','To create a new file','To define a new operator','To allocate memory dynamically',3),(8,'What is the purpose of a reference in C++?','To provide an alias to an existing variable','To define a new data type','To limit access to class members','To create a new constructor','To provide an alias to an existing variable',3),(9,'What is function overloading in C++?','Having multiple functions with the same name but different parameters','Having multiple constructors in a class','Using functions from an external library','Defining functions inside another function','Having multiple functions with the same name but different parameters',3),(10,'What is the role of the `static` keyword in C++?','To create class-level variables and methods','To make a variable immutable','To prevent inheritance','To allow multiple constructors in a class','To create class-level variables and methods',3),(11,'What is the purpose of inheritance in C++?','To create new classes based on existing classes','To restrict access to class members','To define private methods','To create virtual functions','To create new classes based on existing classes',3),(12,'What is the difference between `++i` and `i++` in C++?','`++i` increments the value of `i` and returns the updated value','`i++` increments the value of `i` but returns the previous value','There is no difference','Both statements are invalid in C++','`++i` increments the value of `i` and returns the updated value',3),(13,'What is an array in C++?','A collection of variables of the same type','A data type used for arithmetic operations','A pointer to a memory location','A method for defining functions','A collection of variables of the same type',3),(14,'What is a pointer in C++?','A special variable that stores memory addresses','A data type used for arithmetic operations','An operator used for control flow','A control statement','A special variable that stores memory addresses',3),(15,'What is operator precedence in C++?','The order in which operators are evaluated in an expression','The value returned by a comparison operation','The type of operators used in an expression','The limit on the number of operators in an expression','The order in which operators are evaluated in an expression',3);
/*!40000 ALTER TABLE `cpp_quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `database_quiz`
--

DROP TABLE IF EXISTS `database_quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `database_quiz` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `correct_answer` varchar(255) NOT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `database_quiz_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `database_quiz`
--

LOCK TABLES `database_quiz` WRITE;
/*!40000 ALTER TABLE `database_quiz` DISABLE KEYS */;
INSERT INTO `database_quiz` VALUES (1,'What is a primary key in a database?','A unique identifier for a record','An index on a non-unique column','A column that stores data','A foreign key reference','A unique identifier for a record',2),(2,'What does SQL stand for?','Structured Query Language','Structured Question Language','Sequential Query Language','Standard Query Language','Structured Query Language',2),(3,'What is a JOIN operation used for in databases?','To combine rows from two or more tables','To create a new table','To delete rows from a table','To update rows in a table','To combine rows from two or more tables',2),(4,'What is normalization in database design?','Organizing data to reduce redundancy and dependency','Creating backup copies of databases','Deleting unwanted data from tables','Indexing data for faster retrieval','Organizing data to reduce redundancy and dependency',2),(5,'What is a database transaction?','A unit of work performed on a database','A backup of a database','A database schema','A database connection','A unit of work performed on a database',2),(6,'What is the purpose of indexes in databases?','To optimize query performance','To store backup data','To manage database connections','To create relationships between tables','To optimize query performance',2),(7,'What is ACID in database transactions?','A set of properties that ensure reliable processing of transactions','A database language','A type of data encryption','A database management system','A set of properties that ensure reliable processing of transactions',2),(8,'What is a foreign key in a database?','A field that uniquely identifies a record','A key used for encryption','A key that links two tables together','A key used for database backups','A key that links two tables together',2),(9,'What is the difference between SQL and NoSQL databases?','SQL databases use structured query language, while NoSQL databases use unstructured data models','SQL databases are faster than NoSQL databases','SQL databases are more scalable than NoSQL databases','No difference, they are the same','SQL databases use structured query language, while NoSQL databases use unstructured data models',2),(10,'What is the purpose of database indexing?','To improve the performance of queries','To limit access to certain tables','To create backups of databases','To define table relationships','To improve the performance of queries',2),(11,'What is denormalization?','The process of adding redundant data to improve query performance','The process of removing redundant data to reduce storage space','The process of optimizing indexes','The process of encrypting data','The process of adding redundant data to improve query performance',2),(12,'What is the role of a DBA (Database Administrator)?','To manage and maintain databases','To design user interfaces','To write database queries','To manage server hardware','To manage and maintain databases',2),(13,'What is a database view?','A virtual table based on the result of a query','An index used for faster retrieval','A table without data','A backup copy of a table','A virtual table based on the result of a query',2),(14,'What is a stored procedure?','A precompiled SQL code that can be reused','A method for creating tables','A type of database connection','A method for sorting data','A precompiled SQL code that can be reused',2),(15,'What is a trigger in a database?','A set of actions that automatically execute in response to specified events','A key used for database encryption','A type of database index','An error message in SQL','A set of actions that automatically execute in response to specified events',2);
/*!40000 ALTER TABLE `database_quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `java_quiz`
--

DROP TABLE IF EXISTS `java_quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `java_quiz` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `correct_answer` varchar(255) NOT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `java_quiz_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `java_quiz`
--

LOCK TABLES `java_quiz` WRITE;
/*!40000 ALTER TABLE `java_quiz` DISABLE KEYS */;
INSERT INTO `java_quiz` VALUES (1,'What is a class in Java?','A blueprint for creating objects','A programming language','A method in a class','A variable in a class','A blueprint for creating objects',4),(2,'What is the main method in Java?','The entry point of a Java program','A method to print text','A special constructor','A method to terminate a program','The entry point of a Java program',4),(3,'What is an interface in Java?','A reference type similar to a class','A way to define variables','A control statement','An operator in Java','A reference type similar to a class',4),(4,'What is method overloading in Java?','Having multiple methods with the same name but different parameters','Using methods from an external library','Creating a method inside another method','Defining methods in a subclass','Having multiple methods with the same name but different parameters',4),(5,'What is the purpose of the `static` keyword in Java?','To create class-level variables and methods','To make a variable immutable','To prevent inheritance','To allow multiple constructors in a class','To create class-level variables and methods',4),(6,'What is inheritance in Java?','The process of creating a new class based on an existing class','The process of hiding implementation details','The process of creating static methods','The process of overloading methods','The process of creating a new class based on an existing class',4),(7,'What is polymorphism in Java?','The ability of objects to take on multiple forms','The process of encapsulating data','The creation of private methods','The definition of constructors','The ability of objects to take on multiple forms',4),(8,'What is encapsulation in Java?','Binding data and methods together','Storing data in a secure location','Hiding sensitive information','Preventing data loss','Binding data and methods together',4),(9,'What is the difference between `==` and `.equals()` in Java?','`==` compares object references, while `.equals()` compares object contents','`==` compares primitive data types, while `.equals()` compares objects','There is no difference','`==` and `.equals()` are used interchangeably','`==` compares object references, while `.equals()` compares object contents',4),(10,'What are access modifiers in Java?','Keywords used to control the visibility and accessibility of class members','Keywords used for loop iterations','Keywords used for data manipulation','Keywords used for conditional statements','Keywords used to control the visibility and accessibility of class members',4),(11,'What is the purpose of the `final` keyword in Java?','To make a variable constant and cannot be changed','To define the entry point of a program','To prevent class inheritance','To create a new class','To make a variable constant and cannot be changed',4),(12,'What is the role of Java packages?','To organize classes and interfaces into namespaces','To declare static methods','To define object-oriented principles','To create new data types','To organize classes and interfaces into namespaces',4),(13,'What is the difference between an abstract class and an interface in Java?','An abstract class can have method implementations, while an interface cannot','An interface can have method implementations, while an abstract class cannot','An abstract class cannot have any methods, while an interface can','There is no difference','An abstract class can have method implementations, while an interface cannot',4),(14,'What is the purpose of constructor chaining in Java?','To invoke one constructor from another constructor within the same class','To create multiple instances of a class','To overload constructors','To prevent inheritance','To invoke one constructor from another constructor within the same class',4),(15,'What is the role of garbage collection in Java?','To automatically free memory used by objects that are no longer referenced','To create new instances of objects','To optimize database queries','To prevent memory leaks','To automatically free memory used by objects that are no longer referenced',4);
/*!40000 ALTER TABLE `java_quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oop_quiz`
--

DROP TABLE IF EXISTS `oop_quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oop_quiz` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `correct_answer` varchar(255) NOT NULL,
  `subject_id` int DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `oop_quiz_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oop_quiz`
--

LOCK TABLES `oop_quiz` WRITE;
/*!40000 ALTER TABLE `oop_quiz` DISABLE KEYS */;
INSERT INTO `oop_quiz` VALUES (1,'What does OOP stand for?','Object-Oriented Programming','Object-Oriented Protocol','Object-Oriented Process','Object-Oriented Protocol','Object-Oriented Programming',1),(2,'What is encapsulation in OOP?','Binding data and methods together','Storing data in a secure location','Hiding sensitive information','Preventing data loss','Binding data and methods together',1),(3,'What is inheritance in OOP?','The ability of a class to inherit properties and behaviors from another class','The process of creating new objects','The encapsulation of data','The creation of static methods','The ability of a class to inherit properties and behaviors from another class',1),(4,'What is polymorphism in OOP?','The ability of objects to take on multiple forms','The process of encapsulating data','The creation of private methods','The definition of constructors','The ability of objects to take on multiple forms',1),(5,'What is an abstract class?','A class that cannot be instantiated','A class with only private methods','A class without any methods','A class with static variables','A class that cannot be instantiated',1),(6,'What is the purpose of interfaces in OOP?','To define a contract for implementing classes','To restrict access to class members','To encapsulate data','To create static methods','To define a contract for implementing classes',1),(7,'What is method overriding in OOP?','Providing a new implementation for an inherited method','Hiding methods from other classes','Creating private methods','Defining multiple constructors','Providing a new implementation for an inherited method',1),(8,'What is a constructor in OOP?','A special method used to create objects','A method that returns a value','A method that initializes variables','A method used for data encryption','A special method used to create objects',1),(9,'What are access modifiers in OOP?','Keywords used to control the visibility of class members','Keywords used to restrict class instantiation','Keywords used for method overloading','Keywords used to define static methods','Keywords used to control the visibility of class members',1),(10,'What is the difference between aggregation and composition in OOP?','Composition implies strong ownership, while aggregation implies weak ownership','Aggregation implies strong ownership, while composition implies weak ownership','Aggregation and composition are the same concepts','Composition involves inheritance, while aggregation does not','Composition implies strong ownership, while aggregation implies weak ownership',1),(11,'What is a static method in OOP?','A method that belongs to the class rather than instances of the class','A method that cannot be called directly','A method used for object comparison','A method used for database operations','A method that belongs to the class rather than instances of the class',1),(12,'What is the purpose of getters and setters in OOP?','To encapsulate the internal state of an object','To restrict access to class members','To define private methods','To create static variables','To encapsulate the internal state of an object',1),(13,'What is method overloading in OOP?','Having multiple methods with the same name but different parameters','Having multiple constructors in a class','Using methods from an external library','Defining methods inside another method','Having multiple methods with the same name but different parameters',1),(14,'What is the difference between superclass and subclass in OOP?','A superclass is a parent class, and a subclass is a child class','A superclass is a child class, and a subclass is a parent class','A superclass has fewer features than a subclass','A superclass cannot inherit from another class','A superclass is a parent class, and a subclass is a child class',1);
/*!40000 ALTER TABLE `oop_quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(255) NOT NULL,
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `subject_name` (`subject_name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `CMSID` varchar(10) NOT NULL ,
  `Name` varchar(40) NOT NULL,
  `Batch` varchar(5) NOT NULL,
  `Section` varchar(2) NOT NULL,
  `Emailaddress` varchar(60) NOT NULL,
   `marks` int NOT NULL,
`subject` varchar(8) NOT NULL,
  PRIMARY KEY (`CMSID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

