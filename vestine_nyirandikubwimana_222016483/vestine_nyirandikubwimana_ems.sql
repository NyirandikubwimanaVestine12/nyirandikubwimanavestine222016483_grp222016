-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:40 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vestine_nyirandikubwimana_ems`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `admin_id` int(12) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`admin_id`, `username`, `password`) VALUES
(1, 'vestine', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `bank_account` varchar(200) NOT NULL,
  `bank_name` varchar(255) NOT NULL,
  `transaction_name` varchar(255) NOT NULL,
  `amounts` int(12) NOT NULL,
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`bank_account`, `bank_name`, `transaction_name`, `amounts`, `date`) VALUES
('222_016_483', 'bk', 'deposit', 500000, '2023/12/23'),
('4004120', 'Equity', 'Deposit', 4000000, '2024/17/04'),
('4020', 'ECOBANK', 'loans', 450000, '2024/01/18');

-- --------------------------------------------------------

--
-- Table structure for table `customersales`
--

CREATE TABLE `customersales` (
  `customer_id` int(12) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `order_quantity` int(12) NOT NULL,
  `payments_methods` varchar(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customersales`
--

INSERT INTO `customersales` (`customer_id`, `product_name`, `customer_name`, `telephone`, `order_quantity`, `payments_methods`, `date`) VALUES
(1, 'juice', 'vestine', '0783242567', 25, 'cash', '2024-05-02'),
(2, 'milk', 'brain', '07865654322', 50, 'bank', '2024-02-03'),
(4, 'water', 'veronique', '0789656900', 5, 'cash', '2024-09-04'),
(7, 'milks', 'rwibutso', '0795463789', 780, 'bank', '2024-06-02');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(12) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `quantity` int(12) NOT NULL,
  `unity` varchar(45) NOT NULL,
  `selling_price` int(21) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `quantity`, `unity`, `selling_price`) VALUES
(1, 'beans', 50, 'imifuka 10', 5000),
(2, 'maize', 200, '10 package', 2500),
(3, 'milks', 3000, '30 litles', 1200),
(4, 'oil', 230, '35kg', 9000),
(5, 'water', 900, '100liltle', 1200);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supply_id` int(12) NOT NULL,
  `supply_name` varchar(255) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `unitprice` int(12) NOT NULL,
  `sellingprice` int(21) NOT NULL,
  `quantity` int(20) NOT NULL,
  `paymentsmethod` varchar(250) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supply_id`, `supply_name`, `product_name`, `unitprice`, `sellingprice`, `quantity`, `paymentsmethod`, `date`) VALUES
(1, 'vestine', 'BEER', 4000, 8000, 560, 'cash', '2024-02-09'),
(2, 'GANZA', 'juice', 700, 1000, 45, 'bank', '2023-07-23'),
(4, 'rukundo', 'rice', 1500, 2000, 50, 'cash', '2024-09-04'),
(5, 'ISIMBI', 'CASSAVA', 6700, 8000, 2500, 'BANK', '2024-03-05');

-- --------------------------------------------------------

--
-- Table structure for table `transction`
--

CREATE TABLE `transction` (
  `transction_no` int(12) NOT NULL,
  `transction_name` varchar(255) NOT NULL,
  `transction_type` varchar(255) NOT NULL,
  `amounts` int(12) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transction`
--

INSERT INTO `transction` (`transction_no`, `transction_name`, `transction_type`, `amounts`, `date`) VALUES
(1, 'sales', 'beans', 20000, '2024-01-02'),
(2, 'purchose', 'juice', 12000, '2024-01-01'),
(3, 'purchose', 'beer', 550000, '2024-08-09'),
(4, 'purchase', 'milks', 50000, '2024-04-02');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(12) NOT NULL,
  `name` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `age` int(11) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `email` varchar(250) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `position`, `gender`, `age`, `mobile`, `email`, `username`, `password`) VALUES
(1, 'vestine', 'admin', 'female', 23, '782161295', 'ves@2023', 'veve', '123'),
(2, 'GANZA', 'user', 'male', 45, '784598765', 'nza@gmail.com', 'ganza', '12345'),
(3, 'Isimbi', 'user', 'female', 12, '784532432', 'isimbi@gmail.com', 'isimbi', '1234'),
(5, 'ssd', 'user', 'male', 24, '797564345', 'ssd@gmail.com', 'said', 'ssd'),
(6, 'nick', 'manager', 'female', 23, '784342567', 'nick@gmail.com', 'nick', '123'),
(7, 'brice', 'analyst', 'male', 19, '72131432', 'bb@gmail.com', 'nice', '123'),
(10, 'beaty', 'user', 'female', 23, '786574656', 'beaty@gmail.com', 'bebe', 'bebe');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminlogin`
--
ALTER TABLE `adminlogin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`bank_account`);

--
-- Indexes for table `customersales`
--
ALTER TABLE `customersales`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supply_id`);

--
-- Indexes for table `transction`
--
ALTER TABLE `transction`
  ADD PRIMARY KEY (`transction_no`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminlogin`
--
ALTER TABLE `adminlogin`
  MODIFY `admin_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customersales`
--
ALTER TABLE `customersales`
  MODIFY `customer_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supply_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4346;

--
-- AUTO_INCREMENT for table `transction`
--
ALTER TABLE `transction`
  MODIFY `transction_no` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
