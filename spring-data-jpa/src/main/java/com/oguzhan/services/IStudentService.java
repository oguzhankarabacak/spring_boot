package com.oguzhan.services;

import com.oguzhan.dto.DtoStudent;
import com.oguzhan.dto.DtoStudentIU;
import com.oguzhan.entities.Student;
import com.oguzhan.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getAllStudent();
    public DtoStudent getStudentById(int id);
    public void deleteStudentById(int id);
    public DtoStudent updateStudentbyId(int id, DtoStudentIU updatedStudent);
}
