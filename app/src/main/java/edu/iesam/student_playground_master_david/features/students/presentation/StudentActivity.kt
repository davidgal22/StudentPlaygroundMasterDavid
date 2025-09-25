package edu.iesam.student_playground_master_david.features.students.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.student_playground_master_david.R
import edu.iesam.student_playground_master_david.features.students.data.StudentDataRepository
import edu.iesam.student_playground_master_david.features.students.data.local.StudentDbLocalDataSource
import edu.iesam.student_playground_master_david.features.students.data.local.StudentMemLocalDataSource
import edu.iesam.student_playground_master_david.features.students.data.local.StudentXmlLocalDataSource
import edu.iesam.student_playground_master_david.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.student_playground_master_david.features.students.domain.FetchStudentUseCase
import edu.iesam.student_playground_master_david.features.students.domain.RemoveStudentUseCase
import edu.iesam.student_playground_master_david.features.students.domain.SaveStudentUseCase
import edu.iesam.student_playground_master_david.features.students.domain.Student
import edu.iesam.student_playground_master_david.features.students.domain.UpdateStudentUseCase
import edu.iesam.student_playground_master_david.features.students.presentation.StudentViewModel
import kotlin.math.exp

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initStudents()
    }

    fun initStudents() {
        val xml = StudentXmlLocalDataSource()
        val mem = StudentMemLocalDataSource()
        val api = StudentApiRemoteDataSource()
        val dataRepository = StudentDataRepository(xml, mem, api)

        val removeUseCase = RemoveStudentUseCase(dataRepository)
        val saveUseCase = SaveStudentUseCase(dataRepository)
        val fetchUseCase = FetchStudentUseCase(dataRepository)
        val updateUseCase = UpdateStudentUseCase(dataRepository)

        val viewModel = StudentViewModel(saveUseCase, fetchUseCase, removeUseCase, updateUseCase)
        viewModel.saveClicked("0001", "nombre1")
        viewModel.saveClicked("0002", "Marialo")
        viewModel.saveClicked("0003", "Pepe")
        viewModel.saveClicked("000r", "Pepito")

        val students = viewModel.fetchClicked()
        students.forEach { student ->
            Log.d("@dev", "Student: ${student.exp} - ${student.name}")
        }


        Log.d("@dev", "Student deleted : 0001")

        val students2 = viewModel.fetchClicked()
        students2.forEach { student2 ->
            Log.d("@dev", "Student: ${student2.exp} - ${student2.name}")
        }

        viewModel.updateClicked("0002", "Juan Carlos Pérez")
        Log.d("@dev", "Student updated: 0002")


        Log.d("@dev", "Stop")
    }
}
