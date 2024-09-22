package com.example.myfirstproject.studentservice.model

import jakarta.persistence.*

@Entity
@Table(name = "institutes")
data class Institute(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val city: String,

    @Column(nullable = false)
    val zipcode: Int,

    @Column(nullable = false)
    val state: String

)