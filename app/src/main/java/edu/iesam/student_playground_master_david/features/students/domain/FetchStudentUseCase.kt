package edu.iesam.student_playground_master_david.features.students.domain

class FetchStudentUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(): List<Student> {
        return studentRepository.fetch()
    }
}

