package com.oguzhan.services.impl;

import com.oguzhan.dto.DtoStudent;
import com.oguzhan.dto.DtoStudentIU;
import com.oguzhan.entities.Student;
import com.oguzhan.repository.IStudentRepository;
import com.oguzhan.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(dtoStudentIU, student);

        Student savedStudent = studentRepository.save(student);
        BeanUtils.copyProperties(savedStudent, dtoStudent);
        return dtoStudent;
    }

    @Override
    public List<DtoStudent> getAllStudent() {
        List<Student> studentList = studentRepository.findAllStudentSQL();
        List<DtoStudent> dtoStudentList = new ArrayList<>();
        for (Student student: studentList){
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student,dto);
            dtoStudentList.add(dto);
        }
        return dtoStudentList;
    }

    @Override
    public DtoStudent getStudentById(int id) {
        Optional<Student> optional = studentRepository.findStudentById(id);
        if (optional.isPresent()) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(optional.get(), dtoStudent);
            return dtoStudent;
        }
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()){
            studentRepository.delete(optional.get());
        }
    }
    @Override
    public DtoStudent updateStudentbyId(int id, DtoStudentIU updatedStudent) {
        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            Student newStudent = optional.get();
            BeanUtils.copyProperties(updatedStudent, newStudent);
            Student responseStudent = studentRepository.save(newStudent);
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(responseStudent, dtoStudent);
            return dtoStudent;
        }
        return null;


    }
}
