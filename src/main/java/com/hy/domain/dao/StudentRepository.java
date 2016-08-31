package com.hy.domain.dao;

import com.hy.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by NeilHY on 2016/8/30.
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByPhoneNumber(Long phoneNumber);
}
