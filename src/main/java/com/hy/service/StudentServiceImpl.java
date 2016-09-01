package com.hy.service;

import com.hy.domain.Student;
import com.hy.domain.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return studentRepository.findAll(new Sort(Sort.Direction.DESC,"signUpTime"));
    }

    @Override
    public void addStudent(Student student) {
//        if (null == studentRepository.findByPhoneNumber(student.getPhoneNumber())) {
            studentRepository.save(student);
//        }
//        return null;
    }
}
