BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Gradovi" (
                                         "id"	INTEGER,
                                         "broj_stanovnika"	INTEGER,
                                         "drzava"	INTEGER,
                                         "naziv"	TEXT,
                                         FOREIGN KEY("drzava") REFERENCES "Drzave"("id")
    );
CREATE TABLE IF NOT EXISTS "Drzave" (
                                        "id"	INTEGER,
                                        "glavni_grad"	INTEGER,
                                        "naziv"	TEXT,
                                        PRIMARY KEY("id")
    );
INSERT INTO "Gradovi" VALUES (1,2102650,1,'Pariz');
INSERT INTO "Gradovi" VALUES (2,8799800,2,'London');
INSERT INTO "Gradovi" VALUES (3,2002821,3,'Beč');
INSERT INTO "Gradovi" VALUES (4,549853,2,'Manchester');
INSERT INTO "Gradovi" VALUES (5,295424,3,'Graz');
INSERT INTO "Drzave" VALUES (1,1,'Francuska');
INSERT INTO "Drzave" VALUES (2,2,'UK');
INSERT INTO "Drzave" VALUES (3,3,'Austrija');
COMMIT;
