package com.oguzhan.controller.impl;

import com.oguzhan.controller.IStudentController;
import com.oguzhan.dto.DtoStudent;
import com.oguzhan.dto.DtoStudentIU;
import com.oguzhan.entities.Student;
import com.oguzhan.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;
    // Burada DTO kullanılabilirdi Student tipinde parametre yerine
    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU student) {
        return studentService.saveStudent(student);
    }
    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") int id) {
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name = "id") int id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoStudent updateStudentbyId(@PathVariable(name = "id") int id,@RequestBody DtoStudentIU updatedStudent) {
        return studentService.updateStudentbyId(id, updatedStudent);
    }





}
