package com.oguzhan.controller;

import com.oguzhan.dto.DtoStudent;
import com.oguzhan.dto.DtoStudentIU;

import java.util.List;

public interface IStudentController {

    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getAllStudent();
    public DtoStudent getStudentById(int id);
    public void deleteStudentById(int id);
    public DtoStudent updateStudentbyId(int id, DtoStudentIU updatedStudent);

}
