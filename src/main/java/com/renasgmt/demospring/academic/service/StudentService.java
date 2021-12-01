package com.renasgmt.demospring.academic.service;

import com.renasgmt.demospring.academic.model.Address;
import com.renasgmt.demospring.academic.model.Student;
import com.renasgmt.demospring.academic.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentByStudentId(String studentId){
        return studentRepository.findByStudentId(studentId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Student by Student ID %s", studentId)
        ));
    }

    public void addStudent(Student student){
        studentRepository.insert(student);
    }

    public void updateStudent(Student student){
        Student updateStudent = studentRepository.findByStudentId(student.getStudentId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find MStudent by Student ID %s", student.getStudentId())
                ));
        Address updateAddress = new Address();
        updateAddress.setStreet(student.getAddress().getStreet());
        updateAddress.setSubDistrict1(student.getAddress().getSubDistrict1());
        updateAddress.setSubDistrict2(student.getAddress().getSubDistrict2());
        updateAddress.setDistrict(student.getAddress().getDistrict());
        updateAddress.setProvince(student.getAddress().getProvince());
        updateAddress.setPostalCode(student.getAddress().getPostalCode());

        updateStudent.setName(student.getName());
        updateStudent.setAddress(updateAddress);
        updateStudent.setPlaceOfBirth(student.getPlaceOfBirth());
        updateStudent.setDateOfBirth(student.getDateOfBirth());
        updateStudent.setSex(student.getSex());
        updateStudent.setReligion(student.getReligion());
        updateStudent.setMajor(student.getMajor());
        updateStudent.setYear(student.getYear());

        studentRepository.save(updateStudent);
    }

    public void deleteStudent(String npm){
        Student updateStudent = studentRepository.findByStudentId(npm)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Student by Student ID %s", npm)
                ));
        studentRepository.deleteById(updateStudent.getId());
    }
}
