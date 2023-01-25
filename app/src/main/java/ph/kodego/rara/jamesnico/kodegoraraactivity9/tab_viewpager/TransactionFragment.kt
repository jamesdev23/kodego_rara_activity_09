package ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import ph.kodego.rara.jamesnico.kodegoraraactivity9.R
import ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter.StudentAdapter
import ph.kodego.rara.jamesnico.kodegoraraactivity9.dao.StudentDAO
import ph.kodego.rara.jamesnico.kodegoraraactivity9.dao.StudentDAOSQLImpl
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.FragmentTransactionBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student

class TransactionFragment : Fragment() {

    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!

    private lateinit var studentAdapter:StudentAdapter
    private var students: ArrayList<Student> = ArrayList()
    private lateinit var dao: StudentDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dao = activity?.let { StudentDAOSQLImpl(it) }!!
        students = dao.getStudents()

        studentAdapter = StudentAdapter(students)

        binding.addStudentButton.setOnClickListener {
            val student = Student()

            student.firstName = binding.studentFirstname.text.toString()
            student.lastName = binding.studentLastname.text.toString()

            dao.addStudent(student)
            students = dao.getStudents()
            studentAdapter.updateStudents(students)

            Snackbar.make(binding.root,
                "Added ${student.lastName}, ${student.firstName} to student list.",
                Snackbar.LENGTH_SHORT
            ).show()

        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}