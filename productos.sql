-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-08-2022 a las 06:28:09
-- Versión del servidor: 8.0.11
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `misproductos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `pid` int(11) NOT NULL,
  `pnombre` varchar(20) NOT NULL,
  `pciudad` varchar(20) NOT NULL,
  `pprecio` float NOT NULL,
  `pcantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`pid`, `pnombre`, `pciudad`, `pprecio`, `pcantidad`) VALUES
(9, 'PULLBEAR', 'Cuenca', 20, 45),
(10, 'Tomates', 'Cuenca', 20, 45),
(11, 'Aguacate', 'Quito', 10, 45),
(12, 'Tomates', 'Cuenca', 20, 45),
(13, 'Aguacate', 'Quito', 10, 45),
(14, 'Aceite', 'Quito', 12, 100),
(15, 'Zanahorias', 'Cuenca', 82, 40),
(16, 'Papas', 'Loja', 12, 100),
(17, 'Cebolla', 'Sto. Domingo', 50, 100),
(18, 'Pepino', 'Guayaquil', 12, 100),
(19, 'Ajo', 'Quito', 90, 100),
(20, 'Tomate de arbol', 'Sucumbíos', 120, 100),
(21, 'Manzanas', 'Machala', 127, 100),
(22, 'Arepas', 'Duran', 132, 100),
(23, 'Agua', 'El guasmo', 82, 100),
(24, 'Banana', 'Manabí', 46, 100),
(25, 'Frutilla', 'Portoviejo', 32, 100),
(26, 'Durazno', 'Quito', 87, 100),
(27, 'Coco', 'Carchi', 98, 100),
(28, 'Remolacha', 'Chimborazo', 92, 100),
(29, 'Achotillo', 'Zamora', 70, 100),
(30, 'Acelga', 'Sta. Elena', 80, 100),
(31, 'Pimiento', 'Sangolqui', 90, 100),
(32, 'Aliño', 'El valle', 12, 100),
(33, 'Arroba de arroz', 'Orellana', 11, 100),
(34, 'Jugos ya', 'Zamora chinchipe', 8, 100),
(35, 'Nestea', 'Portoviejo', 10, 100),
(36, 'Frescosolo', 'Ambato', 15, 100),
(37, 'Doritos', 'Tungurahua', 2, 100),
(38, 'Kchitos', 'Otavalo', 0.35, 100),
(39, 'Papitas', 'Sangolqui', 0.4, 100),
(40, 'Chifles', 'Quito', 0.6, 100),
(41, 'Platanitos de sal ', 'Zamora chinchipe', 0.7, 100),
(42, 'Platanitos de dulce', 'Loja', 12, 100),
(43, 'Piña', 'Azuay', 12, 100),
(44, 'Cocoa', 'Napo', 12, 100);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`pid`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
