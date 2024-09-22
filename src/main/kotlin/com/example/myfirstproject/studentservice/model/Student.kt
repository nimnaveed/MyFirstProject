package com.example.myfirstproject.studentservice.model

import jakarta.persistence.*

@Entity
@Table(name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val age: Int,

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = false)
    val institute: Institute
)
