package edu.iesam.student_playground_master_david.features.students.data


import edu.iesam.student_playground_master_david.features.students.data.local.StudentMemLocalDataSource
import edu.iesam.student_playground_master_david.features.students.data.local.StudentXmlLocalDataSource
import edu.iesam.student_playground_master_david.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.student_playground_master_david.features.students.domain.Student
import edu.iesam.student_playground_master_david.features.students.domain.StudentRepository

class StudentDataRepository(
    private val xmlLocalDataSource: StudentXmlLocalDataSource,
    private val memLocalDataSource: StudentMemLocalDataSource,
    private val apiRemoteDataSource: StudentApiRemoteDataSource,
) : StudentRepository {
    override fun save(student: Student) {
        memLocalDataSource.save(student)
    }

    override fun fetch(): List<Student> {
        return memLocalDataSource.fetch()
    }

    override fun remove(exp: String) {
        memLocalDataSource.remove(exp)
    }

    override fun update(student: Student) {
        memLocalDataSource.update(student)
    }


}


