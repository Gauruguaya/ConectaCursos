-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-12-2024 a las 14:43:14
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nueva_academia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre_cat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre_cat`) VALUES
(2, 'Programación'),
(3, 'Diseño Web'),
(4, 'Base de Datos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_seq`
--

CREATE TABLE `categoria_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria_seq`
--

INSERT INTO `categoria_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL,
  `desc_curso` varchar(255) NOT NULL,
  `fecha_fin_curso` datetime(6) NOT NULL,
  `fecha_inicio_curso` datetime(6) NOT NULL,
  `imagen_curso` varchar(255) NOT NULL,
  `nombre_curso` varchar(255) NOT NULL,
  `categoria_id_categoria` int(11) DEFAULT NULL,
  `profesor_id_profesor` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_seq`
--

CREATE TABLE `curso_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `curso_seq`
--

INSERT INTO `curso_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `id_profesor` int(11) NOT NULL,
  `email_prof` varchar(255) NOT NULL,
  `foto_prof` varchar(255) NOT NULL,
  `nombre_prof` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id_profesor`, `email_prof`, `foto_prof`, `nombre_prof`) VALUES
(1, 'profesor@ifsul.edu.br', '', 'Alfredo Gomes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor_seq`
--

CREATE TABLE `profesor_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `profesor_seq`
--

INSERT INTO `profesor_seq` (`next_val`) VALUES
(1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `FKe32vakthp0f6mf7k0ihsxlddx` (`categoria_id_categoria`),
  ADD KEY `FK7nh6tq2gtbogm0a2qnk3qmkd4` (`profesor_id_profesor`),
  ADD KEY `FK4yftnjuuemdgwgfqp3tw1g9us` (`id_categoria`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id_profesor`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `FK4yftnjuuemdgwgfqp3tw1g9us` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `FK7nh6tq2gtbogm0a2qnk3qmkd4` FOREIGN KEY (`profesor_id_profesor`) REFERENCES `profesor` (`id_profesor`),
  ADD CONSTRAINT `FKe32vakthp0f6mf7k0ihsxlddx` FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
