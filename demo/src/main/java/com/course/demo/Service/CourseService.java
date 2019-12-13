package com.course.demo.Service;

import com.course.demo.Models.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findAllCourses();
    void saveOrUpdate(Course course);
    Course findById(String courseCode);
    void deleteById(String courseCode);
}
