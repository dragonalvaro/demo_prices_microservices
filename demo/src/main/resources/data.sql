DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  BRAND_ID INT(20) NOT NULL,
  PRICE DECIMAL (10000,2) NOT NULL,  	
  PRICE_LIST INT(20) NOT NULL,  	
  PRIORITY INT(20) NOT NULL,  	
  PRODUCT_ID INT(20) NOT NULL,  	
  START_DATE DATETIME,
  END_DATE DATETIME  
);

INSERT INTO prices (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE) VALUES
  (1, parsedatetime('2020-06-14-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 1, 35455,0,35.50),
  (1, parsedatetime('2020-06-14-15.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-06-14-18.30.00', 'yyyy-MM-dd-hh.mm.ss'), 2, 35455,1,25.45),
  (1, parsedatetime('2020-06-15-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-06-15-11.00.00', 'yyyy-MM-dd-hh.mm.ss'), 3, 35455,1,30.50),
  (1, parsedatetime('2020-06-16-16.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 4, 35455,1,38.95);
