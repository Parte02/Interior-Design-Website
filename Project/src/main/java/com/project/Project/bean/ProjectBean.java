package com.project.Project.bean;

import java.util.Objects;

public class ProjectBean {
	private int id;
	private String name;
	private String location;
	private String start_date;
	private String end_date;
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	public ProjectBean(int id, String name, String location, String start_date, String end_date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.start_date = start_date;
		this.end_date = end_date;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash( end_date, id, location, name, start_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectBean other = (ProjectBean) obj;
		return Objects.equals(end_date, other.end_date)
				&& id == other.id && Objects.equals(location, other.location) && Objects.equals(name, other.name)
				&& Objects.equals(start_date, other.start_date) ;
	}
	@Override
	public String toString() {
		return "ProjectBean [id=" + id + ", name=" + name + ", location=" + location + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}
	
	
}

