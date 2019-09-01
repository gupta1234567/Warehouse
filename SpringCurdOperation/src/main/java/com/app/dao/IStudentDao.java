package com.app.dao;

import java.util.List;

import com.app.model.Student;

public interface IStudentDao {
	public abstract int save(Student student);
	public abstract void  update(Student student);
	public abstract void  delect(int stuId);	
	public abstract Student getStudentById(int stuId);
	public abstract List<Student> getAllStudent();

}
