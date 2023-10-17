package com.asifanam.cruddemo.dao;

import com.asifanam.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository  //specified annotation for repository, supports component scanning, translated JDBC exceptions
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;


    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional  //since we are performing an update
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }



    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //return query results

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String thelastName) {
        //create query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student where lastName = :theData", Student.class);

        //set Query parameters

        typedQuery.setParameter("theData", thelastName);

        //return query results

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE from Student ").executeUpdate();
    }
}
