package com.project.Project.bean;

import java.util.Objects;

public class Project_ImageBean {

	private int id;
	private String name;
	private String location;
	private String start_date;
	private String end_date;
	private int pkid;
	private String img_name;
	private int fkid;
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
	
	public int getPkid() {
		return pkid;
	}
	public void setPkid(int pkid) {
		this.pkid = pkid;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public int getFkid() {
		return fkid;
	}
	public void setFkid(int fkid) {
		this.fkid = fkid;
	}
	public Project_ImageBean(int id, String name, String location, String start_date, String end_date,
			int pkid, String img_name, int fkid) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.start_date = start_date;
		this.end_date = end_date;
		this.pkid = pkid;
		this.img_name = img_name;
		this.fkid = fkid;
	}
	@Override
	public int hashCode() {
		return Objects.hash( end_date, fkid, id, img_name, location, name, pkid, start_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project_ImageBean other = (Project_ImageBean) obj;
		return  Objects.equals(end_date, other.end_date)
				&& fkid == other.fkid && id == other.id && Objects.equals(img_name, other.img_name)
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name) && pkid == other.pkid
				&& Objects.equals(start_date, other.start_date);
	}
	@Override
	public String toString() {
		return "Project_ImageBean [id=" + id + ", name=" + name + ", location=" + location + ", start_date="
				+ start_date + ", end_date=" + end_date + ", pkid=" + pkid + ", img_name=" + img_name + ", fkid=" + fkid + "]";
	}
	

}
