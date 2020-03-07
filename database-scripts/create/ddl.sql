CREATE TABLE PRODUCT (
	ID INT(16) NOT NULL AUTO_INCREMENT,
	PRODUCT_CODE INT(8) NOT NULL DEFAULT NULL,
	CATEGORY VARCHAR(30) DEFAULT NULL,
	NAME VARCHAR(20),
	PROD_DESC VARCHAR(100) DEFAULT NULL,
	SYS_CREATION_DATE DATE,
	PRICE DOUBLE,
    PRIMARY KEY (ID,PRODUCT_CODE)
);