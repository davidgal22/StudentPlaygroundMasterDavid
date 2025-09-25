package edu.iesam.student_playground_master_david.features.students.domain

interface StudentRepository {
    fun save(student: Student)

    fun fetch(): List<Student>

    fun remove(exp: String)

    fun update(student: Student)
}