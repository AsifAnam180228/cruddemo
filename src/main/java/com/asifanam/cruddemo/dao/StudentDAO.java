package com.asifanam.cruddemo.dao;

import com.asifanam.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String thelastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();

}
