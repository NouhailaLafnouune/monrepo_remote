package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.services.StudentServiceImpl;
import ma.pfe.services.StudentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {
    private final static Logger LOG = LoggerFactory.getLogger(StudentController.class);

    private StudentServices service;

    public StudentController(StudentServices service) {
        this.service = service;
    }

    @PostMapping("/save")
    public StudentDto save (@RequestBody StudentDto dto){
        LOG.debug(("Start methode name"));
        StudentDto resault = service.create(dto);
        LOG.debug("end methode name");
        return resault;
    }

    @PutMapping("/update")
    public StudentDto update(@RequestBody  StudentDto dto){
        LOG.debug(("Start methode name"));
        StudentDto resault = service.update(dto);
        LOG.debug("end methode name");
        return resault;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id){
        LOG.debug(("Start methode name"));
        boolean resault = service.delete(id);
        LOG.debug("end methode name");
        return resault;
    }

    @GetMapping
    public List<StudentDto> selectAll(){
        LOG.debug(("Start methode name"));
        List<StudentDto> resault = service.readAll();
        LOG.debug("end methode name");
        return resault;
    }
}
