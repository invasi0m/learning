--
-- H2 port of the PostgreSQL port of the MySQL "World" database.
--
-- The sample data used in the world database is Copyright Statistics
-- Finland, http://www.stat.fi/worldinfigures.
--

CREATE TABLE IF NOT EXISTS city (
    id int NOT NULL,
    name varchar(100) NOT NULL,
    countrycode varchar(3) NOT NULL,
    district varchar(100) NOT NULL,
    population int NOT NULL
);



INSERT INTO city VALUES (1, 'Kabul', 'AFG', 'Kabol', 1780000);
INSERT INTO city VALUES (2, 'Qandahar', 'AFG', 'Qandahar', 237500);
INSERT INTO city VALUES (3, 'Herat', 'AFG', 'Herat', 186800);
INSERT INTO city VALUES (4, 'Mazar-e-Sharif', 'AFG', 'Balkh', 127800);
INSERT INTO city VALUES (5, 'Amsterdam', 'NLD', 'Noord-Holland', 731200);
INSERT INTO city VALUES (6, 'Rotterdam', 'NLD', 'Zuid-Holland', 593321);
INSERT INTO city VALUES (7, 'Haag', 'NLD', 'Zuid-Holland', 440900);
INSERT INTO city VALUES (8, 'Utrecht', 'NLD', 'Utrecht', 234323);
INSERT INTO city VALUES (9, 'Eindhoven', 'NLD', 'Noord-Brabant', 201843);
INSERT INTO city VALUES (10, 'Tilburg', 'NLD', 'Noord-Brabant', 193238);
INSERT INTO city VALUES (11, 'Groningen', 'NLD', 'Groningen', 172701);
INSERT INTO city VALUES (12, 'Breda', 'NLD', 'Noord-Brabant', 160398);
INSERT INTO city VALUES (13, 'Apeldoorn', 'NLD', 'Gelderland', 153491);
INSERT INTO city VALUES (14, 'Nijmegen', 'NLD', 'Gelderland', 152463);
INSERT INTO city VALUES (15, 'Enschede', 'NLD', 'Overijssel', 149544);
INSERT INTO city VALUES (16, 'Haarlem', 'NLD', 'Noord-Holland', 148772);
INSERT INTO city VALUES (17, 'Almere', 'NLD', 'Flevoland', 142465);
INSERT INTO city VALUES (18, 'Arnhem', 'NLD', 'Gelderland', 138020);
INSERT INTO city VALUES (19, 'Zaanstad', 'NLD', 'Noord-Holland', 135621);
INSERT INTO city VALUES (20, '´s-Hertogenbosch', 'NLD', 'Noord-Brabant', 129170);
INSERT INTO city VALUES (21, 'Amersfoort', 'NLD', 'Utrecht', 126270);
INSERT INTO city VALUES (22, 'Maastricht', 'NLD', 'Limburg', 122087);
INSERT INTO city VALUES (23, 'Dordrecht', 'NLD', 'Zuid-Holland', 119811);
INSERT INTO city VALUES (24, 'Leiden', 'NLD', 'Zuid-Holland', 117196);
INSERT INTO city VALUES (25, 'Haarlemmermeer', 'NLD', 'Noord-Holland', 110722);
INSERT INTO city VALUES (26, 'Zoetermeer', 'NLD', 'Zuid-Holland', 110214);
INSERT INTO city VALUES (27, 'Emmen', 'NLD', 'Drenthe', 105853);
INSERT INTO city VALUES (28, 'Zwolle', 'NLD', 'Overijssel', 105819);
INSERT INTO city VALUES (29, 'Ede', 'NLD', 'Gelderland', 101574);
INSERT INTO city VALUES (30, 'Delft', 'NLD', 'Zuid-Holland', 95268);
INSERT INTO city VALUES (31, 'Heerlen', 'NLD', 'Limburg', 95052);
INSERT INTO city VALUES (32, 'Alkmaar', 'NLD', 'Noord-Holland', 92713);
INSERT INTO city VALUES (33, 'Willemstad', 'ANT', 'Curaçao', 2345);
INSERT INTO city VALUES (34, 'Tirana', 'ALB', 'Tirana', 270000);
INSERT INTO city VALUES (35, 'Alger', 'DZA', 'Alger', 2168000);
INSERT INTO city VALUES (36, 'Oran', 'DZA', 'Oran', 609823);
INSERT INTO city VALUES (37, 'Constantine', 'DZA', 'Constantine', 443727);
INSERT INTO city VALUES (38, 'Annaba', 'DZA', 'Annaba', 222518);
INSERT INTO city VALUES (39, 'Batna', 'DZA', 'Batna', 183377);
INSERT INTO city VALUES (40, 'Sétif', 'DZA', 'Sétif', 179055);
INSERT INTO city VALUES (41, 'Sidi Bel Abbès', 'DZA', 'Sidi Bel Abbès', 153106);
INSERT INTO city VALUES (42, 'Skikda', 'DZA', 'Skikda', 128747);
INSERT INTO city VALUES (43, 'Biskra', 'DZA', 'Biskra', 128281);
INSERT INTO city VALUES (44, 'Blida (el-Boulaida)', 'DZA', 'Blida', 127284);
INSERT INTO city VALUES (45, 'Béjaïa', 'DZA', 'Béjaïa', 117162);
INSERT INTO city VALUES (46, 'Mostaganem', 'DZA', 'Mostaganem', 115212);
INSERT INTO city VALUES (47, 'Tébessa', 'DZA', 'Tébessa', 112007);
INSERT INTO city VALUES (48, 'Tlemcen (Tilimsen)', 'DZA', 'Tlemcen', 110242);
INSERT INTO city VALUES (49, 'Béchar', 'DZA', 'Béchar', 107311);
INSERT INTO city VALUES (50, 'Tiaret', 'DZA', 'Tiaret', 100118);
INSERT INTO city VALUES (51, 'Ech-Chleff (el-Asnam)', 'DZA', 'Chlef', 96794);
INSERT INTO city VALUES (52, 'Ghardaïa', 'DZA', 'Ghardaïa', 89415);
INSERT INTO city VALUES (53, 'Tafuna', 'ASM', 'Tutuila', 5200);
INSERT INTO city VALUES (54, 'Fagatogo', 'ASM', 'Tutuila', 2323);
INSERT INTO city VALUES (55, 'Andorra la Vella', 'AND', 'Andorra la Vella', 21189);
INSERT INTO city VALUES (56, 'Luanda', 'AGO', 'Luanda', 2022000);
INSERT INTO city VALUES (57, 'Huambo', 'AGO', 'Huambo', 163100);
INSERT INTO city VALUES (58, 'Lobito', 'AGO', 'Benguela', 130000);
INSERT INTO city VALUES (59, 'Benguela', 'AGO', 'Benguela', 128300);
INSERT INTO city VALUES (60, 'Namibe', 'AGO', 'Namibe', 118200);
INSERT INTO city VALUES (61, 'South Hill', 'AIA', '', 961);
INSERT INTO city VALUES (62, 'The Valley', 'AIA', '', 595);
INSERT INTO city VALUES (63, 'Saint John´s', 'ATG', 'St John', 24000);
INSERT INTO city VALUES (64, 'Dubai', 'ARE', 'Dubai', 669181);
INSERT INTO city VALUES (65, 'Abu Dhabi', 'ARE', 'Abu Dhabi', 398695);
INSERT INTO city VALUES (66, 'Sharja', 'ARE', 'Sharja', 320095);
INSERT INTO city VALUES (67, 'al-Ayn', 'ARE', 'Abu Dhabi', 225970);
INSERT INTO city VALUES (68, 'Ajman', 'ARE', 'Ajman', 114395);
INSERT INTO city VALUES (69, 'Buenos Aires', 'ARG', 'Distrito Federal', 2982146);
INSERT INTO city VALUES (70, 'La Matanza', 'ARG', 'Buenos Aires', 1266461);
INSERT INTO city VALUES (71, 'Córdoba', 'ARG', 'Córdoba', 1157507);
INSERT INTO city VALUES (72, 'Rosario', 'ARG', 'Santa Fé', 907718);
INSERT INTO city VALUES (73, 'Lomas de Zamora', 'ARG', 'Buenos Aires', 622013);
INSERT INTO city VALUES (74, 'Quilmes', 'ARG', 'Buenos Aires', 559249);
INSERT INTO city VALUES (75, 'Almirante Brown', 'ARG', 'Buenos Aires', 538918);
INSERT INTO city VALUES (76, 'La Plata', 'ARG', 'Buenos Aires', 521936);
INSERT INTO city VALUES (77, 'Mar del Plata', 'ARG', 'Buenos Aires', 512880);
INSERT INTO city VALUES (78, 'San Miguel de Tucumán', 'ARG', 'Tucumán', 470809);
INSERT INTO city VALUES (79, 'Lanús', 'ARG', 'Buenos Aires', 469735);
INSERT INTO city VALUES (80, 'Merlo', 'ARG', 'Buenos Aires', 463846);
INSERT INTO city VALUES (81, 'General San Martín', 'ARG', 'Buenos Aires', 422542);
INSERT INTO city VALUES (82, 'Salta', 'ARG', 'Salta', 367550);
INSERT INTO city VALUES (83, 'Moreno', 'ARG', 'Buenos Aires', 356993);
INSERT INTO city VALUES (84, 'Santa Fé', 'ARG', 'Santa Fé', 353063);
INSERT INTO city VALUES (85, 'Avellaneda', 'ARG', 'Buenos Aires', 353046);
INSERT INTO city VALUES (86, 'Tres de Febrero', 'ARG', 'Buenos Aires', 352311);
INSERT INTO city VALUES (87, 'Morón', 'ARG', 'Buenos Aires', 349246);
INSERT INTO city VALUES (88, 'Florencio Varela', 'ARG', 'Buenos Aires', 315432);
INSERT INTO city VALUES (89, 'San Isidro', 'ARG', 'Buenos Aires', 306341);
INSERT INTO city VALUES (90, 'Tigre', 'ARG', 'Buenos Aires', 296226);
INSERT INTO city VALUES (91, 'Malvinas Argentinas', 'ARG', 'Buenos Aires', 290335);
INSERT INTO city VALUES (92, 'Vicente López', 'ARG', 'Buenos Aires', 288341);
INSERT INTO city VALUES (93, 'Berazategui', 'ARG', 'Buenos Aires', 276916);
INSERT INTO city VALUES (94, 'Corrientes', 'ARG', 'Corrientes', 258103);
INSERT INTO city VALUES (95, 'San Miguel', 'ARG', 'Buenos Aires', 248700);
INSERT INTO city VALUES (96, 'Bahía Blanca', 'ARG', 'Buenos Aires', 239810);
INSERT INTO city VALUES (97, 'Esteban Echeverría', 'ARG', 'Buenos Aires', 235760);
INSERT INTO city VALUES (98, 'Resistencia', 'ARG', 'Chaco', 229212);
INSERT INTO city VALUES (99, 'José C. Paz', 'ARG', 'Buenos Aires', 221754);
INSERT INTO city VALUES (100, 'Paraná', 'ARG', 'Entre Rios', 207041);
