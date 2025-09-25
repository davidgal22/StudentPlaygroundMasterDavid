package edu.iesam.student_playground_master_david.features.students.data.local

import edu.iesam.student_playground_master_david.features.students.domain.Student

class StudentMemLocalDataSource {

    private val dataSource: MutableMap<String, Student> = mutableMapOf()

    fun save(student: Student) {
        dataSource.put(student.exp, student)
    }

    fun fetch(): List<Student> {
        return dataSource.values.toList()
    }

    fun remove(exp: String) {
        dataSource.remove(exp)
    }

    fun update(student: Student) {
        dataSource.put(student.exp, student)
    }


}