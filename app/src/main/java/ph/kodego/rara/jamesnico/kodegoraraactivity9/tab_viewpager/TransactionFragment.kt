package ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter.StudentAdapter
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.FragmentTransactionBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student

class TransactionFragment : Fragment() {

    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!
    private lateinit var studentAdapter: StudentAdapter
    private var students: ArrayList<Student> = ArrayList()

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

        binding.addStudentButton.setOnClickListener {
//            studentAdapter.addStudent(Student(
//                binding.studentFirstname.text.toString(),
//                binding.studentLastname.text.toString()
//                )
//            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}