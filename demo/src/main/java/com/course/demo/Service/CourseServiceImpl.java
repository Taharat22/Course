package com.course.demo.Service;

import com.course.demo.Models.Course;
import com.course.demo.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<Course> findAllCourses() {

        return courseRepo.findAll();
    }

    @Override
    public void saveOrUpdate(Course course) {
         courseRepo.save(course);
    }

    @Override
    public Course findById(String courseCode) {
        return courseRepo.getOne(courseCode);
    }

    @Override
    public void deleteById(String courseCode) {
     courseRepo.deleteById(courseCode);
    }
}
