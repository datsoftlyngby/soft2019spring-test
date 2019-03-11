DROP DATABASE IF EXISTS `cupcakeshop_test`;
CREATE DATABASE `cupcakeshop_test`;
USE `cupcakeshop_test`;

CREATE TABLE `cupcakebottom` (
  `idBottom` int(11) NOT NULL AUTO_INCREMENT,
  `cupcakeBottomName` varchar(45) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`idBottom`)
);

CREATE TABLE `cupcaketopping` (
  `idTopping` int(11) NOT NULL AUTO_INCREMENT,
  `cupcakeToppingName` varchar(45) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`idTopping`)
);

CREATE TABLE `cupcake` (
  `idCupcake` int(11) NOT NULL AUTO_INCREMENT,
  `cupcakeName` varchar(45) DEFAULT NULL,
  `idTopping` int(11) DEFAULT NULL,
  `idBottom` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCupCake`)
);

INSERT INTO `cupcakebottom` VALUES (1,'Chocolate',5);
INSERT INTO `cupcakebottom` VALUES (2,'Blueberry',5);
INSERT INTO `cupcakebottom` VALUES (3,'Raspberry',5);
INSERT INTO `cupcakebottom` VALUES (4,'Crispy',6);
INSERT INTO `cupcakebottom` VALUES (5,'Strawberry',6);
INSERT INTO `cupcakebottom` VALUES (6,'Rum/Raisin',7);
INSERT INTO `cupcakebottom` VALUES (7,'Orange',8),(8,'Lemon',8);
INSERT INTO `cupcakebottom` VALUES (9,'Blue cheese',9);

INSERT INTO `cupcaketopping` VALUES (1,'Chocolate',5);
INSERT INTO `cupcaketopping` VALUES (2,'Vanilla',5);
INSERT INTO `cupcaketopping` VALUES (3,'Nutmeg',5);
INSERT INTO `cupcaketopping` VALUES (4,'Pistacio',6);
INSERT INTO `cupcaketopping` VALUES (5,'Almond',7);

INSERT INTO `cupcake` VALUES (1,'ChoccoNut',3,1);
INSERT INTO `cupcake` VALUES (2,'Chocolate with Chocolate',1,1);
INSERT INTO `cupcake` VALUES (3,'Blueberry with Vanilla',2,2);
INSERT INTO `cupcake` VALUES (4,'Chocolate with Vanilla',2,1);
INSERT INTO `cupcake` VALUES (5,'Crispy with Pistacio',4,4);
INSERT INTO `cupcake` VALUES (6,'Raspberry with Chocolate',1,3);
INSERT INTO `cupcake` VALUES (7,'Chocolate with Vanilla',2,1);
INSERT INTO `cupcake` VALUES (8,'Raspberry with Nutmeg',3,3);
INSERT INTO `cupcake` VALUES (9,'ChoccoNut',3,1);