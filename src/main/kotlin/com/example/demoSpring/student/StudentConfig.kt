package com.example.demoSpring.student

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate

@Configuration
class StudentConfig {

    @Bean
    fun run(studentRepository: StudentRepository) = CommandLineRunner {
        val students = listOf(
            Student(name = "John Doe", dob = LocalDate.of(1999, 2, 2), email = "johndoe@example.com"),
            Student(name = "Jane Smith", dob = LocalDate.of(2001, 3, 24), email = "janesmith@example.com"),
            Student(name = "Mike Johnson", dob = LocalDate.of(2000, 5, 30), email = "mikeJohnson@example.com"),
            Student(name = "Emily Davis", dob = LocalDate.of(2002, 7, 12), email = "emilydavis@example.com"),
            Student(name = "Chris Brown", dob = LocalDate.of(2004, 9, 19), email = "chrisbrown@example.com")
        )
        studentRepository.saveAll(students)
    }

}