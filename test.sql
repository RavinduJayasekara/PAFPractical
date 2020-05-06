-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 07:27 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientID` int(11) NOT NULL,
  `patientUserName` varchar(60) NOT NULL,
  `patientPassword` varchar(50) NOT NULL,
  `patientName` varchar(60) NOT NULL,
  `patientContact` int(11) NOT NULL,
  `patientAddress` varchar(60) NOT NULL,
  `patientEmail` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientID`, `patientUserName`, `patientPassword`, `patientName`, `patientContact`, `patientAddress`, `patientEmail`) VALUES
(1, 'admin', 'admin', 'admin', 345, 'admin', 'admin@gmial.com'),
(2, 'ggfd', 'gfd', 'gfdg', 546, 'hgfhg', 'gfhgfhg'),
(3, 'gdfg', 'fdg', 'gfd', 234, 'dgf', 'gfdgdfgdfgdfgd'),
(4, 'sdsfdsfs', 'fdsd', 'vxcvx', 534534, 'fsfdds', 'fgdfg'),
(5, 'gegdf', 'fdgdf', 'fdgdfg', 32432, 'gfdgd', 'fsdfsdgg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`),
  ADD UNIQUE KEY `patientUserName` (`patientUserName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
