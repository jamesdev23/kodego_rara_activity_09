package ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.NonDisposableHandle.parent
import ph.kodego.rara.jamesnico.kodegoraraactivity9.R
import ph.kodego.rara.jamesnico.kodegoraraactivity9.dao.StudentDAO
import ph.kodego.rara.jamesnico.kodegoraraactivity9.dao.StudentDAOSQLImpl
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.DialogueUpdateStudentBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.StudentItemBinding
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student
import ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager.ListFragment


class StudentAdapter(var students: ArrayList<Student>)
    : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    fun addStudent(student: Student){
        students.add(0,student)
        notifyItemInserted(0)
    }

    fun removeStudent(position: Int){
        students.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateStudents(newStudents: ArrayList<Student>){
        students.clear()
        students.addAll(newStudents)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentAdapter.StudentViewHolder {
        val itemBinding = StudentItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return StudentViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder,
                                  position: Int) {
        holder.bindStudent(students[position])
    }

    inner class StudentViewHolder(private val itemBinding: StudentItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        var student = Student()

        init{
            itemView.setOnClickListener(this)
        }

        fun bindStudent(student: Student) {
            this.student = student

            itemBinding.studentName.setText("${student.lastName}, ${student.firstName}")

            itemBinding.btnDeleteRow.setOnClickListener {
                Snackbar.make(itemBinding.root,
                    "Delete by button",
                    Snackbar.LENGTH_SHORT
                ).show()

                var dao: StudentDAO = StudentDAOSQLImpl(it.context)
                bindStudent(student)
                dao.deleteStudent(student.id)
                removeStudent(adapterPosition)
            }

            itemBinding.profilePicture.setImageResource(student.img)

//            itemBinding.studentName.setOnClickListener{
//                showCustomDialogue(it.context)
//            }

        }

        override fun onClick(v: View?) {
            Snackbar.make(itemBinding.root,
                "${student.lastName}, ${student.firstName}",
                Snackbar.LENGTH_SHORT
            ).show()

            // somehow hack-ish. temporary fix til I read docs again
            showCustomDialogue(v!!.context)
        }

        fun showCustomDialogue(context: Context) {
            context.let {
                val builder = AlertDialog.Builder(it)
                val dialogUpdateStudentBinding: DialogueUpdateStudentBinding =
                    DialogueUpdateStudentBinding.inflate(LayoutInflater.from(it))

                with(dialogUpdateStudentBinding) {
                    studentLastnameUpdate.setText(student.lastName)
                    studentFirstnameUpdate.setText(student.firstName)
                }

                with(builder) {
                    setPositiveButton("Update", DialogInterface.OnClickListener { _, _ ->
                        val dao: StudentDAO = StudentDAOSQLImpl(it)
                        val updateFirstName =
                            dialogUpdateStudentBinding.studentFirstnameUpdate.text.toString()
                        val updateLastName =
                            dialogUpdateStudentBinding.studentLastnameUpdate.text.toString()

                        student.firstName = updateFirstName
                        student.lastName = updateLastName

                        dao.updateStudent(student.id, student)
                        updateStudents(dao.getStudents())
                        notifyItemChanged(adapterPosition)
                    })
                    setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->
                        // Do something when user press the positive button
                    })
                        .setView(dialogUpdateStudentBinding.root)
                        .create()
                        .show()
                }
            }
        }
    }
}