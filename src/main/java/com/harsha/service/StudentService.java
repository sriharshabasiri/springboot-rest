package com.harsha.service;

import com.harsha.hash.Student;
import com.harsha.repository.StudentRedisDBRepo;
import com.harsha.repository.StudentRedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {

    @Autowired
    private StudentRedisRepo studentRedisRepo;

    @Autowired
    private StudentRedisDBRepo studentRedisDBRepo;

    public Student saveStudent(Student student) {
        return studentRedisDBRepo.save(student);
        //return studentRedisRepo.saveStudent(student);
        }

    public List<Student> getStudents(){
        return StreamSupport.stream(studentRedisDBRepo.findAll().spliterator(),false).collect(Collectors.toList());
        //return studentRedisRepo.getStudents();
    }

    public Student getStudent(int id){
        return studentRedisDBRepo.findById(id).get();
        //return studentRedisRepo.getStudent(id);
    }

    public Student updateStudent(Student student, int id){
        Student existingStudent = studentRedisDBRepo.findById(id).get();
        existingStudent.setName(student.getName());
        existingStudent.setSection(student.getSection());
        existingStudent.setId(id);
        return studentRedisDBRepo.save(existingStudent);
        //return studentRedisRepo.updateStudent(student, id);
    }

    public void deleteStudent(int id){
        studentRedisDBRepo.deleteById(id);
        //studentRedisRepo.deleteStudent(id);
    }

}
