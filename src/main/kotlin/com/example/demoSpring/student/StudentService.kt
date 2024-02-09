package com.example.demoSpring.student

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService
@Autowired constructor(
    private val studentRepository: StudentRepository
) {

    fun getStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun addNewStudent(student: Student) {
        println("Start")
        val studentByEmail =
            studentRepository.findStudentByEmail(student.email)

        if (studentByEmail != null) {
            throw IllegalArgumentException("email taken")
        } else {
            studentRepository.save(student)
        }


    }

    fun deleteStudent(id: Long) {
        val studentExist = studentRepository.existsById(id)
        if (!studentExist) {
            throw IllegalArgumentException("Student with id: $id does not exist")
        } else {
            studentRepository.deleteById(id)
        }
    }

    @Transactional
    fun updateStudent(id: Long, name: String?, email: String?) {
        val student =
            studentRepository.findById(id)
                .orElseThrow { IllegalArgumentException("Student with id: $id does not exist") }

        if (!name.isNullOrBlank() && student.name != name) {
            student.name = name
        }

        if (!email.isNullOrBlank() && student.email != email) {
            if (studentRepository.findStudentByEmail(email) == null) {
                student.email = email
            }
        }
    }
}