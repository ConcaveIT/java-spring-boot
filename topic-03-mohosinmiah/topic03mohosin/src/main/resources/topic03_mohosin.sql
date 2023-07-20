-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2023 at 05:56 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `topic03_mohosin`
--

-- --------------------------------------------------------

--
-- Table structure for table `cost_categories`
--

CREATE TABLE `cost_categories` (
  `id` bigint(20) NOT NULL,
  `category_description` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cost_categories`
--

INSERT INTO `cost_categories` (`id`, `category_description`, `category_name`) VALUES
(1, 'Category Description', 'Category Name');

-- --------------------------------------------------------

--
-- Table structure for table `cost_items`
--

CREATE TABLE `cost_items` (
  `id` bigint(20) NOT NULL,
  `amount` double NOT NULL,
  `date` date DEFAULT NULL,
  `item_description` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `approved_by` bigint(20) DEFAULT NULL,
  `cost_category_id` bigint(20) DEFAULT NULL,
  `entry_by` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cost_items`
--

INSERT INTO `cost_items` (`id`, `amount`, `date`, `item_description`, `item_name`, `status`, `approved_by`, `cost_category_id`, `entry_by`, `project_id`) VALUES
(1, 100, '2023-06-27', 'Item Description', 'Item Name', 'Pending', 2, 1, 2, 1),
(4, 200, '2023-06-27', 'Item Description', 'Item Name', 'Pending', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL,
  `end_date` date DEFAULT NULL,
  `project_description` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`id`, `end_date`, `project_description`, `project_name`, `start_date`, `status`) VALUES
(1, '2023-07-30', 'This is a sample project', 'Sample Project', '2023-06-28', 'In Progress'),
(2, '2023-07-30', 'This is a sample project Two', 'Sample Project Two ', '2023-06-28', 'In Progress');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `roles_seq`
--

CREATE TABLE `roles_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roles_seq`
--

INSERT INTO `roles_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `department`, `email`, `member_name`, `password`, `status`, `username`) VALUES
(1, 'cse', 'mohosin@gmail.com', 'hhh', '$2a$10$qBgjK84X78kZ1DHpJ4t7uOA3gf1mhd1ImBLl8Hu.iaOE9QGiBZ6p6', 'Success', 'mohosin'),
(2, 'admin', 'admin@gmail.com', 'admin', '$2a$10$95B8opBb8zCm4gtl2w/NRu1ONMqdmgGFbqnu3Rl.B880/W/ZOKfZu', 'SUCCESS', 'admin'),
(204, 'IT', 'johnsmith@example.com', 'John Smith', '$2a$10$owfbwQfwRaGXdr82tv8h4O71GVuZBzQEwlDYdZbTQrtp6J6GAs6tu', 'Active', 'userone'),
(254, 'IT', 'eee@example.com', 'John Smith', '$2a$10$hwKzka1BYOayO3DNxVTYF.iwL17xjaT3bAXMuA4N13mihxz3ucw0u', 'Active', 'ss');

-- --------------------------------------------------------

--
-- Table structure for table `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(351);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(204, 1),
(204, 2),
(254, 1),
(254, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cost_categories`
--
ALTER TABLE `cost_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cost_items`
--
ALTER TABLE `cost_items`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_tbix57l5fia63ewxtaiyju04w` (`approved_by`),
  ADD UNIQUE KEY `UK_kmtvt0aegghej5tfdhmsc676q` (`entry_by`),
  ADD KEY `FK4vex5u7u4qp7xvnkss0s527pv` (`cost_category_id`),
  ADD KEY `FKar256wceghefly61p6ex2lo9e` (`project_id`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cost_categories`
--
ALTER TABLE `cost_categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cost_items`
--
ALTER TABLE `cost_items`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cost_items`
--
ALTER TABLE `cost_items`
  ADD CONSTRAINT `FK1pjqhr4k51hx6fjux5ivjto8d` FOREIGN KEY (`approved_by`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FK4vex5u7u4qp7xvnkss0s527pv` FOREIGN KEY (`cost_category_id`) REFERENCES `cost_categories` (`id`),
  ADD CONSTRAINT `FKar256wceghefly61p6ex2lo9e` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `FKmlx69xkujs8v3rxjwlo3mb7ab` FOREIGN KEY (`entry_by`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
