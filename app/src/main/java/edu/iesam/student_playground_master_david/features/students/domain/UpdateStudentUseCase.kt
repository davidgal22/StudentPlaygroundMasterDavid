package edu.iesam.student_playground_master_david.features.students.domain

class UpdateStudentUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(student: Student) {
        studentRepository.update(student)
    }
}