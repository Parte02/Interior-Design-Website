package com.project.Project.bean;

import java.util.List;

import com.project.Project.bean.AuthBean;

public class ResponseBean {
	
		private int errId=-1;
		private String msg;
		private List<ProjectBean> projectBeans;
		private String token;
		private List<ImageBean> imageBeans;
		private List<Project_ImageBean> projectImageBeans;
		private List<ContactBean> contactBeans;
		private List<RegisterBean> registerBeans;
		private List<BookBean> bookBeans;
		private boolean admin;
		
		public boolean getAdmin() {
			return admin;
		}

		public void setAdmin(boolean b) {
			this.admin = b;
		}

		public List<ContactBean> getContactBeans() {
			return contactBeans;
		}

		public void setContactBeans(List<ContactBean> contactBeans) {
			this.contactBeans = contactBeans;
		}

		public List<RegisterBean> getRegisterBeans() {
			return registerBeans;
		}

		public void setRegisterBeans(List<RegisterBean> registerBeans) {
			this.registerBeans = registerBeans;
		}

		public List<BookBean> getBookBeans() {
			return bookBeans;
		}

		public void setBookBeans(List<BookBean> bookBeans) {
			this.bookBeans = bookBeans;
		}

		public List<Project_ImageBean> getProjectImageBeans() {
			return projectImageBeans;
		}

		public void setProjectImageBeans(List<Project_ImageBean> projectImageBeans) {
			this.projectImageBeans = projectImageBeans;
		}

		public List<ImageBean> getImageBeans() {
			return imageBeans;
		}

		public void setImageBeans(List<ImageBean> imageBeans) {
			this.imageBeans = imageBeans;
		}

		public ResponseBean() {
			// TODO Auto-generated constructor stub
		}

		public List<ProjectBean> getProjectBeans() {
			return projectBeans;
		}

		public void setProjectBeans(List<ProjectBean> projectBeans) {
			this.projectBeans = projectBeans;
		}

		public ResponseBean(String msg) {
			super();
			this.msg = msg;
		}

		public ResponseBean(int errId, String msg) {
			super();
			this.errId = errId;
			this.msg = msg;
		}

		public int getErrId() {
			return errId;
		}

		public void setErrId(int errId) {
			this.errId = errId;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}


		public String getToken() {
			return token;
		}


		public void setToken(String token) {
			this.token = token;
		}

		public void setPassword(String password) {
			// TODO Auto-generated method stub
			
		}

		

		

			}


