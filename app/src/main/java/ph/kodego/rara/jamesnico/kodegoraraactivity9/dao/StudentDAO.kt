package ph.kodego.rara.jamesnico.kodegoraraactivity9.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import android.provider.ContactsContract.Data
import ph.kodego.rara.jamesnico.kodegoraraactivity9.R
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.Student
import ph.kodego.rara.jamesnico.kodegoraraactivity9.model.User

interface StudentDAO {
    fun addStudent(student: Student)
    fun getStudents() : ArrayList<Student>
    fun updateStudent(studentId: Int, student: Student)
    fun deleteStudent(studentId: Int)
    fun searchStudentByLastName(searchString: String) : ArrayList<Student>

    fun registerNewStudent(student: Student, user: User)
}

class StudentDAOSQLImpl(var context: Context): StudentDAO{
    override fun addStudent(student: Student) {
        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.studentFirstName, student.firstName)
        contentValues.put(DatabaseHandler.studentLastName, student.lastName)
        contentValues.put(DatabaseHandler.studentImage, R.drawable.placeholder)

        val success = db.insert(DatabaseHandler.tableStudents,null,contentValues)
        db.close()
    }

    override fun getStudents(): ArrayList<Student> {
        val studentList: ArrayList<Student> = ArrayList()

        val selectQuery = "SELECT ${DatabaseHandler.studentImage}, " +
                "${DatabaseHandler.studentLastName}, " +
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
                student.id = cursor.getInt(3)
                student.firstName = cursor.getString(2)
                student.lastName = cursor.getString(1)
                student.img = cursor.getInt(0)

                studentList.add(student)
            }while(cursor.moveToNext())
        }
        cursor?.close()
        db.close()
        return studentList
    }

    override fun updateStudent(studentId: Int, student: Student) {
        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.studentFirstName, student.firstName)
        contentValues.put(DatabaseHandler.studentLastName, student.lastName)

        val values = arrayOf("$studentId")
        val success = db.update(DatabaseHandler.tableStudents,
            contentValues,
            "${DatabaseHandler.studentId} = ?",
            values)
        db.close()
    }

    override fun deleteStudent(studentId: Int) {
        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val values = arrayOf("$studentId")
        val success = db.delete(DatabaseHandler.tableStudents,
            "${DatabaseHandler.studentId} = ?",
            values)
        db.close()
    }

    // search student. not available on sample app
    override fun searchStudentByLastName(searchString: String): ArrayList<Student> {
        val studentList: ArrayList<Student> = ArrayList()

        val columns = arrayOf(DatabaseHandler.studentFirstName,
            DatabaseHandler.studentLastName,
            DatabaseHandler.studentId,
            DatabaseHandler.studentImage,
            DatabaseHandler.yearstarted,
            DatabaseHandler.course
            )

        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase

        var cursor: Cursor? = null

        try{
            cursor = db.query(DatabaseHandler.tableStudents,
            columns,
                "${DatabaseHandler.studentLastName} like '%${searchString}'",
                null,
                null,
                null,
                DatabaseHandler.studentLastName
            )
        } catch (e: SQLiteException) {
            db.close()
            return ArrayList()
        }

        var student = Student()
        if(cursor.moveToFirst()) {
            do {
                student = Student()
                student.firstName = cursor.getString(0)
                student.lastName = cursor.getString(1)
                student.id = cursor.getInt(2)
                student.img = cursor.getInt(3)
                studentList.add(student)
            }while(cursor.moveToNext())
        }
        cursor?.close()
        db.close()
        return studentList
    }

    override fun registerNewStudent(student: Student, user: User) {
        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.studentFirstName, student.firstName)
        contentValues.put(DatabaseHandler.studentLastName, student.lastName)
        contentValues.put(DatabaseHandler.studentImage, R.drawable.placeholder)

        val contentValues2 = ContentValues()
        contentValues2.put(DatabaseHandler.userEmail, user.email)
        contentValues2.put(DatabaseHandler.userPassword, user.password)

        val success = db.insert(DatabaseHandler.tableStudents,null,contentValues)
        val success2 = db.insert(DatabaseHandler.tableUser,null,contentValues2)
        db.close()
    }
}