package com.example.myfirstproject.studentservice.controller

import com.example.myfirstproject.studentservice.model.Institute
import com.example.myfirstproject.studentservice.service.InstituteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/institutes")
class InstituteController(private val instituteService: InstituteService) {

    @PostMapping
    fun createInstitute(@RequestBody institute: Institute): ResponseEntity<Institute> {
        val savedInstitute = instituteService.saveInstitute(institute)
        return ResponseEntity(savedInstitute, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllInstitutes(): ResponseEntity<List<Institute>> {
        return ResponseEntity(instituteService.getAllInstitutes(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getInstituteById(@PathVariable id: Long): ResponseEntity<Institute> {
        val institute = instituteService.getInstituteById(id)
        return if (institute != null) {
            ResponseEntity(institute, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/with-students")
    fun getInstitutesWithStudents(): ResponseEntity<List<Institute>> {
        val institutes = instituteService.getAllInstitutes() // Fetch all institutes
        return ResponseEntity(institutes, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteInstitute(@PathVariable id: Long): ResponseEntity<Void> {
        instituteService.deleteInstitute(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
