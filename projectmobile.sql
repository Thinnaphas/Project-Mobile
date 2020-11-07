-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2020 at 10:17 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectmobile`
--

-- --------------------------------------------------------

--
-- Table structure for table `catalogue`
--

CREATE TABLE `catalogue` (
  `id_shirt` int(4) NOT NULL,
  `name_shirt` varchar(50) NOT NULL,
  `detail` varchar(500) NOT NULL,
  `price` varchar(11) NOT NULL,
  `img_shirt` varchar(500) NOT NULL,
  `usr_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `catalogue`
--

INSERT INTO `catalogue` (`id_shirt`, `name_shirt`, `detail`, `price`, `img_shirt`, `usr_id`) VALUES
(4, 'TARABOAW', 'Rare item', '500', 'https://sv1.picz.in.th/images/2020/11/08/bjbaxu.jpg', 'null'),
(7, 'Akasuki T-shirt', 'Sasuke used to own this shirt.', '500', 'https://sv1.picz.in.th/images/2020/11/08/bjlGJe.jpg', '13'),
(8, 'Pattern Thai T-shirt', 'The shirt that used to be famous', '550', 'https://sv1.picz.in.th/images/2020/11/08/bjlFYE.jpg', '13'),
(9, 'TROTCS T-Shirt', 'shirt for the men who love their county', '3000', 'https://sv1.picz.in.th/images/2020/11/08/bjofYy.jpg', '13');

-- --------------------------------------------------------

--
-- Table structure for table `ordertable`
--

CREATE TABLE `ordertable` (
  `id_order` int(11) NOT NULL,
  `name_shirt` varchar(50) NOT NULL,
  `name_surname` varchar(50) NOT NULL,
  `address` varchar(500) NOT NULL,
  `payment` varchar(50) NOT NULL,
  `shipping` varchar(50) NOT NULL,
  `price` varchar(11) NOT NULL,
  `img_shirt` varchar(500) NOT NULL,
  `id_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ordertable`
--

INSERT INTO `ordertable` (`id_order`, `name_shirt`, `name_surname`, `address`, `payment`, `shipping`, `price`, `img_shirt`, `id_name`) VALUES
(6, 'เสื้อวง', 'thrhdrfghnjfghgkldfhjbkladfh', 'fdhsdfghklsdfjgklhjfgklhnbjkl;hebjanriklh', 'ชำระเงินปลายทาง', 'ไปรษณีย์ไทย', '200', 'https://sv1.picz.in.th/images/2020/11/03/bQPtQI.jpg', 'nutthachai'),
(7, 'เสื้อ IRON MAIDEN', 'iyhuioyhuiohui', 'hygb7ytfgt6y7ftyugftyf', 'ชำระเงินปลายทาง', 'Kerry', '500', 'https://sv1.picz.in.th/images/2020/11/03/bQPVFz.jpg', 'nutthachai'),
(8, 'เสื้อ NIRVANA', 'sdad', 'sdasd', 'เลือกวิธีการชำระเงิน', 'เลือกวิธีการจัดส่ง', '400', 'https://sv1.picz.in.th/images/2020/11/03/bQsdtk.jpg', 'nutthachai'),
(9, 'Crop Top Shirt', 'Natthachai.na', '456/5', 'Paypal', 'J and T', '150', 'https://sv1.picz.in.th/images/2020/11/08/bjAdGg.jpg', 'nutthachai'),
(10, 'DJ Ong T-shirt', 'Theeraphong eiei', '585/2', 'ชำระเงินปลายทาง', 'ไปรษณีย์ไทย', '150', 'https://sv1.picz.in.th/images/2020/11/08/bjl2Jq.jpg', 'nutthachai'),
(11, 'Mike piromporn', 'Theeraphong lilpi', '585/2 M.2', 'บัตรเครดิต/เดบิต', 'Kerry', '700', 'https://sv1.picz.in.th/images/2020/11/08/bjjUU0.jpg', 'nutthachai');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `usr_id` int(2) NOT NULL,
  `id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `surname` varchar(200) NOT NULL,
  `phone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`usr_id`, `id`, `password`, `name`, `surname`, `phone`) VALUES
(1, 'maxmaxmax', '123456', 'Theeraphong', 'Thawongsa', '0877926971'),
(2, 'max', '123456', 'max', 'mmm', '123456789'),
(3, 'maxinwinw', '123123', 'MAXZEE', 'ZEEHEE', '0899999999'),
(13, 'nutnut', '456456', 'nutthachai', 'naksing', '0854321111'),
(14, 'maaaa', '1111', 'tttttttttt', 'raaaaaaa', '089999999');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`id_shirt`);

--
-- Indexes for table `ordertable`
--
ALTER TABLE `ordertable`
  ADD PRIMARY KEY (`id_order`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`usr_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `id_shirt` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `ordertable`
--
ALTER TABLE `ordertable`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `usr_id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
