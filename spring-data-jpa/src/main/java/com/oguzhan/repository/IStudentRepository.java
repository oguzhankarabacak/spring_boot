package com.oguzhan.repository;

import com.oguzhan.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {  //Student classı ve Student Classındaki id'nin tipi


    // HQL: sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır, nativeQuery = false
    // SQL: tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılır: nativeQuery = true
    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudent();

    @Query(value = "select * from student.student", nativeQuery = true)
    List<Student> findAllStudentSQL();

    @Query(value = "from Student s where s.id= :studentId", nativeQuery = false)
    Optional<Student> findStudentById(int studentId);
}
