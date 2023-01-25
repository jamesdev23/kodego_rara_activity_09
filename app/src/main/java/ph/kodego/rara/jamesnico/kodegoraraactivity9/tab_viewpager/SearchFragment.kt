package ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter.StudentAdapter
import ph.kodego.rara.jamesnico.kodegoraraactivity9.dao.StudentDAO
import ph.kodego.rara.jamesnico.kodegoraraactivity9.dao.StudentDAOSQLImpl
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.FragmentSearchBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var studentAdapter: StudentAdapter
    private var students: ArrayList<Student> = ArrayList()
    private lateinit var dao: StudentDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studentAdapter = StudentAdapter(students)
        binding.list2.layoutManager = LinearLayoutManager(activity)
        binding.list2.adapter = studentAdapter

        binding.searchStudentButton.setOnClickListener{
            val searchTerm = binding.searchStudent.query.toString()

            dao = activity?.let { StudentDAOSQLImpl(it) }!!
            students = dao.searchStudent(searchTerm)
            studentAdapter.updateStudents(students)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}