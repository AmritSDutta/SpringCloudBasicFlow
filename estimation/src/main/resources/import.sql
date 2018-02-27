DROP TABLE IF EXISTS estimation;
CREATE TABLE estimation(task VARCHAR ,tiny INT,small INT,medium INT,large INT,xlarge INT,type VARCHAR)

INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Analyze         ' ,1,  2 , 4 , 8 ,16,'Feature');
INSERT INTO estimation (task ,tiny, small, medium, large, xlarge,type)  VALUES ('Coding          ' ,1,  4 ,16,  32, 48,'Feature');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Dev Test        ' ,1,  2 , 8 ,16 ,24,'Feature');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('DB Verify       ' ,1,  2 , 4 , 8 ,16,'Feature');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Git management  ' ,0,  0 , 1 , 4 , 8,'Feature');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('UI cordinate    ' ,0,  2 , 8 , 16 ,24,'Feature');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('PhysicalSite    ' ,1,  2 , 8 , 16 ,24,'Feature');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Demo            ' ,1,  2 , 4 , 4 ,  8,'Feature');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Mobile Cordinate' ,0,  2 , 8 , 16 ,24,'Feature');


INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Analyze         ' ,1,  2 , 4, 8 , 16,'BugFix');
INSERT INTO estimation (task ,tiny, small, medium, large, xlarge,type)  VALUES ('Coding          ' ,1,  2 , 4, 16, 24,'BugFix');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Dev Test        ' ,1,  2 , 2 , 8, 16,'BugFix');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('DB Verify       ' ,0,  1 , 2 , 4 ,8,'BugFix');
INSERT INTO estimation (task ,tiny, small, medium, large, xlarge,type)  VALUES ('Reproduce Issue ' ,1,  2 , 4 , 8 , 16,'BugFix');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Git management  ' ,0,  0 , 1 , 4 , 8,'BugFix');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('UI cordinate    ' ,0,  2 , 4 , 4 , 8,'BugFix');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('PhysicalSite    ' ,1,  2 , 4 , 8 ,16,'BugFix');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('DEMO            ' ,1,  1 , 2 , 4 ,  8,'BugFix');
INSERT INTO estimation (task ,tiny , small, medium, large, xlarge,type) VALUES ('Mobile Cordinate' ,1,  2 , 4 , 8 ,16,'BugFix');



