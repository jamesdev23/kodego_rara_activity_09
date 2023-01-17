package ph.kodego.rara.jamesnico.kodegoraraactivity9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter.FragmentAdapter
import ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter.StudentAdapter
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.ActivityMainBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student
import ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager.ListFragment
import ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager.SearchFragment
import ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager.TransactionFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var studentAdapter: StudentAdapter
    private var students: ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        studentAdapter = StudentAdapter(students)
        binding.list.layoutManager = LinearLayoutManager(applicationContext)

        binding.list.adapter = studentAdapter

    }

    fun init(){
        students.add(Student("Dave", "Navor"))
        students.add(Student("James Nico", "Rara"))
        students.add(Student("Janreign", "Aragon"))
        students.add(Student("John Rey", "Balais"))
        students.add(Student("Joni", "James"))
        students.add(Student("Jp", "Soriano"))
        students.add(Student("Matthew", "Mottos"))
        students.add(Student("Rene", "Palma"))
        students.add(Student("Victor", "Yu"))
    }
}