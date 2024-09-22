package com.example.myfirstproject.studentservice.repository

import com.example.myfirstproject.studentservice.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long>