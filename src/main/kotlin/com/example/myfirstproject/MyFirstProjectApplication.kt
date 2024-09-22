package com.example.myfirstproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.myfirstproject"])
class MyFirstProjectApplication

fun main(args: Array<String>) {
    ageCheck(15)
    runApplication<MyFirstProjectApplication>(*args)
}
fun ageCheck(age: Int){
    val first_name: String = "Nimra"
    val last_name: String = "Naveed"

    if (age > 50) {
        println("You are eligible for a discount")
    }else if (age < 18){
        println("You are not eligible for a drivers license")
    }else if(age > 18){
        println("You are eligible for a paid drivers license")
    }
}
