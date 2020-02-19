package logic;

public class Query {
	private Query() {}

	private static String dropTable = "drop table if exists gym, course, trainer;";

	private static String resetTable = "drop table if exists training_session;" + 
			"drop table if exists trainer;" + 
			"drop table if exists gym;" + 
			"drop table if exists course;" + 
			"drop table if exists users;" + 
			"create table if not exists users(" + 
			"    user_id   serial  not null primary key," + 
			"    username varchar not null," + 
			"    password varchar not null," + 
			"    manager  boolean," + 
			"    unique (user_id, username));" + 
			"create table if not exists course(" + 
			"    course_id serial not null primary key," + 
			"    course_name varchar not null);" + 
			"create table if not exists gym(" + 
			"    gym_id serial not null primary key," + 
			"    gym_name varchar not null," + 
			"    street varchar not null," + 
			"    manager_id integer not null," + 
			"    manager_name varchar not null," + 
			"    foreign key (manager_id, manager_name) references users(user_id, username)," + 
			"    unique (gym_id, manager_id, manager_name)," + 
			"    unique (street));" + 
			"create table if not exists trainer(" + 
			"    trainer_id serial not null primary key," + 
			"    trainer_name varchar not null," + 
			"    gym_id int not null," + 
			"    foreign key (gym_id) references gym(gym_id)," + 
			"    unique (trainer_name, gym_id));" + 
			"create table if not exists training_session(" + 
			"    session_id serial not null primary key," + 
			"    trainer_id int not null," + 
			"    trainer_name varchar not null," + 
			"    course_id integer not null," + 
			"    individual boolean," + 
			"    gym_id integer not null," + 
			"    street varchar not null," + 
			"    time_start varchar not null," + 
			"    time_end varchar not null," + 
			"    date varchar not null," + 
			"    description varchar," + 
			"    foreign key (course_id) references course(course_id)," + 
			"    foreign key (trainer_id) references trainer(trainer_id)," + 
			"    foreign key (trainer_name,gym_id) references trainer(trainer_name, gym_id)," + 
			"    foreign key (street) references gym(street)," + 
			"    unique (trainer_id, course_id, time_start, time_end, date));";

	private static String fillTable = "insert into users(username, password, manager) values ('admin', 'admin', 'false');" + 
			"insert into users(username, password, manager) values ('manager', 'manager', 'true');" + 
			"insert into users(username, password, manager) values ('effi', 'pass', 'false');" + 
			"insert into users(username, password, manager) values ('gym', 'gympass', 'true');" + 
			"insert into course(course_name) values ('c1');" + 
			"insert into course(course_name) values ('c2');" + 
			"insert into course(course_name) values ('c3');" + 
			"insert into course(course_name) values ('c4');" + 
			"insert into course(course_name) values ('c5');" + 
			"insert into gym(gym_name, street, manager_id, manager_name) values ('gym1','street1',2,'manager');" + 
			"insert into gym(gym_name, street, manager_id, manager_name) values ('gym2','street2',4,'gym');" + 
			"insert into trainer(trainer_name, gym_id) values('t1', 1);" + 
			"insert into trainer(trainer_name, gym_id) values('t2', 2);" + 
			"insert into trainer(trainer_name, gym_id) values('t3', 2);" + 
			"insert into trainer(trainer_name, gym_id) values('t4', 1);" + 
			"insert into training_session(trainer_id, trainer_name, course_id, individual, gym_id, street, time_start, time_end, date, description) values (1,'t1',1, true, 1, 'street1', '10.00', '11.00', '1.1.2020', 'session_1');" + 
			"insert into training_session(trainer_id, trainer_name, course_id, individual, gym_id, street, time_start, time_end, date, description) values (2,'t1',2, false, 1, 'street1', '12.00', '13.00', '2.2.2020', 'session_2');" + 
			"insert into training_session(trainer_id, trainer_name, course_id, individual, gym_id, street, time_start, time_end, date, description) values (4,'t3',3, true, 2, 'street2', '10.30', '11.30', '3.3.2020','session_3');";
	private static String courseList = "select course_id, course_name from course";
	private static String login =
			"select user_id from users where username = ? and password = ?;";
	private static String trainerList = "select trainer_id, trainer_name from trainer where gym_id = ?;";
	public static String getTrainerList() {
		return trainerList;
	}
	public static String getCourseList() {
		return courseList;
	}
	public static String getLogin() {
		return login;
	}

	public static String getDropTable() {
		return dropTable;
	}

	public static String getResetTable() {
		return resetTable;
	}

	public static String getFillTable() {
		return fillTable;
	}

}