-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 03, 2020 at 12:10 PM
-- Server version: 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `OnlineBookStore_22265`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`email`, `password`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `bookOrder`
--

CREATE TABLE `bookOrder` (
  `orderId` int(11) NOT NULL,
  `orderStatus` varchar(200) DEFAULT NULL,
  `totalbill` double DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `orderDate` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookOrder`
--

INSERT INTO `bookOrder` (`orderId`, `orderStatus`, `totalbill`, `emailId`, `orderDate`) VALUES
(1, 'processing', 0, 'bhagu@gmail.com', NULL),
(2, 'processing', 0, 'bhagu@gmail.com', 'Mon Jan 27 18:27:10 IST 2020'),
(3, 'processing', 0, 'bhagu@gmail.com', 'Mon Jan 27 18:27:59 IST 2020'),
(4, 'processing', 2130, NULL, 'Tue Feb 25 19:44:27 IST 2020'),
(5, 'processing', 2130, NULL, 'Tue Feb 25 19:45:38 IST 2020'),
(6, 'processing', 2130, NULL, 'Tue Feb 25 19:46:10 IST 2020'),
(7, 'processing', 2130, NULL, 'Tue Feb 25 19:47:42 IST 2020'),
(8, 'processing', 2130, NULL, 'Tue Feb 25 19:48:59 IST 2020'),
(19, 'placed', 3529, 'bhagya@gmail.com', 'Wed Feb 26 17:04:15 IST 2020'),
(20, 'placed', 1100, 'bhagya@gmail.com', 'Wed Feb 26 17:04:39 IST 2020'),
(21, 'placed', 1100, 'bhagya@gmail.com', 'Wed Feb 26 17:05:59 IST 2020'),
(22, 'placed', 1030, 'ajay@gmail.com', 'Wed Feb 26 17:38:40 IST 2020'),
(23, 'placed', 550, 'bhagya@gmail.com', 'Thu Feb 27 16:57:51 IST 2020'),
(24, 'placed', 550, 'bhagya@gmail.com', 'Thu Feb 27 16:58:04 IST 2020'),
(25, 'placed', 550, 'bhagya@gmail.com', 'Thu Feb 27 16:59:46 IST 2020');

-- --------------------------------------------------------

--
-- Table structure for table `Book_22265`
--

CREATE TABLE `Book_22265` (
  `bookId` int(11) NOT NULL,
  `bookName` varchar(225) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `author` varchar(225) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `bookDesc` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Book_22265`
--

INSERT INTO `Book_22265` (`bookId`, `bookName`, `price`, `author`, `publisher`, `bookDesc`, `category`, `quantity`) VALUES
(1, 'Dreams from my father', 550, 'Barack Obama', 'Arihant', 'motivate all the persnality', 'Motivational', 2),
(2, 'Jail Dairy', 550, 'Chandrashekhar', 'Rupa', 'it teue experience', 'Motivational', 5),
(3, 'Development as freedom', 655, 'Amartya sen', 'Nirali', 'persanaliy development', 'Fantacy', 10),
(4, 'River of Smoke', 1050, 'Amitav Ghose', 'Arihant', 'motivate how to tackle problems', 'Motivational', 8),
(5, 'Half Girlfriend', 400, 'Chetan Bhagat', 'Rupa', 'drama', 'Fantacy', 5),
(6, 'Five point Someone', 480, 'Chetan Bhagat', 'Arihant', 'horror and  descriptive', 'Horror', 3),
(7, 'java', 299, 'mane', 'Tech', 'book java ', 'Educational', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Cart`
--

CREATE TABLE `Cart` (
  `cartId` int(11) NOT NULL,
  `bookId` int(10) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cart`
--

INSERT INTO `Cart` (`cartId`, `bookId`, `quantity`, `emailId`) VALUES
(1, 1, 2, NULL),
(3, 2, 5, 'nan@gmail.com'),
(5, 5, 10, 'komal@gmail.com'),
(6, 0, 0, NULL),
(7, 0, 0, NULL),
(8, 0, 0, NULL),
(9, 0, 0, NULL),
(10, 0, 0, NULL),
(11, 0, 0, NULL),
(12, 0, 0, NULL),
(13, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Customer_22265`
--

CREATE TABLE `Customer_22265` (
  `CustomerId` int(11) NOT NULL,
  `customerName` varchar(255) DEFAULT NULL,
  `mobNo` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `emailID` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Customer_22265`
--

INSERT INTO `Customer_22265` (`CustomerId`, `customerName`, `mobNo`, `address`, `emailID`, `password`) VALUES
(1, 'BhagyashreeP', '7378471707', 'Thane', 'bhagya@gmail.com', 'Bhagu@95'),
(2, 'Komal', '7758809748', 'Thane', 'komal@gmail.com', 'Komal5'),
(3, 'Nanhi', '9518324797', 'Gondia', 'nanhi@gmail.com', 'nan@95'),
(4, 'Amit', '1234567890', 'Gondia', 'amit@gmail.com', 'a@9'),
(5, 'Sandip', '7769943197', 'amgaon', 'sandip@gmail.com', 'sandip@95'),
(6, 'Sharda', '7769943197', 'salekasa', 'sharda@gmail.com', 'sharda'),
(8, 'Dhanraj', '7030433717', 'tirkhedi', 'dhanraj23@gmail.com', 'dhanraj'),
(9, 'Ajay ', '7769943198', 'hyderabad', 'ajay@gmail.com', 'ajay1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookOrder`
--
ALTER TABLE `bookOrder`
  ADD PRIMARY KEY (`orderId`);

--
-- Indexes for table `Book_22265`
--
ALTER TABLE `Book_22265`
  ADD PRIMARY KEY (`bookId`);

--
-- Indexes for table `Cart`
--
ALTER TABLE `Cart`
  ADD PRIMARY KEY (`cartId`);

--
-- Indexes for table `Customer_22265`
--
ALTER TABLE `Customer_22265`
  ADD PRIMARY KEY (`CustomerId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookOrder`
--
ALTER TABLE `bookOrder`
  MODIFY `orderId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `Book_22265`
--
ALTER TABLE `Book_22265`
  MODIFY `bookId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `Cart`
--
ALTER TABLE `Cart`
  MODIFY `cartId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `Customer_22265`
--
ALTER TABLE `Customer_22265`
  MODIFY `CustomerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
