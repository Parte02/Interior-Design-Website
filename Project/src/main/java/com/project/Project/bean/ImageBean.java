package com.project.Project.bean;

import java.util.Objects;

public class ImageBean {


	private int pkid;
	private String img_name;
	private int fkid;

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
	public int getPkid() {
		return pkid;
	}
	public void setPkid(int pkid) {
		this.pkid = pkid;
	}
	public ImageBean(int pkid ,String img_name, int fkid) {
		super();
		this.pkid = pkid;
		this.img_name = img_name;
		this.fkid = fkid;

	}
	@Override
	public int hashCode() {
		return Objects.hash(fkid, img_name, pkid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageBean other = (ImageBean) obj;
		return fkid == other.fkid && Objects.equals(img_name, other.img_name) && pkid == other.pkid;
	}
	@Override
	public String toString() {
		return "ImageBean [pkid=" + pkid + ", img_name=" + img_name + ", fkid=" + fkid + "]";
	}
	

}
