DROP TABLE IF EXISTS estimation;
CREATE TABLE estimation(task VARCHAR PRIMARY KEY,tiny INT,small INT,medium INT,large INT,xlarge INT)

INSERT INTO estimation (task ,tiny , small, medium, large, xlarge) VALUES ('ANALYZING' ,1,  2 , 4 , 8 ,16);
INSERT INTO estimation (task ,tiny, small, medium, large, xlarge) VALUES ('CODING' , 4, 8 ,20,32,48);
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge) VALUES ('UNIT_TEST' ,1,  2 , 4 , 8 ,16);


