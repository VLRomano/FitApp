package logic;

public class Query {
	private Query() {}
	
	private static String dropTable = "drop table if exists gym, course, trainer;";

	private static String createTable = 
			"create table if not exists trainer("
			+ "trainerID serial not null primary key,"
			+ "trainerName varchar not null,"
			+ "schedule varchar not null);"

			+ "create table if not exists course(" + 
			"	courseID serial not null primary key," + 
			"    courseName varchar not null," + 
			"    trainerID int not null," + 
			"    foreign key (trainerID) references trainer(trainerID)," + 
			"    info varchar not null," + 
			"    unique (courseID,trainerID));"
			
			+ "create table if not exists gym(" + 
			"    gymID serial not null primary key," + 
			"    gymName varchar not null," + 
			"    position varchar not null," + 
			"    trainerID int not null," + 
			"    courseID int not null," + 
			"    foreign key (courseID, trainerID) references course(courseID,trainerID)," + 
			"    unique (gymID,courseID, trainerID));";
	
	private static String fillTable = 
 
			"insert into trainer (trainername, schedule) values ('t1','10.00');" + 
			"insert into trainer (trainername, schedule) values ('t1','15.00');" + 
			"insert into trainer (trainername, schedule) values ('t2','11.00');" + 
			"insert into trainer (trainername, schedule) values ('t3','10.30');" + 
 
			"insert into course (coursename, trainerid, info) values ('c1',1,'info1');" + 
			"insert into course (coursename, trainerid, info) values ('c2',1,'info2');" + 
			"insert into course (coursename, trainerid, info) values ('c3',2,'info3');" + 
			"insert into course (coursename, trainerid, info) values ('c4',3,'info4');" + 
  
			"insert into gym (gymname, position, trainerid, courseid) values ('g1','p1',1,1);" + 
			"insert into gym (gymname, position, trainerid, courseid) values ('g1','p1',1,2);" + 
			"insert into gym (gymname, position, trainerid, courseid) values ('g2','p2',2,3);" + 
			"insert into gym (gymname, position, trainerid, courseid) values ('g3','p3',3,4);";
			/* ALERT: insert like this gives error, as expected */ 
			/*insert into gym (gymname, position, trainerid, courseid) values ('g1','p1',1,3);*/

	private static String selectItem =
			"select id from users where name = 'admin' and password = 'admin';";	
	
	public static String getSelectItem() {
		return selectItem;
	}
	
	public static String getDropTable() {
		return dropTable;
	}

	public static String getCreateTable() {
		return createTable;
	}

	public static String getFillTable() {
		return fillTable;
	}
	
}