package com.hy.service;

import com.hy.domain.Student;

import java.util.List;

/**
 * Created by NeilHY on 2016/8/31.
 */
public interface StudentService {
    List<Student> getAllStudents();

    Long addStudent(Student student);
}
