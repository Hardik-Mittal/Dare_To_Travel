-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Oct 31, 2020 at 06:21 PM
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
-- Table structure for table `admin_details`
--

CREATE TABLE `admin_details` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_details`
--

INSERT INTO `admin_details` (`id`, `name`, `username`, `password`) VALUES
(1, 'daretotravel', 'daretotravel', 'helloworld'),
(2, 'softablitz', 'softablitz', 'java');

-- --------------------------------------------------------

--
-- Table structure for table `assign_date`
--

CREATE TABLE `assign_date` (
  `sno` int(100) NOT NULL,
  `train_no` int(100) NOT NULL,
  `date` date NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assign_date`
--

INSERT INTO `assign_date` (`sno`, `train_no`, `date`, `status`) VALUES
(1, 110, '2020-10-28', 'Running'),
(3, 103, '2020-10-29', 'Running'),
(4, 112, '2020-10-31', 'Running'),
(5, 103, '2020-10-31', 'Running');

-- --------------------------------------------------------

--
-- Table structure for table `assign_train`
--

CREATE TABLE `assign_train` (
  `sno` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `train no` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assign_train`
--

INSERT INTO `assign_train` (`sno`, `id`, `train no`) VALUES
(13, 1, '103'),
(14, 2, '110'),
(15, 1, '112'),
(16, 1, '111');

-- --------------------------------------------------------

--
-- Table structure for table `booking_details`
--

CREATE TABLE `booking_details` (
  `sno` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `train_no` int(11) NOT NULL,
  `train_name` varchar(100) NOT NULL,
  `train_source` varchar(100) NOT NULL,
  `train_dest` varchar(100) NOT NULL,
  `train_route` varchar(100) NOT NULL,
  `train_coach` varchar(100) NOT NULL,
  `train_time` varchar(100) NOT NULL,
  `train_status` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `no_of_seats` int(11) NOT NULL,
  `date` date NOT NULL,
  `user_booked` varchar(100) NOT NULL,
  `amt_paid` int(11) NOT NULL,
  `ticket_status` varchar(100) NOT NULL,
  `meals_status` varchar(100) NOT NULL,
  `meal_dest` varchar(100) NOT NULL,
  `waiting_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking_details`
--

INSERT INTO `booking_details` (`sno`, `id`, `train_no`, `train_name`, `train_source`, `train_dest`, `train_route`, `train_coach`, `train_time`, `train_status`, `first_name`, `last_name`, `no_of_seats`, `date`, `user_booked`, `amt_paid`, `ticket_status`, `meals_status`, `meal_dest`, `waiting_status`) VALUES
(4, 6, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'Sleeper', '5:00 AM', 'Running', 'poiu', 'poiu', 2, '2020-10-30', 'daretotravel', 100, '', '', '', 0),
(9, 6, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'Sleeper', '5:00 AM', 'Running', 'lkjhg', 'mnbvc', 1, '2020-10-30', 'daretotravel', 50, '', '', '', 0),
(10, 6, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'poiuh', 'jhgf', 3, '2020-10-30', 'daretotravel', 300, '', '', '', 0),
(11, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'abhinav', 'anand', 3, '2020-10-31', 'daretotravel', 300, 'confirmed', 'YES', 'Hogwarts', 0),
(12, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'abhinav', 'anand', 3, '2020-10-31', 'daretotravel', 300, 'confirmed', '', '', 0),
(13, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'abhinav', 'anand', 3, '2020-10-31', 'daretotravel', 300, 'confirmed', '', '', 0),
(14, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'Sleeper', '5:00 AM', 'Running', 'zap', 'blade', 2, '2020-10-31', 'daretotravel', 100, 'confirmed', 'YES', 'null', 0),
(15, 37, 112, 'snowland Exp', 'Hogwarts', 'DiagonAlly', 'London', 'AC II', '3:00 PM', 'Running', 'admin', 'admin', 3, '2020-11-28', 'softablitz', 150, 'confirmed', 'YES', 'London', 0),
(16, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'Sleeper', '5:00 AM', 'Running', 'zxcv', 'zxcv', 4, '2020-10-31', 'softablitz', 200, 'confirmed', '', '', 0),
(17, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'qwert', 'qwert', 5, '2020-10-31', 'softablitz', 500, 'confirmed', '', '', 0),
(18, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'poiuy', 'poiuy', 2, '2020-10-31', 'softablitz', 200, 'cancelled', '', '', 0),
(19, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'Sleeper', '5:00 AM', 'Running', 'lkjh', 'lkjhg', 4, '2020-10-31', 'softablitz', 200, 'cancelled', '', '', 0),
(20, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'nbvcx', 'mnbvcx', 2, '2020-10-31', 'softablitz', 200, 'confirmed', '', '', 0),
(21, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'jhgfd', 'jhgfd', 1, '2020-10-31', 'softablitz', 100, 'confirmed', '', '', 0),
(22, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'rew', 'ewq', 1, '2020-10-31', 'softablitz', 100, 'cancelled', 'cancelled', '', 0),
(23, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'ytd', 'gfd', 3, '2020-10-31', 'softablitz', 300, 'cancelled', '', '', -1),
(24, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'iuyt', 'uytre', 2, '2020-10-31', 'softablitz', 200, 'waiting', 'YES', 'Hogwarts', -2),
(25, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'Sleeper', '5:00 AM', 'Running', 'iuyt', 'ytre', 2, '2020-10-31', 'softablitz', 100, 'confirmed', '', '', 0),
(26, 7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'Sleeper', '5:00 AM', 'Running', 'poiuy', 'oiuy', 2, '2020-10-31', 'daretotravel', 100, 'confirmed', 'YES', 'Hogsmeed', 0),
(27, 6, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', 'AC II', '5:00 AM', 'Running', 'batwoman', 'selina', 2, '2020-10-31', 'batwoman', 200, 'cancelled', 'cancelled', '', 0),
(28, 4, 110, 'The Flying Car', 'Paris', 'Hogwarts', 'London', 'AC II', '3:00 AM', 'Running', 'hello', 'hello', 2, '2020-10-31', 'batwoman', 200, 'cancelled', 'cancelled', '', 0),
(29, 4, 110, 'The Flying Car', 'Paris', 'Hogwarts', 'London', 'Sleeper', '3:00 AM', 'Running', 'hello', 'hello', 4, '2020-10-31', 'batwoman', 200, 'cancelled', 'YES', 'Paris', 0),
(30, 4, 110, 'The Flying Car', 'Paris', 'Hogwarts', 'Hogwarts', 'AC II', '3:00 AM', 'Running', 'hello', 'hello', 4, '2020-10-31', 'batwoman', 400, 'cancelled', '', '', -4),
(31, 4, 110, 'The Flying Car', 'Paris', 'Hogwarts', 'Hogwarts', 'AC II', '3:00 AM', 'Running', 'hello', 'hello', 2, '2020-10-31', 'batwoman', 200, 'cancelled', '', '', -6),
(32, 4, 110, 'The Flying Car', 'Paris', 'Hogwarts', 'DiagonAlly', 'Sleeper', '3:00 AM', 'Running', 'qwer', 'asdfg', 3, '2020-10-31', 'batwoman', 150, 'waiting', 'YES', 'Paris', -2),
(33, 4, 110, 'The Flying Car', 'Paris', 'Hogwarts', 'Hogwarts', 'AC II', '3:00 AM', 'Running', 'asdfgh', 'sdfghj', 3, '2020-11-02', 'daretotravel', 240, 'confirmed', 'YES', 'Hogwarts', 0);

-- --------------------------------------------------------

--
-- Table structure for table `emp_details`
--

CREATE TABLE `emp_details` (
  `id` int(11) NOT NULL,
  `fName` varchar(100) NOT NULL,
  `lName` varchar(100) NOT NULL,
  `phoneNo` varchar(255) NOT NULL,
  `Desg` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp_details`
--

INSERT INTO `emp_details` (`id`, `fName`, `lName`, `phoneNo`, `Desg`) VALUES
(1, 'Abhinav', 'Anand', '01918192819', 'Railway Minister'),
(2, 'Hardik', 'Mittal', '263789017', 'west Zone head');

-- --------------------------------------------------------

--
-- Table structure for table `train_details`
--

CREATE TABLE `train_details` (
  `id` int(20) NOT NULL,
  `train_no` int(255) NOT NULL,
  `train_name` varchar(100) NOT NULL,
  `train_source` varchar(100) NOT NULL,
  `train_dest` varchar(100) NOT NULL,
  `train_route` varchar(100) NOT NULL,
  `train_time` varchar(100) NOT NULL,
  `train_status` varchar(100) NOT NULL,
  `ACII_Seats` int(11) NOT NULL,
  `ACII_Price` int(11) NOT NULL,
  `Sleeper_Seats` int(11) NOT NULL,
  `Sleeper_Price` int(11) NOT NULL,
  `train_date` date DEFAULT NULL,
  `avl_acII_seats` int(11) DEFAULT NULL,
  `avl_sleeper_seats` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `train_details`
--

INSERT INTO `train_details` (`id`, `train_no`, `train_name`, `train_source`, `train_dest`, `train_route`, `train_time`, `train_status`, `ACII_Seats`, `ACII_Price`, `Sleeper_Seats`, `Sleeper_Price`, `train_date`, `avl_acII_seats`, `avl_sleeper_seats`) VALUES
(3, 103, 'Azkaban Exp', 'DiagonAlly', 'Hogwarts', 'Hogwarts', '12:00 midnight', 'Cancelled', 0, 0, 0, 0, '2020-10-31', 0, 0),
(4, 110, 'The Flying Car', 'Paris', 'Hogwarts', 'London', '3:00 AM', 'Running', 43, 80, 75, 40, '2020-11-02', 52, 79),
(6, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', '5:00 AM', 'Running', 5, 100, 7, 50, '2020-10-31', 3, 6),
(7, 111, 'Paris Rover', 'Hogwarts', 'Paris', 'Hogsmeed', '5:00 AM', 'Running', 5, 100, 7, 50, '2020-10-31', 0, 0),
(37, 112, 'snowland Exp', 'Hogwarts', 'DiagonAlly', 'London', '3:00 PM', 'Running', 10, 50, 30, 20, '2020-11-28', 16, 33),
(158, 103, 'Azkaban Exp', 'DiagonAlly', 'Hogwarts', 'Hogwarts', '12:00 midnight', 'Cancelled', 0, 0, 0, 0, NULL, NULL, NULL),
(159, 110, 'The Flying Car', 'Paris', 'Hogwarts', 'London', '3:00 AM', 'Running', 43, 80, 75, 40, '2020-11-14', 43, 75);

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
(6, 'Selina', 'kayle', 'batwoman', 'imbatman', 'theftislove@dark.com', '+91-0101010', 'imbatman', 'Female'),
(7, 'git', 'hub', 'gitrepo', 'gitbash', 'git@github.com', '+91-909090', 'gitbash', 'Male'),
(8, 'qwerty', 'qwerty', 'qwerty08', 'qwerty', 'qwerty102@gmail.com', '091029289', 'qwerty', 'Male'),
(9, 'virat', 'kohli', 'vkohli', 'anushka', 'vk@indiacricket.com', '+91-2314637', 'anushka', 'Male'),
(10, 'asdf', 'asdf', 'asdf', 'asdf', 'asdf@asdf.asdf', '123456', 'asdf', 'Male'),
(11, 'zxcv', 'zxcv', 'zxcv', 'zxcv', 'zxcv@zxcv.zxcv', '12567', 'zxcv', 'Male'),
(12, 'Zap', 'blade', 'Zap', 'blade', 'yoyo@yoyo.yoyo', '098765', 'blade', 'Male'),
(13, 'qaz', 'qaz', 'qaz', 'qaz', 'qaz@qaz.qaz', '11111', 'qaz', 'Male'),
(14, 'poiu', 'poiu', 'poiu', 'poiu', 'poiu@poiu.poiu', '09876543', 'poiu', 'Male'),
(15, 'zxcv', 'zxcv', 'zxcvb', 'zxcvb', 'zxcvb@zxcv.zxcv', '123456789', 'zxcvb', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_details`
--
ALTER TABLE `admin_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `assign_date`
--
ALTER TABLE `assign_date`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `assign_train`
--
ALTER TABLE `assign_train`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `booking_details`
--
ALTER TABLE `booking_details`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `emp_details`
--
ALTER TABLE `emp_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `train_details`
--
ALTER TABLE `train_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_details`
--
ALTER TABLE `admin_details`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `assign_date`
--
ALTER TABLE `assign_date`
  MODIFY `sno` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `assign_train`
--
ALTER TABLE `assign_train`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `booking_details`
--
ALTER TABLE `booking_details`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `emp_details`
--
ALTER TABLE `emp_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `train_details`
--
ALTER TABLE `train_details`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=160;

--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
