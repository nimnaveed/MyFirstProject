package com.example.myfirstproject.studentservice.service

import com.example.myfirstproject.studentservice.model.Student
import com.example.myfirstproject.studentservice.repository.StudentRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class StudentService(private val studentRepository: StudentRepository) {

    fun getAllStudents(): List<Student> = studentRepository.findAll()

    fun saveStudent(student: Student): Student = studentRepository.save(student)

    fun getStudentById(id: Long): Student? = studentRepository.findById(id).orElse(null)

    fun deleteStudent(id: Long) {
        studentRepository.deleteById(id)
    }

    fun updateStudentDateOfBirth(id: Long, dateOfBirth: LocalDate): Student? {
        val student = getStudentById(id)
        return if (student != null) {
            val updatedStudent = student.copy(dateOfBirth = dateOfBirth)
            saveStudent(updatedStudent)
            updatedStudent
        } else {
            null
        }
    }
}
