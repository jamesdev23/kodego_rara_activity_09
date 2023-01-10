package ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.StudentListBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student

class StudentAdapter (var students: ArrayList<Student>)
    : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentAdapter.StudentViewHolder {
        val itemBinding = StudentListBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return StudentViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder,
                                  position: Int) {
        holder.bindStudent(students[position])
    }

    inner class StudentViewHolder(private val itemBinding: StudentListBinding)
        : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        var student = Student()

        init{
            itemView.setOnClickListener(this)
        }

        fun bindStudent(student: Student) {
            this.student = student

            itemBinding.studentName.setText("${student.lastName}, ${student.firstName}")
        }

        override fun onClick(v: View?) {
            Snackbar.make(itemBinding.root,
                "${student.lastName}, ${student.firstName}",
                Snackbar.LENGTH_SHORT
            ).show()
        }


    }
}