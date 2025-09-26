package edu.iesam.student_playground_master_david.features.students.domain

import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class SaveStudentUseCaseTest {

    /**
     * When ... Then ...
     */

    @Test
    fun `when invoke then save student`(){
        //Given
        val studentRepositoryMock = mockk<StudentRepository>(relaxed = true)
        val saveStudentUseCase = SaveStudentUseCase(studentRepositoryMock)
        val student = Student("001","jaime")

        //When
    saveStudentUseCase(student)

        //Then

        verify (exactly = 1) { studentRepositoryMock.save(student) }
    }


}