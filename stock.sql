-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 22-05-2019 a las 04:12:46
-- Versión del servidor: 5.7.23
-- Versión de PHP: 7.1.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `stock`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `OrderID` bigint(13) NOT NULL,
  `RecipientName` varchar(20) NOT NULL,
  `Price` decimal(5,3) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Total` decimal(5,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `ID` int(2) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `EAN` bigint(13) NOT NULL,
  `Stock` smallint(5) NOT NULL,
  `Price` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`ID`, `Name`, `EAN`, `Stock`, `Price`) VALUES
(1, 'Cable', 2044744379129, 1000, '1.00'),
(2, 'Capacitor', 580742600473, 500, '0.50'),
(3, 'Connector', 2582685331238, 300, '0.75'),
(4, 'Diode', 2829793958675, 1200, '0.25'),
(5, 'Inductor', 9829810988169, 200, '0.50'),
(6, 'Resistor', 5615788925534, 1500, '0.20'),
(7, 'Sensor', 8061403664468, 100, '1.50'),
(8, 'Transformer', 6131919588892, 200, '5.00'),
(9, 'Transistor', 2724134741001, 1500, '0.65'),
(10, 'Display', 3765916792452, 200, '3.75'),
(11, 'Ribbon', 4255092333079, 1000, '0.45'),
(12, 'Microcontroller', 2781652758218, 1700, '3.25'),
(13, 'Comparator', 5526948823099, 600, '4.25'),
(14, 'Temperature Sensor', 8663178771633, 300, '4.65'),
(15, 'Timer', 2747009402319, 70, '2.25'),
(16, 'Voltage Ref.', 29939124991, 100, '0.75'),
(17, 'Voltage Regulator', 797102417484, 200, '1.25'),
(18, 'Filter', 6790451544454, 1300, '0.50'),
(19, 'Inductor', 8016824490837, 150, '1.50'),
(20, 'Distance Sensor', 9929647161183, 200, '0.75'),
(21, 'Fuse', 8388318059616, 80, '0.25'),
(22, 'Motor', 2256509600540, 100, '3.45'),
(23, 'Laser', 6309521752349, 30, '5.75'),
(24, 'LED', 2423951354080, 1600, '0.50'),
(25, 'LED 3mm', 2615927047205, 1440, '0.25'),
(26, 'LED 5mm', 3989475530656, 1200, '0.85'),
(27, 'Optocoupler', 2863288470488, 650, '0.55'),
(28, 'Keypad', 6861805085883, 30, '10.75'),
(29, 'Rotary Encoder', 5343824755189, 25, '0.50'),
(30, 'Toggle Switch', 1372117895213, 100, '1.45'),
(31, 'Power Supply', 1700649567429, 20, '40.95'),
(32, 'Transformer', 8142224970423, 10, '59.45'),
(33, 'Wall Adapter', 6367048371894, 300, '5.45'),
(34, 'MOSFET', 7812252787263, 1500, '9.50'),
(35, 'GPS', 7420828940792, 40, '9.75'),
(36, 'TFT Screen', 9579755235865, 60, '10.25'),
(37, 'IR LED', 2202707837097, 10, '12.75'),
(38, 'Heat Sink', 398776916237, 30, '10.75'),
(39, 'Network Cable', 1048633644870, 540, '1.70'),
(40, 'Fiber Optic Cable', 9850397058464, 247, '10.95'),
(41, 'WLAN', 5160730934305, 53, '15.45'),
(42, 'ZigBee', 2048141037217, 34, '10.75'),
(43, 'RFID', 2810309169166, 70, '0.95'),
(44, 'Moisture Sensor', 3514102418566, 100, '9.85'),
(45, 'Temperature Sensor', 8099232711541, 35, '7.25'),
(46, 'Pressure Sensor', 4168713452625, 230, '5.85'),
(47, 'Accelerometer', 9407511670776, 55, '3.45'),
(48, 'Light', 4971976949265, 200, '2.75'),
(49, 'Proximity Sensor', 8670805604776, 300, '1.95'),
(50, 'Potentiometer', 4758715527676, 740, '1.15'),
(51, 'Relay', 3080863603522, 250, '0.75'),
(53, 'Prueba', 1231231231231, 12, '5.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sells`
--

CREATE TABLE `sells` (
  `ID` int(4) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `EAN` bigint(13) NOT NULL,
  `Stock` smallint(5) NOT NULL,
  `Price` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sells`
--

INSERT INTO `sells` (`ID`, `Name`, `EAN`, `Stock`, `Price`) VALUES
(3, 'Connector', 2582685331238, 300, '0.75'),
(4, 'Diode', 2829793958675, 1200, '0.25'),
(6, 'Resistor', 5615788925534, 1500, '0.20'),
(10, 'Display', 3765916792452, 200, '3.75');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Nombre` varchar(20) NOT NULL,
  `Password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Nombre`, `Password`, `Email`) VALUES
('aa', '1234', 'aa@aa.es'),
('Admin', 'admin', 'admin@electronics4everyone.com'),
('Carlos', '1234', 'carlosma51199@gmail.com'),
('Prueba', '1234', 'prueba@prueba.es'),
('Prueba2', '1234', 'prueba2@prueba2.com'),
('Prueba3', '1234', 'prueba3@prueba3.com'),
('Prueba4', '1234', 'prueba4@prueba4.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `sells`
--
ALTER TABLE `sells`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD UNIQUE KEY `Nombre` (`Nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `orders`
--
ALTER TABLE `orders`
  MODIFY `OrderID` bigint(13) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `ID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
