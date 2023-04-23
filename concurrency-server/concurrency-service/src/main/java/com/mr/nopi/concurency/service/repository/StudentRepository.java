package com.mr.nopi.concurency.service.repository;

import com.mr.nopi.concurency.service.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
