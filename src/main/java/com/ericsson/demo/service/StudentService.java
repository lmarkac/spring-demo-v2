package com.ericsson.demo.service;

import com.ericsson.demo.dao.StudentDao;
import com.ericsson.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("mongodb") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID id, Student student){
        UUID uuid = id == null ? UUID.randomUUID() : id;
        student.setId(id);
        return studentDao.insertNewStudent(uuid, student);
    }
    public Student getStudentById(UUID studentId){
        return studentDao.selectStudentById(studentId);
    }
    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }
    public int updateStudentById(UUID studentId, @RequestBody Student studentUpdate){
        return studentDao.updateStudentById(studentId, studentUpdate);
    }
    public int deleteStudentById(UUID studentId){
        Student student = studentDao.selectStudentById(studentId);

        if(student == null){
            throw new IllegalStateException();
        }else{
            return studentDao.deleteStudentById(studentId);
        }

    }

}
