INSERT INTO MEASUREMENT_SYSTEM(SYS_ID, NAME) VALUES(1, 'metric');
INSERT INTO MEASUREMENT_SYSTEM(SYS_ID, NAME) VALUES(2, 'imperial');
INSERT INTO MEASUREMENT_SYSTEM(SYS_ID, NAME) VALUES(3, 'none');

INSERT INTO UNITS_OF_MEASURE(UOM_ID, NAME, SYS_ID) VALUES(1, 'litr', 1);
INSERT INTO UNITS_OF_MEASURE(UOM_ID, NAME, SYS_ID) VALUES(2, 'mililitr', 1);
INSERT INTO UNITS_OF_MEASURE(UOM_ID, NAME, SYS_ID) VALUES(3, 'kilogram', 1);
INSERT INTO UNITS_OF_MEASURE(UOM_ID, NAME, SYS_ID) VALUES(4, 'dekagram', 1);
INSERT INTO UNITS_OF_MEASURE(UOM_ID, NAME, SYS_ID) VALUES(5, 'gram', 1);
INSERT INTO UNITS_OF_MEASURE(UOM_ID, NAME, SYS_ID) VALUES(6, 'sztuka', 3);
INSERT INTO UNITS_OF_MEASURE(UOM_ID, NAME, SYS_ID) VALUES(7, 'peczek', 3);

INSERT INTO INGREDIENTS(ING_ID, NAME, UOM_ID) VALUES(100, 'kurczak', 6);
INSERT INTO INGREDIENTS(ING_ID, NAME, UOM_ID) VALUES(101, 'chleb', 6);
INSERT INTO INGREDIENTS(ING_ID, NAME, UOM_ID) VALUES(102, 'mleko', 1);

