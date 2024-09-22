package com.example.myfirstproject.studentservice.service

import com.example.myfirstproject.studentservice.model.Institute
import com.example.myfirstproject.studentservice.repository.InstituteRepository
import org.springframework.stereotype.Service

@Service
class InstituteService(private val instituteRepository: InstituteRepository) {

    fun getAllInstitutes(): List<Institute> = instituteRepository.findAll()

    fun saveInstitute(institute: Institute): Institute = instituteRepository.save(institute)

    fun getInstituteById(id: Long): Institute? = instituteRepository.findById(id).orElse(null)

    fun deleteInstitute(id: Long) {
        instituteRepository.deleteById(id)
    }
}
