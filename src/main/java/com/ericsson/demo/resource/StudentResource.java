package com.ericsson.demo.resource;

import com.ericsson.demo.model.Student;
import com.ericsson.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody Student student){
        studentService.persistNewStudent(UUID.randomUUID(), student);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public Student getStudentById(@PathVariable("id") UUID id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public int deleteStudentById(@PathVariable("id") UUID id){
        return studentService.deleteStudentById(id);
    }
    
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public int updateStudentById(@PathVariable("id") UUID id, @RequestBody Student studentToUpdate){
        return studentService.updateStudentById(id, studentToUpdate);
    }
}
