--------------------------------------------------------
--  File created - Wednesday-October-10-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PLACE
--------------------------------------------------------

  CREATE TABLE "TOUR"."PLACE" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE), 
	"DAYS" NUMBER, 
	"PRICE" NUMBER, 
	"TRANSPORT" VARCHAR2(20 BYTE), 
	"PHOTO" BLOB, 
	"INFO" VARCHAR2(1000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("PHOTO") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table PLACETHEME
--------------------------------------------------------

  CREATE TABLE "TOUR"."PLACETHEME" 
   (	"ID" NUMBER, 
	"PLACEID" NUMBER, 
	"THEMEID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table THEME
--------------------------------------------------------

  CREATE TABLE "TOUR"."THEME" 
   (	"ID" NUMBER, 
	"THEME" VARCHAR2(20 BYTE), 
	"PHOTO" BLOB
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("PHOTO") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "TOUR"."USERS" 
   (	"ID" NUMBER, 
	"USERNAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"MOBILE" NUMBER, 
	"EMAIL" VARCHAR2(20 BYTE), 
	"ROLE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence USER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "TOUR"."USER_SEQ"  MINVALUE 2 MAXVALUE 9999999 INCREMENT BY 1 START WITH 62 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into TOUR.PLACE
SET DEFINE OFF;
Insert into TOUR.PLACE (ID,NAME,DAYS,PRICE,TRANSPORT,INFO) values (1,'MUNNAR',5,24000,'YES','Munnar is a town in the Western Ghats mountain range in Indiaâ€™s Kerala state. A hill station and former resort for the British Raj elite, 
it''s surrounded by rolling hills dotted with tea plantations established in the late 19th century. Eravikulam National Park,
 a habitat for the endangered mountain goat Nilgiri tahr, is home to the Lakkam Waterfalls, hiking trails and 2,695m-tall Anamudi Peak.
 
 
  Kolukkumalai Tea Estates
   Anamudi Peak
   Eravikulam National Park
    Mattupetty Dam & Lake
	Top Station
 link-http://www.munnar.com/tourist.htm#Tourist');
Insert into TOUR.PLACE (ID,NAME,DAYS,PRICE,TRANSPORT,INFO) values (2,'MANALI',6,17000,'NO','Manali is a high-altitude Himalayan resort town in Indiaâ€™s northern Himachal Pradesh state. 
It has a reputation as a backpacking center and honeymoon destination. Set on the Beas River, 
itâ€™s a gateway for skiing in the Solang Valley and trekking in Parvati Valley. It''s also a jumping-off point for paragliding,
 rafting and mountaineering in the Pir Panjal mountains, home to 4,000m-high Rohtang Pass.
 
 Kullu
 Rohtang Pass 
 Solang Valley
 Hidimba Temple
 Basheshwar Mahadev Temple
 Naggar
 Nehru Kund
 Sultanpur Palace
 Beas River
 Manikaran 
 Vashisht
 link-http://www.himachaltourist.com/manali/');
Insert into TOUR.PLACE (ID,NAME,DAYS,PRICE,TRANSPORT,INFO) values (3,'JAIPUR',6,16000,'YES','Jaipur is the capital of India’s Rajasthan state. It evokes the royal family that once ruled the region and that, in 1727, 
founded what is now called the Old City, or “Pink City” for its trademark building color. 
At the center of its stately street grid (notable in India) stands the opulent, colonnaded City Palace complex. 
With gardens, courtyards and museums, part of it is still a royal residence.



Amber Fort and Jaigarh Fort
 Hawa Mahal
 
  Jantar Mantar 
  
  Albert Hall and City Palace
  
   Nahargarh Fort
   Birla Mandir or Laxmi Narayan Mandir
   
   Govind Devji Temple
   
   Raj Mandir 
   Chokhi Dhani
    Birla Planetarium

link-http://tourism.rajasthan.gov.in/jaipur');
Insert into TOUR.PLACE (ID,NAME,DAYS,PRICE,TRANSPORT,INFO) values (4,'RAJASTHAN',5,15000,'NO','Rajasthan is a northern Indian state bordering Pakistan. Its palaces and forts are reminders of the many kingdoms 
that historically vied for the region. In its capital, Jaipur (the "Pink City"), are the 18th-century City Palace and Hawa Mahal,
 a former cloister for royal women, fronted by a 5-story pink-sandstone screen. 
Amer Fort, atop a nearby hill, was built by a Rajput prince in the early 1600s.

Jaipur
Udaipur

Jodhpur

 Jaisalmer
 Bikaner
 
 Pushkar
 Sawai Madhopur
  Chittorgarh
  Mount Abu
  Alwar
link-http://tourism.rajasthan.gov.in/');
Insert into TOUR.PLACE (ID,NAME,DAYS,PRICE,TRANSPORT,INFO) values (5,'GOA',4,12000,'YES','Goa is a state in western India with coastlines stretching along the Arabian Sea.
 Its long history as a Portuguese colony prior to 1961 is evident in its preserved 17th-century
 churches and the areaâ€™s tropical spice plantations. Goa is also known for its beaches, ranging from popular stretches 
at Baga and Palolem to those in laid-back fishing villages such as Agonda.



Calangute
FortAguada
ChaporaFort
Pandava Caves and Arvalem Waterfall
Dudhsagar falls
Ashwem & Arossim Beach

Mollem National Park


link-http://goa-tourism.com/');
Insert into TOUR.PLACE (ID,NAME,DAYS,PRICE,TRANSPORT,INFO) values (6,'KANYAKUMARI',6,18000,'YES','Kanyakumari is a coastal town in the state of Tamil Nadu on India''s southern tip. Jutting into the Laccadive Sea,
 the town was known as Cape Comorin during British rule and is popular for watching sunrise and sunset over the ocean. 
 It''s also a noted pilgrimage site thanks to its Bagavathi Amman Temple, dedicated to a consort of Shiva, 
and its Our Lady of Ransom Church, a center of Indian Catholicism.



Vivekananda Rock Memorial
Kanyakumari Beach
Thiruvalluvar Statue
Kumari Amman Temple
Thanumalayan Temple
Padmanabhapuram Palace
Gandhi Mandapam
Thirparappu Falls
Courtallam Falls
Chitharal Jain Monuments
Vattakottai Fort
Lord Subramanya Temple
Sanguthurai Beach
Wax Museum
link-http://www.kanyakumari.tn.nic.in/tourist.html');
Insert into TOUR.PLACE (ID,NAME,DAYS,PRICE,TRANSPORT,INFO) values (7,'MYSORE',5,15000,'NO','Mysore (or Mysuru), a city in India''s southwestern Karnataka state, was the capital of the Kingdom of Mysore from 1399 to 1947. 
In its center is opulent Mysore Palace, seat of the former ruling Wodeyar dynasty. The palace blends Hindu, Islamic, Gothic and Rajput styles. 
Mysore is also home to the centuries-old Devaraja Market, filled with spices, silk and sandalwood.

Mysore Palace. 
Chamundi Hills. ...
Mysore Zoo. ...
Karanji Lake. ...
St Philomena''s Church. ...
Lalitha Mahal. ...
GRS Fantasy Park. ...
Railway Museum.

link-http://www.mysoretourism.org.in/');
REM INSERTING into TOUR.PLACETHEME
SET DEFINE OFF;
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (1,1,1);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (2,1,2);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (3,2,2);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (4,1,3);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (5,2,6);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (6,1,6);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (7,2,7);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (8,2,8);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (9,2,4);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (10,3,1);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (11,3,3);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (12,3,6);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (13,3,9);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (14,4,4);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (15,4,9);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (16,4,1);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (17,5,5);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (18,5,6);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (19,5,4);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (20,6,3);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (21,6,2);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (22,6,5);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (23,6,10);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (24,6,6);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (25,7,3);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (26,7,10);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (27,7,6);
Insert into TOUR.PLACETHEME (ID,PLACEID,THEMEID) values (28,7,2);
REM INSERTING into TOUR.THEME
SET DEFINE OFF;
Insert into TOUR.THEME (ID,THEME) values (1,'WILDLIFE');
Insert into TOUR.THEME (ID,THEME) values (2,'HILLSTATION');
Insert into TOUR.THEME (ID,THEME) values (3,'FAMILY');
Insert into TOUR.THEME (ID,THEME) values (4,'ADVENTURE');
Insert into TOUR.THEME (ID,THEME) values (5,'BEACH');
Insert into TOUR.THEME (ID,THEME) values (6,'SIGHTSEEING');
Insert into TOUR.THEME (ID,THEME) values (7,'MOUNTAIN CLIMBING');
Insert into TOUR.THEME (ID,THEME) values (8,'RIVER RAFTING');
Insert into TOUR.THEME (ID,THEME) values (9,'FORT PLACES');
Insert into TOUR.THEME (ID,THEME) values (10,'PARAGLIDING');
REM INSERTING into TOUR.USERS
SET DEFINE OFF;
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (1,'vishal','vishal',1234567899,'abc','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (2,'abc','bcaS',445656,'abc','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (3,'bca','bca',46451658,'bca','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (4,'wer','wer',2345,'wer','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (5,'vamsi','vamsi',2537868,'vamsi@bml.edu','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (6,'tej','1234567',1234567899,'t@g.com','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (8,'werr','1234567',1234567891,'t@g.in','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (9,'venu','1234567',1234567893,'venu@gmail.com','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (22,'arun','1234567',9632145874,'arun@g.com','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (42,'vijay','vijay123',2314567899,'vijay@gmail.com','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (43,'prakash','prakash',1234567899,'prak@gmail.com','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (44,'rohan','rohan123',9849144891,'rohan@gmail.com','ADMIN');
Insert into TOUR.USERS (ID,USERNAME,PASSWORD,MOBILE,EMAIL,ROLE) values (45,'Teja','teja1234',1234567899,'teja@gmail.com','ADMIN');
--------------------------------------------------------
--  DDL for Index THEME_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TOUR"."THEME_PK" ON "TOUR"."THEME" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TOUR"."USERS_PK" ON "TOUR"."USERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index USERS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "TOUR"."USERS_UK1" ON "TOUR"."USERS" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PLACETHEME_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TOUR"."PLACETHEME_PK" ON "TOUR"."PLACETHEME" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PLACE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TOUR"."PLACE_PK" ON "TOUR"."PLACE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger USER_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TOUR"."USER_TRIG" BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
    <<COLUMN_SEQUENCES>>
  BEGIN
  IF :NEW.ID IS NULL THEN
    SELECT USER_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
    END IF;
    END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TOUR"."USER_TRIG" ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "TOUR"."USERS" ADD CONSTRAINT "USERS_UK1" UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "TOUR"."USERS" MODIFY ("ROLE" NOT NULL ENABLE);
  ALTER TABLE "TOUR"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "TOUR"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "TOUR"."USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "TOUR"."USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PLACE
--------------------------------------------------------

  ALTER TABLE "TOUR"."PLACE" ADD CONSTRAINT "PLACE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "TOUR"."PLACE" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "TOUR"."PLACE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PLACETHEME
--------------------------------------------------------

  ALTER TABLE "TOUR"."PLACETHEME" ADD CONSTRAINT "PLACETHEME_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "TOUR"."PLACETHEME" MODIFY ("THEMEID" NOT NULL ENABLE);
  ALTER TABLE "TOUR"."PLACETHEME" MODIFY ("PLACEID" NOT NULL ENABLE);
  ALTER TABLE "TOUR"."PLACETHEME" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table THEME
--------------------------------------------------------

  ALTER TABLE "TOUR"."THEME" ADD CONSTRAINT "THEME_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "TOUR"."THEME" MODIFY ("THEME" NOT NULL ENABLE);
  ALTER TABLE "TOUR"."THEME" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table PLACETHEME
--------------------------------------------------------

  ALTER TABLE "TOUR"."PLACETHEME" ADD CONSTRAINT "PLACETHEME_FK1" FOREIGN KEY ("PLACEID")
	  REFERENCES "TOUR"."PLACE" ("ID") ENABLE;
  ALTER TABLE "TOUR"."PLACETHEME" ADD CONSTRAINT "PLACETHEME_FK2" FOREIGN KEY ("THEMEID")
	  REFERENCES "TOUR"."THEME" ("ID") ENABLE;
