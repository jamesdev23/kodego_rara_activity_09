package ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter.StudentAdapter
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.FragmentListBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var studentAdapter:StudentAdapter
    private var students: ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        init()

        studentAdapter = StudentAdapter(students)
        binding.list.layoutManager = LinearLayoutManager(activity)
        binding.list.adapter = studentAdapter

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    fun init(){
        students.add(Student("Janreign", "Aragon"))
        students.add(Student("John Rey", "Balais"))
        students.add(Student("Joni", "James"))
        students.add(Student("Matthew", "Mottos"))
        students.add(Student("Dave", "Navor"))
        students.add(Student("Rene", "Palma"))
        students.add(Student("James Nico", "Rara"))
        students.add(Student("Jp", "Soriano"))
        students.add(Student("Victor", "Yu"))
    }

}

