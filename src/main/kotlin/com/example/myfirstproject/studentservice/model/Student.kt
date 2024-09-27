package com.example.myfirstproject.studentservice.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(name = "date_of_birth", nullable = false)
    val dateOfBirth: LocalDate,

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = true)
    @JsonIgnore // Prevent cyclic reference
    val institute: Institute
)
