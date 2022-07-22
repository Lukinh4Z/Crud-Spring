package com.lucas.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public @ResponseBody List<Course> list() {
        return courseRepository.findAll();
    }

    @PostMapping
    // poderia usar tanto o ResponseStatus como está.
    // @ResponseStatus(code = HttpStatus.CREATED)
    //o @RequestBody vai fazer o mapeamento automatico
    //das informações recebidas para o model "Course"
    public ResponseEntity<Course> create(@RequestBody Course course) {
        // return courseRepository.save(course);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(courseRepository.save(course));
    }
    
}
