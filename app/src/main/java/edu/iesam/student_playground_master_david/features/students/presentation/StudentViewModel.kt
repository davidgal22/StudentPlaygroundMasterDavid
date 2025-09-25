package edu.iesam.student_playground_master_david.features.students.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.student_playground_master_david.features.students.domain.FetchStudentUseCase
import edu.iesam.student_playground_master_david.features.students.domain.RemoveStudentUseCase
import edu.iesam.student_playground_master_david.features.students.domain.SaveStudentUseCase
import edu.iesam.student_playground_master_david.features.students.domain.Student
import edu.iesam.student_playground_master_david.features.students.domain.UpdateStudentUseCase

class StudentViewModel(
    private val saveStudentUseCase: SaveStudentUseCase,
    private val fetchStudentUseCase: FetchStudentUseCase,
    private val removeStudentUseCase: RemoveStudentUseCase,
    private val updateStudentUseCase: UpdateStudentUseCase
) : ViewModel() {
    fun saveClicked(exp: String, name: String) {
        saveStudentUseCase.invoke(Student(exp, name))
    }

    fun fetchClicked(): List<Student> {
        return fetchStudentUseCase.invoke()
    }

    fun removeClicked(exp: String) {
        removeStudentUseCase.invoke(exp)
    }

    fun updateClicked(exp: String, name: String) {
        updateStudentUseCase.invoke(Student(exp, name))
    }


}