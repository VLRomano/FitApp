package logic.entity;

import java.util.List;

public class Gym {
	
	private int id;
	private String name;
	private String position;
	private List<String> trainers;
	private List<String> courses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public List<String> getTrainers() {
		return trainers;
	}
	public void setTrainers(List<String> trainers) {
		this.trainers = trainers;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
}
