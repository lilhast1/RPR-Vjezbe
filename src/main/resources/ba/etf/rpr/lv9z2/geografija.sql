BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Gradovi" (
                                         "id"	INTEGER,
                                         "naziv"	TEXT,
                                         "broj_stanovnika"	INTEGER,
                                         "drzava"	INTEGER,
                                         FOREIGN KEY("drzava") REFERENCES "Drzave"("id")
    );
CREATE TABLE IF NOT EXISTS "Drzave" (
                                        "id"	INTEGER,
                                        "naziv"	TEXT,
                                        "glavni_grad"	INTEGER,
                                        PRIMARY KEY("id")
    );
INSERT INTO "Gradovi" VALUES (1,'Pariz',2102650,1);
INSERT INTO "Gradovi" VALUES (2,'London',8799800,2);
INSERT INTO "Gradovi" VALUES (3,'Beč',2002821,3);
INSERT INTO "Gradovi" VALUES (4,'Manchester',549853,2);
INSERT INTO "Gradovi" VALUES (5,'Graz',295424,3);
INSERT INTO "Drzave" VALUES (1,'Francuska',1);
INSERT INTO "Drzave" VALUES (2,'UK',2);
INSERT INTO "Drzave" VALUES (3,'Austrija',3);
COMMIT;
