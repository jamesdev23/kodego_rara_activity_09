package ph.kodego.rara.jamesnico.kodegoraraactivity9.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student

interface StudentDAO {
    fun addStudent(student: Student)
    fun getStudents() : ArrayList<Student>
}

class StudentDAOSQLImpl(var context: Context): StudentDAO{
    override fun addStudent(student: Student) {
        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.studentFirstName, student.firstName)
        contentValues.put(DatabaseHandler.studentLastName, student.lastName)
        contentValues.put(DatabaseHandler.studentImage, student.img)

        val success = db.insert(DatabaseHandler.tableStudents,null,contentValues)
        db.close()
    }

    override fun getStudents(): ArrayList<Student> {
        val studentList: ArrayList<Student> = ArrayList()

        val selectQuery = "SELECT ${DatabaseHandler.studentLastName}, " +
                "${DatabaseHandler.studentFirstName}, " +
                "${DatabaseHandler.studentId} " +
                "FROM ${DatabaseHandler.tableStudents}"

        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null

        try{
            cursor = db.rawQuery(selectQuery,null)
        } catch (e: SQLiteException) {
            db.close()
            return ArrayList()
        }

        var student = Student()
        if(cursor.moveToFirst()) {
            do {
                student = Student()
                student.id = cursor.getInt(2)
                student.lastName = cursor.getString(0)
                student.firstName = cursor.getString(1)

                studentList.add(student)
            }while(cursor.moveToNext())
        }

        db.close()
        return studentList
    }
}