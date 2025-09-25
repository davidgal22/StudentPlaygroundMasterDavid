package edu.iesam.student_playground_master_david.features.students.domain

class RemoveStudentUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(exp: String) {
        studentRepository.remove(exp)
    }
}