-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-12-2020 a las 06:29:13
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `home_avos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `documento_Admin` bigint(10) NOT NULL,
  `Tipo_documento` varchar(3) NOT NULL,
  `Fecha_expedicion` varchar(10) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Ciudad` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`documento_Admin`, `Tipo_documento`, `Fecha_expedicion`, `Nombre`, `Apellido`, `Ciudad`) VALUES
(141455, 'C.C', '22/01/2002', 'Maria', 'Admin', 'Soacha');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `adulto_mayor`
--

CREATE TABLE `adulto_mayor` (
  `documento_AM` bigint(10) NOT NULL,
  `documento_Fam` bigint(10) NOT NULL,
  `Tipo_documento` varchar(3) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `RH` varchar(3) NOT NULL,
  `Genero` varchar(6) NOT NULL,
  `Fecha_nacimiento` varchar(10) NOT NULL,
  `Cuidados_especiales` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `adulto_mayor`
--

INSERT INTO `adulto_mayor` (`documento_AM`, `documento_Fam`, `Tipo_documento`, `Nombre`, `Apellido`, `RH`, `Genero`, `Fecha_nacimiento`, `Cuidados_especiales`) VALUES
(342342, 1000123486, 'C.C', 'Carlos', 'Martinez', 'O+', 'Hombre', '2020-11-03', 'Nada especial'),
(453781, 123470, 'C.C', 'Hernando', 'Torres', 'O+', 'Hombre', '1940-01-01', 'Gastritis'),
(974514, 1000123486, 'C.C', 'Andres', 'Gomez', 'AB+', 'Hombre', '1950-12-12', 'Requiere de pastillas cada 24 horas'),
(9547810, 1001346343, 'C.E', 'Nairo', 'Hernandez', 'A+', 'Hombre', '1950-10-04', 'Le gusta mirar jovencitas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_plan`
--

CREATE TABLE `compra_plan` (
  `cod_Compra` bigint(20) NOT NULL,
  `NIT` bigint(20) NOT NULL,
  `codPlan` bigint(20) NOT NULL,
  `fecha_hora` varchar(30) NOT NULL,
  `metodo_Pago` varchar(50) NOT NULL,
  `valor_Total` bigint(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familiar`
--

CREATE TABLE `familiar` (
  `documento_Fam` bigint(10) NOT NULL,
  `Tipo_documento` varchar(3) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Genero` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `familiar`
--

INSERT INTO `familiar` (`documento_Fam`, `Tipo_documento`, `Nombre`, `Apellido`, `Genero`) VALUES
(123470, 'C.C', 'Edubin', 'Torres', 'Hombre'),
(1000123486, 'C.C', 'Juan David', 'Gonzalez Corredor', 'Hombre'),
(1001346343, 'C.C', 'Deivids ', 'Ramírez', 'Hombre'),
(1001456993, 'C.E', 'Deisy Viviana', 'Blanco Gutierrez', 'Mujer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hogar_geriatrico`
--

CREATE TABLE `hogar_geriatrico` (
  `NIT` bigint(20) NOT NULL,
  `rep_Legal` varchar(80) NOT NULL,
  `tipo_Documento` varchar(3) NOT NULL,
  `num_Documento` bigint(10) NOT NULL,
  `nom_Residencia` varchar(50) NOT NULL,
  `Telefono2` bigint(10) NOT NULL,
  `Ciudad` varchar(15) NOT NULL,
  `descripcion` varchar(1200) NOT NULL,
  `descrp_corta` varchar(380) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hogar_geriatrico`
--

INSERT INTO `hogar_geriatrico` (`NIT`, `rep_Legal`, `tipo_Documento`, `num_Documento`, `nom_Residencia`, `Telefono2`, `Ciudad`, `descripcion`, `descrp_corta`) VALUES
(56780, 'Samuel Padilla', 'C.C', 1000340372, 'Hogar geriátrico Puerto Alegra ', 3155572985, 'Bogotá', 'Nos esforzamos para conseguir el bienestar de cada persona, promoviendo un envejecimiento activo. Nuestro hogar cuenta con un ambiente que favorece que los residentes hagan amigos y compartan activamente para evitar la soledad.\r\n \r\nCada día trabajamos para ofrecer la mejor atención a los mayores, con la profesionalidad y calidad humana que siempre ha caracterizado al personal.\r\n \r\nContamos con un equipo de profesionales cualificados en diferentes áreas que proporcionará un servicio integral y personalizado al residente.', 'Nos esforzamos para conseguir el bienestar de cada persona, promoviendo un envejecimiento activo. Nuestro hogar cuenta con un ambiente que favorece que los residentes hagan amigos y compartan activamente para evitar la soledad. '),
(102335, 'Juan Gonzalez', 'C.C', 65432123, 'Grand Pa´s Hogar de Abuelos', 7812537, 'Soacha', 'El hogar Grandpa\'s es un lugar donde buscamos hacer placentera y felíz la vida de las personas mayores a través de una convivencia sana y compartida, con espacios adecuados para ellos, actividades físicas y recreativas, nutrición balanceada y aprendizaje permanente. Contamos con equipos profesionales, expertos y capacitados, con calidez humana excepcional para brindar el mejor servicio a nuestros residentes. Trabajamos en aumentar el grado de felicidad y motivación de las personas mayores, a través de un equipo joven, profesional y humano, enfocado en mejorar la calidad de vida y el bienestar emocional, físico y espiritual.', 'El hogar Grandpa\'s es un lugar donde buscamos hacer placentera y felíz la vida de las personas mayores a través de una convivencia sana y compartida.'),
(5847438, 'Deivid Alexander', 'C.E', 1001346343, 'Hogar Rayito de Luna', 3443445688, 'Sibaté', 'Envejecer no es fácil y no solo por todo el deterioro físico y cognitivo que esto conlleva sino por todos los estereotipos y prejuicios que van ligados a este proceso. En el Hogar Rayito de Luna nos preocupamos porque cada arruga de nuestros adultos mayores valga la pena, porque cada cana cuente cada una de sus historias y porque todos nuestros residentes tengan un abrazo que ayude a reconfortar el alma. Nos especializamos en adulto mayor con deterioro cognitivo tipo Alzheimer, fronto temporal, vascular y pacientes en etapas terminales. Porque en Rayito de Luna “siempre hay alguien a quien abrazar”. ', ' En el Hogar Rayito de Luna nos preocupamos porque cada arruga de nuestros adultos mayores valga la pena, porque cada cana cuente cada una de sus historias y porque todos nuestros residentes tengan un abrazo que ayude a reconfortar el alma.'),
(3362514257, 'Marcos Mockus', 'C.C', 1000345678, 'Hogar geriátrico Camino al Cielo', 7894562, 'Soacha', 'Somos un Hogar de larga estancia para el cuidado del adulto mayor, con más de 11 años de experiencia en donde nos esmeramos por el bienestar de nuestros huéspedes. Nuestro equipo de trabajo esta calificado para atender las necesidades de nuestros huéspedes adultos mayores, programando actividades de integración, juegos de mesa, tardes de baile, pintura, paseos extra murales, entre otros, en donde nuestra comunidad de la tercera edad se sienta activa y motivada. Nuestras instalaciones, cuentan con espacios geriátricos seguros, zonas de descanso, relajación e integración, que garantizan calidad de vida a nuestros huéspedes adultos mayores. En el Hogar Campestre Anapoima ofrecemos calidad en el servicio del cuidado del adulto mayor, realizamos actividades de integración y celebración de fechas especiales para que todos se sientan en el calor de una familia que los cuida, los respeta y los valora. El adulto mayor es nuestra razón de ser. Contamos con un medio cómodo de transporte tanto de recreación como para traslados programados o de urgencia, garantizándole a nuestros huéspedes atención de excelencia.\r\n', 'Promovemos un espacio al cuidado del adulto mayor, teniendo como objetivos principales el bienestar y una excelente calidad de vida. Brindando servicios especializados garantizando un óptimo nivel de seguridad y confort.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `info_postulacion`
--

CREATE TABLE `info_postulacion` (
  `cod_Post` bigint(20) NOT NULL,
  `NIT` bigint(20) NOT NULL,
  `documento_Fam` bigint(10) NOT NULL,
  `documento_AM` bigint(10) NOT NULL,
  `servicios_elegidos` varchar(30) NOT NULL,
  `fecha_hora` varchar(30) NOT NULL,
  `estado` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `info_postulacion`
--

INSERT INTO `info_postulacion` (`cod_Post`, `NIT`, `documento_Fam`, `documento_AM`, `servicios_elegidos`, `fecha_hora`, `estado`) VALUES
(126806, 56780, 123470, 453781, '1014 1013 1012', 'Mon Nov 23 15:31:07 COT 2020', 'En proceso'),
(200104521, 56780, 1000123486, 342342, '1014 1013 1012', 'Fri Nov 20 23:37:39 COT 2020', 'En proceso'),
(202190186, 56780, 1001346343, 9547810, '1014 1012', 'Thu Oct 15 12:17:24 COT 2020', 'En proceso'),
(872722451, 3362514257, 1000123486, 974514, '1101 ', 'Mon Nov 30 23:09:37 COT 2020', 'En proceso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan_membresia`
--

CREATE TABLE `plan_membresia` (
  `codPlan` bigint(20) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `duracion` varchar(8) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `precio` bigint(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios_hg`
--

CREATE TABLE `servicios_hg` (
  `cod_servicio` bigint(5) NOT NULL,
  `NIT` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `tiempo` varchar(15) NOT NULL,
  `cupos` int(4) NOT NULL,
  `precio` bigint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicios_hg`
--

INSERT INTO `servicios_hg` (`cod_servicio`, `NIT`, `nombre`, `descripcion`, `tiempo`, `cupos`, `precio`) VALUES
(1012, 56780, 'Masajes', 'especialistas en dolor de espalda, relajaci�n, utilizaci�n de piedras calientes y dem�s', '1 hora', 45, 60000),
(1013, 56780, 'Juegos de mesa', 'Varias opciones como dominó, parqués, ajedrés, cartas y demás', '6 horas x dia', 78, 15000),
(1014, 56780, 'aerobicos', 'estiramientos con pesas, ritmo, entrenadores especializados y un gran ambiente', '2 horas', 120, 30000),
(1100, 3362514257, 'Mantenimiento cognitivo', 'Todas las actividades se centran en nuestra capacidad cognitiva y en la necesidad de mantenerla en el mejor estado posible.', '12 dias', 134, 50000),
(1101, 3362514257, 'Terapia ocupacional', 'Estas actividades nos dan la posibilidad de demostrar aquello que sabemos hacer, a lo que nos hemos dedicado durante nuestra vida y nos gustaría seguir haciendo. ', '7 dias', 43, 40000),
(1103, 3362514257, 'Ejercicio físico', 'Con estas actividades buscamos preservar al máximo el movimiento para tener un envejecimiento saludable. ', '2 dias', 122, 30000),
(1200, 5847438, 'Terapia Multisensorial', 'En un aula tipo Snoezelen equipada con la última tecnología de estimulación de los sentidos. A través de luces, aromas, música, sonidos y texturas, la sala multisensorial recrea una atmósfera agradable que estimula las capacidades físicas y cognitivas de las personas con deterioro cognitivo y otras demencias. .', '11 horas', 745, 60000),
(1201, 5847438, 'Salidas Ecológicas ', 'El contacto con la naturaleza enriquecer los sentidos de las personas con Alzheimer, por lo que periódicamente hacemos salidas que enriquezcan sus sentidos y su estado emocional.', '3 dias x semana', 12, 78000),
(1202, 5847438, 'Monitoreo en tiempo real ', 'A través de una aplicación especializada, los familiares de los usuarios podrán monitorear sus actividades mientras se encuentra en nuestras instalaciones.', '12 horas', 230, 134000),
(1500, 102335, 'Cuidado del adulto mayor con deterioro cognitivo', 'Nos especializamos en adulto mayor con deterioro cognitivo tipo Alzheimer, fronto temporal, vascular y pacientes en etapas terminales.', 'todo el dia', 34, 80000),
(1501, 102335, 'Colorterapia', 'Usamos la colorterapia como método de asignación de nuestras habitaciones ayudando así a la estimulación de nuestro adulto mayor.', '30 minutos', 4587, 30000),
(1502, 102335, 'Espacios al aire libre', 'También tenemos espacio para la naturaleza que con su verde intenso nos llena de energía positiva y tranquilidad.', '8 horas', 123, 26000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Cod_datos` bigint(20) NOT NULL,
  `Telefono` bigint(10) NOT NULL,
  `Direccion` varchar(40) NOT NULL,
  `Correo` varchar(40) NOT NULL,
  `Contraseña` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Cod_datos`, `Telefono`, `Direccion`, `Correo`, `Contraseña`) VALUES
(56780, 3155572985, 'carrera 74b #98-26 norte', 'puertoalegraHG@gmail.com', 'flamita12'),
(102335, 3103142530, 'Calle 127 b No 46-26', 'lilian.torres@grandpas.com.co', 'grandpa'),
(123470, 3224460935, 'Carrera 34-56', 'edu@gmail.com', 'Torres123'),
(141455, 3224460935, 'cra74b#98norte', 'admin@gmail.com', 'admin'),
(5847438, 3123124455, 'Carrera 59 A # 128 B - 23', 'la_ninocano@hotmail.com', 'rayito'),
(1000123486, 7865433267, 'Carrera 34D #4-22', 'Juangonzalez2001@gmail.com', 'Juan12345'),
(1001346343, 3224460935, 'Carrera 16D #35-29', 'deividalex002@gmail.com', 'deivid'),
(1001456993, 3132247062, 'Calle 24', 'deisyviviana@gmail.com', '1010'),
(3362514257, 3569874411, 'Calle 6 No 7 - 55', 'caminoalcielo@gmail.com', '123456789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoracion_hg`
--

CREATE TABLE `valoracion_hg` (
  `cod_valoracion` int(15) NOT NULL,
  `NIT` bigint(20) NOT NULL,
  `documento_Fam` bigint(10) NOT NULL,
  `calificacion` int(1) NOT NULL,
  `comentario` varchar(600) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `valoracion_hg`
--

INSERT INTO `valoracion_hg` (`cod_valoracion`, `NIT`, `documento_Fam`, `calificacion`, `comentario`) VALUES
(500090133, 56780, 1000123486, 0, 'El hogar geriátrico es excelente'),
(500701561, 56780, 1001346343, 0, 'Es un excelente hogar geriátrico, me encantan sus zonas verdes y juegos que ofrecen para el entretenimiento del adulto mayor ;)'),
(500724339, 102335, 1001346343, 0, 'Su falta de compromiso con la atención no fue lo que esperaba, pero sus servicios con el adulto mayor, que es l oque importa, si están bien');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`documento_Admin`),
  ADD KEY `documento_Admin` (`documento_Admin`);

--
-- Indices de la tabla `adulto_mayor`
--
ALTER TABLE `adulto_mayor`
  ADD PRIMARY KEY (`documento_AM`),
  ADD KEY `Num_documento` (`documento_AM`),
  ADD KEY `documento_Fam` (`documento_Fam`);

--
-- Indices de la tabla `compra_plan`
--
ALTER TABLE `compra_plan`
  ADD PRIMARY KEY (`cod_Compra`),
  ADD KEY `cod_Compra` (`cod_Compra`),
  ADD KEY `NIT` (`NIT`),
  ADD KEY `codPlan` (`codPlan`),
  ADD KEY `cod_Compra_2` (`cod_Compra`);

--
-- Indices de la tabla `familiar`
--
ALTER TABLE `familiar`
  ADD PRIMARY KEY (`documento_Fam`),
  ADD KEY `Numero_documento` (`documento_Fam`),
  ADD KEY `Numero_documento_2` (`documento_Fam`);

--
-- Indices de la tabla `hogar_geriatrico`
--
ALTER TABLE `hogar_geriatrico`
  ADD PRIMARY KEY (`NIT`),
  ADD KEY `NIT` (`NIT`);

--
-- Indices de la tabla `info_postulacion`
--
ALTER TABLE `info_postulacion`
  ADD PRIMARY KEY (`cod_Post`),
  ADD KEY `NIT` (`NIT`),
  ADD KEY `documento_Fam` (`documento_Fam`),
  ADD KEY `Documento_AM` (`documento_AM`);

--
-- Indices de la tabla `plan_membresia`
--
ALTER TABLE `plan_membresia`
  ADD PRIMARY KEY (`codPlan`),
  ADD KEY `codPlan` (`codPlan`);

--
-- Indices de la tabla `servicios_hg`
--
ALTER TABLE `servicios_hg`
  ADD PRIMARY KEY (`cod_servicio`),
  ADD KEY `cod_servicio` (`cod_servicio`),
  ADD KEY `NIT` (`NIT`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Cod_datos`),
  ADD KEY `Cod_datos` (`Cod_datos`),
  ADD KEY `Cod_datos_2` (`Cod_datos`);

--
-- Indices de la tabla `valoracion_hg`
--
ALTER TABLE `valoracion_hg`
  ADD PRIMARY KEY (`cod_valoracion`),
  ADD KEY `NIT` (`NIT`),
  ADD KEY `documento_Fam` (`documento_Fam`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`documento_Admin`) REFERENCES `usuario` (`Cod_datos`);

--
-- Filtros para la tabla `adulto_mayor`
--
ALTER TABLE `adulto_mayor`
  ADD CONSTRAINT `adulto_mayor_ibfk_1` FOREIGN KEY (`documento_Fam`) REFERENCES `familiar` (`documento_Fam`);

--
-- Filtros para la tabla `compra_plan`
--
ALTER TABLE `compra_plan`
  ADD CONSTRAINT `compra_plan_ibfk_1` FOREIGN KEY (`codPlan`) REFERENCES `plan_membresia` (`codPlan`),
  ADD CONSTRAINT `compra_plan_ibfk_2` FOREIGN KEY (`NIT`) REFERENCES `hogar_geriatrico` (`NIT`);

--
-- Filtros para la tabla `familiar`
--
ALTER TABLE `familiar`
  ADD CONSTRAINT `familiar_ibfk_1` FOREIGN KEY (`documento_Fam`) REFERENCES `usuario` (`Cod_datos`);

--
-- Filtros para la tabla `hogar_geriatrico`
--
ALTER TABLE `hogar_geriatrico`
  ADD CONSTRAINT `hogar_geriatrico_ibfk_1` FOREIGN KEY (`NIT`) REFERENCES `usuario` (`Cod_datos`);

--
-- Filtros para la tabla `info_postulacion`
--
ALTER TABLE `info_postulacion`
  ADD CONSTRAINT `info_postulacion_ibfk_1` FOREIGN KEY (`NIT`) REFERENCES `hogar_geriatrico` (`NIT`),
  ADD CONSTRAINT `info_postulacion_ibfk_2` FOREIGN KEY (`documento_Fam`) REFERENCES `familiar` (`documento_Fam`),
  ADD CONSTRAINT `info_postulacion_ibfk_3` FOREIGN KEY (`documento_AM`) REFERENCES `adulto_mayor` (`documento_AM`);

--
-- Filtros para la tabla `servicios_hg`
--
ALTER TABLE `servicios_hg`
  ADD CONSTRAINT `servicios_hg_ibfk_1` FOREIGN KEY (`NIT`) REFERENCES `hogar_geriatrico` (`NIT`);

--
-- Filtros para la tabla `valoracion_hg`
--
ALTER TABLE `valoracion_hg`
  ADD CONSTRAINT `valoracion_hg_ibfk_1` FOREIGN KEY (`NIT`) REFERENCES `hogar_geriatrico` (`NIT`),
  ADD CONSTRAINT `valoracion_hg_ibfk_2` FOREIGN KEY (`documento_Fam`) REFERENCES `familiar` (`documento_Fam`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
