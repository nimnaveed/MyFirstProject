package com.example.myfirstproject.studentservice.controller

import com.example.myfirstproject.studentservice.model.Student
import com.example.myfirstproject.studentservice.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/students")
class StudentController(private val studentService: StudentService) {

    @PostMapping
    fun createStudent(@RequestBody student: Student): ResponseEntity<Student> {
        val savedStudent = studentService.saveStudent(student)
        return ResponseEntity(savedStudent, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> {
        return ResponseEntity(studentService.getAllStudents(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) {
            ResponseEntity(student, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
        studentService.deleteStudent(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{id}/dateOfBirth")
    fun updateStudentDateOfBirth(@PathVariable id: Long, @RequestBody updatedStudent: Student): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) {
            val updated = student.copy(dateOfBirth = updatedStudent.dateOfBirth)
            studentService.saveStudent(updated)
            ResponseEntity(updated, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
