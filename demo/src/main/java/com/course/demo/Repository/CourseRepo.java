package com.course.demo.Repository;

import com.course.demo.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepo extends JpaRepository<Course,String> {

}
