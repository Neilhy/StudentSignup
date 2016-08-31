package com.hy.service;

import com.hy.domain.Student;
import com.hy.domain.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NeilHY on 2016/8/31.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Long addStudent(Student student) {
        if (null == studentRepository.findByPhoneNumber(student.getPhoneNumber())) {
            return studentRepository.save(student).getPhoneNumber();
        }
        return null;
    }
}
