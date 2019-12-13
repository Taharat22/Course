package com.course.demo.Controller;

import com.course.demo.Models.Course;
import com.course.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(value="/course")
@Controller

public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value ="/Home",method = RequestMethod.GET)
    public ModelAndView view(){
        ModelAndView mv= new ModelAndView();
        List<Course> list= courseService.findAllCourses();
        mv.addObject("courses",list);
        mv.setViewName("Home");
     return mv;
    }

    @RequestMapping(value ="/addNew",method= RequestMethod.GET)
    public ModelAndView addNewCourse(){
        ModelAndView allCourse= new ModelAndView();
        Course course=new Course();
        allCourse.addObject("course",course);
        allCourse.setViewName("courseForm");
        return allCourse;
    }
    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public ModelAndView saveCourse(@ModelAttribute("course") Course course){
        System.out.println(course.toString());

        courseService.saveOrUpdate(course);
        return new ModelAndView("redirect:/course/Home");
    }
    @RequestMapping(value = "/edit/{courseCode}", method = RequestMethod.GET)
    public ModelAndView updateCourse(@PathVariable("courseCode") String cCode){
        ModelAndView mv= new ModelAndView();
        Course course=courseService.findById(cCode);
        mv.addObject(course);
        mv.setViewName("courseForm");
        return mv;
    }
    @RequestMapping(value = "/remove/{courseCode}", method = RequestMethod.GET)
    public ModelAndView removeCourse(@PathVariable("courseCode")String couCode){
        courseService.deleteById(couCode);
        return new ModelAndView("redirect:/course/Home");
    }
}
