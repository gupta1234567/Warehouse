package com.app.service;

import java.util.List;

import com.app.model.Student;

public interface IStudentService {
	public abstract int save(Student student);
	public abstract void  update(Student student);
	public abstract void  delect(int stuId);	
	public abstract Student getStudentById(int stuId);
	public abstract List<Student> getAllStudent();
}
