package com.example.demoSpring.student

import jakarta.persistence.*
import java.time.LocalDate
import java.time.Period

@Entity
@Table
data class Student(
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    val id: Long = 0L,
    var name: String,
    val dob: LocalDate,
    var email: String
) {
    val age: Int
        get() = Period.between(dob, LocalDate.now()).years

    override fun toString(): String {
        return "Student(id=$id, name='$name', age=$age, dob=$dob, email='$email')"
    }
}