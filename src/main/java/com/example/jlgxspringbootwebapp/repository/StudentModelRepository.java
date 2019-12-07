package com.example.jlgxspringbootwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jlgxspringbootwebapp.model.StudentModel;

@Repository
public interface StudentModelRepository extends JpaRepository<StudentModel, Long> {

}
