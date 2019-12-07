package com.example.jlgxspringbootwebapp.service;

import com.example.jlgxspringbootwebapp.model.Student;

public interface StudentService {

	public void save(Student student);

	public Student findById(Long long1);

}
