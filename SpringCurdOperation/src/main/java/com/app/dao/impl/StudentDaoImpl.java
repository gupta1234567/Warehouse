package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IStudentDao;
import com.app.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int save(Student student) {
		return (Integer) ht.save(student);
	}

	@Override
	public void update(Student student) {
		  ht.update(student);

	}

	@Override
	public void delect(int stuId) {
		Student student=new Student();
		student.setStuId(stuId);
       ht.delete(student);
	}

	@Override
	public Student getStudentById(int stuId) {
		Student student=ht.get(Student.class, stuId);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> student=ht.loadAll(Student.class);
		return student;
	}
}
