package com.example.jlgxspringbootwebapp.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jlgxspringbootwebapp.model.Student;
import com.example.jlgxspringbootwebapp.model.StudentModel;
import com.example.jlgxspringbootwebapp.repository.StudentModelRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentModelRepository studentModelRepository;

	@Override
	public void save(Student student) {
		StudentModel studentModel = new StudentModel();
		try {
			BeanUtils.copyProperties(studentModel,student);
			studentModelRepository.save(studentModel);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Student findById(Long long1) {
		Student student = new Student();
		try {
			BeanUtils.copyProperties(student,studentModelRepository.findById(long1).get());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}
