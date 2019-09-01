package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stdtab")
public class Student {
	@Id
	@Column(name="sid")
	private int stuId;
	
	@Column(name="sname")
	private String stdname;
	
	@Column(name="add")
	private String stdaddr;
	
	@Column(name="schname")
	private String stdschname;

	public Student() {
		super();
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public String getStdaddr() {
		return stdaddr;
	}

	public void setStdaddr(String stdaddr) {
		this.stdaddr = stdaddr;
	}

	public String getStdschname() {
		return stdschname;
	}

	public void setStdschname(String stdschname) {
		this.stdschname = stdschname;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stdname=" + stdname + ", stdaddr=" + stdaddr + ", stdschname="
				+ stdschname + "]";
	}
	
	
	
	

	
}
