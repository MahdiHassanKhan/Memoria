-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2019 at 03:23 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `memoria`
--

-- --------------------------------------------------------

--
-- Table structure for table `aa`
--

CREATE TABLE `aa` (
  `date` varchar(100) DEFAULT NULL,
  `mood` varchar(100) DEFAULT NULL,
  `notes` varchar(400) DEFAULT NULL,
  `goals` varchar(400) DEFAULT NULL,
  `activity` varchar(400) DEFAULT NULL,
  `workActivity` int(20) DEFAULT NULL,
  `familyActivity` int(20) DEFAULT NULL,
  `friendsActivity` int(20) DEFAULT NULL,
  `dateActivity` int(20) DEFAULT NULL,
  `readingActivity` int(20) DEFAULT NULL,
  `workoutActivity` int(20) DEFAULT NULL,
  `musicActivity` int(20) DEFAULT NULL,
  `goodmealActivity` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aa`
--

INSERT INTO `aa` (`date`, `mood`, `notes`, `goals`, `activity`, `workActivity`, `familyActivity`, `friendsActivity`, `dateActivity`, `readingActivity`, `workoutActivity`, `musicActivity`, `goodmealActivity`) VALUES
('13/10/2019', 'Meh', '', '', 'family', 0, 1, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Bad', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Awful', '', '', 'work', 1, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Awful', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Awful', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Awful', '', '', 'work', 1, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Bad', '', '', 'music,good meal', 0, 0, 0, 0, 0, 0, 1, 1),
('13/10/2019', 'Awful', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Rad', '', '', '', 0, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Meh', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Meh', '', '', 'work', 1, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Awful', '', '', 'work', 1, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Rad', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Good', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Rad', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Rad', '', '', 'work', 1, 0, 0, 0, 0, 0, 0, 0),
('12/03/19', 'Rad', NULL, NULL, 'work', 1, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Awful', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Good', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Awful', '', '', '', 0, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Awful', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Bad', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Good', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Rad', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Awful', '', '', 'good meal', 0, 0, 0, 0, 0, 0, 0, 1),
('13/10/2019', 'Awful', '', '', 'work', 1, 0, 0, 0, 0, 0, 0, 0),
('s', '', 's', 's', '', 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `bb`
--

CREATE TABLE `bb` (
  `date` varchar(100) DEFAULT NULL,
  `mood` varchar(100) DEFAULT NULL,
  `notes` varchar(400) DEFAULT NULL,
  `goals` varchar(400) DEFAULT NULL,
  `activity` varchar(400) DEFAULT NULL,
  `workActivity` int(20) DEFAULT NULL,
  `familyActivity` int(20) DEFAULT NULL,
  `friendsActivity` int(20) DEFAULT NULL,
  `dateActivity` int(20) DEFAULT NULL,
  `readingActivity` int(20) DEFAULT NULL,
  `workoutActivity` int(20) DEFAULT NULL,
  `musicActivity` int(20) DEFAULT NULL,
  `goodmealActivity` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nafi`
--

CREATE TABLE `nafi` (
  `date` varchar(100) DEFAULT NULL,
  `mood` varchar(100) DEFAULT NULL,
  `notes` varchar(400) DEFAULT NULL,
  `goals` varchar(400) DEFAULT NULL,
  `activity` varchar(400) DEFAULT NULL,
  `workActivity` int(20) DEFAULT NULL,
  `familyActivity` int(20) DEFAULT NULL,
  `friendsActivity` int(20) DEFAULT NULL,
  `dateActivity` int(20) DEFAULT NULL,
  `readingActivity` int(20) DEFAULT NULL,
  `workoutActivity` int(20) DEFAULT NULL,
  `musicActivity` int(20) DEFAULT NULL,
  `goodmealActivity` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nafi`
--

INSERT INTO `nafi` (`date`, `mood`, `notes`, `goals`, `activity`, `workActivity`, `familyActivity`, `friendsActivity`, `dateActivity`, `readingActivity`, `workoutActivity`, `musicActivity`, `goodmealActivity`) VALUES
('13/10/2019', 'Rad', '', '', 'work,family,friends,date,good meal,music,workout,reading', 1, 1, 1, 1, 1, 1, 1, 1),
('23', '', 'er', 'haha', '', 0, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', '', 'blublu', '', '0', 0, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', 'Awful', '', '', 'work,family,friends,date,good meal,music,workout,reading', 1, 1, 1, 1, 1, 1, 1, 1),
('12/09/20', '', 'cuz im fat', 'gym', '', 0, 0, 0, 0, 0, 0, 0, 0),
('13/10/2019', '', 'blublu', '', '0', 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`username`, `password`, `email`, `firstName`, `lastName`) VALUES
('zunayed', '1234', 'zunayed.rahim@gmail.com', 'Zunayed', 'Rahim'),
('Nafisha', 'nafisha', 'nafisanam@gmailc.om', 'Nafisha', 'Salsabil'),
('mahdi', '1111', 'asd@gmail.com', 'Mahdi Hassan', 'Khan'),
('zayed', '1234', 'zayeedur@gmail.com', 'Zayedur', 'Rahim'),
('zuna', 'zuna', 'zunayed@gmail.com', 'zunayed', 'rahim'),
('zuna', '123', 'adad', 'zunayed', 'adasd'),
('new', 'new', 'new', 'new', 'new'),
('aa', 'aa', 'as', 'aaa', 'aaa'),
('bb', 'bb', 'bb', 'bb', 'bb'),
('nafi', 'nafi', 'nafi', 'nafi', 'nafi');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
