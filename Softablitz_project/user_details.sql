-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Oct 08, 2020 at 07:29 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `daretotravel`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `id` int(10) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `passwordch` varchar(100) NOT NULL,
  `Gender` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id`, `firstname`, `lastname`, `username`, `password`, `email_id`, `contact`, `passwordch`, `Gender`) VALUES
(1, 'Abhinav', 'Anand', 'abhinav1001', 'helloworld', '10.abhinav.anand.01@gmail.com', '+91-1234567890', '', ''),
(2, 'qwerty', 'keyboard', 'qwerty07', 'qwerty', 'qwerty101@gmail.com', '+91-92817381', '', ''),
(3, 'MS', 'Dhoni', 'mahi07', 'cskislove', 'mahi07@gmail.com', '+91-7777777777', '', ''),
(4, 'Indira', 'Nui', 'indirapepsico', 'qwerty', 'pepsico@pepsi.com', '+91-1234567', 'qwerty', 'null'),
(5, 'Indira', 'Nui', 'indirapepsico', 'qwerty', 'pepsico@pepsi.com', '+91-1234567', 'qwerty', 'null'),
(6, 'Selina', 'kayle', 'batwoman', 'imbatman', 'theftislove@dark.com', '+91-0101010', 'imbatman', 'Female');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
