package com.harsha.repository;

import com.harsha.hash.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRedisDBRepo extends CrudRepository<Student, Integer> {
}
