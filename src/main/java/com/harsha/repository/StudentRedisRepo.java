package com.harsha.repository;

import com.harsha.config.RedisConfig;
import com.harsha.hash.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRedisRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    public static final String HASH_KEY = "Student";

    public Student saveStudent(Student student) {
        redisTemplate.opsForHash().put(HASH_KEY,student.getId(), student);
        return student;
    }

    public List<Student> getStudents(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Student getStudent(int id){
        return (Student) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public Student updateStudent(Student student, int id){
        Student existingStudent = getStudent(id);
        existingStudent.setName(student.getName());
        existingStudent.setSection(student.getSection());
        redisTemplate.opsForHash().put(HASH_KEY,id,existingStudent);
        return existingStudent;
    }

    public void deleteStudent(int id){
        redisTemplate.opsForHash().delete(HASH_KEY,id);
    }

}
