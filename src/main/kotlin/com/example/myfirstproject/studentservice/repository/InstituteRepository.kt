package com.example.myfirstproject.studentservice.repository

import com.example.myfirstproject.studentservice.model.Institute
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InstituteRepository : JpaRepository<Institute, Long>
