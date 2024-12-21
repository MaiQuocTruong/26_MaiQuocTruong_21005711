-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.36 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for 26_maiquoctruong_21005711
CREATE DATABASE IF NOT EXISTS `26_maiquoctruong_21005711` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `26_maiquoctruong_21005711`;

-- Dumping structure for table 26_maiquoctruong_21005711.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3046kvjyysq288vy3lsbtc9nw` (`role_id`),
  CONSTRAINT `FK3046kvjyysq288vy3lsbtc9nw` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table 26_maiquoctruong_21005711.employee: ~2 rows (approximately)
INSERT INTO `employee` (`id`, `name`, `password`, `role_id`) VALUES
	(1, 'ADMIN', '$2a$12$JrKXR9S8EgACvUQBBBIr.eXuoOV2jHJXa11Xq9.GDqet7e1KWkIqW', 1),
	(2, 'USER', '$2a$12$c9x6MjofiTb/ydyRT8bTQObcfuU7Z16/1HieharlKoJFw/bxd75mm', 2);

-- Dumping structure for table 26_maiquoctruong_21005711.lophoc
CREATE TABLE IF NOT EXISTS `lophoc` (
  `malop` int NOT NULL AUTO_INCREMENT,
  `tenlop` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`malop`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table 26_maiquoctruong_21005711.lophoc: ~2 rows (approximately)
INSERT INTO `lophoc` (`malop`, `tenlop`) VALUES
	(1, 'DHKTPM17ATT'),
	(2, 'DHKTPM17CTT');

-- Dumping structure for table 26_maiquoctruong_21005711.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table 26_maiquoctruong_21005711.role: ~2 rows (approximately)
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'ADMIN'),
	(2, 'USER');

-- Dumping structure for table 26_maiquoctruong_21005711.sinhvien
CREATE TABLE IF NOT EXISTS `sinhvien` (
  `malop` int NOT NULL,
  `masv` int NOT NULL AUTO_INCREMENT,
  `ngaysinh` date NOT NULL,
  `tensv` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dienthoai` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`masv`),
  KEY `FKrrsnqmcn2k11d10tpsh5gfwpd` (`malop`),
  CONSTRAINT `FKrrsnqmcn2k11d10tpsh5gfwpd` FOREIGN KEY (`malop`) REFERENCES `lophoc` (`malop`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table 26_maiquoctruong_21005711.sinhvien: ~7 rows (approximately)
INSERT INTO `sinhvien` (`malop`, `masv`, `ngaysinh`, `tensv`, `dienthoai`, `email`, `gioitinh`) VALUES
	(1, 1, '2003-03-24', 'Mai Quốc Trưởng', '0398911257', 'maiqtruong@gmail.com', 'Nam'),
	(2, 2, '2003-11-23', 'Nguyễn Văn A', '0986818333', 'ngueynvana@gmail.com', 'Nam'),
	(2, 3, '2016-02-03', 'Nguyễn Thị Lan', '0955818132', 'lan@gmail.com', 'Nữ'),
	(1, 4, '2003-01-20', 'aaa', '0955818132', 'aa@gmail.com', 'Nam'),
	(1, 5, '2002-01-31', 'Le Trong Thien', '123456789', 'thien@gmail.com', 'Nam'),
	(2, 6, '2003-03-03', 'Trần Thiên Trí', '1234567813', 'tri@gmail.com', 'Nữ'),
	(2, 7, '2003-12-31', 'Hải Nguyễn', '0631567813', 'hai123@gmail.com', 'Nam');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
