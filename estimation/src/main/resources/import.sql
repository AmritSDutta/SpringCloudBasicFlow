DROP TABLE IF EXISTS estimation;
CREATE TABLE estimation(task VARCHAR PRIMARY KEY,tiny INT,small INT,medium INT,large INT,xlarge INT,type VARCHAR)

INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('ANALYZING' ,1,  2 , 4 , 8 ,16,'Feature');
INSERT INTO estimation (task ,tiny, small, medium, large, xlarge,type) VALUES ('CODING' , 4, 8 ,20,32,48,'Feature');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('UNIT_TEST' ,1,  2 , 4 , 8 ,16,'Feature');


