package com.ericsson.demo.dao;

import com.ericsson.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("mongodb")
public class MongoDBStudentDaoImpl implements StudentDao {

    @Override
    public int insertNewStudent(UUID id, Student student) {
        return 0;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return null;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(UUID.randomUUID(), "Lukica", "Pukica", "Programiranje", 13));
        return students;
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        return 0;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        return 0;
    }
}
