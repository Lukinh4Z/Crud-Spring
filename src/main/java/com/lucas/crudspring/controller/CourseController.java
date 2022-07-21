package com.lucas.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.crudspring.model.Course;
import com.lucas.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {
    
    // @Autowired
    //esse "final" é uma boa prática,
    //fazemos isso pq sabemos que não precisaremos
    //mudar depois de instanciado.
    private final CourseRepository courseRepository;

    // public CourseController(CourseRepository courseRepository) {
    //     this.courseRepository = courseRepository;
    // }

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }


    
}
