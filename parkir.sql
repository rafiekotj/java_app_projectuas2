-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Jun 2023 pada 10.49
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkir_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `parkir`
--

CREATE TABLE `parkir` (
  `no_tiket` int(11) NOT NULL,
  `nopol` varchar(10) NOT NULL,
  `jenis` varchar(10) NOT NULL,
  `tgl_masuk` date DEFAULT NULL,
  `jam_masuk` time DEFAULT NULL,
  `tgl_keluar` date DEFAULT NULL,
  `jam_keluar` time DEFAULT NULL,
  `durasi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `parkir`
--

INSERT INTO `parkir` (`no_tiket`, `nopol`, `jenis`, `tgl_masuk`, `jam_masuk`, `tgl_keluar`, `jam_keluar`, `durasi`) VALUES
(3, 'A 1234 ABC', 'Motor', '2023-06-23', '00:15:12', '2023-06-23', '11:15:10', NULL),
(4, 'B 3434 CDE', 'Mobil', '2023-06-23', '00:15:59', '2023-06-23', '11:16:37', NULL),
(5, 'B 6785 ASD', 'Motor', '2023-06-23', '00:24:42', '2023-06-23', '00:24:46', NULL),
(6, 'B 9856 SDQ', 'Mobil', '2023-06-23', '08:02:09', '2023-06-23', '11:06:24', NULL),
(7, 'B 6745 DGH', 'Motor', '2023-06-23', '11:05:57', '2023-06-23', '13:45:08', NULL),
(8, 'B 8976 SVF', 'Motor', '2023-06-23', '11:06:15', '2023-06-23', '14:45:08', NULL),
(9, 'B 1234 BNV', 'Mobil', '2023-06-23', '14:42:43', '2023-06-23', '14:43:07', NULL),
(10, 'B 9876 NMJ', 'Motor', '2023-06-23', '14:43:40', '2023-06-23', '14:43:48', NULL),
(11, 'B 5647 JHG', 'Mobil', '2023-06-23', '14:44:51', NULL, NULL, NULL),
(12, 'B 7865 TYU', 'Motor', '2023-06-23', '15:02:29', NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `parkir`
--
ALTER TABLE `parkir`
  ADD PRIMARY KEY (`no_tiket`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `parkir`
--
ALTER TABLE `parkir`
  MODIFY `no_tiket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
